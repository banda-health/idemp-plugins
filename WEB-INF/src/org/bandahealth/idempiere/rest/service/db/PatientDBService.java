package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MLocation;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Patient Database Operations
 * 
 * @author andrew
 *
 */
public class PatientDBService extends BaseDBService<Patient, MBPartner_BH> {

	private static String COLUMNNAME_GENDER = "bh_gender";
	private static String COLUMNNAME_OCCUPATION = "bh_occupation";
	private static String COLUMNNAME_NEXTOFKIN_NAME = "nextofkin_name";
	private static String COLUMNNAME_NEXTOFKIN_CONTACT = "nextofkin_contact";
	
	public BaseListResponse<Patient> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.getAll(MBPartner_BH.COLUMNNAME_BH_IsPatient + "=?", parameters, pagingInfo, sortColumn, sortOrder);
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
				+ " ? " + OR_OPERATOR + MBPartner_BH.COLUMNNAME_BH_Local_PatientID + " " + LIKE_COMPARATOR + " ?" + ")" + AND_OPERATOR
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
				patient.setNational_ID(entity.getNationalId());
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

			patient.setIsActive(entity.isIsActive());

			patient.saveEx();

			return createInstanceWithAllFields(getEntityByUuidFromDB(patient.getC_BPartner_UU()));
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Patient createInstanceWithAllFields(MBPartner_BH instance) {
		try {
			String address = "";
			if (instance.getBH_C_Location() != null) {
				address = instance.getBH_C_Location().getAddress1();
			}
			int visits = VisitDBService.getVisitsCount(instance);
			String lastVisit = VisitDBService.getLastVisitDate(instance);

			return new Patient(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_BPartner_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					instance.getName(), instance.getDescription(), instance.getTotalOpenBalance(),
					instance.getBH_PatientID(), DateUtil.parseDateOnly(instance.getBH_Birthday()),
					instance.getBH_Phone(), address, instance.getbh_gender(), instance.getBH_EMail(),
					instance.getbh_nhif_relationship(), instance.getbh_nhif_member_name(), instance.getNHIF_Number(),
					instance.getBH_NHIF_Type(), instance.getNational_ID(), instance.getbh_occupation(),
					instance.getNextOfKin_Name(), instance.getNextOfKin_Contact(),
					instance.getBH_Local_PatientID(), visits, lastVisit );
		} catch (Exception ex) {
			log.severe(ex.getMessage());
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Patient createInstanceWithDefaultFields(MBPartner_BH instance) {
		try {
			String address = "";
			if (instance.getBH_C_Location() != null) {
				address = instance.getBH_C_Location().getAddress1();
			}

			return new Patient(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_BPartner_UU(),
					instance.isActive(), DateUtil.parseDateOnly(instance.getCreated()), instance.getCreatedBy(),
					instance.getName(), instance.getDescription(), instance.getTotalOpenBalance(),
					instance.getBH_PatientID(), DateUtil.parseDateOnly(instance.getBH_Birthday()),
					instance.getbh_gender(), instance.getBH_Phone(),
					instance.getBH_Local_PatientID());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Patient createInstanceWithSearchFields(MBPartner_BH instance) {
		try {
			String address = "";
			if (instance.getBH_C_Location() != null) {
				address = instance.getBH_C_Location().getAddress1();
			}

			return new Patient(instance.getC_BPartner_UU(), instance.getName(), instance.getTotalOpenBalance(),
					instance.getBH_PatientID(), DateUtil.parseDateOnly(instance.getBH_Birthday()),
					instance.getBH_Phone(), address, DateUtil.parseDateOnly(instance.getCreated()),
					instance.getbh_gender(), instance.isActive(), instance.getBH_Local_PatientID());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected MBPartner_BH getModelInstance() {
		return new MBPartner_BH(Env.getCtx(), 0, null);
	}

	public MBPartner_BH getPatientById(int patientId) {
		return new Query(Env.getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=?", null)
				.setParameters(patientId).first();
	}
}
