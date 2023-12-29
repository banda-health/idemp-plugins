package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_Node_Asset;

/**
 * Generated Interface for PP_Order_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Order_Node_AssetInput extends I_PP_Order_Node_Asset {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_Asset(I_A_AssetInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	I_A_AssetInput getA_Asset();

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
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_Order(I_PP_OrderInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	I_PP_OrderInput getPP_Order();

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
	 * Set PP_Order_Node.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	void setPP_Order_Node(I_PP_Order_NodeInput PP_Order_Node);

	/**
	 * Get PP_Order_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	I_PP_Order_NodeInput getPP_Order_Node();

	/**
	 * Set PP_Order_Workflow.
	 *
	 * @param PP_Order_Workflow PP_Order_Workflow
	 */
	void setPP_Order_Workflow(I_PP_Order_WorkflowInput PP_Order_Workflow);

	/**
	 * Get PP_Order_Workflow.
	 *
	 * @return PP_Order_Workflow
	 */
	I_PP_Order_WorkflowInput getPP_Order_Workflow();
}
