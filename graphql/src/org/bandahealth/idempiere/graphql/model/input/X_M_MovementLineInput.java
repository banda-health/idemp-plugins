package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.MDDOrderLine;

import java.sql.ResultSet;

/**
 * Generated Model for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementLineInput extends MMovementLine_BH implements I_M_MovementLineInput {

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_MovementLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MMovementLine_BH(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			super.setM_AttributeSetInstance_ID(0);
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
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 && M_AttributeSetInstanceTo != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
						.setParameters(M_AttributeSetInstanceTo.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstanceTo_ID(foreignEntity.get_ID());
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
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Locator_ID(foreignEntity.get_ID());
		} else {
			super.setM_Locator_ID(0);
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
		MLocator foreignEntity;
		if (M_LocatorTo != null &&
				(foreignEntity = new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
						.setParameters(M_LocatorTo.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_LocatorTo_ID(foreignEntity.get_ID());
		} else {
			super.setM_LocatorTo_ID(0);
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
		MMovement_BH foreignEntity;
		if (get_ID() == 0 && M_Movement != null &&
				(foreignEntity = new Query(getCtx(), "M_Movement", "M_Movement_UU=?", get_TrxName())
						.setParameters(M_Movement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Movement_ID(foreignEntity.get_ID());
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

	public void setM_MovementLine_ID(int M_MovementLine_ID) {
		if (get_ID() == 0) {
			super.setM_MovementLine_ID(M_MovementLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_MovementLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
	 * Set Reversal Line.
	 *
	 * @param ReversalLine Use to keep the reversal line ID for reversing costing purpose
	 */
	@JsonProperty("ReversalLine")
	public void setReversalLineInput(ForeignEntityInput ReversalLine) {
		this.mReversalLine = ReversalLine;
		MMovementLine_BH foreignEntity;
		if (ReversalLine != null &&
				(foreignEntity = new Query(getCtx(), "M_MovementLine", "M_MovementLine_UU=?", get_TrxName())
						.setParameters(ReversalLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setReversalLine_ID(foreignEntity.get_ID());
		} else {
			super.setReversalLine_ID(0);
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
