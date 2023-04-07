import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResource {
	
	// Viết ArrayList lưu danh sách bộ phận 
	ArrayList<Department> departmentList = new ArrayList<>();
	// Viết ArrayList lưu danh sách nhân sự
	ArrayList<Staff> staffList = new ArrayList<>();
	
	// Phương thức tạo nhân sự có sẵn trong công ty
	private void addStaff() {
		staffList.add(new Employee("AT1", "Thanh Tran", 30, 2.0, "20/11/2020", departmentList.get(0), 12, 30));
		staffList.add(new Employee("AT2", "Thanh Tran", 30, 2.0, "20/11/2020", departmentList.get(0), 12, 20));
		staffList.add(new Employee("AT3", "Phu Cuong", 30, 2.0, "20/11/2020", departmentList.get(1), 12, 10));
		staffList.add(new Manager("AT4", "Thanh Phu", 30, 2.0, "20/11/2020", departmentList.get(0), 12,"Project Leader"));
		staffList.add(new Manager("AT5", "Hoang Thuong", 30, 2.0, "20/11/2020", departmentList.get(1), 12,"Business Leader"));
	}
	
	// Phương thức thêm vào bộ phận cho nhân sự
	private void addDepartment() {
		
		// Tạo 3 bộ phận của công ty.
		Department department1 = new Department("HRD", "Human Resource Department", 0);
		Department department2 = new Department("ACD", "Accounting Department", 0);
		Department department3 = new Department("AD", "Administration Department", 0);
		
		//Thêm các bộ phận được tạo lưu vào ArrayList
		departmentList.add(department1);
		departmentList.add(department2);
		departmentList.add(department3);

	}

	public HumanResource() {
		super();
		addDepartment();
		addStaff();
	}
	
	private Department getDepartmentByID(String id) {
		for (int i = 0; i < departmentList.size(); i++) {
			Department department = departmentList.get(i);
			if (department.getDepartmentID().compareTo(id) == 0) {
				department.setDepartmentTotalEmployee(department.getDepartmentTotalEmployee() + 1);
				departmentList.set(i, department);
				return department;
			}

		}

		return null;
	}

	// Phương thức thêm nhân sự mới kể cả nhân sự quản lý
	public void addNewEmployee(Scanner sc) {
		Staff staff;

		System.out.print("Ma Nhan Vien: ");
		sc.nextLine();
		String mnv = sc.nextLine();

		System.out.print("Tên Nhân viên: ");
		String tnv = sc.nextLine();

		System.out.print("Tuổi: ");
		int old = sc.nextInt();

		System.out.print("Hệ số lương: ");
		double hsl = sc.nextDouble();

		System.out.print("Ngày vào làm: ");
		sc.nextLine();
		String nvl = sc.nextLine();

		System.out.print("So Ngay Phep Hang Nam: ");
		int ngayphep = sc.nextInt();
		
		// Nhập mã bộ phận
		for (int i = 0; i < departmentList.size(); i++) {
		
		System.out.println(departmentList.get(i).getDepartmentID() + ":" + departmentList.get(i).getDepartmentName());
		
		}
		
		System.out.print("Nhập mã bộ phận: ");
		String mbp = sc.next();
	
		Department department = getDepartmentByID(mbp);  
		
		
		// Chọn thêm nhân viên hay quản lý
		System.out.println("Nhập 1. Nhân Viên hoặc 2. Quản Lý");
		int chosee;

		chosee = sc.nextInt();

		if (chosee == 1) {
			System.out.print("So Gio Lam Them: ");
			int sglt = sc.nextInt();

			staff = new Employee(mnv, tnv, old, hsl, nvl, department, ngayphep, sglt);
		}

		else {
			
			String title = chooseTittle(sc);
			staff = new Manager(mnv, tnv, old, hsl, nvl, department, ngayphep, title);
		}
		staffList.add(staff);
	}

	// Phương thức chọn chức danh cho nhân sự quản lý
	public String chooseTittle(Scanner sc) {

		String titleName = "";

		System.out.println("Chức danh: ");
		System.out.println("Chọn 1 trong 3 chức danh: ");
		System.out.println("1. Business Leader: ");
		System.out.println("2. Project Leader: ");
		System.out.println("3. Technical Leader: ");

		int choose;

		switch (choose = sc.nextInt()) {

		case 1:
			titleName = ("Business Leader");
			break;

		case 2:

			titleName = ("Project Leader");
			break;

		case 3:
			titleName = ("Technical Leader");
			break;

		}

		return titleName;

	}

	// Phương thức in ra danh sách thông tin nhân sự
	public void showStaffList() {

		for (Staff member : staffList) {
			member.displayInformation();
		}
	}

	// Phương thức in ra danh sách các bộ phận trong công ty
	public void showDepartmentList() {

		for (Department department : departmentList) {
			System.out.println(department.toString());

		}

	}

	// Phương thức in ra danh sách nhân sự theo từng bộ phận
	public void showStaffByDepartment() {

		for (Department department : departmentList) {
			System.out.println(department.getDepartmentName() + ":");

			for (Staff member : staffList) {
				if (member.department.getDepartmentID().compareTo(department.getDepartmentID()) == 0)
					member.displayInformation();

			}
		}

	}

	// Phương thức tìm kiếm nhân sự từ tên và id nhân sự
	public void findStaff(String name) {
		boolean test = false;

		for (Staff member : staffList) {
			if (name.equalsIgnoreCase(member.getStaffID()) || name.equalsIgnoreCase(member.getStaffName())) {
				member.displayInformation();
				test = true;
			}
		}

		if (!test) {
			System.out.println("Không tìm được nhân sự");
		}

	}

	// Phương thức in danh sách Lương ra màn hình
	public void showSalaryList() {
		for (Staff member : staffList) {
			System.out.println(member.staffName + "\t" + member.department.getDepartmentName() + "\t"
					+ member.coefSalary + "\t" + member.calculateSalary());
		}

	}

	// Phương thức sắp xếp lương tăng dần
	public void sortSalaryList() {
		Collections.sort(this.staffList, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				if (o1.calculateSalary() < o2.calculateSalary()) {
					return -1;
				} else if (o1.calculateSalary() < o2.calculateSalary()) {
					return 1;
				} else {
					return 0;
				}

			}

		});
	}
	
	// Phương thức sắp xếp lương giảm dần
		public void sortSalaryListDown() {
			Collections.sort(this.staffList, new Comparator<Staff>() {

				@Override
				public int compare(Staff o1, Staff o2) {
					if (o1.calculateSalary() > o2.calculateSalary()) {
						return -1;
					} else if (o1.calculateSalary() > o2.calculateSalary()) {
						return 1;
					} else {
						return 0;
					}

				}

			});
		}
}
