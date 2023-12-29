package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ReplicationStrategy;
import org.compiere.util.Env;

/**
 * Generated Model for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationStrategyInput extends X_AD_ReplicationStrategy implements I_AD_ReplicationStrategyInput {

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_EXP_ProcessorInput EXP_Processor;

	/**
	 * Standard constructor
	 */
	public X_AD_ReplicationStrategyInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
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
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.getEntityType());
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}
	/**
	 * Set Entity Type.
	 *
	 * @param EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */

	public void setEntityType(String EntityType) {
		if (get_ID() == 0) {
			super.setEntityType(EntityType);
		}
	}

	/**
	 * Set Export Processor.
	 *
	 * @param EXP_Processor Export Processor
	 */
	public void setEXP_Processor(I_EXP_ProcessorInput EXP_Processor) {
		this.EXP_Processor = EXP_Processor;
		MEXPProcessor foreignEntity;
		if (EXP_Processor != null &&
				(foreignEntity = new Query(getCtx(), MEXPProcessor.Table_Name, MEXPProcessor.COLUMNNAME_EXP_Processor_UU + "=?", get_TrxName())
						.setParameters(EXP_Processor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEXP_Processor_ID(foreignEntity.get_ID());
		} else {
			this.setEXP_Processor_ID(0);
		}
	}

	/**
	 * Get Export Processor.
	 *
	 * @return Export Processor
	 */
	public I_EXP_ProcessorInput getEXP_Processor() {
		return EXP_Processor;
	}
}
