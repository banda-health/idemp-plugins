package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Node;
import org.eevolution.model.X_PP_WF_Node_Asset;

import java.sql.ResultSet;

/**
 * Generated Model for PP_WF_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_WF_Node_AssetInput extends X_PP_WF_Node_Asset implements I_PP_WF_Node_AssetInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WF_Node;
	private ForeignEntityInput mA_Asset;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PP_WF_Node_AssetInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_PP_WF_Node_Asset(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_ID(0);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node) {
		this.mAD_WF_Node = AD_WF_Node;
		X_AD_WF_Node foreignEntity;
		if (get_ID() == 0 && AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Node", "AD_WF_Node_UU=?", get_TrxName())
						.setParameters(AD_WF_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Node_ID(foreignEntity.get_ID());
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
	 * Set Workflow Node Asset.
	 *
	 * @param PP_WF_Node_Asset_ID Workflow Node Asset
	 */

	public void setPP_WF_Node_Asset_ID(int PP_WF_Node_Asset_ID) {
		if (get_ID() == 0) {
			super.setPP_WF_Node_Asset_ID(PP_WF_Node_Asset_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_WF_Node_Asset_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_WF_Node_Asset_UU();
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
