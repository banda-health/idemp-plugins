package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_DiscountSchema;

/**
 * Generated Interface for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_DiscountSchemaInput extends I_M_DiscountSchema {

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
	 * Set CumulativeLevel.
	 *
	 * @param CumulativeLevel Level for accumulative calculations
	 */
	void setCumulativeLevelInput(I_AD_Ref_ListInput CumulativeLevel);

	/**
	 * Get CumulativeLevel.
	 *
	 * @return Level for accumulative calculations
	 */
	I_AD_Ref_ListInput CumulativeLevel();

	/**
	 * Set DiscountType.
	 *
	 * @param DiscountType Type of trade discount calculation
	 */
	void setDiscountTypeInput(I_AD_Ref_ListInput DiscountType);

	/**
	 * Get DiscountType.
	 *
	 * @return Type of trade discount calculation
	 */
	I_AD_Ref_ListInput DiscountType();

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
}
