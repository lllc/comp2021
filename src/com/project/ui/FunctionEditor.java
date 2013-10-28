package com.project.ui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import com.project.model.TemplateAttribute;
import com.project.model.TemplateClass;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class FunctionEditor{

	private TemplateClass templateClass;
	private JFrame frame;
	private TemplateAttribute templateAttribute;
	private JTextField textFieldName;
	private JButton btnAdd;
	private ClassEditor _classEditor;
	
	public TemplateClass getTemplateClass() {
		return templateClass;
	}

	public void setTemplateClass(TemplateClass templateClass) {
		this.templateClass = templateClass;
	}

	public static void main(String[] args) {
		try {
			FunctionEditor FunctionEditor = new FunctionEditor();
			FunctionEditor.frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FunctionEditor() {
		templateAttribute = new TemplateAttribute();
		initLayout();
		initButtonAction();
	}
	
	public FunctionEditor(TemplateClass templateClass, ClassEditor classEditor) {
		System.out.println("template class" + templateClass);
		templateAttribute = new TemplateAttribute();
		_classEditor = classEditor;
		this.templateClass = templateClass;
		initLayout();
		initButtonAction();
		this.frame.setVisible(true);
	}
	
	private void initButtonAction(){
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldName.getText().isEmpty() ){
					// output error message
				}else{
					templateAttribute.setName(textFieldName.getText());
					
					
					}
					if (templateClass != null){
						List<TemplateAttribute> attributes = templateClass.getAttributes();
						if (attributes == null){
							attributes = new ArrayList<TemplateAttribute>();
						}
						attributes.add(templateAttribute);
						templateClass.setAttributes(attributes);	
					}
					
					System.out.println("before dispose");
					frame.dispose();
					System.out.println("after dispose");
					_classEditor.refreshAttributes();
					
				}
	
		});
		
	}
	
	private void initLayout() {
		frame = new JFrame();
		frame.setBounds(100, 100, 386, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Function Editor");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(121, 26, 109, 14);
		frame.getContentPane().add(lblTitle);
		
		JCheckBox chckbxStatus = new JCheckBox("public");
		chckbxStatus.setBounds(38, 91, 74, 23);
		frame.getContentPane().add(chckbxStatus);
		
		JCheckBox chckbxPrivate = new JCheckBox("private");
		chckbxPrivate.setBounds(152, 91, 78, 23);
		frame.getContentPane().add(chckbxPrivate);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(37, 128, 46, 14);
		frame.getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(118, 128, 221, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(126, 264, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblOnlyForVoid = new JLabel("Only for void function");
		lblOnlyForVoid.setBounds(37, 63, 214, 16);
		frame.getContentPane().add(lblOnlyForVoid);
	}

}
