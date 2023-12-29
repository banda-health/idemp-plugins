package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Info_Fin;

/**
 * Generated Interface for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_Info_FinInput extends I_A_Asset_Info_Fin {

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
	 * Set A_Due_On_RL.
	 *
	 * @param A_Due_On_RL A_Due_On_RL
	 */
	void setA_Due_On_RL(I_AD_Ref_ListInput A_Due_On_RL);

	/**
	 * Get A_Due_On_RL.
	 *
	 * @return A_Due_On_RL
	 */
	I_AD_Ref_ListInput getA_Due_On_RL();

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
}
