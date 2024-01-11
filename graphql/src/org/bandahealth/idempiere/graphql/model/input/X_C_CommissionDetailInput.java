package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommissionAmt;
import org.compiere.model.MCommissionDetail;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_CommissionDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionDetailInput extends MCommissionDetail implements I_C_CommissionDetailInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_CommissionAmt;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_InvoiceLine;
	private ForeignEntityInput mC_OrderLine;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CommissionDetailInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCommissionDetail(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Commission Amount.
	 *
	 * @param C_CommissionAmt Generated Commission Amount 
	 */
	@JsonProperty("C_CommissionAmt")
	public void setC_CommissionAmtInput(ForeignEntityInput C_CommissionAmt) {
		this.mC_CommissionAmt = C_CommissionAmt;
		MCommissionAmt foreignEntity;
		if (get_ID() == 0 && C_CommissionAmt != null &&
				(foreignEntity = new Query(getCtx(), "C_CommissionAmt", "C_CommissionAmt_UU=?", get_TrxName())
						.setParameters(C_CommissionAmt.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CommissionAmt_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Commission Amount.
	 *
	 * @return Generated Commission Amount 
	 */
	@JsonProperty("C_CommissionAmt")
	public ForeignEntityInput C_CommissionAmt() {
		return mC_CommissionAmt;
	}
	/**
	 * Set Commission Detail.
	 *
	 * @param C_CommissionDetail_ID Supporting information for Commission Amounts
	 */

	public void setC_CommissionDetail_ID(int C_CommissionDetail_ID) {
		if (get_ID() == 0) {
			super.setC_CommissionDetail_ID(C_CommissionDetail_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CommissionDetail_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_CommissionDetail_UU();
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine) {
		this.mC_InvoiceLine = C_InvoiceLine;
		MInvoiceLine_BH foreignEntity;
		if (get_ID() == 0 && C_InvoiceLine != null &&
				(foreignEntity = new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
						.setParameters(C_InvoiceLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_InvoiceLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public ForeignEntityInput C_InvoiceLine() {
		return mC_InvoiceLine;
	}

	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		MOrderLine_BH foreignEntity;
		if (get_ID() == 0 && C_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
						.setParameters(C_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public ForeignEntityInput C_OrderLine() {
		return mC_OrderLine;
	}
}
