package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Table_ScriptValidator;

/**
 * Generated Interface for AD_Table_ScriptValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_Table_ScriptValidatorInput extends I_AD_Table_ScriptValidator {

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
	 * Set AD_Rule.
	 *
	 * @param AD_Rule AD_Rule
	 */
	void setAD_RuleInput(ForeignEntityInput AD_Rule);

	/**
	 * Get AD_Rule.
	 *
	 * @return AD_Rule
	 */
	ForeignEntityInput AD_Rule();

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

	/**
	 * Set EventModelValidator.
	 *
	 * @param EventModelValidator EventModelValidator
	 */
	void setEventModelValidatorInput(I_AD_Ref_ListInput EventModelValidator);

	/**
	 * Get EventModelValidator.
	 *
	 * @return EventModelValidator
	 */
	I_AD_Ref_ListInput EventModelValidator();
}
