package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_TransactionResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MLocator;
import org.compiere.model.MMovementLine;
import org.compiere.model.MOrg;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProjectIssue;
import org.compiere.model.MTransaction;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Cost_Collector;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for M_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_TransactionInput extends MTransaction implements I_M_TransactionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ProjectIssue;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_InventoryLine;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_MovementLine;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_ProductionLine;
	private ForeignEntityInput mMovementType;
	private ForeignEntityInput mPP_Cost_Collector;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_Transaction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_TransactionInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Project Issue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue) {
		this.mC_ProjectIssue = C_ProjectIssue;
		if (!is_new()) {
			return;
		}
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
		if (!is_new()) {
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
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		if (!is_new()) {
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
		if (!is_new()) {
			return;
		}
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
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public void setM_LocatorInput(ForeignEntityInput M_Locator) {
		this.mM_Locator = M_Locator;
		if (!is_new()) {
			return;
		}
		if (M_Locator != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocator foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
							.setParameters(M_Locator.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Locator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UU " + M_Locator.getUU());
			}
		} else {
			this.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public ForeignEntityInput M_Locator() {
		return mM_Locator;
	}

	/**
	 * Set Move Line.
	 *
	 * @param M_MovementLine Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine")
	public void setM_MovementLineInput(ForeignEntityInput M_MovementLine) {
		this.mM_MovementLine = M_MovementLine;
		if (!is_new()) {
			return;
		}
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
		if (!is_new()) {
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
		if (!is_new()) {
			return;
		}
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
	 * Set Inventory Transaction.
	 *
	 * @param M_Transaction_ID Inventory Transaction
	 */
	@JsonProperty("M_Transaction_ID")
	public void setM_Transaction_IDFromJson(int M_Transaction_ID) {
		if (get_ID() == 0) {
			super.setM_Transaction_ID(M_Transaction_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_Transaction_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_Transaction_UU();
	}
	/**
	 * Set Movement Date.
	 *
	 * @param MovementDate Date a product was moved in or out of inventory
	 */
	@JsonProperty("MovementDate")
	public void setMovementDateFromJson(Timestamp MovementDate) {
		if (get_ID() == 0) {
			super.setMovementDate(MovementDate);
		}
	}
	/**
	 * Set Movement Quantity.
	 *
	 * @param MovementQty Quantity of a product moved.
	 */
	@JsonProperty("MovementQty")
	public void setMovementQtyFromJson(BigDecimal MovementQty) {
		if (get_ID() == 0) {
			super.setMovementQty(MovementQty);
		}
	}

	/**
	 * Set Movement Type.
	 *
	 * @param MovementType Method of moving the inventory
	 */
	@JsonProperty("MovementType")
	public void setMovementTypeInput(ForeignEntityInput MovementType) {
		this.mMovementType = MovementType;
		if (!is_new()) {
			return;
		}
		if (MovementType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_TransactionResolver.MOVEMENTTYPE_UUIDS_BY_VALUE.containsValue(MovementType.getUU())) {
				throw new AdempiereException("The reference list UU of " + MovementType.getUU() +
						" is not in the list defined for the MovementType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MovementType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setMovementType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + MovementType.getUU());
			}
		} else {
			this.setMovementType(null);
		}
	}

	/**
	 * Get Movement Type.
	 *
	 * @return Method of moving the inventory
	 */
	@JsonProperty("MovementType")
	public ForeignEntityInput MovementType() {
		return mMovementType;
	}

	/**
	 * Set Manufacturing Cost Collector.
	 *
	 * @param PP_Cost_Collector Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public void setPP_Cost_CollectorInput(ForeignEntityInput PP_Cost_Collector) {
		this.mPP_Cost_Collector = PP_Cost_Collector;
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
