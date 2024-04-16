package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.rest.model.BusinessPartnerSpecificPayerInformation;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

public class BusinessPartnerSpecificPayerInformationDBService
		extends BaseDBService<BusinessPartnerSpecificPayerInformation, MBHBPSpecificPayerInfo> {
	private final PayerInformationFieldDBService payerInformationFieldDBService = new PayerInformationFieldDBService();

	@Override
	public BusinessPartnerSpecificPayerInformation saveEntity(BusinessPartnerSpecificPayerInformation entity) {
		MBHBPSpecificPayerInfo businessPartnerSpecificPaymentInformation = getEntityByUuidFromDB(entity.getUuid());
		if (businessPartnerSpecificPaymentInformation == null) {
			businessPartnerSpecificPaymentInformation = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				businessPartnerSpecificPaymentInformation.setBH_BP_Specific_Payer_Info_UU(entity.getUuid());
			}
		}

		// Set the charge information relationship
		if (entity.getPayerInformationFieldId() > 0) {
			businessPartnerSpecificPaymentInformation.setBH_Payer_Info_Fld_ID(entity.getPayerInformationFieldId());
		} else {
			MBHPayerInfoFld payerInformationField =
					payerInformationFieldDBService.getEntityByUuidFromDB(entity.getPayerInformationFieldUuid());
			if (payerInformationField != null) {
				businessPartnerSpecificPaymentInformation.setBH_Payer_Info_Fld_ID(
						payerInformationField.getBH_Payer_Info_Fld_ID());
			}
		}
		businessPartnerSpecificPaymentInformation.setC_InvoiceLine_ID(entity.getInvoiceLineId());
		businessPartnerSpecificPaymentInformation.setName(entity.getName());
		ModelUtil.setPropertyIfPresent(entity.getDescription(), businessPartnerSpecificPaymentInformation::setDescription);

		businessPartnerSpecificPaymentInformation.saveEx();
		BusinessPartnerSpecificPayerInformation newEntity = createInstanceWithAllFields(
				getEntityByUuidFromDB(businessPartnerSpecificPaymentInformation.getBH_BP_Specific_Payer_Info_UU()));
		newEntity.setPayerInformationFieldUuid(entity.getPayerInformationFieldUuid());
		return newEntity;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return getEntityByUuidFromDB(entityUuid).delete(false);
	}

	@Override
	protected BusinessPartnerSpecificPayerInformation createInstanceWithDefaultFields(MBHBPSpecificPayerInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartnerSpecificPayerInformation createInstanceWithAllFields(MBHBPSpecificPayerInfo instance) {
		return new BusinessPartnerSpecificPayerInformation(instance);
	}

	@Override
	protected MBHBPSpecificPayerInfo getModelInstance() {
		return new MBHBPSpecificPayerInfo(Env.getCtx(), 0, null);
	}
}
