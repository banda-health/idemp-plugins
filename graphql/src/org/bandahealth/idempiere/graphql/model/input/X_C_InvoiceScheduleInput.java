package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceScheduleInput extends MInvoiceSchedule implements I_C_InvoiceScheduleInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mInvoiceFrequency;
	private I_AD_Ref_ListInput mInvoiceWeekDay;
	private I_AD_Ref_ListInput mInvoiceWeekDayCutoff;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_InvoiceSchedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_InvoiceScheduleInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MInvoiceSchedule(null, (ResultSet) null, null),
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_InvoiceSchedule_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (InvoiceFrequency != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceFrequency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setInvoiceFrequency(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + InvoiceFrequency.getUUID());
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
		if (InvoiceWeekDay != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceWeekDay.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setInvoiceWeekDay(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + InvoiceWeekDay.getUUID());
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
		if (InvoiceWeekDayCutoff != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceWeekDayCutoff.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setInvoiceWeekDayCutoff(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + InvoiceWeekDayCutoff.getUUID());
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
	public I_AD_Ref_ListInput InvoiceWeekDayCutoff() {
		return mInvoiceWeekDayCutoff;
	}
}
