package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDunning;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;

/**
 * Generated Model for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningLevelInput extends MDunningLevel implements I_C_DunningLevelInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintFormatInput Dunning_PrintFormat;
	 private I_AD_Ref_ListInput InvoiceCollectionType_RL;
	 private I_C_DunningInput C_Dunning;
	 private I_C_PaymentTermInput C_PaymentTerm;

	/**
	 * Standard constructor
	 */
	public X_C_DunningLevelInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	public void setC_Dunning(I_C_DunningInput C_Dunning) {
		this.C_Dunning = C_Dunning;
		MDunning foreignEntity;
		if (get_ID() == 0 &&C_Dunning != null &&
				(foreignEntity = new Query(getCtx(), MDunning.Table_Name, MDunning.COLUMNNAME_C_Dunning_UU + "=?", get_TrxName())
						.setParameters(C_Dunning.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Dunning_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	public I_C_DunningInput getC_Dunning() {
		return C_Dunning;
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
	public void setC_PaymentTerm(I_C_PaymentTermInput C_PaymentTerm) {
		this.C_PaymentTerm = C_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (C_PaymentTerm != null &&
				(foreignEntity = new Query(getCtx(), MPaymentTerm.Table_Name, MPaymentTerm.COLUMNNAME_C_PaymentTerm_UU + "=?", get_TrxName())
						.setParameters(C_PaymentTerm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_PaymentTerm_ID(foreignEntity.get_ID());
		} else {
			this.setC_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public I_C_PaymentTermInput getC_PaymentTerm() {
		return C_PaymentTerm;
	}

	/**
	 * Set Dunning Print Format.
	 *
	 * @param Dunning_PrintFormat Print Format for printing Dunning Letters
	 */
	public void setDunning_PrintFormat(I_AD_PrintFormatInput Dunning_PrintFormat) {
		this.Dunning_PrintFormat = Dunning_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Dunning_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFormat.Table_Name, X_AD_PrintFormat.COLUMNNAME_AD_PrintFormat_UU + "=?", get_TrxName())
						.setParameters(Dunning_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDunning_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			this.setDunning_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Dunning Print Format.
	 *
	 * @return Print Format for printing Dunning Letters
	 */
	public I_AD_PrintFormatInput getDunning_PrintFormat() {
		return Dunning_PrintFormat;
	}

	/**
	 * Set Collection Status.
	 *
	 * @param InvoiceCollectionType_RL Invoice Collection Status
	 */
	public void setInvoiceCollectionType_RL(I_AD_Ref_ListInput InvoiceCollectionType_RL) {
		this.InvoiceCollectionType_RL = InvoiceCollectionType_RL;
		MRefList foreignEntity;
		if (InvoiceCollectionType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(InvoiceCollectionType_RL.getID())
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
	public I_AD_Ref_ListInput getInvoiceCollectionType_RL() {
		return InvoiceCollectionType_RL;
	}
}
