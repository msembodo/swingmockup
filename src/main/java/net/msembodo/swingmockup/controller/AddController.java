package net.msembodo.swingmockup.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;

import net.msembodo.swingmockup.model.Model;
import net.msembodo.swingmockup.service.DataService;

public class AddController implements ActionListener {
	
	@Autowired
	private DataService dataService;
	
	private JTextField txtName = new JTextField();
	private JTextField txtAge = new JTextField();
	private JTextField txtMajor = new JTextField();
	private Model model;
	
	public AddController() {}
	
	public void setParams(JTextField txtName, JTextField txtAge, JTextField txtMajor, Model model) {
		this.txtName = txtName;
		this.txtAge = txtAge;
		this.txtMajor = txtMajor;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String name = txtName.getText();
			int age = Integer.valueOf(txtAge.getText());
			String major = txtMajor.getText();
			dataService.addStudent(name, age, major);
			model.populateData();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fields can not be empty", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}

}
