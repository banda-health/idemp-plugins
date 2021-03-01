package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MReference_BH;

public class Reference extends BaseEntity {
	public Reference(MReference_BH model) {
		super(model, model.getDescription(), model.getName(), null);
	}
}
