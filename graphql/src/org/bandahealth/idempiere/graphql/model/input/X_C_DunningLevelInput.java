package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDunning;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;

import java.sql.ResultSet;

/**
 * Generated Model for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningLevelInput extends MDunningLevel implements I_C_DunningLevelInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Dunning;
	private ForeignEntityInput mC_PaymentTerm;
	private ForeignEntityInput mDunning_PrintFormat;
	private I_AD_Ref_ListInput mInvoiceCollectionType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_DunningLevelInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MDunningLevel(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public void setC_DunningInput(ForeignEntityInput C_Dunning) {
		this.mC_Dunning = C_Dunning;
		MDunning foreignEntity;
		if (get_ID() == 0 && C_Dunning != null &&
				(foreignEntity = new Query(getCtx(), "C_Dunning", "C_Dunning_UU=?", get_TrxName())
						.setParameters(C_Dunning.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Dunning_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_DunningLevel_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MPaymentTerm foreignEntity;
		if (C_PaymentTerm != null &&
				(foreignEntity = new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
						.setParameters(C_PaymentTerm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaymentTerm_ID(foreignEntity.get_ID());
		} else {
			super.setC_PaymentTerm_ID(0);
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
		X_AD_PrintFormat foreignEntity;
		if (Dunning_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(Dunning_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDunning_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setDunning_PrintFormat_ID(0);
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
	public void setInvoiceCollectionTypeInput(I_AD_Ref_ListInput InvoiceCollectionType) {
		this.mInvoiceCollectionType = InvoiceCollectionType;
		MRefList_BH foreignEntity;
		if (InvoiceCollectionType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceCollectionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInvoiceCollectionType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput InvoiceCollectionType() {
		return mInvoiceCollectionType;
	}
}
