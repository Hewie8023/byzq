package com.byzq.entity;

/**
 * 
 * <p>Title: Singer</p>
 * <p>Description: </p>
 * <p>Company:公主队 </p> 
 * @author Hewie
 * @date 2015-7-4下午4:35:40
 */
public class Singer {

	private int singerID;
	private String singername;
	private String singertype;
	private String region;
	private String photoUrl;
	public Singer() {
	}
	
	
	public Singer(String singername, String singertype, String region,
			String photoUrl) {
		super();
		this.singername = singername;
		this.singertype = singertype;
		this.region = region;
		this.photoUrl = photoUrl;
	}

	public Singer(int singerID, String singername, String singertype,
			String region, String photoUrl) {
		this.singerID = singerID;
		this.singername = singername;
		this.singertype = singertype;
		this.region = region;
		this.photoUrl = photoUrl;
	}
	public int getSingerID() {
		return singerID;
	}
	public void setSingerID(int singerID) {
		this.singerID = singerID;
	}
	public String getSingername() {
		return singername;
	}
	public void setSingername(String singername) {
		this.singername = singername;
	}
	public String getSingertype() {
		return singertype;
	}
	public void setSingertype(String singertype) {
		this.singertype = singertype;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	@Override
	public String toString() {
		return "Singer [singerID=" + singerID + ", singername=" + singername
				+ ", singertype=" + singertype + ", region=" + region
				+ ", photoUrl=" + photoUrl + "]";
	}
	
}
