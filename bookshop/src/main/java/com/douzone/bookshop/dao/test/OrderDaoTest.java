package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
//		insert("20200202-00001", "17000", "서울", 1L);
//		insertOrderBook(1L, 3L, 8L);

		findAllTest();
	}

	public static void insert(String orderNo, String price, String place, Long memberNo) {
		OrderVo vo = new OrderVo();
		vo.setOrderNo(orderNo);
		vo.setPrice(price);
		vo.setPlace(place);
		vo.setMemberNo(memberNo);

		new OrderDao().insert(vo);
	}
	
	public static void insertOrderBook(Long no, Long bookNo, Long count) {
		OrderVo vo = new OrderVo();
		vo.setNo(no);
		vo.setBookNo(bookNo);
		vo.setCount(count);

		new OrderDao().insertOrderBook(vo);
	}

	public static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}

}