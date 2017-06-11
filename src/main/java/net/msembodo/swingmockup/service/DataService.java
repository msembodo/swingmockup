package net.msembodo.swingmockup.service;

public interface DataService {
	
	public Object[] getHeader();
	public Object[][] getData();
	public void addStudent(String name, int age, String major);

}
