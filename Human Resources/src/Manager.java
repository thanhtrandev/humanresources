// Class Manager - nhân sự sự quản lý
// Class Manager kế thừa class Staff và interface ICalculator
public class Manager extends Staff implements ICalculator {

	// Khai báo thêm biến thể hiện chức danh cho nhân sự quản lý
	private String titleName;

	//Viết Contructor cho biến mới và các biến được kế thừa thừ class cha
	public Manager(String staffID, String staffName, int staffOld, double coefSalary, String startDate,
			Department department, int numOfDayOff, String titleName) {
		super(staffID, staffName, staffOld, coefSalary, startDate, department, numOfDayOff);
		this.titleName = titleName;

	}
	
	// Viết getter và setter cho biến titleName
	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	// Ghi đè phương thức hàm displayInformation() để hiển thị thông tin nhân sự quản lý bao gồm chức danh
	@Override
	void displayInformation() {
		System.out.println(this.getStaffID() + "\t" + this.getStaffName() + "\t" + this.getStaffOld() + "\t"
				+ this.getCoefSalary() + "\t" + this.getStartDate() + "\t" + this.getDepartment().getDepartmentName()
				+ "\t" + this.getNumOfDayOff() + "\t" + this.getTitleName());
	}
	
	// Phương thức tính lương cụ thể cho nhân sự quản lý
	// Khai báo biên lương trách nhiệm dựa trên chức danh
	@Override
	public long calculateSalary() {
		int basicSalary = 5000000;
		int responsibilitySalary = 0;

		if (this.getTitleName() == "Business Leader") {
			responsibilitySalary = 8000000;
		}

		if (this.getTitleName() == "Project Leader") {
			responsibilitySalary = 5000000;
		}

		if (this.getTitleName() == "Technical Leader") {
			responsibilitySalary = 6000000;
		}

		return (long) (basicSalary * coefSalary + responsibilitySalary);
	}

}
