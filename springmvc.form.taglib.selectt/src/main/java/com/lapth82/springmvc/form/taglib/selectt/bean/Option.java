package com.lapth82.springmvc.form.taglib.selectt.bean;

public class Option {

	private String  itemValue;
	
	private String  itemLabel;

	public Option() {}
	
	public Option(String value, String label) {
		this.itemValue = value;
		this.itemLabel = label;
	}
	
	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getItemLabel() {
		return itemLabel;
	}

	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}
}
