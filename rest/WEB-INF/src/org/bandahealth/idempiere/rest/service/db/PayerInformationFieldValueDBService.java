package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldValue;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

public class PayerInformationFieldValueDBService extends BaseDBService<PayerInformationFieldValue, MBHPayerInfoFldVal> {
	@Override
	public PayerInformationFieldValue saveEntity(PayerInformationFieldValue entity) {
		MBHPayerInfoFldVal payerInfoFieldValue = getEntityByUuidFromDB(entity.getUuid());
		if (payerInfoFieldValue == null) {
			payerInfoFieldValue = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				payerInfoFieldValue.setBH_Payer_Info_Fld_Val_UU(entity.getUuid());
			}
		}
		payerInfoFieldValue.setName(entity.getName());
		payerInfoFieldValue.setLine(entity.getLineNumber());
		payerInfoFieldValue.setBH_Payer_Info_Fld_ID(entity.getPayerInfoFieldId());
		payerInfoFieldValue.setIsActive(entity.getIsActive());

		ModelUtil.setPropertyIfPresent(entity.getDescription(), payerInfoFieldValue::setDescription);

		payerInfoFieldValue.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(payerInfoFieldValue.getBH_Payer_Info_Fld_Val_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected PayerInformationFieldValue createInstanceWithDefaultFields(MBHPayerInfoFldVal instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected PayerInformationFieldValue createInstanceWithAllFields(MBHPayerInfoFldVal instance) {
		return new PayerInformationFieldValue(instance);
	}

	@Override
	protected MBHPayerInfoFldVal getModelInstance() {
		return new MBHPayerInfoFldVal(Env.getCtx(), 0, null);
	}
}
