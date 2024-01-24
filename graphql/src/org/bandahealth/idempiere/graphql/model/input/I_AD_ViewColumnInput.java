package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ViewColumn;

/**
 * Generated Interface for AD_ViewColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ViewColumnInput extends I_AD_ViewColumn {

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
	 * Set AD_ViewComponent.
	 *
	 * @param AD_ViewComponent AD_ViewComponent
	 */
	void setAD_ViewComponentInput(ForeignEntityInput AD_ViewComponent);

	/**
	 * Get AD_ViewComponent.
	 *
	 * @return AD_ViewComponent
	 */
	ForeignEntityInput AD_ViewComponent();

	/**
	 * Set DBDataType.
	 *
	 * @param DBDataType DBDataType
	 */
	void setDBDataTypeInput(I_AD_Ref_ListInput DBDataType);

	/**
	 * Get DBDataType.
	 *
	 * @return DBDataType
	 */
	I_AD_Ref_ListInput DBDataType();

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
}
