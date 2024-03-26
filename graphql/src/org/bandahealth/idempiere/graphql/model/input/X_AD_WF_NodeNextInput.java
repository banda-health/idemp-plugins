package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_NodeNext;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WF_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_NodeNextInput extends X_AD_WF_NodeNext implements I_AD_WF_NodeNextInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WF_Next;
	private ForeignEntityInput mAD_WF_Node;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_WF_NodeNext_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_WF_NodeNextInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Next Node.
	 *
	 * @param AD_WF_Next Next Node in workflow
	 */
	@JsonProperty("AD_WF_Next")
	public void setAD_WF_NextInput(ForeignEntityInput AD_WF_Next) {
		this.mAD_WF_Next = AD_WF_Next;
		if (AD_WF_Next != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Node foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Node", "AD_WF_Node_UU=?", get_TrxName())
							.setParameters(AD_WF_Next.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_WF_Next_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Node with UUID " + AD_WF_Next.getUUID());
			}
		} else {
			this.setAD_WF_Next_ID(0);
		}
	}

	/**
	 * Get Next Node.
	 *
	 * @return Next Node in workflow
	 */
	@JsonProperty("AD_WF_Next")
	public ForeignEntityInput AD_WF_Next() {
		return mAD_WF_Next;
	}

	/**
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node) {
		this.mAD_WF_Node = AD_WF_Node;
		if (get_ID() != 0) {
			return;
		}
		if (AD_WF_Node != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Node foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Node", "AD_WF_Node_UU=?", get_TrxName())
							.setParameters(AD_WF_Node.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_WF_Node_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Node with UUID " + AD_WF_Node.getUUID());
			}
		} else {
			this.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public ForeignEntityInput AD_WF_Node() {
		return mAD_WF_Node;
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_WF_NodeNext_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_WF_NodeNext_UU();
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
			}
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}
}
