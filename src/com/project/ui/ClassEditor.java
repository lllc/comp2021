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

import com.project.model.TemplateAttribute;
import com.project.model.TemplateClass;
import com.project.util.ClassCreator;
import com.project.util.FileCreator;
import java.awt.Color;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class ClassEditor {

	private JFrame frame;
	private JTextField textField_1;
	private JLabel lblClass;
	private JPanel formPanel;
	private JLabel lblPackageName;
	private JTextField textField_2;
	private Panel previewPanel;
	private JLabel lblPreivew;
	private Panel mainPanel;
	private JTextArea textArea;
	private JLabel lblError;

	private TemplateClass templateClass;
	private JButton btnAddAttribute;
	private JLabel lblAttributes;
	private JButton btnRefresh;
	
	private ClassEditor _classEditor;
	private Startpage _startpage;
	private JLabel lblModifier;
	private JCheckBox chckbxAbstract;
	private JCheckBox chckbxFinal;
	private JCheckBox chckbxPublic;
	private JCheckBox chckbxPrivate;
	private JCheckBox chckbxMethodMain;
	private JLabel lblSuperclass;
	private JButton btnPreview;
	private JButton btnCreate;
	private JTextField textFieldSuperclass;
	private JButton btnAddFunction;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClassEditor classEditor = new ClassEditor();
			classEditor.frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ClassEditor() {
		templateClass = new TemplateClass();
		_classEditor = this;
		initLayout();
		intiButtonAction();
	}

	public ClassEditor(TemplateClass templateClass, Startpage startpage) {
		System.out.println("template class" + templateClass);
		templateClass = new TemplateClass();
		_startpage = startpage;
		this.templateClass = templateClass;
		initLayout();
		intiButtonAction();
		this.frame.setVisible(true);
		
	}
	
	private void processTemplateClass(){
		templateClass.setClassName(textField_1.getText());
		templateClass.setPackageName(textField_2.getText());
		templateClass.setSuperclass(textFieldSuperclass.getText());
		
		if (chckbxPublic.isSelected()){
			templateClass.setModifierForPublic(TemplateClass.ModifierForPublic.PUBLIC);
		}else if (chckbxPrivate.isSelected()){
			templateClass.setModifierForPublic(TemplateClass.ModifierForPublic.PRIVATE);
		}else{
			templateClass.setModifierForPublic(null);
		}
		
		
		if (chckbxAbstract.isSelected()){
			templateClass.setModifierForAbstract(TemplateClass.ModifierForAbstract.ABSTRACT);
		}else if (chckbxFinal.isSelected()){
			templateClass.setModifierForAbstract(TemplateClass.ModifierForAbstract.FINAL);
		}else{
			templateClass.setModifierForAbstract(null);
		}
		
		if (chckbxMethodMain.isSelected()){
			templateClass.setCreateMain(true);
		}else{
			templateClass.setCreateMain(false);
		}
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

					processTemplateClass();
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
					
					processTemplateClass();
					String classTemplate = ClassCreator.createTemplate(templateClass);
					textArea.setText(classTemplate);
					
					JButton newClass = new JButton();
					newClass.setText(templateClass.getClassName());
					System.out.println("new class: " + templateClass.getClassName());
					if (_startpage != null){
						_startpage.addClassToPanel(newClass);
					}
					
				}
			}
		});
		
		btnAddAttribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("add attribute");
				AttributeEditor attributeEditor = new AttributeEditor(templateClass, _classEditor);
				
			}
		});
		
		btnAddFunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("add function");
				FunctionEditor functionEditor = new FunctionEditor(templateClass, _classEditor);
				
			}
		});
		
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshAttributes();
			}
		});

	}

	public void refreshAttributes(){
		System.out.println("refresh attribute list");
		String attributeNames = "";
		for (TemplateAttribute templateAttribute : templateClass.getAttributes()){
			attributeNames += templateAttribute.getName() + ", ";
		}
		lblAttributes.setText(attributeNames);
	}
	
	private void initLayout() {
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 743);
		frame.getContentPane().setLayout(null);
		
		lblClass = new JLabel("Class Creator");
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setBounds(62, 0, 684, 20);
		frame.getContentPane().add(lblClass);

		lblError = new JLabel("");
		lblError.setBounds(62, 21, 684, 20);
		frame.getContentPane().add(lblError);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);

		mainPanel = new Panel();
		mainPanel.setBounds(62, 50, 684, 584);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 2, 20, 0));

		formPanel = new JPanel();
		mainPanel.add(formPanel);
		formPanel.setLayout(new GridLayout(1, 0, 10, 10));

		JPanel inputTextPanel = new JPanel();
		formPanel.add(inputTextPanel);
		inputTextPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Class Name");
		lblNewLabel.setBounds(0, 11, 98, 20);
		inputTextPanel.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(108, 11, 224, 20);
		inputTextPanel.add(textField_1);
		textField_1.setColumns(20);

		lblPackageName = new JLabel("Package Name");
		lblPackageName.setBounds(0, 42, 98, 20);
		inputTextPanel.add(lblPackageName);

		textField_2 = new JTextField();
		textField_2.setBounds(108, 42, 224, 20);
		inputTextPanel.add(textField_2);
		textField_2.setColumns(20);
		
		lblModifier = new JLabel("Modifier");
		lblModifier.setBounds(0, 73, 98, 20);
		inputTextPanel.add(lblModifier);
		
		chckbxPublic = new JCheckBox("public");
		chckbxPublic.setBounds(108, 72, 97, 23);
		inputTextPanel.add(chckbxPublic);
		
		chckbxPrivate = new JCheckBox("private");
		chckbxPrivate.setBounds(207, 72, 97, 23);
		inputTextPanel.add(chckbxPrivate);
		
		chckbxAbstract = new JCheckBox("abstract");
		chckbxAbstract.setBounds(108, 100, 87, 20);
		inputTextPanel.add(chckbxAbstract);
		
		chckbxFinal = new JCheckBox("Final");
		chckbxFinal.setBounds(207, 100, 87, 20);
		inputTextPanel.add(chckbxFinal);
		
		lblSuperclass = new JLabel("Superclass");
		lblSuperclass.setBounds(0, 138, 98, 20);
		inputTextPanel.add(lblSuperclass);
		
		textFieldSuperclass = new JTextField();
		textFieldSuperclass.setBounds(108, 138, 224, 20);
		inputTextPanel.add(textFieldSuperclass);
		textFieldSuperclass.setColumns(10);
		
		btnRefresh = new JButton("refresh");
		btnRefresh.setBounds(136, 271, 100, 20);
		inputTextPanel.add(btnRefresh);
		
		btnAddAttribute = new JButton("Add Attribute");
		btnAddAttribute.setBounds(0, 271, 126, 20);
		inputTextPanel.add(btnAddAttribute);
		
		lblAttributes = new JLabel("Attributes: ");
		lblAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblAttributes.setBounds(10, 301, 322, 114);
		inputTextPanel.add(lblAttributes);
		
		JLabel lblMethod = new JLabel("Method");
		lblMethod.setBounds(0, 181, 98, 20);
		inputTextPanel.add(lblMethod);
		
		chckbxMethodMain = new JCheckBox("public static void main(String[] args)");
		chckbxMethodMain.setBounds(29, 203, 280, 23);
		inputTextPanel.add(chckbxMethodMain);
		
		btnAddFunction = new JButton("Add Function");
		btnAddFunction.setBounds(0, 376, 117, 29);
		inputTextPanel.add(btnAddFunction);

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
		
		btnPreview = new JButton("Preview");
		btnPreview.setBounds(318, 650, 120, 23);
		frame.getContentPane().add(btnPreview);
		
		btnCreate = new JButton("Save");
		btnCreate.setBounds(452, 650, 120, 23);
		frame.getContentPane().add(btnCreate);
	}
}
