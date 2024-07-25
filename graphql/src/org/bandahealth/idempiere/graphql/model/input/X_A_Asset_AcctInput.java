package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_A_Asset_AcctResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAcct;
import org.compiere.model.MDepreciation;
import org.compiere.model.MDepreciationConvention;
import org.compiere.model.MDepreciationMethod;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for A_Asset_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_AcctInput extends MAssetAcct implements I_A_Asset_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Accumdepreciation_A;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_A;
	private ForeignEntityInput mA_Depreciation;
	private ForeignEntityInput mA_Depreciation_A;
	private ForeignEntityInput mA_Depreciation_Conv;
	private ForeignEntityInput mA_Depreciation_Conv_F;
	private ForeignEntityInput mA_Depreciation_F;
	private ForeignEntityInput mA_Depreciation_Manual_Period;
	private ForeignEntityInput mA_Depreciation_Method;
	private ForeignEntityInput mA_Depreciation_Method_F;
	private ForeignEntityInput mA_Depreciation_Table_Header;
	private ForeignEntityInput mA_Disposal_Gain_A;
	private ForeignEntityInput mA_Disposal_Loss_A;
	private ForeignEntityInput mA_Disposal_Revenue_A;
	private ForeignEntityInput mA_Reval_Adep_Offset_Cur_A;
	private ForeignEntityInput mA_Reval_Adep_Offset_Prior_A;
	private ForeignEntityInput mA_Reval_Cal_Method;
	private ForeignEntityInput mA_Reval_Cost_Offset_A;
	private ForeignEntityInput mA_Reval_Cost_Offset_Prior_A;
	private ForeignEntityInput mA_Reval_Depexp_Offset_A;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Asset_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_AcctInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Accumulated Depreciation Account.
	 *
	 * @param A_Accumdepreciation_A Accumulated Depreciation Account
	 */
	@JsonProperty("A_Accumdepreciation_A")
	public void setA_Accumdepreciation_AInput(ForeignEntityInput A_Accumdepreciation_A) {
		this.mA_Accumdepreciation_A = A_Accumdepreciation_A;
		if (A_Accumdepreciation_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Accumdepreciation_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Accumdepreciation_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Accumdepreciation_A.getUU());
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
	 * Set Asset Acct.
	 *
	 * @param A_Asset_A Asset Acct
	 */
	@JsonProperty("A_Asset_A")
	public void setA_Asset_AInput(ForeignEntityInput A_Asset_A) {
		this.mA_Asset_A = A_Asset_A;
		if (A_Asset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Asset_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Asset_A.getUU());
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
	 * Set A_Asset_Acct_ID.
	 *
	 * @param A_Asset_Acct_ID A_Asset_Acct_ID
	 */
	@JsonProperty("A_Asset_Acct_ID")
	public void setA_Asset_Acct_IDFromJson(int A_Asset_Acct_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Acct_ID(A_Asset_Acct_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Asset_Acct_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Asset_Acct_UU();
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
							.setParameters(A_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public void setA_Depreciation_AInput(ForeignEntityInput A_Depreciation_A) {
		this.mA_Depreciation_A = A_Depreciation_A;
		if (A_Depreciation_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Depreciation_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Depreciation_A.getUU());
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
	 * Set Depreciation Convention (fiscal).
	 *
	 * @param A_Depreciation_Conv_F Depreciation Convention (fiscal)
	 */
	@JsonProperty("A_Depreciation_Conv_F")
	public void setA_Depreciation_Conv_FInput(ForeignEntityInput A_Depreciation_Conv_F) {
		this.mA_Depreciation_Conv_F = A_Depreciation_Conv_F;
		if (A_Depreciation_Conv_F != null) {
			// Since an entity was passed, make sure it's in the DB
			MDepreciationConvention foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation_Convention", "A_Depreciation_Convention_UU=?", get_TrxName())
							.setParameters(A_Depreciation_Conv_F.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_Conv_F_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Convention with UU " + A_Depreciation_Conv_F.getUU());
			}
		} else {
			this.setA_Depreciation_Conv_F_ID(0);
		}
	}

	/**
	 * Get Depreciation Convention (fiscal).
	 *
	 * @return Depreciation Convention (fiscal)
	 */
	@JsonProperty("A_Depreciation_Conv_F")
	public ForeignEntityInput A_Depreciation_Conv_F() {
		return mA_Depreciation_Conv_F;
	}

	/**
	 * Set Convention Type.
	 *
	 * @param A_Depreciation_Conv Convention Type
	 */
	@JsonProperty("A_Depreciation_Conv")
	public void setA_Depreciation_ConvInput(ForeignEntityInput A_Depreciation_Conv) {
		this.mA_Depreciation_Conv = A_Depreciation_Conv;
		if (A_Depreciation_Conv != null) {
			// Since an entity was passed, make sure it's in the DB
			MDepreciationConvention foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation_Convention", "A_Depreciation_Convention_UU=?", get_TrxName())
							.setParameters(A_Depreciation_Conv.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_Conv_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Convention with UU " + A_Depreciation_Conv.getUU());
			}
		} else {
			this.setA_Depreciation_Conv_ID(0);
		}
	}

	/**
	 * Get Convention Type.
	 *
	 * @return Convention Type
	 */
	@JsonProperty("A_Depreciation_Conv")
	public ForeignEntityInput A_Depreciation_Conv() {
		return mA_Depreciation_Conv;
	}

	/**
	 * Set Depreciation (fiscal).
	 *
	 * @param A_Depreciation_F Depreciation (fiscal)
	 */
	@JsonProperty("A_Depreciation_F")
	public void setA_Depreciation_FInput(ForeignEntityInput A_Depreciation_F) {
		this.mA_Depreciation_F = A_Depreciation_F;
		if (A_Depreciation_F != null) {
			// Since an entity was passed, make sure it's in the DB
			MDepreciation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation", "A_Depreciation_UU=?", get_TrxName())
							.setParameters(A_Depreciation_F.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_F_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation with UU " + A_Depreciation_F.getUU());
			}
		} else {
			this.setA_Depreciation_F_ID(0);
		}
	}

	/**
	 * Get Depreciation (fiscal).
	 *
	 * @return Depreciation (fiscal)
	 */
	@JsonProperty("A_Depreciation_F")
	public ForeignEntityInput A_Depreciation_F() {
		return mA_Depreciation_F;
	}

	/**
	 * Set Depreciation.
	 *
	 * @param A_Depreciation Depreciation
	 */
	@JsonProperty("A_Depreciation")
	public void setA_DepreciationInput(ForeignEntityInput A_Depreciation) {
		this.mA_Depreciation = A_Depreciation;
		if (A_Depreciation != null) {
			// Since an entity was passed, make sure it's in the DB
			MDepreciation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation", "A_Depreciation_UU=?", get_TrxName())
							.setParameters(A_Depreciation.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation with UU " + A_Depreciation.getUU());
			}
		} else {
			this.setA_Depreciation_ID(0);
		}
	}

	/**
	 * Get Depreciation.
	 *
	 * @return Depreciation
	 */
	@JsonProperty("A_Depreciation")
	public ForeignEntityInput A_Depreciation() {
		return mA_Depreciation;
	}

	/**
	 * Set A_Depreciation_Manual_Period.
	 *
	 * @param A_Depreciation_Manual_Period A_Depreciation_Manual_Period
	 */
	@JsonProperty("A_Depreciation_Manual_Period")
	public void setA_Depreciation_Manual_PeriodInput(ForeignEntityInput A_Depreciation_Manual_Period) {
		this.mA_Depreciation_Manual_Period = A_Depreciation_Manual_Period;
		if (A_Depreciation_Manual_Period != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_AcctResolver.A_DEPRECIATION_MANUAL_PERIOD_UUIDS_BY_VALUE.containsValue(A_Depreciation_Manual_Period.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Depreciation_Manual_Period.getUU() +
						" is not in the list defined for the A_Depreciation_Manual_Period column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Depreciation_Manual_Period.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_Manual_Period(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Depreciation_Manual_Period.getUU());
			}
		} else {
			this.setA_Depreciation_Manual_Period(null);
		}
	}

	/**
	 * Get A_Depreciation_Manual_Period.
	 *
	 * @return A_Depreciation_Manual_Period
	 */
	@JsonProperty("A_Depreciation_Manual_Period")
	public ForeignEntityInput A_Depreciation_Manual_Period() {
		return mA_Depreciation_Manual_Period;
	}

	/**
	 * Set Depreciation Method (fiscal).
	 *
	 * @param A_Depreciation_Method_F Depreciation Method (fiscal)
	 */
	@JsonProperty("A_Depreciation_Method_F")
	public void setA_Depreciation_Method_FInput(ForeignEntityInput A_Depreciation_Method_F) {
		this.mA_Depreciation_Method_F = A_Depreciation_Method_F;
		if (A_Depreciation_Method_F != null) {
			// Since an entity was passed, make sure it's in the DB
			MDepreciationMethod foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation_Method", "A_Depreciation_Method_UU=?", get_TrxName())
							.setParameters(A_Depreciation_Method_F.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_Method_F_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Method with UU " + A_Depreciation_Method_F.getUU());
			}
		} else {
			this.setA_Depreciation_Method_F_ID(0);
		}
	}

	/**
	 * Get Depreciation Method (fiscal).
	 *
	 * @return Depreciation Method (fiscal)
	 */
	@JsonProperty("A_Depreciation_Method_F")
	public ForeignEntityInput A_Depreciation_Method_F() {
		return mA_Depreciation_Method_F;
	}

	/**
	 * Set Depreciation Method.
	 *
	 * @param A_Depreciation_Method Depreciation Method
	 */
	@JsonProperty("A_Depreciation_Method")
	public void setA_Depreciation_MethodInput(ForeignEntityInput A_Depreciation_Method) {
		this.mA_Depreciation_Method = A_Depreciation_Method;
		if (A_Depreciation_Method != null) {
			// Since an entity was passed, make sure it's in the DB
			MDepreciationMethod foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation_Method", "A_Depreciation_Method_UU=?", get_TrxName())
							.setParameters(A_Depreciation_Method.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_Method_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Method with UU " + A_Depreciation_Method.getUU());
			}
		} else {
			this.setA_Depreciation_Method_ID(0);
		}
	}

	/**
	 * Get Depreciation Method.
	 *
	 * @return Depreciation Method
	 */
	@JsonProperty("A_Depreciation_Method")
	public ForeignEntityInput A_Depreciation_Method() {
		return mA_Depreciation_Method;
	}

	/**
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header A_Depreciation_Table_Header_ID
	 */
	@JsonProperty("A_Depreciation_Table_Header")
	public void setA_Depreciation_Table_HeaderInput(ForeignEntityInput A_Depreciation_Table_Header) {
		this.mA_Depreciation_Table_Header = A_Depreciation_Table_Header;
		if (A_Depreciation_Table_Header != null) {
			// Since an entity was passed, make sure it's in the DB
			X_A_Depreciation_Table_Header foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Depreciation_Table_Header", "A_Depreciation_Table_Header_UU=?", get_TrxName())
							.setParameters(A_Depreciation_Table_Header.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Depreciation_Table_Header_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Table_Header with UU " + A_Depreciation_Table_Header.getUU());
			}
		} else {
			this.setA_Depreciation_Table_Header_ID(0);
		}
	}

	/**
	 * Get A_Depreciation_Table_Header_ID.
	 *
	 * @return A_Depreciation_Table_Header_ID
	 */
	@JsonProperty("A_Depreciation_Table_Header")
	public ForeignEntityInput A_Depreciation_Table_Header() {
		return mA_Depreciation_Table_Header;
	}

	/**
	 * Set Disposal Gain Acct.
	 *
	 * @param A_Disposal_Gain_A Disposal Gain Acct
	 */
	@JsonProperty("A_Disposal_Gain_A")
	public void setA_Disposal_Gain_AInput(ForeignEntityInput A_Disposal_Gain_A) {
		this.mA_Disposal_Gain_A = A_Disposal_Gain_A;
		if (A_Disposal_Gain_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Disposal_Gain_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Disposal_Gain_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Disposal_Gain_A.getUU());
			}
		} else {
			this.setA_Disposal_Gain_Acct(0);
		}
	}

	/**
	 * Get Disposal Gain Acct.
	 *
	 * @return Disposal Gain Acct
	 */
	@JsonProperty("A_Disposal_Gain_A")
	public ForeignEntityInput A_Disposal_Gain_A() {
		return mA_Disposal_Gain_A;
	}

	/**
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_A Disposal Loss Acct
	 */
	@JsonProperty("A_Disposal_Loss_A")
	public void setA_Disposal_Loss_AInput(ForeignEntityInput A_Disposal_Loss_A) {
		this.mA_Disposal_Loss_A = A_Disposal_Loss_A;
		if (A_Disposal_Loss_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Disposal_Loss_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Disposal_Loss_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Disposal_Loss_A.getUU());
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
	 * Set Disposal Revenue Acct.
	 *
	 * @param A_Disposal_Revenue_A Disposal Revenue Acct
	 */
	@JsonProperty("A_Disposal_Revenue_A")
	public void setA_Disposal_Revenue_AInput(ForeignEntityInput A_Disposal_Revenue_A) {
		this.mA_Disposal_Revenue_A = A_Disposal_Revenue_A;
		if (A_Disposal_Revenue_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Disposal_Revenue_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Disposal_Revenue_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Disposal_Revenue_A.getUU());
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
	 * Set A_Reval_Accumdep_Offset_Cur.
	 *
	 * @param A_Reval_Adep_Offset_Cur_A A_Reval_Accumdep_Offset_Cur
	 */
	@JsonProperty("A_Reval_Adep_Offset_Cur_A")
	public void setA_Reval_Adep_Offset_Cur_AInput(ForeignEntityInput A_Reval_Adep_Offset_Cur_A) {
		this.mA_Reval_Adep_Offset_Cur_A = A_Reval_Adep_Offset_Cur_A;
		if (A_Reval_Adep_Offset_Cur_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Reval_Adep_Offset_Cur_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Adep_Offset_Cur_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Reval_Adep_Offset_Cur_A.getUU());
			}
		} else {
			this.setA_Reval_Adep_Offset_Cur_Acct(0);
		}
	}

	/**
	 * Get A_Reval_Accumdep_Offset_Cur.
	 *
	 * @return A_Reval_Accumdep_Offset_Cur
	 */
	@JsonProperty("A_Reval_Adep_Offset_Cur_A")
	public ForeignEntityInput A_Reval_Adep_Offset_Cur_A() {
		return mA_Reval_Adep_Offset_Cur_A;
	}

	/**
	 * Set A_Reval_Accumdep_Offset_Prior.
	 *
	 * @param A_Reval_Adep_Offset_Prior_A A_Reval_Accumdep_Offset_Prior
	 */
	@JsonProperty("A_Reval_Adep_Offset_Prior_A")
	public void setA_Reval_Adep_Offset_Prior_AInput(ForeignEntityInput A_Reval_Adep_Offset_Prior_A) {
		this.mA_Reval_Adep_Offset_Prior_A = A_Reval_Adep_Offset_Prior_A;
		if (A_Reval_Adep_Offset_Prior_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Reval_Adep_Offset_Prior_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Adep_Offset_Prior_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Reval_Adep_Offset_Prior_A.getUU());
			}
		} else {
			this.setA_Reval_Adep_Offset_Prior_Acct(0);
		}
	}

	/**
	 * Get A_Reval_Accumdep_Offset_Prior.
	 *
	 * @return A_Reval_Accumdep_Offset_Prior
	 */
	@JsonProperty("A_Reval_Adep_Offset_Prior_A")
	public ForeignEntityInput A_Reval_Adep_Offset_Prior_A() {
		return mA_Reval_Adep_Offset_Prior_A;
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
			if (!X_A_Asset_AcctResolver.A_REVAL_CAL_METHOD_UUIDS_BY_VALUE.containsValue(A_Reval_Cal_Method.getUU())) {
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
	 * Set Reval Cost Offset Acct.
	 *
	 * @param A_Reval_Cost_Offset_A Reval Cost Offset Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_A")
	public void setA_Reval_Cost_Offset_AInput(ForeignEntityInput A_Reval_Cost_Offset_A) {
		this.mA_Reval_Cost_Offset_A = A_Reval_Cost_Offset_A;
		if (A_Reval_Cost_Offset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Reval_Cost_Offset_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Cost_Offset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Reval_Cost_Offset_A.getUU());
			}
		} else {
			this.setA_Reval_Cost_Offset_Acct(0);
		}
	}

	/**
	 * Get Reval Cost Offset Acct.
	 *
	 * @return Reval Cost Offset Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_A")
	public ForeignEntityInput A_Reval_Cost_Offset_A() {
		return mA_Reval_Cost_Offset_A;
	}

	/**
	 * Set Reval Cost Offset Prior Acct.
	 *
	 * @param A_Reval_Cost_Offset_Prior_A Reval Cost Offset Prior Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_Prior_A")
	public void setA_Reval_Cost_Offset_Prior_AInput(ForeignEntityInput A_Reval_Cost_Offset_Prior_A) {
		this.mA_Reval_Cost_Offset_Prior_A = A_Reval_Cost_Offset_Prior_A;
		if (A_Reval_Cost_Offset_Prior_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Reval_Cost_Offset_Prior_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Cost_Offset_Prior_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Reval_Cost_Offset_Prior_A.getUU());
			}
		} else {
			this.setA_Reval_Cost_Offset_Prior_Acct(0);
		}
	}

	/**
	 * Get Reval Cost Offset Prior Acct.
	 *
	 * @return Reval Cost Offset Prior Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_Prior_A")
	public ForeignEntityInput A_Reval_Cost_Offset_Prior_A() {
		return mA_Reval_Cost_Offset_Prior_A;
	}

	/**
	 * Set Reval Depexp Offset Acct.
	 *
	 * @param A_Reval_Depexp_Offset_A Reval Depexp Offset Acct
	 */
	@JsonProperty("A_Reval_Depexp_Offset_A")
	public void setA_Reval_Depexp_Offset_AInput(ForeignEntityInput A_Reval_Depexp_Offset_A) {
		this.mA_Reval_Depexp_Offset_A = A_Reval_Depexp_Offset_A;
		if (A_Reval_Depexp_Offset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_Reval_Depexp_Offset_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Depexp_Offset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + A_Reval_Depexp_Offset_A.getUU());
			}
		} else {
			this.setA_Reval_Depexp_Offset_Acct(0);
		}
	}

	/**
	 * Get Reval Depexp Offset Acct.
	 *
	 * @return Reval Depexp Offset Acct
	 */
	@JsonProperty("A_Reval_Depexp_Offset_A")
	public ForeignEntityInput A_Reval_Depexp_Offset_A() {
		return mA_Reval_Depexp_Offset_A;
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
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Posting Type.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(ForeignEntityInput PostingType) {
		this.mPostingType = PostingType;
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_AcctResolver.POSTINGTYPE_UUIDS_BY_VALUE.containsValue(PostingType.getUU())) {
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
	/**
	 * Set Valid from.
	 *
	 * @param ValidFrom Valid from including this date (first day)
	 */
	@JsonProperty("ValidFrom")
	public void setValidFromFromJson(Timestamp ValidFrom) {
		if (get_ID() == 0) {
			super.setValidFrom(ValidFrom);
		}
	}
}
