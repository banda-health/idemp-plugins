package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCalendar;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_ReportCube;
import org.compiere.util.Env;

/**
 * Generated Model for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportCubeInput extends X_PA_ReportCube implements I_PA_ReportCubeInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_CalendarInput C_Calendar;

	/**
	 * Standard constructor
	 */
	public X_PA_ReportCubeInput(String ID) {
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
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	public void setC_Calendar(I_C_CalendarInput C_Calendar) {
		this.C_Calendar = C_Calendar;
		MCalendar foreignEntity;
		if (C_Calendar != null &&
				(foreignEntity = new Query(getCtx(), MCalendar.Table_Name, MCalendar.COLUMNNAME_C_Calendar_UU + "=?", get_TrxName())
						.setParameters(C_Calendar.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Calendar_ID(foreignEntity.get_ID());
		} else {
			this.setC_Calendar_ID(0);
		}
	}

	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public I_C_CalendarInput getC_Calendar() {
		return C_Calendar;
	}
	/**
	 * Set Report Cube.
	 *
	 * @param PA_ReportCube_ID Define reporting cube for pre-calculation of summary accounting data.
	 */

	public void setPA_ReportCube_ID(int PA_ReportCube_ID) {
		if (get_ID() == 0) {
			super.setPA_ReportCube_ID(PA_ReportCube_ID);
		}
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
