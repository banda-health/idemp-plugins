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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set CumulativeLevel_RL.
	 *
	 * @param CumulativeLevel_RL Level for accumulative calculations
	 */
	void setCumulativeLevel_RL(I_AD_Ref_ListInput CumulativeLevel_RL);

	/**
	 * Get CumulativeLevel_RL.
	 *
	 * @return Level for accumulative calculations
	 */
	I_AD_Ref_ListInput getCumulativeLevel_RL();

	/**
	 * Set DiscountType_RL.
	 *
	 * @param DiscountType_RL Type of trade discount calculation
	 */
	void setDiscountType_RL(I_AD_Ref_ListInput DiscountType_RL);

	/**
	 * Get DiscountType_RL.
	 *
	 * @return Type of trade discount calculation
	 */
	I_AD_Ref_ListInput getDiscountType_RL();

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
