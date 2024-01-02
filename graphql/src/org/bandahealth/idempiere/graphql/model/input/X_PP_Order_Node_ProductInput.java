package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_M_ProductInput mM_Product;
	 private I_PP_OrderInput mPP_Order;
	 private I_PP_Order_NodeInput mPP_Order_Node;
	 private I_PP_Order_WorkflowInput mPP_Order_Workflow;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PP_Order_Node_ProductInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(I_M_ProductInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public I_M_ProductInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(I_PP_OrderInput PP_Order) {
		this.mPP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (get_ID() == 0 &&PP_Order != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order.Table_Name, X_PP_Order.COLUMNNAME_PP_Order_UU + "=?", get_TrxName())
						.setParameters(PP_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public I_PP_OrderInput PP_Order() {
		return mPP_Order;
	}

	/**
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("PP_Order_Node")
	public void setPP_Order_NodeInput(I_PP_Order_NodeInput PP_Order_Node) {
		this.mPP_Order_Node = PP_Order_Node;
		X_PP_Order_Node foreignEntity;
		if (get_ID() == 0 &&PP_Order_Node != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Node.Table_Name, X_PP_Order_Node.COLUMNNAME_PP_Order_Node_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_Node_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order Activity.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("PP_Order_Node")
	public I_PP_Order_NodeInput PP_Order_Node() {
		return mPP_Order_Node;
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
	@JsonProperty("PP_Order_Workflow")
	public void setPP_Order_WorkflowInput(I_PP_Order_WorkflowInput PP_Order_Workflow) {
		this.mPP_Order_Workflow = PP_Order_Workflow;
		X_PP_Order_Workflow foreignEntity;
		if (get_ID() == 0 &&PP_Order_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Workflow.Table_Name, X_PP_Order_Workflow.COLUMNNAME_PP_Order_Workflow_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_Workflow_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	@JsonProperty("PP_Order_Workflow")
	public I_PP_Order_WorkflowInput PP_Order_Workflow() {
		return mPP_Order_Workflow;
	}
}
