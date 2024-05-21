package university.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import university.model.SubjectVO;

public class SubjectDAO {
	
	//학과 목록
	public void getSubjectList() {
		String sql = "select * from subject order by no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("일련번호\t학과번호\t학과명");
			
			while(rs.next()) {
				SubjectVO subjectVo = new SubjectVO();
				subjectVo.setNo(rs.getInt("no"));
				subjectVo.setsNum(rs.getString("s_num"));
				subjectVo.setsName(rs.getString("s_name"));
				
				System.out.println(subjectVo.getNo()+"\t"+subjectVo.getsNum()+"\t"+subjectVo.getsName());
			}			
		} catch (SQLException e) {
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
	
	//학과 등록
	public void setSubjectRegister(SubjectVO vo) {
		String sql = "insert into subject values(subject_seq.nextval,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;		
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getsNum());
			pstmt.setString(2, vo.getsName());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println(vo.getsName() + ": 학과 등록 완료.");
			} else {
				System.out.println("학과 등록 실패.");
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("이미 존재하는 학과 번호입니다.");
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
	
	//학과 수정
	public void setSubjectUpdate(SubjectVO vo) {
		String sql = "update subject set s_num = ?, s_name = ? where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getsNum());
			pstmt.setString(2, vo.getsName());
			pstmt.setInt(3, vo.getNo());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println(vo.getsName() + ": 학과 수정 완료.");
			} else {
				System.out.println("학과 수정 실패.");
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
	
	//학과 삭제
	public void setSubjectDelete(SubjectVO vo) {
		String sql = "delete from subject where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println("학과 삭제 완료.");
			} else {
				System.out.println("학과 삭제 실패.");
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
