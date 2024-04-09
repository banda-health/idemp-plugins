package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PInstance_Log;

/**
 * Generated Interface for AD_PInstance_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_PInstance_LogInput extends I_AD_PInstance_Log {

	/**
	 * Set AD_PInstance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	void setAD_PInstanceInput(ForeignEntityInput AD_PInstance);

	/**
	 * Get AD_PInstance.
	 *
	 * @return Instance of the process
	 */
	ForeignEntityInput AD_PInstance();

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
	 * Set PInstanceLogType.
	 *
	 * @param PInstanceLogType Process Audit Log Type
	 */
	void setPInstanceLogTypeInput(I_AD_Ref_ListInput PInstanceLogType);

	/**
	 * Get PInstanceLogType.
	 *
	 * @return Process Audit Log Type
	 */
	I_AD_Ref_ListInput PInstanceLogType();
}
