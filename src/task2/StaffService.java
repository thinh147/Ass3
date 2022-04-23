package task2;

import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StaffService {
	
	private Validate validate = new Validate();
	private Scanner sc = new Scanner(System.in);
	
	public void insertStaff(List<Staff> lstStaff) {
		if(lstStaff == null) {
			System.out.println("Something wrong!");
			return;
		}
		
		String id = validate.getString("Input staff indentification: ", "Input not empty");
		while(validate.isIdExist(lstStaff, id)) {
			id = validate.getString("Input staff indentification: ", "Input not empty");
		}
		
		String fullName = validate.getString("Input fullname: ", "Input not empty");
		String address = validate.getString("Input address: ", "Input not empty");
		int day = validate.getInt("Input day of birth date: ", "Day must be a possitive decical number! ", 0, 31);
		int month = validate.getInt("Input month of birth date: ", "Month must be a possitive decical number! ", 0, 12);
		int year = validate.getInt("Input year of birth date: ", "Year must be a possitive decical number! ", 0, Calendar.getInstance().get(Calendar.YEAR));
		double salary = validate.getDouble("Input salary : ", "Day must be a number!", month, year);
		
		Date dob = new Date(day, month, year);
		Staff staff = new Staff(id, fullName, address, dob, salary);
		lstStaff.add(staff);
		System.out.println("success!!");
	}
	
	public Staff findStaffById(List<Staff> lstStaff) {
		if(lstStaff == null) {
			return null;
		}
		
		String id = validate.getString("Input staff indentification: ", "Input not empty");
		for(Staff staff: lstStaff) {
			if(staff.getId().equalsIgnoreCase(id)) return staff;
		}		
		return null;
	}
	
	public void displayAllStaff(List<Staff> lstStaff) {
		if(lstStaff == null) {
			System.out.println("Something wrong!");
			return;
		}
		
		for(Staff staff: lstStaff) {
			System.out.println(staff.toString());
		}		
	}
	
	public List<Staff>sortListStaff(List<Staff> lstStaff){
		List<Staff>lstResult = lstStaff.stream().sorted(new Comparator<Staff>() {
			@Override
			public int compare(Staff o1, Staff o2) {
				if(o1.getSalary() > o2.getSalary()) return 1;
				if(o1.getSalary() < o2.getSalary()) return -1;
				return 0;
			}
		}).collect(Collectors.toList());
		return lstResult;
	}
	
	public void deleteStaffById(List<Staff> lstStaff) {
		String id = validate.getString("Input staff indentification: ", "Input not empty");
		if(!validate.isIdExist(lstStaff, id)) {
			System.out.println("Id not exist!");
			return;
		}
		
		Staff staffDelete = null;
		for(Staff staff: lstStaff) {
			if(staff.getId().equalsIgnoreCase(id)) {
				staffDelete = staff;
				break;
			} 
		}
		
		lstStaff.remove(staffDelete);
	}
}
