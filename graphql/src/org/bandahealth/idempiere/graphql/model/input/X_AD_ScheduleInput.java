package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSchedule;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ScheduleInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MSchedule(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Schedule_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		if (FrequencyType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FrequencyType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFrequencyType(foreignEntity.getValue());
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
		if (ScheduleType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ScheduleType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setScheduleType(foreignEntity.getValue());
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
		if (WeekDay != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(WeekDay.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setWeekDay(foreignEntity.getValue());
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
