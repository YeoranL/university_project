package university.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import university.model.StudentVO;

public class StudentDAO {
	//학생 등록
	public void setStudentRegister(StudentVO vo) {
		String sql = "insert into student values(student_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSdNum());
			pstmt.setString(2, vo.getSdName());
			pstmt.setString(3, vo.getSdId());
			pstmt.setString(4, vo.getSdPassword());
			pstmt.setString(5, vo.getsNum());
			pstmt.setString(6, vo.getSdBirthday());
			pstmt.setString(7, vo.getSdPhone());
			pstmt.setString(8, vo.getSdAddress());
			pstmt.setString(9, vo.getSdEmail());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println(vo.getSdName() + ": 학생 등록 완료.");
			} else {
				System.out.println("학생 등록 실패.");
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
	//학생 수정
	public void setStudentUpdate(StudentVO vo) {
		String sql = "update student set sd_password=?, sd_phone=?,sd_address=?,sd_email=? where sd_num=?";
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSdPassword());
			pstmt.setString(2, vo.getSdPhone());
			pstmt.setString(3, vo.getSdAddress());
			pstmt.setString(4, vo.getSdEmail());
			pstmt.setString(5, vo.getSdNum());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				System.out.println(vo.getSdName() + ": 학생 수정 완료.");
			} else {
				System.out.println("학생 수정 실패.");
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
	//학생 목록
	public void getStudentList() {
		String sql = "select * from student order by no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("일련번호\t학생번호\t\t성명\t아이디\t\t비밀번호\t\t학과\t\t생년월일\t\t전화번호\t\t주소\t\t\t이메일\t\t\t등록일자");
			
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setNo(rs.getInt("no"));
				vo.setSdNum(rs.getString("sd_num"));
				vo.setSdName(rs.getString("sd_name"));
				vo.setSdId(rs.getString("sd_id"));
				vo.setSdPassword(rs.getString("sd_password"));
				vo.setsNum(rs.getString("sd_num"));
				vo.setSdBirthday(rs.getString("sd_birthday"));
				vo.setSdPhone(rs.getNString("sd_phone"));
				vo.setSdAddress(rs.getString("sd_address"));
				vo.setSdEmail(rs.getString("sd_email"));
				vo.setSdDate(rs.getString("sd_date"));
				
				
				System.out.println(vo.getNo()+"\t"+vo.getSdNum()+"\t"+vo.getSdName()+"\t"+vo.getSdId()+"\t"+vo.getSdPassword()+"\t"+
								   vo.getsNum()+"\t\t"+vo.getSdBirthday()+"\t"+vo.getSdPhone()+"\t"+vo.getSdAddress()+"\t\t"+
								   vo.getSdEmail()+"\t\t"+vo.getSdDate());
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
	
	//아이디중복체크
	public boolean getStudentIdCheck(String sdId) {		
		String sql = "select * from student where sd_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		boolean idCheckResult = false;
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sdId);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				idCheckResult = true;
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
		
		return idCheckResult;
	}
	
	//동일학과 학생 일련번호
	public String getStudentCount(String sNum) {
		String sql = "select lpad(count(*)+1,4,'0') as studentCount from student where s_num = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		String serialNumber = null;
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sNum);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				serialNumber = rs.getString("studentCount");
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
		return serialNumber;
	}
	
	//수정을 위한 학생로그인
	public boolean getStudentLogin(String sdId, String sdPassword) {
		String sql = "select * from student where sd_id = ? and sd_password = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		boolean loginSuccess = false;
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sdId);
			pstmt.setString(2, sdPassword);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				loginSuccess = true; //로그인성공
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
		
		return loginSuccess;
	}
	
	//로그인후 학생번호가져오기
	public String getStudentNum(String sdId, String sdPassword) {
		String sql = "select sd_num from student where sd_id = ? and sd_password = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		String sd_num = null;
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sdId);
			pstmt.setString(2, sdPassword);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				sd_num = rs.getString("sd_num");
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
		
		return sd_num;
	}
}
