package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {
	private static boolean trueFalse;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car(2020, "Honda", false);
		System.out.println(car.ageCheck());
		System.out.println(car.mustReceiveCheck(2020));
		List<Car> carList = new ArrayList<>();
		File dataFile = new File("C:\\Users\\Student\\workspace\\jeffrey-mcluckie\\module-1\\Assessment\\student-assessment\\java\\data-files\\CarInput.csv");
		try(Scanner dataInput = new Scanner(dataFile)) {
			int sum = 0;
			while (dataInput.hasNext()) {
				String[] lineOfInput = dataInput.nextLine().split(",");
				if (lineOfInput[2].equals("true")) {
					trueFalse = true;
				} else if (lineOfInput[2].equals("false")) {
					trueFalse = false;
				}
				carList.add(new Car(Integer.parseInt(lineOfInput[0]), lineOfInput[1], trueFalse));
				int carAge = 2021 - Integer.parseInt(lineOfInput[0]);
				sum += carAge;
			}
			System.out.println(sum);
			System.out.println(carList);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");}
	}

}
