package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_Workflow;

/**
 * Generated Interface for PP_Order_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Order_WorkflowInput extends I_PP_Order_Workflow {

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
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_WorkflowInput(I_AD_WorkflowInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	I_AD_WorkflowInput AD_Workflow();

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
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_OrderInput(I_PP_OrderInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	I_PP_OrderInput PP_Order();

	/**
	 * Set PP_Order_Node.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	void setPP_Order_NodeInput(I_PP_Order_NodeInput PP_Order_Node);

	/**
	 * Get PP_Order_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	I_PP_Order_NodeInput PP_Order_Node();

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
