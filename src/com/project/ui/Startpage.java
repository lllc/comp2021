package com.project.ui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;

import com.project.model.TemplateClass;
import com.project.util.ClassCreator;
import com.project.util.FileCreator;

public class Startpage {

	private JFrame frame;
	private JButton btnSave;
	private JButton btnNewClass;
	private JButton btnCallFunction;
	private JLabel lblError;
	private TemplateClass templateClass;
	
	private Startpage _startpage;
	
	public static void main(String[] args){
		try {
			Startpage startpage = new Startpage();
			startpage.frame.setVisible(true);
			
		} catch (Exception e){
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
		frame.getContentPane().setLayout(null);
		
		btnNewClass = new JButton("New Class");
		btnNewClass.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnNewClass);
		
		btnCallFunction = new JButton("Call Function");
		btnCallFunction.setBounds(6, 47, 117, 29);
		frame.getContentPane().add(btnCallFunction);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(6, 88, 117, 29);
		frame.getContentPane().add(btnSave);
		
		
	}


private void intiButtonAction() {

btnSave.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
//		if (textField_1.getText().isEmpty()) {
//			lblError.setText("Please enter class name");
//
//		}else{
//			
//			lblError.setText("");
//			
//			JFileChooser saveFile = new JFileChooser();
//			saveFile.setSelectedFile(new File(textField_1.getText() + ".java"));
//			saveFile.showSaveDialog(null);
//			
//			FileCreator fileCreator = new FileCreator();
//			
//			fileCreator.setFile(saveFile.getSelectedFile());
//			templateClass.setClassName(textField_1.getText());
//			templateClass.setPackageName(textField_2.getText());
//
//			String classTemplate = ClassCreator.createTemplate(templateClass);
//			
//			fileCreator.setContent(classTemplate);
//			fileCreator.write();
//		}
		
	}
});

btnNewClass.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(" add new Class");
		ClassEditor classEditor = new ClassEditor(templateClass, _startpage);
		
		
	}
});



btnCallFunction.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(" call function");
//		CallFunction callFunction = new callFunction();
	}
});
}






}