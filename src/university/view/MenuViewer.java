package university.view;

public class MenuViewer {
	//메인메뉴
	public static void mainMenuView() {
		System.out.println("미래대학교 수강신청 프로그램");
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1.학과 정보 목록/입력/수정/삭제");
		System.out.println("2.학생 정보 입력/수정/목록");
		System.out.println("3.과목 정보 목록/입력/수정/삭제");
		System.out.println("4.수강 신청 목록/신청/취소");
		System.out.println("5.프로그램 종료");
		System.out.print("번호 선택 : ");
	}
	
	//학과메뉴
	public static void subjectMenuView() {
		System.out.println("학과 정보 메뉴 번호를 입력하세요.");
		System.out.println("1.학과 정보 목록");
		System.out.println("2.학과 정보 입력");
		System.out.println("3.학과 정보 수정");
		System.out.println("4.학과 정보 삭제");
		System.out.println("5.메인 메뉴");
		System.out.print("번호 선택 : ");		
	}
	
	//학생메뉴
	public static void studentMenuView() {
		System.out.println("학생 정보 메뉴 번호를 입력하세요.");
		System.out.println("1.학생 정보 입력");
		System.out.println("2.학생 정보 수정");
		System.out.println("3.학생 정보 목록");
		System.out.println("4.메인 메뉴");
		System.out.print("번호 선택 : ");	
	}
	
	//과목메뉴
	public static void lessonMenuView() {
		System.out.println("과목 정보 메뉴 번호를 입력하세요.");
		System.out.println("1.과목 정보 목록");
		System.out.println("2.과목 정보 입력");
		System.out.println("3.과목 정보 수정");
		System.out.println("4.과목 정보 삭제");
		System.out.println("5.메인 메뉴");
		System.out.print("번호 선택 : ");	
	}
	
	//수강신청메뉴
	public static void traineeMenuView() {
		System.out.println("학과 정보 메뉴 번호를 입력하세요.");
		System.out.println("1.수강 신청 목록");
		System.out.println("2.수강 신청");
		System.out.println("3.수강 취소");
		System.out.println("4.메인 메뉴");
		System.out.print("번호 선택 : ");	
	}
}
