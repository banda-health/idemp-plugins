package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Activity;
import org.compiere.model.X_AD_WF_ActivityResult;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_ActivityResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ActivityResultInput extends X_AD_WF_ActivityResult implements I_AD_WF_ActivityResultInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_WF_ActivityInput AD_WF_Activity;

	/**
	 * Standard constructor
	 */
	public X_AD_WF_ActivityResultInput(String ID) {
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
	 * Set Workflow Activity.
	 *
	 * @param AD_WF_Activity Workflow Activity
	 */
	public void setAD_WF_Activity(I_AD_WF_ActivityInput AD_WF_Activity) {
		this.AD_WF_Activity = AD_WF_Activity;
		X_AD_WF_Activity foreignEntity;
		if (get_ID() == 0 &&AD_WF_Activity != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Activity.Table_Name, X_AD_WF_Activity.COLUMNNAME_AD_WF_Activity_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Activity_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Workflow Activity.
	 *
	 * @return Workflow Activity
	 */
	public I_AD_WF_ActivityInput getAD_WF_Activity() {
		return AD_WF_Activity;
	}
	/**
	 * Set Workflow Activity.
	 *
	 * @param AD_WF_Activity_ID Workflow Activity
	 */

	public void setAD_WF_Activity_ID(int AD_WF_Activity_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_Activity_ID(AD_WF_Activity_ID);
		}
	}
	/**
	 * Set Workflow Activity Result.
	 *
	 * @param AD_WF_ActivityResult_ID Result of the Workflow Process Activity
	 */

	public void setAD_WF_ActivityResult_ID(int AD_WF_ActivityResult_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_ActivityResult_ID(AD_WF_ActivityResult_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_ActivityResult_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_ActivityResult_UU();
	}
}
