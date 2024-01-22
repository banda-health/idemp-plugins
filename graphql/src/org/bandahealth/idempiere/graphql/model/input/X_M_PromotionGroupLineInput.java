package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_PromotionGroup;
import org.compiere.model.X_M_PromotionGroupLine;

import java.sql.ResultSet;

/**
 * Generated Model for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionGroupLineInput extends X_M_PromotionGroupLine implements I_M_PromotionGroupLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_PromotionGroup;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_PromotionGroupLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_PromotionGroupLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Promotion Group.
	 *
	 * @param M_PromotionGroup Promotion Group
	 */
	@JsonProperty("M_PromotionGroup")
	public void setM_PromotionGroupInput(ForeignEntityInput M_PromotionGroup) {
		this.mM_PromotionGroup = M_PromotionGroup;
		X_M_PromotionGroup foreignEntity;
		if (get_ID() == 0 && M_PromotionGroup != null &&
				(foreignEntity = new Query(getCtx(), "M_PromotionGroup", "M_PromotionGroup_UU=?", get_TrxName())
						.setParameters(M_PromotionGroup.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PromotionGroup_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_PromotionGroupLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_PromotionGroupLine_UU();
	}
}
