package com.musyan.starter;

import com.musyan.dto.DtoEmployee;
import com.musyan.service.IEmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ExceptionManagamentStarter.class})
class ExceptionManagamentApplicationTests {


	@Autowired
	private IEmployeeService employeeService;

	@BeforeEach
	public void beforeEach(){
		System.out.println("beforeEach çalıştı...");
	}

	@Test
	public void testFindEmployeeById(){

		DtoEmployee employee = employeeService.findEmployeeById(28L);

		if(employee != null){
			System.out.println("İsim : "+ employee.getName());
		}
	}

	@AfterEach
	public void afterEach(){
		System.out.println("AfterEach çalıştı...");
	}

}
