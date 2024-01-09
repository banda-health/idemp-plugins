package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGLCategory;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_CategoryInput extends MGLCategory implements I_GL_CategoryInput {

	 private ForeignEntityInput mAD_Org;
	 private I_AD_Ref_ListInput mCategoryType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_GL_CategoryInput(@JsonProperty("ID") String ID) {
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
	 * Set Category Type.
	 *
	 * @param CategoryType Source of the Journal with this category
	 */
	@JsonProperty("CategoryType")
	public void setCategoryTypeInput(I_AD_Ref_ListInput CategoryType) {
		this.mCategoryType = CategoryType;
		MRefList_BH foreignEntity;
		if (CategoryType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CategoryType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCategoryType(foreignEntity.getValue());
		} else {
			this.setCategoryType(null);
		}
	}

	/**
	 * Get Category Type.
	 *
	 * @return Source of the Journal with this category
	 */
	@JsonProperty("CategoryType")
	public I_AD_Ref_ListInput CategoryType() {
		return mCategoryType;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setGL_Category_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getGL_Category_UU();
	}
}
