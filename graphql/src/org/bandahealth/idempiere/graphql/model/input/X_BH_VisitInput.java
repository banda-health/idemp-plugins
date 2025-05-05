package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_VisitResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_VisitInput extends MBHVisit implements I_BH_VisitInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Clinician_User;
	private ForeignEntityInput mBH_PatientType;
	private ForeignEntityInput mBH_Process_Stage;
	private ForeignEntityInput mBH_Voided_Reason;
	private ForeignEntityInput mPatient;
	private ForeignEntityInput mbh_referral;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Visit_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_VisitInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set BH_Clinician_User_ID.
	 *
	 * @param BH_Clinician_User BH_Clinician_User_ID
	 */
	@JsonProperty("BH_Clinician_User")
	public void setBH_Clinician_UserInput(ForeignEntityInput BH_Clinician_User) {
		this.mBH_Clinician_User = BH_Clinician_User;
		if (BH_Clinician_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(BH_Clinician_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Clinician_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + BH_Clinician_User.getUU());
			}
		} else {
			this.setBH_Clinician_User_ID(0);
		}
	}

	/**
	 * Get BH_Clinician_User_ID.
	 *
	 * @return BH_Clinician_User_ID
	 */
	@JsonProperty("BH_Clinician_User")
	public ForeignEntityInput BH_Clinician_User() {
		return mBH_Clinician_User;
	}

	/**
	 * Set Patient Type.
	 *
	 * @param BH_PatientType Patient Type
	 */
	@JsonProperty("BH_PatientType")
	public void setBH_PatientTypeInput(ForeignEntityInput BH_PatientType) {
		this.mBH_PatientType = BH_PatientType;
		if (BH_PatientType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_VisitResolver.BH_PATIENTTYPE_UUIDS_BY_VALUE.containsValue(BH_PatientType.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_PatientType.getUU() +
						" is not in the list defined for the BH_PatientType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_PatientType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_PatientType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_PatientType.getUU());
			}
		} else {
			this.setBH_PatientType(null);
		}
	}

	/**
	 * Get Patient Type.
	 *
	 * @return Patient Type
	 */
	@JsonProperty("BH_PatientType")
	public ForeignEntityInput BH_PatientType() {
		return mBH_PatientType;
	}

	/**
	 * Set BH_Process_Stage.
	 *
	 * @param BH_Process_Stage Drop down field in visits for users to define the process stage
	 */
	@JsonProperty("BH_Process_Stage")
	public void setBH_Process_StageInput(ForeignEntityInput BH_Process_Stage) {
		this.mBH_Process_Stage = BH_Process_Stage;
		if (BH_Process_Stage != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_VisitResolver.BH_PROCESS_STAGE_UUIDS_BY_VALUE.containsValue(BH_Process_Stage.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Process_Stage.getUU() +
						" is not in the list defined for the BH_Process_Stage column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Process_Stage.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Process_Stage(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Process_Stage.getUU());
			}
		} else {
			this.setBH_Process_Stage(null);
		}
	}

	/**
	 * Get BH_Process_Stage.
	 *
	 * @return Drop down field in visits for users to define the process stage
	 */
	@JsonProperty("BH_Process_Stage")
	public ForeignEntityInput BH_Process_Stage() {
		return mBH_Process_Stage;
	}

	/**
	 * Set Referral.
	 *
	 * @param bh_referral Referral
	 */
	@JsonProperty("bh_referral")
	public void setbh_referralInput(ForeignEntityInput bh_referral) {
		this.mbh_referral = bh_referral;
		if (bh_referral != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_VisitResolver.BH_REFERRAL_UUIDS_BY_VALUE.containsValue(bh_referral.getUU())) {
				throw new AdempiereException("The reference list UU of " + bh_referral.getUU() +
						" is not in the list defined for the bh_referral column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(bh_referral.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setbh_referral(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + bh_referral.getUU());
			}
		} else {
			this.setbh_referral(null);
		}
	}

	/**
	 * Get Referral.
	 *
	 * @return Referral
	 */
	@JsonProperty("bh_referral")
	public ForeignEntityInput bh_referral() {
		return mbh_referral;
	}
	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */
	@JsonProperty("BH_Visit_ID")
	public void setBH_Visit_IDFromJson(int BH_Visit_ID) {
		if (get_ID() == 0) {
			super.setBH_Visit_ID(BH_Visit_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Visit_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Visit_UU();
	}

	/**
	 * Set BH_Voided_Reason_ID.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason_ID
	 */
	@JsonProperty("BH_Voided_Reason")
	public void setBH_Voided_ReasonInput(ForeignEntityInput BH_Voided_Reason) {
		this.mBH_Voided_Reason = BH_Voided_Reason;
		if (BH_Voided_Reason != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHVoidedReason foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Voided_Reason", "BH_Voided_Reason_UU=?", get_TrxName())
							.setParameters(BH_Voided_Reason.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Voided_Reason_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Voided_Reason with UU " + BH_Voided_Reason.getUU());
			}
		} else {
			this.setBH_Voided_Reason_ID(0);
		}
	}

	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	@JsonProperty("BH_Voided_Reason")
	public ForeignEntityInput BH_Voided_Reason() {
		return mBH_Voided_Reason;
	}
	/**
	 * Set Document No.
	 *
	 * @param DocumentNo Document sequence number of the document
	 */
	@JsonProperty("DocumentNo")
	public void setDocumentNoFromJson(String DocumentNo) {
		if (get_ID() == 0) {
			super.setDocumentNo(DocumentNo);
		}
	}

	/**
	 * Set Patient.
	 *
	 * @param Patient The Patient must be a valid business partner.
	 */
	@JsonProperty("Patient")
	public void setPatientInput(ForeignEntityInput Patient) {
		this.mPatient = Patient;
		if (Patient != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(Patient.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPatient_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + Patient.getUU());
			}
		} else {
			this.setPatient_ID(0);
		}
	}

	/**
	 * Get Patient.
	 *
	 * @return The Patient must be a valid business partner.
	 */
	@JsonProperty("Patient")
	public ForeignEntityInput Patient() {
		return mPatient;
	}
}
