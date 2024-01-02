package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintPaper;

/**
 * Generated Interface for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_PrintPaperInput extends I_AD_PrintPaper {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

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
	 * Set DimensionUnits.
	 *
	 * @param DimensionUnits Units of Dimension
	 */
	void setDimensionUnitsInput(I_AD_Ref_ListInput DimensionUnits);

	/**
	 * Get DimensionUnits.
	 *
	 * @return Units of Dimension
	 */
	I_AD_Ref_ListInput DimensionUnits();
}
