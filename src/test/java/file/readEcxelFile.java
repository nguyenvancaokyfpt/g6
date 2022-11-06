/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.tss.helper.ExcelHelper;
import com.tss.model.Trainee;
import com.tss.model.Excel.TeamImportModel;

public class readEcxelFile {

	public static void main(String args[]) {
		readTraineeFile();
		// readTeamImportModel();
	}

	public static void readTraineeFile() {
		HashMap<Set<Integer>, List<Trainee>> map = ExcelHelper
				.readEcxelFile("E:\\Repositories\\Project\\g6\\src\\test\\java\\file\\test.xlsx");

		for (Trainee trainee : map.get(map.keySet().toArray()[0])) {
			System.out.println(trainee.getEmail());
			System.out.println(trainee.getFullname());
			System.out.println(trainee.getMobile());
			System.out.println(trainee.getGrade());
		}
		System.out.println("Error:");

		for (Integer integer : map.keySet().iterator().next()) {
			System.out.println(integer);
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
