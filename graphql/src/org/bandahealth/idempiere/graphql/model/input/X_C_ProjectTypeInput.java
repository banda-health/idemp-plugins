package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectType;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectTypeInput extends MProjectType implements I_C_ProjectTypeInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ProjectCategory_RL;

	/**
	 * Standard constructor
	 */
	public X_C_ProjectTypeInput(String ID) {
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
	 * @param ProjectCategory_RL Project Category
	 */
	public void setProjectCategory_RL(I_AD_Ref_ListInput ProjectCategory_RL) {
		this.ProjectCategory_RL = ProjectCategory_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&ProjectCategory_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProjectCategory_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setProjectCategory(foreignEntity.getValue());
		}
	}

	/**
	 * Get Project Category.
	 *
	 * @return Project Category
	 */
	public I_AD_Ref_ListInput getProjectCategory_RL() {
		return ProjectCategory_RL;
	}
}
