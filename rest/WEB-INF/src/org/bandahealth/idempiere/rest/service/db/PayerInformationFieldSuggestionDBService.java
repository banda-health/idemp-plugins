package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFieldSuggestion;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFieldValueSuggestion;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldSuggestion;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldValueSuggestion;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PayerInformationFieldSuggestionDBService
		extends BaseDBService<PayerInformationFieldSuggestion, MBHPayerInfoFieldSuggestion> {
	@Autowired
	private PayerInformationFieldValueSuggestionDBService payerInformationFieldValueSuggestionDBService;
	@Autowired
	private ReferenceListDBService referenceListDBService;

	@Override
	public PayerInformationFieldSuggestion saveEntity(PayerInformationFieldSuggestion entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected PayerInformationFieldSuggestion createInstanceWithDefaultFields(MBHPayerInfoFieldSuggestion instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected PayerInformationFieldSuggestion createInstanceWithAllFields(MBHPayerInfoFieldSuggestion instance) {
		return new PayerInformationFieldSuggestion(instance);
	}

	@Override
	protected MBHPayerInfoFieldSuggestion getModelInstance() {
		return new MBHPayerInfoFieldSuggestion(Env.getCtx(), 0, null);
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
		return new EntityConfiguration() {{
			setShouldUseContextClientId(true);
			setShouldFetchFromSystemClient(true);
		}};
	}

	@Override
	public List<PayerInformationFieldSuggestion> transformData(List<MBHPayerInfoFieldSuggestion> dbModels) {
		Set<Integer> payerInformationFieldSuggestionIds =
				dbModels.stream().map(MBHPayerInfoFieldSuggestion::get_ID).collect(Collectors.toSet());
		// Batch call to get payer info field values
		Map<Integer, List<MBHPayerInfoFieldValueSuggestion>>
				payerInformationFIeldValueSuggestionsByPayerInformationFieldSuggestionId =
				payerInformationFieldValueSuggestionDBService.getGroupsByIds(
						MBHPayerInfoFieldValueSuggestion::getBH_Payer_Info_Field_Suggestion_ID,
						MBHPayerInfoFieldValueSuggestion.COLUMNNAME_BH_Payer_Info_Field_Suggestion_ID,
						payerInformationFieldSuggestionIds);

		// Batch calls to get reference lists for payer info field value suggestions
		Map<String, MRefList> subTypeByValue = referenceListDBService
				.getTypes(MReference_BH.NON_PATIENT_PAYER_AD_REFERENCE_UU,
						dbModels.stream().map(MBHPayerInfoFieldSuggestion::getBH_SubType)
								.collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));
		Map<String, MRefList> dataTypesByValue = referenceListDBService
				.getTypes(MReference_BH.PAYER_INFORMATION_FIELD_DATA_TYPE_AD_REFERENCE_UU,
						dbModels.stream().map(MBHPayerInfoFieldSuggestion::getBH_PayerInfoFieldDataType)
								.collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		return dbModels.stream().map(payerInformationFieldSuggestion -> {
			PayerInformationFieldSuggestion model = createInstanceWithAllFields(payerInformationFieldSuggestion);
			// Now fill in the batched data
			if (!StringUtil.isNullOrEmpty(model.getSubTypeValue())) {
				model.setSubType(new ReferenceList(subTypeByValue.get(model.getSubTypeValue())));
			}
			if (!StringUtil.isNullOrEmpty(model.getDataTypeValue())) {
				model.setDataType(new ReferenceList(dataTypesByValue.get(model.getDataTypeValue())));
			}
			if (payerInformationFIeldValueSuggestionsByPayerInformationFieldSuggestionId.containsKey(model.getId())) {
				model.setValues(
						payerInformationFIeldValueSuggestionsByPayerInformationFieldSuggestionId.get(model.getId()).stream()
								.map(PayerInformationFieldValueSuggestion::new).collect(Collectors.toList()));
			}
			return model;
		}).collect(Collectors.toList());
	}
}
