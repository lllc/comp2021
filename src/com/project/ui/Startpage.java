package com.project.ui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;

import com.project.model.TemplateClass;
import com.project.util.ClassCreator;
import com.project.util.FileCreator;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Startpage {

	private JFrame frame;
	private JButton btnSave;
	private JButton btnNewClass;
	private JButton btnCallFunction;
	private JLabel lblError;
	private TemplateClass templateClass;
	private JPanel panel_2;

	private Startpage _startpage;
	private JLabel lblClasses;
	private Label label;

	public static void main(String[] args) {
		try {
			Startpage startpage = new Startpage();
			startpage.frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public Startpage() {
		templateClass = new TemplateClass();
		_startpage = this;
		initialize();
		intiButtonAction();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setBounds(100, 100, 565, 374);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		btnNewClass = new JButton("New Class");
		panel_1.add(btnNewClass);

		btnCallFunction = new JButton("Call Function");
		panel_1.add(btnCallFunction);

		btnSave = new JButton("Save");
		panel_1.add(btnSave);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblClasses = new JLabel("Classes");
		lblClasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasses.setPreferredSize(new Dimension(200, 15));
		panel_2.add(lblClasses);
		
		label = new Label(" ");
		panel_2.add(label);

	}

	private void intiButtonAction() {

//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				 if (textField_1.getText().isEmpty()) {
//				 lblError.setText("Please enter class");
//				
//				 }else{
//				
//				 lblError.setText("");
//				
//				 JFileChooser saveFile = new JFileChooser();
//				 saveFile.setSelectedFile(new File(lblClasses.getText() +
//				 ".java"));
//				 saveFile.showSaveDialog(null);
//				
//				 FileCreator fileCreator = new FileCreator();
//				
//				 fileCreator.setFile(saveFile.getSelectedFile());
//				 templateClass.setClassName(lblClasses.getText());
//				
//				
//				 String classTemplate =
//				 ClassCreator.createTemplate(templateClass);
//				
//				 fileCreator.setContent(classTemplate);
//				 fileCreator.write();
//				 }
//
//			}
//		});

		btnNewClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(" add new Class");
				ClassEditor classEditor = new ClassEditor(templateClass,
						_startpage);

			}
		});

		btnCallFunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(" call function");
				CallFunction callFunction = new CallFunction(templateClass,
						_startpage);
			}
		});
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}
	
	public void addClassToPanel(JButton jButton){
		System.out.println("Add class to panel");
		System.out.println(jButton.getText());
		jButton.setPreferredSize(new Dimension(100,100 ));
		panel_2.add(jButton);

		String temp = lblClasses.getText();
		lblClasses.setText(lblClasses.getText() + ": " + jButton.getText());
		lblClasses.setText(temp);
		
	}
	
}