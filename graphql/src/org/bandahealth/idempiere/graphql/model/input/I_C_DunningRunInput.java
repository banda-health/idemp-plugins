package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DunningRun;

/**
 * Generated Interface for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_DunningRunInput extends I_C_DunningRun {

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
	 * Set C_Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	void setC_DunningInput(ForeignEntityInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	ForeignEntityInput C_Dunning();

	/**
	 * Set C_DunningLevel.
	 *
	 * @param C_DunningLevel C_DunningLevel
	 */
	void setC_DunningLevelInput(ForeignEntityInput C_DunningLevel);

	/**
	 * Get C_DunningLevel.
	 *
	 * @return C_DunningLevel
	 */
	ForeignEntityInput C_DunningLevel();

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
