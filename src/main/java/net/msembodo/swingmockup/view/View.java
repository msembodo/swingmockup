package net.msembodo.swingmockup.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;

import org.springframework.beans.factory.annotation.Autowired;

import net.msembodo.swingmockup.controller.AddController;
import net.msembodo.swingmockup.model.Model;

public class View {
	
	@Autowired
	private Model model;
	
	@Autowired
	private AddController addController;
	
	public View() {}
	
	public void init() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception e1) {}
		}
		
		JPanel formPane = new JPanel();
		formPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"Add student", TitledBorder.LEFT, TitledBorder.TOP));
		formPane.setLayout(new GridLayout(0, 2));
		formPane.add(new JLabel("Name:"));
		JTextField txtName = new JTextField();
		formPane.add(txtName);
		formPane.add(new JLabel("Age:"));
		JTextField txtAge = new JTextField();
		formPane.add(txtAge);
		formPane.add(new JLabel("Major:"));
		JTextField txtMajor = new JTextField();
		formPane.add(txtMajor);
		formPane.add(new JLabel(""));
		JButton btnAdd = new JButton("Add");
		formPane.add(btnAdd);
		
		JTable table = new JTable();
		
		// create table model
		model.populateData();
		table.setModel(model);
		
		// create controller
		addController.setParams(txtName, txtAge, txtMajor, model);
		btnAdd.addActionListener(addController);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(400, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
				"Students", 
				TitledBorder.CENTER, TitledBorder.TOP));
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, formPane, tableScrollPane);
		splitPane.setEnabled(false);
		
		// display it all in a scrolling window and make the window appear
		JFrame frame = new JFrame("Swing MVC Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
