package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Attachment;

/**
 * Generated Interface for AD_Attachment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_AttachmentInput extends I_AD_Attachment {

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

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
}
