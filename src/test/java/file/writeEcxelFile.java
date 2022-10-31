/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.util.List;

import com.tss.helper.ExcelHelper;
import com.tss.model.Trainee;
import com.tss.service.UserService;
import com.tss.service.impl.UserServiceImpl;

public class writeEcxelFile {

	public static void main(String args[]) {

		UserService userService = new UserServiceImpl();
		List<Trainee> traineeList = userService.findAllByClassId(0, 999, "", null, 0, "ASC", "", 1);
		ExcelHelper.exportUserForTeamImport(traineeList,
				"E:\\Repositories\\Project\\g6\\src\\test\\java\\file\\test2.xlsx");

	}

}
