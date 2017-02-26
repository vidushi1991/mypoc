/**
 * 
 */
package com.bookfari.practise.utility;

import java.util.ArrayList;
import java.util.List;

import com.bookfari.practise.model.Employee;

/**
 * @author Vidushi Mishra
 *
 */
public class AccessData {
	
	public List<Employee> empInfo(){
		List<Employee>empList = new ArrayList<Employee>();
		empList.add(new Employee("Viduhsi","Mishra",25));
		empList.add(new Employee("Rohit", "Pahouli", 32));
		empList.add(new Employee("Sohit", "Pachouli", 30));
		
		return empList;
		
	}

}
