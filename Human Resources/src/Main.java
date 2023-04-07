import java.util.Scanner;

public class Main {
	
	// Hàm main - chính để quản lý các chức năng
	public static void main(String[] args) {
		HumanResource hr = new HumanResource();
		int choose = 0;
		
		// Sử dụng DO - WHILE để chọn lại chức năng từ menu
		do {
			Scanner sc = new Scanner(System.in);
			menu();
			System.out.print("chon = ");
			choose = sc.nextInt();
			
			// Sử dụng SWITCH CASE để thực hiện từng chức năng.
			switch (choose) {

			case 0:
				System.exit(0);
				return;

			case 1:
				System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty: ");
				hr.showStaffList();
				break;

			case 2:
				System.out.println("2. Hiển thị các bộ phận trong công ty");
				hr.showDepartmentList();
				break;

			case 3:
				System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
				hr.showStaffByDepartment();
				break;

			case 4:
				System.out.println("4. Thêm nhân viên mới vào công ty");
				hr.addNewEmployee(sc);
				break;
				
			case 5:
				sc.nextLine();
				System.out.println("Nhập tên hoặc mã nhân sự: "); String searchStaff = sc.nextLine();
				System.out.println("Kết quả tìm kiếm: ");
				hr.findStaff(searchStaff);
				
				break;
				
			case 6:
				System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
				hr.showSalaryList();
					
				break;
				
			case 7:
				System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
				hr.sortSalaryList();
				hr.showSalaryList();
				break;
				
			case 8:
				System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
				hr.sortSalaryListDown();
				hr.showSalaryList();
				break;
			}


		} while (choose != 0);
	}
	
	// Phướng thức hiển thị menu cho người dùng lựa chọn
	public static void menu() {
		System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
		System.out.println("2. Hiển thị các bộ phận trong công ty");
		System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
		System.out.println("4. Thêm nhân viên mới vào công ty: ");
		System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
		System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
		System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
		System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
		System.out.println("0. THoát");

	}
}
