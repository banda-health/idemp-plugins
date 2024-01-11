package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProductPrice;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_ProductPrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductPriceInput extends MProductPrice implements I_M_ProductPriceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_PriceList_Version;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ProductPriceInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MProductPrice(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Price List Version.
	 *
	 * @param M_PriceList_Version Identifies a unique instance of a Price List
	 */
	@JsonProperty("M_PriceList_Version")
	public void setM_PriceList_VersionInput(ForeignEntityInput M_PriceList_Version) {
		this.mM_PriceList_Version = M_PriceList_Version;
		MPriceListVersion foreignEntity;
		if (get_ID() == 0 && M_PriceList_Version != null &&
				(foreignEntity = new Query(getCtx(), "M_PriceList_Version", "M_PriceList_Version_UU=?", get_TrxName())
						.setParameters(M_PriceList_Version.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PriceList_Version_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Price List Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	@JsonProperty("M_PriceList_Version")
	public ForeignEntityInput M_PriceList_Version() {
		return mM_PriceList_Version;
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
		if (get_ID() == 0 && M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
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
	/**
	 * Set Product Price.
	 *
	 * @param M_ProductPrice_ID Intersection between a Product and a Price List Version
	 */

	public void setM_ProductPrice_ID(int M_ProductPrice_ID) {
		if (get_ID() == 0) {
			super.setM_ProductPrice_ID(M_ProductPrice_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ProductPrice_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ProductPrice_UU();
	}
}
