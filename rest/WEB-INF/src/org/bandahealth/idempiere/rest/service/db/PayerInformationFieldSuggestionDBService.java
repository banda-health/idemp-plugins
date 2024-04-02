package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldSuggestion;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldValueSuggestion;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PayerInformationFieldSuggestionDBService
		extends BaseDBService<PayerInformationFieldSuggestion, MBHPayerInfoFldSug> {
	private final PayerInformationFieldValueSuggestionDBService payerInformationFieldValueSuggestionDBService =
			new PayerInformationFieldValueSuggestionDBService();
	private final ReferenceListDBService referenceListDBService = new ReferenceListDBService();

	@Override
	public PayerInformationFieldSuggestion saveEntity(PayerInformationFieldSuggestion entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected PayerInformationFieldSuggestion createInstanceWithDefaultFields(MBHPayerInfoFldSug instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected PayerInformationFieldSuggestion createInstanceWithAllFields(MBHPayerInfoFldSug instance) {
		return new PayerInformationFieldSuggestion(instance);
	}

	@Override
	protected MBHPayerInfoFldSug getModelInstance() {
		return new MBHPayerInfoFldSug(Env.getCtx(), 0, null);
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
		return new EntityConfiguration() {{
			setShouldUseContextClientId(true);
			setShouldFetchFromSystemClient(true);
		}};
	}

	@Override
	public List<PayerInformationFieldSuggestion> transformData(List<MBHPayerInfoFldSug> dbModels) {
		Set<Integer> payerInformationFieldSuggestionIds =
				dbModels.stream().map(MBHPayerInfoFldSug::get_ID).collect(Collectors.toSet());
		// Batch call to get payer info field values
		Map<Integer, List<MBHPayerInfoFldValSug>>
				payerInformationFIeldValueSuggestionsByPayerInformationFieldSuggestionId =
				payerInformationFieldValueSuggestionDBService.getGroupsByIds(
						MBHPayerInfoFldValSug::getBH_Payer_Info_Fld_Sug_ID,
						MBHPayerInfoFldValSug.COLUMNNAME_BH_Payer_Info_Fld_Sug_ID,
						payerInformationFieldSuggestionIds);

		// Batch calls to get reference lists for payer info field value suggestions
		Map<String, MRefList> subTypeByValue = referenceListDBService
				.getTypes(MReference_BH.NON_PATIENT_PAYER_AD_REFERENCE_UU,
						dbModels.stream().map(MBHPayerInfoFldSug::getBH_SubType)
								.collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));
		Map<String, MRefList> dataTypesByValue = referenceListDBService
				.getTypes(MReference_BH.PAYER_INFORMATION_FIELD_DATA_TYPE_AD_REFERENCE_UU,
						dbModels.stream().map(MBHPayerInfoFldSug::getBH_PayerInfoFieldDataType)
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
