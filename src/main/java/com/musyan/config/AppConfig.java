package com.musyan.config;

import com.musyan.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee ("1","Mustafa","Yanmaz"));

        employeeList.add(new Employee ("2","Ahmet","Yılmaz"));

        employeeList.add(new Employee ("3","Veli","Demir"));

        employeeList.add(new Employee ("4","Nazım","Sangare"));

        return employeeList;

    }
}
