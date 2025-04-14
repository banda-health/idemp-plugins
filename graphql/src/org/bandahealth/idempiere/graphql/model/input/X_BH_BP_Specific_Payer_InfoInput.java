package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_BP_Specific_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_BP_Specific_Payer_InfoInput extends MBHBPSpecificPayerInfo implements I_BH_BP_Specific_Payer_InfoInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payer_Info_Fld;
	private ForeignEntityInput mC_InvoiceLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_BP_Specific_Payer_Info_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_BP_Specific_Payer_InfoInput(@JsonProperty("UU") String UU) {
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
	 * Set Business Partner Specific Payer Information.
	 *
	 * @param BH_BP_Specific_Payer_Info_ID Business Partner Specific Payer Information
	 */
	@JsonProperty("BH_BP_Specific_Payer_Info_ID")
	public void setBH_BP_Specific_Payer_Info_IDFromJson(int BH_BP_Specific_Payer_Info_ID) {
		if (get_ID() == 0) {
			super.setBH_BP_Specific_Payer_Info_ID(BH_BP_Specific_Payer_Info_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_BP_Specific_Payer_Info_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_BP_Specific_Payer_Info_UU();
	}

	/**
	 * Set Payer Info Field.
	 *
	 * @param BH_Payer_Info_Fld Payer Info Field
	 */
	@JsonProperty("BH_Payer_Info_Fld")
	public void setBH_Payer_Info_FldInput(ForeignEntityInput BH_Payer_Info_Fld) {
		this.mBH_Payer_Info_Fld = BH_Payer_Info_Fld;
		if (get_ID() != 0) {
			return;
		}
		if (BH_Payer_Info_Fld != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHPayerInfoFld foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Payer_Info_Fld", "BH_Payer_Info_Fld_UU=?", get_TrxName())
							.setParameters(BH_Payer_Info_Fld.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Payer_Info_Fld_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Payer_Info_Fld with UU " + BH_Payer_Info_Fld.getUU());
			}
		} else {
			this.setBH_Payer_Info_Fld_ID(0);
		}
	}

	/**
	 * Get Payer Info Field.
	 *
	 * @return Payer Info Field
	 */
	@JsonProperty("BH_Payer_Info_Fld")
	public ForeignEntityInput BH_Payer_Info_Fld() {
		return mBH_Payer_Info_Fld;
	}

	/**
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine) {
		this.mC_InvoiceLine = C_InvoiceLine;
		if (get_ID() != 0) {
			return;
		}
		if (C_InvoiceLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoiceLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UU " + C_InvoiceLine.getUU());
			}
		} else {
			this.setC_InvoiceLine_ID(0);
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
}
