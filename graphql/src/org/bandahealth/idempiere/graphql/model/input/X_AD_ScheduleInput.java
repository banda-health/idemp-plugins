package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_ScheduleResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSchedule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Schedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ScheduleInput extends MSchedule implements I_AD_ScheduleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mFrequencyType;
	private ForeignEntityInput mScheduleType;
	private ForeignEntityInput mWeekDay;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Schedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ScheduleInput(@JsonProperty("UU") String UU) {
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
	 * Set Schedule.
	 *
	 * @param AD_Schedule_ID Schedule
	 */
	@JsonProperty("AD_Schedule_ID")
	public void setAD_Schedule_IDFromJson(int AD_Schedule_ID) {
		if (get_ID() == 0) {
			super.setAD_Schedule_ID(AD_Schedule_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Schedule_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Schedule_UU();
	}

	/**
	 * Set Frequency Type.
	 *
	 * @param FrequencyType Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public void setFrequencyTypeInput(ForeignEntityInput FrequencyType) {
		this.mFrequencyType = FrequencyType;
		if (FrequencyType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ScheduleResolver.FREQUENCYTYPE_UUIDS_BY_VALUE.containsValue(FrequencyType.getUU())) {
				throw new AdempiereException("The reference list UU of " + FrequencyType.getUU() +
						" is not in the list defined for the FrequencyType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FrequencyType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFrequencyType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + FrequencyType.getUU());
			}
		} else {
			this.setFrequencyType(null);
		}
	}

	/**
	 * Get Frequency Type.
	 *
	 * @return Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public ForeignEntityInput FrequencyType() {
		return mFrequencyType;
	}

	/**
	 * Set Schedule Type.
	 *
	 * @param ScheduleType Type of schedule
	 */
	@JsonProperty("ScheduleType")
	public void setScheduleTypeInput(ForeignEntityInput ScheduleType) {
		this.mScheduleType = ScheduleType;
		if (ScheduleType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ScheduleResolver.SCHEDULETYPE_UUIDS_BY_VALUE.containsValue(ScheduleType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ScheduleType.getUU() +
						" is not in the list defined for the ScheduleType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ScheduleType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setScheduleType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ScheduleType.getUU());
			}
		} else {
			this.setScheduleType(null);
		}
	}

	/**
	 * Get Schedule Type.
	 *
	 * @return Type of schedule
	 */
	@JsonProperty("ScheduleType")
	public ForeignEntityInput ScheduleType() {
		return mScheduleType;
	}

	/**
	 * Set Day of the Week.
	 *
	 * @param WeekDay Day of the Week
	 */
	@JsonProperty("WeekDay")
	public void setWeekDayInput(ForeignEntityInput WeekDay) {
		this.mWeekDay = WeekDay;
		if (WeekDay != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ScheduleResolver.WEEKDAY_UUIDS_BY_VALUE.containsValue(WeekDay.getUU())) {
				throw new AdempiereException("The reference list UU of " + WeekDay.getUU() +
						" is not in the list defined for the WeekDay column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(WeekDay.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setWeekDay(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + WeekDay.getUU());
			}
		} else {
			this.setWeekDay(null);
		}
	}

	/**
	 * Get Day of the Week.
	 *
	 * @return Day of the Week
	 */
	@JsonProperty("WeekDay")
	public ForeignEntityInput WeekDay() {
		return mWeekDay;
	}
}
