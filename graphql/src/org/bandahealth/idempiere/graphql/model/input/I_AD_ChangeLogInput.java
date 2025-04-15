package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ChangeLog;

/**
 * Generated Interface for AD_ChangeLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_ChangeLogInput extends I_AD_ChangeLog {

	/**
	 * Set AD_ChangeLog.
	 *
	 * @param AD_ChangeLog Log of data changes
	 */
	void setAD_ChangeLogInput(ForeignEntityInput AD_ChangeLog);

	/**
	 * Get AD_ChangeLog.
	 *
	 * @return Log of data changes
	 */
	ForeignEntityInput AD_ChangeLog();

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
	 * Set AD_Session.
	 *
	 * @param AD_Session User Session Online or Web
	 */
	void setAD_SessionInput(ForeignEntityInput AD_Session);

	/**
	 * Get AD_Session.
	 *
	 * @return User Session Online or Web
	 */
	ForeignEntityInput AD_Session();

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
	 * Set EventChangeLog.
	 *
	 * @param EventChangeLog Type of Event in Change Log
	 */
	void setEventChangeLogInput(ForeignEntityInput EventChangeLog);

	/**
	 * Get EventChangeLog.
	 *
	 * @return Type of Event in Change Log
	 */
	ForeignEntityInput EventChangeLog();
}
