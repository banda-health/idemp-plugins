package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Workflow;

/**
 * Generated Interface for AD_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WorkflowInput extends I_AD_Workflow {

	/**
	 * Set AccessLevel.
	 *
	 * @param AccessLevel Access Level required
	 */
	void setAccessLevelInput(I_AD_Ref_ListInput AccessLevel);

	/**
	 * Get AccessLevel.
	 *
	 * @return Access Level required
	 */
	I_AD_Ref_ListInput AccessLevel();

	/**
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelpInput(I_AD_CtxHelpInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	I_AD_CtxHelpInput AD_CtxHelp();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(I_AD_TableInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	I_AD_TableInput AD_Table();

	/**
	 * Set AD_WF_Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	void setAD_WF_NodeInput(I_AD_WF_NodeInput AD_WF_Node);

	/**
	 * Get AD_WF_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	I_AD_WF_NodeInput AD_WF_Node();

	/**
	 * Set AD_WF_Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	void setAD_WF_ResponsibleInput(I_AD_WF_ResponsibleInput AD_WF_Responsible);

	/**
	 * Get AD_WF_Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	I_AD_WF_ResponsibleInput AD_WF_Responsible();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set AD_WorkflowProcessor.
	 *
	 * @param AD_WorkflowProcessor Workflow Processor Server
	 */
	void setAD_WorkflowProcessorInput(I_AD_WorkflowProcessorInput AD_WorkflowProcessor);

	/**
	 * Get AD_WorkflowProcessor.
	 *
	 * @return Workflow Processor Server
	 */
	I_AD_WorkflowProcessorInput AD_WorkflowProcessor();

	/**
	 * Set DurationUnit.
	 *
	 * @param DurationUnit Unit of Duration
	 */
	void setDurationUnitInput(I_AD_Ref_ListInput DurationUnit);

	/**
	 * Get DurationUnit.
	 *
	 * @return Unit of Duration
	 */
	I_AD_Ref_ListInput DurationUnit();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput AD_EntityType();

	/**
	 * Set ProcessType.
	 *
	 * @param ProcessType ProcessType
	 */
	void setProcessTypeInput(I_AD_Ref_ListInput ProcessType);

	/**
	 * Get ProcessType.
	 *
	 * @return ProcessType
	 */
	I_AD_Ref_ListInput ProcessType();

	/**
	 * Set PublishStatus.
	 *
	 * @param PublishStatus Status of Publication
	 */
	void setPublishStatusInput(I_AD_Ref_ListInput PublishStatus);

	/**
	 * Get PublishStatus.
	 *
	 * @return Status of Publication
	 */
	I_AD_Ref_ListInput PublishStatus();

	/**
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_ResourceInput(I_S_ResourceInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	I_S_ResourceInput S_Resource();

	/**
	 * Set WorkflowType.
	 *
	 * @param WorkflowType Type of Workflow
	 */
	void setWorkflowTypeInput(I_AD_Ref_ListInput WorkflowType);

	/**
	 * Get WorkflowType.
	 *
	 * @return Type of Workflow
	 */
	I_AD_Ref_ListInput WorkflowType();
}
