package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_InventoryLineResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_InventoryLineInput extends MInventoryLine implements I_M_InventoryLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mInventoryType;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_Inventory;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mReversalLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_InventoryLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_InventoryLineInput(@JsonProperty("UU") String UU) {
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
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(ForeignEntityInput C_Charge) {
		this.mC_Charge = C_Charge;
		if (C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(C_Charge.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UU " + C_Charge.getUU());
			}
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public ForeignEntityInput C_Charge() {
		return mC_Charge;
	}
	/**
	 * Set Current Cost Price.
	 *
	 * @param CurrentCostPrice The currently used cost price
	 */
	@JsonProperty("CurrentCostPrice")
	public void setCurrentCostPriceFromJson(BigDecimal CurrentCostPrice) {
		if (get_ID() == 0) {
			super.setCurrentCostPrice(CurrentCostPrice);
		}
	}

	/**
	 * Set Inventory Type.
	 *
	 * @param InventoryType Type of inventory difference
	 */
	@JsonProperty("InventoryType")
	public void setInventoryTypeInput(ForeignEntityInput InventoryType) {
		this.mInventoryType = InventoryType;
		if (InventoryType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_InventoryLineResolver.INVENTORYTYPE_UUIDS_BY_VALUE.containsValue(InventoryType.getUU())) {
				throw new AdempiereException("The reference list UU of " + InventoryType.getUU() +
						" is not in the list defined for the InventoryType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InventoryType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInventoryType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + InventoryType.getUU());
			}
		} else {
			this.setInventoryType(null);
		}
	}

	/**
	 * Get Inventory Type.
	 *
	 * @return Type of inventory difference
	 */
	@JsonProperty("InventoryType")
	public ForeignEntityInput InventoryType() {
		return mInventoryType;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
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
	 * Set Phys.Inventory.
	 *
	 * @param M_Inventory Parameters for a Physical Inventory
	 */
	@JsonProperty("M_Inventory")
	public void setM_InventoryInput(ForeignEntityInput M_Inventory) {
		this.mM_Inventory = M_Inventory;
		if (get_ID() != 0) {
			return;
		}
		if (M_Inventory != null) {
			// Since an entity was passed, make sure it's in the DB
			MInventory_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Inventory", "M_Inventory_UU=?", get_TrxName())
							.setParameters(M_Inventory.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Inventory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Inventory with UU " + M_Inventory.getUU());
			}
		} else {
			this.setM_Inventory_ID(0);
		}
	}

	/**
	 * Get Phys.Inventory.
	 *
	 * @return Parameters for a Physical Inventory
	 */
	@JsonProperty("M_Inventory")
	public ForeignEntityInput M_Inventory() {
		return mM_Inventory;
	}
	/**
	 * Set Phys.Inventory Line.
	 *
	 * @param M_InventoryLine_ID Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine_ID")
	public void setM_InventoryLine_IDFromJson(int M_InventoryLine_ID) {
		if (get_ID() == 0) {
			super.setM_InventoryLine_ID(M_InventoryLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_InventoryLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_InventoryLine_UU();
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public void setM_LocatorInput(ForeignEntityInput M_Locator) {
		this.mM_Locator = M_Locator;
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
	 * Set Quantity book.
	 *
	 * @param QtyBook Book Quantity
	 */
	@JsonProperty("QtyBook")
	public void setQtyBookFromJson(BigDecimal QtyBook) {
		if (get_ID() == 0) {
			super.setQtyBook(QtyBook);
		}
	}

	/**
	 * Set Reversal Line.
	 *
	 * @param ReversalLine Use to keep the reversal line ID for reversing costing purpose
	 */
	@JsonProperty("ReversalLine")
	public void setReversalLineInput(ForeignEntityInput ReversalLine) {
		this.mReversalLine = ReversalLine;
		if (ReversalLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInventoryLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
							.setParameters(ReversalLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setReversalLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InventoryLine with UU " + ReversalLine.getUU());
			}
		} else {
			this.setReversalLine_ID(0);
		}
	}

	/**
	 * Get Reversal Line.
	 *
	 * @return Use to keep the reversal line ID for reversing costing purpose
	 */
	@JsonProperty("ReversalLine")
	public ForeignEntityInput ReversalLine() {
		return mReversalLine;
	}
}
