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

public class AttributeEditor{

	private TemplateClass templateClass;
	private JFrame frame;
	private TemplateAttribute templateAttribute;
	private JTextField textFieldName;
	private JTextField textFieldType;
	private JTextField textFieldLength;
	private JButton btnAdd;
	
	public TemplateClass getTemplateClass() {
		return templateClass;
	}

	public void setTemplateClass(TemplateClass templateClass) {
		this.templateClass = templateClass;
	}

	public static void main(String[] args) {
		try {
			AttributeEditor attributeEditor = new AttributeEditor();
			attributeEditor.frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AttributeEditor() {
		templateAttribute = new TemplateAttribute();
		initLayout();
		initButtonAction();
	}
	
	public AttributeEditor(TemplateClass templateClass) {
		System.out.println("template class" + templateClass);
		templateAttribute = new TemplateAttribute();
		this.templateClass = templateClass;
		initLayout();
		initButtonAction();
		this.frame.setVisible(true);
	}
	
	private void initButtonAction(){
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldName.getText().isEmpty() && textFieldType.getText().isEmpty()){
					// output error message
				}else{
					templateAttribute.setName(textFieldName.getText());
					templateAttribute.setType(textFieldType.getText());
					if (!textFieldLength.getText().isEmpty()){
						templateAttribute.setLength(Integer.getInteger(textFieldLength.getText()));
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

				}
			}
		});
		
		
	}
	
	private void initLayout() {
		frame = new JFrame();
		frame.setBounds(100, 100, 386, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Attribute Editor");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(121, 26, 109, 14);
		frame.getContentPane().add(lblTitle);
		
		JCheckBox chckbxStatus = new JCheckBox("public");
		chckbxStatus.setBounds(38, 59, 74, 23);
		frame.getContentPane().add(chckbxStatus);
		
		JCheckBox chckbxPrivate = new JCheckBox("private");
		chckbxPrivate.setBounds(152, 59, 78, 23);
		frame.getContentPane().add(chckbxPrivate);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(37, 108, 46, 14);
		frame.getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(118, 108, 221, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(38, 148, 46, 14);
		frame.getContentPane().add(lblType);
		
		textFieldType = new JTextField();
		textFieldType.setColumns(10);
		textFieldType.setBounds(119, 148, 221, 20);
		frame.getContentPane().add(textFieldType);
		
		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(38, 199, 46, 14);
		frame.getContentPane().add(lblLength);
		
		textFieldLength = new JTextField();
		textFieldLength.setColumns(10);
		textFieldLength.setBounds(119, 199, 221, 20);
		frame.getContentPane().add(textFieldLength);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(126, 264, 89, 23);
		frame.getContentPane().add(btnAdd);
	}

}
