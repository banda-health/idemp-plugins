package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_SLA_Measure;

/**
 * Generated Interface for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_PA_SLA_MeasureInput extends I_PA_SLA_Measure {

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
	 * Set PA_SLA_Goal.
	 *
	 * @param PA_SLA_Goal Service Level Agreement Goal
	 */
	void setPA_SLA_GoalInput(ForeignEntityInput PA_SLA_Goal);

	/**
	 * Get PA_SLA_Goal.
	 *
	 * @return Service Level Agreement Goal
	 */
	ForeignEntityInput PA_SLA_Goal();

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
}
