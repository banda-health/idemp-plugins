package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_RegistrationValue;

/**
 * Generated Interface for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_A_RegistrationValueInput extends I_A_RegistrationValue {

	/**
	 * Set A_Registration.
	 *
	 * @param A_Registration User Asset Registration
	 */
	void setA_RegistrationInput(ForeignEntityInput A_Registration);

	/**
	 * Get A_Registration.
	 *
	 * @return User Asset Registration
	 */
	ForeignEntityInput A_Registration();

	/**
	 * Set A_RegistrationAttribute.
	 *
	 * @param A_RegistrationAttribute Asset Registration Attribute
	 */
	void setA_RegistrationAttributeInput(ForeignEntityInput A_RegistrationAttribute);

	/**
	 * Get A_RegistrationAttribute.
	 *
	 * @return Asset Registration Attribute
	 */
	ForeignEntityInput A_RegistrationAttribute();

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
}
