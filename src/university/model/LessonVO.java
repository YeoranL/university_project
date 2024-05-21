package university.model;

public class LessonVO {
	private int no;
	private String lAbbre;
	private String lName;
		
	public LessonVO() {
		super();
	}

	public LessonVO(int no, String lAbbre, String lName) {
		super();
		this.no = no;
		this.lAbbre = lAbbre;
		this.lName = lName;
	}

	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getlAbbre() {
		return lAbbre;
	}
	
	public void setlAbbre(String lAbbre) {
		this.lAbbre = lAbbre;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "LessonVO [no=" + no + ", lAbbre=" + lAbbre + ", lName=" + lName + "]";
	}
		
}
