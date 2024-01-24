package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_DesktopWorkbench;

/**
 * Generated Interface for AD_DesktopWorkbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_DesktopWorkbenchInput extends I_AD_DesktopWorkbench {

	/**
	 * Set AD_Desktop.
	 *
	 * @param AD_Desktop Collection of Workbenches
	 */
	void setAD_DesktopInput(ForeignEntityInput AD_Desktop);

	/**
	 * Get AD_Desktop.
	 *
	 * @return Collection of Workbenches
	 */
	ForeignEntityInput AD_Desktop();

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
	 * Set AD_Workbench.
	 *
	 * @param AD_Workbench Collection of windows, reports
	 */
	void setAD_WorkbenchInput(ForeignEntityInput AD_Workbench);

	/**
	 * Get AD_Workbench.
	 *
	 * @return Collection of windows, reports
	 */
	ForeignEntityInput AD_Workbench();
}
