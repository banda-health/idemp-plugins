package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_NodeNext;

/**
 * Generated Model for PP_Order_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_NodeNextInput extends X_PP_Order_NodeNext implements I_PP_Order_NodeNextInput {

	 private I_AD_EntityTypeInput mAD_EntityType;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_WF_NodeInput mAD_WF_Next;
	 private I_AD_WF_NodeInput mAD_WF_Node;
	 private I_PP_OrderInput mPP_Order;
	 private I_PP_Order_NodeInput mPP_Order_Next;
	 private I_PP_Order_NodeInput mPP_Order_Node;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PP_Order_NodeNextInput(@JsonProperty("ID") String ID) {
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
	 * Set Next Node.
	 *
	 * @param AD_WF_Next Next Node in workflow
	 */
	@JsonProperty("AD_WF_Next")
	public void setAD_WF_NextInput(I_AD_WF_NodeInput AD_WF_Next) {
		this.mAD_WF_Next = AD_WF_Next;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Next != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Node.Table_Name, X_AD_WF_Node.COLUMNNAME_AD_WF_Node_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Next.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Next_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WF_Next_ID(0);
		}
	}

	/**
	 * Get Next Node.
	 *
	 * @return Next Node in workflow
	 */
	@JsonProperty("AD_WF_Next")
	public I_AD_WF_NodeInput AD_WF_Next() {
		return mAD_WF_Next;
	}

	/**
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public void setAD_WF_NodeInput(I_AD_WF_NodeInput AD_WF_Node) {
		this.mAD_WF_Node = AD_WF_Node;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Node.Table_Name, X_AD_WF_Node.COLUMNNAME_AD_WF_Node_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Node_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public I_AD_WF_NodeInput AD_WF_Node() {
		return mAD_WF_Node;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public I_AD_EntityTypeInput AD_EntityType() {
		return mAD_EntityType;
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
	 * Set Manufacturing Order Activity Next.
	 *
	 * @param PP_Order_Next Manufacturing Order Activity Next
	 */
	@JsonProperty("PP_Order_Next")
	public void setPP_Order_NextInput(I_PP_Order_NodeInput PP_Order_Next) {
		this.mPP_Order_Next = PP_Order_Next;
		X_PP_Order_Node foreignEntity;
		if (PP_Order_Next != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Node.Table_Name, X_PP_Order_Node.COLUMNNAME_PP_Order_Node_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Next.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_Next_ID(foreignEntity.get_ID());
		} else {
			super.setPP_Order_Next_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Activity Next.
	 *
	 * @return Manufacturing Order Activity Next
	 */
	@JsonProperty("PP_Order_Next")
	public I_PP_Order_NodeInput PP_Order_Next() {
		return mPP_Order_Next;
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
		setPP_Order_NodeNext_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Order_NodeNext_UU();
	}
	/**
	 * Set Sequence.
	 *
	 * @param SeqNo Method of ordering records; lowest number comes first
	 */

	public void setSeqNo(int SeqNo) {
		if (get_ID() == 0) {
			super.setSeqNo(SeqNo);
		}
	}
}
