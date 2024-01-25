package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentAllocate;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentAllocateInput extends MPaymentAllocate implements I_C_PaymentAllocateInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AllocationLine;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_Payment;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_PaymentAllocate_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PaymentAllocateInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MPaymentAllocate(null, (ResultSet) null, null),
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
	 * Set Allocation Line.
	 *
	 * @param C_AllocationLine Allocation Line
	 */
	@JsonProperty("C_AllocationLine")
	public void setC_AllocationLineInput(ForeignEntityInput C_AllocationLine) {
		this.mC_AllocationLine = C_AllocationLine;
		if (C_AllocationLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MAllocationLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AllocationLine", "C_AllocationLine_UU=?", get_TrxName())
							.setParameters(C_AllocationLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AllocationLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AllocationLine with UUID " + C_AllocationLine.getUUID());
			}
		} else {
			this.setC_AllocationLine_ID(0);
		}
	}

	/**
	 * Get Allocation Line.
	 *
	 * @return Allocation Line
	 */
	@JsonProperty("C_AllocationLine")
	public ForeignEntityInput C_AllocationLine() {
		return mC_AllocationLine;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		if (C_Invoice != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoice_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	@JsonProperty("C_Payment")
	public void setC_PaymentInput(ForeignEntityInput C_Payment) {
		this.mC_Payment = C_Payment;
		if (C_Payment != null) {
			// Since an entity was passed, make sure it's in the DB
			MPayment_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + C_Payment.getUUID());
			}
		} else {
			this.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	@JsonProperty("C_Payment")
	public ForeignEntityInput C_Payment() {
		return mC_Payment;
	}
	/**
	 * Set Allocate Payment.
	 *
	 * @param C_PaymentAllocate_ID Allocate Payment to Invoices
	 */

	public void setC_PaymentAllocate_ID(int C_PaymentAllocate_ID) {
		if (get_ID() == 0) {
			super.setC_PaymentAllocate_ID(C_PaymentAllocate_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_PaymentAllocate_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_PaymentAllocate_UU();
	}
	/**
	 * Set Remaining Amt.
	 *
	 * @param RemainingAmt Remaining Amount
	 */

	public void setRemainingAmt(BigDecimal RemainingAmt) {
		if (get_ID() == 0) {
			super.setRemainingAmt(RemainingAmt);
		}
	}
}
