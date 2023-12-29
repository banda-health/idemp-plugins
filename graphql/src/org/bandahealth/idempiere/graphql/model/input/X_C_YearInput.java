package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCalendar;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Year;
import org.compiere.util.Env;

/**
 * Generated Model for C_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_YearInput extends X_C_Year implements I_C_YearInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_CalendarInput C_Calendar;

	/**
	 * Standard constructor
	 */
	public X_C_YearInput(String ID) {
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 &&C_Calendar != null &&
				(foreignEntity = new Query(getCtx(), MCalendar.Table_Name, MCalendar.COLUMNNAME_C_Calendar_UU + "=?", get_TrxName())
						.setParameters(C_Calendar.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Calendar_ID(foreignEntity.get_ID());
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
	 * Set Calendar.
	 *
	 * @param C_Calendar_ID Accounting Calendar Name
	 */

	public void setC_Calendar_ID(int C_Calendar_ID) {
		if (get_ID() == 0) {
			super.setC_Calendar_ID(C_Calendar_ID);
		}
	}
	/**
	 * Set Year.
	 *
	 * @param C_Year_ID Calendar Year
	 */

	public void setC_Year_ID(int C_Year_ID) {
		if (get_ID() == 0) {
			super.setC_Year_ID(C_Year_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Year_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Year_UU();
	}
}
