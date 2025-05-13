package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_NodeNext;

import java.sql.ResultSet;

/**
 * Generated Model for PP_Order_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_Order_NodeNextInput extends X_PP_Order_NodeNext implements I_PP_Order_NodeNextInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WF_Next;
	private ForeignEntityInput mAD_WF_Node;
	private ForeignEntityInput mPP_Order;
	private ForeignEntityInput mPP_Order_Next;
	private ForeignEntityInput mPP_Order_Node;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PP_Order_NodeNext_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_Order_NodeNextInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
							.setParameters(AD_WF_Next.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_WF_Next_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Node with UU " + AD_WF_Next.getUU());
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
		if (AD_WF_Node != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Node foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Node", "AD_WF_Node_UU=?", get_TrxName())
							.setParameters(AD_WF_Node.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_WF_Node_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Node with UU " + AD_WF_Node.getUU());
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
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
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

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(ForeignEntityInput PP_Order) {
		this.mPP_Order = PP_Order;
		if (!is_new()) {
			return;
		}
		if (PP_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
							.setParameters(PP_Order.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order with UU " + PP_Order.getUU());
			}
		} else {
			this.setPP_Order_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public ForeignEntityInput PP_Order() {
		return mPP_Order;
	}

	/**
	 * Set Manufacturing Order Activity Next.
	 *
	 * @param PP_Order_Next Manufacturing Order Activity Next
	 */
	@JsonProperty("PP_Order_Next")
	public void setPP_Order_NextInput(ForeignEntityInput PP_Order_Next) {
		this.mPP_Order_Next = PP_Order_Next;
		if (PP_Order_Next != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order_Node foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order_Node", "PP_Order_Node_UU=?", get_TrxName())
							.setParameters(PP_Order_Next.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Order_Next_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order_Node with UU " + PP_Order_Next.getUU());
			}
		} else {
			this.setPP_Order_Next_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Activity Next.
	 *
	 * @return Manufacturing Order Activity Next
	 */
	@JsonProperty("PP_Order_Next")
	public ForeignEntityInput PP_Order_Next() {
		return mPP_Order_Next;
	}

	/**
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("PP_Order_Node")
	public void setPP_Order_NodeInput(ForeignEntityInput PP_Order_Node) {
		this.mPP_Order_Node = PP_Order_Node;
		if (!is_new()) {
			return;
		}
		if (PP_Order_Node != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order_Node foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order_Node", "PP_Order_Node_UU=?", get_TrxName())
							.setParameters(PP_Order_Node.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Order_Node_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order_Node with UU " + PP_Order_Node.getUU());
			}
		} else {
			this.setPP_Order_Node_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Activity.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("PP_Order_Node")
	public ForeignEntityInput PP_Order_Node() {
		return mPP_Order_Node;
	}
	/**
	 * Set Manufacturing Order Activity Next.
	 *
	 * @param PP_Order_NodeNext_ID Manufacturing Order Activity Next
	 */
	@JsonProperty("PP_Order_NodeNext_ID")
	public void setPP_Order_NodeNext_IDFromJson(int PP_Order_NodeNext_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_NodeNext_ID(PP_Order_NodeNext_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPP_Order_NodeNext_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getPP_Order_NodeNext_UU();
	}
	/**
	 * Set Sequence.
	 *
	 * @param SeqNo Method of ordering records; lowest number comes first
	 */
	@JsonProperty("SeqNo")
	public void setSeqNoFromJson(int SeqNo) {
		if (get_ID() == 0) {
			super.setSeqNo(SeqNo);
		}
	}
}
