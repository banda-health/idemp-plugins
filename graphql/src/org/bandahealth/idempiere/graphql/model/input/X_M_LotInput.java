package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLot;
import org.compiere.model.MLotCtl;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LotInput extends MLot implements I_M_LotInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mM_LotCtl;
	 private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_LotInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Lot_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Lot_UU();
	}

	/**
	 * Set Lot Control.
	 *
	 * @param M_LotCtl Product Lot Control
	 */
	@JsonProperty("M_LotCtl")
	public void setM_LotCtlInput(ForeignEntityInput M_LotCtl) {
		this.mM_LotCtl = M_LotCtl;
		MLotCtl foreignEntity;
		if (get_ID() == 0 &&M_LotCtl != null &&
				(foreignEntity = new Query(getCtx(), MLotCtl.Table_Name, MLotCtl.COLUMNNAME_M_LotCtl_UU + "=?", get_TrxName())
						.setParameters(M_LotCtl.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_LotCtl_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Lot Control.
	 *
	 * @return Product Lot Control
	 */
	@JsonProperty("M_LotCtl")
	public ForeignEntityInput M_LotCtl() {
		return mM_LotCtl;
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
		if (get_ID() == 0 &&M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
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
}
