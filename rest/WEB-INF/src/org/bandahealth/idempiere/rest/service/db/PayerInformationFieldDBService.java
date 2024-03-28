package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.rest.model.PayerInformationField;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;

public class PayerInformationFieldDBService extends BaseDBService<PayerInformationField, MBHPayerInfoFld> {
	private final PayerInformationFieldValueDBService payerInformationFieldValueDBService =
			new PayerInformationFieldValueDBService();
	private final ReferenceListDBService referenceListDBService = new ReferenceListDBService();

	@Override
	public PayerInformationField saveEntity(PayerInformationField entity) {
		MBHPayerInfoFld payerInfoField = getEntityByUuidFromDB(entity.getUuid());
		if (payerInfoField == null) {
			payerInfoField = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				payerInfoField.setBH_Payer_Info_Fld_UU(entity.getUuid());
			}
		}
		payerInfoField.setBH_Payer_ID(entity.getPayerId());
		payerInfoField.setBH_FillFromPatient(entity.isShouldFillFromPatient());
		payerInfoField.setLine(entity.getLineNumber());
		payerInfoField.setName(entity.getName());
		payerInfoField.setIsActive(entity.getIsActive());
		if (entity.getDataType() != null) {
			MRefList dataType = referenceListDBService.getEntityByUuidFromDB(entity.getDataType().getUuid());
			if (dataType != null) {
				payerInfoField.setBH_PayerInfoFieldDataType(dataType.getValue());
			}
		}

		ModelUtil.setPropertyIfPresent(entity.getDescription(), payerInfoField::setDescription);

		payerInfoField.saveEx();
		entity.setId(payerInfoField.getBH_Payer_Info_Fld_ID());

		// Save the values, if any
		if (entity.getValues() != null) {
			entity.getValues().forEach(payerInformationFieldValue -> {
				payerInformationFieldValue.setPayerInfoFieldId(entity.getId());
				payerInformationFieldValueDBService.saveEntity(payerInformationFieldValue);
			});
		}

		return createInstanceWithAllFields(getEntityByUuidFromDB(payerInfoField.getBH_Payer_Info_Fld_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected PayerInformationField createInstanceWithDefaultFields(MBHPayerInfoFld instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected PayerInformationField createInstanceWithAllFields(MBHPayerInfoFld instance) {
		return new PayerInformationField(instance);
	}

	@Override
	protected MBHPayerInfoFld getModelInstance() {
		return new MBHPayerInfoFld(Env.getCtx(), 0, null);
	}
}
