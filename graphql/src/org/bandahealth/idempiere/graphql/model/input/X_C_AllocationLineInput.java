package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MBankTransfer;
import org.compiere.model.MCashLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for C_AllocationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_AllocationLineInput extends MAllocationLine implements I_C_AllocationLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AllocationHdr;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BankTransfer;
	private ForeignEntityInput mC_CashLine;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_Payment;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_AllocationLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_AllocationLineInput(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
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
	 * Set Amount.
	 *
	 * @param Amount Amount in a defined currency
	 */
	@JsonProperty("Amount")
	public void setAmountFromJson(BigDecimal Amount) {
		if (get_ID() == 0) {
			super.setAmount(Amount);
		}
	}

	/**
	 * Set Allocation.
	 *
	 * @param C_AllocationHdr Payment allocation
	 */
	@JsonProperty("C_AllocationHdr")
	public void setC_AllocationHdrInput(ForeignEntityInput C_AllocationHdr) {
		this.mC_AllocationHdr = C_AllocationHdr;
		if (get_ID() != 0) {
			return;
		}
		if (C_AllocationHdr != null) {
			// Since an entity was passed, make sure it's in the DB
			MAllocationHdr foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AllocationHdr", "C_AllocationHdr_UU=?", get_TrxName())
							.setParameters(C_AllocationHdr.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AllocationHdr_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AllocationHdr with UU " + C_AllocationHdr.getUU());
			}
		} else {
			this.setC_AllocationHdr_ID(0);
		}
	}

	/**
	 * Get Allocation.
	 *
	 * @return Payment allocation
	 */
	@JsonProperty("C_AllocationHdr")
	public ForeignEntityInput C_AllocationHdr() {
		return mC_AllocationHdr;
	}
	/**
	 * Set Allocation Line.
	 *
	 * @param C_AllocationLine_ID Allocation Line
	 */
	@JsonProperty("C_AllocationLine_ID")
	public void setC_AllocationLine_IDFromJson(int C_AllocationLine_ID) {
		if (get_ID() == 0) {
			super.setC_AllocationLine_ID(C_AllocationLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_AllocationLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_AllocationLine_UU();
	}

	/**
	 * Set Bank Transfer.
	 *
	 * @param C_BankTransfer Bank Transfer
	 */
	@JsonProperty("C_BankTransfer")
	public void setC_BankTransferInput(ForeignEntityInput C_BankTransfer) {
		this.mC_BankTransfer = C_BankTransfer;
		if (C_BankTransfer != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankTransfer foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankTransfer", "C_BankTransfer_UU=?", get_TrxName())
							.setParameters(C_BankTransfer.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BankTransfer_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankTransfer with UU " + C_BankTransfer.getUU());
			}
		} else {
			this.setC_BankTransfer_ID(0);
		}
	}

	/**
	 * Get Bank Transfer.
	 *
	 * @return Bank Transfer
	 */
	@JsonProperty("C_BankTransfer")
	public ForeignEntityInput C_BankTransfer() {
		return mC_BankTransfer;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (get_ID() != 0) {
			return;
		}
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Cash Journal Line.
	 *
	 * @param C_CashLine Cash Journal Line
	 */
	@JsonProperty("C_CashLine")
	public void setC_CashLineInput(ForeignEntityInput C_CashLine) {
		this.mC_CashLine = C_CashLine;
		if (get_ID() != 0) {
			return;
		}
		if (C_CashLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashLine", "C_CashLine_UU=?", get_TrxName())
							.setParameters(C_CashLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_CashLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashLine with UU " + C_CashLine.getUU());
			}
		} else {
			this.setC_CashLine_ID(0);
		}
	}

	/**
	 * Get Cash Journal Line.
	 *
	 * @return Cash Journal Line
	 */
	@JsonProperty("C_CashLine")
	public ForeignEntityInput C_CashLine() {
		return mC_CashLine;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(ForeignEntityInput C_Charge) {
		this.mC_Charge = C_Charge;
		if (get_ID() != 0) {
			return;
		}
		if (C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(C_Charge.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UU " + C_Charge.getUU());
			}
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public ForeignEntityInput C_Charge() {
		return mC_Charge;
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
							.setParameters(C_Invoice.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UU " + C_Invoice.getUU());
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
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		if (get_ID() != 0) {
			return;
		}
		if (C_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UU " + C_Order.getUU());
			}
		} else {
			this.setC_Order_ID(0);
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}

	/**
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	@JsonProperty("C_Payment")
	public void setC_PaymentInput(ForeignEntityInput C_Payment) {
		this.mC_Payment = C_Payment;
		if (get_ID() != 0) {
			return;
		}
		if (C_Payment != null) {
			// Since an entity was passed, make sure it's in the DB
			MPayment_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UU " + C_Payment.getUU());
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
	 * Set Transaction Date.
	 *
	 * @param DateTrx Transaction Date
	 */
	@JsonProperty("DateTrx")
	public void setDateTrxFromJson(Timestamp DateTrx) {
		if (get_ID() == 0) {
			super.setDateTrx(DateTrx);
		}
	}
	/**
	 * Set Discount Amount.
	 *
	 * @param DiscountAmt Calculated amount of discount
	 */
	@JsonProperty("DiscountAmt")
	public void setDiscountAmtFromJson(BigDecimal DiscountAmt) {
		if (get_ID() == 0) {
			super.setDiscountAmt(DiscountAmt);
		}
	}
	/**
	 * Set Manual.
	 *
	 * @param IsManual This is a manual process
	 */
	@JsonProperty("IsManual")
	public void setIsManualFromJson(boolean IsManual) {
		if (get_ID() == 0) {
			super.setIsManual(IsManual);
		}
	}
	/**
	 * Set Write-off Amount.
	 *
	 * @param WriteOffAmt Amount to write-off
	 */
	@JsonProperty("WriteOffAmt")
	public void setWriteOffAmtFromJson(BigDecimal WriteOffAmt) {
		if (get_ID() == 0) {
			super.setWriteOffAmt(WriteOffAmt);
		}
	}
}
