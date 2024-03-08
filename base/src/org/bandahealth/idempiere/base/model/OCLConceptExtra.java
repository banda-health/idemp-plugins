package org.bandahealth.idempiere.base.model;

public class OCLConceptExtra {

	private String key;
	private String value;
	private int conceptId;

	public OCLConceptExtra() {
	}

	public OCLConceptExtra(String key, String value) {
		setKey(key);
		setValue(value);
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

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}

}
