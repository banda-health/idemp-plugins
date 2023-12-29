package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.X_BH_Visit;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_VisitInput extends X_BH_Visit implements I_BH_VisitInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput BH_PatientType_RL;
	 private I_AD_Ref_ListInput BH_Process_Stage_RL;
	 private I_AD_Ref_ListInput bh_referral_RL;
	 private I_BH_Voided_ReasonInput BH_Voided_Reason;
	 private I_C_BPartnerInput Patient;

	/**
	 * Standard constructor
	 */
	public X_BH_VisitInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Patient Type.
	 *
	 * @param BH_PatientType_RL Patient Type
	 */
	public void setBH_PatientType_RL(I_AD_Ref_ListInput BH_PatientType_RL) {
		this.BH_PatientType_RL = BH_PatientType_RL;
		MRefList foreignEntity;
		if (BH_PatientType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_PatientType_RL.getID())
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
	public I_AD_Ref_ListInput getBH_PatientType_RL() {
		return BH_PatientType_RL;
	}

	/**
	 * Set BH_Process_Stage.
	 *
	 * @param BH_Process_Stage_RL Drop down field in visits for users to define the process stage
	 */
	public void setBH_Process_Stage_RL(I_AD_Ref_ListInput BH_Process_Stage_RL) {
		this.BH_Process_Stage_RL = BH_Process_Stage_RL;
		MRefList foreignEntity;
		if (BH_Process_Stage_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_Process_Stage_RL.getID())
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
	public I_AD_Ref_ListInput getBH_Process_Stage_RL() {
		return BH_Process_Stage_RL;
	}

	/**
	 * Set Referral.
	 *
	 * @param bh_referral_RL Referral
	 */
	public void setbh_referral_RL(I_AD_Ref_ListInput bh_referral_RL) {
		this.bh_referral_RL = bh_referral_RL;
		MRefList foreignEntity;
		if (bh_referral_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(bh_referral_RL.getID())
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
	public I_AD_Ref_ListInput getbh_referral_RL() {
		return bh_referral_RL;
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
	public void setBH_Voided_Reason(I_BH_Voided_ReasonInput BH_Voided_Reason) {
		this.BH_Voided_Reason = BH_Voided_Reason;
		MBHVoidedReason foreignEntity;
		if (BH_Voided_Reason != null &&
				(foreignEntity = new Query(getCtx(), MBHVoidedReason.Table_Name, MBHVoidedReason.COLUMNNAME_BH_Voided_Reason_UU + "=?", get_TrxName())
						.setParameters(BH_Voided_Reason.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Voided_Reason_ID(foreignEntity.get_ID());
		} else {
			this.setBH_Voided_Reason_ID(0);
		}
	}

	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	public I_BH_Voided_ReasonInput getBH_Voided_Reason() {
		return BH_Voided_Reason;
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
	public void setPatient(I_C_BPartnerInput Patient) {
		this.Patient = Patient;
		MBPartner_BH foreignEntity;
		if (Patient != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(Patient.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPatient_ID(foreignEntity.get_ID());
		} else {
			this.setPatient_ID(0);
		}
	}

	/**
	 * Get Patient.
	 *
	 * @return The Patient must be a valid business partner.
	 */
	public I_C_BPartnerInput getPatient() {
		return Patient;
	}
	/**
	 * Set Patient.
	 *
	 * @param Patient_ID The Patient must be a valid business partner.
	 */

	public void setPatient_ID(int Patient_ID) {
		if (get_ID() == 0) {
			super.setPatient_ID(Patient_ID);
		}
	}
}
