package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_VisitInput extends MBHVisit implements I_BH_VisitInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Voided_Reason;
	private ForeignEntityInput mPatient;
	private I_AD_Ref_ListInput mBH_PatientType;
	private I_AD_Ref_ListInput mBH_Process_Stage;
	private I_AD_Ref_ListInput mbh_referral;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_VisitInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHVisit(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Patient Type.
	 *
	 * @param BH_PatientType Patient Type
	 */
	@JsonProperty("BH_PatientType")
	public void setBH_PatientTypeInput(I_AD_Ref_ListInput BH_PatientType) {
		this.mBH_PatientType = BH_PatientType;
		MRefList_BH foreignEntity;
		if (BH_PatientType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_PatientType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_PatientType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput BH_PatientType() {
		return mBH_PatientType;
	}

	/**
	 * Set BH_Process_Stage.
	 *
	 * @param BH_Process_Stage Drop down field in visits for users to define the process stage
	 */
	@JsonProperty("BH_Process_Stage")
	public void setBH_Process_StageInput(I_AD_Ref_ListInput BH_Process_Stage) {
		this.mBH_Process_Stage = BH_Process_Stage;
		MRefList_BH foreignEntity;
		if (BH_Process_Stage != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_Process_Stage.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Process_Stage(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput BH_Process_Stage() {
		return mBH_Process_Stage;
	}

	/**
	 * Set Referral.
	 *
	 * @param bh_referral Referral
	 */
	@JsonProperty("bh_referral")
	public void setbh_referralInput(I_AD_Ref_ListInput bh_referral) {
		this.mbh_referral = bh_referral;
		MRefList_BH foreignEntity;
		if (bh_referral != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(bh_referral.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setbh_referral(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput bh_referral() {
		return mbh_referral;
	}
	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */

	public void setBH_Visit_ID(int BH_Visit_ID) {
		if (get_ID() == 0) {
			super.setBH_Visit_ID(BH_Visit_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Visit_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MBHVoidedReason foreignEntity;
		if (BH_Voided_Reason != null &&
				(foreignEntity = new Query(getCtx(), "BH_Voided_Reason", "BH_Voided_Reason_UU=?", get_TrxName())
						.setParameters(BH_Voided_Reason.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Voided_Reason_ID(foreignEntity.get_ID());
		} else {
			super.setBH_Voided_Reason_ID(0);
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

	public void setDocumentNo(String DocumentNo) {
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
		MBPartner_BH foreignEntity;
		if (Patient != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(Patient.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPatient_ID(foreignEntity.get_ID());
		} else {
			super.setPatient_ID(0);
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
