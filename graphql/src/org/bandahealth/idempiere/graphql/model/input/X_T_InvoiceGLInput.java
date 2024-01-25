package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MConversionType;
import org.compiere.model.MOrg;
import org.compiere.model.MPInstance;
import org.compiere.model.Query;
import org.compiere.model.X_T_InvoiceGL;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The T_InvoiceGL_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_T_InvoiceGLInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_T_InvoiceGL(null, (ResultSet) null, null),
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
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		if (AD_PInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MPInstance foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
							.setParameters(AD_PInstance.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PInstance with UUID " + AD_PInstance.getUUID());
			}
		} else {
			this.setAD_PInstance_ID(0);
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
		if (APAR != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(APAR.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAPAR(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + APAR.getUUID());
			}
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
		if (C_ConversionTypeReval != null) {
			// Since an entity was passed, make sure it's in the DB
			MConversionType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionTypeReval.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ConversionTypeReval_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UUID " + C_ConversionTypeReval.getUUID());
			}
		} else {
			this.setC_ConversionTypeReval_ID(0);
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
		if (C_DocTypeReval != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocTypeReval.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocTypeReval_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocTypeReval.getUUID());
			}
		} else {
			this.setC_DocTypeReval_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setT_InvoiceGL_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getT_InvoiceGL_UU();
	}
}
