package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insert("이것은 자바다", "30000", 1L);
//		insert("해리포터", "20000", 2L);
//		insert("팩트풀니스", "40000", 3L);

		findAllTest();
	}

	public static void insert(String title, String price, Long categoryNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategoryNo(categoryNo);

		new BookDao().insert(vo);

	}

	public static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

}