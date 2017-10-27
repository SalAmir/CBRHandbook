package ru.cbr.helper;

public class FieldList {

	private String nameField = "";
	private String display = "";
	private String original = "";

	public FieldList(String nameField, String display, String original) {
		this.nameField = nameField;
		this.display = display;
		this.original = original;
	}

	public FieldList(String nameField, String original) {
		this.nameField = nameField;
		this.original = original;
	}

	public String getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField = nameField;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getOriginalNameByDisplay(String displayName) {
		if (this.display.equals(displayName))
			return original;
		return "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameField == null) ? 0 : nameField.hashCode());
		result = prime * result + ((original == null) ? 0 : original.hashCode());
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		FieldList other = (FieldList) obj;
		if (nameField == null) {
			if (other.nameField != null)
				return false;
		} 
		else if (!nameField.equals(other.nameField))
			return false;

		if (display == null) {
			if (other.display != null)
				return false;
		}
		else if (!display.equals(other.display.trim()))
			return false;

		if (original == null) {
			if (other.original != null)
				return false;
		}
		else if (!original.equals(other.original.trim()))
			return false;

		return true;
	}
}
