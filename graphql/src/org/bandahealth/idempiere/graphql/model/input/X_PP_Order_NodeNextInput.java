package org.bandahealth.idempiere.graphql.model.input;

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

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_WF_NodeInput AD_WF_Next;
	 private I_AD_WF_NodeInput AD_WF_Node;
	 private I_PP_OrderInput PP_Order;
	 private I_PP_Order_NodeInput PP_Order_Next;
	 private I_PP_Order_NodeInput PP_Order_Node;

	/**
	 * Standard constructor
	 */
	public X_PP_Order_NodeNextInput(String ID) {
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
	 * Set Next Node.
	 *
	 * @param AD_WF_Next Next Node in workflow
	 */
	public void setAD_WF_Next(I_AD_WF_NodeInput AD_WF_Next) {
		this.AD_WF_Next = AD_WF_Next;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Next != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Node.Table_Name, X_AD_WF_Node.COLUMNNAME_AD_WF_Node_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Next.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Next_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WF_Next_ID(0);
		}
	}

	/**
	 * Get Next Node.
	 *
	 * @return Next Node in workflow
	 */
	public I_AD_WF_NodeInput getAD_WF_Next() {
		return AD_WF_Next;
	}
	/**
	 * Set Next Node.
	 *
	 * @param AD_WF_Next_ID Next Node in workflow
	 */

	public void setAD_WF_Next_ID(int AD_WF_Next_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_Next_ID(AD_WF_Next_ID);
		}
	}

	/**
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	public void setAD_WF_Node(I_AD_WF_NodeInput AD_WF_Node) {
		this.AD_WF_Node = AD_WF_Node;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Node.Table_Name, X_AD_WF_Node.COLUMNNAME_AD_WF_Node_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Node_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public I_AD_WF_NodeInput getAD_WF_Node() {
		return AD_WF_Node;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.getEntityType());
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}
	/**
	 * Set Entity Type.
	 *
	 * @param EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */

	public void setEntityType(String EntityType) {
		if (get_ID() == 0) {
			super.setEntityType(EntityType);
		}
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

	/**
	 * Set Manufacturing Order Activity Next.
	 *
	 * @param PP_Order_Next Manufacturing Order Activity Next
	 */
	public void setPP_Order_Next(I_PP_Order_NodeInput PP_Order_Next) {
		this.PP_Order_Next = PP_Order_Next;
		X_PP_Order_Node foreignEntity;
		if (PP_Order_Next != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Node.Table_Name, X_PP_Order_Node.COLUMNNAME_PP_Order_Node_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Next.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_Next_ID(foreignEntity.get_ID());
		} else {
			this.setPP_Order_Next_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Activity Next.
	 *
	 * @return Manufacturing Order Activity Next
	 */
	public I_PP_Order_NodeInput getPP_Order_Next() {
		return PP_Order_Next;
	}
	/**
	 * Set Manufacturing Order Activity Next.
	 *
	 * @param PP_Order_Next_ID Manufacturing Order Activity Next
	 */

	public void setPP_Order_Next_ID(int PP_Order_Next_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_Next_ID(PP_Order_Next_ID);
		}
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
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node_ID Workflow Node (activity), step or process
	 */

	public void setPP_Order_Node_ID(int PP_Order_Node_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_Node_ID(PP_Order_Node_ID);
		}
	}
	/**
	 * Set Manufacturing Order Activity Next.
	 *
	 * @param PP_Order_NodeNext_ID Manufacturing Order Activity Next
	 */

	public void setPP_Order_NodeNext_ID(int PP_Order_NodeNext_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_NodeNext_ID(PP_Order_NodeNext_ID);
		}
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
