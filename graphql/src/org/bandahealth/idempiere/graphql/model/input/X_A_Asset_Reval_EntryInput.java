package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCurrency;
import org.compiere.model.MGLCategory;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Reval_Entry;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Reval_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Reval_EntryInput extends X_A_Asset_Reval_Entry implements I_A_Asset_Reval_EntryInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Rev_Code_RL;
	 private I_AD_Ref_ListInput A_Reval_Cal_Method_RL;
	 private I_AD_Ref_ListInput A_Reval_Effective_Date_RL;
	 private I_AD_Ref_ListInput A_Reval_Multiplier_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_PeriodInput C_Period;
	 private I_GL_CategoryInput GL_Category;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_Reval_EntryInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Reval_Entry_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Reval_Entry_UU();
	}

	/**
	 * Set Rev. Code.
	 *
	 * @param A_Rev_Code_RL Rev. Code
	 */
	public void setA_Rev_Code_RL(I_AD_Ref_ListInput A_Rev_Code_RL) {
		this.A_Rev_Code_RL = A_Rev_Code_RL;
		MRefList foreignEntity;
		if (A_Rev_Code_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Rev_Code_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Rev_Code(foreignEntity.getValue());
		} else {
			this.setA_Rev_Code(null);
		}
	}

	/**
	 * Get Rev. Code.
	 *
	 * @return Rev. Code
	 */
	public I_AD_Ref_ListInput getA_Rev_Code_RL() {
		return A_Rev_Code_RL;
	}

	/**
	 * Set A_Reval_Cal_Method.
	 *
	 * @param A_Reval_Cal_Method_RL A_Reval_Cal_Method
	 */
	public void setA_Reval_Cal_Method_RL(I_AD_Ref_ListInput A_Reval_Cal_Method_RL) {
		this.A_Reval_Cal_Method_RL = A_Reval_Cal_Method_RL;
		MRefList foreignEntity;
		if (A_Reval_Cal_Method_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Cal_Method_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Cal_Method(foreignEntity.getValue());
		} else {
			this.setA_Reval_Cal_Method(null);
		}
	}

	/**
	 * Get A_Reval_Cal_Method.
	 *
	 * @return A_Reval_Cal_Method
	 */
	public I_AD_Ref_ListInput getA_Reval_Cal_Method_RL() {
		return A_Reval_Cal_Method_RL;
	}

	/**
	 * Set Reval. Effective Date.
	 *
	 * @param A_Reval_Effective_Date_RL Reval. Effective Date
	 */
	public void setA_Reval_Effective_Date_RL(I_AD_Ref_ListInput A_Reval_Effective_Date_RL) {
		this.A_Reval_Effective_Date_RL = A_Reval_Effective_Date_RL;
		MRefList foreignEntity;
		if (A_Reval_Effective_Date_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Effective_Date_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Effective_Date(foreignEntity.getValue());
		} else {
			this.setA_Reval_Effective_Date(null);
		}
	}

	/**
	 * Get Reval. Effective Date.
	 *
	 * @return Reval. Effective Date
	 */
	public I_AD_Ref_ListInput getA_Reval_Effective_Date_RL() {
		return A_Reval_Effective_Date_RL;
	}

	/**
	 * Set Reval. Multiplier.
	 *
	 * @param A_Reval_Multiplier_RL Reval. Multiplier
	 */
	public void setA_Reval_Multiplier_RL(I_AD_Ref_ListInput A_Reval_Multiplier_RL) {
		this.A_Reval_Multiplier_RL = A_Reval_Multiplier_RL;
		MRefList foreignEntity;
		if (A_Reval_Multiplier_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Multiplier_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Multiplier(foreignEntity.getValue());
		} else {
			this.setA_Reval_Multiplier(null);
		}
	}

	/**
	 * Get Reval. Multiplier.
	 *
	 * @return Reval. Multiplier
	 */
	public I_AD_Ref_ListInput getA_Reval_Multiplier_RL() {
		return A_Reval_Multiplier_RL;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	public void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema) {
		this.C_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public I_C_AcctSchemaInput getC_AcctSchema() {
		return C_AcctSchema;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	public void setC_DocType(I_C_DocTypeInput C_DocType) {
		this.C_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public I_C_DocTypeInput getC_DocType() {
		return C_DocType;
	}

	/**
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	public void setC_Period(I_C_PeriodInput C_Period) {
		this.C_Period = C_Period;
		MPeriod foreignEntity;
		if (C_Period != null &&
				(foreignEntity = new Query(getCtx(), MPeriod.Table_Name, MPeriod.COLUMNNAME_C_Period_UU + "=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Period_ID(foreignEntity.get_ID());
		} else {
			this.setC_Period_ID(0);
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public I_C_PeriodInput getC_Period() {
		return C_Period;
	}

	/**
	 * Set GL Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	public void setGL_Category(I_GL_CategoryInput GL_Category) {
		this.GL_Category = GL_Category;
		MGLCategory foreignEntity;
		if (GL_Category != null &&
				(foreignEntity = new Query(getCtx(), MGLCategory.Table_Name, MGLCategory.COLUMNNAME_GL_Category_UU + "=?", get_TrxName())
						.setParameters(GL_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGL_Category_ID(foreignEntity.get_ID());
		} else {
			this.setGL_Category_ID(0);
		}
	}

	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	public I_GL_CategoryInput getGL_Category() {
		return GL_Category;
	}

	/**
	 * Set PostingType.
	 *
	 * @param PostingType_RL The type of posted amount for the transaction
	 */
	public void setPostingType_RL(I_AD_Ref_ListInput PostingType_RL) {
		this.PostingType_RL = PostingType_RL;
		MRefList foreignEntity;
		if (PostingType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPostingType(foreignEntity.getValue());
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	public I_AD_Ref_ListInput getPostingType_RL() {
		return PostingType_RL;
	}
}
