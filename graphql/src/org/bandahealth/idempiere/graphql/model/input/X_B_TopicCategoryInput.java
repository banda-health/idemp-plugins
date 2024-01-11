package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_B_TopicCategory;
import org.compiere.model.X_B_TopicType;

import java.sql.ResultSet;

/**
 * Generated Model for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_TopicCategoryInput extends X_B_TopicCategory implements I_B_TopicCategoryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mB_TopicType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_B_TopicCategoryInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_B_TopicCategory(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Topic Category.
	 *
	 * @param B_TopicCategory_ID Auction Topic Category
	 */

	public void setB_TopicCategory_ID(int B_TopicCategory_ID) {
		if (get_ID() == 0) {
			super.setB_TopicCategory_ID(B_TopicCategory_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setB_TopicCategory_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getB_TopicCategory_UU();
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
