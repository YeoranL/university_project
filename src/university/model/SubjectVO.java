package university.model;

public class SubjectVO {
	private int no;
	private String sNum;
	private String sName;
	
	public SubjectVO() {
		super();
	}

	public SubjectVO(int no, String sNum, String sName) {
		super();
		this.no = no;
		this.sNum = sNum;
		this.sName = sName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "SubjectVO [no=" + no + ", sNum=" + sNum + ", sName=" + sName + "]";
	}

}
