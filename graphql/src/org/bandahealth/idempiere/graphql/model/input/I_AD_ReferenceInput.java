package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Reference;

/**
 * Generated Interface for AD_Reference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_ReferenceInput extends I_AD_Reference {

	/**
	 * Set AD_Element.
	 *
	 * @param AD_Element System Element enables the central maintenance of column description and help.
	 */
	void setAD_ElementInput(ForeignEntityInput AD_Element);

	/**
	 * Get AD_Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	ForeignEntityInput AD_Element();

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
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set ShowInactive.
	 *
	 * @param ShowInactive Show Inactive Records
	 */
	void setShowInactiveInput(I_AD_Ref_ListInput ShowInactive);

	/**
	 * Get ShowInactive.
	 *
	 * @return Show Inactive Records
	 */
	I_AD_Ref_ListInput ShowInactive();

	/**
	 * Set ValidationType.
	 *
	 * @param ValidationType Different method of validating data
	 */
	void setValidationTypeInput(I_AD_Ref_ListInput ValidationType);

	/**
	 * Get ValidationType.
	 *
	 * @return Different method of validating data
	 */
	I_AD_Ref_ListInput ValidationType();
}
