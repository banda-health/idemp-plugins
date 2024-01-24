package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ReplicationTable;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ReplicationTable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReplicationTableInput extends X_AD_ReplicationTable implements I_AD_ReplicationTableInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_ReplicationStrategy;
	private ForeignEntityInput mAD_Table;
	private I_AD_Ref_ListInput mReplicationType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ReplicationTable_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ReplicationTableInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_ReplicationTable(null, (ResultSet) null, null),
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
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public void setAD_ReplicationStrategyInput(ForeignEntityInput AD_ReplicationStrategy) {
		this.mAD_ReplicationStrategy = AD_ReplicationStrategy;
		MReplicationStrategy foreignEntity;
		if (get_ID() == 0 && AD_ReplicationStrategy != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_ReplicationStrategy", "AD_ReplicationStrategy_UU=?", get_TrxName())
							.setParameters(AD_ReplicationStrategy.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ReplicationStrategy with UUID " + AD_ReplicationStrategy.getUUID());
			}
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
	 * Set Replication Table.
	 *
	 * @param AD_ReplicationTable_ID Data Replication Strategy Table Info
	 */

	public void setAD_ReplicationTable_ID(int AD_ReplicationTable_ID) {
		if (get_ID() == 0) {
			super.setAD_ReplicationTable_ID(AD_ReplicationTable_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_ReplicationTable_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_ReplicationTable_UU();
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable_BH foreignEntity;
		if (get_ID() == 0 && AD_Table != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
			}
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
			}
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Replication Type.
	 *
	 * @param ReplicationType Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public void setReplicationTypeInput(I_AD_Ref_ListInput ReplicationType) {
		this.mReplicationType = ReplicationType;
		MRefList_BH foreignEntity;
		if (ReplicationType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ReplicationType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setReplicationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ReplicationType.getUUID());
			}
		} else {
			this.setReplicationType(null);
		}
	}

	/**
	 * Get Replication Type.
	 *
	 * @return Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public I_AD_Ref_ListInput ReplicationType() {
		return mReplicationType;
	}
}
