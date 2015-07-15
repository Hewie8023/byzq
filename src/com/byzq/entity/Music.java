package com.byzq.entity;

/**
 * 
 * <p>Title: Music</p>
 * <p>Description: </p>
 * <p>Company:公主队 </p> 
 * @author Hewie
 * @date 2015-7-4下午4:44:37
 */
public class Music {

	private int musicID;
	private String musicname;
	private int singerID;
	private int musicclickNum;
	private int musicdownloadNum;
	private String style;
	private String musictime;
	private String albumcover;
	private String musicpath;
	
	public Music() {
	}

	public Music(int musicID, String musicname, int singerID,
			int musicclickNum, int musicdownloadNum, String style,
			String musictime, String albumcover, String musicpath) {
		this.musicID = musicID;
		this.musicname = musicname;
		this.singerID = singerID;
		this.musicclickNum = musicclickNum;
		this.musicdownloadNum = musicdownloadNum;
		this.style = style;
		this.musictime = musictime;
		this.albumcover = albumcover;
		this.musicpath = musicpath;
	}

	public int getMusicID() {
		return musicID;
	}

	public void setMusicID(int musicID) {
		this.musicID = musicID;
	}

	public String getMusicname() {
		return musicname;
	}

	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}

	public int getSingerID() {
		return singerID;
	}

	public void setSingerID(int singerID) {
		this.singerID = singerID;
	}

	public int getMusicclickNum() {
		return musicclickNum;
	}

	public void setMusicclickNum(int musicclickNum) {
		this.musicclickNum = musicclickNum;
	}

	public int getMusicdownloadNum() {
		return musicdownloadNum;
	}

	public void setMusicdownloadNum(int musicdownloadNum) {
		this.musicdownloadNum = musicdownloadNum;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getMusictime() {
		return musictime;
	}

	public void setMusictime(String musictime) {
		this.musictime = musictime;
	}

	public String getAlbumcover() {
		return albumcover;
	}

	public void setAlbumcover(String albumcover) {
		this.albumcover = albumcover;
	}

	public String getMusicpath() {
		return musicpath;
	}

	public void setMusicpath(String musicpath) {
		this.musicpath = musicpath;
	}

	@Override
	public String toString() {
		return "Music [musicID=" + musicID + ", musicname=" + musicname
				+ ", singerID=" + singerID + ", musicclickNum=" + musicclickNum
				+ ", musicdownloadNum=" + musicdownloadNum + ", style=" + style
				+ ", musictime=" + musictime + ", albumcover=" + albumcover
				+ ", musicpath=" + musicpath + "]";
	}
}
