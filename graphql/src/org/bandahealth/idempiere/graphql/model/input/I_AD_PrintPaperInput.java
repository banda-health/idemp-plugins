package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintPaper;

/**
 * Generated Interface for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
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
