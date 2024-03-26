package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_PromotionGroup;
import org.compiere.model.X_M_PromotionGroupLine;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionGroupLineInput extends X_M_PromotionGroupLine implements I_M_PromotionGroupLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_PromotionGroup;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_PromotionGroupLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_PromotionGroupLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
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
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Promotion Group.
	 *
	 * @param M_PromotionGroup Promotion Group
	 */
	@JsonProperty("M_PromotionGroup")
	public void setM_PromotionGroupInput(ForeignEntityInput M_PromotionGroup) {
		this.mM_PromotionGroup = M_PromotionGroup;
		if (get_ID() != 0) {
			return;
		}
		if (M_PromotionGroup != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_PromotionGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PromotionGroup", "M_PromotionGroup_UU=?", get_TrxName())
							.setParameters(M_PromotionGroup.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_PromotionGroup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PromotionGroup with UUID " + M_PromotionGroup.getUUID());
			}
		} else {
			this.setM_PromotionGroup_ID(0);
		}
	}

	/**
	 * Get Promotion Group.
	 *
	 * @return Promotion Group
	 */
	@JsonProperty("M_PromotionGroup")
	public ForeignEntityInput M_PromotionGroup() {
		return mM_PromotionGroup;
	}
	/**
	 * Set Promotion Group Line.
	 *
	 * @param M_PromotionGroupLine_ID Promotion Group Line
	 */

	public void setM_PromotionGroupLine_ID(int M_PromotionGroupLine_ID) {
		if (get_ID() == 0) {
			super.setM_PromotionGroupLine_ID(M_PromotionGroupLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_PromotionGroupLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_PromotionGroupLine_UU();
	}
}
