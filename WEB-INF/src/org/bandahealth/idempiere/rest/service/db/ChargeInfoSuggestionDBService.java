package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.bandahealth.idempiere.base.model.MBHChargeInfoSuggestion;
import org.bandahealth.idempiere.base.model.MBHChargeInfoValue;
import org.bandahealth.idempiere.base.model.MBHChargeInfoValueSuggestion;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.model.Account;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.ChargeInfo;
import org.bandahealth.idempiere.rest.model.ChargeInfoSuggestion;
import org.bandahealth.idempiere.rest.model.ChargeInfoValue;
import org.bandahealth.idempiere.rest.model.ChargeInfoValueSuggestion;
import org.bandahealth.idempiere.rest.model.ChargeType;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MRefList;
import org.compiere.model.PO;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ChargeInfoSuggestionDBService extends BaseDBService<ChargeInfoSuggestion, MBHChargeInfoSuggestion> {
	private final ChargeInfoValueSuggestionDBService chargeInfoValueSuggestionDBService;
	private final ReferenceListDBService referenceListDBService;

	public ChargeInfoSuggestionDBService() {
		chargeInfoValueSuggestionDBService = new ChargeInfoValueSuggestionDBService();
		referenceListDBService = new ReferenceListDBService();
	}

	public List<ChargeInfoSuggestion> get() {
		List<ChargeInfoSuggestion> chargeInfoSuggestions =
				super.getAll(null, null, Paging.ALL.getInstance(), null, null, null).getResults();
		if (chargeInfoSuggestions == null) {
			return new ArrayList<>();
		}

		Set<Integer> chargeInfoSuggestionIds =
				chargeInfoSuggestions.stream().map(ChargeInfoSuggestion::getId).collect(Collectors.toSet());
		// Batch call to get charge info values
		Map<Integer, List<MBHChargeInfoValueSuggestion>> chargeInfoValueSuggestionsByChargeInfoSuggestion =
				chargeInfoValueSuggestionDBService.getGroupsByIds(MBHChargeInfoValueSuggestion::getBH_Charge_Info_Suggestion_ID,
						MBHChargeInfoValueSuggestion.COLUMNNAME_BH_Charge_Info_Suggestion_ID, chargeInfoSuggestionIds);

		// Batch calls to get reference lists for charge info suggestions
		Map<String, MRefList> subTypeByValue = referenceListDBService
				.getTypes(MReference_BH.NON_PATIENT_PAYMENT_AD_REFERENCE_UU,
						chargeInfoSuggestions.stream().map(ChargeInfoSuggestion::getSubTypeValue).collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));
		Map<String, MRefList> dataTypesByValue = referenceListDBService
				.getTypes(MReference_BH.CHARGE_INFO_DATA_TYPE_AD_REFERENCE_UU,
						chargeInfoSuggestions.stream().map(ChargeInfoSuggestion::getDataTypeValue).collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		return chargeInfoSuggestions.stream().peek(chargeInfoSuggestion -> {
			// Now fill in the batched data
			if (!StringUtil.isNullOrEmpty(chargeInfoSuggestion.getSubTypeValue())) {
				chargeInfoSuggestion.setSubType(new ReferenceList(subTypeByValue.get(chargeInfoSuggestion.getSubTypeValue())));
			}
			if (!StringUtil.isNullOrEmpty(chargeInfoSuggestion.getDataTypeValue())) {
				chargeInfoSuggestion
						.setDataType(new ReferenceList(dataTypesByValue.get(chargeInfoSuggestion.getDataTypeValue())));
			}
			if (chargeInfoValueSuggestionsByChargeInfoSuggestion.containsKey(chargeInfoSuggestion.getId())) {
				chargeInfoSuggestion.setValues(
						chargeInfoValueSuggestionsByChargeInfoSuggestion.get(chargeInfoSuggestion.getId()).stream()
								.map(ChargeInfoValueSuggestion::new).collect(Collectors.toList()));
			}
		}).collect(Collectors.toList());
	}

	@Override
	public ChargeInfoSuggestion saveEntity(ChargeInfoSuggestion entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeInfoSuggestion createInstanceWithDefaultFields(MBHChargeInfoSuggestion instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeInfoSuggestion createInstanceWithAllFields(MBHChargeInfoSuggestion instance) {
		return new ChargeInfoSuggestion(instance);
	}

	@Override
	protected ChargeInfoSuggestion createInstanceWithSearchFields(MBHChargeInfoSuggestion instance) {
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
