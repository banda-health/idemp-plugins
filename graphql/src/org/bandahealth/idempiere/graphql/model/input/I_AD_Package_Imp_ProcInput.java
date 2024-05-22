package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Imp_Proc;

/**
 * Generated Interface for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_Package_Imp_ProcInput extends I_AD_Package_Imp_Proc {

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
	 * Set AD_Package_Source_Type.
	 *
	 * @param AD_Package_Source_Type Type of package source - file, ftp, webservice etc
	 */
	void setAD_Package_Source_TypeInput(ForeignEntityInput AD_Package_Source_Type);

	/**
	 * Get AD_Package_Source_Type.
	 *
	 * @return Type of package source - file, ftp, webservice etc
	 */
	ForeignEntityInput AD_Package_Source_Type();
}
