package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_InfoProcess;

/**
 * Generated Interface for AD_InfoProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_InfoProcessInput extends I_AD_InfoProcess {

	/**
	 * Set AD_InfoColumn.
	 *
	 * @param AD_InfoColumn Info Window Column
	 */
	void setAD_InfoColumnInput(ForeignEntityInput AD_InfoColumn);

	/**
	 * Get AD_InfoColumn.
	 *
	 * @return Info Window Column
	 */
	ForeignEntityInput AD_InfoColumn();

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
	 * Set LayoutType.
	 *
	 * @param LayoutType Layout type of info process
	 */
	void setLayoutTypeInput(ForeignEntityInput LayoutType);

	/**
	 * Get LayoutType.
	 *
	 * @return Layout type of info process
	 */
	ForeignEntityInput LayoutType();
}
