package net.msembodo.swingmockup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.msembodo.swingmockup.dao.StudentDao;
import net.msembodo.swingmockup.model.Student;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public Object[] getHeader() {
		Object[] tableHeader = { "name", "age", "major" };
		return tableHeader;
	}

	@Override
	public Object[][] getData() {
		List<Student> students = (List<Student>) studentDao.findAll();
		Object[][] data = new Object[students.size()][3];
		for (int i = 0; i < students.size(); i++) {
			data[i][0] = students.get(i).getName();
			data[i][1] = students.get(i).getAge();
			data[i][2] = students.get(i).getMajor();
		}
		return data;
	}

	@Override
	public void addStudent(String name, int age, String major) {
		Student student = new Student(name, age, major);
		studentDao.save(student);
	}
	
}
