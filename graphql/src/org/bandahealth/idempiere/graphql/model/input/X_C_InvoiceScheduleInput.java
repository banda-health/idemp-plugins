package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_InvoiceSchedule;
import org.compiere.util.Env;

/**
 * Generated Model for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceScheduleInput extends X_C_InvoiceSchedule implements I_C_InvoiceScheduleInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput InvoiceFrequency_RL;
	 private I_AD_Ref_ListInput InvoiceWeekDayCutoff_RL;
	 private I_AD_Ref_ListInput InvoiceWeekDay_RL;

	/**
	 * Standard constructor
	 */
	public X_C_InvoiceScheduleInput(String ID) {
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
	 * Set Invoice Schedule.
	 *
	 * @param C_InvoiceSchedule_ID Schedule for generating Invoices
	 */

	public void setC_InvoiceSchedule_ID(int C_InvoiceSchedule_ID) {
		if (get_ID() == 0) {
			super.setC_InvoiceSchedule_ID(C_InvoiceSchedule_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_InvoiceSchedule_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_InvoiceSchedule_UU();
	}

	/**
	 * Set Invoice Frequency.
	 *
	 * @param InvoiceFrequency_RL How often invoices will be generated
	 */
	public void setInvoiceFrequency_RL(I_AD_Ref_ListInput InvoiceFrequency_RL) {
		this.InvoiceFrequency_RL = InvoiceFrequency_RL;
		MRefList foreignEntity;
		if (InvoiceFrequency_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceFrequency_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInvoiceFrequency(foreignEntity.getValue());
		} else {
			this.setInvoiceFrequency(null);
		}
	}

	/**
	 * Get Invoice Frequency.
	 *
	 * @return How often invoices will be generated
	 */
	public I_AD_Ref_ListInput getInvoiceFrequency_RL() {
		return InvoiceFrequency_RL;
	}

	/**
	 * Set Invoice Week Day.
	 *
	 * @param InvoiceWeekDay_RL Day to generate invoices
	 */
	public void setInvoiceWeekDay_RL(I_AD_Ref_ListInput InvoiceWeekDay_RL) {
		this.InvoiceWeekDay_RL = InvoiceWeekDay_RL;
		MRefList foreignEntity;
		if (InvoiceWeekDay_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceWeekDay_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInvoiceWeekDay(foreignEntity.getValue());
		} else {
			this.setInvoiceWeekDay(null);
		}
	}

	/**
	 * Get Invoice Week Day.
	 *
	 * @return Day to generate invoices
	 */
	public I_AD_Ref_ListInput getInvoiceWeekDay_RL() {
		return InvoiceWeekDay_RL;
	}

	/**
	 * Set Invoice weekday cutoff.
	 *
	 * @param InvoiceWeekDayCutoff_RL Last day in the week for shipments to be included
	 */
	public void setInvoiceWeekDayCutoff_RL(I_AD_Ref_ListInput InvoiceWeekDayCutoff_RL) {
		this.InvoiceWeekDayCutoff_RL = InvoiceWeekDayCutoff_RL;
		MRefList foreignEntity;
		if (InvoiceWeekDayCutoff_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceWeekDayCutoff_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInvoiceWeekDayCutoff(foreignEntity.getValue());
		} else {
			this.setInvoiceWeekDayCutoff(null);
		}
	}

	/**
	 * Get Invoice weekday cutoff.
	 *
	 * @return Last day in the week for shipments to be included
	 */
	public I_AD_Ref_ListInput getInvoiceWeekDayCutoff_RL() {
		return InvoiceWeekDayCutoff_RL;
	}
}
