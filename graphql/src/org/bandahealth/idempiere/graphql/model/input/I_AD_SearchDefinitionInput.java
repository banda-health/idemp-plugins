package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_SearchDefinition;

/**
 * Generated Interface for AD_SearchDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_SearchDefinitionInput extends I_AD_SearchDefinition {

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
	 * Set AD_Message.
	 *
	 * @param AD_Message System Message
	 */
	void setAD_MessageInput(ForeignEntityInput AD_Message);

	/**
	 * Get AD_Message.
	 *
	 * @return System Message
	 */
	ForeignEntityInput AD_Message();

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
	 * Set AD_Style.
	 *
	 * @param AD_Style CSS style for field and label
	 */
	void setAD_StyleInput(ForeignEntityInput AD_Style);

	/**
	 * Get AD_Style.
	 *
	 * @return CSS style for field and label
	 */
	ForeignEntityInput AD_Style();

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
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

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
	 * Set PO_Window.
	 *
	 * @param PO_Window Purchase Order Window
	 */
	void setPO_WindowInput(ForeignEntityInput PO_Window);

	/**
	 * Get PO_Window.
	 *
	 * @return Purchase Order Window
	 */
	ForeignEntityInput PO_Window();
}
