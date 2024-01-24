package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostDetail;
import org.compiere.model.MCostElement;
import org.compiere.model.MInOutLine;
import org.compiere.model.MMatchInv;
import org.compiere.model.MOrg;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProjectIssue;
import org.compiere.model.Query;
import org.eevolution.model.X_PP_Cost_Collector;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for M_CostDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostDetailInput extends MCostDetail implements I_M_CostDetailInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_InvoiceLine;
	private ForeignEntityInput mC_OrderLine;
	private ForeignEntityInput mC_ProjectIssue;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_CostElement;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_InventoryLine;
	private ForeignEntityInput mM_MatchInv;
	private ForeignEntityInput mM_MovementLine;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_ProductionLine;
	private ForeignEntityInput mPP_Cost_Collector;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_CostDetailInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCostDetail(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine) {
		this.mC_InvoiceLine = C_InvoiceLine;
		MInvoiceLine_BH foreignEntity;
		if (get_ID() == 0 && C_InvoiceLine != null &&
				(foreignEntity = new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
						.setParameters(C_InvoiceLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_InvoiceLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public ForeignEntityInput C_InvoiceLine() {
		return mC_InvoiceLine;
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
		if (get_ID() == 0 && C_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
						.setParameters(C_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderLine_ID(foreignEntity.get_ID());
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
	 * Set Project Issue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue) {
		this.mC_ProjectIssue = C_ProjectIssue;
		MProjectIssue foreignEntity;
		if (C_ProjectIssue != null &&
				(foreignEntity = new Query(getCtx(), "C_ProjectIssue", "C_ProjectIssue_UU=?", get_TrxName())
						.setParameters(C_ProjectIssue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectIssue_ID(foreignEntity.get_ID());
		} else {
			super.setC_ProjectIssue_ID(0);
		}
	}

	/**
	 * Get Project Issue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public ForeignEntityInput C_ProjectIssue() {
		return mC_ProjectIssue;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 && M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public ForeignEntityInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}
	/**
	 * Set Cost Detail.
	 *
	 * @param M_CostDetail_ID Cost Detail Information
	 */

	public void setM_CostDetail_ID(int M_CostDetail_ID) {
		if (get_ID() == 0) {
			super.setM_CostDetail_ID(M_CostDetail_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_CostDetail_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_CostDetail_UU();
	}

	/**
	 * Set Cost Element.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	@JsonProperty("M_CostElement")
	public void setM_CostElementInput(ForeignEntityInput M_CostElement) {
		this.mM_CostElement = M_CostElement;
		MCostElement foreignEntity;
		if (get_ID() == 0 && M_CostElement != null &&
				(foreignEntity = new Query(getCtx(), "M_CostElement", "M_CostElement_UU=?", get_TrxName())
						.setParameters(M_CostElement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_CostElement_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	@JsonProperty("M_CostElement")
	public ForeignEntityInput M_CostElement() {
		return mM_CostElement;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 && M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOutLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public ForeignEntityInput M_InOutLine() {
		return mM_InOutLine;
	}

	/**
	 * Set Phys.Inventory Line.
	 *
	 * @param M_InventoryLine Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public void setM_InventoryLineInput(ForeignEntityInput M_InventoryLine) {
		this.mM_InventoryLine = M_InventoryLine;
		MInventoryLine_BH foreignEntity;
		if (M_InventoryLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
						.setParameters(M_InventoryLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InventoryLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_InventoryLine_ID(0);
		}
	}

	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public ForeignEntityInput M_InventoryLine() {
		return mM_InventoryLine;
	}

	/**
	 * Set Match Invoice.
	 *
	 * @param M_MatchInv Match Shipment/Receipt to Invoice
	 */
	@JsonProperty("M_MatchInv")
	public void setM_MatchInvInput(ForeignEntityInput M_MatchInv) {
		this.mM_MatchInv = M_MatchInv;
		MMatchInv foreignEntity;
		if (get_ID() == 0 && M_MatchInv != null &&
				(foreignEntity = new Query(getCtx(), "M_MatchInv", "M_MatchInv_UU=?", get_TrxName())
						.setParameters(M_MatchInv.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_MatchInv_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Match Invoice.
	 *
	 * @return Match Shipment/Receipt to Invoice
	 */
	@JsonProperty("M_MatchInv")
	public ForeignEntityInput M_MatchInv() {
		return mM_MatchInv;
	}

	/**
	 * Set Move Line.
	 *
	 * @param M_MovementLine Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine")
	public void setM_MovementLineInput(ForeignEntityInput M_MovementLine) {
		this.mM_MovementLine = M_MovementLine;
		MMovementLine_BH foreignEntity;
		if (M_MovementLine != null &&
				(foreignEntity = new Query(getCtx(), "M_MovementLine", "M_MovementLine_UU=?", get_TrxName())
						.setParameters(M_MovementLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_MovementLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_MovementLine_ID(0);
		}
	}

	/**
	 * Get Move Line.
	 *
	 * @return Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine")
	public ForeignEntityInput M_MovementLine() {
		return mM_MovementLine;
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
		if (get_ID() == 0 && M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
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
	 * Set Production Line.
	 *
	 * @param M_ProductionLine Document Line representing a production
	 */
	@JsonProperty("M_ProductionLine")
	public void setM_ProductionLineInput(ForeignEntityInput M_ProductionLine) {
		this.mM_ProductionLine = M_ProductionLine;
		MProductionLine foreignEntity;
		if (M_ProductionLine != null &&
				(foreignEntity = new Query(getCtx(), "M_ProductionLine", "M_ProductionLine_UU=?", get_TrxName())
						.setParameters(M_ProductionLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductionLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_ProductionLine_ID(0);
		}
	}

	/**
	 * Get Production Line.
	 *
	 * @return Document Line representing a production
	 */
	@JsonProperty("M_ProductionLine")
	public ForeignEntityInput M_ProductionLine() {
		return mM_ProductionLine;
	}

	/**
	 * Set Manufacturing Cost Collector.
	 *
	 * @param PP_Cost_Collector Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public void setPP_Cost_CollectorInput(ForeignEntityInput PP_Cost_Collector) {
		this.mPP_Cost_Collector = PP_Cost_Collector;
		X_PP_Cost_Collector foreignEntity;
		if (get_ID() == 0 && PP_Cost_Collector != null &&
				(foreignEntity = new Query(getCtx(), "PP_Cost_Collector", "PP_Cost_Collector_UU=?", get_TrxName())
						.setParameters(PP_Cost_Collector.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Cost_Collector_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public ForeignEntityInput PP_Cost_Collector() {
		return mPP_Cost_Collector;
	}
	/**
	 * Set Price.
	 *
	 * @param Price Price
	 */

	public void setPrice(BigDecimal Price) {
		if (get_ID() == 0) {
			super.setPrice(Price);
		}
	}
}
