package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_T_BankRegister;

/**
 * Generated Interface for T_BankRegister - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_T_BankRegisterInput extends I_T_BankRegister {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_PInstance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	void setAD_PInstanceInput(ForeignEntityInput AD_PInstance);

	/**
	 * Get AD_PInstance.
	 *
	 * @return Instance of the process
	 */
	ForeignEntityInput AD_PInstance();

	/**
	 * Set C_Bank.
	 *
	 * @param C_Bank Bank
	 */
	void setC_BankInput(ForeignEntityInput C_Bank);

	/**
	 * Get C_Bank.
	 *
	 * @return Bank
	 */
	ForeignEntityInput C_Bank();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();
}
