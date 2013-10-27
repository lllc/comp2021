package com.project.util;

import com.project.layout.Form;
import com.project.layout.Window;
import com.project.model.TemplateAttribute;
import com.project.model.TemplateClass;

public class ClassCreator {

	public static String createTemplate(TemplateClass templateClass) {
		String temp = "";
		if (!templateClass.getPackageName().isEmpty()) {
			temp += "package " + templateClass.getPackageName() + ";\n";
		}
		if (!templateClass.getClassName().isEmpty()) {
			temp += "public class " + templateClass.getClassName() + " { ";
			temp += "\n";
			temp += "\n";
			for(TemplateAttribute templateAttribute : templateClass.getAttributes()){
				temp += "\tprivate " + templateAttribute.getType() + " "	+ templateAttribute.getName() + ";\n";
			}
			temp += "}";
		}
		return temp;

	}

	// public static void main(String[] args) {
	// try {
	// Window mainPanel = new Window();
	// mainPanel.getFrame().setVisible(true);
	// mainPanel.getFrame().setTitle("Class Creator");
	//
	// Form form = new Form("Form");
	// form.addInputTextField("Class Name");
	// form.addInputTextField("Package Name");
	// mainPanel.getMainPanel().add(form.getFormPanel());
	// // mainPanel.getFrame().getContentPane().add(mainPanel.getMainPanel());
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
