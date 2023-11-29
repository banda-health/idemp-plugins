package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;

public class BH_VisitInput extends MBHVisit {

	private AD_OrgInput AD_Org;
	private AD_UserInput BH_Clinician_User;
	private AD_Ref_ListInput BH_PatientType;
	private AD_Ref_ListInput BH_Process_Stage;
	private AD_Ref_ListInput bh_referral;
	private List<BH_EncounterInput> BH_Encounter = new ArrayList<>();
	private BH_VoidedReasonInput BH_VoidedReason;
	private List<C_InvoiceInput> C_Invoice = new ArrayList<>();
	private List<C_OrderInput> C_Order = new ArrayList<>();
	private List<C_PaymentInput> C_Payment = new ArrayList<>();
	private List<M_InOutInput> M_InOut = new ArrayList<>();
	private C_BPartnerInput Patient;

	public BH_VisitInput(String id) {
		super(Env.getCtx(), Optional.ofNullable(
						(IdObject) new Query(Env.getCtx(), Table_Name, Table_Name + "_uu=?", null).setParameters(id).first())
				.orElse(() -> 0).get_ID(), null);
	}

	public BH_VisitInput(Properties ctx, int BH_Visit_ID, String trxName) {
		super(ctx, BH_Visit_ID, trxName);
	}

	public BH_VisitInput(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	public void setAD_Org(AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		// Only set if this is a new entity
		MOrg foreignEntity;
		if (get_ID() == 0 && (foreignEntity = Optional.ofNullable(
				(IdObject) new Query(Env.getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName()).setParameters(
						AD_Org.getID()).first()).orElse(() -> 0)).get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	public AD_UserInput getBH_Clinician_User() {
		return BH_Clinician_User;
	}

	public void setBH_Clinician_User(AD_UserInput BH_Clinician_User) {
		this.BH_Clinician_User = BH_Clinician_User;
		MRefList foreignEntity;
		if (BH_Clinician_User != null && (foreignEntity = Optional.ofNullable(
				(IdObject) new Query(Env.getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?",
						null).setParameters(BH_Clinician_User.getID()).first()).orElse(() -> 0)).get_ID() != 0) {
			this.setBH_Clinician_User_ID(foreignEntity.get_ID());
		} else if (BH_Clinician_User == null) {
			this.setBH_Clinician_User_ID(0);
		}
	}

	@Override
	public AD_Ref_ListInput getBH_PatientType() {
		return BH_PatientType;
	}

	public void setBH_PatientType(AD_Ref_ListInput BH_PatientType) {
		this.BH_PatientType = BH_PatientType;
		MRefList foreignEntity;
		if ((foreignEntity = Optional.ofNullable(
				(IdObject) new Query(Env.getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						null).setParameters(BH_PatientType.getID()).first()).orElse(() -> 0)).get_ID() != 0) {
			this.setBH_PatientType(foreignEntity.getValue());
		}
	}

	@Override
	public AD_Ref_ListInput getBH_Process_Stage() {
		return BH_Process_Stage;
	}

	public void setBH_Process_Stage(AD_Ref_ListInput BH_Process_Stage) {
		this.BH_Process_Stage = BH_Process_Stage;
		MRefList foreignEntity;
		if (BH_Process_Stage != null && (foreignEntity = Optional.ofNullable(
				(IdObject) new Query(Env.getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						null).setParameters(BH_Process_Stage.getID()).first()).orElse(() -> 0)).get_ID() != 0) {
			this.setBH_Process_Stage(foreignEntity.getValue());
		} else if (BH_Process_Stage == null) {
			this.setBH_Process_Stage("");
		}
	}

	public AD_Ref_ListInput getBh_referral() {
		return bh_referral;
	}

	public void setBh_referral(AD_Ref_ListInput bh_referral) {
		this.bh_referral = bh_referral;
		MRefList foreignEntity;
		if ((foreignEntity = Optional.ofNullable(
				(IdObject) new Query(Env.getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						null).setParameters(bh_referral.getID()).first()).orElse(() -> 0)).get_ID() != 0) {
			this.setbh_referral(foreignEntity.getValue());
		}
	}

	public List<BH_EncounterInput> getBH_Encounter() {
		return BH_Encounter;
	}

	public void setBH_Encounter(List<BH_EncounterInput> BH_Encounter) {
		this.BH_Encounter = BH_Encounter;
	}

	public BH_VoidedReasonInput getBH_VoidedReason() {
		return BH_VoidedReason;
	}

	public void setBH_VoidedReason(BH_VoidedReasonInput BH_VoidedReason) {
		this.BH_VoidedReason = BH_VoidedReason;
		MRefList foreignEntity;
		if ((foreignEntity = Optional.ofNullable(
				(IdObject) new Query(Env.getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						null).setParameters(bh_referral.getID()).first()).orElse(() -> 0)).get_ID() != 0) {
			this.setBH_Voided_Reason_ID(foreignEntity.get_ID());
		}
	}

	@Override
	public C_BPartnerInput getPatient() {
		return Patient;
	}

	public void setPatient(C_BPartnerInput patient) {
		Patient = patient;
		MBPartner_BH foreignEntity;
		if ((foreignEntity = Optional.ofNullable(
				(IdObject) new Query(Env.getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?",
						null).setParameters(bh_referral.getID()).first()).orElse(() -> 0)).get_ID() != 0) {
			this.setPatient_ID(foreignEntity.get_ID());
		}
	}

	@Override
	public void setDocumentNo(String DocumentNo) {
		if (get_ID() == 0) {
			super.setDocumentNo(DocumentNo);
		}
	}

	public List<C_InvoiceInput> getC_Invoice() {
		return C_Invoice;
	}

	public void setC_Invoice(List<C_InvoiceInput> c_Invoice) {
		C_Invoice = c_Invoice;
	}

	public List<C_OrderInput> getC_Order() {
		return C_Order;
	}

	public void setC_Order(List<C_OrderInput> c_Order) {
		C_Order = c_Order;
	}

	public List<C_PaymentInput> getC_Payment() {
		return C_Payment;
	}

	public void setC_Payment(List<C_PaymentInput> c_Payment) {
		C_Payment = c_Payment;
	}

	public List<M_InOutInput> getM_InOut() {
		return M_InOut;
	}

	public void setM_InOut(List<M_InOutInput> m_InOut) {
		M_InOut = m_InOut;
	}
}
