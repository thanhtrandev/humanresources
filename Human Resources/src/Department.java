import java.util.ArrayList;
import java.util.List;

// Class Department để quản lý các thuộc tính bộ phận
public class Department {

	// Khai báo các biến thuộc tính của bộ phận
	private String departmentID;
	private String departmentName;
	private int departmentTotalEmployee;

	// Viết ArrayList lưu các nhân viên theo từng bộ phân.
	private final List<Staff> staffInDepartment = new ArrayList<>();

	// Viết Contructor cho các biến mới thuộc tính
	public Department(String departmentID, String departmentName, int departmentTotalEmployee) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.departmentTotalEmployee = departmentTotalEmployee;
	}

	//// Viết getter và setter cho biến đã khai báo và ArrayList
	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentTotalEmployee() {
		return departmentTotalEmployee;
	}

	public void setDepartmentTotalEmployee(int departmentTotalEmployee) {
		this.departmentTotalEmployee = departmentTotalEmployee;
	}

	public List<Staff> getStaffInDepartment() {
		return staffInDepartment;
	}

	// Phương thức thêm nhân sự và tính tổng nhân sự của từng bộ phận
	public void addStafftoDepartment(Staff member) {
		this.staffInDepartment.add(member);
		this.departmentTotalEmployee++;
	}

//	public void removeStaffFromDepartment(Staff member) {
//		this.staffInDepartment.remove(member);
//		this.departmentTotalEmployee--;
//	}

	// Phương thức: toString() hiển thị thông tin về bộ phận.
	@Override
	public String toString() {
		return "Mã bộ phận: " + departmentID + "\t" + "Tên bộ phận: " + departmentName + "\t" + "Tổng nhân sự: "
				+ departmentTotalEmployee;
	}

}
