package com.byzq.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.byzq.entity.Singer;
import com.byzq.util.DbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class SingerDao {

	/**
	 * 
	 * 添加歌手信息
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 下午8:49:31
	 * @return
	 */
	public int addSinger(Singer singer) throws Exception {
		String sql = "insert into singer values(null,?,?,?,?)";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, singer.getSingername());
		ps.setString(2, singer.getSingertype());
		ps.setString(3, singer.getRegion());
		ps.setString(4, singer.getPhotoUrl());
		return ps.executeUpdate();
	}

	/**
	 * 
	 * 通过名字查询歌手信息
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 下午7:42:26
	 * @return
	 */
	public Singer querySingerByName(String singername) {
		String sql = "select SingerID, SingerName,SingerType,Region,Photo from singer where SingerName='"
				+ singername + "'";
		Connection con = DbUtil.getConnection();
		ResultSet rs = null;
		Singer singer = null;
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			if (rs.next()) {
				singer = new Singer();
				singer.setSingerID(rs.getInt("SingerID"));
				singer.setSingername(rs.getString("SingerName"));
				singer.setSingertype(rs.getString("SingerType"));
				singer.setRegion(rs.getString("Region"));
				singer.setPhotoUrl(rs.getString("Photo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con, rs, null);
		}
		return singer;
	}

	/**
	 * 
	 * 通过ID查找歌手信息
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-5 下午12:25:59
	 * @return
	 */
	public Singer querySingerByID(int id) {
		String sql = "select SingerName,SingerType,Region,Photo from singer where SingerID="+id;
		Connection con = DbUtil.getConnection();
		Singer singer = null;
		ResultSet rs = null;
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			if (rs.next()) {
				singer = new Singer();
				singer.setSingername(rs.getString("SingerName"));
				singer.setSingertype(rs.getString("SingerType"));
				singer.setRegion(rs.getString("Region"));
				singer.setPhotoUrl(rs.getString("photo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return singer;
	}

	/**
	 * 
	 * 查询所有的歌手信息
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 下午7:47:33
	 * @return
	 */
	public List queryAllSinger() {
		String sql = "select SingerID,SingerName,SingerType,Region,Photo from singer";
		Connection con = DbUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		Singer singer = null;
		try {
			st = (Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery(sql);

			while (rs.next()) {
				singer = new Singer();
				singer.setSingerID(Integer.parseInt(rs.getString("SingerID")));
				singer.setSingername(rs.getString("SingerName"));
				singer.setSingertype(rs.getString("SingerType"));
				singer.setRegion(rs.getString("Region"));
				singer.setPhotoUrl(rs.getString("Photo"));
				list.add(singer);
				// System.out.println(singer+"%^^^%");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con, rs, st);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "!!!!!!!!");
		}

		return list;
	}

	/**
	 * 
	 * 删除歌手信息
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 下午7:48:49
	 * @return
	 */
	public int deleteSinger(String singername) throws Exception {
		String sql = "delete from singer where SingerName=?";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, singername);
		return ps.executeUpdate();
	}

	/**
	 * 
	 * 更新歌手信息
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-4 下午7:59:44
	 * @return
	 * @throws Exception 
	 */
	public int updateSinger(Singer singer) throws Exception {
		String sql = "update singer set SingerName=?,SingerType=?,Region=?,Photo=? where SingerName=?";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, singer.getSingername());
		ps.setString(2, singer.getSingertype());
		ps.setString(3, singer.getRegion());
		ps.setString(4, singer.getPhotoUrl());
		return ps.executeUpdate();
	}
	
//	public List querySingerBy

}
