package net.msembodo.swingmockup.model;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import net.msembodo.swingmockup.service.DataService;

@SuppressWarnings("serial")
public class Model extends DefaultTableModel {
	
	@Autowired
	private DataService dataService;

	public Model() {}
	
	public void populateData() {
		setDataVector(dataService.getData(), dataService.getHeader());
	}

}
