package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MMovementLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.MDDOrderLine;

import java.sql.ResultSet;

/**
 * Generated Model for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementLineInput extends MMovementLine implements I_M_MovementLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mDD_OrderLine;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_AttributeSetInstanceTo;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_LocatorTo;
	private ForeignEntityInput mM_Movement;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mReversalLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_MovementLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_MovementLineInput(@JsonProperty("UU") String UU) {
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
							.setParameters(DD_OrderLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setDD_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table DD_OrderLine with UU " + DD_OrderLine.getUU());
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
	 * Set Attribute Set Instance To.
	 *
	 * @param M_AttributeSetInstanceTo Target Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstanceTo")
	public void setM_AttributeSetInstanceToInput(ForeignEntityInput M_AttributeSetInstanceTo) {
		this.mM_AttributeSetInstanceTo = M_AttributeSetInstanceTo;
		if (get_ID() != 0) {
			return;
		}
		if (M_AttributeSetInstanceTo != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSetInstance_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstanceTo.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_AttributeSetInstanceTo_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UU " + M_AttributeSetInstanceTo.getUU());
			}
		} else {
			this.setM_AttributeSetInstanceTo_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance To.
	 *
	 * @return Target Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstanceTo")
	public ForeignEntityInput M_AttributeSetInstanceTo() {
		return mM_AttributeSetInstanceTo;
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
	 * Set Locator To.
	 *
	 * @param M_LocatorTo Location inventory is moved to
	 */
	@JsonProperty("M_LocatorTo")
	public void setM_LocatorToInput(ForeignEntityInput M_LocatorTo) {
		this.mM_LocatorTo = M_LocatorTo;
		if (M_LocatorTo != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocator foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
							.setParameters(M_LocatorTo.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_LocatorTo_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UU " + M_LocatorTo.getUU());
			}
		} else {
			this.setM_LocatorTo_ID(0);
		}
	}

	/**
	 * Get Locator To.
	 *
	 * @return Location inventory is moved to
	 */
	@JsonProperty("M_LocatorTo")
	public ForeignEntityInput M_LocatorTo() {
		return mM_LocatorTo;
	}

	/**
	 * Set Inventory Move.
	 *
	 * @param M_Movement Movement of Inventory
	 */
	@JsonProperty("M_Movement")
	public void setM_MovementInput(ForeignEntityInput M_Movement) {
		this.mM_Movement = M_Movement;
		if (get_ID() != 0) {
			return;
		}
		if (M_Movement != null) {
			// Since an entity was passed, make sure it's in the DB
			MMovement_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Movement", "M_Movement_UU=?", get_TrxName())
							.setParameters(M_Movement.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Movement_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Movement with UU " + M_Movement.getUU());
			}
		} else {
			this.setM_Movement_ID(0);
		}
	}

	/**
	 * Get Inventory Move.
	 *
	 * @return Movement of Inventory
	 */
	@JsonProperty("M_Movement")
	public ForeignEntityInput M_Movement() {
		return mM_Movement;
	}
	/**
	 * Set Move Line.
	 *
	 * @param M_MovementLine_ID Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine_ID")
	public void setM_MovementLine_IDFromJson(int M_MovementLine_ID) {
		if (get_ID() == 0) {
			super.setM_MovementLine_ID(M_MovementLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_MovementLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_MovementLine_UU();
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
	 * Set Reversal Line.
	 *
	 * @param ReversalLine Use to keep the reversal line ID for reversing costing purpose
	 */
	@JsonProperty("ReversalLine")
	public void setReversalLineInput(ForeignEntityInput ReversalLine) {
		this.mReversalLine = ReversalLine;
		if (ReversalLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MMovementLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_MovementLine", "M_MovementLine_UU=?", get_TrxName())
							.setParameters(ReversalLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setReversalLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_MovementLine with UU " + ReversalLine.getUU());
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
