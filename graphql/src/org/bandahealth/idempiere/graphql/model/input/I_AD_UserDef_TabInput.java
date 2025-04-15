package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserDef_Tab;

/**
 * Generated Interface for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_UserDef_TabInput extends I_AD_UserDef_Tab {

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
	void setIsAllowAdvancedLookupInput(ForeignEntityInput IsAllowAdvancedLookup);

	/**
	 * Get IsAllowAdvancedLookup.
	 *
	 * @return IsAllowAdvancedLookup
	 */
	ForeignEntityInput IsAllowAdvancedLookup();

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
	 * Set IsLookupOnlySelection.
	 *
	 * @param IsLookupOnlySelection When defined to true Lookup panel will display only selection columns. Default to false.
	 */
	void setIsLookupOnlySelectionInput(ForeignEntityInput IsLookupOnlySelection);

	/**
	 * Get IsLookupOnlySelection.
	 *
	 * @return When defined to true Lookup panel will display only selection columns. Default to false.
	 */
	ForeignEntityInput IsLookupOnlySelection();

	/**
	 * Set IsReadOnly.
	 *
	 * @param IsReadOnly Field is read only
	 */
	void setIsReadOnlyInput(ForeignEntityInput IsReadOnly);

	/**
	 * Get IsReadOnly.
	 *
	 * @return Field is read only
	 */
	ForeignEntityInput IsReadOnly();

	/**
	 * Set IsSingleRow.
	 *
	 * @param IsSingleRow Default for toggle between Single- and Multi-Row (Grid) Layout
	 */
	void setIsSingleRowInput(ForeignEntityInput IsSingleRow);

	/**
	 * Get IsSingleRow.
	 *
	 * @return Default for toggle between Single- and Multi-Row (Grid) Layout
	 */
	ForeignEntityInput IsSingleRow();
}
