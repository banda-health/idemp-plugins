package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MGLCategory;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
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

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mC_AcctSchema;
	 private ForeignEntityInput mC_Currency;
	 private ForeignEntityInput mC_DocType;
	 private ForeignEntityInput mC_Period;
	 private ForeignEntityInput mGL_Category;
	 private I_AD_Ref_ListInput mA_Rev_Code;
	 private I_AD_Ref_ListInput mA_Reval_Cal_Method;
	 private I_AD_Ref_ListInput mA_Reval_Effective_Date;
	 private I_AD_Ref_ListInput mA_Reval_Multiplier;
	 private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_Reval_EntryInput(@JsonProperty("ID") String ID) {
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
	 * @param A_Rev_Code Rev. Code
	 */
	@JsonProperty("A_Rev_Code")
	public void setA_Rev_CodeInput(I_AD_Ref_ListInput A_Rev_Code) {
		this.mA_Rev_Code = A_Rev_Code;
		MRefList_BH foreignEntity;
		if (A_Rev_Code != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Rev_Code.getID())
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
	@JsonProperty("A_Rev_Code")
	public I_AD_Ref_ListInput A_Rev_Code() {
		return mA_Rev_Code;
	}

	/**
	 * Set A_Reval_Cal_Method.
	 *
	 * @param A_Reval_Cal_Method A_Reval_Cal_Method
	 */
	@JsonProperty("A_Reval_Cal_Method")
	public void setA_Reval_Cal_MethodInput(I_AD_Ref_ListInput A_Reval_Cal_Method) {
		this.mA_Reval_Cal_Method = A_Reval_Cal_Method;
		MRefList_BH foreignEntity;
		if (A_Reval_Cal_Method != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Cal_Method.getID())
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
	@JsonProperty("A_Reval_Cal_Method")
	public I_AD_Ref_ListInput A_Reval_Cal_Method() {
		return mA_Reval_Cal_Method;
	}

	/**
	 * Set Reval. Effective Date.
	 *
	 * @param A_Reval_Effective_Date Reval. Effective Date
	 */
	@JsonProperty("A_Reval_Effective_Date")
	public void setA_Reval_Effective_DateInput(I_AD_Ref_ListInput A_Reval_Effective_Date) {
		this.mA_Reval_Effective_Date = A_Reval_Effective_Date;
		MRefList_BH foreignEntity;
		if (A_Reval_Effective_Date != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Effective_Date.getID())
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
	@JsonProperty("A_Reval_Effective_Date")
	public I_AD_Ref_ListInput A_Reval_Effective_Date() {
		return mA_Reval_Effective_Date;
	}

	/**
	 * Set Reval. Multiplier.
	 *
	 * @param A_Reval_Multiplier Reval. Multiplier
	 */
	@JsonProperty("A_Reval_Multiplier")
	public void setA_Reval_MultiplierInput(I_AD_Ref_ListInput A_Reval_Multiplier) {
		this.mA_Reval_Multiplier = A_Reval_Multiplier;
		MRefList_BH foreignEntity;
		if (A_Reval_Multiplier != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Multiplier.getID())
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
	@JsonProperty("A_Reval_Multiplier")
	public I_AD_Ref_ListInput A_Reval_Multiplier() {
		return mA_Reval_Multiplier;
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
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			super.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
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
				(foreignEntity = new Query(getCtx(), MCurrency_BH.Table_Name, MCurrency_BH.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
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
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		MPeriod foreignEntity;
		if (C_Period != null &&
				(foreignEntity = new Query(getCtx(), MPeriod.Table_Name, MPeriod.COLUMNNAME_C_Period_UU + "=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Period_ID(foreignEntity.get_ID());
		} else {
			super.setC_Period_ID(0);
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public ForeignEntityInput C_Period() {
		return mC_Period;
	}

	/**
	 * Set GL Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	@JsonProperty("GL_Category")
	public void setGL_CategoryInput(ForeignEntityInput GL_Category) {
		this.mGL_Category = GL_Category;
		MGLCategory foreignEntity;
		if (GL_Category != null &&
				(foreignEntity = new Query(getCtx(), MGLCategory.Table_Name, MGLCategory.COLUMNNAME_GL_Category_UU + "=?", get_TrxName())
						.setParameters(GL_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_Category_ID(foreignEntity.get_ID());
		} else {
			super.setGL_Category_ID(0);
		}
	}

	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	@JsonProperty("GL_Category")
	public ForeignEntityInput GL_Category() {
		return mGL_Category;
	}

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(I_AD_Ref_ListInput PostingType) {
		this.mPostingType = PostingType;
		MRefList_BH foreignEntity;
		if (PostingType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType.getID())
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
	@JsonProperty("PostingType")
	public I_AD_Ref_ListInput PostingType() {
		return mPostingType;
	}
}
