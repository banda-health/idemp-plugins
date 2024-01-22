package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AlertRule;

/**
 * Generated Interface for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_AlertRuleInput extends I_AD_AlertRule {

	/**
	 * Set AD_Alert.
	 *
	 * @param AD_Alert iDempiere Alert
	 */
	void setAD_AlertInput(ForeignEntityInput AD_Alert);

	/**
	 * Get AD_Alert.
	 *
	 * @return iDempiere Alert
	 */
	ForeignEntityInput AD_Alert();

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
}
