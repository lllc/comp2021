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





public class CallFunction {
	private JFrame frame;
	private TemplateClass templateClass;
	private JTextField txtMethodname;
	private JTextField txtFromclass;
	private JTextField txtToclass;
	private JButton btnOK; 
	private Startpage _startpage;
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public TemplateClass getTemplateClass() {
		return templateClass;
	}

	public void setTemplateClass(TemplateClass templateClass) {
		this.templateClass = templateClass;
	}
	
	public static void main(String[] args) {
		try {
			CallFunction callfuction = new CallFunction();
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
	public CallFunction(TemplateClass templateClass, Startpage startpage) {
		System.out.println("template class" + templateClass);
		templateClass = new TemplateClass();
		_startpage = startpage;
		this.templateClass = templateClass;
		initialize();
		initButtonAction();
		this.frame.setVisible(true);
	}
	
	private void initButtonAction(){
//		btnOK.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//					
//				}
//			
//		});
		
		
	}
	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JLabel lblMethodName = new JLabel("Method Name");
		lblMethodName.setBounds(35, 70, 97, 16);
		frame.getContentPane().add(lblMethodName);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(35, 115, 61, 16);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(35, 160, 61, 16);
		frame.getContentPane().add(lblTo);
		
		txtMethodname = new JTextField();
		txtMethodname.setText("");
		txtMethodname.setBounds(144, 64, 134, 28);
		frame.getContentPane().add(txtMethodname);
		txtMethodname.setColumns(10);
		
		txtFromclass = new JTextField();
		txtFromclass.setText("");
		txtFromclass.setBounds(144, 109, 134, 28);
		frame.getContentPane().add(txtFromclass);
		txtFromclass.setColumns(10);
		
		txtToclass = new JTextField();
		txtToclass.setText("");
		txtToclass.setBounds(144, 154, 134, 28);
		frame.getContentPane().add(txtToclass);
		txtToclass.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(144, 220, 117, 29);
		frame.getContentPane().add(btnOk);
	

	
	
	}
}