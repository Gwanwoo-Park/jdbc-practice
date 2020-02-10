package com.douzone.bookshop.dao.test;

public class ResultTest {
	public static void main(String[] args) {
		// category 테이블 칼럼 insert
		CategoryDaoTest.insert("IT");
		CategoryDaoTest.insert("소설");
		CategoryDaoTest.insert("인문");
		
		// book 테이블 칼럼 insert
		BookDaoTest.insert("이것은 자바다", "30000", 1L);
		BookDaoTest.insert("해리포터", "20000", 2L);
		BookDaoTest.insert("팩트풀니스", "40000", 3L);
		
		// member 테이블 칼럼 insert
		MemberDaoTest.insert("박관우", "01046269470", "pgw9470@naver.com", "관우_password");
		MemberDaoTest.insert("홍길동", "01023451245", "홍길동@gmail.com", "길동_password");
		
		// cart 테이블 칼럼 insert
		CartDaoTest.insert(1L, 1L, 3L);
		CartDaoTest.insert(2L, 2L, 2L);
		
		// orders 테이블 칼럼 insert
		OrderDaoTest.insert("20200202-00001", "17000", "서울", 1L);
		// order_book 테이블 칼럼 insert
		OrderDaoTest.insertOrderBook(1L, 1L, 5L);
		OrderDaoTest.insertOrderBook(1L, 2L, 7L);

		
		// 1. 회원 리스트 - 2개
		MemberDaoTest.findAllTest();
		System.out.println();
		
		// 2. 카테고리 리스트 - 3개
		CategoryDaoTest.findAllTest();
		System.out.println();
		
		// 3. 상품 리스트 - 3개
		BookDaoTest.findAllTest();
		System.out.println();
		
		// 4. 카트 리스트 - 2개
		CartDaoTest.findAllTest();
		System.out.println();
		
		// 5-1. 주문 리스트 - 1개
		// 5-2. 주문 도서 리스트 - 2개     
		OrderDaoTest.findAllTest();
		System.out.println();
	}
}