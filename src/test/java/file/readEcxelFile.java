/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.util.HashMap;
import java.util.List;

import com.tss.helper.ExcelHelper;
import com.tss.model.Trainee;
import com.tss.model.Excel.TeamImportModel;

public class readEcxelFile {

	public static void main(String args[]) {
		readTeamImportModel();
	}

	public static void readTraineeFile() {
		List<Trainee> traineeList = ExcelHelper
				.readEcxelFile("E:\\Repositories\\Project\\g6\\src\\test\\java\\file\\test.xlsx");

		for (Trainee trainee : traineeList) {
			System.out.println(trainee.getEmail());
			System.out.println(trainee.getFullname());
			System.out.println(trainee.getMobile());
			System.out.println(trainee.getGrade());
		}
	}

	public static void readTeamImportModel() {
		TeamImportModel teamImportModel = ExcelHelper
				.readTeamImportFile("E:\\Repositories\\Project\\g6\\src\\test\\java\\file\\test2.xlsx");

		HashMap<Integer, List<Trainee>> map = teamImportModel.getTraineeTeamMap();
		for (Integer key : map.keySet()) {
			System.out.println("Team " + key);
			List<Trainee> traineeList = map.get(key);
			for (Trainee trainee : traineeList) {
				System.out.println(trainee.getEmail());
				System.out.println(trainee.getFullname());
				System.out.println(trainee.isIsLeader());
			}
		}
	}

}
