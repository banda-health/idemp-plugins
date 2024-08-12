package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAchievement;
import org.compiere.model.MMeasure;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_AchievementInput extends MAchievement implements I_PA_AchievementInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mPA_Measure;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PA_Achievement_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_AchievementInput(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
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
	 * Set Achievement.
	 *
	 * @param PA_Achievement_ID Performance Achievement
	 */
	@JsonProperty("PA_Achievement_ID")
	public void setPA_Achievement_IDFromJson(int PA_Achievement_ID) {
		if (get_ID() == 0) {
			super.setPA_Achievement_ID(PA_Achievement_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPA_Achievement_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getPA_Achievement_UU();
	}

	/**
	 * Set Measure.
	 *
	 * @param PA_Measure Concrete Performance Measurement
	 */
	@JsonProperty("PA_Measure")
	public void setPA_MeasureInput(ForeignEntityInput PA_Measure) {
		this.mPA_Measure = PA_Measure;
		if (get_ID() != 0) {
			return;
		}
		if (PA_Measure != null) {
			// Since an entity was passed, make sure it's in the DB
			MMeasure foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Measure", "PA_Measure_UU=?", get_TrxName())
							.setParameters(PA_Measure.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPA_Measure_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Measure with UU " + PA_Measure.getUU());
			}
		} else {
			this.setPA_Measure_ID(0);
		}
	}

	/**
	 * Get Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	@JsonProperty("PA_Measure")
	public ForeignEntityInput PA_Measure() {
		return mPA_Measure;
	}
}
