package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Info_Tax;

/**
 * Generated Interface for A_Asset_Info_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_Info_TaxInput extends I_A_Asset_Info_Tax {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_Asset(I_A_AssetInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	I_A_AssetInput getA_Asset();

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
	 * Set A_Finance_Meth_RL.
	 *
	 * @param A_Finance_Meth_RL A_Finance_Meth_RL
	 */
	void setA_Finance_Meth_RL(I_AD_Ref_ListInput A_Finance_Meth_RL);

	/**
	 * Get A_Finance_Meth_RL.
	 *
	 * @return A_Finance_Meth_RL
	 */
	I_AD_Ref_ListInput getA_Finance_Meth_RL();

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
}
