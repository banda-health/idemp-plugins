package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MLocation;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Patient Database Operations
 *
 * @author andrew
 */
@Component
public class PatientDBService extends BaseDBService<Patient, MBPartner_BH> {

	@Autowired
	private LocationDBService locationDBService;
	private static String COLUMNNAME_GENDER = "bh_gender";
	private static String COLUMNNAME_OCCUPATION = "bh_occupation";
	private static String COLUMNNAME_NEXTOFKIN_NAME = "nextofkin_name";
	private static String COLUMNNAME_NEXTOFKIN_CONTACT = "nextofkin_contact";

	private Map<String, String> dynamicJoins = new HashMap<>() {{
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

	public BaseListResponse<Patient> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.getAll(MBPartner_BH.COLUMNNAME_BH_IsPatient + "=?", parameters, pagingInfo, sortJson, filterJson);
	}

	public BaseListResponse<Patient> search(String value, Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		String patientId = constructSearchValue(value);
		parameters.add(patientId);
		parameters.add(value + "%");
		parameters.add(value + "%");
		parameters.add(patientId);
		parameters.add("Y");

		String whereClause = "(" + DEFAULT_SEARCH_CLAUSE + OR_OPERATOR + MBPartner_BH.COLUMNNAME_BH_PatientID + " "
				+ LIKE_COMPARATOR + " ?" + OR_OPERATOR + MBPartner_BH.COLUMNNAME_BH_Phone + " " + LIKE_COMPARATOR
				+ " ? " + OR_OPERATOR + MBPartner_BH.COLUMNNAME_BH_Local_PatientID + " " + LIKE_COMPARATOR + " ?" + ")" +
				AND_OPERATOR
				+ MBPartner_BH.COLUMNNAME_BH_IsPatient + "=?";

		return search(whereClause, parameters, pagingInfo, sortColumn, sortOrder);
	}

	/*
	 * Save or Update Patient
	 */
	@Override
	public Patient saveEntity(Patient entity) {
		try {
			MBPartner_BH patient = getEntityByUuidFromDB(entity.getUuid());
			if (patient == null) {
				patient = getModelInstance();
				patient.setBH_IsPatient(true);
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					patient.setC_BPartner_UU(entity.getUuid());
				}
			}

			if (StringUtil.isNotNullAndEmpty(entity.getName())) {
				patient.setName(entity.getName());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getPatientNumber())) {
				patient.setBH_PatientID(entity.getPatientNumber());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDateOfBirth())) {
				patient.setBH_Birthday(DateUtil.getTimestamp(entity.getDateOfBirth()));
			}

			if (StringUtil.isNotNullAndEmpty(entity.getPhone())) {
				patient.setBH_Phone(entity.getPhone());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getAddress())) {
				MLocation location = new MLocation(Env.getCtx(), 0, null);
				location.setAddress1(entity.getAddress());
				location.saveEx();

				patient.setBH_C_Location_ID(location.get_ID());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getGender())) {
				patient.set_CustomColumn(COLUMNNAME_GENDER, entity.getGender());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getEmail())) {
				patient.setBH_EMail(entity.getEmail());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNhifRelationship())) {
				patient.setbh_nhif_relationship(entity.getNhifRelationship());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNhifMemberName())) {
				patient.setbh_nhif_member_name(entity.getNhifMemberName());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNhifNumber())) {
				patient.setNHIF_Number(entity.getNhifNumber());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNhifType())) {
				patient.setBH_NHIF_Type(entity.getNhifType());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNationalId())) {
				patient.setNationalID(entity.getNationalId());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getOccupation())) {
				patient.set_CustomColumn(COLUMNNAME_OCCUPATION, entity.getOccupation());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNextOfKinName())) {
				patient.set_CustomColumn(COLUMNNAME_NEXTOFKIN_NAME, entity.getNextOfKinName());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNextOfKinContact())) {
				patient.set_CustomColumn(COLUMNNAME_NEXTOFKIN_CONTACT, entity.getNextOfKinContact());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getLocalPatientNumber())) {
				patient.setBH_Local_PatientID(entity.getLocalPatientNumber());
			}

			if (entity.isApproximateDateOfBirth() != null) {
				patient.setBH_IsApproximateDateOfBirth(entity.isApproximateDateOfBirth());
			}

			patient.setIsActive(entity.getIsActive());

			patient.saveEx();

			return createInstanceWithAllFields(getEntityByUuidFromDB(patient.getC_BPartner_UU()));
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Patient createInstanceWithAllFields(MBPartner_BH instance) {
		return new Patient(instance);
	}

	@Override
	protected Patient createInstanceWithDefaultFields(MBPartner_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Patient createInstanceWithSearchFields(MBPartner_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBPartner_BH getModelInstance() {
		return new MBPartner_BH(Env.getCtx(), 0, null);
	}

	public MBPartner_BH getPatientById(int patientId) {
		return new Query(Env.getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=?", null)
				.setParameters(patientId).first();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> transformData(List<MBPartner_BH> dbModels) {
		if (dbModels == null || dbModels.isEmpty()) {
			return new ArrayList<>();
		}
		Set<Integer> patientIds = dbModels.stream().map(MBPartner_BH::get_ID).collect(Collectors.toSet());
		Map<Integer, Integer> visitsCount = VisitDBService.getVisitCountsByPatients(patientIds);
		Map<Integer, String> lastVisitDateByPatientId = VisitDBService.getLastVisitDateByPatients(patientIds);

		Set<Integer> locationIds =
				dbModels.stream().map(MBPartner_BH::getBH_C_Location_ID).filter(locationId -> locationId > 0)
						.collect(Collectors.toSet());
		Map<Integer, MLocation> locationsById =
				locationIds.isEmpty() ? new HashMap<>() : locationDBService.getByIds(locationIds);

		return dbModels.stream().map(businessPartner -> {
			Patient patient = createInstanceWithDefaultFields(businessPartner);

			patient.setTotalVisits(visitsCount.getOrDefault(patient.getId(), 0));
			patient.setLastVisitDate(lastVisitDateByPatientId.getOrDefault(patient.getId(), null));
			if (locationsById.containsKey(businessPartner.getBH_C_Location_ID())) {
				patient.setAddress(locationsById.get(businessPartner.getBH_C_Location_ID()).getAddress1());
			}
			return patient;
		}).collect(Collectors.toList());
	}
}
