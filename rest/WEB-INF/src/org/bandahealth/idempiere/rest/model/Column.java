package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Column extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String columnName;
	@JsonIgnore
	private int tableId;
	private Reference reference;
	private Reference referenceValue;
	private String defaultValue;
	private boolean mandatory;
	private int sequenceNumber;
	private String placeholder;

	public Column() {
	}

	public Column(MColumn entity) {
		super(entity, entity.getName(), entity.getDescription(), null);

		this.defaultValue = entity.getDefaultValue();
		this.mandatory = entity.isMandatory();
		this.placeholder = entity.getPlaceholder();
		this.sequenceNumber = entity.getSeqNo();
		this.tableId = entity.get_Table_ID();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public Reference getReferenceValue() {
		return referenceValue;
	}

	public void setReferenceValue(Reference referenceValue) {
		this.referenceValue = referenceValue;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
}
