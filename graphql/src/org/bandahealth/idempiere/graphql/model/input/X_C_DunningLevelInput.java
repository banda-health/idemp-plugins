package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDunning;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DunningLevelInput extends MDunningLevel implements I_C_DunningLevelInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Dunning;
	private ForeignEntityInput mC_PaymentTerm;
	private ForeignEntityInput mDunning_PrintFormat;
	private ForeignEntityInput mInvoiceCollectionType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_DunningLevel_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_DunningLevelInput(@JsonProperty("UU") String UU) {
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
	 * Set Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public void setC_DunningInput(ForeignEntityInput C_Dunning) {
		this.mC_Dunning = C_Dunning;
		if (get_ID() != 0) {
			return;
		}
		if (C_Dunning != null) {
			// Since an entity was passed, make sure it's in the DB
			MDunning foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Dunning", "C_Dunning_UU=?", get_TrxName())
							.setParameters(C_Dunning.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Dunning_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Dunning with UU " + C_Dunning.getUU());
			}
		} else {
			this.setC_Dunning_ID(0);
		}
	}

	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public ForeignEntityInput C_Dunning() {
		return mC_Dunning;
	}
	/**
	 * Set Dunning Level.
	 *
	 * @param C_DunningLevel_ID Dunning Level
	 */

	public void setC_DunningLevel_ID(int C_DunningLevel_ID) {
		if (get_ID() == 0) {
			super.setC_DunningLevel_ID(C_DunningLevel_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_DunningLevel_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_DunningLevel_UU();
	}

	/**
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm) {
		this.mC_PaymentTerm = C_PaymentTerm;
		if (C_PaymentTerm != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaymentTerm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
							.setParameters(C_PaymentTerm.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UU " + C_PaymentTerm.getUU());
			}
		} else {
			this.setC_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public ForeignEntityInput C_PaymentTerm() {
		return mC_PaymentTerm;
	}

	/**
	 * Set Dunning Print Format.
	 *
	 * @param Dunning_PrintFormat Print Format for printing Dunning Letters
	 */
	@JsonProperty("Dunning_PrintFormat")
	public void setDunning_PrintFormatInput(ForeignEntityInput Dunning_PrintFormat) {
		this.mDunning_PrintFormat = Dunning_PrintFormat;
		if (Dunning_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Dunning_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDunning_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + Dunning_PrintFormat.getUU());
			}
		} else {
			this.setDunning_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Dunning Print Format.
	 *
	 * @return Print Format for printing Dunning Letters
	 */
	@JsonProperty("Dunning_PrintFormat")
	public ForeignEntityInput Dunning_PrintFormat() {
		return mDunning_PrintFormat;
	}

	/**
	 * Set Collection Status.
	 *
	 * @param InvoiceCollectionType Invoice Collection Status
	 */
	@JsonProperty("InvoiceCollectionType")
	public void setInvoiceCollectionTypeInput(ForeignEntityInput InvoiceCollectionType) {
		this.mInvoiceCollectionType = InvoiceCollectionType;
		if (InvoiceCollectionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(InvoiceCollectionType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInvoiceCollectionType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + InvoiceCollectionType.getUU());
			}
		} else {
			this.setInvoiceCollectionType(null);
		}
	}

	/**
	 * Get Collection Status.
	 *
	 * @return Invoice Collection Status
	 */
	@JsonProperty("InvoiceCollectionType")
	public ForeignEntityInput InvoiceCollectionType() {
		return mInvoiceCollectionType;
	}
}
