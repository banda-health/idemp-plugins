package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_Node_Asset;

/**
 * Generated Interface for PP_Order_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_PP_Order_Node_AssetInput extends I_PP_Order_Node_Asset {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

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
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_OrderInput(ForeignEntityInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	ForeignEntityInput PP_Order();

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
	 * Set PP_Order_Node.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	void setPP_Order_NodeInput(ForeignEntityInput PP_Order_Node);

	/**
	 * Get PP_Order_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	ForeignEntityInput PP_Order_Node();

	/**
	 * Set PP_Order_Workflow.
	 *
	 * @param PP_Order_Workflow PP_Order_Workflow
	 */
	void setPP_Order_WorkflowInput(ForeignEntityInput PP_Order_Workflow);

	/**
	 * Get PP_Order_Workflow.
	 *
	 * @return PP_Order_Workflow
	 */
	ForeignEntityInput PP_Order_Workflow();
}
