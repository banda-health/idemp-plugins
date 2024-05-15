package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_Workflow;

/**
 * Generated Interface for PP_Order_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_PP_Order_WorkflowInput extends I_PP_Order_Workflow {

	/**
	 * Set AccessLevel.
	 *
	 * @param AccessLevel Access Level required
	 */
	void setAccessLevelInput(ForeignEntityInput AccessLevel);

	/**
	 * Get AccessLevel.
	 *
	 * @return Access Level required
	 */
	ForeignEntityInput AccessLevel();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

	/**
	 * Set AD_WF_Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node);

	/**
	 * Get AD_WF_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	ForeignEntityInput AD_WF_Node();

	/**
	 * Set AD_WF_Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	void setAD_WF_ResponsibleInput(ForeignEntityInput AD_WF_Responsible);

	/**
	 * Get AD_WF_Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	ForeignEntityInput AD_WF_Responsible();

	/**
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_WorkflowInput(ForeignEntityInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	ForeignEntityInput AD_Workflow();

	/**
	 * Set AD_WorkflowProcessor.
	 *
	 * @param AD_WorkflowProcessor Workflow Processor Server
	 */
	void setAD_WorkflowProcessorInput(ForeignEntityInput AD_WorkflowProcessor);

	/**
	 * Get AD_WorkflowProcessor.
	 *
	 * @return Workflow Processor Server
	 */
	ForeignEntityInput AD_WorkflowProcessor();

	/**
	 * Set DurationUnit.
	 *
	 * @param DurationUnit Unit of Duration
	 */
	void setDurationUnitInput(ForeignEntityInput DurationUnit);

	/**
	 * Get DurationUnit.
	 *
	 * @return Unit of Duration
	 */
	ForeignEntityInput DurationUnit();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_OrderInput(ForeignEntityInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	ForeignEntityInput PP_Order();

	/**
	 * Set PP_Order_Node.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	void setPP_Order_NodeInput(ForeignEntityInput PP_Order_Node);

	/**
	 * Get PP_Order_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	ForeignEntityInput PP_Order_Node();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set ProcessType.
	 *
	 * @param ProcessType ProcessType
	 */
	void setProcessTypeInput(ForeignEntityInput ProcessType);

	/**
	 * Get ProcessType.
	 *
	 * @return ProcessType
	 */
	ForeignEntityInput ProcessType();

	/**
	 * Set PublishStatus.
	 *
	 * @param PublishStatus Status of Publication
	 */
	void setPublishStatusInput(ForeignEntityInput PublishStatus);

	/**
	 * Get PublishStatus.
	 *
	 * @return Status of Publication
	 */
	ForeignEntityInput PublishStatus();

	/**
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_ResourceInput(ForeignEntityInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	ForeignEntityInput S_Resource();

	/**
	 * Set WorkflowType.
	 *
	 * @param WorkflowType Type of Workflow
	 */
	void setWorkflowTypeInput(ForeignEntityInput WorkflowType);

	/**
	 * Get WorkflowType.
	 *
	 * @return Type of Workflow
	 */
	ForeignEntityInput WorkflowType();
}
