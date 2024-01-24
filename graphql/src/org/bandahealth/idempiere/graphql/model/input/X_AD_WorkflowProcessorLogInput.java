package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WorkflowProcessor;
import org.compiere.model.X_AD_WorkflowProcessorLog;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WorkflowProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WorkflowProcessorLogInput extends X_AD_WorkflowProcessorLog implements I_AD_WorkflowProcessorLogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WorkflowProcessor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WorkflowProcessorLogInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_WorkflowProcessorLog(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Workflow Processor.
	 *
	 * @param AD_WorkflowProcessor Workflow Processor Server
	 */
	@JsonProperty("AD_WorkflowProcessor")
	public void setAD_WorkflowProcessorInput(ForeignEntityInput AD_WorkflowProcessor) {
		this.mAD_WorkflowProcessor = AD_WorkflowProcessor;
		X_AD_WorkflowProcessor foreignEntity;
		if (get_ID() == 0 && AD_WorkflowProcessor != null &&
				(foreignEntity = new Query(getCtx(), "AD_WorkflowProcessor", "AD_WorkflowProcessor_UU=?", get_TrxName())
						.setParameters(AD_WorkflowProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WorkflowProcessor_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WorkflowProcessorLog_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WorkflowProcessorLog_UU();
	}
}
