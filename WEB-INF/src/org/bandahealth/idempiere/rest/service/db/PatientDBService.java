package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MLocation;
import org.compiere.util.Env;

public class PatientDBService extends BusinessPartnerDBService<Patient> {

	private String WHERE_CLAUSE = MBPartner_BH.COLUMNNAME_BH_IsPatient + "=?";
	private List<Object> parameters = new ArrayList<>();

	public PatientDBService() {
		parameters.add("Y");
		setQueryConditions(WHERE_CLAUSE, parameters);
	}

	/*
	 * Save or Update Patient
	 */
	public Patient savePatient(Patient entity) {
		MBPartner_BH patient;
		MBPartner_BH exists = getBPartner(entity.getUuid());
		if (exists != null) {
			patient = exists;
		} else {
			patient = new MBPartner_BH(Env.getCtx(), 0, null);
			patient.setBH_IsPatient(true);
		}

		if (entity.getName() != null) {
			patient.setName(entity.getName());
		}

		if (entity.getPatientNumber() != null) {
			patient.setBH_PatientID(entity.getPatientNumber());
		}

		if (entity.getDateOfBirth() != null) {
			patient.setBH_Birthday(DateUtil.getTimestamp(entity.getDateOfBirth()));
		}

		if (entity.getPhone() != null) {
			patient.setBH_Phone(entity.getPhone());
		}

		if (entity.getAddress() != null) {
			MLocation location = new MLocation(Env.getCtx(), 0, null);
			location.setAddress1(entity.getAddress());
			location.saveEx();

			patient.setBH_C_Location_ID(location.get_ID());
		}

		if (entity.getGender() != null) {
			patient.set_Attribute("bh_gender", entity.getGender());
		}

		if (entity.getEmail() != null) {
			patient.setBH_EMail(entity.getEmail());
		}

		if (entity.getNhifRelationship() != null) {
			patient.setBH_NHIFRelationship(entity.getNhifRelationship());
		}

		if (entity.getNhifMemberName() != null) {
			patient.setBH_NHIFMemberName(entity.getNhifMemberName());
		}

		if (entity.getNhifNumber() != null) {
			patient.setBH_NHIFNumber(entity.getNhifNumber());
		}

		if (entity.getNhifType() != null) {
			patient.setBH_NHIFType(entity.getNhifType());
		}

		if (entity.getNationalId() != null) {
			patient.setBH_NationalID(entity.getNationalId());
		}

		patient.saveEx();

		return createInstance(getBPartner(patient.getC_BPartner_UU()));
	}

	@Override
	protected Patient getInstance() {
		return new Patient();
	}

	@Override
	protected Patient createInstance(MBPartner_BH bpartner) {
		try {
			String address = "";
			if (bpartner.getBH_C_Location() != null) {
				address = bpartner.getBH_C_Location().getAddress1();
			}
			return new Patient(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), DateUtil.parse(bpartner.getCreated()), bpartner.getCreatedBy(),
					bpartner.getName(), bpartner.getDescription(), bpartner.getTotalOpenBalance(),
					bpartner.getBH_PatientID(), DateUtil.parse(bpartner.getBH_Birthday()), bpartner.getBH_Phone(),
					address, bpartner.get_ValueAsString("bh_gender"), bpartner.getBH_EMail(),
					bpartner.getBH_NHIFRelationship(), bpartner.getBH_NHIFMemberName(), bpartner.getBH_NHIFNumber(),
					bpartner.getBH_NHIFType(), bpartner.getBH_NationalID(), bpartner.get_ValueAsString("bh_occupation"),
					bpartner.get_ValueAsString("nextofkin_name"), bpartner.get_ValueAsString("nextofkin_contact"));
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}
}
