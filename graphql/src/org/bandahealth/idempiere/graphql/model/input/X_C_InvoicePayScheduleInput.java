package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInvoicePaySchedule;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySchedule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_InvoicePaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoicePayScheduleInput extends MInvoicePaySchedule implements I_C_InvoicePayScheduleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_PaySchedule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_InvoicePaySchedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_InvoicePayScheduleInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		if (get_ID() != 0) {
			return;
		}
		if (C_Invoice != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoice_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UUID " + C_Invoice.getUUID());
			}
		} else {
			this.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public ForeignEntityInput C_Invoice() {
		return mC_Invoice;
	}
	/**
	 * Set Invoice Payment Schedule.
	 *
	 * @param C_InvoicePaySchedule_ID Invoice Payment Schedule
	 */

	public void setC_InvoicePaySchedule_ID(int C_InvoicePaySchedule_ID) {
		if (get_ID() == 0) {
			super.setC_InvoicePaySchedule_ID(C_InvoicePaySchedule_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_InvoicePaySchedule_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_InvoicePaySchedule_UU();
	}

	/**
	 * Set Payment Schedule.
	 *
	 * @param C_PaySchedule Payment Schedule Template
	 */
	@JsonProperty("C_PaySchedule")
	public void setC_PayScheduleInput(ForeignEntityInput C_PaySchedule) {
		this.mC_PaySchedule = C_PaySchedule;
		if (get_ID() != 0) {
			return;
		}
		if (C_PaySchedule != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaySchedule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaySchedule", "C_PaySchedule_UU=?", get_TrxName())
							.setParameters(C_PaySchedule.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_PaySchedule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaySchedule with UUID " + C_PaySchedule.getUUID());
			}
		} else {
			this.setC_PaySchedule_ID(0);
		}
	}

	/**
	 * Get Payment Schedule.
	 *
	 * @return Payment Schedule Template
	 */
	@JsonProperty("C_PaySchedule")
	public ForeignEntityInput C_PaySchedule() {
		return mC_PaySchedule;
	}
}
