package university.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import university.model.StudentVO;

public class StudentController {
	//학생 등록
	public void studentRegister() {
		Scanner sc = new Scanner(System.in);
		SubjectDAO subjectDao = new SubjectDAO();
		StudentDAO studentDao = new StudentDAO();
		StudentVO studentVo = new StudentVO();
		
		boolean id_check = false;
		String year = null;
		String sdNum = null;
		String sdId = null;
		
		System.out.println("\n학생 정보 입력");
		
		System.out.print("성명 : ");
		String sdName = sc.nextLine();
		
		//아이디체크
		do {
			System.out.print("아이디(8자 이상 12자 이내) : ");
			sdId = sc.nextLine();
			id_check = studentDao.getStudentIdCheck(sdId);
			if(id_check) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
		} while(id_check);
		
		System.out.print("비밀번호(12자이내) : ");
		String sdPassword = sc.nextLine();

		subjectDao.getSubjectList();
		
		System.out.print("학과번호 : ");		
		String sNum = sc.nextLine();
		
		//학번생성(8자리:연도2+학과2+일련번호)
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		year = sdf.format(new Date());
		sdNum = year + sNum + studentDao.getStudentCount(sNum);
		
		System.out.print("생년월일(8자리) : ");		
		String sdBirthday = sc.nextLine();
		
		System.out.print("전화번호 : ");		
		String sdPhone = sc.nextLine();
		
		System.out.print("도로명 주소 : ");		
		String sdAddress = sc.nextLine();
		
		System.out.print("이메일 : ");		
		String sdEmail = sc.nextLine();
		
		studentVo.setSdNum(sdNum);
		studentVo.setSdName(sdName);
		studentVo.setSdId(sdId);
		studentVo.setSdPassword(sdPassword);
		studentVo.setsNum(sNum);
		studentVo.setSdBirthday(sdBirthday);
		studentVo.setSdPhone(sdPhone);
		studentVo.setSdAddress(sdAddress);
		studentVo.setSdEmail(sdEmail);
		
		studentDao.setStudentRegister(studentVo);
		
		System.out.println("\n학생 정보 리스트");
		studentDao.getStudentList();
		System.out.println();
	}
	//학생 수정
	public void studentUpdate() {
		Scanner sc = new Scanner(System.in);

		StudentDAO studentDao = new StudentDAO();
		StudentVO studentVo = new StudentVO();
		
		boolean success = false;
		String sdId = null;
		String sdPassword = null;
		String sdNum = null;
		
		System.out.println("학생 정보 수정");		
	
		do {
			System.out.print("아이디 : ");
			sdId = sc.nextLine();
			System.out.print("비밀번호 : ");
			sdPassword = sc.nextLine();
			success = studentDao.getStudentLogin(sdId,sdPassword);
			if(!success) {
				System.out.println("아이디 또는 비밀번호가 틀림. 다시 입력하세요.");
			}
		} while(!success);
		
		sdNum = studentDao.getStudentNum(sdId,sdPassword);
		System.out.println("\n수정할 학생");
		System.out.println("학생번호 : " + sdNum);
		
		System.out.print("비밀번호(12자이내) : ");
		sdPassword = sc.nextLine();
		
		System.out.print("전화번호 : ");		
		String sdPhone = sc.nextLine();
		
		System.out.print("도로명 주소 : ");		
		String sdAddress = sc.nextLine();
		
		System.out.print("이메일 : ");		
		String sdEmail = sc.nextLine();
		
		studentVo.setSdNum(sdNum);
		studentVo.setSdPassword(sdPassword);
		studentVo.setSdPhone(sdPhone);
		studentVo.setSdAddress(sdAddress);
		studentVo.setSdEmail(sdEmail);
		
		studentDao.setStudentRegister(studentVo);
		
		System.out.println("\n학생 정보 리스트");
		studentDao.getStudentList();
		System.out.println();
	}
	//학생 목록
	public void studentList() {
		StudentDAO studentDao = new StudentDAO();
		System.out.println("학생 전체 리스트");
		studentDao.getStudentList();
		System.out.println();
	}
}
