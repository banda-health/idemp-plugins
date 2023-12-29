package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Cash;

/**
 * Generated Interface for C_Cash - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_CashInput extends I_C_Cash {

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
	 * Set C_CashBook.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	void setC_CashBook(I_C_CashBookInput C_CashBook);

	/**
	 * Get C_CashBook.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	I_C_CashBookInput getC_CashBook();

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
	 * Set DocAction_RL.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL);

	/**
	 * Get DocAction_RL.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput getDocAction_RL();

	/**
	 * Set DocStatus_RL.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL);

	/**
	 * Get DocStatus_RL.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput getDocStatus_RL();

	/**
	 * Set Posted_RL.
	 *
	 * @param Posted_RL Posting status
	 */
	void setPosted_RL(I_AD_Ref_ListInput Posted_RL);

	/**
	 * Get Posted_RL.
	 *
	 * @return Posting status
	 */
	I_AD_Ref_ListInput getPosted_RL();

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
