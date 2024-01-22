package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAddition;
import org.compiere.model.MAssetChange;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Retirement;
import org.compiere.model.X_A_Depreciation_Table_Header;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_ChangeInput extends MAssetChange implements I_A_Asset_ChangeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mA_Accumdepreciation_A;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_A;
	private ForeignEntityInput mA_Asset_Addition;
	private ForeignEntityInput mA_Asset_Retirement;
	private ForeignEntityInput mA_Depreciation_A;
	private ForeignEntityInput mA_Depreciation_Table_Header;
	private ForeignEntityInput mA_Disposal_Loss_A;
	private ForeignEntityInput mA_Disposal_Revenue_A;
	private ForeignEntityInput mA_Parent_Asset;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mC_ValidCombination;
	private I_AD_Ref_ListInput mA_Depreciation_Manual_Period;
	private I_AD_Ref_ListInput mA_Reval_Cal_Method;
	private I_AD_Ref_ListInput mChangeType;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_ChangeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAssetChange(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Accumulated Depreciation Account.
	 *
	 * @param A_Accumdepreciation_A Accumulated Depreciation Account
	 */
	@JsonProperty("A_Accumdepreciation_A")
	public void setA_Accumdepreciation_AInput(ForeignEntityInput A_Accumdepreciation_A) {
		this.mA_Accumdepreciation_A = A_Accumdepreciation_A;
		MAccount foreignEntity;
		if (A_Accumdepreciation_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Accumdepreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Accumdepreciation_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Accumdepreciation_Acct(0);
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
		MAccount foreignEntity;
		if (A_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Acct(0);
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
	 * Set Asset Addition.
	 *
	 * @param A_Asset_Addition Asset Addition
	 */
	@JsonProperty("A_Asset_Addition")
	public void setA_Asset_AdditionInput(ForeignEntityInput A_Asset_Addition) {
		this.mA_Asset_Addition = A_Asset_Addition;
		MAssetAddition foreignEntity;
		if (get_ID() == 0 && A_Asset_Addition != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset_Addition", "A_Asset_Addition_UU=?", get_TrxName())
						.setParameters(A_Asset_Addition.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Addition_ID(foreignEntity.get_ID());
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
	 * Set A_Asset_Change_ID.
	 *
	 * @param A_Asset_Change_ID A_Asset_Change_ID
	 */

	public void setA_Asset_Change_ID(int A_Asset_Change_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Change_ID(A_Asset_Change_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Change_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Change_UU();
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
		if (get_ID() == 0 && A_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
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
	 * Set Asset Retirement.
	 *
	 * @param A_Asset_Retirement Internally used asset is not longer used.
	 */
	@JsonProperty("A_Asset_Retirement")
	public void setA_Asset_RetirementInput(ForeignEntityInput A_Asset_Retirement) {
		this.mA_Asset_Retirement = A_Asset_Retirement;
		X_A_Asset_Retirement foreignEntity;
		if (get_ID() == 0 && A_Asset_Retirement != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset_Retirement", "A_Asset_Retirement_UU=?", get_TrxName())
						.setParameters(A_Asset_Retirement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Retirement_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset Retirement.
	 *
	 * @return Internally used asset is not longer used.
	 */
	@JsonProperty("A_Asset_Retirement")
	public ForeignEntityInput A_Asset_Retirement() {
		return mA_Asset_Retirement;
	}

	/**
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public void setA_Depreciation_AInput(ForeignEntityInput A_Depreciation_A) {
		this.mA_Depreciation_A = A_Depreciation_A;
		MAccount foreignEntity;
		if (A_Depreciation_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Depreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Acct(0);
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
	 * Set A_Depreciation_Manual_Period.
	 *
	 * @param A_Depreciation_Manual_Period A_Depreciation_Manual_Period
	 */
	@JsonProperty("A_Depreciation_Manual_Period")
	public void setA_Depreciation_Manual_PeriodInput(I_AD_Ref_ListInput A_Depreciation_Manual_Period) {
		this.mA_Depreciation_Manual_Period = A_Depreciation_Manual_Period;
		MRefList_BH foreignEntity;
		if (A_Depreciation_Manual_Period != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Manual_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Manual_Period(foreignEntity.getValue());
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
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header A_Depreciation_Table_Header_ID
	 */
	@JsonProperty("A_Depreciation_Table_Header")
	public void setA_Depreciation_Table_HeaderInput(ForeignEntityInput A_Depreciation_Table_Header) {
		this.mA_Depreciation_Table_Header = A_Depreciation_Table_Header;
		X_A_Depreciation_Table_Header foreignEntity;
		if (A_Depreciation_Table_Header != null &&
				(foreignEntity = new Query(getCtx(), "A_Depreciation_Table_Header", "A_Depreciation_Table_Header_UU=?", get_TrxName())
						.setParameters(A_Depreciation_Table_Header.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Table_Header_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Table_Header_ID(0);
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
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_A Disposal Loss Acct
	 */
	@JsonProperty("A_Disposal_Loss_A")
	public void setA_Disposal_Loss_AInput(ForeignEntityInput A_Disposal_Loss_A) {
		this.mA_Disposal_Loss_A = A_Disposal_Loss_A;
		MAccount foreignEntity;
		if (A_Disposal_Loss_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Disposal_Loss_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Loss_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Disposal_Loss_Acct(0);
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
		MAccount foreignEntity;
		if (A_Disposal_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Disposal_Revenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Revenue_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Disposal_Revenue_Acct(0);
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
	 * Set Parent Asset.
	 *
	 * @param A_Parent_Asset Parent Asset
	 */
	@JsonProperty("A_Parent_Asset")
	public void setA_Parent_AssetInput(ForeignEntityInput A_Parent_Asset) {
		this.mA_Parent_Asset = A_Parent_Asset;
		MAsset foreignEntity;
		if (A_Parent_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Parent_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Parent_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Parent_Asset_ID(0);
		}
	}

	/**
	 * Get Parent Asset.
	 *
	 * @return Parent Asset
	 */
	@JsonProperty("A_Parent_Asset")
	public ForeignEntityInput A_Parent_Asset() {
		return mA_Parent_Asset;
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
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
	/**
	 * Set AssetAccumDepreciationAmt.
	 *
	 * @param AssetAccumDepreciationAmt AssetAccumDepreciationAmt
	 */

	public void setAssetAccumDepreciationAmt(BigDecimal AssetAccumDepreciationAmt) {
		if (get_ID() == 0) {
			super.setAssetAccumDepreciationAmt(AssetAccumDepreciationAmt);
		}
	}
	/**
	 * Set AssetBookValueAmt.
	 *
	 * @param AssetBookValueAmt AssetBookValueAmt
	 */

	public void setAssetBookValueAmt(BigDecimal AssetBookValueAmt) {
		if (get_ID() == 0) {
			super.setAssetBookValueAmt(AssetBookValueAmt);
		}
	}
	/**
	 * Set Asset Depreciation Date.
	 *
	 * @param AssetDepreciationDate Date of last depreciation
	 */

	public void setAssetDepreciationDate(Timestamp AssetDepreciationDate) {
		if (get_ID() == 0) {
			super.setAssetDepreciationDate(AssetDepreciationDate);
		}
	}
	/**
	 * Set Market value Amount.
	 *
	 * @param AssetMarketValueAmt Market value of the asset
	 */

	public void setAssetMarketValueAmt(BigDecimal AssetMarketValueAmt) {
		if (get_ID() == 0) {
			super.setAssetMarketValueAmt(AssetMarketValueAmt);
		}
	}
	/**
	 * Set In Service Date.
	 *
	 * @param AssetServiceDate Date when Asset was put into service
	 */

	public void setAssetServiceDate(Timestamp AssetServiceDate) {
		if (get_ID() == 0) {
			super.setAssetServiceDate(AssetServiceDate);
		}
	}
	/**
	 * Set Asset value.
	 *
	 * @param AssetValueAmt Book Value of the asset
	 */

	public void setAssetValueAmt(BigDecimal AssetValueAmt) {
		if (get_ID() == 0) {
			super.setAssetValueAmt(AssetValueAmt);
		}
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
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public ForeignEntityInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(ForeignEntityInput C_Location) {
		this.mC_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	@JsonProperty("C_Location")
	public ForeignEntityInput C_Location() {
		return mC_Location;
	}

	/**
	 * Set Combination.
	 *
	 * @param C_ValidCombination Valid Account Combination
	 */
	@JsonProperty("C_ValidCombination")
	public void setC_ValidCombinationInput(ForeignEntityInput C_ValidCombination) {
		this.mC_ValidCombination = C_ValidCombination;
		MAccount foreignEntity;
		if (C_ValidCombination != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(C_ValidCombination.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ValidCombination_ID(foreignEntity.get_ID());
		} else {
			super.setC_ValidCombination_ID(0);
		}
	}

	/**
	 * Get Combination.
	 *
	 * @return Valid Account Combination
	 */
	@JsonProperty("C_ValidCombination")
	public ForeignEntityInput C_ValidCombination() {
		return mC_ValidCombination;
	}
	/**
	 * Set ChangeAmt.
	 *
	 * @param ChangeAmt ChangeAmt
	 */

	public void setChangeAmt(BigDecimal ChangeAmt) {
		if (get_ID() == 0) {
			super.setChangeAmt(ChangeAmt);
		}
	}
	/**
	 * Set ChangeDate.
	 *
	 * @param ChangeDate ChangeDate
	 */

	public void setChangeDate(Timestamp ChangeDate) {
		if (get_ID() == 0) {
			super.setChangeDate(ChangeDate);
		}
	}

	/**
	 * Set ChangeType.
	 *
	 * @param ChangeType ChangeType
	 */
	@JsonProperty("ChangeType")
	public void setChangeTypeInput(I_AD_Ref_ListInput ChangeType) {
		this.mChangeType = ChangeType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&ChangeType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ChangeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setChangeType(foreignEntity.getValue());
		}
	}

	/**
	 * Get ChangeType.
	 *
	 * @return ChangeType
	 */
	@JsonProperty("ChangeType")
	public I_AD_Ref_ListInput ChangeType() {
		return mChangeType;
	}
	/**
	 * Set Life use.
	 *
	 * @param LifeUseUnits Units of use until the asset is not usable anymore
	 */

	public void setLifeUseUnits(int LifeUseUnits) {
		if (get_ID() == 0) {
			super.setLifeUseUnits(LifeUseUnits);
		}
	}
	/**
	 * Set Lot No.
	 *
	 * @param Lot Lot number (alphanumeric)
	 */

	public void setLot(String Lot) {
		if (get_ID() == 0) {
			super.setLot(Lot);
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
	/**
	 * Set Serial No.
	 *
	 * @param SerNo Product Serial Number 
	 */

	public void setSerNo(String SerNo) {
		if (get_ID() == 0) {
			super.setSerNo(SerNo);
		}
	}
	/**
	 * Set Details.
	 *
	 * @param TextDetails Details
	 */

	public void setTextDetails(String TextDetails) {
		if (get_ID() == 0) {
			super.setTextDetails(TextDetails);
		}
	}
	/**
	 * Set Usable Life - Months.
	 *
	 * @param UseLifeMonths Months of the usable life of the asset
	 */

	public void setUseLifeMonths(int UseLifeMonths) {
		if (get_ID() == 0) {
			super.setUseLifeMonths(UseLifeMonths);
		}
	}
	/**
	 * Set Usable Life - Years.
	 *
	 * @param UseLifeYears Years of the usable life of the asset
	 */

	public void setUseLifeYears(int UseLifeYears) {
		if (get_ID() == 0) {
			super.setUseLifeYears(UseLifeYears);
		}
	}
	/**
	 * Set Version No.
	 *
	 * @param VersionNo Version Number
	 */

	public void setVersionNo(String VersionNo) {
		if (get_ID() == 0) {
			super.setVersionNo(VersionNo);
		}
	}
}
