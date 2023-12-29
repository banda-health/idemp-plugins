package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashPlan;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_CashPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashPlanInput extends MCashPlan implements I_C_CashPlanInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CashFlowType_RL;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_ElementValueInput User1;
	 private I_C_ElementValueInput User2;
	 private I_C_ProjectInput C_Project;

	/**
	 * Standard constructor
	 */
	public X_C_CashPlanInput(String ID) {
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	public void setC_Activity(I_C_ActivityInput C_Activity) {
		this.C_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public I_C_ActivityInput getC_Activity() {
		return C_Activity;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public I_C_CampaignInput getC_Campaign() {
		return C_Campaign;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CashPlan_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_CashPlan_UU();
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}

	/**
	 * Set Cash Flow Type.
	 *
	 * @param CashFlowType_RL Cash Flow Type
	 */
	public void setCashFlowType_RL(I_AD_Ref_ListInput CashFlowType_RL) {
		this.CashFlowType_RL = CashFlowType_RL;
		MRefList foreignEntity;
		if (CashFlowType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CashFlowType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCashFlowType(foreignEntity.getValue());
		} else {
			this.setCashFlowType(null);
		}
	}

	/**
	 * Get Cash Flow Type.
	 *
	 * @return Cash Flow Type
	 */
	public I_AD_Ref_ListInput getCashFlowType_RL() {
		return CashFlowType_RL;
	}
	/**
	 * Set Grand Total.
	 *
	 * @param GrandTotal Total amount of document
	 */
	public void setGrandTotal(BigDecimal GrandTotal) {
		if (get_ID() == 0) {
			super.setGrandTotal(GrandTotal);
		}
	}
	/**
	 * Set Approved.
	 *
	 * @param IsApproved Indicates if this document requires approval
	 */
	public void setIsApproved(boolean IsApproved) {
		if (get_ID() == 0) {
			super.setIsApproved(IsApproved);
		}
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */
	public void setProcessed(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	public void setUser1(I_C_ElementValueInput User1) {
		this.User1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser1_ID(foreignEntity.get_ID());
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public I_C_ElementValueInput getUser1() {
		return User1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	public void setUser2(I_C_ElementValueInput User2) {
		this.User2 = User2;
		MElementValue foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser2_ID(foreignEntity.get_ID());
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public I_C_ElementValueInput getUser2() {
		return User2;
	}
}
