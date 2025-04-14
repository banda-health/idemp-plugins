package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintPaper;

/**
 * Generated Interface for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_PrintPaperInput extends I_AD_PrintPaper {

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
	 * Set DimensionUnits.
	 *
	 * @param DimensionUnits Units of Dimension
	 */
	void setDimensionUnitsInput(ForeignEntityInput DimensionUnits);

	/**
	 * Get DimensionUnits.
	 *
	 * @return Units of Dimension
	 */
	ForeignEntityInput DimensionUnits();
}
