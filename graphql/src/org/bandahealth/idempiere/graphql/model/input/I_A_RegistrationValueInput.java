package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_RegistrationValue;

/**
 * Generated Interface for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_A_RegistrationValueInput extends I_A_RegistrationValue {

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
}
