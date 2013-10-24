package com.project.layout;

import java.awt.*;

import javax.swing.*;

public class Form {

	private JPanel formPanel = new JPanel();;
	private JPanel formTitlePanel = new JPanel();;
	private JPanel inputTextPanel = new JPanel();

	private JTextField textfield;
	
	public JPanel getFormPanel() {
		return formPanel;
	}

	public void setFormPanel(JPanel formPanel) {
		this.formPanel = formPanel;
	}

	public JPanel getFormTitlePanel() {
		return formTitlePanel;
	}

	public void setFormTitlePanel(JPanel formTitlePanel) {
		this.formTitlePanel = formTitlePanel;
	}

	public JPanel getInputTextPanel() {
		return inputTextPanel;
	}

	public void setInputTextPanel(JPanel inputTextPanel) {
		this.inputTextPanel = inputTextPanel;
	}

	public Form(String formName) {
		initialize();
		addFormTitle(formName);
	}

	private void initialize() {
		formPanel.setLayout(new GridLayout(6, 0, 20, 20));

		formPanel.add(formTitlePanel);
		formTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		formPanel.add(inputTextPanel);
		inputTextPanel.setLayout(new GridLayout(2, 2, 0, 10));

	}

	public void addInputTextField(String fieldName) {
		JLabel lblNewLabel = new JLabel(fieldName);
		System.out.println(fieldName);
		getInputTextPanel().add(lblNewLabel);

		textfield = new JTextField();
		getInputTextPanel().add(textfield);
		textfield.setColumns(20);
	}

	private void addFormTitle(String formName) {
		JLabel lblClass = new JLabel(formName);
		formTitlePanel.add(lblClass);
	}

}
