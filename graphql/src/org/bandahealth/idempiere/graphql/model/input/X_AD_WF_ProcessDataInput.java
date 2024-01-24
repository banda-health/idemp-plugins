package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_ProcessData;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WF_ProcessDataInput extends X_AD_WF_ProcessData implements I_AD_WF_ProcessDataInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WF_Process;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WF_ProcessDataInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_WF_ProcessData(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Workflow Process.
	 *
	 * @param AD_WF_Process Actual Workflow Process Instance
	 */
	@JsonProperty("AD_WF_Process")
	public void setAD_WF_ProcessInput(ForeignEntityInput AD_WF_Process) {
		this.mAD_WF_Process = AD_WF_Process;
		X_AD_WF_Process foreignEntity;
		if (get_ID() == 0 && AD_WF_Process != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Process", "AD_WF_Process_UU=?", get_TrxName())
						.setParameters(AD_WF_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Process_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Workflow Process.
	 *
	 * @return Actual Workflow Process Instance
	 */
	@JsonProperty("AD_WF_Process")
	public ForeignEntityInput AD_WF_Process() {
		return mAD_WF_Process;
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
