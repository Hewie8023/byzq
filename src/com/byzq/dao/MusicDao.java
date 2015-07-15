package com.byzq.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.byzq.entity.Music;
import com.byzq.util.DateUtil;
import com.byzq.util.DbUtil;
import com.byzq.util.StringUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class MusicDao {

	/**
	 * 
	 * 添加歌曲信息 
	 * @author Hewie 
	 * @version 1.0, 2015-7-4 下午8:43:43   
	 * @return
	 */
	public int addMusic(Music music) throws Exception{
		String sql = "insert into music values(null,?,?,?,?,?,?,?,now())";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, music.getMusicname());
		ps.setInt(2, music.getSingerID());
		ps.setInt(3, music.getMusicclickNum());
		ps.setInt(4, music.getMusicdownloadNum());
		ps.setString(5, music.getStyle());
		ps.setString(6, music.getAlbumcover());
		ps.setString(7, music.getMusicpath());
		return ps.executeUpdate();
	}
	
	/**
	 * 
	 * 查询歌曲信息   
	 * @author Hewie 
	 * @version 1.0, 2015-7-4 下午8:20:46   
	 * @return
	 */
	public Music queryMusicByName(String musicname){
		String sql = "select MusicName,SingerID,MusicClick,MusicDownload,Style,MusicTime,AlbumCover,Musicpath where MusicName='"+musicname+"'";
		Connection con = DbUtil.getConnection();
		ResultSet rs = null;
		Music music = null;
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			if(rs.next()){
				music = new Music();
				music.setMusicname(rs.getString("MusicName"));
				music.setSingerID(rs.getInt("SingerID"));
				music.setMusicclickNum(rs.getInt("MusicClick"));
				music.setMusicdownloadNum(rs.getInt("MusicDownload"));
				music.setStyle(rs.getString("Style"));
				music.setMusictime(DateUtil.DatetoString(rs.getDate("MusicTime")));
				music.setAlbumcover(rs.getString("AlbumCover"));
				music.setMusicpath(rs.getString("MusicPath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeCon(con, rs, null);
		}
		return music;
	}
	
	/**
	 * 
	 * 查询所有的歌曲
	 * @author Hewie 
	 * @version 1.0, 2015-7-4 下午8:21:40   
	 * @return
	 */
	public List queryAllMusic(){
		String sql = "select MusicName,SingerID,MusicClick,MusicDownload,Style,MusicTime,AlbumCover,MusicPath from music";
		Connection con = DbUtil.getConnection();
		ResultSet rs = null;
		List list = new ArrayList();
		Music music = null;
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			while(rs.next()){
				music = new Music();
				music.setMusicname(rs.getString("MusicName"));
				music.setSingerID(rs.getInt("SingerID"));
				music.setMusicclickNum(rs.getInt("MusicClick"));
				music.setMusicdownloadNum(rs.getInt("MusicDownload"));
				music.setStyle(rs.getString("Style"));
				music.setMusictime(DateUtil.DatetoString(rs.getDate("MusicTime")));
				music.setAlbumcover(rs.getString("AlbumCover"));
				music.setMusicpath(rs.getString("MusicPath"));
				list.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.closeCon(con, rs, null);
		}
		return list;
	}
	
	/**
	 * 
	 * 删除歌曲  
	 * @author Hewie 
	 * @version 1.0, 2015-7-4 下午8:26:43   
	 * @return
	 * @throws SQLException 
	 */
	public int deleteMusic(String musicname) throws Exception{
		String sql = "delete from music where MusicName='"+musicname+"'";
		Connection con = DbUtil.getConnection();
		return con.createStatement().executeUpdate(sql);
	}
	
	/**
	 * 
	 * 更新歌曲信息 
	 * @author Hewie 
	 * @version 1.0, 2015-7-4 下午8:29:27   
	 * @return
	 * @throws SQLException 
	 */
	public int updateMusic(Music music) throws SQLException{
		String sql = "update music set MusicName=?,SingerID=?,MusicClick=?,MusicDownload=?,Style=?,MusicTime=now(),AlbumCover=?,MusicPath=?";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, music.getMusicname());
		ps.setInt(2, music.getSingerID());
		ps.setInt(3, music.getMusicclickNum());
		ps.setInt(4, music.getMusicdownloadNum());
		ps.setString(5, music.getStyle());
		ps.setString(6, music.getAlbumcover());
		ps.setString(7, music.getMusicpath());
		return ps.executeUpdate();
	}
	
	/**
	 * 
	 * 通過類型獲取歌曲列表  
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 上午4:53:02   
	 * @return
	 */
	public List queryMusicByStyle(String style){
		String sql = "select * from music where Style='"+style+"'";
		Connection con = DbUtil.getConnection();
		ResultSet rs = null;
		List list = new ArrayList();
		Music music = null;
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			while(rs.next()){
				music = new Music();
				music.setMusicID(rs.getInt("MusicID"));
				music.setMusicname(rs.getString("MusicName"));
				music.setSingerID(rs.getInt("SingerID"));
				music.setMusicclickNum(rs.getInt("MusicClick"));
				music.setMusicdownloadNum(rs.getInt("MusicDownload"));
				music.setStyle(rs.getString("Style"));
				music.setAlbumcover(rs.getString("AlbumCover"));
				music.setMusicpath(rs.getString("MusicPath"));
				music.setMusictime(DateUtil.DatetoString(rs.getDate("MusicTime")));
				list.add(music);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * 通过歌手ID来查找歌曲
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 下午8:05:42   
	 * @return
	 */
	public Music queryMusicBySingerID(int id){
		String sql = "select * from music where SingerID="+id;
		Connection con = DbUtil.getConnection();
		Music music = null;
		ResultSet rs = null;
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			if(rs.next()){
				music.setMusicID(rs.getInt("MusicID"));
				music.setMusicname(rs.getString("MusicName"));
				music.setSingerID(rs.getInt("SingerID"));
				music.setMusicclickNum(rs.getInt("MusicClick"));
				music.setMusicdownloadNum(rs.getInt("MusicDownLoad"));
				music.setStyle(rs.getString("Style"));
				music.setAlbumcover(rs.getString("AlbumCover"));
				music.setMusicpath(rs.getString("MusicPath"));
				music.setMusictime(DateUtil.DatetoString(rs.getDate("MusicTime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.closeCon(con, rs, null);
		}
		return music;
	}
	
	/**
	 * 
	 * 按点击量字段降序排序输出music   
	 * @author Hewie 
	 * @version 1.0, 2015-7-8 下午10:41:46   
	 * @return
	 */
	public List queryMusicByClickDesc(){
		String sql = "select * from music order by MusicClick desc";
		Connection con  =DbUtil.getConnection();
		ResultSet rs = null;
		List list = new ArrayList();
		Music music = null;
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			while(rs.next()){
				music = new Music();
				music.setMusicID(rs.getInt("MusicID"));
				music.setMusicname(rs.getString("MusicName"));
				music.setSingerID(rs.getInt("SingerID"));
				music.setMusicclickNum(rs.getInt("MusicClick"));
				music.setMusicdownloadNum(rs.getInt("MusicDownLoad"));
				music.setStyle(rs.getString("Style"));
				music.setAlbumcover(rs.getString("AlbumCover"));
				music.setMusicpath(rs.getString("MusicPath"));
				music.setMusictime(DateUtil.DatetoString(rs.getDate("MusicTime")));
				list.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List queryMusicByKey(String key){
		StringBuffer sb = new StringBuffer("select * from music");
		if(StringUtil.isNotEmpty(key)){
			sb.append(" and MusicName like '%"+key+"%'");
		}
		String sql = sb.toString().replaceFirst("and", "where");
		Connection con = DbUtil.getConnection();
		Music music = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			rs = (ResultSet) con.createStatement().executeQuery(sql);
			while(rs.next()){
				music = new Music();
				music.setMusicID(rs.getInt("MusicID"));
				music.setMusicname(rs.getString("MusicName"));
				music.setSingerID(rs.getInt("SingerID"));
				music.setMusicclickNum(rs.getInt("MusicClick"));
				music.setMusicdownloadNum(rs.getInt("MusicDownLoad"));
				music.setStyle(rs.getString("Style"));
				music.setAlbumcover(rs.getString("AlbumCover"));
				music.setMusicpath(rs.getString("MusicPath"));
				music.setMusictime(DateUtil.DatetoString(rs.getDate("MusicTime")));
				list.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
