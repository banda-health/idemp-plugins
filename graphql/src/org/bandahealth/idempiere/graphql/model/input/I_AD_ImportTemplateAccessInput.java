package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ImportTemplateAccess;

/**
 * Generated Interface for AD_ImportTemplateAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ImportTemplateAccessInput extends I_AD_ImportTemplateAccess {

	/**
	 * Set AD_ImportTemplate.
	 *
	 * @param AD_ImportTemplate AD_ImportTemplate
	 */
	void setAD_ImportTemplateInput(ForeignEntityInput AD_ImportTemplate);

	/**
	 * Get AD_ImportTemplate.
	 *
	 * @return AD_ImportTemplate
	 */
	ForeignEntityInput AD_ImportTemplate();

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
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();
}
