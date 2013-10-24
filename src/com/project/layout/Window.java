package com.project.layout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;

public class Window {

	private JFrame frame;

	private Panel mainPanel;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Panel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(Panel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public Window() {
		initialize();
	}

	/**
	 * Initialize the default contents of the frame.
	 */
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
	}

}
