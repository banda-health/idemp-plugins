package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PromotionLine;

/**
 * Generated Interface for M_PromotionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_PromotionLineInput extends I_M_PromotionLine {

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
	 * Set M_Promotion.
	 *
	 * @param M_Promotion M_Promotion
	 */
	void setM_PromotionInput(ForeignEntityInput M_Promotion);

	/**
	 * Get M_Promotion.
	 *
	 * @return M_Promotion
	 */
	ForeignEntityInput M_Promotion();

	/**
	 * Set M_PromotionGroup.
	 *
	 * @param M_PromotionGroup M_PromotionGroup
	 */
	void setM_PromotionGroupInput(ForeignEntityInput M_PromotionGroup);

	/**
	 * Get M_PromotionGroup.
	 *
	 * @return M_PromotionGroup
	 */
	ForeignEntityInput M_PromotionGroup();

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
}
