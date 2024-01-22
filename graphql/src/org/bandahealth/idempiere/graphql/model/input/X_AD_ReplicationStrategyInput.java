package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReplicationStrategyInput extends MReplicationStrategy implements I_AD_ReplicationStrategyInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mEXP_Processor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ReplicationStrategyInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MReplicationStrategy(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy_ID Data Replication Strategy
	 */

	public void setAD_ReplicationStrategy_ID(int AD_ReplicationStrategy_ID) {
		if (get_ID() == 0) {
			super.setAD_ReplicationStrategy_ID(AD_ReplicationStrategy_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_ReplicationStrategy_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_ReplicationStrategy_UU();
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
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
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
	 * Set Export Processor.
	 *
	 * @param EXP_Processor Export Processor
	 */
	@JsonProperty("EXP_Processor")
	public void setEXP_ProcessorInput(ForeignEntityInput EXP_Processor) {
		this.mEXP_Processor = EXP_Processor;
		MEXPProcessor foreignEntity;
		if (EXP_Processor != null &&
				(foreignEntity = new Query(getCtx(), "EXP_Processor", "EXP_Processor_UU=?", get_TrxName())
						.setParameters(EXP_Processor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEXP_Processor_ID(foreignEntity.get_ID());
		} else {
			super.setEXP_Processor_ID(0);
		}
	}

	/**
	 * Get Export Processor.
	 *
	 * @return Export Processor
	 */
	@JsonProperty("EXP_Processor")
	public ForeignEntityInput EXP_Processor() {
		return mEXP_Processor;
	}
}
