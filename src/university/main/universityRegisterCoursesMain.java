package university.main;

import java.util.Scanner;

import university.controller.LessonController;
import university.controller.StudentController;
import university.controller.SubjectController;
import university.controller.TraineeController;
import university.view.LESSON_CHOICE;
import university.view.MENU_CHOICE;
import university.view.MenuViewer;
import university.view.STUDENT_CHOICE;
import university.view.SUBJECT_CHOICE;
import university.view.TRAINEE_CHOICE;

public class universityRegisterCoursesMain {
	public static Scanner choice = new Scanner(System.in);
	public static void main(String[] args) {
		mainMenu();		
	}
	
	public static void mainMenu() {
		int number = 0;
		boolean quit = false;	
		
		while(!quit) {
			MenuViewer.mainMenuView();
			number = Integer.parseInt(choice.nextLine());
			switch (number) {
			case MENU_CHOICE.SUBJECT:
				subjectMenu();
				break;
			case MENU_CHOICE.STUDENT:
				studentMenu();
				break;
			case MENU_CHOICE.LESSON:
				lessonMenu();
				break;
			case MENU_CHOICE.TRAINEE:
				traineeMenu();
				break;
			case MENU_CHOICE.EXIT:
				System.out.println("프로그램을 종료합니다.");
				quit = true;
				break;
			default:
				System.out.println("해당 메뉴 번호만 입력하세요.");
				break;
			}
		}
	}

	public static void subjectMenu() {
		int number;
		SubjectController subjectController = new SubjectController();
		MenuViewer.subjectMenuView();
		number = Integer.parseInt(choice.nextLine());
		
		switch (number) {
		case SUBJECT_CHOICE.LIST:
			subjectController.subjectList();
			break;
		case SUBJECT_CHOICE.INSERT:
			subjectController.subjectRegister();
			break;
		case SUBJECT_CHOICE.UPDATE:
			subjectController.subjectUpdate();
			break;
		case SUBJECT_CHOICE.DELETE:
			subjectController.subjectDelete();
			break;
		case SUBJECT_CHOICE.MAIN:			
			break;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
			break;
		}
		
	}

	public static void studentMenu() {
		int number;
		StudentController studentController = new StudentController();
		MenuViewer.studentMenuView();
		number = Integer.parseInt(choice.nextLine());
		
		switch (number) {		
		case STUDENT_CHOICE.INSERT:
			studentController.studentRegister();
			break;
		case STUDENT_CHOICE.UPDATE:
			studentController.studentUpdate();
			break;
		case STUDENT_CHOICE.LIST:
			studentController.studentList();
			break;
		case STUDENT_CHOICE.MAIN:			
			break;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
			break;
		}
	}

	public static void lessonMenu() {
		int number;
		LessonController lessonController = new LessonController();
		MenuViewer.lessonMenuView();
		number = Integer.parseInt(choice.nextLine());
		
		switch (number) {		
		case LESSON_CHOICE.LIST:
			lessonController.lessonList();
			break;
		case LESSON_CHOICE.INSERT:
			lessonController.lessonRegister();
			break;
		case LESSON_CHOICE.UPDATE:
			lessonController.lessonUpdate();
			break;
		case LESSON_CHOICE.DELETE:
			lessonController.lessonDelete();
			break;
		case LESSON_CHOICE.MAIN:			
			break;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
			break;
		}
		
	}

	public static void traineeMenu() {
		int number;
		TraineeController traineeController = new TraineeController();
		MenuViewer.traineeMenuView();
		number = Integer.parseInt(choice.nextLine());
		
		switch (number) {		
		case TRAINEE_CHOICE.LIST:
			traineeController.traineeList();
			break;
		case TRAINEE_CHOICE.INSERT:
			traineeController.traineeRegister();
			break;
		case TRAINEE_CHOICE.UPDATE:
			traineeController.traineeDelete();
			break;
		case TRAINEE_CHOICE.MAIN:			
			break;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
			break;
		}
	}


}
