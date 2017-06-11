package model.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/warsztaty";
	public static final String USER = "root";
	public static final String PASSWORD = "coderslab";
	
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static LocalDate stringToLocalDate(String inputString) {
		if (inputString != null)
			return LocalDate.parse(inputString, DATE_FORMATTER);
		else
			return null;
	}

	public static String localDateToString(LocalDate inputDate) {
		if (inputDate != null)
			return inputDate.format(DATE_FORMATTER);
		else
			return null;
	}

	public static LocalDate changeDateToLocalDate(Date inputDate) {
		if (inputDate != null)
			return inputDate.toLocalDate();
		else
			return null;
	}
}
