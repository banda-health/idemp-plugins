package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Tab;

/**
 * Generated Interface for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_TabInput extends I_AD_Tab {

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
	 * Set AD_ColumnSortOrder.
	 *
	 * @param AD_ColumnSortOrder Column determining the order
	 */
	void setAD_ColumnSortOrderInput(ForeignEntityInput AD_ColumnSortOrder);

	/**
	 * Get AD_ColumnSortOrder.
	 *
	 * @return Column determining the order
	 */
	ForeignEntityInput AD_ColumnSortOrder();

	/**
	 * Set AD_ColumnSortYesNo.
	 *
	 * @param AD_ColumnSortYesNo Column determining if a Table Column is included in Ordering
	 */
	void setAD_ColumnSortYesNoInput(ForeignEntityInput AD_ColumnSortYesNo);

	/**
	 * Get AD_ColumnSortYesNo.
	 *
	 * @return Column determining if a Table Column is included in Ordering
	 */
	ForeignEntityInput AD_ColumnSortYesNo();

	/**
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelpInput(ForeignEntityInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	ForeignEntityInput AD_CtxHelp();

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	void setAD_ImageInput(ForeignEntityInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	ForeignEntityInput AD_Image();

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
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_ProcessInput(ForeignEntityInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	ForeignEntityInput AD_Process();

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
	 * Set AD_TabType.
	 *
	 * @param AD_TabType Defines Tab Type
	 */
	void setAD_TabTypeInput(ForeignEntityInput AD_TabType);

	/**
	 * Get AD_TabType.
	 *
	 * @return Defines Tab Type
	 */
	ForeignEntityInput AD_TabType();

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
	 * Set Included_Tab.
	 *
	 * @param Included_Tab Included Tab in this Tab (Master Detail)
	 */
	void setIncluded_TabInput(ForeignEntityInput Included_Tab);

	/**
	 * Get Included_Tab.
	 *
	 * @return Included Tab in this Tab (Master Detail)
	 */
	ForeignEntityInput Included_Tab();

	/**
	 * Set IsHighVolume.
	 *
	 * @param IsHighVolume Use Search instead of Pick list
	 */
	void setIsHighVolumeInput(ForeignEntityInput IsHighVolume);

	/**
	 * Get IsHighVolume.
	 *
	 * @return Use Search instead of Pick list
	 */
	ForeignEntityInput IsHighVolume();

	/**
	 * Set Parent_Column.
	 *
	 * @param Parent_Column The link column on the parent tab.
	 */
	void setParent_ColumnInput(ForeignEntityInput Parent_Column);

	/**
	 * Get Parent_Column.
	 *
	 * @return The link column on the parent tab.
	 */
	ForeignEntityInput Parent_Column();

	/**
	 * Set TreeDisplayedOn.
	 *
	 * @param TreeDisplayedOn The tree can be displayed on master tab, detail tab or both
	 */
	void setTreeDisplayedOnInput(ForeignEntityInput TreeDisplayedOn);

	/**
	 * Get TreeDisplayedOn.
	 *
	 * @return The tree can be displayed on master tab, detail tab or both
	 */
	ForeignEntityInput TreeDisplayedOn();
}
