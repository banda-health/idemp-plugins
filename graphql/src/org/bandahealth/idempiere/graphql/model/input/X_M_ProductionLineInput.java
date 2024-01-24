package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MProduction;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProductionPlan;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for M_ProductionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionLineInput extends MProductionLine implements I_M_ProductionLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Production;
	private ForeignEntityInput mM_ProductionPlan;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ProductionLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ProductionLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MProductionLine(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UUID " + M_AttributeSetInstance.getUUID());
			}
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
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public void setM_LocatorInput(ForeignEntityInput M_Locator) {
		this.mM_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
							.setParameters(M_Locator.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Locator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UUID " + M_Locator.getUUID());
			}
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
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
	 * Set Production.
	 *
	 * @param M_Production Plan for producing a product
	 */
	@JsonProperty("M_Production")
	public void setM_ProductionInput(ForeignEntityInput M_Production) {
		this.mM_Production = M_Production;
		MProduction foreignEntity;
		if (get_ID() == 0 && M_Production != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Production", "M_Production_UU=?", get_TrxName())
							.setParameters(M_Production.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Production_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Production with UUID " + M_Production.getUUID());
			}
		}
	}

	/**
	 * Get Production.
	 *
	 * @return Plan for producing a product
	 */
	@JsonProperty("M_Production")
	public ForeignEntityInput M_Production() {
		return mM_Production;
	}
	/**
	 * Set Production Line.
	 *
	 * @param M_ProductionLine_ID Document Line representing a production
	 */

	public void setM_ProductionLine_ID(int M_ProductionLine_ID) {
		if (get_ID() == 0) {
			super.setM_ProductionLine_ID(M_ProductionLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ProductionLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_ProductionLine_UU();
	}

	/**
	 * Set Production Plan.
	 *
	 * @param M_ProductionPlan Plan for how a product is produced
	 */
	@JsonProperty("M_ProductionPlan")
	public void setM_ProductionPlanInput(ForeignEntityInput M_ProductionPlan) {
		this.mM_ProductionPlan = M_ProductionPlan;
		MProductionPlan foreignEntity;
		if (get_ID() == 0 && M_ProductionPlan != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_ProductionPlan", "M_ProductionPlan_UU=?", get_TrxName())
							.setParameters(M_ProductionPlan.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ProductionPlan_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ProductionPlan with UUID " + M_ProductionPlan.getUUID());
			}
		}
	}

	/**
	 * Get Production Plan.
	 *
	 * @return Plan for how a product is produced
	 */
	@JsonProperty("M_ProductionPlan")
	public ForeignEntityInput M_ProductionPlan() {
		return mM_ProductionPlan;
	}
	/**
	 * Set Product Type.
	 *
	 * @param ProductType Type of product
	 */

	public void setProductType(String ProductType) {
		if (get_ID() == 0) {
			super.setProductType(ProductType);
		}
	}
	/**
	 * Set Available Quantity.
	 *
	 * @param QtyAvailable Available Quantity (On Hand - Reserved)
	 */

	public void setQtyAvailable(BigDecimal QtyAvailable) {
		if (get_ID() == 0) {
			super.setQtyAvailable(QtyAvailable);
		}
	}
}
