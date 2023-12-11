package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;

@JsonInclude(value = Include.NON_NULL)
public class FieldGroup extends BaseEntity {
	private String abbreviation;

	public FieldGroup() {
	}

	public FieldGroup(MFieldGroup_BH entity) {
		super(entity, entity.getName(), null, null);
		setAbbreviation(entity.getBH_Abbreviation());
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}
