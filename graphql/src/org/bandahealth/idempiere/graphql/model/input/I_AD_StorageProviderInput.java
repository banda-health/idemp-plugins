package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_StorageProvider;

/**
 * Generated Interface for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_StorageProviderInput extends I_AD_StorageProvider {

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
	 * Set Method.
	 *
	 * @param Method Method
	 */
	void setMethodInput(I_AD_Ref_ListInput Method);

	/**
	 * Get Method.
	 *
	 * @return Method
	 */
	I_AD_Ref_ListInput Method();
}
