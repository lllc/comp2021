package com.project.ui;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.project.model.TemplateClass;
import com.project.util.ClassCreator;
import com.project.util.FileCreator;
import java.awt.Color;
import java.io.File;

public class window {

	private JFrame frame;
	private JTextField textField_1;
	private JPanel formTitlePanel;
	private JLabel lblClass;
	private JPanel formPanel;
	private JLabel lblPackageName;
	private JTextField textField_2;
	private JPanel errorPanel;
	private JPanel inputTextPanel3;
	private JPanel panel_btn;
	private JButton btnCreate;
	private JButton btnPreview;
	private Panel previewPanel;
	private JLabel lblPreivew;
	private Panel mainPanel;
	private JTextArea textArea;
	private JLabel lblError;

	private TemplateClass templateClass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			window window = new window();
			window.frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public window() {
		templateClass = new TemplateClass();
		initialize();
		intiButtonAction();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void intiButtonAction() {

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_1.getText().isEmpty()) {
					lblError.setText("Please enter class name");

				}else{
					
					lblError.setText("");
					
					JFileChooser saveFile = new JFileChooser();
					saveFile.setSelectedFile(new File(textField_1.getText() + ".java"));
					saveFile.showSaveDialog(null);
					
					FileCreator fileCreator = new FileCreator();
					
					fileCreator.setFile(saveFile.getSelectedFile());
					templateClass.setClassName(textField_1.getText());
					templateClass.setPackageName(textField_2.getText());

					String classTemplate = ClassCreator.createTemplate(templateClass);
					
					fileCreator.setContent(classTemplate);
					fileCreator.write();
				}
				
			}
		});

		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().isEmpty()) {
					lblError.setText("Please enter class name");

				} else {
					lblError.setText("");
					templateClass.setClassName(textField_1.getText());
					templateClass.setPackageName(textField_2.getText());
					String classTemplate = ClassCreator.createTemplate(templateClass);
					textArea.setText(classTemplate);
				}
			}
		});

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flowLayout_2 = new FlowLayout(FlowLayout.CENTER, 0, 0);
		flowLayout_2.setAlignOnBaseline(true);
		frame.getContentPane().setLayout(flowLayout_2);

		mainPanel = new Panel();
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 2, 20, 0));

		formPanel = new JPanel();
		mainPanel.add(formPanel);
		formPanel.setLayout(new GridLayout(6, 0, 20, 20));

		formTitlePanel = new JPanel();
		formPanel.add(formTitlePanel);
		formTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblClass = new JLabel("Class Creator");
		formTitlePanel.add(lblClass);

		errorPanel = new JPanel();
		formPanel.add(errorPanel);

		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		errorPanel.add(lblError);

		JPanel inputTextPanel = new JPanel();
		formPanel.add(inputTextPanel);
		inputTextPanel.setLayout(new GridLayout(2, 2, 0, 10));

		JLabel lblNewLabel = new JLabel("Class Name");
		inputTextPanel.add(lblNewLabel);

		textField_1 = new JTextField();
		inputTextPanel.add(textField_1);
		textField_1.setColumns(20);

		lblPackageName = new JLabel("Package Name");
		inputTextPanel.add(lblPackageName);

		textField_2 = new JTextField();
		inputTextPanel.add(textField_2);
		textField_2.setColumns(20);

		inputTextPanel3 = new JPanel();
		formPanel.add(inputTextPanel3);

		panel_btn = new JPanel();
		formPanel.add(panel_btn);

		btnCreate = new JButton("Save");

		btnPreview = new JButton("Preview");

		panel_btn.add(btnPreview);
		panel_btn.add(btnCreate);

		previewPanel = new Panel();
		previewPanel.setPreferredSize(new Dimension(100, 100));
		previewPanel.setMaximumSize(new Dimension(500, 32767));
		mainPanel.add(previewPanel);
		previewPanel.setLayout(null);

		lblPreivew = new JLabel("Preivew");
		lblPreivew.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreivew.setBounds(0, 0, 332, 37);
		previewPanel.add(lblPreivew);

		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(0, 35, 332, 365);
		previewPanel.add(textArea);
	}

}
