package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Product_CategoryDefaultInput extends MBHProductCategoryDefault implements I_BH_Product_CategoryDefaultInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mBH_Product_Category_Type;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_Product_CategoryDefaultInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHProductCategoryDefault(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set BH Product Category Type.
	 *
	 * @param BH_Product_Category_Type Contains a character the is linked to a ref list to determine types of product categories
	 */
	@JsonProperty("BH_Product_Category_Type")
	public void setBH_Product_Category_TypeInput(I_AD_Ref_ListInput BH_Product_Category_Type) {
		this.mBH_Product_Category_Type = BH_Product_Category_Type;
		MRefList_BH foreignEntity;
		if (BH_Product_Category_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_Product_Category_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Product_Category_Type(foreignEntity.getValue());
		} else {
			this.setBH_Product_Category_Type(null);
		}
	}

	/**
	 * Get BH Product Category Type.
	 *
	 * @return Contains a character the is linked to a ref list to determine types of product categories
	 */
	@JsonProperty("BH_Product_Category_Type")
	public I_AD_Ref_ListInput BH_Product_Category_Type() {
		return mBH_Product_Category_Type;
	}
	/**
	 * Set BH_Product_CategoryDefault.
	 *
	 * @param BH_Product_CategoryDefault_ID BH_Product_CategoryDefault
	 */

	public void setBH_Product_CategoryDefault_ID(int BH_Product_CategoryDefault_ID) {
		if (get_ID() == 0) {
			super.setBH_Product_CategoryDefault_ID(BH_Product_CategoryDefault_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Product_CategoryDefault_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_Product_CategoryDefault_UU();
	}
}
