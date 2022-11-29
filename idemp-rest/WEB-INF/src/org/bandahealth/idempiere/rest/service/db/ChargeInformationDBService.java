package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.bandahealth.idempiere.rest.model.ChargeInformation;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChargeInformationDBService extends BaseDBService<ChargeInformation, MBHChargeInfo> {
	@Autowired
	private ChargeInformationValueDBService chargeInformationValueDBService;
	@Autowired
	private ReferenceListDBService referenceListDBService;

	@Override
	public ChargeInformation saveEntity(ChargeInformation entity) {
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
		chargeInfo.setIsActive(entity.getIsActive());
		if (entity.getDataType() != null) {
			MRefList dataType = referenceListDBService.getEntityByUuidFromDB(entity.getDataType().getUuid());
			if (dataType != null) {
				chargeInfo.setBH_ChargeInfoDataType(dataType.getValue());
			}
		}

		ModelUtil.setPropertyIfPresent(entity.getDescription(), chargeInfo::setDescription);

		chargeInfo.saveEx();
		entity.setId(chargeInfo.getBH_Charge_Info_ID());

		// Save the values, if any
		if (entity.getValues() != null) {
			entity.getValues().forEach(chargeInfoValue -> {
				chargeInfoValue.setChargeInfoId(entity.getId());
				chargeInformationValueDBService.saveEntity(chargeInfoValue);
			});
		}

		return createInstanceWithAllFields(getEntityByUuidFromDB(chargeInfo.getBH_Charge_Info_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeInformation createInstanceWithDefaultFields(MBHChargeInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeInformation createInstanceWithAllFields(MBHChargeInfo instance) {
		return new ChargeInformation(instance);
	}

	@Override
	protected ChargeInformation createInstanceWithSearchFields(MBHChargeInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHChargeInfo getModelInstance() {
		return new MBHChargeInfo(Env.getCtx(), 0, null);
	}
}
