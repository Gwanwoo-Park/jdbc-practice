package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
//		insert("IT");
//		insert("소설");
//		insert("인문");

		findAllTest();
	}

	public static void insert(String title) {
		CategoryVo vo = new CategoryVo();
		vo.setTitle(title);

		new CategoryDao().insert(vo);

	}

	public static void findAllTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}

}