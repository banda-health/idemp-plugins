package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetTransfer;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_TransferInput extends MAssetTransfer implements I_A_Asset_TransferInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Accumdepreciation_A;
	private ForeignEntityInput mA_Accumdepreciation_New_A;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_A;
	private ForeignEntityInput mA_Asset_New_A;
	private ForeignEntityInput mA_Depreciation_A;
	private ForeignEntityInput mA_Depreciation_New_A;
	private ForeignEntityInput mA_Disposal_Loss_A;
	private ForeignEntityInput mA_Disposal_Loss_New_A;
	private ForeignEntityInput mA_Disposal_Revenue_A;
	private ForeignEntityInput mA_Disposal_Revenue_New_A;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Period;
	private I_AD_Ref_ListInput mA_CapvsExp;
	private I_AD_Ref_ListInput mDocAction;
	private I_AD_Ref_ListInput mDocStatus;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Transfer_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_TransferInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAssetTransfer(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Accumulated Depreciation Account.
	 *
	 * @param A_Accumdepreciation_A Accumulated Depreciation Account
	 */
	@JsonProperty("A_Accumdepreciation_A")
	public void setA_Accumdepreciation_AInput(ForeignEntityInput A_Accumdepreciation_A) {
		this.mA_Accumdepreciation_A = A_Accumdepreciation_A;
		if (get_ID() != 0) {
			return;
		}
		if (A_Accumdepreciation_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Accumdepreciation_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Accumdepreciation_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Accumdepreciation_A.getUUID());
			}
		} else {
			this.setA_Accumdepreciation_Acct(0);
		}
	}

	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	@JsonProperty("A_Accumdepreciation_A")
	public ForeignEntityInput A_Accumdepreciation_A() {
		return mA_Accumdepreciation_A;
	}
	/**
	 * Set Old Asset Cost Acct.
	 *
	 * @param A_Accumdepreciation_Acct_Str Old Asset Cost Acct
	 */

	public void setA_Accumdepreciation_Acct_Str(String A_Accumdepreciation_Acct_Str) {
		if (get_ID() == 0) {
			super.setA_Accumdepreciation_Acct_Str(A_Accumdepreciation_Acct_Str);
		}
	}

	/**
	 * Set Accumulated Depreciation Account (new).
	 *
	 * @param A_Accumdepreciation_New_A Accumulated Depreciation Account (new)
	 */
	@JsonProperty("A_Accumdepreciation_New_A")
	public void setA_Accumdepreciation_New_AInput(ForeignEntityInput A_Accumdepreciation_New_A) {
		this.mA_Accumdepreciation_New_A = A_Accumdepreciation_New_A;
		if (A_Accumdepreciation_New_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Accumdepreciation_New_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Accumdepreciation_New_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Accumdepreciation_New_A.getUUID());
			}
		} else {
			this.setA_Accumdepreciation_New_Acct(0);
		}
	}

	/**
	 * Get Accumulated Depreciation Account (new).
	 *
	 * @return Accumulated Depreciation Account (new)
	 */
	@JsonProperty("A_Accumdepreciation_New_A")
	public ForeignEntityInput A_Accumdepreciation_New_A() {
		return mA_Accumdepreciation_New_A;
	}

	/**
	 * Set Asset Acct.
	 *
	 * @param A_Asset_A Asset Acct
	 */
	@JsonProperty("A_Asset_A")
	public void setA_Asset_AInput(ForeignEntityInput A_Asset_A) {
		this.mA_Asset_A = A_Asset_A;
		if (get_ID() != 0) {
			return;
		}
		if (A_Asset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Asset_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Asset_A.getUUID());
			}
		} else {
			this.setA_Asset_Acct(0);
		}
	}

	/**
	 * Get Asset Acct.
	 *
	 * @return Asset Acct
	 */
	@JsonProperty("A_Asset_A")
	public ForeignEntityInput A_Asset_A() {
		return mA_Asset_A;
	}
	/**
	 * Set A_Asset_Acct_Str.
	 *
	 * @param A_Asset_Acct_Str A_Asset_Acct_Str
	 */

	public void setA_Asset_Acct_Str(String A_Asset_Acct_Str) {
		if (get_ID() == 0) {
			super.setA_Asset_Acct_Str(A_Asset_Acct_Str);
		}
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (get_ID() != 0) {
			return;
		}
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
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
	 * Set Asset Acct (new).
	 *
	 * @param A_Asset_New_A Asset Acct (new)
	 */
	@JsonProperty("A_Asset_New_A")
	public void setA_Asset_New_AInput(ForeignEntityInput A_Asset_New_A) {
		this.mA_Asset_New_A = A_Asset_New_A;
		if (A_Asset_New_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Asset_New_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_New_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Asset_New_A.getUUID());
			}
		} else {
			this.setA_Asset_New_Acct(0);
		}
	}

	/**
	 * Get Asset Acct (new).
	 *
	 * @return Asset Acct (new)
	 */
	@JsonProperty("A_Asset_New_A")
	public ForeignEntityInput A_Asset_New_A() {
		return mA_Asset_New_A;
	}
	/**
	 * Set A_Asset_Transfer_ID.
	 *
	 * @param A_Asset_Transfer_ID A_Asset_Transfer_ID
	 */

	public void setA_Asset_Transfer_ID(int A_Asset_Transfer_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Transfer_ID(A_Asset_Transfer_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Asset_Transfer_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Asset_Transfer_UU();
	}

	/**
	 * Set Capital/Expense.
	 *
	 * @param A_CapvsExp Capital/Expense
	 */
	@JsonProperty("A_CapvsExp")
	public void setA_CapvsExpInput(I_AD_Ref_ListInput A_CapvsExp) {
		this.mA_CapvsExp = A_CapvsExp;
		if (A_CapvsExp != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_CapvsExp.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_CapvsExp(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_CapvsExp.getUUID());
			}
		} else {
			this.setA_CapvsExp(null);
		}
	}

	/**
	 * Get Capital/Expense.
	 *
	 * @return Capital/Expense
	 */
	@JsonProperty("A_CapvsExp")
	public I_AD_Ref_ListInput A_CapvsExp() {
		return mA_CapvsExp;
	}

	/**
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public void setA_Depreciation_AInput(ForeignEntityInput A_Depreciation_A) {
		this.mA_Depreciation_A = A_Depreciation_A;
		if (get_ID() != 0) {
			return;
		}
		if (A_Depreciation_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Depreciation_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Depreciation_A.getUUID());
			}
		} else {
			this.setA_Depreciation_Acct(0);
		}
	}

	/**
	 * Get Depreciation Account.
	 *
	 * @return Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public ForeignEntityInput A_Depreciation_A() {
		return mA_Depreciation_A;
	}
	/**
	 * Set A_Depreciation_Acct_Str.
	 *
	 * @param A_Depreciation_Acct_Str A_Depreciation_Acct_Str
	 */

	public void setA_Depreciation_Acct_Str(String A_Depreciation_Acct_Str) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Acct_Str(A_Depreciation_Acct_Str);
		}
	}

	/**
	 * Set Depreciation Acct (new).
	 *
	 * @param A_Depreciation_New_A Depreciation Acct (new)
	 */
	@JsonProperty("A_Depreciation_New_A")
	public void setA_Depreciation_New_AInput(ForeignEntityInput A_Depreciation_New_A) {
		this.mA_Depreciation_New_A = A_Depreciation_New_A;
		if (A_Depreciation_New_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Depreciation_New_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_New_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Depreciation_New_A.getUUID());
			}
		} else {
			this.setA_Depreciation_New_Acct(0);
		}
	}

	/**
	 * Get Depreciation Acct (new).
	 *
	 * @return Depreciation Acct (new)
	 */
	@JsonProperty("A_Depreciation_New_A")
	public ForeignEntityInput A_Depreciation_New_A() {
		return mA_Depreciation_New_A;
	}

	/**
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_A Disposal Loss Acct
	 */
	@JsonProperty("A_Disposal_Loss_A")
	public void setA_Disposal_Loss_AInput(ForeignEntityInput A_Disposal_Loss_A) {
		this.mA_Disposal_Loss_A = A_Disposal_Loss_A;
		if (get_ID() != 0) {
			return;
		}
		if (A_Disposal_Loss_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Disposal_Loss_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Disposal_Loss_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Disposal_Loss_A.getUUID());
			}
		} else {
			this.setA_Disposal_Loss_Acct(0);
		}
	}

	/**
	 * Get Disposal Loss Acct.
	 *
	 * @return Disposal Loss Acct
	 */
	@JsonProperty("A_Disposal_Loss_A")
	public ForeignEntityInput A_Disposal_Loss_A() {
		return mA_Disposal_Loss_A;
	}

	/**
	 * Set Disposal Loss Acct (new).
	 *
	 * @param A_Disposal_Loss_New_A Disposal Loss Acct (new)
	 */
	@JsonProperty("A_Disposal_Loss_New_A")
	public void setA_Disposal_Loss_New_AInput(ForeignEntityInput A_Disposal_Loss_New_A) {
		this.mA_Disposal_Loss_New_A = A_Disposal_Loss_New_A;
		if (A_Disposal_Loss_New_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Disposal_Loss_New_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Disposal_Loss_New_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Disposal_Loss_New_A.getUUID());
			}
		} else {
			this.setA_Disposal_Loss_New_Acct(0);
		}
	}

	/**
	 * Get Disposal Loss Acct (new).
	 *
	 * @return Disposal Loss Acct (new)
	 */
	@JsonProperty("A_Disposal_Loss_New_A")
	public ForeignEntityInput A_Disposal_Loss_New_A() {
		return mA_Disposal_Loss_New_A;
	}
	/**
	 * Set Disposal Loss Str.
	 *
	 * @param A_Disposal_Loss_Str Disposal Loss Str
	 */

	public void setA_Disposal_Loss_Str(String A_Disposal_Loss_Str) {
		if (get_ID() == 0) {
			super.setA_Disposal_Loss_Str(A_Disposal_Loss_Str);
		}
	}

	/**
	 * Set Disposal Revenue Acct.
	 *
	 * @param A_Disposal_Revenue_A Disposal Revenue Acct
	 */
	@JsonProperty("A_Disposal_Revenue_A")
	public void setA_Disposal_Revenue_AInput(ForeignEntityInput A_Disposal_Revenue_A) {
		this.mA_Disposal_Revenue_A = A_Disposal_Revenue_A;
		if (get_ID() != 0) {
			return;
		}
		if (A_Disposal_Revenue_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Disposal_Revenue_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Disposal_Revenue_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Disposal_Revenue_A.getUUID());
			}
		} else {
			this.setA_Disposal_Revenue_Acct(0);
		}
	}

	/**
	 * Get Disposal Revenue Acct.
	 *
	 * @return Disposal Revenue Acct
	 */
	@JsonProperty("A_Disposal_Revenue_A")
	public ForeignEntityInput A_Disposal_Revenue_A() {
		return mA_Disposal_Revenue_A;
	}

	/**
	 * Set Disposal Revenue Acct (new).
	 *
	 * @param A_Disposal_Revenue_New_A Disposal Revenue Acct (new)
	 */
	@JsonProperty("A_Disposal_Revenue_New_A")
	public void setA_Disposal_Revenue_New_AInput(ForeignEntityInput A_Disposal_Revenue_New_A) {
		this.mA_Disposal_Revenue_New_A = A_Disposal_Revenue_New_A;
		if (A_Disposal_Revenue_New_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Disposal_Revenue_New_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Disposal_Revenue_New_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Disposal_Revenue_New_A.getUUID());
			}
		} else {
			this.setA_Disposal_Revenue_New_Acct(0);
		}
	}

	/**
	 * Get Disposal Revenue Acct (new).
	 *
	 * @return Disposal Revenue Acct (new)
	 */
	@JsonProperty("A_Disposal_Revenue_New_A")
	public ForeignEntityInput A_Disposal_Revenue_New_A() {
		return mA_Disposal_Revenue_New_A;
	}
	/**
	 * Set Disposal Revenue Str.
	 *
	 * @param A_Disposal_Revenue_Str Disposal Revenue Str
	 */

	public void setA_Disposal_Revenue_Str(String A_Disposal_Revenue_Str) {
		if (get_ID() == 0) {
			super.setA_Disposal_Revenue_Str(A_Disposal_Revenue_Str);
		}
	}
	/**
	 * Set A_Period_End.
	 *
	 * @param A_Period_End A_Period_End
	 */

	public void setA_Period_End(int A_Period_End) {
		if (get_ID() == 0) {
			super.setA_Period_End(A_Period_End);
		}
	}
	/**
	 * Set A_Period_Start.
	 *
	 * @param A_Period_Start A_Period_Start
	 */

	public void setA_Period_Start(int A_Period_Start) {
		if (get_ID() == 0) {
			super.setA_Period_Start(A_Period_Start);
		}
	}
	/**
	 * Set Split Percent.
	 *
	 * @param A_Split_Percent Split Percent
	 */

	public void setA_Split_Percent(BigDecimal A_Split_Percent) {
		if (get_ID() == 0) {
			super.setA_Split_Percent(A_Split_Percent);
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
		if (get_ID() != 0) {
			return;
		}
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
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
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
							.setParameters(C_Period.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UUID " + C_Period.getUUID());
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
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocAction.getUUID());
			}
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public I_AD_Ref_ListInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(I_AD_Ref_ListInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocStatus.getUUID());
			}
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public I_AD_Ref_ListInput DocStatus() {
		return mDocStatus;
	}
	/**
	 * Set Posted.
	 *
	 * @param Posted Posting status
	 */

	public void setPosted(boolean Posted) {
		if (get_ID() == 0) {
			super.setPosted(Posted);
		}
	}

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(I_AD_Ref_ListInput PostingType) {
		this.mPostingType = PostingType;
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
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
