package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgInput extends MOrg implements I_AD_OrgInput {

	 private I_AD_ReplicationStrategyInput AD_ReplicationStrategy;

	/**
	 * Standard constructor
	 */
	public X_AD_OrgInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Org_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Org_UU();
	}

	/**
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	public void setAD_ReplicationStrategy(I_AD_ReplicationStrategyInput AD_ReplicationStrategy) {
		this.AD_ReplicationStrategy = AD_ReplicationStrategy;
		MReplicationStrategy foreignEntity;
		if (AD_ReplicationStrategy != null &&
				(foreignEntity = new Query(getCtx(), MReplicationStrategy.Table_Name, MReplicationStrategy.COLUMNNAME_AD_ReplicationStrategy_UU + "=?", get_TrxName())
						.setParameters(AD_ReplicationStrategy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
		} else {
			this.setAD_ReplicationStrategy_ID(0);
		}
	}

	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	public I_AD_ReplicationStrategyInput getAD_ReplicationStrategy() {
		return AD_ReplicationStrategy;
	}
}
