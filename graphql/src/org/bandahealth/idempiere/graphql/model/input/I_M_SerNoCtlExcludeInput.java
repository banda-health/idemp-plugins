package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_SerNoCtlExclude;

/**
 * Generated Interface for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_SerNoCtlExcludeInput extends I_M_SerNoCtlExclude {

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
	 * Set M_SerNoCtl.
	 *
	 * @param M_SerNoCtl Product Serial Number Control
	 */
	void setM_SerNoCtlInput(ForeignEntityInput M_SerNoCtl);

	/**
	 * Get M_SerNoCtl.
	 *
	 * @return Product Serial Number Control
	 */
	ForeignEntityInput M_SerNoCtl();

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
