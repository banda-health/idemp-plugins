package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Image;

/**
 * Generated Interface for AD_Image - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_ImageInput extends I_AD_Image {

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
	 * Set AD_StorageProvider.
	 *
	 * @param AD_StorageProvider AD_StorageProvider
	 */
	void setAD_StorageProviderInput(ForeignEntityInput AD_StorageProvider);

	/**
	 * Get AD_StorageProvider.
	 *
	 * @return AD_StorageProvider
	 */
	ForeignEntityInput AD_StorageProvider();

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
