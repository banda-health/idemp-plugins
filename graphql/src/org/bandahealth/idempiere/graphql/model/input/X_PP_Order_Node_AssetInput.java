package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Node_Asset;
import org.eevolution.model.X_PP_Order_Workflow;

import java.sql.ResultSet;

/**
 * Generated Model for PP_Order_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_Node_AssetInput extends X_PP_Order_Node_Asset implements I_PP_Order_Node_AssetInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mPP_Order;
	private ForeignEntityInput mPP_Order_Node;
	private ForeignEntityInput mPP_Order_Workflow;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PP_Order_Node_Asset_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_Order_Node_AssetInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(ForeignEntityInput PP_Order) {
		this.mPP_Order = PP_Order;
		if (get_ID() != 0) {
			return;
		}
		if (PP_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
							.setParameters(PP_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order with UUID " + PP_Order.getUUID());
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
	 * Set Manufacturing Order Activity Asset.
	 *
	 * @param PP_Order_Node_Asset_ID Manufacturing Order Activity Asset
	 */

	public void setPP_Order_Node_Asset_ID(int PP_Order_Node_Asset_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_Node_Asset_ID(PP_Order_Node_Asset_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPP_Order_Node_Asset_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPP_Order_Node_Asset_UU();
	}

	/**
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("PP_Order_Node")
	public void setPP_Order_NodeInput(ForeignEntityInput PP_Order_Node) {
		this.mPP_Order_Node = PP_Order_Node;
		if (get_ID() != 0) {
			return;
		}
		if (PP_Order_Node != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order_Node foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order_Node", "PP_Order_Node_UU=?", get_TrxName())
							.setParameters(PP_Order_Node.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Order_Node_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order_Node with UUID " + PP_Order_Node.getUUID());
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
	 * Set Manufacturing Order Workflow.
	 *
	 * @param PP_Order_Workflow Manufacturing Order Workflow
	 */
	@JsonProperty("PP_Order_Workflow")
	public void setPP_Order_WorkflowInput(ForeignEntityInput PP_Order_Workflow) {
		this.mPP_Order_Workflow = PP_Order_Workflow;
		if (get_ID() != 0) {
			return;
		}
		if (PP_Order_Workflow != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order_Workflow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order_Workflow", "PP_Order_Workflow_UU=?", get_TrxName())
							.setParameters(PP_Order_Workflow.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Order_Workflow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order_Workflow with UUID " + PP_Order_Workflow.getUUID());
			}
		} else {
			this.setPP_Order_Workflow_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	@JsonProperty("PP_Order_Workflow")
	public ForeignEntityInput PP_Order_Workflow() {
		return mPP_Order_Workflow;
	}
}
