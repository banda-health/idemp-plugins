package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_IndexColumn;

/**
 * Generated Interface for AD_IndexColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_IndexColumnInput extends I_AD_IndexColumn {

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

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
	 * Set AD_TableIndex.
	 *
	 * @param AD_TableIndex AD_TableIndex
	 */
	void setAD_TableIndexInput(ForeignEntityInput AD_TableIndex);

	/**
	 * Get AD_TableIndex.
	 *
	 * @return AD_TableIndex
	 */
	ForeignEntityInput AD_TableIndex();

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
