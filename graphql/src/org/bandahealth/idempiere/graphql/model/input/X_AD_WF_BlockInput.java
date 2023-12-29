package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Block;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_Block - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_BlockInput extends X_AD_WF_Block implements I_AD_WF_BlockInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_WorkflowInput AD_Workflow;

	/**
	 * Standard constructor
	 */
	public X_AD_WF_BlockInput(String ID) {
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
		setAD_WF_Block_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_Block_UU();
	}

	/**
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	public void setAD_Workflow(I_AD_WorkflowInput AD_Workflow) {
		this.AD_Workflow = AD_Workflow;
		X_AD_Workflow foreignEntity;
		if (get_ID() == 0 &&AD_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Workflow.Table_Name, X_AD_Workflow.COLUMNNAME_AD_Workflow_UU + "=?", get_TrxName())
						.setParameters(AD_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Workflow_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public I_AD_WorkflowInput getAD_Workflow() {
		return AD_Workflow;
	}
}
