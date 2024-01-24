package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_B_Topic;
import org.compiere.model.X_B_TopicCategory;
import org.compiere.model.X_B_TopicType;

import java.sql.ResultSet;

/**
 * Generated Model for B_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_B_TopicInput extends X_B_Topic implements I_B_TopicInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mB_TopicCategory;
	private ForeignEntityInput mB_TopicType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_B_TopicInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_B_Topic(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Topic.
	 *
	 * @param B_Topic_ID Auction Topic
	 */

	public void setB_Topic_ID(int B_Topic_ID) {
		if (get_ID() == 0) {
			super.setB_Topic_ID(B_Topic_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setB_Topic_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getB_Topic_UU();
	}

	/**
	 * Set Topic Category.
	 *
	 * @param B_TopicCategory Auction Topic Category
	 */
	@JsonProperty("B_TopicCategory")
	public void setB_TopicCategoryInput(ForeignEntityInput B_TopicCategory) {
		this.mB_TopicCategory = B_TopicCategory;
		X_B_TopicCategory foreignEntity;
		if (get_ID() == 0 && B_TopicCategory != null &&
				(foreignEntity = new Query(getCtx(), "B_TopicCategory", "B_TopicCategory_UU=?", get_TrxName())
						.setParameters(B_TopicCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setB_TopicCategory_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Topic Category.
	 *
	 * @return Auction Topic Category
	 */
	@JsonProperty("B_TopicCategory")
	public ForeignEntityInput B_TopicCategory() {
		return mB_TopicCategory;
	}

	/**
	 * Set Topic Type.
	 *
	 * @param B_TopicType Auction Topic Type
	 */
	@JsonProperty("B_TopicType")
	public void setB_TopicTypeInput(ForeignEntityInput B_TopicType) {
		this.mB_TopicType = B_TopicType;
		X_B_TopicType foreignEntity;
		if (get_ID() == 0 && B_TopicType != null &&
				(foreignEntity = new Query(getCtx(), "B_TopicType", "B_TopicType_UU=?", get_TrxName())
						.setParameters(B_TopicType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setB_TopicType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Topic Type.
	 *
	 * @return Auction Topic Type
	 */
	@JsonProperty("B_TopicType")
	public ForeignEntityInput B_TopicType() {
		return mB_TopicType;
	}
}
