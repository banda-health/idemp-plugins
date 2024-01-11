package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.model.X_B_TopicType;

import java.sql.ResultSet;

/**
 * Generated Model for B_TopicType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_TopicTypeInput extends X_B_TopicType implements I_B_TopicTypeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_PriceList;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_ProductMember;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_B_TopicTypeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_B_TopicType(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Topic Type.
	 *
	 * @param B_TopicType_ID Auction Topic Type
	 */

	public void setB_TopicType_ID(int B_TopicType_ID) {
		if (get_ID() == 0) {
			super.setB_TopicType_ID(B_TopicType_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setB_TopicType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getB_TopicType_UU();
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public void setM_PriceListInput(ForeignEntityInput M_PriceList) {
		this.mM_PriceList = M_PriceList;
		MPriceList foreignEntity;
		if (M_PriceList != null &&
				(foreignEntity = new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
						.setParameters(M_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PriceList_ID(foreignEntity.get_ID());
		} else {
			super.setM_PriceList_ID(0);
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public ForeignEntityInput M_PriceList() {
		return mM_PriceList;
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
	 * Set Membership.
	 *
	 * @param M_ProductMember Product used to determine the price of the membership for the topic type
	 */
	@JsonProperty("M_ProductMember")
	public void setM_ProductMemberInput(ForeignEntityInput M_ProductMember) {
		this.mM_ProductMember = M_ProductMember;
		MProduct_BH foreignEntity;
		if (M_ProductMember != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_ProductMember.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductMember_ID(foreignEntity.get_ID());
		} else {
			super.setM_ProductMember_ID(0);
		}
	}

	/**
	 * Get Membership.
	 *
	 * @return Product used to determine the price of the membership for the topic type
	 */
	@JsonProperty("M_ProductMember")
	public ForeignEntityInput M_ProductMember() {
		return mM_ProductMember;
	}
}
