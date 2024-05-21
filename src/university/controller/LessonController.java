package university.controller;

import java.util.Scanner;

import university.model.LessonVO;

public class LessonController {
	//과목 목록
	public void lessonList() {
		LessonDAO lessonDao = new LessonDAO();
		System.out.println("과목 전체 리스트");
		lessonDao.getLessonList();
		System.out.println();
	}
	
	//과목 등록
	public void lessonRegister() {
		Scanner sc = new Scanner(System.in);
		LessonDAO lessonDao = new LessonDAO();
		LessonVO lessonVo = new LessonVO();
		
		System.out.println("과목 정보 리스트");
		lessonDao.getLessonList();
		
		System.out.println("\n과목 정보 입력");
		System.out.print("과목약어 : ");
		String lAbbre = sc.nextLine();
		System.out.print("과목명 : ");
		String lName = sc.nextLine();
		
		lessonVo.setlAbbre(lAbbre);
		lessonVo.setlName(lName);
		
		lessonDao.setLessonRegister(lessonVo);
		
		System.out.println("\n과목 정보 리스트");
		lessonDao.getLessonList();
		System.out.println();
	}
	
	//과목 수정
	public void lessonUpdate() {
		Scanner sc = new Scanner(System.in);
		LessonDAO lessonDao = new LessonDAO();
		LessonVO lessonVo = new LessonVO();
		
		System.out.println("과목 정보 리스트");
		lessonDao.getLessonList();
		
		System.out.print("\n수정할 과목 일련번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		System.out.println("새로운 정보 입력");
		System.out.print("과목약어 : ");
		String lAbbre = sc.nextLine();
		System.out.print("과목명 : ");
		String lName = sc.nextLine();
		
		lessonVo.setNo(no);
		lessonVo.setlAbbre(lAbbre);
		lessonVo.setlName(lName);
		
		lessonDao.setLessonUpdate(lessonVo);
		
		System.out.println("\n과목 정보 리스트");
		lessonDao.getLessonList();
		System.out.println();
	}
	
	//과목 삭제
	public void lessonDelete() {
		Scanner sc = new Scanner(System.in);
		LessonDAO lessonDao = new LessonDAO();
		LessonVO lessonVo = new LessonVO();
		
		System.out.println("과목 정보 리스트");
		lessonDao.getLessonList();
		
		System.out.print("\n삭제할 과목 일련번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		lessonVo.setNo(no);
		
		lessonDao.setLessonDelete(lessonVo);
		
		System.out.println("\n과목 정보 리스트");
		lessonDao.getLessonList();
		System.out.println();
	}
}
