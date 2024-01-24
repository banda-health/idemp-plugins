package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_InfoRelated;

/**
 * Generated Interface for AD_InfoRelated - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_InfoRelatedInput extends I_AD_InfoRelated {

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
	 * Set AD_InfoWindow.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow);

	/**
	 * Get AD_InfoWindow.
	 *
	 * @return Info and search/select Window
	 */
	ForeignEntityInput AD_InfoWindow();

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
	 * Set ParentRelatedColumn.
	 *
	 * @param ParentRelatedColumn column in parent info window, link with column in this relate info
	 */
	void setParentRelatedColumnInput(ForeignEntityInput ParentRelatedColumn);

	/**
	 * Get ParentRelatedColumn.
	 *
	 * @return column in parent info window, link with column in this relate info
	 */
	ForeignEntityInput ParentRelatedColumn();

	/**
	 * Set RelatedColumn.
	 *
	 * @param RelatedColumn RelatedColumn
	 */
	void setRelatedColumnInput(ForeignEntityInput RelatedColumn);

	/**
	 * Get RelatedColumn.
	 *
	 * @return RelatedColumn
	 */
	ForeignEntityInput RelatedColumn();

	/**
	 * Set RelatedInfo.
	 *
	 * @param RelatedInfo RelatedInfo
	 */
	void setRelatedInfoInput(ForeignEntityInput RelatedInfo);

	/**
	 * Get RelatedInfo.
	 *
	 * @return RelatedInfo
	 */
	ForeignEntityInput RelatedInfo();
}
