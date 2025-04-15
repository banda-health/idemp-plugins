package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_Level;

/**
 * Generated Interface for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_ASP_LevelInput extends I_ASP_Level {

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
