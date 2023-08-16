package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoField;
import org.bandahealth.idempiere.rest.model.PayerInformationField;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayerInformationFieldDBService extends BaseDBService<PayerInformationField, MBHPayerInfoField> {
	@Autowired
	private PayerInformationFieldValueDBService payerInformationFieldValueDBService;
	@Autowired
	private ReferenceListDBService referenceListDBService;

	@Override
	public PayerInformationField saveEntity(PayerInformationField entity) {
		MBHPayerInfoField payerInfoField = getEntityByUuidFromDB(entity.getUuid());
		if (payerInfoField == null) {
			payerInfoField = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				payerInfoField.setBH_Payer_Info_Field_UU(entity.getUuid());
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
		entity.setId(payerInfoField.getBH_Payer_Info_Field_ID());

		// Save the values, if any
		if (entity.getValues() != null) {
			entity.getValues().forEach(payerInformationFieldValue -> {
				payerInformationFieldValue.setPayerInfoFieldId(entity.getId());
				payerInformationFieldValueDBService.saveEntity(payerInformationFieldValue);
			});
		}

		return createInstanceWithAllFields(getEntityByUuidFromDB(payerInfoField.getBH_Payer_Info_Field_UU()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected PayerInformationField createInstanceWithDefaultFields(MBHPayerInfoField instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected PayerInformationField createInstanceWithAllFields(MBHPayerInfoField instance) {
		return new PayerInformationField(instance);
	}

	@Override
	protected MBHPayerInfoField getModelInstance() {
		return new MBHPayerInfoField(Env.getCtx(), 0, null);
	}
}
