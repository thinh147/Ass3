package task2;

import task1.task11.Task11Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------Task 2-----------------");
		StaffService staffService = new StaffService();
		List<Staff> list = new LinkedList<>();
		while (true) {
			System.out.println("Task 2");
			System.out.println("Feature 1-> 4, 0 to exit");
			System.out.println("1. Insert staff.");
			System.out.println("2. Find staff by ID.");
			System.out.println("3. Show all staff. ");
			System.out.println("4. Sort list by salary. ");
			System.out.println("5. Delete staff. ");

			int choice = sc.nextInt();
			switch (choice) {
				case 0:
					System.exit(0);
				case 1:
					staffService.insertStaff(list);
					break;
				case 2:
					System.out.println(staffService.findStaffById(list));
					break;
				case 3:
					System.out.println("List staff: ");
					staffService.displayAllStaff(list);
					break;
				case 4:
					System.out.println("Sort by Salary");
					System.out.println(staffService.sortListStaff(list));
					break;
				case 5:
					staffService.deleteStaffById(list);
					break;
				default:
					System.out.println("Nhập sai, vui lòng nhập lại!!");
					break;
			}
		}
	}
}
