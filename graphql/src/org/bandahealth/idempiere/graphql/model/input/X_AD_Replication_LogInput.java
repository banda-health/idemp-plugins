package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationLog;
import org.compiere.model.MReplicationRun;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ReplicationTable;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Replication_LogInput extends MReplicationLog implements I_AD_Replication_LogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_ReplicationTable;
	private ForeignEntityInput mAD_Replication_Run;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Replication_LogInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MReplicationLog(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Replication Log.
	 *
	 * @param AD_Replication_Log_ID Data Replication Log Details
	 */

	public void setAD_Replication_Log_ID(int AD_Replication_Log_ID) {
		if (get_ID() == 0) {
			super.setAD_Replication_Log_ID(AD_Replication_Log_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Replication_Log_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Replication_Log_UU();
	}

	/**
	 * Set Replication Run.
	 *
	 * @param AD_Replication_Run Data Replication Run
	 */
	@JsonProperty("AD_Replication_Run")
	public void setAD_Replication_RunInput(ForeignEntityInput AD_Replication_Run) {
		this.mAD_Replication_Run = AD_Replication_Run;
		MReplicationRun foreignEntity;
		if (get_ID() == 0 && AD_Replication_Run != null &&
				(foreignEntity = new Query(getCtx(), "AD_Replication_Run", "AD_Replication_Run_UU=?", get_TrxName())
						.setParameters(AD_Replication_Run.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Replication_Run_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Replication Run.
	 *
	 * @return Data Replication Run
	 */
	@JsonProperty("AD_Replication_Run")
	public ForeignEntityInput AD_Replication_Run() {
		return mAD_Replication_Run;
	}

	/**
	 * Set Replication Table.
	 *
	 * @param AD_ReplicationTable Data Replication Strategy Table Info
	 */
	@JsonProperty("AD_ReplicationTable")
	public void setAD_ReplicationTableInput(ForeignEntityInput AD_ReplicationTable) {
		this.mAD_ReplicationTable = AD_ReplicationTable;
		X_AD_ReplicationTable foreignEntity;
		if (AD_ReplicationTable != null &&
				(foreignEntity = new Query(getCtx(), "AD_ReplicationTable", "AD_ReplicationTable_UU=?", get_TrxName())
						.setParameters(AD_ReplicationTable.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ReplicationTable_ID(foreignEntity.get_ID());
		} else {
			super.setAD_ReplicationTable_ID(0);
		}
	}

	/**
	 * Get Replication Table.
	 *
	 * @return Data Replication Strategy Table Info
	 */
	@JsonProperty("AD_ReplicationTable")
	public ForeignEntityInput AD_ReplicationTable() {
		return mAD_ReplicationTable;
	}
}
