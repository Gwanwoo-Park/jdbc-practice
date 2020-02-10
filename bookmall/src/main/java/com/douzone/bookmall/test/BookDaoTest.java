package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insert("트와일라잇", 1L);
//		insert("뉴문", 1L);
//		insert("이클립스", 1L);
//		insert("브레이킹던", 1L);
//		insert("아리랑", 5L);
//		insert("젊은그들", 2L);
//		insert("아프니깐 청춘이다", 3L);
//		insert("귀천", 4L);
//		insert("태백산맥", 5L);
//		insert("풀하우스", 6L);

		findAllTest();
	}

	public static void insert(String title, Long authorNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setAuthorNo(authorNo);

		new BookDao().insert(vo);
	}

	public static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

}