package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionGroup;
import org.compiere.model.X_M_PromotionLine;

import java.sql.ResultSet;

/**
 * Generated Model for M_PromotionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionLineInput extends X_M_PromotionLine implements I_M_PromotionLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Promotion;
	private ForeignEntityInput mM_PromotionGroup;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_PromotionLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_PromotionLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Promotion.
	 *
	 * @param M_Promotion Promotion
	 */
	@JsonProperty("M_Promotion")
	public void setM_PromotionInput(ForeignEntityInput M_Promotion) {
		this.mM_Promotion = M_Promotion;
		X_M_Promotion foreignEntity;
		if (get_ID() == 0 && M_Promotion != null &&
				(foreignEntity = new Query(getCtx(), "M_Promotion", "M_Promotion_UU=?", get_TrxName())
						.setParameters(M_Promotion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Promotion_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Promotion.
	 *
	 * @return Promotion
	 */
	@JsonProperty("M_Promotion")
	public ForeignEntityInput M_Promotion() {
		return mM_Promotion;
	}

	/**
	 * Set Promotion Group.
	 *
	 * @param M_PromotionGroup Promotion Group
	 */
	@JsonProperty("M_PromotionGroup")
	public void setM_PromotionGroupInput(ForeignEntityInput M_PromotionGroup) {
		this.mM_PromotionGroup = M_PromotionGroup;
		X_M_PromotionGroup foreignEntity;
		if (M_PromotionGroup != null &&
				(foreignEntity = new Query(getCtx(), "M_PromotionGroup", "M_PromotionGroup_UU=?", get_TrxName())
						.setParameters(M_PromotionGroup.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PromotionGroup_ID(foreignEntity.get_ID());
		} else {
			super.setM_PromotionGroup_ID(0);
		}
	}

	/**
	 * Get Promotion Group.
	 *
	 * @return Promotion Group
	 */
	@JsonProperty("M_PromotionGroup")
	public ForeignEntityInput M_PromotionGroup() {
		return mM_PromotionGroup;
	}
	/**
	 * Set Promotion Line.
	 *
	 * @param M_PromotionLine_ID Promotion Line
	 */

	public void setM_PromotionLine_ID(int M_PromotionLine_ID) {
		if (get_ID() == 0) {
			super.setM_PromotionLine_ID(M_PromotionLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_PromotionLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_PromotionLine_UU();
	}
}
