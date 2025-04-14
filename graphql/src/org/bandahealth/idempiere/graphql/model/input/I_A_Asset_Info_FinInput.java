package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Info_Fin;

/**
 * Generated Interface for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_A_Asset_Info_FinInput extends I_A_Asset_Info_Fin {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

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
	 * Set A_Due_On.
	 *
	 * @param A_Due_On A_Due_On
	 */
	void setA_Due_OnInput(ForeignEntityInput A_Due_On);

	/**
	 * Get A_Due_On.
	 *
	 * @return A_Due_On
	 */
	ForeignEntityInput A_Due_On();

	/**
	 * Set A_Finance_Meth.
	 *
	 * @param A_Finance_Meth A_Finance_Meth
	 */
	void setA_Finance_MethInput(ForeignEntityInput A_Finance_Meth);

	/**
	 * Get A_Finance_Meth.
	 *
	 * @return A_Finance_Meth
	 */
	ForeignEntityInput A_Finance_Meth();

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
}
