package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFieldValue;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldValue;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class PayerInformationFieldValueDBService extends BaseDBService<PayerInformationFieldValue, MBHPayerInfoFieldValue> {
	@Override
	public PayerInformationFieldValue saveEntity(PayerInformationFieldValue entity) {
		MBHPayerInfoFieldValue payerInfoFieldValue = getEntityByUuidFromDB(entity.getUuid());
		if (payerInfoFieldValue == null) {
			payerInfoFieldValue = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				payerInfoFieldValue.setBH_Payer_Info_Field_Value_UU(entity.getUuid());
			}
		}
		payerInfoFieldValue.setName(entity.getName());
		payerInfoFieldValue.setLine(entity.getLineNumber());
		payerInfoFieldValue.setBH_Payer_Info_Field_ID(entity.getPayerInfoFieldId());
		payerInfoFieldValue.setIsActive(entity.getIsActive());

		ModelUtil.setPropertyIfPresent(entity.getDescription(), payerInfoFieldValue::setDescription);

		payerInfoFieldValue.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(payerInfoFieldValue.getBH_Payer_Info_Field_Value_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected PayerInformationFieldValue createInstanceWithDefaultFields(MBHPayerInfoFieldValue instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected PayerInformationFieldValue createInstanceWithAllFields(MBHPayerInfoFieldValue instance) {
		return new PayerInformationFieldValue(instance);
	}

	@Override
	protected MBHPayerInfoFieldValue getModelInstance() {
		return new MBHPayerInfoFieldValue(Env.getCtx(), 0, null);
	}
}
