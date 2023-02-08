package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfoSuggestion;
import org.bandahealth.idempiere.base.model.MBHChargeInfoValueSuggestion;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.ChargeInformationSuggestion;
import org.bandahealth.idempiere.rest.model.ChargeInformationValueSuggestion;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ChargeInformationSuggestionDBService
		extends BaseDBService<ChargeInformationSuggestion, MBHChargeInfoSuggestion> {
	@Autowired
	private ChargeInformationValueSuggestionDBService chargeInformationValueSuggestionDBService;
	@Autowired
	private ReferenceListDBService referenceListDBService;

	@Override
	public ChargeInformationSuggestion saveEntity(ChargeInformationSuggestion entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
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

	@Override
	public List<ChargeInformationSuggestion> transformData(List<MBHChargeInfoSuggestion> dbModels) {
		Set<Integer> chargeInfoSuggestionIds =
				dbModels.stream().map(MBHChargeInfoSuggestion::get_ID).collect(Collectors.toSet());
		// Batch call to get charge info values
		Map<Integer, List<MBHChargeInfoValueSuggestion>> chargeInfoValueSuggestionsByChargeInfoSuggestion =
				chargeInformationValueSuggestionDBService.getGroupsByIds(
						MBHChargeInfoValueSuggestion::getBH_Charge_Info_Suggestion_ID,
						MBHChargeInfoValueSuggestion.COLUMNNAME_BH_Charge_Info_Suggestion_ID, chargeInfoSuggestionIds);

		// Batch calls to get reference lists for charge info suggestions
		Map<String, MRefList> subTypeByValue = referenceListDBService
				.getTypes(MReference_BH.NON_PATIENT_PAYMENT_AD_REFERENCE_UU,
						dbModels.stream().map(MBHChargeInfoSuggestion::getBH_SubType)
								.collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));
		Map<String, MRefList> dataTypesByValue = referenceListDBService
				.getTypes(MReference_BH.CHARGE_INFORMATION_DATA_TYPE_AD_REFERENCE_UU,
						dbModels.stream().map(MBHChargeInfoSuggestion::getBH_ChargeInfoDataType)
								.collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		return dbModels.stream().map(chargeInformationSuggestion -> {
			ChargeInformationSuggestion model = createInstanceWithAllFields(chargeInformationSuggestion);
			// Now fill in the batched data
			if (!StringUtil.isNullOrEmpty(model.getSubTypeValue())) {
				model.setSubType(new ReferenceList(subTypeByValue.get(model.getSubTypeValue())));
			}
			if (!StringUtil.isNullOrEmpty(model.getDataTypeValue())) {
				model.setDataType(new ReferenceList(dataTypesByValue.get(model.getDataTypeValue())));
			}
			if (chargeInfoValueSuggestionsByChargeInfoSuggestion.containsKey(model.getId())) {
				model.setValues(chargeInfoValueSuggestionsByChargeInfoSuggestion.get(model.getId()).stream()
						.map(ChargeInformationValueSuggestion::new).collect(Collectors.toList()));
			}
			return model;
		}).collect(Collectors.toList());
	}
}
