package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MWFActivityApprover;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Activity;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_ActivityApprover - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ActivityApproverInput extends MWFActivityApprover implements I_AD_WF_ActivityApproverInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_UserInput AD_User;
	 private I_AD_WF_ActivityInput AD_WF_Activity;

	/**
	 * Standard constructor
	 */
	public X_AD_WF_ActivityApproverInput(String ID) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_ActivityApprover_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_ActivityApprover_UU();
	}
}
