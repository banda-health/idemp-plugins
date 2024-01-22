package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MForecast;
import org.compiere.model.MForecastLine;
import org.compiere.model.MOrg;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.MResource;
import org.compiere.model.Query;
import org.eevolution.model.MDDOrder;
import org.eevolution.model.MDDOrderLine;
import org.eevolution.model.X_PP_MRP;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_BOMLine;

import java.sql.ResultSet;

/**
 * Generated Model for PP_MRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_MRPInput extends X_PP_MRP implements I_PP_MRPInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_OrderLine;
	private ForeignEntityInput mDD_Order;
	private ForeignEntityInput mDD_OrderLine;
	private ForeignEntityInput mM_Forecast;
	private ForeignEntityInput mM_ForecastLine;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Requisition;
	private ForeignEntityInput mM_RequisitionLine;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mPP_Order;
	private ForeignEntityInput mPP_Order_BOMLine;
	private ForeignEntityInput mPlanner;
	private ForeignEntityInput mS_Resource;
	private I_AD_Ref_ListInput mDocStatus;
	private I_AD_Ref_ListInput mOrderType;
	private I_AD_Ref_ListInput mTypeMRP;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PP_MRPInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_PP_MRP(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (C_Order != null &&
				(foreignEntity = new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Order_ID(foreignEntity.get_ID());
		} else {
			super.setC_Order_ID(0);
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}

	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		MOrderLine_BH foreignEntity;
		if (C_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
						.setParameters(C_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderLine_ID(foreignEntity.get_ID());
		} else {
			super.setC_OrderLine_ID(0);
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public ForeignEntityInput C_OrderLine() {
		return mC_OrderLine;
	}

	/**
	 * Set Distribution Order.
	 *
	 * @param DD_Order Distribution Order
	 */
	@JsonProperty("DD_Order")
	public void setDD_OrderInput(ForeignEntityInput DD_Order) {
		this.mDD_Order = DD_Order;
		MDDOrder foreignEntity;
		if (DD_Order != null &&
				(foreignEntity = new Query(getCtx(), "DD_Order", "DD_Order_UU=?", get_TrxName())
						.setParameters(DD_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDD_Order_ID(foreignEntity.get_ID());
		} else {
			super.setDD_Order_ID(0);
		}
	}

	/**
	 * Get Distribution Order.
	 *
	 * @return Distribution Order
	 */
	@JsonProperty("DD_Order")
	public ForeignEntityInput DD_Order() {
		return mDD_Order;
	}

	/**
	 * Set Distribution Order Line.
	 *
	 * @param DD_OrderLine Distribution Order Line
	 */
	@JsonProperty("DD_OrderLine")
	public void setDD_OrderLineInput(ForeignEntityInput DD_OrderLine) {
		this.mDD_OrderLine = DD_OrderLine;
		MDDOrderLine foreignEntity;
		if (DD_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), "DD_OrderLine", "DD_OrderLine_UU=?", get_TrxName())
						.setParameters(DD_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDD_OrderLine_ID(foreignEntity.get_ID());
		} else {
			super.setDD_OrderLine_ID(0);
		}
	}

	/**
	 * Get Distribution Order Line.
	 *
	 * @return Distribution Order Line
	 */
	@JsonProperty("DD_OrderLine")
	public ForeignEntityInput DD_OrderLine() {
		return mDD_OrderLine;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(I_AD_Ref_ListInput DocStatus) {
		this.mDocStatus = DocStatus;
		MRefList_BH foreignEntity;
		if (DocStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocStatus(foreignEntity.getValue());
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public I_AD_Ref_ListInput DocStatus() {
		return mDocStatus;
	}

	/**
	 * Set Forecast.
	 *
	 * @param M_Forecast Material Forecast
	 */
	@JsonProperty("M_Forecast")
	public void setM_ForecastInput(ForeignEntityInput M_Forecast) {
		this.mM_Forecast = M_Forecast;
		MForecast foreignEntity;
		if (M_Forecast != null &&
				(foreignEntity = new Query(getCtx(), "M_Forecast", "M_Forecast_UU=?", get_TrxName())
						.setParameters(M_Forecast.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Forecast_ID(foreignEntity.get_ID());
		} else {
			super.setM_Forecast_ID(0);
		}
	}

	/**
	 * Get Forecast.
	 *
	 * @return Material Forecast
	 */
	@JsonProperty("M_Forecast")
	public ForeignEntityInput M_Forecast() {
		return mM_Forecast;
	}

	/**
	 * Set Forecast Line.
	 *
	 * @param M_ForecastLine Forecast Line
	 */
	@JsonProperty("M_ForecastLine")
	public void setM_ForecastLineInput(ForeignEntityInput M_ForecastLine) {
		this.mM_ForecastLine = M_ForecastLine;
		MForecastLine foreignEntity;
		if (M_ForecastLine != null &&
				(foreignEntity = new Query(getCtx(), "M_ForecastLine", "M_ForecastLine_UU=?", get_TrxName())
						.setParameters(M_ForecastLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ForecastLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_ForecastLine_ID(0);
		}
	}

	/**
	 * Get Forecast Line.
	 *
	 * @return Forecast Line
	 */
	@JsonProperty("M_ForecastLine")
	public ForeignEntityInput M_ForecastLine() {
		return mM_ForecastLine;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set Requisition.
	 *
	 * @param M_Requisition Material Requisition
	 */
	@JsonProperty("M_Requisition")
	public void setM_RequisitionInput(ForeignEntityInput M_Requisition) {
		this.mM_Requisition = M_Requisition;
		MRequisition foreignEntity;
		if (M_Requisition != null &&
				(foreignEntity = new Query(getCtx(), "M_Requisition", "M_Requisition_UU=?", get_TrxName())
						.setParameters(M_Requisition.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Requisition_ID(foreignEntity.get_ID());
		} else {
			super.setM_Requisition_ID(0);
		}
	}

	/**
	 * Get Requisition.
	 *
	 * @return Material Requisition
	 */
	@JsonProperty("M_Requisition")
	public ForeignEntityInput M_Requisition() {
		return mM_Requisition;
	}

	/**
	 * Set Requisition Line.
	 *
	 * @param M_RequisitionLine Material Requisition Line
	 */
	@JsonProperty("M_RequisitionLine")
	public void setM_RequisitionLineInput(ForeignEntityInput M_RequisitionLine) {
		this.mM_RequisitionLine = M_RequisitionLine;
		MRequisitionLine foreignEntity;
		if (M_RequisitionLine != null &&
				(foreignEntity = new Query(getCtx(), "M_RequisitionLine", "M_RequisitionLine_UU=?", get_TrxName())
						.setParameters(M_RequisitionLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_RequisitionLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_RequisitionLine_ID(0);
		}
	}

	/**
	 * Get Requisition Line.
	 *
	 * @return Material Requisition Line
	 */
	@JsonProperty("M_RequisitionLine")
	public ForeignEntityInput M_RequisitionLine() {
		return mM_RequisitionLine;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			super.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}

	/**
	 * Set Order Type.
	 *
	 * @param OrderType Type of Order: MRP records grouped by source (Sales Order, Purchase Order, Distribution Order, Requisition)
	 */
	@JsonProperty("OrderType")
	public void setOrderTypeInput(I_AD_Ref_ListInput OrderType) {
		this.mOrderType = OrderType;
		MRefList_BH foreignEntity;
		if (OrderType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(OrderType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOrderType(foreignEntity.getValue());
		} else {
			this.setOrderType(null);
		}
	}

	/**
	 * Get Order Type.
	 *
	 * @return Type of Order: MRP records grouped by source (Sales Order, Purchase Order, Distribution Order, Requisition)
	 */
	@JsonProperty("OrderType")
	public I_AD_Ref_ListInput OrderType() {
		return mOrderType;
	}

	/**
	 * Set Planner.
	 *
	 * @param Planner Planner
	 */
	@JsonProperty("Planner")
	public void setPlannerInput(ForeignEntityInput Planner) {
		this.mPlanner = Planner;
		MUser_BH foreignEntity;
		if (Planner != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(Planner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPlanner_ID(foreignEntity.get_ID());
		} else {
			super.setPlanner_ID(0);
		}
	}

	/**
	 * Get Planner.
	 *
	 * @return Planner
	 */
	@JsonProperty("Planner")
	public ForeignEntityInput Planner() {
		return mPlanner;
	}
	/**
	 * Set Material Requirement Planning.
	 *
	 * @param PP_MRP_ID MRP ID
	 */

	public void setPP_MRP_ID(int PP_MRP_ID) {
		if (get_ID() == 0) {
			super.setPP_MRP_ID(PP_MRP_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_MRP_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_MRP_UU();
	}

	/**
	 * Set Manufacturing Order BOM Line.
	 *
	 * @param PP_Order_BOMLine Manufacturing Order BOM Line
	 */
	@JsonProperty("PP_Order_BOMLine")
	public void setPP_Order_BOMLineInput(ForeignEntityInput PP_Order_BOMLine) {
		this.mPP_Order_BOMLine = PP_Order_BOMLine;
		X_PP_Order_BOMLine foreignEntity;
		if (PP_Order_BOMLine != null &&
				(foreignEntity = new Query(getCtx(), "PP_Order_BOMLine", "PP_Order_BOMLine_UU=?", get_TrxName())
						.setParameters(PP_Order_BOMLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_BOMLine_ID(foreignEntity.get_ID());
		} else {
			super.setPP_Order_BOMLine_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order BOM Line.
	 *
	 * @return Manufacturing Order BOM Line
	 */
	@JsonProperty("PP_Order_BOMLine")
	public ForeignEntityInput PP_Order_BOMLine() {
		return mPP_Order_BOMLine;
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(ForeignEntityInput PP_Order) {
		this.mPP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (PP_Order != null &&
				(foreignEntity = new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
						.setParameters(PP_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_ID(foreignEntity.get_ID());
		} else {
			super.setPP_Order_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public ForeignEntityInput PP_Order() {
		return mPP_Order;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	@JsonProperty("S_Resource")
	public void setS_ResourceInput(ForeignEntityInput S_Resource) {
		this.mS_Resource = S_Resource;
		MResource foreignEntity;
		if (S_Resource != null &&
				(foreignEntity = new Query(getCtx(), "S_Resource", "S_Resource_UU=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setS_Resource_ID(foreignEntity.get_ID());
		} else {
			super.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	@JsonProperty("S_Resource")
	public ForeignEntityInput S_Resource() {
		return mS_Resource;
	}

	/**
	 * Set MRP Type.
	 *
	 * @param TypeMRP MRP Type determines whether a record is demand or supply
	 */
	@JsonProperty("TypeMRP")
	public void setTypeMRPInput(I_AD_Ref_ListInput TypeMRP) {
		this.mTypeMRP = TypeMRP;
		MRefList_BH foreignEntity;
		if (TypeMRP != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TypeMRP.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTypeMRP(foreignEntity.getValue());
		} else {
			this.setTypeMRP(null);
		}
	}

	/**
	 * Get MRP Type.
	 *
	 * @return MRP Type determines whether a record is demand or supply
	 */
	@JsonProperty("TypeMRP")
	public I_AD_Ref_ListInput TypeMRP() {
		return mTypeMRP;
	}
}
