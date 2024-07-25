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
 * @version Release 11 - $Id$
 */
public class X_AD_Replication_RunInput extends MReplicationRun implements I_AD_Replication_RunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Replication;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Replication_Run_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Replication_RunInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Replication != null) {
			// Since an entity was passed, make sure it's in the DB
			MReplication foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Replication", "AD_Replication_UU=?", get_TrxName())
							.setParameters(AD_Replication.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Replication_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Replication with UU " + AD_Replication.getUU());
			}
		} else {
			this.setAD_Replication_ID(0);
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
	@JsonProperty("AD_Replication_Run_ID")
	public void setAD_Replication_Run_IDFromJson(int AD_Replication_Run_ID) {
		if (get_ID() == 0) {
			super.setAD_Replication_Run_ID(AD_Replication_Run_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Replication_Run_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Replication_Run_UU();
	}
	/**
	 * Set Replicated.
	 *
	 * @param IsReplicated The data is successfully replicated
	 */
	@JsonProperty("IsReplicated")
	public void setIsReplicatedFromJson(boolean IsReplicated) {
		if (get_ID() == 0) {
			super.setIsReplicated(IsReplicated);
		}
	}
}
