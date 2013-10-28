package com.project.ui;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.project.model.TemplateAttribute;
import com.project.model.TemplateClass;
import com.project.model.TemplateFunction;

import javax.swing.JComboBox;

public class CallFunction {
	private JFrame frame;
	private TemplateClass templateClass;
	private JButton btnOK;
	private Startpage _startpage;
	private List<TemplateClass> _classes = new ArrayList<TemplateClass>();
	private JComboBox comboBoxTo;
	private JComboBox comboBoxFrom;
	private JComboBox comboBoxMethod;
	private JTextField textFieldMethod;

	public TemplateClass getTemplateClass() {
		return templateClass;
	}

	public void setTemplateClass(TemplateClass templateClass) {
		this.templateClass = templateClass;
	}

	public static void main(String[] args) {
		try {

			TemplateClass c1 = new TemplateClass();
			c1.setClassName("c1");
			TemplateFunction f1 = new TemplateFunction();
			f1.setName("f1");
			TemplateFunction f2 = new TemplateFunction();
			f1.setName("f2");
			List<TemplateFunction> fs = new ArrayList<TemplateFunction>();
			fs.add(f1);
			fs.add(f2);
			c1.setFunction(fs);
			
			
			TemplateClass c2 = new TemplateClass();
			c2.setClassName("c2");
			TemplateFunction f3 = new TemplateFunction();
			f1.setName("f3");
			TemplateFunction f4 = new TemplateFunction();
			f1.setName("f4");
			
			List<TemplateFunction> fs2 = new ArrayList<TemplateFunction>();
			fs2.add(f3);
			fs2.add(f4);
			
			c2.setFunction(fs2);
			
			List<TemplateClass> cs = new ArrayList<TemplateClass>();
			cs.add(c1);
			cs.add(c2);

			CallFunction callfuction = new CallFunction(c1, new Startpage(), cs);
			callfuction.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CallFunction() {
		templateClass = new TemplateClass();
		initialize();
		initButtonAction();
	}

	public CallFunction(TemplateClass templateClass, Startpage startpage,
			List<TemplateClass> classes) {
		System.out.println("template class" + templateClass);
		templateClass = new TemplateClass();
		_startpage = startpage;
		this.templateClass = templateClass;
		initialize();
		initButtonAction();
		this.frame.setVisible(true);
		List<String> classNames = new ArrayList<String>();
		for (TemplateClass c : classes) {
			classNames.add(c.getClassName());
			System.out.println(c.getClassName());
		}
		_classes = classes;
		comboBoxFrom = new JComboBox(classNames.toArray());
		comboBoxFrom.setBounds(170, 66, 122, 27);
		frame.getContentPane().add(comboBoxFrom);

		comboBoxFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("******" + comboBoxFrom.getSelectedItem());
				TemplateClass selectedClass = null;
				for (TemplateClass c : _classes) {
					if (c.getClassName().equals(comboBoxFrom.getSelectedItem())) {
						selectedClass = c;
						break;
					}
				}
				List<String> functionNames = new ArrayList<String>();
				if (selectedClass != null) {
					System.out.println("selected");
					for (TemplateFunction f : selectedClass.getFunction()) {
						functionNames.add(f.getName());
					}

					comboBoxMethod = new JComboBox(functionNames.toArray());
					comboBoxMethod.setBounds(170, 111, 122, 27);
					frame.getContentPane().add(comboBoxMethod);
				}

			}
		});

		comboBoxTo = new JComboBox(classNames.toArray());
		comboBoxTo.setBounds(170, 156, 122, 27);
		frame.getContentPane().add(comboBoxTo);
		
		textFieldMethod = new JTextField();
		textFieldMethod.setBounds(170, 109, 134, 28);
		frame.getContentPane().add(textFieldMethod);
		textFieldMethod.setColumns(10);
	}

	private void initButtonAction() {
		// btnOK.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		//
		//
		// }
		//
		// });

	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		frame.getContentPane().setLayout(null);

		JLabel lblMethodName = new JLabel("Method Name");
		lblMethodName.setBounds(35, 115, 97, 16);
		frame.getContentPane().add(lblMethodName);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(35, 70, 61, 16);
		frame.getContentPane().add(lblFrom);

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(35, 160, 61, 16);
		frame.getContentPane().add(lblTo);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
			}
		});
		btnOk.setBounds(144, 220, 117, 29);
		frame.getContentPane().add(btnOk);

		// comboBoxFrom = new JComboBox();
		// comboBoxFrom.setBounds(170, 66, 122, 27);
		// frame.getContentPane().add(comboBoxFrom);

		// comboBoxMethod = new JComboBox();
		// comboBoxMethod.setBounds(170, 111, 122, 27);
		// frame.getContentPane().add(comboBoxMethod);
		//
		// comboBoxTo = new JComboBox();
		// comboBoxTo.setBounds(170, 156, 122, 27);
		// frame.getContentPane().add(comboBoxTo);
		//

	}
}