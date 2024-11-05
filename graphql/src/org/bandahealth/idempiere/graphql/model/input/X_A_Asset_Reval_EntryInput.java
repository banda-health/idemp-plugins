package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_A_Asset_Reval_EntryResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MGLCategory;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Reval_Entry;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Reval_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Reval_EntryInput extends X_A_Asset_Reval_Entry implements I_A_Asset_Reval_EntryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Rev_Code;
	private ForeignEntityInput mA_Reval_Cal_Method;
	private ForeignEntityInput mA_Reval_Effective_Date;
	private ForeignEntityInput mA_Reval_Multiplier;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mGL_Category;
	private ForeignEntityInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Asset_Reval_Entry_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_Reval_EntryInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Asset Reval. Entry.
	 *
	 * @param A_Asset_Reval_Entry_ID Asset Reval. Entry
	 */
	@JsonProperty("A_Asset_Reval_Entry_ID")
	public void setA_Asset_Reval_Entry_IDFromJson(int A_Asset_Reval_Entry_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Reval_Entry_ID(A_Asset_Reval_Entry_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Asset_Reval_Entry_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Asset_Reval_Entry_UU();
	}

	/**
	 * Set Rev. Code.
	 *
	 * @param A_Rev_Code Rev. Code
	 */
	@JsonProperty("A_Rev_Code")
	public void setA_Rev_CodeInput(ForeignEntityInput A_Rev_Code) {
		this.mA_Rev_Code = A_Rev_Code;
		if (A_Rev_Code != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_Reval_EntryResolver.A_REV_CODE_UUIDS_BY_VALUE.containsValue(A_Rev_Code.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Rev_Code.getUU() +
						" is not in the list defined for the A_Rev_Code column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Rev_Code.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Rev_Code(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Rev_Code.getUU());
			}
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
	public ForeignEntityInput A_Rev_Code() {
		return mA_Rev_Code;
	}

	/**
	 * Set A_Reval_Cal_Method.
	 *
	 * @param A_Reval_Cal_Method A_Reval_Cal_Method
	 */
	@JsonProperty("A_Reval_Cal_Method")
	public void setA_Reval_Cal_MethodInput(ForeignEntityInput A_Reval_Cal_Method) {
		this.mA_Reval_Cal_Method = A_Reval_Cal_Method;
		if (A_Reval_Cal_Method != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_Reval_EntryResolver.A_REVAL_CAL_METHOD_UUIDS_BY_VALUE.containsValue(A_Reval_Cal_Method.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Reval_Cal_Method.getUU() +
						" is not in the list defined for the A_Reval_Cal_Method column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Reval_Cal_Method.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Cal_Method(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Reval_Cal_Method.getUU());
			}
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
	public ForeignEntityInput A_Reval_Cal_Method() {
		return mA_Reval_Cal_Method;
	}

	/**
	 * Set Reval. Effective Date.
	 *
	 * @param A_Reval_Effective_Date Reval. Effective Date
	 */
	@JsonProperty("A_Reval_Effective_Date")
	public void setA_Reval_Effective_DateInput(ForeignEntityInput A_Reval_Effective_Date) {
		this.mA_Reval_Effective_Date = A_Reval_Effective_Date;
		if (A_Reval_Effective_Date != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_Reval_EntryResolver.A_REVAL_EFFECTIVE_DATE_UUIDS_BY_VALUE.containsValue(A_Reval_Effective_Date.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Reval_Effective_Date.getUU() +
						" is not in the list defined for the A_Reval_Effective_Date column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Reval_Effective_Date.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Effective_Date(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Reval_Effective_Date.getUU());
			}
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
	public ForeignEntityInput A_Reval_Effective_Date() {
		return mA_Reval_Effective_Date;
	}

	/**
	 * Set Reval. Multiplier.
	 *
	 * @param A_Reval_Multiplier Reval. Multiplier
	 */
	@JsonProperty("A_Reval_Multiplier")
	public void setA_Reval_MultiplierInput(ForeignEntityInput A_Reval_Multiplier) {
		this.mA_Reval_Multiplier = A_Reval_Multiplier;
		if (A_Reval_Multiplier != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_Reval_EntryResolver.A_REVAL_MULTIPLIER_UUIDS_BY_VALUE.containsValue(A_Reval_Multiplier.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Reval_Multiplier.getUU() +
						" is not in the list defined for the A_Reval_Multiplier column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Reval_Multiplier.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Multiplier(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Reval_Multiplier.getUU());
			}
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
	public ForeignEntityInput A_Reval_Multiplier() {
		return mA_Reval_Multiplier;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UU " + C_AcctSchema.getUU());
			}
		} else {
			this.setC_AcctSchema_ID(0);
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
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + C_Currency.getUU());
			}
		} else {
			this.setC_Currency_ID(0);
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
		if (C_DocType != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UU " + C_DocType.getUU());
			}
		} else {
			this.setC_DocType_ID(-1);
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
		if (C_Period != null) {
			// Since an entity was passed, make sure it's in the DB
			MPeriod foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UU " + C_Period.getUU());
			}
		} else {
			this.setC_Period_ID(0);
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
		if (GL_Category != null) {
			// Since an entity was passed, make sure it's in the DB
			MGLCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_Category", "GL_Category_UU=?", get_TrxName())
							.setParameters(GL_Category.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setGL_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Category with UU " + GL_Category.getUU());
			}
		} else {
			this.setGL_Category_ID(0);
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
	 * Set Posting Type.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(ForeignEntityInput PostingType) {
		this.mPostingType = PostingType;
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_Reval_EntryResolver.POSTINGTYPE_UUIDS_BY_VALUE.containsValue(PostingType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PostingType.getUU() +
						" is not in the list defined for the PostingType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PostingType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPostingType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PostingType.getUU());
			}
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get Posting Type.
	 *
	 * @return The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public ForeignEntityInput PostingType() {
		return mPostingType;
	}
}
