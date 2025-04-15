package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommission;
import org.compiere.model.MCommissionRun;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CommissionRunInput extends MCommissionRun implements I_C_CommissionRunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Commission;
	private ForeignEntityInput mC_Invoice;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_CommissionRun_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CommissionRunInput(@JsonProperty("UU") String UU) {
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
	 * Set Commission.
	 *
	 * @param C_Commission Commission
	 */
	@JsonProperty("C_Commission")
	public void setC_CommissionInput(ForeignEntityInput C_Commission) {
		this.mC_Commission = C_Commission;
		if (get_ID() != 0) {
			return;
		}
		if (C_Commission != null) {
			// Since an entity was passed, make sure it's in the DB
			MCommission foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Commission", "C_Commission_UU=?", get_TrxName())
							.setParameters(C_Commission.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Commission_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Commission with UU " + C_Commission.getUU());
			}
		} else {
			this.setC_Commission_ID(0);
		}
	}

	/**
	 * Get Commission.
	 *
	 * @return Commission
	 */
	@JsonProperty("C_Commission")
	public ForeignEntityInput C_Commission() {
		return mC_Commission;
	}
	/**
	 * Set Commission Run.
	 *
	 * @param C_CommissionRun_ID Commission Run or Process
	 */
	@JsonProperty("C_CommissionRun_ID")
	public void setC_CommissionRun_IDFromJson(int C_CommissionRun_ID) {
		if (get_ID() == 0) {
			super.setC_CommissionRun_ID(C_CommissionRun_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_CommissionRun_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_CommissionRun_UU();
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
	 * Set Grand Total.
	 *
	 * @param GrandTotal Total amount of document
	 */
	@JsonProperty("GrandTotal")
	public void setGrandTotalFromJson(BigDecimal GrandTotal) {
		if (get_ID() == 0) {
			super.setGrandTotal(GrandTotal);
		}
	}
}
