package university.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import university.model.LessonVO;

public class LessonDAO {
	//과목 목록
	public void getLessonList() {
		String sql = "select * from lesson order by no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("일련번호\t과목약어\t과목명");
			
			while(rs.next()) {
				LessonVO vo = new LessonVO();
				vo.setNo(rs.getInt("no"));
				vo.setlAbbre(rs.getString("l_abbre"));
				vo.setlName(rs.getString("l_name"));
				
				System.out.println(vo.getNo()+"\t"+vo.getlAbbre()+"\t"+vo.getlName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//과목 등록
	public void setLessonRegister(LessonVO vo) {
		String sql = "insert into lesson values(lesson_seq.nextval,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getlAbbre());
			pstmt.setString(2, vo.getlName());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println(vo.getlName() + ": 과목 등록 완료.");
			} else {
				System.out.println("과목 등록 실패.");
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("이미 존재하는 과목 약어입니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//과목 수정
	public void setLessonUpdate(LessonVO vo) {
		String sql = "update lesson set l_abbre = ?, l_name = ? where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getlAbbre());
			pstmt.setString(2, vo.getlName());
			pstmt.setInt(3, vo.getNo());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println(vo.getlName() + ": 과목 수정 완료.");
			} else {
				System.out.println("과목 수정 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//과목 삭제
	public void setLessonDelete(LessonVO vo) {
		String sql = "delete from lesson where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println("과목 삭제 완료.");
			} else {
				System.out.println("과목 삭제 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
