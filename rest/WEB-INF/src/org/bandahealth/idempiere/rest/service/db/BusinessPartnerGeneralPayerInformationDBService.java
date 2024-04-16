package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.rest.model.BusinessPartnerGeneralPayerInformation;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

public class BusinessPartnerGeneralPayerInformationDBService
		extends BaseDBService<BusinessPartnerGeneralPayerInformation, MBHBPGeneralPayerInfo> {
	private final PayerInformationFieldDBService payerInformationFieldDBService = new PayerInformationFieldDBService();

	@Override
	public BusinessPartnerGeneralPayerInformation saveEntity(BusinessPartnerGeneralPayerInformation entity) {
		MBHBPGeneralPayerInfo businessPartnerGeneralPaymentInformation = getEntityByUuidFromDB(entity.getUuid());
		if (businessPartnerGeneralPaymentInformation == null) {
			businessPartnerGeneralPaymentInformation = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				businessPartnerGeneralPaymentInformation.setBH_BP_General_Payer_Info_UU(entity.getUuid());
			}
		}

		// Set the charge information relationship
		if (entity.getPayerInformationFieldId() > 0) {
			businessPartnerGeneralPaymentInformation.setBH_Payer_Info_Fld_ID(entity.getPayerInformationFieldId());
		} else {
			MBHPayerInfoFld paymentInformationField =
					payerInformationFieldDBService.getEntityByUuidFromDB(entity.getPayerInformationFieldUuid());
			if (paymentInformationField != null) {
				businessPartnerGeneralPaymentInformation.setBH_Payer_Info_Fld_ID(
						paymentInformationField.getBH_Payer_Info_Fld_ID());
			}
		}
		businessPartnerGeneralPaymentInformation.setBH_BP_Payer_Info_ID(entity.getBusinessPartnerPayerInformationId());
		businessPartnerGeneralPaymentInformation.setName(entity.getName());
		ModelUtil.setPropertyIfPresent(entity.getDescription(), businessPartnerGeneralPaymentInformation::setDescription);

		businessPartnerGeneralPaymentInformation.saveEx();
		BusinessPartnerGeneralPayerInformation newEntity = createInstanceWithAllFields(
				getEntityByUuidFromDB(businessPartnerGeneralPaymentInformation.getBH_BP_General_Payer_Info_UU()));
		newEntity.setPayerInformationFieldUuid(entity.getPayerInformationFieldUuid());
		return newEntity;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return getEntityByUuidFromDB(entityUuid).delete(false);
	}

	@Override
	protected BusinessPartnerGeneralPayerInformation createInstanceWithDefaultFields(MBHBPGeneralPayerInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartnerGeneralPayerInformation createInstanceWithAllFields(MBHBPGeneralPayerInfo instance) {
		return new BusinessPartnerGeneralPayerInformation(instance);
	}

	@Override
	protected MBHBPGeneralPayerInfo getModelInstance() {
		return new MBHBPGeneralPayerInfo(Env.getCtx(), 0, null);
	}
}
