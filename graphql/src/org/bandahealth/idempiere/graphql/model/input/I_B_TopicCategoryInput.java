package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_B_TopicCategory;

/**
 * Generated Interface for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_B_TopicCategoryInput extends I_B_TopicCategory {

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
	 * Set B_TopicType.
	 *
	 * @param B_TopicType Auction Topic Type
	 */
	void setB_TopicTypeInput(ForeignEntityInput B_TopicType);

	/**
	 * Get B_TopicType.
	 *
	 * @return Auction Topic Type
	 */
	ForeignEntityInput B_TopicType();
}
