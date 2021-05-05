package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.bandahealth.idempiere.base.model.MBHChargeInfoValue;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.model.Account;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.ChargeInfo;
import org.bandahealth.idempiere.rest.model.ChargeInfoValue;
import org.bandahealth.idempiere.rest.model.ChargeType;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MRefList;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ChargeDBService extends BaseDBService<Charge, MCharge_BH> {
	private final AccountDBService accountDBService;
	private final ChargeTypeDBService chargeTypeDBService;
	private final ChargeInfoDBService chargeInfoDBService;
	private final ChargeInfoValueDBService chargeInfoValueDBService;
	private final ReferenceListDBService referenceListDBService;

	public ChargeDBService() {
		accountDBService = new AccountDBService();
		chargeTypeDBService = new ChargeTypeDBService();
		chargeInfoDBService = new ChargeInfoDBService();
		chargeInfoValueDBService = new ChargeInfoValueDBService();
		referenceListDBService = new ReferenceListDBService();
	}

	public BaseListResponse<Charge> getNonPatientPayments(Paging pagingInfo, String sortColumn, String sortOrder,
			String filterJson) {
		String whereClause = MChargeType_BH.Table_Name + "." + MChargeType_BH.COLUMNNAME_Name + "=?";
		List<Object> parameters = new ArrayList<>() {{
			add(MChargeType_BH.CHARGETYPENAME_NON_PATIENT_PAYMENT);
		}};
		String joinClause = "JOIN " + MChargeType_BH.Table_Name + " ON " + MChargeType_BH.Table_Name + "." +
				MChargeType_BH.COLUMNNAME_C_ChargeType_ID + "=" + MCharge_BH.Table_Name + "." +
				MCharge_BH.COLUMNNAME_C_ChargeType_ID;
		return super.getAll(whereClause, parameters, pagingInfo, sortColumn, sortOrder, filterJson, joinClause);
	}

	@Override
	public Charge saveEntity(Charge entity) {
		// Save to the DB
		MCharge_BH charge = getEntityByUuidFromDB(entity.getUuid());
		if (charge == null) {
			charge = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				charge.setC_Charge_UU(entity.getUuid());
			}
		}

		ModelUtil.setPropertyIfPresent(entity.getName(), charge::setName);
		ModelUtil.setPropertyIfPresent(entity.getDescription(), charge::setDescription);

		if (entity.getAccount() != null) {
			MElementValue account = accountDBService.getEntityByUuidFromDB(entity.getAccount().getUuid());
			if (account != null) {
				charge.setC_ElementValue_ID(account.getC_ElementValue_ID());
			}
		}

		charge.setIsActive(entity.getIsActive());

		if (entity.getChargeType() != null) {
			MChargeType_BH chargeType = chargeTypeDBService.getEntityByUuidFromDB(entity.getChargeType().getUuid());
			if (chargeType != null) {
				charge.setC_ChargeType_ID(chargeType.getC_ChargeType_ID());
			}
		}

		charge.saveEx();

		// If it has info & values, we need to update those
		if (entity.getChargeInfoList() != null) {
			entity.getChargeInfoList().forEach(chargeInfo -> {
				chargeInfo.setChargeId(entity.getId());
				chargeInfoDBService.saveEntity(chargeInfo);
			});
		}

		return transformData(Collections.singletonList(getEntityByUuidFromDB(charge.getC_Charge_UU()))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected Charge createInstanceWithDefaultFields(MCharge_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Charge createInstanceWithAllFields(MCharge_BH instance) {
		return new Charge(instance);
	}

	@Override
	protected Charge createInstanceWithSearchFields(MCharge_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MCharge_BH getModelInstance() {
		return new MCharge_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<Charge> transformData(List<MCharge_BH> dbModels) {
		if (dbModels == null) {
			return new ArrayList<>();
		}
		Set<Integer> chargeIds = dbModels.stream().map(MCharge_BH::getC_Charge_ID).collect(Collectors.toSet());
		// Batch call to get charge info
		Map<Integer, List<MBHChargeInfo>> chargeInfoByCharge = chargeInfoDBService
				.getGroupsByIds(MBHChargeInfo::getC_Charge_ID, MBHChargeInfo.COLUMNNAME_C_Charge_ID, chargeIds);

		// Batch call to get accounts
		Map<Integer, MElementValue> accountsById =
				accountDBService.getByIds(dbModels.stream().map(MCharge_BH::getC_ElementValue_ID).collect(Collectors.toSet()));

		// Batch call to get charge info values
		Set<Integer> chargeInfoIds = chargeInfoByCharge.values().stream()
				.flatMap(chargeInfoList -> chargeInfoList.stream().map(MBHChargeInfo::getBH_Charge_Info_ID))
				.collect(Collectors.toSet());
		Map<Integer, List<MBHChargeInfoValue>> chargeInfoValueListsByChargeInfo = chargeInfoValueDBService
				.getGroupsByIds(MBHChargeInfoValue::getBH_Charge_Info_ID, MBHChargeInfoValue.COLUMNNAME_BH_Charge_Info_ID,
						chargeInfoIds);

		// Batch call to get charge types
		Map<Integer, MChargeType_BH> chargeTypesById =
				chargeTypeDBService.getByIds(dbModels.stream().map(MCharge_BH::getC_ChargeType_ID).collect(Collectors.toSet()));

		// Batch call to get reference lists for charges
		Map<String, MRefList> subTypeByValue = referenceListDBService
				.getTypes(MReference_BH.NON_PATIENT_PAYMENT_AD_REFERENCE_UU,
						dbModels.stream().map(MCharge_BH::getBH_SubType).collect(Collectors.toSet())).stream()
				.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		// Batch call to get reference lists for charge info
		Map<String, MRefList> dataTypesByValue = referenceListDBService
				.getTypes(MReference_BH.CHARGE_INFO_DATA_TYPE_AD_REFERENCE_UU, chargeInfoByCharge.values().stream()
						.flatMap(chargeInfoList -> chargeInfoList.stream().map(MBHChargeInfo::getBH_ChargeInfoDataType))
						.collect(Collectors.toSet())).stream()
				.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		return dbModels.stream().map(charge -> {
			Charge chargeToReturn = createInstanceWithAllFields(charge);

			// Now fill in the child data
			chargeToReturn.setChargeType(new ChargeType(chargeTypesById.get(charge.getC_ChargeType_ID())));
			if (!StringUtil.isNullOrEmpty(charge.getBH_SubType())) {
				chargeToReturn.setSubType(new ReferenceList(subTypeByValue.get(charge.getBH_SubType())));
			}
			if (chargeInfoByCharge.containsKey(charge.get_ID())) {
				chargeToReturn.setChargeInfoList(chargeInfoByCharge.get(charge.getC_Charge_ID()).stream().map(chargeInfo -> {
					ChargeInfo chargeInfoToReturn = new ChargeInfo(chargeInfo);

					// Now fill in the child data
					if (!StringUtil.isNullOrEmpty(chargeInfo.getBH_ChargeInfoDataType())) {
						chargeInfoToReturn
								.setDataType(new ReferenceList(dataTypesByValue.get(chargeInfo.getBH_ChargeInfoDataType())));
					}
					if (chargeInfoValueListsByChargeInfo.containsKey(chargeInfo.get_ID())) {
						chargeInfoToReturn.setValues(
								chargeInfoValueListsByChargeInfo.get(chargeInfo.get_ID()).stream().map(ChargeInfoValue::new)
										.collect(Collectors.toList()));
					}

					return chargeInfoToReturn;
				}).collect(Collectors.toList()));
			}
			if (accountsById.containsKey(charge.getC_ElementValue_ID())) {
				chargeToReturn.setAccount(new Account(accountsById.get(charge.getC_ElementValue_ID())));
			}

			return chargeToReturn;
		}).collect(Collectors.toList());
	}
}
