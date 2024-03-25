package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Imp_Backup;

/**
 * Generated Interface for AD_Package_Imp_Backup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_Package_Imp_BackupInput extends I_AD_Package_Imp_Backup {

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
	 * Set AD_Package_Imp_Detail.
	 *
	 * @param AD_Package_Imp_Detail AD_Package_Imp_Detail
	 */
	void setAD_Package_Imp_DetailInput(ForeignEntityInput AD_Package_Imp_Detail);

	/**
	 * Get AD_Package_Imp_Detail.
	 *
	 * @return AD_Package_Imp_Detail
	 */
	ForeignEntityInput AD_Package_Imp_Detail();

	/**
	 * Set AD_Package_Imp.
	 *
	 * @param AD_Package_Imp AD_Package_Imp
	 */
	void setAD_Package_ImpInput(ForeignEntityInput AD_Package_Imp);

	/**
	 * Get AD_Package_Imp.
	 *
	 * @return AD_Package_Imp
	 */
	ForeignEntityInput AD_Package_Imp();

	/**
	 * Set AD_Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	void setAD_ReferenceInput(ForeignEntityInput AD_Reference);

	/**
	 * Get AD_Reference.
	 *
	 * @return System Reference and Validation
	 */
	ForeignEntityInput AD_Reference();

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
}
