package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MCurrency;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.MShipper;
import org.compiere.model.MTax;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_OrderLine;
import org.compiere.model.X_M_Promotion;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Cost_Collector;

/**
 * Generated Model for C_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderLineInput extends X_C_OrderLine implements I_C_OrderLineInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BPartner_LocationInput C_BPartner_Location;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_ChargeInput C_Charge;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_ElementValueInput User1;
	 private I_C_ElementValueInput User2;
	 private I_C_OrderInput C_Order;
	 private I_C_OrderLineInput Link_OrderLine;
	 private I_C_OrderLineInput Ref_OrderLine;
	 private I_C_ProjectInput C_Project;
	 private I_C_ProjectPhaseInput C_ProjectPhase;
	 private I_C_ProjectTaskInput C_ProjectTask;
	 private I_C_TaxInput C_Tax;
	 private I_C_UOMInput C_UOM;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_ProductInput M_Product;
	 private I_M_PromotionInput M_Promotion;
	 private I_M_ShipperInput M_Shipper;
	 private I_M_WarehouseInput M_Warehouse;
	 private I_PP_Cost_CollectorInput PP_Cost_Collector;
	 private I_S_ResourceAssignmentInput S_ResourceAssignment;

	/**
	 * Standard constructor
	 */
	public X_C_OrderLineInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Expire On.
	 *
	 * @param BH_Expiration Expire On
	 */
	public void setBH_Expiration(Timestamp BH_Expiration) {
		set_Value(COLUMNNAME_BH_Expiration, BH_Expiration);
	}


	/**
	 * Get Expire On.
	 *
	 * @return Expire On
	 */
	public Timestamp getBH_Expiration() {
 		return (Timestamp) get_Value(COLUMNNAME_BH_Expiration);
	}


	/**
	 * Set BH_Instructions.
	 *
	 * @param BH_Instructions BH_Instructions
	 */
	public void setBH_Instructions(String BH_Instructions) {
		set_Value(COLUMNNAME_BH_Instructions, BH_Instructions);
	}


	/**
	 * Get BH_Instructions.
	 *
	 * @return BH_Instructions
	 */
	public String getBH_Instructions() {
 		return (String) get_Value(COLUMNNAME_BH_Instructions);
	}


	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	public void setBH_NavButtons(Object BH_NavButtons) {
		set_Value(COLUMNNAME_BH_NavButtons, BH_NavButtons);
	}


	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	public Object getBH_NavButtons() {
 		return get_Value(COLUMNNAME_BH_NavButtons);
	}


	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	public void setC_Activity(I_C_ActivityInput C_Activity) {
		this.C_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public I_C_ActivityInput getC_Activity() {
		return C_Activity;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 &&C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}
	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner_ID Identifies a Business Partner
	 */

	public void setC_BPartner_ID(int C_BPartner_ID) {
		if (get_ID() == 0) {
			super.setC_BPartner_ID(C_BPartner_ID);
		}
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	public void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.C_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public I_C_BPartner_LocationInput getC_BPartner_Location() {
		return C_BPartner_Location;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public I_C_CampaignInput getC_Campaign() {
		return C_Campaign;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	public void setC_Charge(I_C_ChargeInput C_Charge) {
		this.C_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public I_C_ChargeInput getC_Charge() {
		return C_Charge;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (get_ID() == 0 &&C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}
	/**
	 * Set Currency.
	 *
	 * @param C_Currency_ID The Currency for this record
	 */

	public void setC_Currency_ID(int C_Currency_ID) {
		if (get_ID() == 0) {
			super.setC_Currency_ID(C_Currency_ID);
		}
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	public void setC_Order(I_C_OrderInput C_Order) {
		this.C_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 &&C_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public I_C_OrderInput getC_Order() {
		return C_Order;
	}
	/**
	 * Set Order.
	 *
	 * @param C_Order_ID Order
	 */

	public void setC_Order_ID(int C_Order_ID) {
		if (get_ID() == 0) {
			super.setC_Order_ID(C_Order_ID);
		}
	}
	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine_ID Sales Order Line
	 */

	public void setC_OrderLine_ID(int C_OrderLine_ID) {
		if (get_ID() == 0) {
			super.setC_OrderLine_ID(C_OrderLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_OrderLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_OrderLine_UU();
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}

	/**
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	public void setC_ProjectPhase(I_C_ProjectPhaseInput C_ProjectPhase) {
		this.C_ProjectPhase = C_ProjectPhase;
		MProjectPhase foreignEntity;
		if (get_ID() == 0 &&C_ProjectPhase != null &&
				(foreignEntity = new Query(getCtx(), MProjectPhase.Table_Name, MProjectPhase.COLUMNNAME_C_ProjectPhase_UU + "=?", get_TrxName())
						.setParameters(C_ProjectPhase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ProjectPhase_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	public I_C_ProjectPhaseInput getC_ProjectPhase() {
		return C_ProjectPhase;
	}
	/**
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase_ID Phase of a Project
	 */

	public void setC_ProjectPhase_ID(int C_ProjectPhase_ID) {
		if (get_ID() == 0) {
			super.setC_ProjectPhase_ID(C_ProjectPhase_ID);
		}
	}

	/**
	 * Set Project Task.
	 *
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	public void setC_ProjectTask(I_C_ProjectTaskInput C_ProjectTask) {
		this.C_ProjectTask = C_ProjectTask;
		MProjectTask foreignEntity;
		if (get_ID() == 0 &&C_ProjectTask != null &&
				(foreignEntity = new Query(getCtx(), MProjectTask.Table_Name, MProjectTask.COLUMNNAME_C_ProjectTask_UU + "=?", get_TrxName())
						.setParameters(C_ProjectTask.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ProjectTask_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	public I_C_ProjectTaskInput getC_ProjectTask() {
		return C_ProjectTask;
	}
	/**
	 * Set Project Task.
	 *
	 * @param C_ProjectTask_ID Actual Project Task in a Phase
	 */

	public void setC_ProjectTask_ID(int C_ProjectTask_ID) {
		if (get_ID() == 0) {
			super.setC_ProjectTask_ID(C_ProjectTask_ID);
		}
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	public void setC_Tax(I_C_TaxInput C_Tax) {
		this.C_Tax = C_Tax;
		MTax foreignEntity;
		if (C_Tax != null &&
				(foreignEntity = new Query(getCtx(), MTax.Table_Name, MTax.COLUMNNAME_C_Tax_UU + "=?", get_TrxName())
						.setParameters(C_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Tax_ID(foreignEntity.get_ID());
		} else {
			this.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public I_C_TaxInput getC_Tax() {
		return C_Tax;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	public void setC_UOM(I_C_UOMInput C_UOM) {
		this.C_UOM = C_UOM;
		MUOM foreignEntity;
		if (get_ID() == 0 &&C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public I_C_UOMInput getC_UOM() {
		return C_UOM;
	}
	/**
	 * Set UOM.
	 *
	 * @param C_UOM_ID Unit of Measure
	 */

	public void setC_UOM_ID(int C_UOM_ID) {
		if (get_ID() == 0) {
			super.setC_UOM_ID(C_UOM_ID);
		}
	}
	/**
	 * Set Date Delivered.
	 *
	 * @param DateDelivered Date when the product was delivered
	 */

	public void setDateDelivered(Timestamp DateDelivered) {
		if (get_ID() == 0) {
			super.setDateDelivered(DateDelivered);
		}
	}
	/**
	 * Set Date Invoiced.
	 *
	 * @param DateInvoiced Date printed on Invoice
	 */

	public void setDateInvoiced(Timestamp DateInvoiced) {
		if (get_ID() == 0) {
			super.setDateInvoiced(DateInvoiced);
		}
	}
	/**
	 * Set Line Amount.
	 *
	 * @param LineNetAmt Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	 */

	public void setLineNetAmt(BigDecimal LineNetAmt) {
		if (get_ID() == 0) {
			super.setLineNetAmt(LineNetAmt);
		}
	}

	/**
	 * Set Linked Order Line.
	 *
	 * @param Link_OrderLine This field links a sales order line to the purchase order line that is generated from it.
	 */
	public void setLink_OrderLine(I_C_OrderLineInput Link_OrderLine) {
		this.Link_OrderLine = Link_OrderLine;
		MOrderLine_BH foreignEntity;
		if (get_ID() == 0 &&Link_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_OrderLine_UU + "=?", get_TrxName())
						.setParameters(Link_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLink_OrderLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Linked Order Line.
	 *
	 * @return This field links a sales order line to the purchase order line that is generated from it.
	 */
	public I_C_OrderLineInput getLink_OrderLine() {
		return Link_OrderLine;
	}
	/**
	 * Set Linked Order Line.
	 *
	 * @param Link_OrderLine_ID This field links a sales order line to the purchase order line that is generated from it.
	 */

	public void setLink_OrderLine_ID(int Link_OrderLine_ID) {
		if (get_ID() == 0) {
			super.setLink_OrderLine_ID(Link_OrderLine_ID);
		}
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			this.setM_AttributeSetInstance_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public I_M_AttributeSetInstanceInput getM_AttributeSetInstance() {
		return M_AttributeSetInstance;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}

	/**
	 * Set Promotion.
	 *
	 * @param M_Promotion Promotion
	 */
	public void setM_Promotion(I_M_PromotionInput M_Promotion) {
		this.M_Promotion = M_Promotion;
		X_M_Promotion foreignEntity;
		if (M_Promotion != null &&
				(foreignEntity = new Query(getCtx(), X_M_Promotion.Table_Name, X_M_Promotion.COLUMNNAME_M_Promotion_UU + "=?", get_TrxName())
						.setParameters(M_Promotion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Promotion_ID(foreignEntity.get_ID());
		} else {
			this.setM_Promotion_ID(0);
		}
	}

	/**
	 * Get Promotion.
	 *
	 * @return Promotion
	 */
	public I_M_PromotionInput getM_Promotion() {
		return M_Promotion;
	}

	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	public void setM_Shipper(I_M_ShipperInput M_Shipper) {
		this.M_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), MShipper.Table_Name, MShipper.COLUMNNAME_M_Shipper_UU + "=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Shipper_ID(foreignEntity.get_ID());
		} else {
			this.setM_Shipper_ID(0);
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public I_M_ShipperInput getM_Shipper() {
		return M_Shipper;
	}
	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper_ID Method or manner of product delivery
	 */

	public void setM_Shipper_ID(int M_Shipper_ID) {
		if (get_ID() == 0) {
			super.setM_Shipper_ID(M_Shipper_ID);
		}
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	public void setM_Warehouse(I_M_WarehouseInput M_Warehouse) {
		this.M_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public I_M_WarehouseInput getM_Warehouse() {
		return M_Warehouse;
	}
	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse_ID Storage Warehouse and Service Point
	 */

	public void setM_Warehouse_ID(int M_Warehouse_ID) {
		if (get_ID() == 0) {
			super.setM_Warehouse_ID(M_Warehouse_ID);
		}
	}

	/**
	 * Set Manufacturing Cost Collector.
	 *
	 * @param PP_Cost_Collector Manufacturing Cost Collector
	 */
	public void setPP_Cost_Collector(I_PP_Cost_CollectorInput PP_Cost_Collector) {
		this.PP_Cost_Collector = PP_Cost_Collector;
		X_PP_Cost_Collector foreignEntity;
		if (PP_Cost_Collector != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Cost_Collector.Table_Name, X_PP_Cost_Collector.COLUMNNAME_PP_Cost_Collector_UU + "=?", get_TrxName())
						.setParameters(PP_Cost_Collector.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Cost_Collector_ID(foreignEntity.get_ID());
		} else {
			this.setPP_Cost_Collector_ID(0);
		}
	}

	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	public I_PP_Cost_CollectorInput getPP_Cost_Collector() {
		return PP_Cost_Collector;
	}
	/**
	 * Set Unit Price.
	 *
	 * @param PriceActual Actual Price 
	 */

	public void setPriceActual(BigDecimal PriceActual) {
		if (get_ID() == 0) {
			super.setPriceActual(PriceActual);
		}
	}

	/**
	 * Set Available Quantity.
	 *
	 * @param QtyAvailable Available Quantity (On Hand - Reserved)
	 */
	public void setQtyAvailable(BigDecimal QtyAvailable) {
		set_ValueNoCheck(COLUMNNAME_QtyAvailable, QtyAvailable);
	}


	/**
	 * Get Available Quantity.
	 *
	 * @return Available Quantity (On Hand - Reserved)
	 */
	public BigDecimal getQtyAvailable() {
 		BigDecimal columnValue = (BigDecimal) get_Value(COLUMNNAME_QtyAvailable);
		if (columnValue == null) {
			return Env.ZERO;
		}
		return columnValue;
	}

	/**
	 * Set Delivered Quantity.
	 *
	 * @param QtyDelivered Delivered Quantity
	 */

	public void setQtyDelivered(BigDecimal QtyDelivered) {
		if (get_ID() == 0) {
			super.setQtyDelivered(QtyDelivered);
		}
	}
	/**
	 * Set Quantity Invoiced.
	 *
	 * @param QtyInvoiced Invoiced Quantity
	 */

	public void setQtyInvoiced(BigDecimal QtyInvoiced) {
		if (get_ID() == 0) {
			super.setQtyInvoiced(QtyInvoiced);
		}
	}
	/**
	 * Set Reserved Quantity.
	 *
	 * @param QtyReserved Reserved Quantity
	 */

	public void setQtyReserved(BigDecimal QtyReserved) {
		if (get_ID() == 0) {
			super.setQtyReserved(QtyReserved);
		}
	}

	/**
	 * Set Referenced Order Line.
	 *
	 * @param Ref_OrderLine Reference to corresponding Sales/Purchase Order
	 */
	public void setRef_OrderLine(I_C_OrderLineInput Ref_OrderLine) {
		this.Ref_OrderLine = Ref_OrderLine;
		MOrderLine_BH foreignEntity;
		if (Ref_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_OrderLine_UU + "=?", get_TrxName())
						.setParameters(Ref_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRef_OrderLine_ID(foreignEntity.get_ID());
		} else {
			this.setRef_OrderLine_ID(0);
		}
	}

	/**
	 * Get Referenced Order Line.
	 *
	 * @return Reference to corresponding Sales/Purchase Order
	 */
	public I_C_OrderLineInput getRef_OrderLine() {
		return Ref_OrderLine;
	}
	/**
	 * Set Referenced Order Line.
	 *
	 * @param Ref_OrderLine_ID Reference to corresponding Sales/Purchase Order
	 */

	public void setRef_OrderLine_ID(int Ref_OrderLine_ID) {
		if (get_ID() == 0) {
			super.setRef_OrderLine_ID(Ref_OrderLine_ID);
		}
	}

	/**
	 * Set Resource Assignment.
	 *
	 * @param S_ResourceAssignment Resource Assignment
	 */
	public void setS_ResourceAssignment(I_S_ResourceAssignmentInput S_ResourceAssignment) {
		this.S_ResourceAssignment = S_ResourceAssignment;
		MResourceAssignment foreignEntity;
		if (S_ResourceAssignment != null &&
				(foreignEntity = new Query(getCtx(), MResourceAssignment.Table_Name, MResourceAssignment.COLUMNNAME_S_ResourceAssignment_UU + "=?", get_TrxName())
						.setParameters(S_ResourceAssignment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_ResourceAssignment_ID(foreignEntity.get_ID());
		} else {
			this.setS_ResourceAssignment_ID(0);
		}
	}

	/**
	 * Get Resource Assignment.
	 *
	 * @return Resource Assignment
	 */
	public I_S_ResourceAssignmentInput getS_ResourceAssignment() {
		return S_ResourceAssignment;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	public void setUser1(I_C_ElementValueInput User1) {
		this.User1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser1_ID(foreignEntity.get_ID());
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public I_C_ElementValueInput getUser1() {
		return User1;
	}
	/**
	 * Set User Element List 1.
	 *
	 * @param User1_ID User defined list element #1
	 */

	public void setUser1_ID(int User1_ID) {
		if (get_ID() == 0) {
			super.setUser1_ID(User1_ID);
		}
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	public void setUser2(I_C_ElementValueInput User2) {
		this.User2 = User2;
		MElementValue foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser2_ID(foreignEntity.get_ID());
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public I_C_ElementValueInput getUser2() {
		return User2;
	}
	/**
	 * Set User Element List 2.
	 *
	 * @param User2_ID User defined list element #2
	 */

	public void setUser2_ID(int User2_ID) {
		if (get_ID() == 0) {
			super.setUser2_ID(User2_ID);
		}
	}
}
