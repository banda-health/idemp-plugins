package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_Vendor_Acct;

/**
 * Generated Interface for C_BP_Vendor_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_BP_Vendor_AcctInput extends I_C_BP_Vendor_Acct {

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

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
	 * Set V_Liability_A.
	 *
	 * @param V_Liability_A Account for Vendor Liability
	 */
	void setV_Liability_AInput(ForeignEntityInput V_Liability_A);

	/**
	 * Get V_Liability_A.
	 *
	 * @return Account for Vendor Liability
	 */
	ForeignEntityInput V_Liability_A();

	/**
	 * Set V_Liability_Services_A.
	 *
	 * @param V_Liability_Services_A Account for Vendor Service Liability
	 */
	void setV_Liability_Services_AInput(ForeignEntityInput V_Liability_Services_A);

	/**
	 * Get V_Liability_Services_A.
	 *
	 * @return Account for Vendor Service Liability
	 */
	ForeignEntityInput V_Liability_Services_A();

	/**
	 * Set V_Prepayment_A.
	 *
	 * @param V_Prepayment_A Account for Vendor Prepayments
	 */
	void setV_Prepayment_AInput(ForeignEntityInput V_Prepayment_A);

	/**
	 * Get V_Prepayment_A.
	 *
	 * @return Account for Vendor Prepayments
	 */
	ForeignEntityInput V_Prepayment_A();
}
