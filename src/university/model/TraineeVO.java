package university.model;

public class TraineeVO {
	private int no;
	private String sdNum;
	private String lAbbre;
	private String tSection;
	private String tDate;	
		
	public TraineeVO() {
		super();
	}

	public TraineeVO(int no, String sdNum, String lAbbre, String tSection, String tDate) {
		super();
		this.no = no;
		this.sdNum = sdNum;
		this.lAbbre = lAbbre;
		this.tSection = tSection;
		this.tDate = tDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSdNum() {
		return sdNum;
	}

	public void setSdNum(String sdNum) {
		this.sdNum = sdNum;
	}

	public String getlAbbre() {
		return lAbbre;
	}

	public void setlAbbre(String lAbbre) {
		this.lAbbre = lAbbre;
	}

	public String gettSection() {
		return tSection;
	}

	public void settSection(String tSection) {
		this.tSection = tSection;
	}

	public String gettDate() {
		return tDate;
	}

	public void settDate(String tDate) {
		this.tDate = tDate;
	}

	@Override
	public String toString() {
		return "TraineeVO [no=" + no + ", sdNum=" + sdNum + ", lAbbre=" + lAbbre + ", tSection=" + tSection + ", tDate="
				+ tDate + "]";
	}
		
}
