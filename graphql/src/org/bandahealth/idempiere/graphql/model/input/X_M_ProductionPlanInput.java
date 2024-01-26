package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MProduction;
import org.compiere.model.MProductionPlan;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionPlanInput extends MProductionPlan implements I_M_ProductionPlanInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Production;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ProductionPlan_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ProductionPlanInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
	 * Set Production.
	 *
	 * @param M_Production Plan for producing a product
	 */
	@JsonProperty("M_Production")
	public void setM_ProductionInput(ForeignEntityInput M_Production) {
		this.mM_Production = M_Production;
		if (get_ID() != 0) {
			return;
		}
		if (M_Production != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduction foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Production", "M_Production_UU=?", get_TrxName())
							.setParameters(M_Production.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Production_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Production with UUID " + M_Production.getUUID());
			}
		} else {
			this.setM_Production_ID(0);
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
	 * Set Production Plan.
	 *
	 * @param M_ProductionPlan_ID Plan for how a product is produced
	 */

	public void setM_ProductionPlan_ID(int M_ProductionPlan_ID) {
		if (get_ID() == 0) {
			super.setM_ProductionPlan_ID(M_ProductionPlan_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ProductionPlan_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_ProductionPlan_UU();
	}
}
