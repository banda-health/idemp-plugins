package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MSchedule;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Schedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ScheduleInput extends MSchedule implements I_AD_ScheduleInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput FrequencyType_RL;
	 private I_AD_Ref_ListInput ScheduleType_RL;
	 private I_AD_Ref_ListInput WeekDay_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_ScheduleInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
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
	 * @param FrequencyType_RL Frequency of event
	 */
	public void setFrequencyType_RL(I_AD_Ref_ListInput FrequencyType_RL) {
		this.FrequencyType_RL = FrequencyType_RL;
		MRefList foreignEntity;
		if (FrequencyType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FrequencyType_RL.getID())
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
	public I_AD_Ref_ListInput getFrequencyType_RL() {
		return FrequencyType_RL;
	}

	/**
	 * Set Schedule Type.
	 *
	 * @param ScheduleType_RL Type of schedule
	 */
	public void setScheduleType_RL(I_AD_Ref_ListInput ScheduleType_RL) {
		this.ScheduleType_RL = ScheduleType_RL;
		MRefList foreignEntity;
		if (ScheduleType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ScheduleType_RL.getID())
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
	public I_AD_Ref_ListInput getScheduleType_RL() {
		return ScheduleType_RL;
	}

	/**
	 * Set Day of the Week.
	 *
	 * @param WeekDay_RL Day of the Week
	 */
	public void setWeekDay_RL(I_AD_Ref_ListInput WeekDay_RL) {
		this.WeekDay_RL = WeekDay_RL;
		MRefList foreignEntity;
		if (WeekDay_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(WeekDay_RL.getID())
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
	public I_AD_Ref_ListInput getWeekDay_RL() {
		return WeekDay_RL;
	}
}
