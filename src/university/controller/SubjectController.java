package university.controller;

import java.util.Scanner;

import university.model.SubjectVO;

public class SubjectController {
	//학과 목록
	public void subjectList() {
		SubjectDAO subjectDao = new SubjectDAO();
		System.out.println("학과 전체 리스트");
		subjectDao.getSubjectList();
		System.out.println();
	}
	
	//학과 등록
	public void subjectRegister() {
		Scanner sc = new Scanner(System.in);
		SubjectDAO subjectDao = new SubjectDAO();
		SubjectVO subjectVo = new SubjectVO();
		
		System.out.println("학과 정보 리스트");
		subjectDao.getSubjectList();
		
		System.out.println("\n학과 정보 입력");
		System.out.print("학과번호 : ");
		String sNum = sc.nextLine();
		System.out.print("학과명 : ");
		String sName = sc.nextLine();
		
		subjectVo.setsNum(sNum);
		subjectVo.setsName(sName);
		
		subjectDao.setSubjectRegister(subjectVo);
		
		System.out.println("\n학과 정보 리스트");
		subjectDao.getSubjectList();
		System.out.println();
	}
	
	//학과 수정
	public void subjectUpdate() {
		Scanner sc = new Scanner(System.in);
		SubjectDAO subjectDao = new SubjectDAO();
		SubjectVO subjectVo = new SubjectVO();
		
		System.out.println("학과 정보 리스트");
		subjectDao.getSubjectList();
		
		System.out.print("\n수정할 학과 일련번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		System.out.println("새로운 정보 입력");
		System.out.print("학과번호 : ");
		String sNum = sc.nextLine();
		System.out.print("학과명 : ");
		String sName = sc.nextLine();
		
		subjectVo.setNo(no);
		subjectVo.setsNum(sNum);
		subjectVo.setsName(sName);
		
		subjectDao.setSubjectUpdate(subjectVo);
		
		System.out.println("\n학과 정보 리스트");
		subjectDao.getSubjectList();
		System.out.println();
	}
	
	//학과 삭제
	public void subjectDelete() {
		Scanner sc = new Scanner(System.in);
		SubjectDAO subjectDao = new SubjectDAO();
		SubjectVO subjectVo = new SubjectVO();
		
		System.out.println("학과 정보 리스트");
		subjectDao.getSubjectList();
		
		System.out.print("\n삭제할 학과 일련번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		subjectVo.setNo(no);
		
		subjectDao.setSubjectDelete(subjectVo);
		
		System.out.println("\n학과 정보 리스트");
		subjectDao.getSubjectList();
		System.out.println();
	}
}
