package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MChargeType_BH;

public class ChargeType extends BaseEntity{
	public ChargeType(MChargeType_BH entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());
	}
}
