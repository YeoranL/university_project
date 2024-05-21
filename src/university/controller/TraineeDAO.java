package university.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import university.model.StudentVO;
import university.model.TraineeVO;

public class TraineeDAO {
	//수강신청 목록
	public void getTraineeList(String sdNum) {
		String sql = "select tr.no as no, tr.sd_num as sd_num, tr.l_abbre as l_abbre, le.l_name as l_name, sd.sd_name as sd_name, tr.t_section as t_section, t_date "
				+ "from trainee tr, student sd, lesson le "
				+ "where tr.sd_num = sd.sd_num "
				+ "and tr.l_abbre = le.l_abbre "
				+ "and tr.sd_num = ? "
				+ "order by t_date";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sdNum);
			rs = pstmt.executeQuery();
			
			System.out.println("일련번호\t학생번호\t\t과목약어\t과목명\t학생이름\t과목구분\t등록일자");
			
			while(rs.next()) {
				TraineeVO vo = new TraineeVO();
				vo.setNo(rs.getInt("no"));
				vo.setSdNum(rs.getString("sd_num"));
				vo.setlAbbre(rs.getString("l_abbre"));
				vo.settSection(rs.getString("t_section"));
				vo.settDate(rs.getString("t_date"));				
				
				System.out.println(vo.getNo()+"\t"+vo.getSdNum()+"\t"+vo.getlAbbre()+"\t"+rs.getString("l_name")+"\t"+rs.getString("sd_name")+"\t"+vo.gettSection()+"\t"+vo.gettDate());
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
	
	//수강신청 등록
	public void setTraineeRegister(TraineeVO vo) {
		String sql = "insert into trainee values(trainee_seq.nextval,?,?,?,sysdate)";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSdNum());
			pstmt.setString(2, vo.getlAbbre());
			pstmt.setString(3, vo.gettSection());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println("수강 신청 성공.");
			} else {
				System.out.println("수강 신청 실패.");
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("이미 존재합니다.");
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
	
	//수강신청 취소
	public void setTraineeDelete(int no) {
		String sql = "delete from trainee where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println("수강 신청 취소 성공.");
			} else {
				System.out.println("수강 신청 취소 실패.");
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
