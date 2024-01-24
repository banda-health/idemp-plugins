package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserDef_Tab;

/**
 * Generated Interface for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_UserDef_TabInput extends I_AD_UserDef_Tab {

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
	 * Set AD_Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	void setAD_TabInput(ForeignEntityInput AD_Tab);

	/**
	 * Get AD_Tab.
	 *
	 * @return Tab within a Window
	 */
	ForeignEntityInput AD_Tab();

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
	 * Set AD_UserDef_Win.
	 *
	 * @param AD_UserDef_Win AD_UserDef_Win
	 */
	void setAD_UserDef_WinInput(ForeignEntityInput AD_UserDef_Win);

	/**
	 * Get AD_UserDef_Win.
	 *
	 * @return AD_UserDef_Win
	 */
	ForeignEntityInput AD_UserDef_Win();

	/**
	 * Set IsAllowAdvancedLookup.
	 *
	 * @param IsAllowAdvancedLookup IsAllowAdvancedLookup
	 */
	void setIsAllowAdvancedLookupInput(I_AD_Ref_ListInput IsAllowAdvancedLookup);

	/**
	 * Get IsAllowAdvancedLookup.
	 *
	 * @return IsAllowAdvancedLookup
	 */
	I_AD_Ref_ListInput IsAllowAdvancedLookup();

	/**
	 * Set IsLookupOnlySelection.
	 *
	 * @param IsLookupOnlySelection When defined to true Lookup panel will display only selection columns. Default to false.
	 */
	void setIsLookupOnlySelectionInput(I_AD_Ref_ListInput IsLookupOnlySelection);

	/**
	 * Get IsLookupOnlySelection.
	 *
	 * @return When defined to true Lookup panel will display only selection columns. Default to false.
	 */
	I_AD_Ref_ListInput IsLookupOnlySelection();

	/**
	 * Set IsReadOnly.
	 *
	 * @param IsReadOnly Field is read only
	 */
	void setIsReadOnlyInput(I_AD_Ref_ListInput IsReadOnly);

	/**
	 * Get IsReadOnly.
	 *
	 * @return Field is read only
	 */
	I_AD_Ref_ListInput IsReadOnly();

	/**
	 * Set IsSingleRow.
	 *
	 * @param IsSingleRow Default for toggle between Single- and Multi-Row (Grid) Layout
	 */
	void setIsSingleRowInput(I_AD_Ref_ListInput IsSingleRow);

	/**
	 * Get IsSingleRow.
	 *
	 * @return Default for toggle between Single- and Multi-Row (Grid) Layout
	 */
	I_AD_Ref_ListInput IsSingleRow();
}
