package com.byzq.service;

import java.util.List;

import com.byzq.dao.MusicDao;
import com.byzq.entity.Music;

public class MusicService {

	/**
	 * 
	 * 查询所有的歌曲信息 
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 下午7:04:24   
	 * @return
	 */
	public List queryAllMusic(){
		MusicDao ms = new MusicDao();
		List list = ms.queryAllMusic();
		return list;
	}
	
	/**
	 * 
	 * 添加歌曲信息
	 * @author Hewie 
	 * @version 1.0, 2015-7-7 下午11:26:17   
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
	 * 刪除歌曲
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 上午2:31:48   
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
	 * 通過類型查找歌曲
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 上午6:42:51   
	 * @return
	 */
	public List queryMusicByStyle(String style){
		MusicDao md = new MusicDao();
		List list = md.queryMusicByStyle(style);
		return list;
	}
	
	/**
	 * 
	 * 按点击量字段降序排序输出music    
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 下午10:43:22   
	 * @return
	 */
	public List queryMusicByClickDesc(){
		MusicDao ms = new MusicDao();
		List list = ms.queryMusicByClickDesc();
		return list;
	}
	
	/**
	 * 
	 * 按照关键字进行模糊搜索 
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 下午11:14:56   
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
