package com.myentry.MyEntry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * Author :SAURAV ROY
 */
@SpringBootApplication
@EnableCaching
public class MyEntryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEntryApplication.class, args);
	}

}
