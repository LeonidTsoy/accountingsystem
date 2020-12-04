package com.accountingsystem.library;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class LibraryApplication {

	static final String DB_URL = "jdbc:postgresql://localhost:8080/accountingsystem";
	static final String USER = "postgres";
	static final String PASS = "leonid";

	public static void main(String[] argv) {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		Connection connection = null;

		try {
			connection = DriverManager
					.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("Вы подключены к базе данных");
		} else {
			System.out.println("Не удалось подключиться к базе данных");
		}
	}
}
