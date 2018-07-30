package com.wonder5.yanyigraph.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AnyClassObject {
	private String key;
	private String value;

	public AnyClassObject(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}