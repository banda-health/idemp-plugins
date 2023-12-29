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
	 * Set AccessLevel_RL.
	 *
	 * @param AccessLevel_RL Access Level required
	 */
	void setAccessLevel_RL(I_AD_Ref_ListInput AccessLevel_RL);

	/**
	 * Get AccessLevel_RL.
	 *
	 * @return Access Level required
	 */
	I_AD_Ref_ListInput getAccessLevel_RL();

	/**
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelp(I_AD_CtxHelpInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	I_AD_CtxHelpInput getAD_CtxHelp();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_Table(I_AD_TableInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	I_AD_TableInput getAD_Table();

	/**
	 * Set AD_WF_Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	void setAD_WF_Node(I_AD_WF_NodeInput AD_WF_Node);

	/**
	 * Get AD_WF_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	I_AD_WF_NodeInput getAD_WF_Node();

	/**
	 * Set AD_WF_Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	void setAD_WF_Responsible(I_AD_WF_ResponsibleInput AD_WF_Responsible);

	/**
	 * Get AD_WF_Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	I_AD_WF_ResponsibleInput getAD_WF_Responsible();

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
	void setAD_WorkflowProcessor(I_AD_WorkflowProcessorInput AD_WorkflowProcessor);

	/**
	 * Get AD_WorkflowProcessor.
	 *
	 * @return Workflow Processor Server
	 */
	I_AD_WorkflowProcessorInput getAD_WorkflowProcessor();

	/**
	 * Set DurationUnit_RL.
	 *
	 * @param DurationUnit_RL Unit of Duration
	 */
	void setDurationUnit_RL(I_AD_Ref_ListInput DurationUnit_RL);

	/**
	 * Get DurationUnit_RL.
	 *
	 * @return Unit of Duration
	 */
	I_AD_Ref_ListInput getDurationUnit_RL();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set ProcessType_RL.
	 *
	 * @param ProcessType_RL ProcessType_RL
	 */
	void setProcessType_RL(I_AD_Ref_ListInput ProcessType_RL);

	/**
	 * Get ProcessType_RL.
	 *
	 * @return ProcessType_RL
	 */
	I_AD_Ref_ListInput getProcessType_RL();

	/**
	 * Set PublishStatus_RL.
	 *
	 * @param PublishStatus_RL Status of Publication
	 */
	void setPublishStatus_RL(I_AD_Ref_ListInput PublishStatus_RL);

	/**
	 * Get PublishStatus_RL.
	 *
	 * @return Status of Publication
	 */
	I_AD_Ref_ListInput getPublishStatus_RL();

	/**
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_Resource(I_S_ResourceInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	I_S_ResourceInput getS_Resource();

	/**
	 * Set WorkflowType_RL.
	 *
	 * @param WorkflowType_RL Type of Workflow
	 */
	void setWorkflowType_RL(I_AD_Ref_ListInput WorkflowType_RL);

	/**
	 * Get WorkflowType_RL.
	 *
	 * @return Type of Workflow
	 */
	I_AD_Ref_ListInput getWorkflowType_RL();
}
