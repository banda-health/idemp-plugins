package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MReplication;
import org.compiere.model.MReplicationRun;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Replication_RunInput extends MReplicationRun implements I_AD_Replication_RunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Replication;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Replication_RunInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MReplicationRun(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Replication.
	 *
	 * @param AD_Replication Data Replication Target
	 */
	@JsonProperty("AD_Replication")
	public void setAD_ReplicationInput(ForeignEntityInput AD_Replication) {
		this.mAD_Replication = AD_Replication;
		MReplication foreignEntity;
		if (get_ID() == 0 && AD_Replication != null &&
				(foreignEntity = new Query(getCtx(), "AD_Replication", "AD_Replication_UU=?", get_TrxName())
						.setParameters(AD_Replication.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Replication_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Replication.
	 *
	 * @return Data Replication Target
	 */
	@JsonProperty("AD_Replication")
	public ForeignEntityInput AD_Replication() {
		return mAD_Replication;
	}
	/**
	 * Set Replication Run.
	 *
	 * @param AD_Replication_Run_ID Data Replication Run
	 */

	public void setAD_Replication_Run_ID(int AD_Replication_Run_ID) {
		if (get_ID() == 0) {
			super.setAD_Replication_Run_ID(AD_Replication_Run_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Replication_Run_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Replication_Run_UU();
	}
	/**
	 * Set Replicated.
	 *
	 * @param IsReplicated The data is successfully replicated
	 */

	public void setIsReplicated(boolean IsReplicated) {
		if (get_ID() == 0) {
			super.setIsReplicated(IsReplicated);
		}
	}
}
