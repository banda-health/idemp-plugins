package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_ShippingAcct;

/**
 * Generated Interface for C_BP_ShippingAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_BP_ShippingAcctInput extends I_C_BP_ShippingAcct {

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
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	ForeignEntityInput C_BPartner_Location();

	/**
	 * Set M_ShippingProcessor.
	 *
	 * @param M_ShippingProcessor M_ShippingProcessor
	 */
	void setM_ShippingProcessorInput(ForeignEntityInput M_ShippingProcessor);

	/**
	 * Get M_ShippingProcessor.
	 *
	 * @return M_ShippingProcessor
	 */
	ForeignEntityInput M_ShippingProcessor();
}
