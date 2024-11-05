package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ReplicationStrategyInput extends MReplicationStrategy implements I_AD_ReplicationStrategyInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mEXP_Processor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_ReplicationStrategy_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ReplicationStrategyInput(@JsonProperty("UU") String UU) {
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
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy_ID Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy_ID")
	public void setAD_ReplicationStrategy_IDFromJson(int AD_ReplicationStrategy_ID) {
		if (get_ID() == 0) {
			super.setAD_ReplicationStrategy_ID(AD_ReplicationStrategy_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_ReplicationStrategy_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
			}
		} else {
			this.setEntityType(null);
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
		if (EXP_Processor != null) {
			// Since an entity was passed, make sure it's in the DB
			MEXPProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "EXP_Processor", "EXP_Processor_UU=?", get_TrxName())
							.setParameters(EXP_Processor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setEXP_Processor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table EXP_Processor with UU " + EXP_Processor.getUU());
			}
		} else {
			this.setEXP_Processor_ID(0);
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
