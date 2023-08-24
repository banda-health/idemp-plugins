package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.BusinessPartnerGroup;
import org.bandahealth.idempiere.rest.model.PayerInformationField;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldValue;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.I_C_Location;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCountry;
import org.compiere.model.MLocation;
import org.compiere.model.MRefList;
import org.compiere.model.MRegion;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BusinessPartnerDBService extends BaseDBService<BusinessPartner, MBPartner_BH> {
	@Autowired
	private PayerInformationFieldDBService payerInformationFieldDBService;
	@Autowired
	private PayerInformationFieldValueDBService payerInformationFieldValueDBService;
	@Autowired
	private ReferenceListDBService referenceListDBService;
	@Autowired
	private BusinessPartnerGroupDBService businessPartnerGroupDBService;
	@Autowired
	private BusinessPartnerLocationDBService businessPartnerLocationDBService;
	@Autowired
	private LocationDBService locationDBService;

	private final Map<String, String> dynamicJoins = new HashMap<>() {{
		put(MOrder_BH.Table_Name, "LEFT JOIN (" + "SELECT " + MOrder_BH.COLUMNNAME_C_BPartner_ID
				+ ",MAX(" + MOrder_BH.COLUMNNAME_DateOrdered + ") as " + MOrder_BH.COLUMNNAME_DateOrdered + " FROM "
				+ MOrder_BH.Table_Name + " WHERE " + MOrder_BH.COLUMNNAME_IsSOTrx + "='Y' GROUP BY "
				+ MOrder_BH.COLUMNNAME_C_BPartner_ID + ") AS " + MOrder_BH.Table_Name + " ON " + MOrder_BH.Table_Name + "."
				+ MOrder_BH.COLUMNNAME_C_BPartner_ID + "=" + MBPartner_BH.Table_Name + "."
				+ MBPartner_BH.COLUMNNAME_C_BPartner_ID);
	}};

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	@Override
	public BusinessPartner saveEntity(BusinessPartner entity) {
		MBPartner_BH businessPartner = getEntityByUuidFromDB(entity.getUuid());
		if (businessPartner == null) {
			businessPartner = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				businessPartner.setC_BPartner_UU(entity.getUuid());
			}
		}

		businessPartner.setIsCustomer(entity.getCustomer());
		businessPartner.setIsVendor(entity.getVendor());

		if (StringUtil.isNotNullAndEmpty(entity.getName())) {
			businessPartner.setName(entity.getName());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getPatientNumber())) {
			businessPartner.setBH_PatientID(entity.getPatientNumber());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getDateOfBirth())) {
			businessPartner.setBH_Birthday(DateUtil.getTimestamp(entity.getDateOfBirth()));
		}

		if (StringUtil.isNotNullAndEmpty(entity.getPhone())) {
			businessPartner.setBH_Phone(entity.getPhone());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
			businessPartner.setDescription(entity.getDescription());
		}

		I_C_Location clientLocation = MOrgInfo_BH.get(Env.getCtx(), Env.getAD_Org_ID(Env.getCtx())).getC_Location();
		String locationWhereClause = "";
		List<Object> parameters = new ArrayList<>();
		if (clientLocation.getC_Country_ID() > 0) {
			locationWhereClause += MLocation.COLUMNNAME_C_Country_ID + "=?";
			parameters.add(clientLocation.getC_Country_ID());
		}
		if (clientLocation.getC_Region_ID() > 0) {
			locationWhereClause += (!locationWhereClause.isEmpty() ? " AND " : "") + MLocation.COLUMNNAME_C_Region_ID + "=?";
			parameters.add(clientLocation.getC_Region_ID());
		}
		if (!StringUtil.isNullOrEmpty(entity.getAddress())) {
			locationWhereClause += (!locationWhereClause.isEmpty() ? " AND " : "") + MLocation.COLUMNNAME_Address1 + "=?";
			parameters.add(entity.getAddress());
		}
		MLocation location =
				new Query(Env.getCtx(), MLocation.Table_Name, locationWhereClause, null).setParameters(parameters)
						.setClient_ID().first();
		if (location == null) {
			location = new MLocation(
					clientLocation.getC_Country_ID() > 0 ? MCountry.get(Env.getCtx(), clientLocation.getC_Country_ID()) : null,
					clientLocation.getC_Region_ID() > 0 ? MRegion.get(Env.getCtx(), clientLocation.getC_Region_ID()) : null);
			location.saveEx();
		}
		if (StringUtil.isNotNullAndEmpty(entity.getAddress())) {
			location.setAddress1(entity.getAddress());
			location.saveEx();
		}

		if (StringUtil.isNotNullAndEmpty(entity.getGender())) {
			businessPartner.setbh_gender(entity.getGender());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getEmail())) {
			businessPartner.setBH_EMail(entity.getEmail());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getNationalId())) {
			businessPartner.setNationalID(entity.getNationalId());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getOccupation())) {
			businessPartner.setbh_occupation(entity.getOccupation());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getNextOfKinName())) {
			businessPartner.setNextOfKin_Name(entity.getNextOfKinName());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getNextOfKinContact())) {
			businessPartner.setNextOfKin_Contact(entity.getNextOfKinContact());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getLocalPatientNumber())) {
			businessPartner.setBH_Local_PatientID(entity.getLocalPatientNumber());
		}

		if (entity.isApproximateDateOfBirth() != null) {
			businessPartner.setBH_IsApproximateDateOfBirth(entity.isApproximateDateOfBirth());
		}

		if (entity.getBusinessPartnerGroup() != null &&
				!StringUtil.isNullOrEmpty(entity.getBusinessPartnerGroup().getUuid())) {
			MBPGroup_BH businessPartnerGroup =
					businessPartnerGroupDBService.getEntityByUuidFromDB(entity.getBusinessPartnerGroup().getUuid());
			if (businessPartnerGroup != null) {
				businessPartner.setC_BP_Group_ID(businessPartnerGroup.getC_BP_Group_ID());
			}
		}

		businessPartner.setIsActive(entity.getIsActive());
		businessPartner.setBH_NeedAdditionalVisitInfo(entity.isNeedAdditionalVisitInformation());

		businessPartner.saveEx();
		entity.setId(businessPartner.get_ID());

		// Add a BP location, if there aren't any
		if (businessPartner.getLocations(false).length == 0) {
			MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(Env.getCtx(), 0, null);
			businessPartnerLocation.setAD_Org_ID(0);
			businessPartnerLocation.setC_BPartner_ID(businessPartner.get_ID());
			businessPartnerLocation.setC_Location_ID(location.get_ID());
			businessPartnerLocation.setName("Default Location");
			businessPartnerLocation.saveEx();
		}

		// If it has info & values, we need to update those
		if (entity.getPayerInformationFieldList() != null) {
			entity.getPayerInformationFieldList().forEach(payerInformationField -> {
				payerInformationField.setPayerId(entity.getId());
				payerInformationFieldDBService.saveEntity(payerInformationField);
			});
		}

		return transformData(Collections.singletonList(getEntityByUuidFromDB(businessPartner.getC_BPartner_UU()))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected BusinessPartner createInstanceWithDefaultFields(MBPartner_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartner createInstanceWithAllFields(MBPartner_BH instance) {
		return new BusinessPartner(instance);
	}

	@Override
	protected MBPartner_BH getModelInstance() {
		return new MBPartner_BH(Env.getCtx(), 0, null);
	}

	@Override
	public BusinessPartner getEntity(String uuid) {
		return transformData(Collections.singletonList(getEntityByUuidFromDB(uuid))).get(0);
	}

	@Override
	public List<BusinessPartner> transformData(List<MBPartner_BH> dbModels) {
		Set<Integer> businessPartnerIds = dbModels.stream().map(MBPartner_BH::get_ID).collect(Collectors.toSet());
		Set<Integer> businessPartnerGroupIds = dbModels.stream().map(MBPartner_BH::getC_BP_Group_ID)
				.filter(businessPartnerGroupId -> businessPartnerGroupId > 0).collect(Collectors.toSet());

		Map<Integer, Integer> visitsCount = VisitDBService.getVisitCountsByPatients(businessPartnerIds);
		Map<Integer, String> lastVisitDateByPatientId = VisitDBService.getLastVisitDateByPatients(businessPartnerIds);

		// Batch calls
		Map<Integer, BusinessPartnerGroup> businessPartnerGroupsById = businessPartnerGroupDBService.transformData(
						new ArrayList<>(businessPartnerGroupDBService.getByIds(businessPartnerGroupIds).values())).stream()
				.collect(Collectors.toMap(BusinessPartnerGroup::getId, businessPartnerGroup -> businessPartnerGroup));
		Map<Integer, MBPartnerLocation> businessPartnerLocationsByBusinessPartnerId =
				businessPartnerLocationDBService.getGroupsByIds(MBPartnerLocation::getC_BPartner_ID,
						MBPartnerLocation.COLUMNNAME_C_BPartner_ID, businessPartnerIds).entrySet().stream().collect(HashMap::new,
						(map, entrySet) -> map.put(entrySet.getKey(),
								entrySet.getValue() == null || entrySet.getValue().isEmpty() ? null : entrySet.getValue().get(0)),
						HashMap::putAll);
		Map<Integer, MLocation> locationsById = locationDBService.getByIds(
				businessPartnerLocationsByBusinessPartnerId.values().stream().filter(Objects::nonNull)
						.map(MBPartnerLocation::getC_Location_ID).collect(Collectors.toSet()));
		// Batch call to get payer info fields
		Map<Integer, List<MBHPayerInfoFld>> payerInformationFieldsByPayerId = payerInformationFieldDBService
				.getGroupsByIds(MBHPayerInfoFld::getBH_Payer_ID, MBHPayerInfoFld.COLUMNNAME_BH_Payer_ID,
						businessPartnerIds);

		// Batch call to get payer info field values
		Set<Integer> payerInformationFieldIds = payerInformationFieldsByPayerId.values().stream()
				.flatMap(paymentInformationFieldList -> paymentInformationFieldList.stream().map(MBHPayerInfoFld::get_ID))
				.collect(Collectors.toSet());
		Map<Integer, List<MBHPayerInfoFldVal>> payerInformationFieldValueListByPayerInformationFieldId =
				payerInformationFieldValueDBService
						.getGroupsByIds(MBHPayerInfoFldVal::getBH_Payer_Info_Fld_ID, MBHPayerInfoFldVal
										.COLUMNNAME_BH_Payer_Info_Fld_ID,
								payerInformationFieldIds);

		// Batch call to get reference lists for charge info
		Map<String, MRefList> dataTypesByValue =
				referenceListDBService.getTypes(MReference_BH.PAYER_INFORMATION_FIELD_DATA_TYPE_AD_REFERENCE_UU,
								payerInformationFieldsByPayerId.values().stream().flatMap(
										payemntInformationFieldList -> payemntInformationFieldList.stream()
												.map(MBHPayerInfoFld::getBH_PayerInfoFieldDataType)).collect(Collectors.toSet())).stream()
						.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		return dbModels.stream().map(businessPartner -> {
			BusinessPartner businessPartnerToReturn = new BusinessPartner(businessPartner);

			// Add the group
			if (businessPartnerGroupsById.containsKey(businessPartner.getC_BP_Group_ID())) {
				businessPartnerToReturn.setBusinessPartnerGroup(
						businessPartnerGroupsById.get(businessPartner.getC_BP_Group_ID()));
			}
			// Fill in the payer information
			if (payerInformationFieldsByPayerId.containsKey(businessPartner.get_ID())) {
				businessPartnerToReturn.setPayerInformationFieldList(
						payerInformationFieldsByPayerId.get(businessPartner.get_ID()).stream().map(paymentInformationField -> {
							PayerInformationField payerInformationFieldToReturn = new PayerInformationField(paymentInformationField);

							// Now fill in the child data
							if (!StringUtil.isNullOrEmpty(paymentInformationField.getBH_PayerInfoFieldDataType())) {
								payerInformationFieldToReturn.setDataType(
										new ReferenceList(dataTypesByValue.get(paymentInformationField.getBH_PayerInfoFieldDataType())));
							}
							if (payerInformationFieldValueListByPayerInformationFieldId.containsKey(
									paymentInformationField.get_ID())) {
								payerInformationFieldToReturn.setValues(
										payerInformationFieldValueListByPayerInformationFieldId.get(paymentInformationField.get_ID())
												.stream().map(PayerInformationFieldValue::new).collect(Collectors.toList()));
							}

							return payerInformationFieldToReturn;
						}).collect(Collectors.toList()));
			}

			businessPartnerToReturn.setTotalVisits(visitsCount.getOrDefault(businessPartnerToReturn.getId(), 0));
			businessPartnerToReturn.setLastVisitDate(
					lastVisitDateByPatientId.getOrDefault(businessPartnerToReturn.getId(), null));
			if (businessPartnerLocationsByBusinessPartnerId.containsKey(businessPartnerToReturn.getId()) &&
					businessPartnerLocationsByBusinessPartnerId.get(businessPartnerToReturn.getId()) != null &&
					locationsById.containsKey(
							businessPartnerLocationsByBusinessPartnerId.get(businessPartnerToReturn.getId()).getC_Location_ID())) {
				businessPartnerToReturn.setAddress(locationsById.get(
								businessPartnerLocationsByBusinessPartnerId.get(businessPartnerToReturn.getId()).getC_Location_ID())
						.getAddress1());
			}

			return businessPartnerToReturn;
		}).collect(Collectors.toList());
	}
}
