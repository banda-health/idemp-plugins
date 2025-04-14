package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_SysConfig;

/**
 * Generated Interface for AD_SysConfig - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_SysConfigInput extends I_AD_SysConfig {

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
	 * Set ConfigurationLevel.
	 *
	 * @param ConfigurationLevel Configuration Level for this parameter
	 */
	void setConfigurationLevelInput(ForeignEntityInput ConfigurationLevel);

	/**
	 * Get ConfigurationLevel.
	 *
	 * @return Configuration Level for this parameter
	 */
	ForeignEntityInput ConfigurationLevel();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();
}
