package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRefList;
import org.compiere.model.MResource;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Cost_Collector;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_BOMLine;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Workflow;

/**
 * Generated Model for PP_Cost_Collector - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Cost_CollectorInput extends X_PP_Cost_Collector implements I_PP_Cost_CollectorInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CostCollectorType_RL;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_UserInput AD_User;
	 private I_AD_UserInput User1;
	 private I_AD_UserInput User2;
	 private I_C_ActivityInput C_Activity;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_DocTypeInput C_DocTypeTarget;
	 private I_C_ProjectInput C_Project;
	 private I_C_UOMInput C_UOM;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_LocatorInput M_Locator;
	 private I_M_ProductInput M_Product;
	 private I_M_WarehouseInput M_Warehouse;
	 private I_PP_Cost_CollectorInput Reversal;
	 private I_PP_OrderInput PP_Order;
	 private I_PP_Order_BOMLineInput PP_Order_BOMLine;
	 private I_PP_Order_NodeInput PP_Order_Node;
	 private I_PP_Order_WorkflowInput PP_Order_Workflow;
	 private I_S_ResourceInput S_Resource;

	/**
	 * Standard constructor
	 */
	public X_PP_Cost_CollectorInput(String ID) {
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	public void setC_Activity(I_C_ActivityInput C_Activity) {
		this.C_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public I_C_ActivityInput getC_Activity() {
		return C_Activity;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public I_C_CampaignInput getC_Campaign() {
		return C_Campaign;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	public void setC_DocType(I_C_DocTypeInput C_DocType) {
		this.C_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public I_C_DocTypeInput getC_DocType() {
		return C_DocType;
	}

	/**
	 * Set Target Document Type.
	 *
	 * @param C_DocTypeTarget Target document type for conversing documents
	 */
	public void setC_DocTypeTarget(I_C_DocTypeInput C_DocTypeTarget) {
		this.C_DocTypeTarget = C_DocTypeTarget;
		MDocType_BH foreignEntity;
		if (get_ID() == 0 &&C_DocTypeTarget != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeTarget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocTypeTarget_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Target Document Type.
	 *
	 * @return Target document type for conversing documents
	 */
	public I_C_DocTypeInput getC_DocTypeTarget() {
		return C_DocTypeTarget;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	public void setC_UOM(I_C_UOMInput C_UOM) {
		this.C_UOM = C_UOM;
		MUOM foreignEntity;
		if (C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public I_C_UOMInput getC_UOM() {
		return C_UOM;
	}

	/**
	 * Set Cost Collector Type.
	 *
	 * @param CostCollectorType_RL Transaction Type for Manufacturing Management
	 */
	public void setCostCollectorType_RL(I_AD_Ref_ListInput CostCollectorType_RL) {
		this.CostCollectorType_RL = CostCollectorType_RL;
		MRefList foreignEntity;
		if (CostCollectorType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostCollectorType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCostCollectorType(foreignEntity.getValue());
		} else {
			this.setCostCollectorType(null);
		}
	}

	/**
	 * Get Cost Collector Type.
	 *
	 * @return Transaction Type for Manufacturing Management
	 */
	public I_AD_Ref_ListInput getCostCollectorType_RL() {
		return CostCollectorType_RL;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	public void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL) {
		this.DocAction_RL = DocAction_RL;
		MRefList foreignEntity;
		if (DocAction_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	public I_AD_Ref_ListInput getDocAction_RL() {
		return DocAction_RL;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	public void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL) {
		this.DocStatus_RL = DocStatus_RL;
		MRefList foreignEntity;
		if (DocStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocStatus(foreignEntity.getValue());
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	public I_AD_Ref_ListInput getDocStatus_RL() {
		return DocStatus_RL;
	}
	/**
	 * Set Is Subcontracting.
	 *
	 * @param IsSubcontracting Is Subcontracting
	 */
	public void setIsSubcontracting(boolean IsSubcontracting) {
		if (get_ID() == 0) {
			super.setIsSubcontracting(IsSubcontracting);
		}
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			this.setM_AttributeSetInstance_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public I_M_AttributeSetInstanceInput getM_AttributeSetInstance() {
		return M_AttributeSetInstance;
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	public void setM_Locator(I_M_LocatorInput M_Locator) {
		this.M_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Locator_ID(foreignEntity.get_ID());
		} else {
			this.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public I_M_LocatorInput getM_Locator() {
		return M_Locator;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	public void setM_Warehouse(I_M_WarehouseInput M_Warehouse) {
		this.M_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public I_M_WarehouseInput getM_Warehouse() {
		return M_Warehouse;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_Cost_Collector_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Cost_Collector_UU();
	}

	/**
	 * Set Manufacturing Order BOM Line.
	 *
	 * @param PP_Order_BOMLine Manufacturing Order BOM Line
	 */
	public void setPP_Order_BOMLine(I_PP_Order_BOMLineInput PP_Order_BOMLine) {
		this.PP_Order_BOMLine = PP_Order_BOMLine;
		X_PP_Order_BOMLine foreignEntity;
		if (PP_Order_BOMLine != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_BOMLine.Table_Name, X_PP_Order_BOMLine.COLUMNNAME_PP_Order_BOMLine_UU + "=?", get_TrxName())
						.setParameters(PP_Order_BOMLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_BOMLine_ID(foreignEntity.get_ID());
		} else {
			this.setPP_Order_BOMLine_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order BOM Line.
	 *
	 * @return Manufacturing Order BOM Line
	 */
	public I_PP_Order_BOMLineInput getPP_Order_BOMLine() {
		return PP_Order_BOMLine;
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	public void setPP_Order(I_PP_OrderInput PP_Order) {
		this.PP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (PP_Order != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order.Table_Name, X_PP_Order.COLUMNNAME_PP_Order_UU + "=?", get_TrxName())
						.setParameters(PP_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_ID(foreignEntity.get_ID());
		} else {
			this.setPP_Order_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public I_PP_OrderInput getPP_Order() {
		return PP_Order;
	}

	/**
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	public void setPP_Order_Node(I_PP_Order_NodeInput PP_Order_Node) {
		this.PP_Order_Node = PP_Order_Node;
		X_PP_Order_Node foreignEntity;
		if (PP_Order_Node != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Node.Table_Name, X_PP_Order_Node.COLUMNNAME_PP_Order_Node_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_Node_ID(foreignEntity.get_ID());
		} else {
			this.setPP_Order_Node_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Activity.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public I_PP_Order_NodeInput getPP_Order_Node() {
		return PP_Order_Node;
	}

	/**
	 * Set Manufacturing Order Workflow.
	 *
	 * @param PP_Order_Workflow Manufacturing Order Workflow
	 */
	public void setPP_Order_Workflow(I_PP_Order_WorkflowInput PP_Order_Workflow) {
		this.PP_Order_Workflow = PP_Order_Workflow;
		X_PP_Order_Workflow foreignEntity;
		if (PP_Order_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Workflow.Table_Name, X_PP_Order_Workflow.COLUMNNAME_PP_Order_Workflow_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_Workflow_ID(foreignEntity.get_ID());
		} else {
			this.setPP_Order_Workflow_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	public I_PP_Order_WorkflowInput getPP_Order_Workflow() {
		return PP_Order_Workflow;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	public void setReversal(I_PP_Cost_CollectorInput Reversal) {
		this.Reversal = Reversal;
		X_PP_Cost_Collector foreignEntity;
		if (Reversal != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Cost_Collector.Table_Name, X_PP_Cost_Collector.COLUMNNAME_PP_Cost_Collector_UU + "=?", get_TrxName())
						.setParameters(Reversal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReversal_ID(foreignEntity.get_ID());
		} else {
			this.setReversal_ID(0);
		}
	}

	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public I_PP_Cost_CollectorInput getReversal() {
		return Reversal;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	public void setS_Resource(I_S_ResourceInput S_Resource) {
		this.S_Resource = S_Resource;
		MResource foreignEntity;
		if (S_Resource != null &&
				(foreignEntity = new Query(getCtx(), MResource.Table_Name, MResource.COLUMNNAME_S_Resource_UU + "=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_Resource_ID(foreignEntity.get_ID());
		} else {
			this.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public I_S_ResourceInput getS_Resource() {
		return S_Resource;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	public void setUser1(I_AD_UserInput User1) {
		this.User1 = User1;
		MUser_BH foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser1_ID(foreignEntity.get_ID());
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public I_AD_UserInput getUser1() {
		return User1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	public void setUser2(I_AD_UserInput User2) {
		this.User2 = User2;
		MUser_BH foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser2_ID(foreignEntity.get_ID());
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public I_AD_UserInput getUser2() {
		return User2;
	}
}
