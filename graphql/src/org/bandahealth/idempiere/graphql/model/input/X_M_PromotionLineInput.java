package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionGroup;
import org.compiere.model.X_M_PromotionLine;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_PromotionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionLineInput extends X_M_PromotionLine implements I_M_PromotionLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Promotion;
	private ForeignEntityInput mM_PromotionGroup;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_PromotionLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_PromotionLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_M_PromotionLine(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
	 * Set Promotion.
	 *
	 * @param M_Promotion Promotion
	 */
	@JsonProperty("M_Promotion")
	public void setM_PromotionInput(ForeignEntityInput M_Promotion) {
		this.mM_Promotion = M_Promotion;
		if (get_ID() != 0) {
			return;
		}
		if (M_Promotion != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_Promotion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Promotion", "M_Promotion_UU=?", get_TrxName())
							.setParameters(M_Promotion.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Promotion_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Promotion with UUID " + M_Promotion.getUUID());
			}
		} else {
			this.setM_Promotion_ID(0);
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
		if (M_PromotionGroup != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_PromotionGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PromotionGroup", "M_PromotionGroup_UU=?", get_TrxName())
							.setParameters(M_PromotionGroup.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_PromotionGroup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PromotionGroup with UUID " + M_PromotionGroup.getUUID());
			}
		} else {
			this.setM_PromotionGroup_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_PromotionLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_PromotionLine_UU();
	}
}
