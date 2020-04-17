package ru.ankoks.simple_orm;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class SimpleOrmApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SimpleOrmApplication.class, args);
		Console.main(args);
	}

}
