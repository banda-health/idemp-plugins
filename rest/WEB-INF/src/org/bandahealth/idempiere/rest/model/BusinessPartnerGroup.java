package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.compiere.model.MBPGroup;

public class BusinessPartnerGroup extends BaseEntity {
	@JsonIgnore
	private String subTypeValue;
	private ReferenceList subType;

	public BusinessPartnerGroup() {}

	public BusinessPartnerGroup(MBPGroup_BH entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());
		setSubTypeValue(entity.getBH_SubType());
	}

	@JsonIgnore
	public String getSubTypeValue() {
		return subTypeValue;
	}

	@JsonIgnore
	public void setSubTypeValue(String subTypeValue) {
		this.subTypeValue = subTypeValue;
	}

	public ReferenceList getSubType() {
		return subType;
	}

	public void setSubType(ReferenceList subType) {
		this.subType = subType;
	}
}
