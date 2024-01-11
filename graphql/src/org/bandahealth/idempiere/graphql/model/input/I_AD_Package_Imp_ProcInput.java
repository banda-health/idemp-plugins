package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Imp_Proc;

/**
 * Generated Interface for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
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
