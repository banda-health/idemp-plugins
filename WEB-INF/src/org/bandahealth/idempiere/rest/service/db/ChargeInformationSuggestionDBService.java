package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfoSuggestion;
import org.bandahealth.idempiere.base.model.MBHChargeInfoValueSuggestion;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.model.ChargeInformationSuggestion;
import org.bandahealth.idempiere.rest.model.ChargeInformationValueSuggestion;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ChargeInformationSuggestionDBService extends BaseDBService<ChargeInformationSuggestion, MBHChargeInfoSuggestion> {
	private final ChargeInformationValueSuggestionDBService chargeInformationValueSuggestionDBService;
	private final ReferenceListDBService referenceListDBService;

	public ChargeInformationSuggestionDBService() {
		chargeInformationValueSuggestionDBService = new ChargeInformationValueSuggestionDBService();
		referenceListDBService = new ReferenceListDBService();
	}

	public List<ChargeInformationSuggestion> get() {
		List<ChargeInformationSuggestion> chargeInformationSuggestions =
				super.getAll(null, null, Paging.ALL.getInstance(), null, null, null).getResults();
		if (chargeInformationSuggestions == null) {
			return new ArrayList<>();
		}

		Set<Integer> chargeInfoSuggestionIds =
				chargeInformationSuggestions.stream().map(ChargeInformationSuggestion::getId).collect(Collectors.toSet());
		// Batch call to get charge info values
		Map<Integer, List<MBHChargeInfoValueSuggestion>> chargeInfoValueSuggestionsByChargeInfoSuggestion =
				chargeInformationValueSuggestionDBService.getGroupsByIds(MBHChargeInfoValueSuggestion::getBH_Charge_Info_Suggestion_ID,
						MBHChargeInfoValueSuggestion.COLUMNNAME_BH_Charge_Info_Suggestion_ID, chargeInfoSuggestionIds);

		// Batch calls to get reference lists for charge info suggestions
		Map<String, MRefList> subTypeByValue = referenceListDBService
				.getTypes(MReference_BH.NON_PATIENT_PAYMENT_AD_REFERENCE_UU,
						chargeInformationSuggestions.stream().map(ChargeInformationSuggestion::getSubTypeValue).collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));
		Map<String, MRefList> dataTypesByValue = referenceListDBService
				.getTypes(MReference_BH.CHARGE_INFO_DATA_TYPE_AD_REFERENCE_UU,
						chargeInformationSuggestions.stream().map(ChargeInformationSuggestion::getDataTypeValue).collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		return chargeInformationSuggestions.stream().peek(chargeInformationSuggestion -> {
			// Now fill in the batched data
			if (!StringUtil.isNullOrEmpty(chargeInformationSuggestion.getSubTypeValue())) {
				chargeInformationSuggestion.setSubType(new ReferenceList(subTypeByValue.get(chargeInformationSuggestion.getSubTypeValue())));
			}
			if (!StringUtil.isNullOrEmpty(chargeInformationSuggestion.getDataTypeValue())) {
				chargeInformationSuggestion
						.setDataType(new ReferenceList(dataTypesByValue.get(chargeInformationSuggestion.getDataTypeValue())));
			}
			if (chargeInfoValueSuggestionsByChargeInfoSuggestion.containsKey(chargeInformationSuggestion.getId())) {
				chargeInformationSuggestion.setValues(
						chargeInfoValueSuggestionsByChargeInfoSuggestion.get(chargeInformationSuggestion.getId()).stream()
								.map(ChargeInformationValueSuggestion::new).collect(Collectors.toList()));
			}
		}).collect(Collectors.toList());
	}

	@Override
	public ChargeInformationSuggestion saveEntity(ChargeInformationSuggestion entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeInformationSuggestion createInstanceWithDefaultFields(MBHChargeInfoSuggestion instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeInformationSuggestion createInstanceWithAllFields(MBHChargeInfoSuggestion instance) {
		return new ChargeInformationSuggestion(instance);
	}

	@Override
	protected ChargeInformationSuggestion createInstanceWithSearchFields(MBHChargeInfoSuggestion instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHChargeInfoSuggestion getModelInstance() {
		return new MBHChargeInfoSuggestion(Env.getCtx(), 0, null);
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
