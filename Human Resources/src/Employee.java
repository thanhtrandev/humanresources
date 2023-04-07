// Class Employee - nhân sự thông thường
// Class Employee kế thừa class Staff và interface ICalculator
public class Employee extends Staff implements ICalculator {
	
	// Khai báo biến để nhận giá trị làm thêm giờ
	private int overtimeHours;
	
	// Viết Contructor cho các biến mới và các biến được kế thừa thừ class cha
	public Employee(String staffID, String staffName, int staffOld, double coefSalary, String startDate,
			Department department, int numOfDayOff, int overtimeHours ) {
		super(staffID, staffName, staffOld, coefSalary, startDate, department, numOfDayOff);
		this.overtimeHours = overtimeHours;
		
	}

	
	// Viết getter và setter cho biến overtimeHours
	public int getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(int overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	
	// Ghi đè phương thức hàm displayInformation() để hiển thị thông tin nhân sự thông thường
	@Override
	void displayInformation() {
		System.out.println(this.getStaffID() + "\t" + this.getStaffName() + "\t" + this.getStaffOld() + "\t" + this.getCoefSalary() + "\t" + this.getStartDate() + "\t" + this.getDepartment().getDepartmentName() + "\t" + this.getNumOfDayOff() + "\t" + this.getOvertimeHours()); 
	}
	
	// Phương thức tính lương cụ thể cho nhân sự thông thường
	public long calculateSalary(){
		int basicSalary = 3000000;
        return (long) (basicSalary * coefSalary + 200000 * overtimeHours);
    }
	
}
