/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;


import java.util.List;

import com.tss.helper.ExcelHelper;
import com.tss.model.Trainee;

public class readEcxelFile {

    public static void main(String args[]) {

		List<Trainee> traineeList = ExcelHelper.readEcxelFile("E:\\Repositories\\Project\\g6\\src\\test\\java\\file\\test.xlsx");

		for (Trainee trainee : traineeList) {
			System.out.println(trainee.getEmail());
			System.out.println(trainee.getFullname());
		}

    }

}
