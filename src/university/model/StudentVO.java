package university.model;

public class StudentVO {
	private int no;
	private String sdNum;
	private String sdName;
	private String sdId;
	private String sdPassword;
	private String sNum;
	private String sdBirthday;
	private String sdPhone;
	private String sdAddress;
	private String sdEmail;
	private String sdDate;
		
	public StudentVO() {
		super();
	}

	public StudentVO(int no, String sdNum, String sdName, String sdId, String sdPassword, String sNum,
			String sdBirthday, String sdPhone, String sdAddress, String sdEmail, String sdDate) {
		super();
		this.no = no;
		this.sdNum = sdNum;
		this.sdName = sdName;
		this.sdId = sdId;
		this.sdPassword = sdPassword;
		this.sNum = sNum;
		this.sdBirthday = sdBirthday;
		this.sdPhone = sdPhone;
		this.sdAddress = sdAddress;
		this.sdEmail = sdEmail;
		this.sdDate = sdDate;
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

	public String getSdName() {
		return sdName;
	}

	public void setSdName(String sdName) {
		this.sdName = sdName;
	}

	public String getSdId() {
		return sdId;
	}

	public void setSdId(String sdId) {
		this.sdId = sdId;
	}

	public String getSdPassword() {
		return sdPassword;
	}

	public void setSdPassword(String sdPassword) {
		this.sdPassword = sdPassword;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getSdBirthday() {
		return sdBirthday;
	}

	public void setSdBirthday(String sdBirthday) {
		this.sdBirthday = sdBirthday;
	}

	public String getSdPhone() {
		return sdPhone;
	}

	public void setSdPhone(String sdPhone) {
		this.sdPhone = sdPhone;
	}

	public String getSdAddress() {
		return sdAddress;
	}

	public void setSdAddress(String sdAddress) {
		this.sdAddress = sdAddress;
	}

	public String getSdEmail() {
		return sdEmail;
	}

	public void setSdEmail(String sdEmail) {
		this.sdEmail = sdEmail;
	}

	public String getSdDate() {
		return sdDate;
	}

	public void setSdDate(String sdDate) {
		this.sdDate = sdDate;
	}

	@Override
	public String toString() {
		return "StudentVO [no=" + no + ", sdNum=" + sdNum + ", sdName=" + sdName + ", sdId=" + sdId + ", sdPassword="
				+ sdPassword + ", sNum=" + sNum + ", sdBirthday=" + sdBirthday + ", sdPhone=" + sdPhone + ", sdAddress="
				+ sdAddress + ", sdEmail=" + sdEmail + ", sdDate=" + sdDate + "]";
	}
	
	
}
