package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetGroupAcct;
import org.compiere.model.MDepreciation;
import org.compiere.model.MDepreciationConvention;
import org.compiere.model.MDepreciationMethod;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Group_AcctInput extends MAssetGroupAcct implements I_A_Asset_Group_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Accumdepreciation_A;
	private ForeignEntityInput mA_Asset_A;
	private ForeignEntityInput mA_Asset_Group;
	private ForeignEntityInput mA_Depreciation;
	private ForeignEntityInput mA_Depreciation_A;
	private ForeignEntityInput mA_Depreciation_Conv;
	private ForeignEntityInput mA_Depreciation_Conv_F;
	private ForeignEntityInput mA_Depreciation_F;
	private ForeignEntityInput mA_Depreciation_Method;
	private ForeignEntityInput mA_Depreciation_Method_F;
	private ForeignEntityInput mA_Depreciation_Table_Header;
	private ForeignEntityInput mA_Disposal_Gain_A;
	private ForeignEntityInput mA_Disposal_Loss_A;
	private ForeignEntityInput mA_Disposal_Revenue_A;
	private ForeignEntityInput mA_Reval_Adep_Offset_Cur_A;
	private ForeignEntityInput mA_Reval_Adep_Offset_Prior_A;
	private ForeignEntityInput mA_Reval_Cost_Offset_A;
	private ForeignEntityInput mA_Reval_Cost_Offset_Prior_A;
	private ForeignEntityInput mA_Reval_Depexp_Offset_A;
	private ForeignEntityInput mC_AcctSchema;
	private I_AD_Ref_ListInput mA_Depreciation_Manual_Period;
	private I_AD_Ref_ListInput mA_Reval_Cal_Method;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Group_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_Group_AcctInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
	 * Set Asset Group Accounting.
	 *
	 * @param A_Asset_Group_Acct_ID Asset Group Accounting
	 */

	public void setA_Asset_Group_Acct_ID(int A_Asset_Group_Acct_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Group_Acct_ID(A_Asset_Group_Acct_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Asset_Group_Acct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Asset_Group_Acct_UU();
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(ForeignEntityInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		if (get_ID() != 0) {
			return;
		}
		if (A_Asset_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Group", "A_Asset_Group_UU=?", get_TrxName())
							.setParameters(A_Asset_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Group with UUID " + A_Asset_Group.getUUID());
			}
		} else {
			this.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public ForeignEntityInput A_Asset_Group() {
		return mA_Asset_Group;
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
							.setParameters(A_Depreciation_Conv_F.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_Conv_F_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Convention with UUID " + A_Depreciation_Conv_F.getUUID());
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
							.setParameters(A_Depreciation_Conv.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_Conv_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Convention with UUID " + A_Depreciation_Conv.getUUID());
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
							.setParameters(A_Depreciation_F.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_F_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation with UUID " + A_Depreciation_F.getUUID());
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
							.setParameters(A_Depreciation.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation with UUID " + A_Depreciation.getUUID());
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
	public void setA_Depreciation_Manual_PeriodInput(I_AD_Ref_ListInput A_Depreciation_Manual_Period) {
		this.mA_Depreciation_Manual_Period = A_Depreciation_Manual_Period;
		if (A_Depreciation_Manual_Period != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Depreciation_Manual_Period.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_Manual_Period(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_Depreciation_Manual_Period.getUUID());
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
	public I_AD_Ref_ListInput A_Depreciation_Manual_Period() {
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
							.setParameters(A_Depreciation_Method_F.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_Method_F_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Method with UUID " + A_Depreciation_Method_F.getUUID());
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
							.setParameters(A_Depreciation_Method.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_Method_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Method with UUID " + A_Depreciation_Method.getUUID());
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
							.setParameters(A_Depreciation_Table_Header.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Depreciation_Table_Header_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Depreciation_Table_Header with UUID " + A_Depreciation_Table_Header.getUUID());
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
							.setParameters(A_Disposal_Gain_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Disposal_Gain_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Disposal_Gain_A.getUUID());
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
							.setParameters(A_Reval_Adep_Offset_Cur_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Reval_Adep_Offset_Cur_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Reval_Adep_Offset_Cur_A.getUUID());
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
							.setParameters(A_Reval_Adep_Offset_Prior_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Reval_Adep_Offset_Prior_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Reval_Adep_Offset_Prior_A.getUUID());
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
	public void setA_Reval_Cal_MethodInput(I_AD_Ref_ListInput A_Reval_Cal_Method) {
		this.mA_Reval_Cal_Method = A_Reval_Cal_Method;
		if (A_Reval_Cal_Method != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Reval_Cal_Method.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Reval_Cal_Method(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_Reval_Cal_Method.getUUID());
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
	public I_AD_Ref_ListInput A_Reval_Cal_Method() {
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
							.setParameters(A_Reval_Cost_Offset_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Reval_Cost_Offset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Reval_Cost_Offset_A.getUUID());
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
							.setParameters(A_Reval_Cost_Offset_Prior_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Reval_Cost_Offset_Prior_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Reval_Cost_Offset_Prior_A.getUUID());
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
							.setParameters(A_Reval_Depexp_Offset_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Reval_Depexp_Offset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_Reval_Depexp_Offset_A.getUUID());
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
