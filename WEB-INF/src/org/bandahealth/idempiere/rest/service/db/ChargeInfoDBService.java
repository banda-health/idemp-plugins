package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.bandahealth.idempiere.rest.model.ChargeInfo;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

public class ChargeInfoDBService extends BaseDBService<ChargeInfo, MBHChargeInfo> {
	private final ChargeInfoValueDBService chargeInfoValueDBService;

	public ChargeInfoDBService() {
		chargeInfoValueDBService = new ChargeInfoValueDBService();
	}

	@Override
	public ChargeInfo saveEntity(ChargeInfo entity) {
		MBHChargeInfo chargeInfo = getEntityByUuidFromDB(entity.getUuid());
		if (chargeInfo == null) {
			chargeInfo = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				chargeInfo.setBH_Charge_Info_UU(entity.getUuid());
			}
		}
		chargeInfo.setC_Charge_ID(entity.getChargeId());
		chargeInfo.setBH_FillFromPatient(entity.isShouldFillFromPatient());
		chargeInfo.setLine(entity.getLineNumber());
		chargeInfo.setName(entity.getName());
		if (entity.getDataType() != null) {
			chargeInfo.setBH_ChargeInfoDataType(entity.getDataType().getValue());
		}

		ModelUtil.setPropertyIfPresent(entity.getDescription(), chargeInfo::setDescription);

		chargeInfo.saveEx();

		// Save the values, if any
		if (entity.getValues() != null) {
			entity.getValues().forEach(chargeInfoValue -> {
				chargeInfoValue.setChargeInfoId(entity.getId());
				chargeInfoValueDBService.saveEntity(chargeInfoValue);
			});
		}

		return createInstanceWithAllFields(getEntityByUuidFromDB(chargeInfo.getBH_Charge_Info_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeInfo createInstanceWithDefaultFields(MBHChargeInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeInfo createInstanceWithAllFields(MBHChargeInfo instance) {
		return new ChargeInfo(instance);
	}

	@Override
	protected ChargeInfo createInstanceWithSearchFields(MBHChargeInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHChargeInfo getModelInstance() {
		return new MBHChargeInfo(Env.getCtx(), 0, null);
	}
}
