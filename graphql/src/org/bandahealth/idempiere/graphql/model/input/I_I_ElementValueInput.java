package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_ElementValue;

/**
 * Generated Interface for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_I_ElementValueInput extends I_I_ElementValue {

	/**
	 * Set AccountSign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	void setAccountSignInput(I_AD_Ref_ListInput AccountSign);

	/**
	 * Get AccountSign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	I_AD_Ref_ListInput AccountSign();

	/**
	 * Set AccountType.
	 *
	 * @param AccountType Indicates the type of account
	 */
	void setAccountTypeInput(I_AD_Ref_ListInput AccountType);

	/**
	 * Get AccountType.
	 *
	 * @return Indicates the type of account
	 */
	I_AD_Ref_ListInput AccountType();

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
	 * Set C_Element.
	 *
	 * @param C_Element Accounting Element
	 */
	void setC_ElementInput(ForeignEntityInput C_Element);

	/**
	 * Get C_Element.
	 *
	 * @return Accounting Element
	 */
	ForeignEntityInput C_Element();

	/**
	 * Set C_ElementValue.
	 *
	 * @param C_ElementValue Account Element
	 */
	void setC_ElementValueInput(ForeignEntityInput C_ElementValue);

	/**
	 * Get C_ElementValue.
	 *
	 * @return Account Element
	 */
	ForeignEntityInput C_ElementValue();

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
	 * Set ParentElementValue.
	 *
	 * @param ParentElementValue The parent (summary) account
	 */
	void setParentElementValueInput(ForeignEntityInput ParentElementValue);

	/**
	 * Get ParentElementValue.
	 *
	 * @return The parent (summary) account
	 */
	ForeignEntityInput ParentElementValue();
}
