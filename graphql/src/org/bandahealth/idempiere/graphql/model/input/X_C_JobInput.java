package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_C_JobCategory;
import org.compiere.util.Env;

/**
 * Generated Model for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_JobInput extends X_C_Job implements I_C_JobInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_JobCategoryInput C_JobCategory;

	/**
	 * Standard constructor
	 */
	public X_C_JobInput(String ID) {
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
	 * Set Position.
	 *
	 * @param C_Job_ID Job Position
	 */

	public void setC_Job_ID(int C_Job_ID) {
		if (get_ID() == 0) {
			super.setC_Job_ID(C_Job_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Job_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Job_UU();
	}

	/**
	 * Set Position Category.
	 *
	 * @param C_JobCategory Job Position Category
	 */
	public void setC_JobCategory(I_C_JobCategoryInput C_JobCategory) {
		this.C_JobCategory = C_JobCategory;
		X_C_JobCategory foreignEntity;
		if (C_JobCategory != null &&
				(foreignEntity = new Query(getCtx(), X_C_JobCategory.Table_Name, X_C_JobCategory.COLUMNNAME_C_JobCategory_UU + "=?", get_TrxName())
						.setParameters(C_JobCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_JobCategory_ID(foreignEntity.get_ID());
		} else {
			this.setC_JobCategory_ID(0);
		}
	}

	/**
	 * Get Position Category.
	 *
	 * @return Job Position Category
	 */
	public I_C_JobCategoryInput getC_JobCategory() {
		return C_JobCategory;
	}
}
