package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_B_TopicCategory;
import org.compiere.model.X_B_TopicType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_B_TopicCategoryInput extends X_B_TopicCategory implements I_B_TopicCategoryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mB_TopicType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The B_TopicCategory_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_B_TopicCategoryInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
			return;
		}
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
	 * Set Topic Category.
	 *
	 * @param B_TopicCategory_ID Auction Topic Category
	 */
	@JsonProperty("B_TopicCategory_ID")
	public void setB_TopicCategory_IDFromJson(int B_TopicCategory_ID) {
		if (get_ID() == 0) {
			super.setB_TopicCategory_ID(B_TopicCategory_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setB_TopicCategory_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (!is_new()) {
			return;
		}
		if (B_TopicType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_B_TopicType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "B_TopicType", "B_TopicType_UU=?", get_TrxName())
							.setParameters(B_TopicType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_TopicType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table B_TopicType with UU " + B_TopicType.getUU());
			}
		} else {
			this.setB_TopicType_ID(0);
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
