package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CashPlan;

/**
 * Generated Interface for C_CashPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_CashPlanInput extends I_C_CashPlan {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_Activity(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput getC_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_Campaign(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput getC_Campaign();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

	/**
	 * Set CashFlowType_RL.
	 *
	 * @param CashFlowType_RL CashFlowType_RL
	 */
	void setCashFlowType_RL(I_AD_Ref_ListInput CashFlowType_RL);

	/**
	 * Get CashFlowType_RL.
	 *
	 * @return CashFlowType_RL
	 */
	I_AD_Ref_ListInput getCashFlowType_RL();

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1(I_C_ElementValueInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	I_C_ElementValueInput getUser1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2(I_C_ElementValueInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	I_C_ElementValueInput getUser2();
}
