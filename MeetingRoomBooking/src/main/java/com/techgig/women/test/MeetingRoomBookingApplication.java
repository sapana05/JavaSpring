package com.techgig.women.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.techgig.women.test","com.techgig.women.test.Service","com.techgig.women.test.Repository","com.techgig.women.test.Response","com.techgig.women.test.Controller"})
public class MeetingRoomBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomBookingApplication.class, args);
	}

}
