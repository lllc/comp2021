package com.project.util;

import com.project.model.TemplateAttribute;
import com.project.model.TemplateClass;
import com.project.model.TemplateFunction;


public class ClassCreator{

	public static String createTemplate(TemplateClass templateClass) {
		String temp = "";
		if (!templateClass.getPackageName().isEmpty()) {
			temp += "package " + templateClass.getPackageName() + ";\n";
		}
		if (!templateClass.getClassName().isEmpty()) {
			if (templateClass.getModifierForPublic() != null){
				if (templateClass.getModifierForPublic() == TemplateClass.ModifierForPublic.PUBLIC ){
					temp += "public ";
				}else if (templateClass.getModifierForPublic() == TemplateClass.ModifierForPublic.PRIVATE ){
					temp += "private ";
				}else if (templateClass.getModifierForPublic() == TemplateClass.ModifierForPublic.PROTECTED){
					temp += "protected ";
				}
				
			}
			
			if (templateClass.getModifierForAbstract() != null){
				if (templateClass.getModifierForAbstract() == TemplateClass.ModifierForAbstract.ABSTRACT ){
					temp += "abstract ";
				}else if (templateClass.getModifierForAbstract() == TemplateClass.ModifierForAbstract.FINAL ){
					temp += "final ";
				}else if (templateClass.getModifierForAbstract() == TemplateClass.ModifierForAbstract.STATIC){
					temp += "static ";
				}

			}

					
			temp +=	" class " + templateClass.getClassName() + " ";
			if (!templateClass.getSuperclass().isEmpty()){
				temp += "extends " + templateClass.getSuperclass() + " ";
			}
			temp += " { ";
			temp += "\n";
			temp += "\n";
			for(TemplateAttribute templateAttribute : templateClass.getAttributes()){
				temp += "\tprivate " + templateAttribute.getType() + " "	+ templateAttribute.getName() + ";\n";
			}
			if (templateClass.getCreateMain()){
				temp += "\tpublic static void main(String[] args){";
				temp += "\n";
				temp += "\t}";
				temp += "\n";
			}
			
			
			for(TemplateFunction templateFunction : templateClass.getFunction()){
				temp += "\n";
				if (templateFunction.getModifierForPublic() == TemplateFunction.ModifierForPublic.PUBLIC){
					temp += "\tpublic ";
				}else if(templateFunction.getModifierForPublic() == TemplateFunction.ModifierForPublic.PRIVATE){
					temp += "\tprivate ";
				}
				temp +=  "void " + templateFunction.getName() + "(){" + "\n" +"\t}";
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
