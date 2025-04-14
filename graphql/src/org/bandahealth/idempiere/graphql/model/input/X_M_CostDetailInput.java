package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostDetail;
import org.compiere.model.MCostElement;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MMatchInv;
import org.compiere.model.MMovementLine;
import org.compiere.model.MOrg;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProjectIssue;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Cost_Collector;

import java.sql.ResultSet;

/**
 * Generated Model for M_CostDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_CostDetail_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_CostDetailInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (get_ID() != 0) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UU " + C_AcctSchema.getUU());
			}
		} else {
			this.setC_AcctSchema_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_InvoiceLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoiceLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UU " + C_InvoiceLine.getUU());
			}
		} else {
			this.setC_InvoiceLine_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_OrderLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrderLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
							.setParameters(C_OrderLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLine with UU " + C_OrderLine.getUU());
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
	 * Set Project Issue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue) {
		this.mC_ProjectIssue = C_ProjectIssue;
		if (C_ProjectIssue != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectIssue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectIssue", "C_ProjectIssue_UU=?", get_TrxName())
							.setParameters(C_ProjectIssue.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_ProjectIssue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectIssue with UU " + C_ProjectIssue.getUU());
			}
		} else {
			this.setC_ProjectIssue_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (M_AttributeSetInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSetInstance_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UU " + M_AttributeSetInstance.getUU());
			}
		} else {
			this.setM_AttributeSetInstance_ID(-1);
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
	@JsonProperty("M_CostDetail_ID")
	public void setM_CostDetail_IDFromJson(int M_CostDetail_ID) {
		if (get_ID() == 0) {
			super.setM_CostDetail_ID(M_CostDetail_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_CostDetail_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (M_CostElement != null) {
			// Since an entity was passed, make sure it's in the DB
			MCostElement foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_CostElement", "M_CostElement_UU=?", get_TrxName())
							.setParameters(M_CostElement.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_CostElement_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostElement with UU " + M_CostElement.getUU());
			}
		} else {
			this.setM_CostElement_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (M_InOutLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInOutLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
							.setParameters(M_InOutLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_InOutLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOutLine with UU " + M_InOutLine.getUU());
			}
		} else {
			this.setM_InOutLine_ID(0);
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
		if (M_InventoryLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInventoryLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
							.setParameters(M_InventoryLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_InventoryLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InventoryLine with UU " + M_InventoryLine.getUU());
			}
		} else {
			this.setM_InventoryLine_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (M_MatchInv != null) {
			// Since an entity was passed, make sure it's in the DB
			MMatchInv foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_MatchInv", "M_MatchInv_UU=?", get_TrxName())
							.setParameters(M_MatchInv.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_MatchInv_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_MatchInv with UU " + M_MatchInv.getUU());
			}
		} else {
			this.setM_MatchInv_ID(0);
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
		if (M_MovementLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MMovementLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_MovementLine", "M_MovementLine_UU=?", get_TrxName())
							.setParameters(M_MovementLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_MovementLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_MovementLine with UU " + M_MovementLine.getUU());
			}
		} else {
			this.setM_MovementLine_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
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
	 * Set Production Line.
	 *
	 * @param M_ProductionLine Document Line representing a production
	 */
	@JsonProperty("M_ProductionLine")
	public void setM_ProductionLineInput(ForeignEntityInput M_ProductionLine) {
		this.mM_ProductionLine = M_ProductionLine;
		if (M_ProductionLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MProductionLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ProductionLine", "M_ProductionLine_UU=?", get_TrxName())
							.setParameters(M_ProductionLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ProductionLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ProductionLine with UU " + M_ProductionLine.getUU());
			}
		} else {
			this.setM_ProductionLine_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (PP_Cost_Collector != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Cost_Collector foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Cost_Collector", "PP_Cost_Collector_UU=?", get_TrxName())
							.setParameters(PP_Cost_Collector.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Cost_Collector_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Cost_Collector with UU " + PP_Cost_Collector.getUU());
			}
		} else {
			this.setPP_Cost_Collector_ID(0);
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
}
