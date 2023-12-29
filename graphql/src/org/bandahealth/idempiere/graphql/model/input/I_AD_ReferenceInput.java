package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Reference;

/**
 * Generated Interface for AD_Reference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ReferenceInput extends I_AD_Reference {

	/**
	 * Set AD_Element.
	 *
	 * @param AD_Element System Element enables the central maintenance of column description and help.
	 */
	void setAD_Element(I_AD_ElementInput AD_Element);

	/**
	 * Get AD_Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	I_AD_ElementInput getAD_Element();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

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
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set ValidationType_RL.
	 *
	 * @param ValidationType_RL Different method of validating data
	 */
	void setValidationType_RL(I_AD_Ref_ListInput ValidationType_RL);

	/**
	 * Get ValidationType_RL.
	 *
	 * @return Different method of validating data
	 */
	I_AD_Ref_ListInput getValidationType_RL();
}
