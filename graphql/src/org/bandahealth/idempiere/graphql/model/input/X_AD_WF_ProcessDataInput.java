package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_ProcessData;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ProcessDataInput extends X_AD_WF_ProcessData implements I_AD_WF_ProcessDataInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_WF_ProcessInput AD_WF_Process;

	/**
	 * Standard constructor
	 */
	public X_AD_WF_ProcessDataInput(String ID) {
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
	 * Set Workflow Process.
	 *
	 * @param AD_WF_Process Actual Workflow Process Instance
	 */
	public void setAD_WF_Process(I_AD_WF_ProcessInput AD_WF_Process) {
		this.AD_WF_Process = AD_WF_Process;
		X_AD_WF_Process foreignEntity;
		if (get_ID() == 0 &&AD_WF_Process != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Process.Table_Name, X_AD_WF_Process.COLUMNNAME_AD_WF_Process_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Process_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Workflow Process.
	 *
	 * @return Actual Workflow Process Instance
	 */
	public I_AD_WF_ProcessInput getAD_WF_Process() {
		return AD_WF_Process;
	}
	/**
	 * Set Workflow Process.
	 *
	 * @param AD_WF_Process_ID Actual Workflow Process Instance
	 */

	public void setAD_WF_Process_ID(int AD_WF_Process_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_Process_ID(AD_WF_Process_ID);
		}
	}
	/**
	 * Set Workflow Process Data.
	 *
	 * @param AD_WF_ProcessData_ID Workflow Process Context
	 */

	public void setAD_WF_ProcessData_ID(int AD_WF_ProcessData_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_ProcessData_ID(AD_WF_ProcessData_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_ProcessData_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_ProcessData_UU();
	}
}
