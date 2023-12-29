package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Category;
import org.compiere.util.Env;

/**
 * Generated Model for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_CategoryInput extends X_GL_Category implements I_GL_CategoryInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CategoryType_RL;

	/**
	 * Standard constructor
	 */
	public X_GL_CategoryInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Category Type.
	 *
	 * @param CategoryType_RL Source of the Journal with this category
	 */
	public void setCategoryType_RL(I_AD_Ref_ListInput CategoryType_RL) {
		this.CategoryType_RL = CategoryType_RL;
		MRefList foreignEntity;
		if (CategoryType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CategoryType_RL.getID())
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
	public I_AD_Ref_ListInput getCategoryType_RL() {
		return CategoryType_RL;
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
