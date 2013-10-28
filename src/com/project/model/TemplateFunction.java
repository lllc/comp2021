package com.project.model;

import java.util.Arrays;
import java.util.List;

public class TemplateFunction {
	
	public static final class ModifierForPublic {

		public static final int PUBLIC = 0;

		public static final int DEFAULT = 1;

		public static final int PRIVATE = 2;

		public static final int PROTECTED = 3;

		public static final List<Integer> list = Arrays.asList(new Integer[] {
				PUBLIC, DEFAULT, PRIVATE, PROTECTED });
	}



private String name;



private Integer modifierForPublic;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}




public Integer getModifierForPublic() {
	return modifierForPublic;
}

public void setModifierForPublic(Integer modifierForPublic) {
	this.modifierForPublic = modifierForPublic;
}

}

