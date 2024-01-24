package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectType;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectTypeInput extends MProjectType implements I_C_ProjectTypeInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mProjectCategory;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ProjectTypeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MProjectType(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Project Type.
	 *
	 * @param C_ProjectType_ID Type of the project
	 */

	public void setC_ProjectType_ID(int C_ProjectType_ID) {
		if (get_ID() == 0) {
			super.setC_ProjectType_ID(C_ProjectType_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ProjectType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ProjectType_UU();
	}

	/**
	 * Set Project Category.
	 *
	 * @param ProjectCategory Project Category
	 */
	@JsonProperty("ProjectCategory")
	public void setProjectCategoryInput(I_AD_Ref_ListInput ProjectCategory) {
		this.mProjectCategory = ProjectCategory;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&ProjectCategory != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProjectCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setProjectCategory(foreignEntity.getValue());
		}
	}

	/**
	 * Get Project Category.
	 *
	 * @return Project Category
	 */
	@JsonProperty("ProjectCategory")
	public I_AD_Ref_ListInput ProjectCategory() {
		return mProjectCategory;
	}
}
