package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Imp_Proc;

/**
 * Generated Interface for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_Package_Imp_ProcInput extends I_AD_Package_Imp_Proc {

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
	 * Set AD_Package_Source_Type.
	 *
	 * @param AD_Package_Source_Type Type of package source - file, ftp, webservice etc
	 */
	void setAD_Package_Source_TypeInput(I_AD_Ref_ListInput AD_Package_Source_Type);

	/**
	 * Get AD_Package_Source_Type.
	 *
	 * @return Type of package source - file, ftp, webservice etc
	 */
	I_AD_Ref_ListInput AD_Package_Source_Type();
}
