package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MReplication;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for AD_Replication - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReplicationInput extends MReplication implements I_AD_ReplicationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_ReplicationStrategy;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ReplicationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MReplication(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * @param AD_Replication_ID Data Replication Target
	 */

	public void setAD_Replication_ID(int AD_Replication_ID) {
		if (get_ID() == 0) {
			super.setAD_Replication_ID(AD_Replication_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Replication_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Replication_UU();
	}

	/**
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public void setAD_ReplicationStrategyInput(ForeignEntityInput AD_ReplicationStrategy) {
		this.mAD_ReplicationStrategy = AD_ReplicationStrategy;
		MReplicationStrategy foreignEntity;
		if (AD_ReplicationStrategy != null &&
				(foreignEntity = new Query(getCtx(), "AD_ReplicationStrategy", "AD_ReplicationStrategy_UU=?", get_TrxName())
						.setParameters(AD_ReplicationStrategy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
		} else {
			super.setAD_ReplicationStrategy_ID(0);
		}
	}

	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public ForeignEntityInput AD_ReplicationStrategy() {
		return mAD_ReplicationStrategy;
	}
	/**
	 * Set Date last run.
	 *
	 * @param DateLastRun Date the process was last run.
	 */

	public void setDateLastRun(Timestamp DateLastRun) {
		if (get_ID() == 0) {
			super.setDateLastRun(DateLastRun);
		}
	}
}
