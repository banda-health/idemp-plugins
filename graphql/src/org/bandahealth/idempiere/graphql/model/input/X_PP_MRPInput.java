package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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
import org.compiere.util.Env;
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
 * @version Release 8.2 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PP_MRP_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_MRPInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
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
		if (C_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + C_Order.getUUID());
			}
		} else {
			this.setC_Order_ID(0);
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
		if (C_OrderLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrderLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
							.setParameters(C_OrderLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLine with UUID " + C_OrderLine.getUUID());
			}
		} else {
			this.setC_OrderLine_ID(0);
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
		if (DD_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MDDOrder foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "DD_Order", "DD_Order_UU=?", get_TrxName())
							.setParameters(DD_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDD_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table DD_Order with UUID " + DD_Order.getUUID());
			}
		} else {
			this.setDD_Order_ID(0);
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
		if (DD_OrderLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MDDOrderLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "DD_OrderLine", "DD_OrderLine_UU=?", get_TrxName())
							.setParameters(DD_OrderLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDD_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table DD_OrderLine with UUID " + DD_OrderLine.getUUID());
			}
		} else {
			this.setDD_OrderLine_ID(0);
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
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocStatus.getUUID());
			}
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
		if (M_Forecast != null) {
			// Since an entity was passed, make sure it's in the DB
			MForecast foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Forecast", "M_Forecast_UU=?", get_TrxName())
							.setParameters(M_Forecast.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Forecast_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Forecast with UUID " + M_Forecast.getUUID());
			}
		} else {
			this.setM_Forecast_ID(0);
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
		if (M_ForecastLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MForecastLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ForecastLine", "M_ForecastLine_UU=?", get_TrxName())
							.setParameters(M_ForecastLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ForecastLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ForecastLine with UUID " + M_ForecastLine.getUUID());
			}
		} else {
			this.setM_ForecastLine_ID(0);
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
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			this.setM_Product_ID(0);
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
		if (M_Requisition != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequisition foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Requisition", "M_Requisition_UU=?", get_TrxName())
							.setParameters(M_Requisition.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Requisition_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Requisition with UUID " + M_Requisition.getUUID());
			}
		} else {
			this.setM_Requisition_ID(0);
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
		if (M_RequisitionLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequisitionLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_RequisitionLine", "M_RequisitionLine_UU=?", get_TrxName())
							.setParameters(M_RequisitionLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_RequisitionLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_RequisitionLine with UUID " + M_RequisitionLine.getUUID());
			}
		} else {
			this.setM_RequisitionLine_ID(0);
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
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_Warehouse.getUUID());
			}
		} else {
			this.setM_Warehouse_ID(0);
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
		if (OrderType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(OrderType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setOrderType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + OrderType.getUUID());
			}
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
		if (Planner != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Planner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPlanner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + Planner.getUUID());
			}
		} else {
			this.setPlanner_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPP_MRP_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (PP_Order_BOMLine != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order_BOMLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order_BOMLine", "PP_Order_BOMLine_UU=?", get_TrxName())
							.setParameters(PP_Order_BOMLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Order_BOMLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order_BOMLine with UUID " + PP_Order_BOMLine.getUUID());
			}
		} else {
			this.setPP_Order_BOMLine_ID(0);
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
		if (PP_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
							.setParameters(PP_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order with UUID " + PP_Order.getUUID());
			}
		} else {
			this.setPP_Order_ID(0);
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
		if (S_Resource != null) {
			// Since an entity was passed, make sure it's in the DB
			MResource foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "S_Resource", "S_Resource_UU=?", get_TrxName())
							.setParameters(S_Resource.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setS_Resource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_Resource with UUID " + S_Resource.getUUID());
			}
		} else {
			this.setS_Resource_ID(0);
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
		if (TypeMRP != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TypeMRP.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setTypeMRP(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + TypeMRP.getUUID());
			}
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
