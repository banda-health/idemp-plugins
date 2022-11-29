package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHBPartnerChargeInfo;
import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.bandahealth.idempiere.rest.model.BusinessPartnerChargeInformation;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessPartnerChargeInformationDBService
		extends BaseDBService<BusinessPartnerChargeInformation, MBHBPartnerChargeInfo> {
	@Autowired
	private ChargeInformationDBService chargeInformationDBService;

	@Override
	public BusinessPartnerChargeInformation saveEntity(BusinessPartnerChargeInformation entity) {
		MBHBPartnerChargeInfo businessPartnerChargeInformation = getEntityByUuidFromDB(entity.getUuid());
		if (businessPartnerChargeInformation == null) {
			businessPartnerChargeInformation = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				businessPartnerChargeInformation.setBH_BPartner_Charge_Info_UU(entity.getUuid());
			}
		}

		// Set the charge information relationship
		if (entity.getChargeInformationId() > 0) {
			businessPartnerChargeInformation.setBH_Charge_Info_ID(entity.getChargeInformationId());
		} else {
			MBHChargeInfo chargeInformation =
					chargeInformationDBService.getEntityByUuidFromDB(entity.getChargeInformationUuid());
			if (chargeInformation != null) {
				businessPartnerChargeInformation.setBH_Charge_Info_ID(chargeInformation.getBH_Charge_Info_ID());
			}
		}
		businessPartnerChargeInformation.setBH_BPartner_Charge_ID(entity.getBusinessPartnerChargeId());
		businessPartnerChargeInformation.setName(entity.getName());
		ModelUtil.setPropertyIfPresent(entity.getDescription(), businessPartnerChargeInformation::setDescription);

		businessPartnerChargeInformation.saveEx();
		BusinessPartnerChargeInformation newEntity = createInstanceWithAllFields(
				getEntityByUuidFromDB(businessPartnerChargeInformation.getBH_BPartner_Charge_Info_UU()));
		newEntity.setChargeInformationUuid(entity.getChargeInformationUuid());
		return newEntity;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return getEntityByUuidFromDB(entityUuid).delete(false);
	}

	@Override
	protected BusinessPartnerChargeInformation createInstanceWithDefaultFields(MBHBPartnerChargeInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartnerChargeInformation createInstanceWithAllFields(MBHBPartnerChargeInfo instance) {
		return new BusinessPartnerChargeInformation(instance);
	}

	@Override
	protected BusinessPartnerChargeInformation createInstanceWithSearchFields(MBHBPartnerChargeInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHBPartnerChargeInfo getModelInstance() {
		return new MBHBPartnerChargeInfo(Env.getCtx(), 0, null);
	}
}
