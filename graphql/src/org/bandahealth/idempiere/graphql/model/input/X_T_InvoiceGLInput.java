package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MConversionType;
import org.compiere.model.MOrg;
import org.compiere.model.MPInstance;
import org.compiere.model.Query;
import org.compiere.model.X_T_InvoiceGL;

import java.sql.ResultSet;

/**
 * Generated Model for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_InvoiceGLInput extends X_T_InvoiceGL implements I_T_InvoiceGLInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PInstance;
	private ForeignEntityInput mC_ConversionTypeReval;
	private ForeignEntityInput mC_DocTypeReval;
	private ForeignEntityInput mC_Invoice;
	private I_AD_Ref_ListInput mAPAR;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_T_InvoiceGLInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_T_InvoiceGL(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
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
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		MPInstance foreignEntity;
		if (AD_PInstance != null &&
				(foreignEntity = new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
						.setParameters(AD_PInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PInstance_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PInstance_ID(0);
		}
	}

	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public ForeignEntityInput AD_PInstance() {
		return mAD_PInstance;
	}

	/**
	 * Set AP - AR.
	 *
	 * @param APAR Include Receivables and/or Payables transactions
	 */
	@JsonProperty("APAR")
	public void setAPARInput(I_AD_Ref_ListInput APAR) {
		this.mAPAR = APAR;
		MRefList_BH foreignEntity;
		if (APAR != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(APAR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAPAR(foreignEntity.getValue());
		} else {
			this.setAPAR(null);
		}
	}

	/**
	 * Get AP - AR.
	 *
	 * @return Include Receivables and/or Payables transactions
	 */
	@JsonProperty("APAR")
	public I_AD_Ref_ListInput APAR() {
		return mAPAR;
	}

	/**
	 * Set Revaluation Conversion Type.
	 *
	 * @param C_ConversionTypeReval Revaluation Currency Conversion Type
	 */
	@JsonProperty("C_ConversionTypeReval")
	public void setC_ConversionTypeRevalInput(ForeignEntityInput C_ConversionTypeReval) {
		this.mC_ConversionTypeReval = C_ConversionTypeReval;
		MConversionType foreignEntity;
		if (C_ConversionTypeReval != null &&
				(foreignEntity = new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
						.setParameters(C_ConversionTypeReval.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ConversionTypeReval_ID(foreignEntity.get_ID());
		} else {
			super.setC_ConversionTypeReval_ID(0);
		}
	}

	/**
	 * Get Revaluation Conversion Type.
	 *
	 * @return Revaluation Currency Conversion Type
	 */
	@JsonProperty("C_ConversionTypeReval")
	public ForeignEntityInput C_ConversionTypeReval() {
		return mC_ConversionTypeReval;
	}

	/**
	 * Set Revaluation Document Type.
	 *
	 * @param C_DocTypeReval Document Type for Revaluation Journal
	 */
	@JsonProperty("C_DocTypeReval")
	public void setC_DocTypeRevalInput(ForeignEntityInput C_DocTypeReval) {
		this.mC_DocTypeReval = C_DocTypeReval;
		MDocType_BH foreignEntity;
		if (C_DocTypeReval != null &&
				(foreignEntity = new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
						.setParameters(C_DocTypeReval.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocTypeReval_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocTypeReval_ID(0);
		}
	}

	/**
	 * Get Revaluation Document Type.
	 *
	 * @return Document Type for Revaluation Journal
	 */
	@JsonProperty("C_DocTypeReval")
	public ForeignEntityInput C_DocTypeReval() {
		return mC_DocTypeReval;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Invoice_ID(foreignEntity.get_ID());
		} else {
			super.setC_Invoice_ID(0);
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
	 * Set Accounting Fact.
	 *
	 * @param Fact_Acct_ID Accounting Fact
	 */

	public void setFact_Acct_ID(int Fact_Acct_ID) {
		if (get_ID() == 0) {
			super.setFact_Acct_ID(Fact_Acct_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setT_InvoiceGL_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getT_InvoiceGL_UU();
	}
}
