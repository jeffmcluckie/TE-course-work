package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {

		MovieRental movie = new BluRayRental("Batman Begins", false );
		System.out.println("My movie format is " + movie.getFormat());
		System.out.println("My movie rental price is " + movie.getRentalPrice());
		System.out.println(movie.toString());

		List<MovieRental> movies = new ArrayList<MovieRental>();
		File file = new File("data-files/MovieInput.csv");
		try (Scanner scanner = new Scanner(file)) {
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] lineParts = line.split(",");

				String title = lineParts[0];
				String format = lineParts[1];
				boolean premium = Boolean.parseBoolean(lineParts[2]);

				if (format.equals("Blu-ray")) {
					movies.add(new BluRayRental(title, premium));
				} else if (format.equals("VHS")) {
					movies.add(new VHSRental(title, premium));
				} else if (format.equals("DVD")) {
					movies.add(new DVDRental(title, premium));
				}
			}

			BigDecimal totalRentalPrice = BigDecimal.ZERO;
			for(MovieRental m : movies) {
				totalRentalPrice = totalRentalPrice.add(m.getRentalPrice());
				System.out.println(m);
			}

			System.out.println("Total Rental Price Is $" + totalRentalPrice);
		} catch(Exception ex) {
			System.out.println("Failed to parse file");
			// log the actual exception to external file
		}
	}

}
