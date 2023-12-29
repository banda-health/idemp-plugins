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
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_Workflow(I_AD_WorkflowInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	I_AD_WorkflowInput getAD_Workflow();

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
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_Order(I_PP_OrderInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	I_PP_OrderInput getPP_Order();

	/**
	 * Set PP_Order_Node.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	void setPP_Order_Node(I_PP_Order_NodeInput PP_Order_Node);

	/**
	 * Get PP_Order_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	I_PP_Order_NodeInput getPP_Order_Node();

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
