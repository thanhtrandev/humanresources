// Class abstrac Staff chứa các thông tin cơ bản của nhân viên.
// Class abstrac Staff kế thừa  interface ICalculator
public abstract class Staff implements ICalculator {

	// hàm abstract để in thông tin nhân sự
	abstract void displayInformation();

	// Khai báo các biến thông tin cơ bản
	String staffID;
	String staffName;
	int staffOld;
	double coefSalary;
	String startDate;
	// kiểu dữ liệu được lấy từ class Department
	Department department;
	int numOfDayOff;

	// Viết Contructor cho các biến
	public Staff(String staffID, String staffName, int staffOld, double coefSalary, String startDate,
			Department department, int numOfDayOff) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.staffOld = staffOld;
		this.coefSalary = coefSalary;
		this.startDate = startDate;
		this.department = department;
		this.numOfDayOff = numOfDayOff;
	}

	// Viết getter và setter cho các biến
	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getStaffOld() {
		return staffOld;
	}

	public void setStaffOld(int staffOld) {
		this.staffOld = staffOld;
	}

	public double getCoefSalary() {
		return coefSalary;
	}

	public void setCoefSalary(double coefSalary) {
		this.coefSalary = coefSalary;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getNumOfDayOff() {
		return numOfDayOff;
	}

	public void setNumOfDayOff(int numOfDayOff) {
		this.numOfDayOff = numOfDayOff;
	}

}
