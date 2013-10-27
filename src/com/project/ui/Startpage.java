package com.project.ui;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Startpage {

	private JFrame frame;
	
	public static void main(String[] args){
		Startpage startpage = new Startpage();
		
	}
	
	public Startpage(){
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
