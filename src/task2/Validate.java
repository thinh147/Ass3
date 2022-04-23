package task2;

import java.util.List;
import java.util.Scanner;

public class Validate {
	private Scanner sc = new Scanner(System.in);

	public int getInt(String msg, String err, int min, int max) {
		int a = 0;
		boolean check;
		do {
			check = true;
			try {
				System.out.print(msg);
				a = Integer.parseInt(sc.nextLine());
				if (a < min || a > max) {
					System.out.println("Out of range, input again!");
					check = false;
				}
			} catch (Exception e) {
				System.out.println(err);
				check = false;
			}
		} while (check == false);
		return a;
	}

	public double getDouble(String msg, String err, double min, double max) {
		double a = 0;
		boolean check;
		do {
			check = true;
			try {
				System.out.print(msg);
				a = Double.parseDouble(sc.nextLine());
				String value = Double.toString(a);
				if (a < min || a > max) {
					System.out.println("Out of range, input again!");
					check = false;

				}

			} catch (Exception e) {
				System.out.println(err);
				check = false;
			}
		} while (check == false);
		return a;
	}

	public String getString(String msg, String err) {
		String string;
		do {
			System.out.println(msg);
			string = sc.nextLine().trim();
			if (string.equals("")) {
				System.out.println(err);
			}
		} while (string.equals(""));
		return string;
	}
	
	public Boolean isIdExist(List<Staff> lstStaff, String id) {
		
		for(Staff staff: lstStaff) {
			if(staff.getId().equalsIgnoreCase(id)) return true;
		}
		
		return false;
	}

}
