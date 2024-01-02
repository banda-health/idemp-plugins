package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_Cost;

/**
 * Generated Interface for PP_Order_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Order_CostInput extends I_PP_Order_Cost {

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
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_WorkflowInput(I_AD_WorkflowInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	I_AD_WorkflowInput AD_Workflow();

	/**
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	I_C_AcctSchemaInput C_AcctSchema();

	/**
	 * Set CostingMethod.
	 *
	 * @param CostingMethod Indicates how Costs will be calculated
	 */
	void setCostingMethodInput(I_AD_Ref_ListInput CostingMethod);

	/**
	 * Get CostingMethod.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	I_AD_Ref_ListInput CostingMethod();

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(I_M_AttributeSetInstanceInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	I_M_AttributeSetInstanceInput M_AttributeSetInstance();

	/**
	 * Set M_CostElement.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	void setM_CostElementInput(I_M_CostElementInput M_CostElement);

	/**
	 * Get M_CostElement.
	 *
	 * @return Product Cost Element
	 */
	I_M_CostElementInput M_CostElement();

	/**
	 * Set M_CostType.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	void setM_CostTypeInput(I_M_CostTypeInput M_CostType);

	/**
	 * Get M_CostType.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	I_M_CostTypeInput M_CostType();

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
}
