package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_AD_ScheduleInput extends MSchedule implements I_AD_ScheduleInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mFrequencyType;
	private I_AD_Ref_ListInput mScheduleType;
	private I_AD_Ref_ListInput mWeekDay;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Schedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ScheduleInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MSchedule(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			super.setAD_Org_ID(0);
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
	 * Set Schedule.
	 *
	 * @param AD_Schedule_ID Schedule
	 */

	public void setAD_Schedule_ID(int AD_Schedule_ID) {
		if (get_ID() == 0) {
			super.setAD_Schedule_ID(AD_Schedule_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Schedule_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Schedule_UU();
	}

	/**
	 * Set Frequency Type.
	 *
	 * @param FrequencyType Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType) {
		this.mFrequencyType = FrequencyType;
		MRefList_BH foreignEntity;
		if (FrequencyType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FrequencyType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFrequencyType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + FrequencyType.getUUID());
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
	public I_AD_Ref_ListInput FrequencyType() {
		return mFrequencyType;
	}

	/**
	 * Set Schedule Type.
	 *
	 * @param ScheduleType Type of schedule
	 */
	@JsonProperty("ScheduleType")
	public void setScheduleTypeInput(I_AD_Ref_ListInput ScheduleType) {
		this.mScheduleType = ScheduleType;
		MRefList_BH foreignEntity;
		if (ScheduleType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ScheduleType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setScheduleType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ScheduleType.getUUID());
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
	public I_AD_Ref_ListInput ScheduleType() {
		return mScheduleType;
	}

	/**
	 * Set Day of the Week.
	 *
	 * @param WeekDay Day of the Week
	 */
	@JsonProperty("WeekDay")
	public void setWeekDayInput(I_AD_Ref_ListInput WeekDay) {
		this.mWeekDay = WeekDay;
		MRefList_BH foreignEntity;
		if (WeekDay != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(WeekDay.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setWeekDay(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + WeekDay.getUUID());
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
	public I_AD_Ref_ListInput WeekDay() {
		return mWeekDay;
	}
}
