package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_Level;

/**
 * Generated Interface for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_ASP_LevelInput extends I_ASP_Level {

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
	 * Set ASP_Module.
	 *
	 * @param ASP_Module ASP_Module
	 */
	void setASP_ModuleInput(ForeignEntityInput ASP_Module);

	/**
	 * Get ASP_Module.
	 *
	 * @return ASP_Module
	 */
	ForeignEntityInput ASP_Module();
}
