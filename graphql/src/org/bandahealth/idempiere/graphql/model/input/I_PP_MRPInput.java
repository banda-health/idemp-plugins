package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_MRP;

/**
 * Generated Interface for PP_MRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_MRPInput extends I_PP_MRP {

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
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(ForeignEntityInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	ForeignEntityInput C_Order();

	/**
	 * Set C_OrderLine.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	void setC_OrderLineInput(ForeignEntityInput C_OrderLine);

	/**
	 * Get C_OrderLine.
	 *
	 * @return Sales Order Line
	 */
	ForeignEntityInput C_OrderLine();

	/**
	 * Set DD_Order.
	 *
	 * @param DD_Order DD_Order
	 */
	void setDD_OrderInput(ForeignEntityInput DD_Order);

	/**
	 * Get DD_Order.
	 *
	 * @return DD_Order
	 */
	ForeignEntityInput DD_Order();

	/**
	 * Set DD_OrderLine.
	 *
	 * @param DD_OrderLine DD_OrderLine
	 */
	void setDD_OrderLineInput(ForeignEntityInput DD_OrderLine);

	/**
	 * Get DD_OrderLine.
	 *
	 * @return DD_OrderLine
	 */
	ForeignEntityInput DD_OrderLine();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(I_AD_Ref_ListInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput DocStatus();

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
	 * Set M_Requisition.
	 *
	 * @param M_Requisition Material Requisition
	 */
	void setM_RequisitionInput(ForeignEntityInput M_Requisition);

	/**
	 * Get M_Requisition.
	 *
	 * @return Material Requisition
	 */
	ForeignEntityInput M_Requisition();

	/**
	 * Set M_RequisitionLine.
	 *
	 * @param M_RequisitionLine Material Requisition Line
	 */
	void setM_RequisitionLineInput(ForeignEntityInput M_RequisitionLine);

	/**
	 * Get M_RequisitionLine.
	 *
	 * @return Material Requisition Line
	 */
	ForeignEntityInput M_RequisitionLine();

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
	 * Set OrderType.
	 *
	 * @param OrderType Type of Order: MRP records grouped by source (Sales Order, Purchase Order, Distribution Order, Requisition)
	 */
	void setOrderTypeInput(I_AD_Ref_ListInput OrderType);

	/**
	 * Get OrderType.
	 *
	 * @return Type of Order: MRP records grouped by source (Sales Order, Purchase Order, Distribution Order, Requisition)
	 */
	I_AD_Ref_ListInput OrderType();

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
	 * Set PP_Order_BOMLine.
	 *
	 * @param PP_Order_BOMLine PP_Order_BOMLine
	 */
	void setPP_Order_BOMLineInput(ForeignEntityInput PP_Order_BOMLine);

	/**
	 * Get PP_Order_BOMLine.
	 *
	 * @return PP_Order_BOMLine
	 */
	ForeignEntityInput PP_Order_BOMLine();

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
	 * Set TypeMRP.
	 *
	 * @param TypeMRP MRP Type determines whether a record is demand or supply
	 */
	void setTypeMRPInput(I_AD_Ref_ListInput TypeMRP);

	/**
	 * Get TypeMRP.
	 *
	 * @return MRP Type determines whether a record is demand or supply
	 */
	I_AD_Ref_ListInput TypeMRP();
}
