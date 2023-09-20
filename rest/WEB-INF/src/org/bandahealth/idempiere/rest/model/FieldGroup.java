package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MFieldGroup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class FieldGroup extends BaseEntity {

	public FieldGroup() {
	}
	
	public FieldGroup(MFieldGroup entity) {
		super(entity, entity.getName(), null, null);
	}
}
