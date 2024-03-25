package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AllClients_V;

/**
 * Generated Interface for AD_AllClients_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_AllClients_VInput extends I_AD_AllClients_V {

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
	 * Set AD_Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	void setAD_LanguageInput(ForeignEntityInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return Language for this entity
	 */
	ForeignEntityInput AD_Language();

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
}
