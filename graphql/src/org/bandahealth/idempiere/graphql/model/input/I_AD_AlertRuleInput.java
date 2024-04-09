package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AlertRule;

/**
 * Generated Interface for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
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
