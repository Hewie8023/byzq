package com.byzq.service;

import java.util.List;

import com.byzq.dao.SingerDao;
import com.byzq.entity.Singer;

public class SingerService {

	/**
	 * 
	 * ��ѯ���и��ֵ���Ϣ  
	 * @author Hewie 
	 * @version 1.0, 2015-7-5 ����12:47:47   
	 * @return
	 */
	public List queryAllSinger(){
		SingerDao sd = new SingerDao();
		List list = sd.queryAllSinger();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+"***");
		}
		return list;
	}
	
	/**
	 * 
	 * ��Ӹ�����Ϣ  
	 * @author Hewie 
	 * @version 1.0, 2015-7-6 ����3:37:56   
	 * @return
	 * @throws Exception 
	 */
	public boolean addSinger(Singer singer){
		SingerDao sd = new SingerDao();
		int sdID;
		boolean flag = true;
		try {
			sdID = sd.addSinger(singer);
			if(1==sdID){
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
	 * ɾ��������Ϣ
	 *   
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 ����9:13:37   
	 * @return
	 */
	public boolean deleteSinger(String name){
		SingerDao sd = new SingerDao();
		int sdID;
		boolean flag = true;
		try {
			sdID = sd.deleteSinger(name);
			if(1==sdID){
				System.out.println("hahahahaha"+sdID);
			}else{
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(flag+"asdasd");
		return flag;
	}
	
	/**
	 * 
	 * ���¸�����Ϣ
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 ����10:16:05   
	 * @return
	 */
//	public boolean modifySinger(String name){
//		SingerDao sd = new SingerDao();
//		int sdID;
//		boolean flag = true;
//		sdID = sd.updateSinger(singer)
//	}
	
	/**
	 * 
	 * ͨ��id��ѯ������Ϣ  
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 ����7:52:03   
	 * @return
	 */
	public Singer querySingerByID(int id){
		SingerDao sd = new SingerDao();
		Singer singer = sd.querySingerByID(id);
		return singer;
	}
	
	
	/**
	 * 
	 * ��ԃ������Ϣͨ�^���� 
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 ����12:44:44   
	 * @return
	 */
	public Singer querySingerByName(String name){
		SingerDao sd = new SingerDao();
		Singer singer = sd.querySingerByName(name);
		return singer;
	}
	
	
}
