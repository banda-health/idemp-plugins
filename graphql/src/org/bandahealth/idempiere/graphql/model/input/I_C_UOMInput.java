package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_UOM;

/**
 * Generated Interface for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_UOMInput extends I_C_UOM {

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
