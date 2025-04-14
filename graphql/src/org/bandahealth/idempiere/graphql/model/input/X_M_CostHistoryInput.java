package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCostDetail;
import org.compiere.model.MCostElement;
import org.compiere.model.MCostHistory;
import org.compiere.model.MCostType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_CostHistoryInput extends MCostHistory implements I_M_CostHistoryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_CostDetail;
	private ForeignEntityInput mM_CostElement;
	private ForeignEntityInput mM_CostType;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_CostHistory_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_CostHistoryInput(@JsonProperty("UU") String UU) {
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
	 * @param M_CostDetail Cost Detail Information
	 */
	@JsonProperty("M_CostDetail")
	public void setM_CostDetailInput(ForeignEntityInput M_CostDetail) {
		this.mM_CostDetail = M_CostDetail;
		if (get_ID() != 0) {
			return;
		}
		if (M_CostDetail != null) {
			// Since an entity was passed, make sure it's in the DB
			MCostDetail foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_CostDetail", "M_CostDetail_UU=?", get_TrxName())
							.setParameters(M_CostDetail.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_CostDetail_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostDetail with UU " + M_CostDetail.getUU());
			}
		} else {
			this.setM_CostDetail_ID(0);
		}
	}

	/**
	 * Get Cost Detail.
	 *
	 * @return Cost Detail Information
	 */
	@JsonProperty("M_CostDetail")
	public ForeignEntityInput M_CostDetail() {
		return mM_CostDetail;
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
	 * Set Cost History.
	 *
	 * @param M_CostHistory_ID Movement history for M_Cost
	 */
	@JsonProperty("M_CostHistory_ID")
	public void setM_CostHistory_IDFromJson(int M_CostHistory_ID) {
		if (get_ID() == 0) {
			super.setM_CostHistory_ID(M_CostHistory_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_CostHistory_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_CostHistory_UU();
	}

	/**
	 * Set Cost Type.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	@JsonProperty("M_CostType")
	public void setM_CostTypeInput(ForeignEntityInput M_CostType) {
		this.mM_CostType = M_CostType;
		if (get_ID() != 0) {
			return;
		}
		if (M_CostType != null) {
			// Since an entity was passed, make sure it's in the DB
			MCostType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_CostType", "M_CostType_UU=?", get_TrxName())
							.setParameters(M_CostType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_CostType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostType with UU " + M_CostType.getUU());
			}
		} else {
			this.setM_CostType_ID(0);
		}
	}

	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	@JsonProperty("M_CostType")
	public ForeignEntityInput M_CostType() {
		return mM_CostType;
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
	 * Set New Accumulated Amt.
	 *
	 * @param NewCAmt Accumulated Amt after processing of M_CostDetail
	 */
	@JsonProperty("NewCAmt")
	public void setNewCAmtFromJson(BigDecimal NewCAmt) {
		if (get_ID() == 0) {
			super.setNewCAmt(NewCAmt);
		}
	}
	/**
	 * Set New Cost Price.
	 *
	 * @param NewCostPrice New current cost price after processing of M_CostDetail
	 */
	@JsonProperty("NewCostPrice")
	public void setNewCostPriceFromJson(BigDecimal NewCostPrice) {
		if (get_ID() == 0) {
			super.setNewCostPrice(NewCostPrice);
		}
	}
	/**
	 * Set New Accumulated Qty.
	 *
	 * @param NewCQty New Accumulated Qty after processing of M_CostDetail
	 */
	@JsonProperty("NewCQty")
	public void setNewCQtyFromJson(BigDecimal NewCQty) {
		if (get_ID() == 0) {
			super.setNewCQty(NewCQty);
		}
	}
	/**
	 * Set New Current Quantity.
	 *
	 * @param NewQty New current quantity after processing of M_CostDetail
	 */
	@JsonProperty("NewQty")
	public void setNewQtyFromJson(BigDecimal NewQty) {
		if (get_ID() == 0) {
			super.setNewQty(NewQty);
		}
	}
	/**
	 * Set Old Accumulated Amt.
	 *
	 * @param OldCAmt Old accumulated amt before the processing of M_CostDetail
	 */
	@JsonProperty("OldCAmt")
	public void setOldCAmtFromJson(BigDecimal OldCAmt) {
		if (get_ID() == 0) {
			super.setOldCAmt(OldCAmt);
		}
	}
	/**
	 * Set Old Current Cost Price.
	 *
	 * @param OldCostPrice Old current cost price before the processing of M_CostDetail
	 */
	@JsonProperty("OldCostPrice")
	public void setOldCostPriceFromJson(BigDecimal OldCostPrice) {
		if (get_ID() == 0) {
			super.setOldCostPrice(OldCostPrice);
		}
	}
	/**
	 * Set Old Accumulated Qty.
	 *
	 * @param OldCQty Old accumulated qty before the processing of M_CostDetail
	 */
	@JsonProperty("OldCQty")
	public void setOldCQtyFromJson(BigDecimal OldCQty) {
		if (get_ID() == 0) {
			super.setOldCQty(OldCQty);
		}
	}
	/**
	 * Set Old Current Quantity.
	 *
	 * @param OldQty Old current quantity before the processing of M_CostDetail
	 */
	@JsonProperty("OldQty")
	public void setOldQtyFromJson(BigDecimal OldQty) {
		if (get_ID() == 0) {
			super.setOldQty(OldQty);
		}
	}
}
