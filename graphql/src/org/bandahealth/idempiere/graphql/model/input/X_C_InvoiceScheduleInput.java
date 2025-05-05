package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_InvoiceScheduleResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInvoiceSchedule;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_InvoiceScheduleInput extends MInvoiceSchedule implements I_C_InvoiceScheduleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mInvoiceFrequency;
	private ForeignEntityInput mInvoiceWeekDay;
	private ForeignEntityInput mInvoiceWeekDayCutoff;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_InvoiceSchedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_InvoiceScheduleInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Invoice Schedule.
	 *
	 * @param C_InvoiceSchedule_ID Schedule for generating Invoices
	 */
	@JsonProperty("C_InvoiceSchedule_ID")
	public void setC_InvoiceSchedule_IDFromJson(int C_InvoiceSchedule_ID) {
		if (get_ID() == 0) {
			super.setC_InvoiceSchedule_ID(C_InvoiceSchedule_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_InvoiceSchedule_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_InvoiceSchedule_UU();
	}

	/**
	 * Set Invoice Frequency.
	 *
	 * @param InvoiceFrequency How often invoices will be generated
	 */
	@JsonProperty("InvoiceFrequency")
	public void setInvoiceFrequencyInput(ForeignEntityInput InvoiceFrequency) {
		this.mInvoiceFrequency = InvoiceFrequency;
		if (InvoiceFrequency != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_InvoiceScheduleResolver.INVOICEFREQUENCY_UUIDS_BY_VALUE.containsValue(InvoiceFrequency.getUU())) {
				throw new AdempiereException("The reference list UU of " + InvoiceFrequency.getUU() +
						" is not in the list defined for the InvoiceFrequency column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceFrequency.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInvoiceFrequency(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + InvoiceFrequency.getUU());
			}
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
	public ForeignEntityInput InvoiceFrequency() {
		return mInvoiceFrequency;
	}

	/**
	 * Set Invoice Week Day.
	 *
	 * @param InvoiceWeekDay Day to generate invoices
	 */
	@JsonProperty("InvoiceWeekDay")
	public void setInvoiceWeekDayInput(ForeignEntityInput InvoiceWeekDay) {
		this.mInvoiceWeekDay = InvoiceWeekDay;
		if (InvoiceWeekDay != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_InvoiceScheduleResolver.INVOICEWEEKDAY_UUIDS_BY_VALUE.containsValue(InvoiceWeekDay.getUU())) {
				throw new AdempiereException("The reference list UU of " + InvoiceWeekDay.getUU() +
						" is not in the list defined for the InvoiceWeekDay column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceWeekDay.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInvoiceWeekDay(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + InvoiceWeekDay.getUU());
			}
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
	public ForeignEntityInput InvoiceWeekDay() {
		return mInvoiceWeekDay;
	}

	/**
	 * Set Invoice weekday cutoff.
	 *
	 * @param InvoiceWeekDayCutoff Last day in the week for shipments to be included
	 */
	@JsonProperty("InvoiceWeekDayCutoff")
	public void setInvoiceWeekDayCutoffInput(ForeignEntityInput InvoiceWeekDayCutoff) {
		this.mInvoiceWeekDayCutoff = InvoiceWeekDayCutoff;
		if (InvoiceWeekDayCutoff != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_InvoiceScheduleResolver.INVOICEWEEKDAYCUTOFF_UUIDS_BY_VALUE.containsValue(InvoiceWeekDayCutoff.getUU())) {
				throw new AdempiereException("The reference list UU of " + InvoiceWeekDayCutoff.getUU() +
						" is not in the list defined for the InvoiceWeekDayCutoff column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceWeekDayCutoff.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInvoiceWeekDayCutoff(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + InvoiceWeekDayCutoff.getUU());
			}
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
	public ForeignEntityInput InvoiceWeekDayCutoff() {
		return mInvoiceWeekDayCutoff;
	}
}
