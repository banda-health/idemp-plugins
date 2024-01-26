package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WorkflowProcessor;
import org.compiere.model.X_AD_WorkflowProcessorLog;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WorkflowProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowProcessorLogInput extends X_AD_WorkflowProcessorLog implements I_AD_WorkflowProcessorLogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WorkflowProcessor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_WorkflowProcessorLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_WorkflowProcessorLogInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Workflow Processor.
	 *
	 * @param AD_WorkflowProcessor Workflow Processor Server
	 */
	@JsonProperty("AD_WorkflowProcessor")
	public void setAD_WorkflowProcessorInput(ForeignEntityInput AD_WorkflowProcessor) {
		this.mAD_WorkflowProcessor = AD_WorkflowProcessor;
		if (get_ID() != 0) {
			return;
		}
		if (AD_WorkflowProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WorkflowProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WorkflowProcessor", "AD_WorkflowProcessor_UU=?", get_TrxName())
							.setParameters(AD_WorkflowProcessor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_WorkflowProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WorkflowProcessor with UUID " + AD_WorkflowProcessor.getUUID());
			}
		} else {
			this.setAD_WorkflowProcessor_ID(0);
		}
	}

	/**
	 * Get Workflow Processor.
	 *
	 * @return Workflow Processor Server
	 */
	@JsonProperty("AD_WorkflowProcessor")
	public ForeignEntityInput AD_WorkflowProcessor() {
		return mAD_WorkflowProcessor;
	}
	/**
	 * Set Workflow Processorl Log.
	 *
	 * @param AD_WorkflowProcessorLog_ID Result of the execution of the Workflow Processor
	 */

	public void setAD_WorkflowProcessorLog_ID(int AD_WorkflowProcessorLog_ID) {
		if (get_ID() == 0) {
			super.setAD_WorkflowProcessorLog_ID(AD_WorkflowProcessorLog_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_WorkflowProcessorLog_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_WorkflowProcessorLog_UU();
	}
}
