package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfoValue;
import org.bandahealth.idempiere.rest.model.ChargeInformationValue;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ChargeInformationValueDBService extends BaseDBService<ChargeInformationValue, MBHChargeInfoValue> {
	@Override
	public ChargeInformationValue saveEntity(ChargeInformationValue entity) {
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
		chargeInfoValue.setIsActive(entity.getIsActive());

		ModelUtil.setPropertyIfPresent(entity.getDescription(), chargeInfoValue::setDescription);

		chargeInfoValue.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(chargeInfoValue.getBH_Charge_Info_Values_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeInformationValue createInstanceWithDefaultFields(MBHChargeInfoValue instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeInformationValue createInstanceWithAllFields(MBHChargeInfoValue instance) {
		return new ChargeInformationValue(instance);
	}

	@Override
	protected ChargeInformationValue createInstanceWithSearchFields(MBHChargeInfoValue instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHChargeInfoValue getModelInstance() {
		return new MBHChargeInfoValue(Env.getCtx(), 0, null);
	}
}
