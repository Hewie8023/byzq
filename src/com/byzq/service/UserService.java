package com.byzq.service;

import java.util.List;

import com.byzq.dao.UserDao;
import com.byzq.entity.User;

public class UserService {

	/**
	 * 
	 * 获取用户信息  
	 * @author Hewie 
	 * @version 1.0, 2015-7-5 上午9:19:24   
	 * @return
	 */
	public User queryUser(String name){
		UserDao ud = new UserDao();
		User u = ud.queryUserByName(name);
		return u;
	}
	
	/**
	 * 
	 * 读取全部的用户信息 
	 * @author Hewie 
	 * @version 1.0, 2015-7-5 下午12:11:59   
	 * @return
	 */
	public List queryAllUser(){
		UserDao ud = new UserDao();
		List list = ud.queryAllUser();
		return list;
	}
	
	/**
	 * 
	 * 添加用户
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 上午11:53:29   
	 * @return
	 */
	public boolean addUser(User user){
		UserDao ud = new UserDao();
		boolean flag = true;
		try {
			int udID = ud.addUser(user);
			if(1==udID){
				System.out.println(udID+"hewie");
			}else{
				flag = false;
				System.out.println(udID+"hewie");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 
	 * 更新  
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 上午11:54:05   
	 * @return
	 */
	public boolean modifyUser(User user){
		UserDao ud = new UserDao();
		boolean flag = true;
		try {
			int udID = ud.updateUser(user);
			if(1==udID){
			}else{
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 
	 * 查询用户通过性别  
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 下午6:09:49   
	 * @return
	 */
	public List queryUserBySex(String sex){
		UserDao ud = new UserDao();
		List list = ud.queryUserBySex(sex);
		return list;
	}
	

	/**
	 * 
	 * 查询用户通过关键字  
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 下午6:10:49   
	 * @return
	 */
	public List queryUserBykey(String key){
		UserDao ud = new UserDao();
		List list = ud.queryUserByKey(key);
		return list;
	}
	
	/**
	 * 
	 * 通过性别和关键字查找 
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 下午6:15:39   
	 * @return
	 */
	public List queryUserBykeyAndsex(String sex,String key){
		UserDao ud = new UserDao();
		List list = ud.queryUserBykeyAndsex(key, sex);
		return list;
	}
	
	/**
	 * 
	 * 刪除用戶  
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 上午1:26:47   
	 * @return
	 */
	public boolean deleteUserByName(String name){
		UserDao ud = new UserDao();
		int udID;
		boolean flag = true;
		try {
			udID = ud.deleteUserByName(name);
			if(1==udID){
			}else{
				flag = false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
