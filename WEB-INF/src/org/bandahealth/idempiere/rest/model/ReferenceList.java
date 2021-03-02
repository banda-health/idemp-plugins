package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MRefList;

public class ReferenceList extends BaseEntity {
	public ReferenceList(MRefList model) {
		super(model, model.getDescription(), model.getName(), model.getValue());
	}
}
