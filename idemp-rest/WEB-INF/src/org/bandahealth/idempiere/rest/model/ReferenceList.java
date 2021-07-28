package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MRefList;

public class ReferenceList extends BaseEntity {
	/**
	 * Empty constructor needed for deserialization
	 */
	public ReferenceList() {}

	public ReferenceList(MRefList model) {
		super(model, model.getName(), model.getDescription(), model.getValue());
	}
}
