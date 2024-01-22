package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Imp;

/**
 * Generated Interface for AD_Package_Imp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_Package_ImpInput extends I_AD_Package_Imp {

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
	 * Set AD_Package_Imp_Proc.
	 *
	 * @param AD_Package_Imp_Proc AD_Package_Imp_Proc
	 */
	void setAD_Package_Imp_ProcInput(ForeignEntityInput AD_Package_Imp_Proc);

	/**
	 * Get AD_Package_Imp_Proc.
	 *
	 * @return AD_Package_Imp_Proc
	 */
	ForeignEntityInput AD_Package_Imp_Proc();

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
}
