package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ContactActivity;

/**
 * Generated Interface for C_ContactActivity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_ContactActivityInput extends I_C_ContactActivity {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set C_Opportunity.
	 *
	 * @param C_Opportunity C_Opportunity
	 */
	void setC_OpportunityInput(ForeignEntityInput C_Opportunity);

	/**
	 * Get C_Opportunity.
	 *
	 * @return C_Opportunity
	 */
	ForeignEntityInput C_Opportunity();

	/**
	 * Set ContactActivityType.
	 *
	 * @param ContactActivityType Type of activity, e.g. task, email, phone call
	 */
	void setContactActivityTypeInput(ForeignEntityInput ContactActivityType);

	/**
	 * Get ContactActivityType.
	 *
	 * @return Type of activity, e.g. task, email, phone call
	 */
	ForeignEntityInput ContactActivityType();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(ForeignEntityInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	ForeignEntityInput SalesRep();
}
