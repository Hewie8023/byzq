package com.byzq.entity;

/**
 * 
 * <p>Title: MusicList</p>
 * <p>Description: </p>
 * <p>Company:������ </p> 
 * @author Hewie
 * @date 2015-7-4����4:50:29
 */
public class MusicList {

	private int listID;
	private int userID;
	private String listname;
	public MusicList() {
	}
	public MusicList(int listID, int userID, String listname) {
		super();
		this.listID = listID;
		this.userID = userID;
		this.listname = listname;
	}
	public int getListID() {
		return listID;
	}
	public void setListID(int listID) {
		this.listID = listID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getListname() {
		return listname;
	}
	public void setListname(String listname) {
		this.listname = listname;
	}
	@Override
	public String toString() {
		return "MusicList [listID=" + listID + ", userID=" + userID
				+ ", listname=" + listname + "]";
	}
}
