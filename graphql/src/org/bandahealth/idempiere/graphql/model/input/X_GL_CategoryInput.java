package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGLCategory;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_CategoryInput extends MGLCategory implements I_GL_CategoryInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mCategoryType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_Category_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_CategoryInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MGLCategory(null, (ResultSet) null, null),
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
	 * Set Category Type.
	 *
	 * @param CategoryType Source of the Journal with this category
	 */
	@JsonProperty("CategoryType")
	public void setCategoryTypeInput(I_AD_Ref_ListInput CategoryType) {
		this.mCategoryType = CategoryType;
		MRefList_BH foreignEntity;
		if (CategoryType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CategoryType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setCategoryType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CategoryType.getUUID());
			}
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
	 * Set GL Category.
	 *
	 * @param GL_Category_ID General Ledger Category
	 */

	public void setGL_Category_ID(int GL_Category_ID) {
		if (get_ID() == 0) {
			super.setGL_Category_ID(GL_Category_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setGL_Category_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getGL_Category_UU();
	}
}
