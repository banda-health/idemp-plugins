package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MReplication;
import org.compiere.model.MReplicationRun;
import org.compiere.model.Query;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Replication_Run_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Replication_RunInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MReplicationRun(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		if (get_ID() == 0 && AD_Replication != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Replication", "AD_Replication_UU=?", get_TrxName())
							.setParameters(AD_Replication.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Replication_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Replication with UUID " + AD_Replication.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Replication_Run_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
