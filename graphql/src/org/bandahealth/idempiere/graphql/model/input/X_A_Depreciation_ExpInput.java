package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_A_Depreciation_ExpResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAddition;
import org.compiere.model.MAssetDisposed;
import org.compiere.model.MDepreciationEntry;
import org.compiere.model.MDepreciationExp;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_ExpInput extends MDepreciationExp implements I_A_Depreciation_ExpInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Account_Number_A;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_Addition;
	private ForeignEntityInput mA_Asset_Disposed;
	private ForeignEntityInput mA_Depreciation_Entry;
	private ForeignEntityInput mA_Entry_Type;
	private ForeignEntityInput mCR_Account;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mDR_Account;
	private ForeignEntityInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Depreciation_Exp_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Depreciation_ExpInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set A_Account_Number_Acct.
	 *
	 * @param A_Account_Number_A A_Account_Number_Acct
	 */
	@JsonProperty("A_Account_Number_A")
	public void setA_Account_Number_AInput(ForeignEntityInput A_Account_Number_A) {
		this.mA_Account_Number_A = A_Account_Number_A;
		if (A_Account_Number_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Account_Number_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Account_Number_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Account_Number_A.getUU());
			}
		} else {
			this.setA_Account_Number_Acct(0);
		}
	}

	/**
	 * Get A_Account_Number_Acct.
	 *
	 * @return A_Account_Number_Acct
	 */
	@JsonProperty("A_Account_Number_A")
	public ForeignEntityInput A_Account_Number_A() {
		return mA_Account_Number_A;
	}

	/**
	 * Set Asset Addition.
	 *
	 * @param A_Asset_Addition Asset Addition
	 */
	@JsonProperty("A_Asset_Addition")
	public void setA_Asset_AdditionInput(ForeignEntityInput A_Asset_Addition) {
		this.mA_Asset_Addition = A_Asset_Addition;
		if (A_Asset_Addition != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetAddition foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Addition", "A_Asset_Addition_UU=?", get_TrxName())
							.setParameters(A_Asset_Addition.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Asset_Addition_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Addition with UU " + A_Asset_Addition.getUU());
			}
		} else {
			this.setA_Asset_Addition_ID(0);
		}
	}

	/**
	 * Get Asset Addition.
	 *
	 * @return Asset Addition
	 */
	@JsonProperty("A_Asset_Addition")
	public ForeignEntityInput A_Asset_Addition() {
		return mA_Asset_Addition;
	}

	/**
	 * Set Asset Disposed.
	 *
	 * @param A_Asset_Disposed Asset Disposed
	 */
	@JsonProperty("A_Asset_Disposed")
	public void setA_Asset_DisposedInput(ForeignEntityInput A_Asset_Disposed) {
		this.mA_Asset_Disposed = A_Asset_Disposed;
		if (A_Asset_Disposed != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetDisposed foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Disposed", "A_Asset_Disposed_UU=?", get_TrxName())
							.setParameters(A_Asset_Disposed.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Asset_Disposed_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Disposed with UU " + A_Asset_Disposed.getUU());
			}
		} else {
			this.setA_Asset_Disposed_ID(0);
		}
	}

	/**
	 * Get Asset Disposed.
	 *
	 * @return Asset Disposed
	 */
	@JsonProperty("A_Asset_Disposed")
	public ForeignEntityInput A_Asset_Disposed() {
		return mA_Asset_Disposed;
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Asset.getUU());
			}
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Depreciation Entry.
	 *
	 * @param A_Depreciation_Entry Depreciation Entry
	 */
	@JsonProperty("A_Depreciation_Entry")
	public void setA_Depreciation_EntryInput(ForeignEntityInput A_Depreciation_Entry) {
		this.mA_Depreciation_Entry = A_Depreciation_Entry;
		if (A_Depreciation_Entry != null) {
			// Since an entity was passed, make sure it's in the DB
			MDepreciationEntry foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation_Entry", "A_Depreciation_Entry_UU=?", get_TrxName())
							.setParameters(A_Depreciation_Entry.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Depreciation_Entry_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Entry with UU " + A_Depreciation_Entry.getUU());
			}
		} else {
			this.setA_Depreciation_Entry_ID(0);
		}
	}

	/**
	 * Get Depreciation Entry.
	 *
	 * @return Depreciation Entry
	 */
	@JsonProperty("A_Depreciation_Entry")
	public ForeignEntityInput A_Depreciation_Entry() {
		return mA_Depreciation_Entry;
	}
	/**
	 * Set A_Depreciation_Exp_ID.
	 *
	 * @param A_Depreciation_Exp_ID A_Depreciation_Exp_ID
	 */
	@JsonProperty("A_Depreciation_Exp_ID")
	public void setA_Depreciation_Exp_IDFromJson(int A_Depreciation_Exp_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Exp_ID(A_Depreciation_Exp_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Depreciation_Exp_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Depreciation_Exp_UU();
	}

	/**
	 * Set Entry Type.
	 *
	 * @param A_Entry_Type Entry Type
	 */
	@JsonProperty("A_Entry_Type")
	public void setA_Entry_TypeInput(ForeignEntityInput A_Entry_Type) {
		this.mA_Entry_Type = A_Entry_Type;
		if (A_Entry_Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Depreciation_ExpResolver.A_ENTRY_TYPE_UUIDS_BY_VALUE.containsValue(A_Entry_Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Entry_Type.getUU() +
						" is not in the list defined for the A_Entry_Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Entry_Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Entry_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Entry_Type.getUU());
			}
		} else {
			this.setA_Entry_Type(null);
		}
	}

	/**
	 * Get Entry Type.
	 *
	 * @return Entry Type
	 */
	@JsonProperty("A_Entry_Type")
	public ForeignEntityInput A_Entry_Type() {
		return mA_Entry_Type;
	}
	/**
	 * Set Asset Period.
	 *
	 * @param A_Period Asset Period
	 */
	@JsonProperty("A_Period")
	public void setA_PeriodFromJson(int A_Period) {
		if (get_ID() == 0) {
			super.setA_Period(A_Period);
		}
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
		if (get_ID() != 0) {
			return;
		}
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
	 * Set Account (credit).
	 *
	 * @param CR_Account Account used
	 */
	@JsonProperty("CR_Account")
	public void setCR_AccountInput(ForeignEntityInput CR_Account) {
		this.mCR_Account = CR_Account;
		if (CR_Account != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CR_Account.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCR_Account_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + CR_Account.getUU());
			}
		} else {
			this.setCR_Account_ID(0);
		}
	}

	/**
	 * Get Account (credit).
	 *
	 * @return Account used
	 */
	@JsonProperty("CR_Account")
	public ForeignEntityInput CR_Account() {
		return mCR_Account;
	}

	/**
	 * Set Account (debit).
	 *
	 * @param DR_Account Account used
	 */
	@JsonProperty("DR_Account")
	public void setDR_AccountInput(ForeignEntityInput DR_Account) {
		this.mDR_Account = DR_Account;
		if (DR_Account != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(DR_Account.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setDR_Account_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + DR_Account.getUU());
			}
		} else {
			this.setDR_Account_ID(0);
		}
	}

	/**
	 * Get Account (debit).
	 *
	 * @return Account used
	 */
	@JsonProperty("DR_Account")
	public ForeignEntityInput DR_Account() {
		return mDR_Account;
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
			if (!X_A_Depreciation_ExpResolver.POSTINGTYPE_UUIDS_BY_VALUE.containsValue(PostingType.getUU())) {
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
