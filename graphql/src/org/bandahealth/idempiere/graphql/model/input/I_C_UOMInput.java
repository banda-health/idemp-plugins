package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_UOM;

/**
 * Generated Interface for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_UOMInput extends I_C_UOM {

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
	 * Set UOMType.
	 *
	 * @param UOMType UOMType
	 */
	void setUOMTypeInput(I_AD_Ref_ListInput UOMType);

	/**
	 * Get UOMType.
	 *
	 * @return UOMType
	 */
	I_AD_Ref_ListInput UOMType();
}
