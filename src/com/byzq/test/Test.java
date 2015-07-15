package com.byzq.test;

import java.util.List;

import com.byzq.service.MusicService;

public class Test {

	public static void main(String[] args) {
		MusicService ms = new MusicService();
		List list = ms.queryMusicByKey("as");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+"!!!!!!!!!");
		}
	}
	
}
