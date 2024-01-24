package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_I_ProductPlanning;

/**
 * Generated Interface for I_ProductPlanning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_I_ProductPlanningInput extends I_I_ProductPlanning {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

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
	 * Set M_Forecast.
	 *
	 * @param M_Forecast Material Forecast
	 */
	void setM_ForecastInput(ForeignEntityInput M_Forecast);

	/**
	 * Get M_Forecast.
	 *
	 * @return Material Forecast
	 */
	ForeignEntityInput M_Forecast();

	/**
	 * Set M_ForecastLine.
	 *
	 * @param M_ForecastLine Forecast Line
	 */
	void setM_ForecastLineInput(ForeignEntityInput M_ForecastLine);

	/**
	 * Get M_ForecastLine.
	 *
	 * @return Forecast Line
	 */
	ForeignEntityInput M_ForecastLine();

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
	 * Set PP_Product_Planning.
	 *
	 * @param PP_Product_Planning PP_Product_Planning
	 */
	void setPP_Product_PlanningInput(ForeignEntityInput PP_Product_Planning);

	/**
	 * Get PP_Product_Planning.
	 *
	 * @return PP_Product_Planning
	 */
	ForeignEntityInput PP_Product_Planning();

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

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(ForeignEntityInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	ForeignEntityInput SalesRep();
}
