package com.jdbc;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jdbc.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {

		
		IOService fileIOService = IOService.FILE_IO;
		@Test
		public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = {
		new EmployeePayrollData(1, "Bill", 1000000),
		new EmployeePayrollData(2, "Teria", 3000000),
		new EmployeePayrollData(3, "Charlie", 3000000),
		};
		
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(fileIOService);
		employeePayrollService.printData(fileIOService);
		long entries = employeePayrollService.countEntries(fileIOService);
		Assert.assertEquals(3, entries);
	}

		@Test
		public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
			EmployeePayrollService employeePayrollService = new EmployeePayrollService();
			List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(IOService.DB_IO);
			Assert.assertEquals(4, employeePayrollData.size());
			
			}
			
		@Test
		public void givenNewSalaryForEmployee_WhenUpdatedShouldSyncWithDB() {
			EmployeePayrollService employeePayrollService = new EmployeePayrollService ();
			List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(fileIOService);
			employeePayrollService.updateEmployeebasicPay("Teria", 3006000);
			boolean result = employeePayrollService.checkEmployeePayrollInSynWithDB("Teria", 3000000);
			Assert.assertTrue(result);
			
		}	
			
	}


