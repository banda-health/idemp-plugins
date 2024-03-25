package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_B_Topic;

/**
 * Generated Interface for B_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_B_TopicInput extends I_B_Topic {

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
	 * Set B_TopicCategory.
	 *
	 * @param B_TopicCategory Auction Topic Category
	 */
	void setB_TopicCategoryInput(ForeignEntityInput B_TopicCategory);

	/**
	 * Get B_TopicCategory.
	 *
	 * @return Auction Topic Category
	 */
	ForeignEntityInput B_TopicCategory();

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
