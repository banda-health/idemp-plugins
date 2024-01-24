package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Product_Planning;

/**
 * Generated Interface for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Product_PlanningInput extends I_PP_Product_Planning {

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
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_WorkflowInput(ForeignEntityInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	ForeignEntityInput AD_Workflow();

	/**
	 * Set DD_NetworkDistribution.
	 *
	 * @param DD_NetworkDistribution DD_NetworkDistribution
	 */
	void setDD_NetworkDistributionInput(ForeignEntityInput DD_NetworkDistribution);

	/**
	 * Get DD_NetworkDistribution.
	 *
	 * @return DD_NetworkDistribution
	 */
	ForeignEntityInput DD_NetworkDistribution();

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

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(ForeignEntityInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	ForeignEntityInput M_Warehouse();

	/**
	 * Set Order_Policy.
	 *
	 * @param Order_Policy Order_Policy
	 */
	void setOrder_PolicyInput(I_AD_Ref_ListInput Order_Policy);

	/**
	 * Get Order_Policy.
	 *
	 * @return Order_Policy
	 */
	I_AD_Ref_ListInput Order_Policy();

	/**
	 * Set Planner.
	 *
	 * @param Planner Planner
	 */
	void setPlannerInput(ForeignEntityInput Planner);

	/**
	 * Get Planner.
	 *
	 * @return Planner
	 */
	ForeignEntityInput Planner();

	/**
	 * Set PP_Product_BOM.
	 *
	 * @param PP_Product_BOM BOM & Formula
	 */
	void setPP_Product_BOMInput(ForeignEntityInput PP_Product_BOM);

	/**
	 * Get PP_Product_BOM.
	 *
	 * @return BOM & Formula
	 */
	ForeignEntityInput PP_Product_BOM();

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
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_ResourceInput(ForeignEntityInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	ForeignEntityInput S_Resource();
}
