package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Opportunity;

/**
 * Generated Interface for C_Opportunity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_OpportunityInput extends I_C_Opportunity {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

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
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

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
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_Order(I_C_OrderInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	I_C_OrderInput getC_Order();

	/**
	 * Set C_SalesStage.
	 *
	 * @param C_SalesStage Stages of the sales process
	 */
	void setC_SalesStage(I_C_SalesStageInput C_SalesStage);

	/**
	 * Get C_SalesStage.
	 *
	 * @return Stages of the sales process
	 */
	I_C_SalesStageInput getC_SalesStage();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRep(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput getSalesRep();
}
