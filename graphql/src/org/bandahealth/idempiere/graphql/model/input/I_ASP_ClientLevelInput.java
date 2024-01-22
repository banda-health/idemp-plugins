package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_ClientLevel;

/**
 * Generated Interface for ASP_ClientLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_ASP_ClientLevelInput extends I_ASP_ClientLevel {

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
	 * Set ASP_Level.
	 *
	 * @param ASP_Level ASP_Level
	 */
	void setASP_LevelInput(ForeignEntityInput ASP_Level);

	/**
	 * Get ASP_Level.
	 *
	 * @return ASP_Level
	 */
	ForeignEntityInput ASP_Level();

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
