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

	/*
	 * Save or Update Patient
	 */
	@Override
	public Patient saveEntity(Patient entity) {
		try {
			MBPartner_BH patient;
			MBPartner_BH exists = getEntityFromDB(entity.getUuid());
			if (exists != null) {
				patient = exists;
			} else {
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
				patient.setBH_NHIFRelationship(entity.getNhifRelationship());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNhifMemberName())) {
				patient.setBH_NHIFMemberName(entity.getNhifMemberName());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNhifNumber())) {
				patient.setBH_NHIFNumber(entity.getNhifNumber());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNhifType())) {
				patient.setBH_NHIFType(entity.getNhifType());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getNationalId())) {
				patient.setBH_NationalID(entity.getNationalId());
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

			patient.setIsActive(entity.isIsActive());

			patient.saveEx();

			return createInstanceWithAllFields(getEntityFromDB(patient.getC_BPartner_UU()));
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Patient createInstanceWithAllFields(MBPartner_BH bpartner) {
		try {
			String address = "";
			if (bpartner.getBH_C_Location() != null) {
				address = bpartner.getBH_C_Location().getAddress1();
			}

			return new Patient(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), DateUtil.parse(bpartner.getCreated()), bpartner.getCreatedBy(),
					bpartner.getName(), bpartner.getDescription(), bpartner.getTotalOpenBalance(),
					bpartner.getBH_PatientID(), DateUtil.parse(bpartner.getBH_Birthday()), bpartner.getBH_Phone(),
					address, bpartner.get_ValueAsString(COLUMNNAME_GENDER), bpartner.getBH_EMail(),
					bpartner.getBH_NHIFRelationship(), bpartner.getBH_NHIFMemberName(), bpartner.getBH_NHIFNumber(),
					bpartner.getBH_NHIFType(), bpartner.getBH_NationalID(),
					bpartner.get_ValueAsString(COLUMNNAME_GENDER),
					bpartner.get_ValueAsString(COLUMNNAME_NEXTOFKIN_NAME),
					bpartner.get_ValueAsString(COLUMNNAME_NEXTOFKIN_CONTACT));
		} catch (Exception ex) {
			log.severe(ex.getMessage());
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Patient createInstanceWithDefaultFields(MBPartner_BH bpartner) {
		try {
			return new Patient(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), DateUtil.parse(bpartner.getCreated()), bpartner.getCreatedBy(),
					bpartner.getName(), bpartner.getDescription(), bpartner.getTotalOpenBalance(),
					bpartner.getBH_PatientID());
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
