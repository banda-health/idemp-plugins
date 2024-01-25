package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
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
 * @version Release 7.1 - $Id$
 */
public class X_M_InventoryLineInput extends MInventoryLine_BH implements I_M_InventoryLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_Inventory;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mReversalLine;
	private I_AD_Ref_ListInput mInventoryType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_InventoryLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_InventoryLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MInventoryLine_BH(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
	 * Set Number of Order Lines.
	 *
	 * @param BH_NumOrderLines The number of order lines on an order
	 */

	public void setBH_NumOrderLines(int BH_NumOrderLines) {
		if (get_ID() == 0) {
			super.setBH_NumOrderLines(BH_NumOrderLines);
		}
	}
	/**
	 * Set Document Status.
	 *
	 * @param BH_OrderDocStatus The current status of the document
	 */

	public void setBH_OrderDocStatus(String BH_OrderDocStatus) {
		if (get_ID() == 0) {
			super.setBH_OrderDocStatus(BH_OrderDocStatus);
		}
	}
	/**
	 * Set Requires Expiration.
	 *
	 * @param BH_RequiresExpiration Requires Expiration
	 */

	public void setBH_RequiresExpiration(boolean BH_RequiresExpiration) {
		if (get_ID() == 0) {
			super.setBH_RequiresExpiration(BH_RequiresExpiration);
		}
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
							.setParameters(C_Charge.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UUID " + C_Charge.getUUID());
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

	public void setCurrentCostPrice(BigDecimal CurrentCostPrice) {
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
	public void setInventoryTypeInput(I_AD_Ref_ListInput InventoryType) {
		this.mInventoryType = InventoryType;
		if (InventoryType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InventoryType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setInventoryType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + InventoryType.getUUID());
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
	public I_AD_Ref_ListInput InventoryType() {
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
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UUID " + M_AttributeSetInstance.getUUID());
			}
		} else {
			this.setM_AttributeSetInstance_ID(0);
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
							.setParameters(M_Inventory.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Inventory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Inventory with UUID " + M_Inventory.getUUID());
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

	public void setM_InventoryLine_ID(int M_InventoryLine_ID) {
		if (get_ID() == 0) {
			super.setM_InventoryLine_ID(M_InventoryLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_InventoryLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
							.setParameters(M_Locator.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Locator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UUID " + M_Locator.getUUID());
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
	 * Set Quantity book.
	 *
	 * @param QtyBook Book Quantity
	 */

	public void setQtyBook(BigDecimal QtyBook) {
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
			MInventoryLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
							.setParameters(ReversalLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setReversalLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InventoryLine with UUID " + ReversalLine.getUUID());
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
	/**
	 * Set UPC/EAN.
	 *
	 * @param UPC Bar Code (Universal Product Code or its superset European Article Number)
	 */

	public void setUPC(String UPC) {
		if (get_ID() == 0) {
			super.setUPC(UPC);
		}
	}
	/**
	 * Set Search Key.
	 *
	 * @param Value Search key for the record in the format required - must be unique
	 */

	public void setValue(String Value) {
		if (get_ID() == 0) {
			super.setValue(Value);
		}
	}
}
