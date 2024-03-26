package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AuthorizationProvider;

/**
 * Generated Interface for AD_AuthorizationProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_AuthorizationProviderInput extends I_AD_AuthorizationProvider {

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
	 * Set AD_AuthorizationType.
	 *
	 * @param AD_AuthorizationType AD_AuthorizationType
	 */
	void setAD_AuthorizationTypeInput(I_AD_Ref_ListInput AD_AuthorizationType);

	/**
	 * Get AD_AuthorizationType.
	 *
	 * @return AD_AuthorizationType
	 */
	I_AD_Ref_ListInput AD_AuthorizationType();

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
