package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Node_Product;
import org.eevolution.model.X_PP_Order_Workflow;

/**
 * Generated Model for PP_Order_Node_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_Node_ProductInput extends X_PP_Order_Node_Product implements I_PP_Order_Node_ProductInput {

	 private I_AD_OrgInput AD_Org;
	 private I_M_ProductInput M_Product;
	 private I_PP_OrderInput PP_Order;
	 private I_PP_Order_NodeInput PP_Order_Node;
	 private I_PP_Order_WorkflowInput PP_Order_Workflow;

	/**
	 * Standard constructor
	 */
	public X_PP_Order_Node_ProductInput(String ID) {
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
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	public void setPP_Order_Node(I_PP_Order_NodeInput PP_Order_Node) {
		this.PP_Order_Node = PP_Order_Node;
		X_PP_Order_Node foreignEntity;
		if (get_ID() == 0 &&PP_Order_Node != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Node.Table_Name, X_PP_Order_Node.COLUMNNAME_PP_Order_Node_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_Node_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_Order_Node_Product_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Order_Node_Product_UU();
	}

	/**
	 * Set Manufacturing Order Workflow.
	 *
	 * @param PP_Order_Workflow Manufacturing Order Workflow
	 */
	public void setPP_Order_Workflow(I_PP_Order_WorkflowInput PP_Order_Workflow) {
		this.PP_Order_Workflow = PP_Order_Workflow;
		X_PP_Order_Workflow foreignEntity;
		if (get_ID() == 0 &&PP_Order_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Workflow.Table_Name, X_PP_Order_Workflow.COLUMNNAME_PP_Order_Workflow_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_Workflow_ID(foreignEntity.get_ID());
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
}
