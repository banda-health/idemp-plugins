package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationStrategyInput extends MReplicationStrategy implements I_AD_ReplicationStrategyInput {

	 private I_AD_EntityTypeInput mAD_EntityType;
	 private I_AD_OrgInput mAD_Org;
	 private I_EXP_ProcessorInput mEXP_Processor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ReplicationStrategyInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
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
	public void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
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
	public I_AD_EntityTypeInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Export Processor.
	 *
	 * @param EXP_Processor Export Processor
	 */
	@JsonProperty("EXP_Processor")
	public void setEXP_ProcessorInput(I_EXP_ProcessorInput EXP_Processor) {
		this.mEXP_Processor = EXP_Processor;
		MEXPProcessor foreignEntity;
		if (EXP_Processor != null &&
				(foreignEntity = new Query(getCtx(), MEXPProcessor.Table_Name, MEXPProcessor.COLUMNNAME_EXP_Processor_UU + "=?", get_TrxName())
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
	public I_EXP_ProcessorInput EXP_Processor() {
		return mEXP_Processor;
	}
}
