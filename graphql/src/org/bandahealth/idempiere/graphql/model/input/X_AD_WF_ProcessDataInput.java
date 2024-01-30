package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_ProcessData;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ProcessDataInput extends X_AD_WF_ProcessData implements I_AD_WF_ProcessDataInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WF_Process;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_WF_ProcessData_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_WF_ProcessDataInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_WF_Process != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Process foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Process", "AD_WF_Process_UU=?", get_TrxName())
							.setParameters(AD_WF_Process.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_WF_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Process with UUID " + AD_WF_Process.getUUID());
			}
		} else {
			this.setAD_WF_Process_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_WF_ProcessData_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_WF_ProcessData_UU();
	}
}
