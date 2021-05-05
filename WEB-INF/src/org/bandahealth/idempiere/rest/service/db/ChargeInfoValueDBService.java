package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfoValue;
import org.bandahealth.idempiere.rest.model.ChargeInfoValue;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

public class ChargeInfoValueDBService extends BaseDBService<ChargeInfoValue, MBHChargeInfoValue> {
	@Override
	public ChargeInfoValue saveEntity(ChargeInfoValue entity) {
		MBHChargeInfoValue chargeInfoValue = getEntityByUuidFromDB(entity.getUuid());
		if (chargeInfoValue == null) {
			chargeInfoValue = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				chargeInfoValue.setBH_Charge_Info_Values_UU(entity.getUuid());
			}
		}
		chargeInfoValue.setName(entity.getName());
		chargeInfoValue.setLine(entity.getLineNumber());
		chargeInfoValue.setBH_Charge_Info_ID(entity.getChargeInfoId());

		ModelUtil.setPropertyIfPresent(entity.getDescription(), chargeInfoValue::setDescription);

		chargeInfoValue.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(chargeInfoValue.getBH_Charge_Info_Values_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeInfoValue createInstanceWithDefaultFields(MBHChargeInfoValue instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeInfoValue createInstanceWithAllFields(MBHChargeInfoValue instance) {
		return new ChargeInfoValue(instance);
	}

	@Override
	protected ChargeInfoValue createInstanceWithSearchFields(MBHChargeInfoValue instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHChargeInfoValue getModelInstance() {
		return new MBHChargeInfoValue(Env.getCtx(), 0, null);
	}
}
