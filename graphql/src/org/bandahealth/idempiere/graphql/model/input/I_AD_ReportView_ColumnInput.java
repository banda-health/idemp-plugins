package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ReportView_Column;

/**
 * Generated Interface for AD_ReportView_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_ReportView_ColumnInput extends I_AD_ReportView_Column {

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
	 * Set AD_ReportView.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	void setAD_ReportViewInput(ForeignEntityInput AD_ReportView);

	/**
	 * Get AD_ReportView.
	 *
	 * @return View used to generate this report
	 */
	ForeignEntityInput AD_ReportView();
}
