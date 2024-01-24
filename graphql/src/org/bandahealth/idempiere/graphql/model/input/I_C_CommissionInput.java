package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Commission;

/**
 * Generated Interface for C_Commission - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_CommissionInput extends I_C_Commission {

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

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

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set DocBasisType.
	 *
	 * @param DocBasisType Basis for the calculation the commission
	 */
	void setDocBasisTypeInput(I_AD_Ref_ListInput DocBasisType);

	/**
	 * Get DocBasisType.
	 *
	 * @return Basis for the calculation the commission
	 */
	I_AD_Ref_ListInput DocBasisType();

	/**
	 * Set FrequencyType.
	 *
	 * @param FrequencyType Frequency of event
	 */
	void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType);

	/**
	 * Get FrequencyType.
	 *
	 * @return Frequency of event
	 */
	I_AD_Ref_ListInput FrequencyType();
}
