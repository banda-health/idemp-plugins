package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.compiere.model.MProcessPara;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "parameter")
@JsonInclude(value = Include.NON_NULL)
public class ProcessParameter extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int adElementId;
	private int adReferenceId;
	private int adReferenceValueId;
	private int adValueRuleId;
	private String defaultValue;
	private String defaultValue2;
	private String displayLogic;
	private String entityType;
	private int fieldLength;
	private boolean isEncrypted;
	private boolean isMandatory;
	private boolean isRange;
	private String mandatoryLogic;
	private Reference reference;
	private List<ReferenceList> referenceValues = new ArrayList<>();
	private int sequenceNumber;
	private String columnName;

	public ProcessParameter() {
		super();
	}

	public ProcessParameter(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String name, String description, int adElementId, int adReferenceId, int adReferenceValueId,
			int adValueRuleId, String defaultValue, String defaultValue2, String displayLogic, String entityType,
			int fieldLength, boolean isEncrypted, boolean isMandatory, boolean isRange, String mandatoryLogic,
			MProcessPara model) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.adElementId = adElementId;
		this.adReferenceId = adReferenceId;
		this.adReferenceValueId = adReferenceValueId;
		this.adValueRuleId = adValueRuleId;
		this.defaultValue = defaultValue;
		this.defaultValue2 = defaultValue2;
		this.displayLogic = displayLogic;
		this.entityType = entityType;
		this.fieldLength = fieldLength;
		this.isEncrypted = isEncrypted;
		this.isMandatory = isMandatory;
		this.isRange = isRange;
		this.mandatoryLogic = mandatoryLogic;
		setSequenceNumber(model.getSeqNo());
		setColumnName(model.getColumnName());
	}

	public ProcessParameter(MProcessPara model, Reference reference, List<ReferenceList> referenceValues) {
		super(model, model.getName(), model.getDescription(), null);

		this.adElementId = model.getAD_Element_ID();
		this.adReferenceId = model.getAD_Reference_ID();
		this.adReferenceValueId = model.getAD_Reference_Value_ID();
		this.adValueRuleId = model.getAD_Val_Rule_ID();
		this.defaultValue = model.getDefaultValue();
		this.defaultValue2 = model.getDefaultValue2();
		this.displayLogic = model.getDisplayLogic();
		this.entityType = model.getEntityType();
		this.fieldLength = model.getFieldLength();
		this.isEncrypted = model.isEncrypted();
		this.isMandatory = model.isMandatory();
		this.isRange = model.isRange();
		this.mandatoryLogic = model.getMandatoryLogic();
		this.reference = reference;
		this.referenceValues = referenceValues != null ? referenceValues : this.referenceValues;
		setSequenceNumber(model.getSeqNo());
		setColumnName(model.getColumnName());
	}

	@XmlElement
	public int getAdElementId() {
		return adElementId;
	}

	public void setAdElementId(int adElementId) {
		this.adElementId = adElementId;
	}

	@XmlElement
	public int getAdReferenceId() {
		return adReferenceId;
	}

	public void setAdReferenceId(int adReferenceId) {
		this.adReferenceId = adReferenceId;
	}

	@XmlElement
	public int getAdReferenceValueId() {
		return adReferenceValueId;
	}

	public void setAdReferenceValueId(int adReferenceValueId) {
		this.adReferenceValueId = adReferenceValueId;
	}

	@XmlElement
	public int getAdValueRuleId() {
		return adValueRuleId;
	}

	public void setAdValueRuleId(int adValueRuleId) {
		this.adValueRuleId = adValueRuleId;
	}

	@XmlElement
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@XmlElement
	public String getDefaultValue2() {
		return defaultValue2;
	}

	public void setDefaultValue2(String defaultValue2) {
		this.defaultValue2 = defaultValue2;
	}

	@XmlElement
	public String getDisplayLogic() {
		return displayLogic;
	}

	public void setDisplayLogic(String displayLogic) {
		this.displayLogic = displayLogic;
	}

	@XmlElement
	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@XmlElement
	public int getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(int fieldLength) {
		this.fieldLength = fieldLength;
	}

	@XmlElement
	public boolean isEncrypted() {
		return isEncrypted;
	}

	public void setEncrypted(boolean isEncrypted) {
		this.isEncrypted = isEncrypted;
	}

	@XmlElement
	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	@XmlElement
	public boolean isRange() {
		return isRange;
	}

	public void setRange(boolean isRange) {
		this.isRange = isRange;
	}

	@XmlElement
	public String getMandatoryLogic() {
		return mandatoryLogic;
	}

	public void setMandatoryLogic(String mandatoryLogic) {
		this.mandatoryLogic = mandatoryLogic;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public List<ReferenceList> getReferenceValues() {
		return referenceValues;
	}

	public void setReferenceValues(List<ReferenceList> referenceValues) {
		this.referenceValues = referenceValues;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}
