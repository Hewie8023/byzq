package com.byzq.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzq.service.MusicService;

public class MusicServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 应答方式
		res.setContentType("text/html;charset=gbk");
		// 编码
		res.setCharacterEncoding("gbk");
		req.setCharacterEncoding("gbk");
//		
//		String style = req.getParameter("type");
//		
//		System.out.println(style+"hewie*()");
//		
//		MusicService ms = new MusicService();
//		List list  = new ArrayList();
//		
//		if(style.equals("all")){
//			list = ms.queryAllMusic();
//		}else {
//			list = ms.queryMusicByStyle(style);
//		}
//		
//		req.getSession().setAttribute("listmusic", list);
//		res.sendRedirect("/byzq/index.jsp?type=musicstyle");
		
		String s = req.getParameter("type");
		
		if("searchmusic".equals(s)){
			try {
				searchMusic(req,res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("style".equals(s)){
			try {
				searchMusicByStyle(req,res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**   
	 * This class is used for ...   
	 * @author Hewie
	 * @version   1.0, 2015-7-9 上午12:06:10   
	 * @throws Exception 
	 */   
	private void searchMusicByStyle(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		String style = req.getParameter("musicstyle");
		
		System.out.println(style+"#@#");
		
		MusicService ms = new MusicService();
		List list  = ms.queryMusicByStyle(style);
		
		req.getSession().setAttribute("musiclistbystyle", list);
		res.sendRedirect("/byzq/bosombuddy/music.jsp?type=searchmusicbystyle");
		
	}

	/**   
	 * This class is used for ...   
	 * @author Hewie
	 * @version   1.0, 2015-7-8 下午11:04:49   
	 * @throws Exception 
	 */   
	private void searchMusic(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String key = req.getParameter("searchmusic");
		MusicService ms = new MusicService();
		List list = ms.queryMusicByKey(key);
		
		req.getSession().setAttribute("musiclistbykey", list);
		res.sendRedirect("/byzq/bosombuddy/music.jsp?type=searchmusic");
		
	}
	
}
