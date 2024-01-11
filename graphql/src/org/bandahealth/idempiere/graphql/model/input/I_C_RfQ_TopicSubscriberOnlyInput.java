package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RfQ_TopicSubscriberOnly;

/**
 * Generated Interface for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_RfQ_TopicSubscriberOnlyInput extends I_C_RfQ_TopicSubscriberOnly {

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
	 * Set C_RfQ_TopicSubscriber.
	 *
	 * @param C_RfQ_TopicSubscriber Request for Quotation Topic Subscriber
	 */
	void setC_RfQ_TopicSubscriberInput(ForeignEntityInput C_RfQ_TopicSubscriber);

	/**
	 * Get C_RfQ_TopicSubscriber.
	 *
	 * @return Request for Quotation Topic Subscriber
	 */
	ForeignEntityInput C_RfQ_TopicSubscriber();

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
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	ForeignEntityInput M_Product_Category();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();
}
