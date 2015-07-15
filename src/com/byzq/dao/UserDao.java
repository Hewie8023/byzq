package com.byzq.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.byzq.entity.User;
import com.byzq.util.DbUtil;
import com.byzq.util.StringUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class UserDao {

	/**
	 * 
	 * ����û���Ϣ
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 ����8:47:47
	 * @return
	 */
	public int addUser(User user) throws Exception {
		String sql = "insert into users values(null,?,?,?,?,?,?)";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getSex());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getPreference());
		ps.setString(5, user.getMail());
		ps.setString(6, user.getAvatarUrl());
		return ps.executeUpdate();
	}

	/**
	 * ��ȡ�û�ͨ������
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 ����7:26:41
	 * @return
	 */
	public User queryUserByName(String name) {
		String sql = "select Name,Sex,Password,Preference,Mail,Avatar from users where Name='"
				+ name + "'";
		Connection con = DbUtil.getConnection();
		User u = new User();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = (Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery(sql);
			if (rs.next()) {
				u.setName(rs.getString("Name"));
				u.setPassword(rs.getString("Password"));
				u.setSex(rs.getString("Sex"));
				u.setPreference(rs.getString("Preference"));
				u.setMail(rs.getString("Mail"));
				u.setAvatarUrl(rs.getString("Avatar"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con, rs, st);
		}

		return u;
	}

	/**
	 * 
	 * ��ȡȫ�����û���Ϣ
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 ����7:28:26
	 * @return
	 */
	public List queryAllUser() {
		Connection con = DbUtil.getConnection();
		String sql = "select Name,Sex,Password,Preference,Mail,Avatar from users";
		List list = new ArrayList();
		User u = null;
		ResultSet rs = null;
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			while(rs.next()){
				u = new User();
				u.setName(rs.getString("Name"));
				u.setPassword(rs.getString("Password"));
				u.setSex(rs.getString("Sex"));
				u.setPreference(rs.getString("Preference"));
				u.setMail(rs.getString("Mail"));
				u.setAvatarUrl(rs.getString("Avatar"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.closeCon(con, rs, null);
		}
		return list;
	}

	/**
	 * 
	 * ɾ���û�
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 ����7:30:03
	 * @return
	 * @throws Exception 
	 */
	public int deleteUserByName(String name) throws Exception {
		String sql = "delete from users where Name = ?";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, name);
		return ps.executeUpdate();
	}

	/**
	 * 
	 * �����û�
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 ����7:32:11
	 * @return
	 */
	public int updateUser(User user) throws Exception{
		String sql = "update users set Sex=?,Password=?,Preference=?,Mail=?,Avatar=? where Name=?";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, user.getSex());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPreference());
			ps.setString(4, user.getMail());
			ps.setString(5, user.getAvatarUrl());
			ps.setString(6, user.getName());
			return ps.executeUpdate();
	}
	
	/**
	 * 
	 *	ͨ���Ա�����û�
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 ����4:10:37   
	 * @return
	 */
	public List queryUserBySex(String sex){
		String sql = "select Name,Sex,Password,Preference,Mail,Avatar from users where Sex='"
				+ sex + "'";
		Connection con = DbUtil.getConnection();
		User u = null;
		Statement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			st = (Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {
				u = new User();
				u.setName(rs.getString("Name"));
				u.setPassword(rs.getString("Password"));
				u.setSex(rs.getString("Sex"));
				u.setPreference(rs.getString("Preference"));
				u.setMail(rs.getString("Mail"));
				u.setAvatarUrl(rs.getString("Avatar"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con, rs, st);
		}

		return list;
	}
	
	/**
	 * 
	 * ͨ���ؼ��ֲ���  
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 ����5:27:25   
	 * @return
	 */
	public List queryUserByKey(String key){
		StringBuffer sb = new StringBuffer("select Name,Sex,Password,Preference,Mail,Avatar from users");
		if(StringUtil.isNotEmpty(key)){
			sb.append(" and Name like '%"+key+"%'");
		}
		String sql = sb.toString().replaceFirst("and", "where");
		Connection con = DbUtil.getConnection();
		User u = null;
		Statement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			st = (Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {
				u = new User();
				u.setName(rs.getString("Name"));
				u.setPassword(rs.getString("Password"));
				u.setSex(rs.getString("Sex"));
				u.setPreference(rs.getString("Preference"));
				u.setMail(rs.getString("Mail"));
				u.setAvatarUrl(rs.getString("Avatar"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con, rs, st);
		}

		return list;
	}
	
	/**
	 * 
	 * 
  	 * ͨ���Ա�͹ؼ��ֲ���
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 ����6:18:05   
	 * @return
	 */
	public List queryUserBykeyAndsex(String key,String sex){
		StringBuffer sb = new StringBuffer("select Name,Sex,Password,Preference,Mail,Avatar from users");
		if(StringUtil.isNotEmpty(key)){
			sb.append(" and Name like '%"+key+"%' and Sex='"+sex+"'");
		}
		String sql = sb.toString().replaceFirst("and", "where");
		Connection con = DbUtil.getConnection();
		User u = null;
		Statement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			st = (Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery(sql);
			while(rs.next()) {
				u = new User();
				u.setName(rs.getString("Name"));
				u.setPassword(rs.getString("Password"));
				u.setSex(rs.getString("Sex"));
				u.setPreference(rs.getString("Preference"));
				u.setMail(rs.getString("Mail"));
				u.setAvatarUrl(rs.getString("Avatar"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con, rs, st);
		}

		return list;
	}

}
