package com.byzq.entity;

/**
 * 
 * <p>Title: ListRelation</p>
 * <p>Description: </p>
 * <p>Company:������ </p> 
 * @author Hewie
 * @date 2015-7-4����4:51:48
 */
public class ListRelation {

	private int musicID;
	private int listID;
	public ListRelation() {
		super();
	}
	
	public ListRelation(int musicID, int listID) {
		super();
		this.musicID = musicID;
		this.listID = listID;
	}

	public int getMusicID() {
		return musicID;
	}
	public void setMusicID(int musicID) {
		this.musicID = musicID;
	}
	public int getListID() {
		return listID;
	}
	public void setListID(int listID) {
		this.listID = listID;
	}
	@Override
	public String toString() {
		return "ListRelation [musicID=" + musicID + ", listID=" + listID + "]";
	}
	
}
