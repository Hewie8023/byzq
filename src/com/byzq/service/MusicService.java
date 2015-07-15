package com.byzq.service;

import java.util.List;

import com.byzq.dao.MusicDao;
import com.byzq.entity.Music;

public class MusicService {

	/**
	 * 
	 * ��ѯ���еĸ�����Ϣ 
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 ����7:04:24   
	 * @return
	 */
	public List queryAllMusic(){
		MusicDao ms = new MusicDao();
		List list = ms.queryAllMusic();
		return list;
	}
	
	/**
	 * 
	 * ��Ӹ�����Ϣ
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 ����11:26:17   
	 * @return
	 */
	public boolean insertMusic(Music music){
		MusicDao md = new MusicDao();
		boolean flag = true;
		try {
			int mdID = md.addMusic(music);
			if(1==mdID){
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
	 * �h������
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 ����2:31:48   
	 * @return
	 */
	public boolean deleteMusic(String name){
		MusicDao md = new MusicDao();
		boolean flag = true;
		try {
			int mdID = md.deleteMusic(name);
			if(1==mdID){
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
	 * ͨ�^��Ͳ��Ҹ���
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 ����6:42:51   
	 * @return
	 */
	public List queryMusicByStyle(String style){
		MusicDao md = new MusicDao();
		List list = md.queryMusicByStyle(style);
		return list;
	}
	
	/**
	 * 
	 * ��������ֶν����������music    
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 ����10:43:22   
	 * @return
	 */
	public List queryMusicByClickDesc(){
		MusicDao ms = new MusicDao();
		List list = ms.queryMusicByClickDesc();
		return list;
	}
	
	/**
	 * 
	 * ���չؼ��ֽ���ģ������ 
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 ����11:14:56   
	 * @return
	 */
	public List queryMusicByKey(String key){
		MusicDao ms = new MusicDao();
		List list = ms.queryMusicByKey(key);
		return list;
	}
	
	public Music queryMusicBySingerID(int id){
		MusicDao md = new MusicDao();
		Music music = md.queryMusicBySingerID(id);
		return music;
	}
}
