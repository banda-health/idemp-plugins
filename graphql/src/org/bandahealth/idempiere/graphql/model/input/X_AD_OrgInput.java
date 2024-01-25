package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgInput extends MOrg implements I_AD_OrgInput {

	private ForeignEntityInput mAD_ReplicationStrategy;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Org_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_OrgInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MOrg(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Org_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Org_UU();
	}

	/**
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public void setAD_ReplicationStrategyInput(ForeignEntityInput AD_ReplicationStrategy) {
		this.mAD_ReplicationStrategy = AD_ReplicationStrategy;
		if (AD_ReplicationStrategy != null) {
			// Since an entity was passed, make sure it's in the DB
			MReplicationStrategy foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ReplicationStrategy", "AD_ReplicationStrategy_UU=?", get_TrxName())
							.setParameters(AD_ReplicationStrategy.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ReplicationStrategy with UUID " + AD_ReplicationStrategy.getUUID());
			}
		} else {
			this.setAD_ReplicationStrategy_ID(0);
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
}
