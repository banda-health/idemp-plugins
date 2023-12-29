package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostElement;
import org.compiere.model.MCostType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Cost;

/**
 * Generated Model for PP_Order_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_CostInput extends X_PP_Order_Cost implements I_PP_Order_CostInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CostingMethod_RL;
	 private I_AD_WorkflowInput AD_Workflow;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_CostElementInput M_CostElement;
	 private I_M_CostTypeInput M_CostType;
	 private I_M_ProductInput M_Product;
	 private I_PP_OrderInput PP_Order;

	/**
	 * Standard constructor
	 */
	public X_PP_Order_CostInput(String ID) {
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
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	public void setAD_Workflow(I_AD_WorkflowInput AD_Workflow) {
		this.AD_Workflow = AD_Workflow;
		X_AD_Workflow foreignEntity;
		if (AD_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Workflow.Table_Name, X_AD_Workflow.COLUMNNAME_AD_Workflow_UU + "=?", get_TrxName())
						.setParameters(AD_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Workflow_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public I_AD_WorkflowInput getAD_Workflow() {
		return AD_Workflow;
	}
	/**
	 * Set Workflow.
	 *
	 * @param AD_Workflow_ID Workflow or combination of tasks
	 */

	public void setAD_Workflow_ID(int AD_Workflow_ID) {
		if (get_ID() == 0) {
			super.setAD_Workflow_ID(AD_Workflow_ID);
		}
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	public void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema) {
		this.C_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public I_C_AcctSchemaInput getC_AcctSchema() {
		return C_AcctSchema;
	}

	/**
	 * Set Costing Method.
	 *
	 * @param CostingMethod_RL Indicates how Costs will be calculated
	 */
	public void setCostingMethod_RL(I_AD_Ref_ListInput CostingMethod_RL) {
		this.CostingMethod_RL = CostingMethod_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&CostingMethod_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingMethod_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCostingMethod(foreignEntity.getValue());
		}
	}

	/**
	 * Get Costing Method.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	public I_AD_Ref_ListInput getCostingMethod_RL() {
		return CostingMethod_RL;
	}
	/**
	 * Set Accumulated Amt.
	 *
	 * @param CumulatedAmt Total Amount
	 */

	public void setCumulatedAmt(BigDecimal CumulatedAmt) {
		if (get_ID() == 0) {
			super.setCumulatedAmt(CumulatedAmt);
		}
	}
	/**
	 * Set Cumulated Amt Post.
	 *
	 * @param CumulatedAmtPost Cumulated Amt Post
	 */

	public void setCumulatedAmtPost(BigDecimal CumulatedAmtPost) {
		if (get_ID() == 0) {
			super.setCumulatedAmtPost(CumulatedAmtPost);
		}
	}
	/**
	 * Set Accumulated Qty.
	 *
	 * @param CumulatedQty Total Quantity
	 */

	public void setCumulatedQty(BigDecimal CumulatedQty) {
		if (get_ID() == 0) {
			super.setCumulatedQty(CumulatedQty);
		}
	}
	/**
	 * Set Cumulated Qty Post.
	 *
	 * @param CumulatedQtyPost Cumulated Qty Post
	 */

	public void setCumulatedQtyPost(BigDecimal CumulatedQtyPost) {
		if (get_ID() == 0) {
			super.setCumulatedQtyPost(CumulatedQtyPost);
		}
	}
	/**
	 * Set Current Cost Price.
	 *
	 * @param CurrentCostPrice The currently used cost price
	 */

	public void setCurrentCostPrice(BigDecimal CurrentCostPrice) {
		if (get_ID() == 0) {
			super.setCurrentCostPrice(CurrentCostPrice);
		}
	}
	/**
	 * Set Current Cost Price Lower Level.
	 *
	 * @param CurrentCostPriceLL Current Price Lower Level Is the sum of the costs of the components of this product manufactured for this level.
	 */

	public void setCurrentCostPriceLL(BigDecimal CurrentCostPriceLL) {
		if (get_ID() == 0) {
			super.setCurrentCostPriceLL(CurrentCostPriceLL);
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
	 * Set Cost Element.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	public void setM_CostElement(I_M_CostElementInput M_CostElement) {
		this.M_CostElement = M_CostElement;
		MCostElement foreignEntity;
		if (get_ID() == 0 &&M_CostElement != null &&
				(foreignEntity = new Query(getCtx(), MCostElement.Table_Name, MCostElement.COLUMNNAME_M_CostElement_UU + "=?", get_TrxName())
						.setParameters(M_CostElement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_CostElement_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	public I_M_CostElementInput getM_CostElement() {
		return M_CostElement;
	}
	/**
	 * Set Cost Element.
	 *
	 * @param M_CostElement_ID Product Cost Element
	 */

	public void setM_CostElement_ID(int M_CostElement_ID) {
		if (get_ID() == 0) {
			super.setM_CostElement_ID(M_CostElement_ID);
		}
	}

	/**
	 * Set Cost Type.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	public void setM_CostType(I_M_CostTypeInput M_CostType) {
		this.M_CostType = M_CostType;
		MCostType foreignEntity;
		if (M_CostType != null &&
				(foreignEntity = new Query(getCtx(), MCostType.Table_Name, MCostType.COLUMNNAME_M_CostType_UU + "=?", get_TrxName())
						.setParameters(M_CostType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_CostType_ID(foreignEntity.get_ID());
		} else {
			this.setM_CostType_ID(0);
		}
	}

	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	public I_M_CostTypeInput getM_CostType() {
		return M_CostType;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 &&M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
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
	 * Set Product/Service.
	 *
	 * @param M_Product_ID Product, Service, Item
	 */

	public void setM_Product_ID(int M_Product_ID) {
		if (get_ID() == 0) {
			super.setM_Product_ID(M_Product_ID);
		}
	}
	/**
	 * Set Manufacturing Order Cost.
	 *
	 * @param PP_Order_Cost_ID Manufacturing Order Cost
	 */

	public void setPP_Order_Cost_ID(int PP_Order_Cost_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_Cost_ID(PP_Order_Cost_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_Order_Cost_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Order_Cost_UU();
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	public void setPP_Order(I_PP_OrderInput PP_Order) {
		this.PP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (get_ID() == 0 &&PP_Order != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order.Table_Name, X_PP_Order.COLUMNNAME_PP_Order_UU + "=?", get_TrxName())
						.setParameters(PP_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_ID(foreignEntity.get_ID());
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
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order_ID Manufacturing Order
	 */

	public void setPP_Order_ID(int PP_Order_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_ID(PP_Order_ID);
		}
	}
}
