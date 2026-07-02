package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningLarcRemovalReason;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Visit_Family_Planning_Larc_Removal_ReasonResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Visit_Family_Planning_Larc_Removal_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_Larc_Removal_ReasonInput extends MBHVisitFamilyPlanningLarcRemovalReason implements I_BH_Visit_Family_Planning_Larc_Removal_ReasonInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Larc_Removal_Reason;
	private ForeignEntityInput mBH_Visit_Family_Planning;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Visit_Family_Planning_Larc_Removal_Reason_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Visit_Family_Planning_Larc_Removal_ReasonInput(@JsonProperty("UU") String UU) {
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
	 * Set LARC Removal Reason.
	 *
	 * @param BH_Larc_Removal_Reason LARC Removal Reason
	 */
	@JsonProperty("BH_Larc_Removal_Reason")
	public void setBH_Larc_Removal_ReasonInput(ForeignEntityInput BH_Larc_Removal_Reason) {
		this.mBH_Larc_Removal_Reason = BH_Larc_Removal_Reason;
		if (BH_Larc_Removal_Reason != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_Planning_Larc_Removal_ReasonResolver.BH_LARC_REMOVAL_REASON_UUIDS_BY_VALUE.containsValue(BH_Larc_Removal_Reason.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Larc_Removal_Reason.getUU() +
						" is not in the list defined for the BH_Larc_Removal_Reason column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Larc_Removal_Reason.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Larc_Removal_Reason(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Larc_Removal_Reason.getUU());
			}
		} else {
			this.setBH_Larc_Removal_Reason(null);
		}
	}

	/**
	 * Get LARC Removal Reason.
	 *
	 * @return LARC Removal Reason
	 */
	@JsonProperty("BH_Larc_Removal_Reason")
	public ForeignEntityInput BH_Larc_Removal_Reason() {
		return mBH_Larc_Removal_Reason;
	}

	/**
	 * Set Visit Family Planning.
	 *
	 * @param BH_Visit_Family_Planning Visit Family Planning
	 */
	@JsonProperty("BH_Visit_Family_Planning")
	public void setBH_Visit_Family_PlanningInput(ForeignEntityInput BH_Visit_Family_Planning) {
		this.mBH_Visit_Family_Planning = BH_Visit_Family_Planning;
		if (BH_Visit_Family_Planning != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHVisitFamilyPlanning foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Visit_Family_Planning", "BH_Visit_Family_Planning_UU=?", get_TrxName())
							.setParameters(BH_Visit_Family_Planning.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Visit_Family_Planning_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Visit_Family_Planning with UU " + BH_Visit_Family_Planning.getUU());
			}
		} else {
			this.setBH_Visit_Family_Planning_ID(0);
		}
	}

	/**
	 * Get Visit Family Planning.
	 *
	 * @return Visit Family Planning
	 */
	@JsonProperty("BH_Visit_Family_Planning")
	public ForeignEntityInput BH_Visit_Family_Planning() {
		return mBH_Visit_Family_Planning;
	}
	/**
	 * Set Visit Family Planning LARC Removal Reason.
	 *
	 * @param BH_Visit_Family_Planning_Larc_Removal_Reason_ID Visit Family Planning LARC Removal Reason
	 */
	@JsonProperty("BH_Visit_Family_Planning_Larc_Removal_Reason_ID")
	public void setBH_Visit_Family_Planning_Larc_Removal_Reason_IDFromJson(int BH_Visit_Family_Planning_Larc_Removal_Reason_ID) {
		if (get_ID() == 0) {
			super.setBH_Visit_Family_Planning_Larc_Removal_Reason_ID(BH_Visit_Family_Planning_Larc_Removal_Reason_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Visit_Family_Planning_Larc_Removal_Reason_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Visit_Family_Planning_Larc_Removal_Reason_UU();
	}
}
