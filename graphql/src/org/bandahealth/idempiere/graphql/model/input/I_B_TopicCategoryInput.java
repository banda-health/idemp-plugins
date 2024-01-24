package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_B_TopicCategory;

/**
 * Generated Interface for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_B_TopicCategoryInput extends I_B_TopicCategory {

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
