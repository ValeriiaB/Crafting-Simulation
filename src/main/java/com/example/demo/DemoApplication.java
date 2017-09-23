package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//trangeent - не записывать в бд

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) throws IOException{
		SpringApplication.run(DemoApplication.class, args);

	}
}
