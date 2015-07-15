package com.byzq.entity;

/**
 * 
 * <p>Title: User类</p>
 * <p>Description: </p>
 * <p>Company:公主队 </p> 
 * @author Hewie
 * @date 2015-7-4下午4:29:29
 */
public class User {

	private int userID;
	private String name;
	private String sex;
	private String password;
	private String preference;
	private String mail;
	private String avatarUrl;
	public User() {
	}
	
	public User(String name, String password, String mail) {
		super();
		this.name = name;
		this.password = password;
		this.mail = mail;
	}

	public User(String name, String sex, String password, String preference,
			String mail, String avatarUrl) {
		super();
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.preference = preference;
		this.mail = mail;
		this.avatarUrl = avatarUrl;
	}

	public User(int userID, String name, String sex, String password,
			String preference, String mail, String avatarUrl) {
		this.userID = userID;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.preference = preference;
		this.mail = mail;
		this.avatarUrl = avatarUrl;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", sex=" + sex
				+ ", password=" + password + ", preference=" + preference
				+ ", mail=" + mail + ", avatarUrl=" + avatarUrl + "]";
	}
}
