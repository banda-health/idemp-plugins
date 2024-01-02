package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInvoiceSchedule;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceScheduleInput extends MInvoiceSchedule implements I_C_InvoiceScheduleInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mInvoiceFrequency;
	 private I_AD_Ref_ListInput mInvoiceWeekDay;
	 private I_AD_Ref_ListInput mInvoiceWeekDayCutoff;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_InvoiceScheduleInput(@JsonProperty("ID") String ID) {
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * @param InvoiceFrequency How often invoices will be generated
	 */
	@JsonProperty("InvoiceFrequency")
	public void setInvoiceFrequencyInput(I_AD_Ref_ListInput InvoiceFrequency) {
		this.mInvoiceFrequency = InvoiceFrequency;
		MRefList_BH foreignEntity;
		if (InvoiceFrequency != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceFrequency.getID())
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
	@JsonProperty("InvoiceFrequency")
	public I_AD_Ref_ListInput InvoiceFrequency() {
		return mInvoiceFrequency;
	}

	/**
	 * Set Invoice Week Day.
	 *
	 * @param InvoiceWeekDay Day to generate invoices
	 */
	@JsonProperty("InvoiceWeekDay")
	public void setInvoiceWeekDayInput(I_AD_Ref_ListInput InvoiceWeekDay) {
		this.mInvoiceWeekDay = InvoiceWeekDay;
		MRefList_BH foreignEntity;
		if (InvoiceWeekDay != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceWeekDay.getID())
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
	@JsonProperty("InvoiceWeekDay")
	public I_AD_Ref_ListInput InvoiceWeekDay() {
		return mInvoiceWeekDay;
	}

	/**
	 * Set Invoice weekday cutoff.
	 *
	 * @param InvoiceWeekDayCutoff Last day in the week for shipments to be included
	 */
	@JsonProperty("InvoiceWeekDayCutoff")
	public void setInvoiceWeekDayCutoffInput(I_AD_Ref_ListInput InvoiceWeekDayCutoff) {
		this.mInvoiceWeekDayCutoff = InvoiceWeekDayCutoff;
		MRefList_BH foreignEntity;
		if (InvoiceWeekDayCutoff != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceWeekDayCutoff.getID())
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
	@JsonProperty("InvoiceWeekDayCutoff")
	public I_AD_Ref_ListInput InvoiceWeekDayCutoff() {
		return mInvoiceWeekDayCutoff;
	}
}
