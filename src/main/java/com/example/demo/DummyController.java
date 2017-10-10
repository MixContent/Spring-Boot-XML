package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

	@RequestMapping(value = "/save", produces = { MediaType.APPLICATION_XML_VALUE }, headers = "Accept=application/xml")
	public Response saveEmployee(@RequestBody Employee employee) {
		Response response = new Response();
		response.setStatus("success");
		response.setMessage("User " + employee.getName() + " Saved");
		return response;
	}

	@RequestMapping(value = "/getAll", produces = {
			MediaType.APPLICATION_XML_VALUE }, headers = "Accept=application/xml")
	public ListEmployeeResponse getEmployees() {
		Employee employee1 = new Employee();
		employee1.setId(11);
		employee1.setName("Basant");
		Employee employee2 = new Employee();
		employee2.setId(19);
		employee2.setName("Bikash");
		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		ListEmployeeResponse employeeResponse = new ListEmployeeResponse();
		employeeResponse.setEmployees(employees);
		return employeeResponse;

	}

}
