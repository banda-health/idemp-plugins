package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCalendar;
import org.compiere.model.MOrg;
import org.compiere.model.MReportCube;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportCubeInput extends MReportCube implements I_PA_ReportCubeInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_C_CalendarInput mC_Calendar;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_ReportCubeInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public void setC_CalendarInput(I_C_CalendarInput C_Calendar) {
		this.mC_Calendar = C_Calendar;
		MCalendar foreignEntity;
		if (C_Calendar != null &&
				(foreignEntity = new Query(getCtx(), MCalendar.Table_Name, MCalendar.COLUMNNAME_C_Calendar_UU + "=?", get_TrxName())
						.setParameters(C_Calendar.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Calendar_ID(foreignEntity.get_ID());
		} else {
			super.setC_Calendar_ID(0);
		}
	}

	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public I_C_CalendarInput C_Calendar() {
		return mC_Calendar;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_ReportCube_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_ReportCube_UU();
	}
}
