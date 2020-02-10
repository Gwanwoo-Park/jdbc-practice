package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.BookVo;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDao {

	public BookVo find(Long no) {
		return null;
	}
	
	public Boolean update(BookVo vo) {
		return false;
	}
	
	public boolean insertOrderBook(OrderVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into order_book values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getCount());
			
			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;

	}
	
	
	public boolean insert(OrderVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into orders values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrderNo());
			pstmt.setString(2, vo.getPrice());
			pstmt.setString(3, vo.getPlace());
			pstmt.setLong(4, vo.getMemberNo());

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;

	}

	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<OrderVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

//			select o.order_no, m.name, o.price, o.place" + 
//			 "  from orders o," + 
//			 "	   member m" + 
//			 " where m.no = o.member_no
			
			String sql = "select *" + 
						 "  from (select o.order_no, m.name, o.price, o.place" + 
						 "		    from orders o," + 
						 "			     member m" + 
						 "		   where m.no = o.member_no) a," + 
						 "	     (select b.no, b.title, ob.count" + 
						 "		    from order_book ob," + 
						 "			     book b" + 
						 "		   where ob.book_no = b.no) b";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String orderNo = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				String place = rs.getString(4);
				
				Long no = rs.getLong(5);
				String title = rs.getString(6);
				Long count = rs.getLong(7);

				OrderVo vo = new OrderVo();
				vo.setOrderNo(orderNo);
				vo.setName(name);
				vo.setPrice(price);
				vo.setPlace(place);
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setCount(count);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url, "bookshop", "bookshop");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}
}