package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_NodeNext;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_NodeNextInput extends X_AD_WF_NodeNext implements I_AD_WF_NodeNextInput {

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_WF_NodeInput AD_WF_Next;
	 private I_AD_WF_NodeInput AD_WF_Node;

	/**
	 * Standard constructor
	 */
	public X_AD_WF_NodeNextInput(String ID) {
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 &&AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Node.Table_Name, X_AD_WF_Node.COLUMNNAME_AD_WF_Node_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Node_ID(foreignEntity.get_ID());
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
	 * Set Node.
	 *
	 * @param AD_WF_Node_ID Workflow Node (activity), step or process
	 */

	public void setAD_WF_Node_ID(int AD_WF_Node_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_Node_ID(AD_WF_Node_ID);
		}
	}
	/**
	 * Set Node Transition.
	 *
	 * @param AD_WF_NodeNext_ID Workflow Node Transition
	 */

	public void setAD_WF_NodeNext_ID(int AD_WF_NodeNext_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_NodeNext_ID(AD_WF_NodeNext_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_NodeNext_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_NodeNext_UU();
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
}
