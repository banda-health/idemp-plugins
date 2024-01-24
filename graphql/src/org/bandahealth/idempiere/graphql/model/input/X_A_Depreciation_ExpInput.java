package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_ExpInput extends MDepreciationExp implements I_A_Depreciation_ExpInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Account_Number_A;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_Addition;
	private ForeignEntityInput mA_Asset_Disposed;
	private ForeignEntityInput mA_Depreciation_Entry;
	private ForeignEntityInput mCR_Account;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mDR_Account;
	private I_AD_Ref_ListInput mA_Entry_Type;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Depreciation_Exp_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Depreciation_ExpInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDepreciationExp(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set A_Account_Number_Acct.
	 *
	 * @param A_Account_Number_A A_Account_Number_Acct
	 */
	@JsonProperty("A_Account_Number_A")
	public void setA_Account_Number_AInput(ForeignEntityInput A_Account_Number_A) {
		this.mA_Account_Number_A = A_Account_Number_A;
		MAccount foreignEntity;
		if (A_Account_Number_A != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Account_Number_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Account_Number_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Account_Number_A.getUUID());
			}
		} else {
			super.setA_Account_Number_Acct(0);
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
		MAssetAddition foreignEntity;
		if (A_Asset_Addition != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Addition", "A_Asset_Addition_UU=?", get_TrxName())
							.setParameters(A_Asset_Addition.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Addition_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Addition with UUID " + A_Asset_Addition.getUUID());
			}
		} else {
			super.setA_Asset_Addition_ID(0);
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
		MAssetDisposed foreignEntity;
		if (A_Asset_Disposed != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Disposed", "A_Asset_Disposed_UU=?", get_TrxName())
							.setParameters(A_Asset_Disposed.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Disposed_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Disposed with UUID " + A_Asset_Disposed.getUUID());
			}
		} else {
			super.setA_Asset_Disposed_ID(0);
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
		MAsset foreignEntity;
		if (A_Asset != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
		} else {
			super.setA_Asset_ID(0);
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
		MDepreciationEntry foreignEntity;
		if (A_Depreciation_Entry != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation_Entry", "A_Depreciation_Entry_UU=?", get_TrxName())
							.setParameters(A_Depreciation_Entry.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_Entry_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Entry with UUID " + A_Depreciation_Entry.getUUID());
			}
		} else {
			super.setA_Depreciation_Entry_ID(0);
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

	public void setA_Depreciation_Exp_ID(int A_Depreciation_Exp_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Exp_ID(A_Depreciation_Exp_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Depreciation_Exp_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Depreciation_Exp_UU();
	}

	/**
	 * Set Entry Type.
	 *
	 * @param A_Entry_Type Entry Type
	 */
	@JsonProperty("A_Entry_Type")
	public void setA_Entry_TypeInput(I_AD_Ref_ListInput A_Entry_Type) {
		this.mA_Entry_Type = A_Entry_Type;
		MRefList_BH foreignEntity;
		if (A_Entry_Type != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Entry_Type.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Entry_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_Entry_Type.getUUID());
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
	public I_AD_Ref_ListInput A_Entry_Type() {
		return mA_Entry_Type;
	}
	/**
	 * Set Asset Period.
	 *
	 * @param A_Period Asset Period
	 */

	public void setA_Period(int A_Period) {
		if (get_ID() == 0) {
			super.setA_Period(A_Period);
		}
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
		if (AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		if (get_ID() == 0 && C_AcctSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
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
		MAccount foreignEntity;
		if (CR_Account != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CR_Account.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setCR_Account_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CR_Account.getUUID());
			}
		} else {
			super.setCR_Account_ID(0);
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
		MAccount foreignEntity;
		if (DR_Account != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(DR_Account.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDR_Account_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + DR_Account.getUUID());
			}
		} else {
			super.setDR_Account_ID(0);
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
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(I_AD_Ref_ListInput PostingType) {
		this.mPostingType = PostingType;
		MRefList_BH foreignEntity;
		if (PostingType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PostingType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPostingType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PostingType.getUUID());
			}
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
