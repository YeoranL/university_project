package university.controller;

import java.util.Scanner;

import university.model.LessonVO;
import university.model.StudentVO;
import university.model.TraineeVO;

public class TraineeController {
	//수강신청 목록
	public void traineeList() {
		Scanner sc = new Scanner(System.in);
		TraineeDAO traineeDao = new TraineeDAO();
		StudentDAO studentDao = new StudentDAO();
		
		boolean success = false;
		
		String sdNum = null;
		String sdId = null;
		String sdPassword = null;

		System.out.println("수강 신청한 리스트");
		
		//로그인
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
		System.out.println("\n수강 신청한 리스트");
		traineeDao.getTraineeList(sdNum);
		System.out.println();
	}
	
	//수강신청 등록
	public void traineeRegister() {
		Scanner sc = new Scanner(System.in);
		TraineeDAO traineeDao = new TraineeDAO();
		StudentDAO studentDao = new StudentDAO();
		LessonDAO lessondDao = new LessonDAO();
		TraineeVO tvo = new TraineeVO();
		LessonVO lvo = new LessonVO();
		
		boolean success = false;
		
		String sdNum = null;
		String sdId = null;
		String sdPassword = null;

		System.out.println("수강 가능 과목 전체 리스트");
		lessondDao.getLessonList();
		
		System.out.println("\n수강 신청을 위한 정보 입력");		
		//로그인
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
		System.out.println("학번 : " + sdNum);
		System.out.print("과목약어(영문대문자) : ");
		String lAbbre = sc.nextLine();
		System.out.print("과목구분(교양,전공,부전공) : ");
		String tSection = sc.nextLine();
		
		tvo.setSdNum(sdNum);
		tvo.setlAbbre(lAbbre);
		tvo.settSection(tSection);
		
		traineeDao.setTraineeRegister(tvo);
		
		System.out.println("\n수강 신청한 리스트");
		traineeDao.getTraineeList(sdNum);
		System.out.println();
	}
	
	//수강신청 취소
	public void traineeDelete() {
		Scanner sc = new Scanner(System.in);
		TraineeDAO traineeDao = new TraineeDAO();
		StudentDAO studentDao = new StudentDAO();
		
		boolean success = false;
		
		String sdNum = null;
		String sdId = null;
		String sdPassword = null;
		
		System.out.println("\n수강 취소를 위한 정보 입력");		
		//로그인
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
		
		System.out.println("\n수강 신청한 리스트");
		traineeDao.getTraineeList(sdNum);
		System.out.println();

		System.out.print("취소할 수강 신청 일련번호 입력 : ");
		int no = sc.nextInt();
		traineeDao.setTraineeDelete(no);

		System.out.println("\n수강 취소후 리스트");
		traineeDao.getTraineeList(sdNum);
		System.out.println();
	}
}
