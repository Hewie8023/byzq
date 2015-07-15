package com.byzq.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.byzq.entity.Music;
import com.byzq.entity.Singer;
import com.byzq.entity.User;
import com.byzq.service.MusicService;
import com.byzq.service.SingerService;
import com.byzq.service.UserService;
import com.byzq.util.DateUtil;

/**
 * This class is used for ...
 * 
 * @author Hewie
 * @version 1.0, 2015-7-6 ����2:01:24
 */
public class ManagerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// Ӧ��ʽ
		res.setContentType("text/html;charset=utf-8");
		// ����
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String s = req.getParameter("type");
		System.out.println(s + "112233");

		if ("addsinger".equals(s)) {
			System.out.println("11");
			try {
				insertSinger(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("22");
		} else if (req.getParameter("deletesinger") != null
				&& !(req.getParameter("deletesinger").equals(""))) {
			// System.out.println("hewie");
			deleteSinger(req, res);
		} else if (req.getParameter("modifysinger") != null
				&& !(req.getParameter("modifysinger")).equals("")) {
			modifySinger(req, res);
		} else if ("modifyuserinfo".equals(s)) {
			try {
				modifyUser(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("searchuser".equals(s)) {
			searchUser(req, res);
		} else if ("addmusic".equals(s)) {
			try {
				insertMusic(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("deleteuser".equals(s)) {
			deleteUser(req, res);
		} else if ("deletemusic".equals(s)) {
			deleteMusic(req, res);
		} else if("playmusic".equals(s)){
			palyMusic(req,res);
		}
	}

	/**   
	 * This class is used for ...   
	 * @author Hewie
	 * @version   1.0, 2015-7-8 ����2:41:26   
	 */   
	private void palyMusic(HttpServletRequest req, HttpServletResponse res) {
		String url = req.getParameter("palyurl");
		try {
			res.sendRedirect("/byzq/bosombuddymanager/play.jsp?url="+url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This class is used for ...
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-8 ����2:28:32
	 */
	private void deleteMusic(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("DeleteMusic");
		MusicService ms = new MusicService();
		try {
			if (ms.deleteMusic(name)) {
				res.sendRedirect("/byzq/bosombuddymanager/music.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This class is used for ...
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-8 ����1:23:52
	 */
	private void deleteUser(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("DeleteUser");
		UserService us = new UserService();
		try {
			if (us.deleteUserByName(name)) {
				System.out.println(name + "mahua");
				res.sendRedirect("/byzq/bosombuddymanager/user.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This class is used for ...
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-7 ����10:32:37
	 * @throws UnsupportedEncodingException
	 */
	private void insertMusic(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		try {
			items = fileUpload.parseRequest(req);

		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		SingerService ss = new SingerService();
		MusicService ms = new MusicService();
		Iterator<FileItem> itr = items.iterator();
		Music music = new Music();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			if (item.isFormField()) {
				String fieldName = item.getFieldName();
				if ("musicname".equals(fieldName)) {
					music.setMusicname(item.getString("utf-8"));
				}
				if ("singername".equals(fieldName)) {
					Singer singer = ss.querySingerByName(item
							.getString("utf-8"));
					System.out.println(item.getString("utf-8") + "(---)"
							+ singer + "hahahaha");
					music.setSingerID(singer.getSingerID());
				}
				if ("clicknum".equals(fieldName)) {
					music.setMusicclickNum(Integer.parseInt(item
							.getString("utf-8")));
				}
				if ("downnum".equals(fieldName)) {
					music.setMusicdownloadNum(Integer.parseInt(item
							.getString("utf-8")));
				}
				if ("style".equals(fieldName)) {
					music.setStyle(item.getString("utf-8"));
				}
			} else if (!"".equals(item.getName())) {
				String fieldName = item.getFieldName();
				if ("albumcover".equals(fieldName)) {
					String imgName = DateUtil.getCurrentTime();
					music.setAlbumcover("albumcover/" + imgName + "."
							+ item.getName().split("\\.")[1]);
					String albumPath = "C:\\Hewie\\byzq\\WebRoot\\bosombuddymanager\\albumcover\\"
							+ imgName + "." + item.getName().split("\\.")[1];
					item.write(new File(albumPath));
				}
				if ("musicfile".equals(fieldName)) {
					String imgName = DateUtil.getCurrentTime();
					music.setMusicpath("audio/" + imgName + "."
							+ item.getName().split("\\.")[1]);
					String musicPath = "C:\\Hewie\\byzq\\WebRoot\\bosombuddymanager\\audio\\"
							+ imgName + "." + item.getName().split("\\.")[1];
					item.write(new File(musicPath));
				}
			}
		}
		if (ms.insertMusic(music)) {
			res.sendRedirect("/byzq/bosombuddymanager/music.jsp");
		} else {
			res.sendRedirect("/byzq/bosombuddymanager/music.jsp");
		}

	}

	/**
	 * This class is used for ...
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-7 ����4:21:56
	 */
	private void searchUser(HttpServletRequest req, HttpServletResponse res) {

		String sexop = req.getParameter("search-sort");
		String sex = null;
		if (sexop.equals("1")) {
			sex = "��";
		} else if (sexop.equals("2")) {
			sex = "Ů";
		} else {
			sex = null;
		}
		String keyword = req.getParameter("keywords");
		UserService us = new UserService();
		List list = null;
		try {
			if (keyword.equals("") || keyword == null) {
				if (sex != null && !sex.equals("")) {
					System.out.println(sex + "!@@@@!");
					list = us.queryUserBySex(sex);
				} else {
					list = us.queryAllUser();
				}
				req.getSession().setAttribute("userlist", list);
				// req.getRequestDispatcher("bosombuddymanager/user.jsp?type=search").forward(req,
				// res);
				res.sendRedirect("/byzq/bosombuddymanager/user.jsp?type=search");
			} else {
				if (sex != null && !sex.equals("")) {
					System.out.println(sex + "!@@@@!");
					list = us.queryUserBykeyAndsex(sex, keyword);
				} else {
					list = us.queryUserBykey(keyword);
				}

				req.getSession().setAttribute("userlist", list);
				// req.getRequestDispatcher("bosombuddymanager/user.jsp?type=search").forward(req,
				// res);
				res.sendRedirect("/byzq/bosombuddymanager/user.jsp?type=search");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This class is used for ...
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-7 ����11:29:35
	 * @throws Exception
	 */
	private void modifyUser(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		UserService us = new UserService();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		try {
			items = fileUpload.parseRequest(req);

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator<FileItem> itr = items.iterator();
		User user = new User();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			if (item.isFormField()) {
				String fieldName = item.getFieldName();
				if ("username".equals(fieldName)) {
					user.setName(item.getString("utf-8"));
				}
				if ("sex".equals(fieldName)) {
					user.setSex(item.getString("utf-8"));
				}
				if ("password".equals(fieldName)) {
					user.setPassword(item.getString("utf-8"));
				}
				if ("preference".equals(fieldName)) {
					user.setPreference(item.getString("utf-8"));
				}
				if ("email".equals(fieldName)) {
					user.setMail(item.getString("utf-8"));
				}
			} else if (!"".equals(item.getName())) {
				String imgName = DateUtil.getCurrentTime();
				user.setAvatarUrl("avatar/" + imgName + "."
						+ item.getName().split("\\.")[1]);
				String imagePath = "C:\\Hewie\\byzq\\WebRoot\\bosombuddymanager\\avatar\\"
						+ imgName + "." + item.getName().split("\\.")[1];
				item.write(new File(imagePath));
			}
		}

		if (us.modifyUser(user)) {
			res.sendRedirect("/byzq/bosombuddymanager/user.jsp");
		}

		// User u = (User) req.getAttribute("user");
		// String name = req.getParameter("username");
		// String password = u.getPassword();
		// String sexop = (String) req.getParameter("sex");
		// String sex = null;
		// if (sexop.equals("��")) {
		// sex = "��";
		// } else {
		// sex = "Ů";
		// }
		// String preferenceop = req.getParameter("preference");
		// String preference = null;
		// if (preferenceop.equals("1")) {
		// preference = "ҡ��";
		// } else if (preferenceop.equals("2")) {
		// preference = "����";
		// } else if (preferenceop.equals("3")) {
		// preference = "����";
		// } else if (preferenceop.equals("4")) {
		// preference = "������";
		// } else if (preferenceop.equals("5")) {
		// preference = "����";
		// }
		// String email = req.getParameter("email");
		// String photoUrl = u.getAvatarUrl();
		//
		// User user = new User(name, sex, password, preference, email,
		// photoUrl);
		// System.out.println(user+"!@!@");
		// try {
		// if (us.modifyUser(user)) {
		// res.sendRedirect("/byzq/bosombuddymanager/user.jsp");
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * This class is used for ...
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-7 ����10:13:08
	 */
	private void modifySinger(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("modifysinger");
		System.out.println(name + "flag");
		SingerService ss = new SingerService();

	}

	/**
	 * This class is used for ...
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-7 ����9:03:08
	 */
	private void deleteSinger(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("deletesinger");
		SingerService ss = new SingerService();
		MusicService ms = new MusicService();
		try {
			if (ss.deleteSinger(name)) {
				System.out.println(name + "mahua");
				res.sendRedirect("/byzq/bosombuddymanager/singer.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * This class is used for ...
	 * 
	 * @author Hewie
	 * @version 1.0, 2015-7-6 ����3:05:55
	 * @return
	 * @throws Exception
	 */
	private void insertSinger(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		try {
			items = fileUpload.parseRequest(req);

		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		Iterator<FileItem> itr = items.iterator();
		Singer singer = new Singer();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			if (item.isFormField()) {
				String fieldName = item.getFieldName();
				if ("singername".equals(fieldName)) {
					singer.setSingername(item.getString("utf-8"));
				}
				if ("region".equals(fieldName)) {
					singer.setRegion(item.getString("utf-8"));
				}
				if ("style".equals(fieldName)) {
					singer.setSingertype(item.getString("utf-8"));
				}
			} else if (!"".equals(item.getName())) {
				String imgName = DateUtil.getCurrentTime();
				singer.setPhotoUrl("avatar/" + imgName + "."
						+ item.getName().split("\\.")[1]);
				String imagePath = "C:\\Hewie\\byzq\\WebRoot\\bosombuddymanager\\avatar\\"
						+ imgName + "." + item.getName().split("\\.")[1];
				item.write(new File(imagePath));
			}
		}

		SingerService ss = new SingerService();

		if (ss.addSinger(singer)) {
			res.sendRedirect("/byzq/bosombuddymanager/singer.jsp");
		}

		// String singername = req.getParameter("singername");
		// System.out.println(singername+"123");
		// String regionop = req.getParameter("region");
		// String region = null;
		// if (regionop.equals("1")) {
		// region = "����";
		// } else if (regionop.equals("2")) {
		// region = "�պ�";
		// } else if (regionop.equals("3")) {
		// region = "ŷ��";
		// } else if (regionop.equals("4")) {
		// region = "����";
		// }
		// String styleop = req.getParameter("style");
		// String style = null;
		// if (styleop.equals("19")) {
		// style = "�и���";
		// } else if (styleop.equals("20")) {
		// style = "Ů����";
		// } else if (styleop.equals("21")) {
		// style = "���";
		// }
		// String photopath = req.getParameter("photofile");
		//
		// System.out.println(singername+"@"+region+"@"+style+"@"+photopath);
		// SingerService ss = new SingerService();
		// Singer singer = new Singer(singername, style, region, "images/"
		// + photopath);
		//
		// try {
		// if (ss.addSinger(singer)) {
		// res.sendRedirect("/byzq/bosombuddymanager/singer.jsp");
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
}
