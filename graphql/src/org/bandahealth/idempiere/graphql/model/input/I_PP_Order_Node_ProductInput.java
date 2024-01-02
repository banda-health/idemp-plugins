package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_Node_Product;

/**
 * Generated Interface for PP_Order_Node_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Order_Node_ProductInput extends I_PP_Order_Node_Product {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput M_Product();

	/**
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_OrderInput(I_PP_OrderInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	I_PP_OrderInput PP_Order();

	/**
	 * Set PP_Order_Node.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	void setPP_Order_NodeInput(I_PP_Order_NodeInput PP_Order_Node);

	/**
	 * Get PP_Order_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	I_PP_Order_NodeInput PP_Order_Node();

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
	 * Set PP_Order_Workflow.
	 *
	 * @param PP_Order_Workflow PP_Order_Workflow
	 */
	void setPP_Order_WorkflowInput(I_PP_Order_WorkflowInput PP_Order_Workflow);

	/**
	 * Get PP_Order_Workflow.
	 *
	 * @return PP_Order_Workflow
	 */
	I_PP_Order_WorkflowInput PP_Order_Workflow();
}
