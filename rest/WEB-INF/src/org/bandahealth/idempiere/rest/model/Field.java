package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MField;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Field extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Reference reference;
	private String defaultValue;
	private String mandatory;
	private String placeholder;
	@JsonIgnore
	private int tabId;
	private FieldGroup fieldGroup;
	private int sequenceNumber;

	public Field() {
	}

	public Field(MField entity) {
		super(entity, entity.getName(), entity.getDescription(), null);

		this.defaultValue = entity.getDefaultValue();
		this.mandatory = entity.getIsMandatory();
		this.placeholder = entity.getPlaceholder();
		this.sequenceNumber = entity.getSeqNo();
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	public int getTabId() {
		return tabId;
	}

	public void setTabId(int tabId) {
		this.tabId = tabId;
	}

	public FieldGroup getFieldGroup() {
		return fieldGroup;
	}

	public void setFieldGroup(FieldGroup fieldGroup) {
		this.fieldGroup = fieldGroup;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
}
