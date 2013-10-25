package com.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemplateClass implements Serializable {
	
	public static final class ModifierForPublic {

		public static final int PUBLIC = 0;

		public static final int DEFAULT = 1;

		public static final int PRIVATE = 2;

		public static final int PROTECTED = 3;

		public static final List<Integer> list = Arrays.asList(new Integer[] {
				PUBLIC, DEFAULT, PRIVATE, PROTECTED });
	}

	public static final class ModifierForAbstract {

		public static final int ABSTRACT = 0;

		public static final int FINAL = 1;
		
		public static final int STATIC = 2;

		public static final List<Integer> list = Arrays.asList(new Integer[] {
				ABSTRACT, FINAL, STATIC });
	}
	
	private String className;
	
	private String packageName;
	
	private Boolean createMain = false;
	
	private Integer modifierForPublic;
	
	private Integer modifierForAbstract;
	
	private String superclass;
	
	private List<TemplateAttribute> attributes = new ArrayList<TemplateAttribute>();

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Boolean getCreateMain() {
		return createMain;
	}

	public void setCreateMain(Boolean createMain) {
		this.createMain = createMain;
	}

	public Integer getModifierForPublic() {
		return modifierForPublic;
	}

	public void setModifierForPublic(Integer modifierForPublic) {
		this.modifierForPublic = modifierForPublic;
	}

	public Integer getModifierForAbstract() {
		return modifierForAbstract;
	}

	public void setModifierForAbstract(Integer modifierForAbstract) {
		this.modifierForAbstract = modifierForAbstract;
	}

	public String getSuperclass() {
		return superclass;
	}

	public void setSuperclass(String superclass) {
		this.superclass = superclass;
	}

	public List<TemplateAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<TemplateAttribute> attributes) {
		this.attributes = attributes;
	}
	
	
}
