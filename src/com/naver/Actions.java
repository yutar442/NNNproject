package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class Actions {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";
	private final String PASSWORD = "ca2";

	public Actions() {
		try {
			Class.forName(DRIVERNAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
    public void Pwupdate(BoxInfo box) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update box set pw = ? where boxnum = ?";
        
        try {
          conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(2, box.getBoxnum());
          pstmt.setInt(1, box.getPw());
          
          
          pstmt.executeUpdate();
          
          
       } catch (Exception e) {
          e.printStackTrace();
       }finally {
          try {
             if(pstmt != null) {
                pstmt.close();
             }
             
             if(conn != null) {
                conn.close();
             }
             
          } catch (Exception e2) {
             e2.printStackTrace();
          }
       }
     }
    
	public void BoxUpdate(String id, String item1, String item2, String item3) { // 박스 내용물 업데이트
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE box SET item1 = ?, item2 = ? , item3 = ? WHERE id = ?";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(4, id);
			pstmt.setString(1, item1);
			pstmt.setString(2, item2);
			pstmt.setString(3, item3);

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public List<BoxInfo> itemSelect(String id, int password, int boxnum) {
		List<BoxInfo> list = new ArrayList<BoxInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;
		if(boxnum == 0) {
		sql = "select person.id,box.boxnum,box.item1,box.item2,box.item3,box.pw from person inner join box on person.id=box.id WHERE person.id = ? AND box.pw = ?";
		} else {
		sql = "select person.id,box.boxnum,box.item1,box.item2,box.item3,box.pw from person inner join box on person.id=box.id WHERE person.id = ? AND box.pw = ? AND box.boxnum = ?";
		}
		
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false); // 트랜젝션
			conn.commit(); // 트랜젝션
			try {

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, password);
				if(boxnum != 0) pstmt.setInt(3, boxnum);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String nid = rs.getString("id");
					boxnum = rs.getInt(2);
					String item1 = rs.getString("item1");
					String item2 = rs.getString("item2");
					String item3 = rs.getString("item3");

					list.add(new BoxInfo(boxnum, nid, item1, item2, item3, 0));
				}
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("-------트랜젝션-------");
				conn.rollback();

			}
		} catch (Exception e) {
			e.printStackTrace();
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

	public List<PersonInfo> selectAll() { // 회원목록 로드
		List<PersonInfo> list = new ArrayList<PersonInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from person";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int ph = rs.getInt(3);

				list.add(new PersonInfo(id, name, ph));
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

	public List<BoxInfo> boxSelectAll() { // 물품보관함 조회
		List<BoxInfo> list = new ArrayList<BoxInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from box";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false); // 트랜젝션
			conn.commit(); // 트랜젝션
			try {

				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int boxnum = rs.getInt(1);
					String id = rs.getString("id");
					String item1 = rs.getString("item1");
					String item2 = rs.getString("item2");
					String item3 = rs.getString("item3");
					int pw = rs.getInt(6);

					list.add(new BoxInfo(boxnum, id, item1, item2, item3, pw));
				}
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("-------트랜젝션-------");
				conn.rollback();

			}
		} catch (Exception e) {
			e.printStackTrace();
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

	public void insert(PersonInfo ps) { // 회원 가입
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into person (id, name, ph) values (?,?,?)";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);
			conn.commit();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, ps.getName());
			pstmt.setInt(3, ps.getPh());
			try {
				pstmt.setString(1, ps.getId());
				pstmt.executeUpdate();

			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("이미 가입된 ID입니다.");
				conn.rollback();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
