package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class X_BH_VisitInput extends MBHVisit implements I_BH_VisitInput {

	private I_AD_OrgInput AD_Org;
	private I_AD_Ref_ListInput BH_PatientType_RL;
	private I_AD_Ref_ListInput BH_Process_Stage_RL;
	private I_AD_Ref_ListInput bh_referral_RL;
	private I_BH_Voided_ReasonInput BH_Voided_Reason;
	private I_C_BPartnerInput Patient;

	public X_BH_VisitInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(Table_Name, ID), null);
		setID(ID);
	}

	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * AD_Org
	 *
	 * @param AD_Org
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		// Only set if this is a new entity
		MOrg foreignEntity;
		if (get_ID() == 0 && (foreignEntity =
				new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName()).setParameters(
						AD_Org.getID()).first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	public I_AD_Ref_ListInput getBH_PatientType_RL() {
		return BH_PatientType_RL;
	}

	public void setBH_PatientType_RL(I_AD_Ref_ListInput BH_PatientType_RL) {
		this.BH_PatientType_RL = BH_PatientType_RL;
		MRefList foreignEntity;
		if (BH_PatientType_RL != null && (foreignEntity =
				new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						get_TrxName()).setParameters(
						BH_PatientType_RL.getID()).first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_PatientType(foreignEntity.getValue());
		} else {
			this.setBH_Process_Stage(null);
		}
	}

	public I_AD_Ref_ListInput getBH_Process_Stage_RL() {
		return BH_Process_Stage_RL;
	}

	public void setBH_Process_Stage_RL(I_AD_Ref_ListInput BH_Process_Stage_RL) {
		this.BH_Process_Stage_RL = BH_Process_Stage_RL;
		MRefList foreignEntity;
		if (BH_Process_Stage_RL != null && (foreignEntity =
				new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						get_TrxName()).setParameters(
						BH_Process_Stage_RL.getID()).first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Process_Stage(foreignEntity.getValue());
		} else {
			this.setBH_Process_Stage(null);
		}
	}

	public I_AD_Ref_ListInput getBh_referral_RL() {
		return bh_referral_RL;
	}

	public void setBh_referral_RL(I_AD_Ref_ListInput bh_referral_RL) {
		this.bh_referral_RL = bh_referral_RL;
		MRefList foreignEntity;
		if (bh_referral_RL != null && (foreignEntity =
				new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						get_TrxName()).setParameters(
						bh_referral_RL.getID()).first()) != null && foreignEntity.get_ID() != 0) {
			this.setbh_referral(foreignEntity.getValue());
		} else {
			this.setbh_referral(null);
		}
	}

	public I_BH_Voided_ReasonInput getBH_Voided_Reason() {
		return BH_Voided_Reason;
	}

	public void setBH_Voided_Reason(I_BH_Voided_ReasonInput BH_VoidedReason) {
		this.BH_Voided_Reason = BH_VoidedReason;
		MRefList foreignEntity;
		if (BH_VoidedReason != null && (foreignEntity =
				new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						get_TrxName()).setParameters(BH_VoidedReason.getID()).first()) != null && foreignEntity.get_ID() != 0) {
			setBH_Voided_Reason_ID(foreignEntity.get_ID());
		} else {
			setBH_Voided_Reason_ID(0);
		}
	}

	@Override
	public I_C_BPartnerInput getPatient() {
		return Patient;
	}

	public void setPatient(I_C_BPartnerInput patient) {
		Patient = patient;
		MBPartner_BH foreignEntity;
		if (patient != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						get_TrxName()).setParameters(Patient.getID()).first()) != null && foreignEntity.get_ID() != 0) {
			setPatient_ID(foreignEntity.get_ID());
		} else {
			setPatient_ID(0);
		}
	}

	@Override
	public void setDocumentNo(String DocumentNo) {
		if (get_ID() == 0) {
			super.setDocumentNo(DocumentNo);
		}
	}

	@Override
	public String getID() {
		return getBH_Visit_UU();
	}

	@Override
	public void setID(String ID) {
		setBH_Visit_UU(ID);
	}
}
