package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAddition;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Change;
import org.compiere.model.X_A_Asset_Retirement;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_ChangeInput extends X_A_Asset_Change implements I_A_Asset_ChangeInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Depreciation_Manual_Period_RL;
	 private I_AD_Ref_ListInput A_Reval_Cal_Method_RL;
	 private I_AD_Ref_ListInput ChangeType_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_AD_UserInput AD_User;
	 private I_A_AssetInput A_Asset;
	 private I_A_AssetInput A_Parent_Asset;
	 private I_A_Asset_AdditionInput A_Asset_Addition;
	 private I_A_Asset_RetirementInput A_Asset_Retirement;
	 private I_A_Depreciation_Table_HeaderInput A_Depreciation_Table_Header;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BPartner_LocationInput C_BPartner_Location;
	 private I_C_LocationInput C_Location;
	 private I_C_ValidCombinationInput A_Accumdepreciation_A;
	 private I_C_ValidCombinationInput A_Asset_A;
	 private I_C_ValidCombinationInput A_Depreciation_A;
	 private I_C_ValidCombinationInput A_Disposal_Loss_A;
	 private I_C_ValidCombinationInput A_Disposal_Revenue_A;
	 private I_C_ValidCombinationInput C_ValidCombination;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_ChangeInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Accumulated Depreciation Account.
	 *
	 * @param A_Accumdepreciation_A Accumulated Depreciation Account
	 */
	public void setA_Accumdepreciation_A(I_C_ValidCombinationInput A_Accumdepreciation_A) {
		this.A_Accumdepreciation_A = A_Accumdepreciation_A;
		MAccount foreignEntity;
		if (A_Accumdepreciation_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Accumdepreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Accumdepreciation_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Accumdepreciation_Acct(0);
		}
	}

	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	public I_C_ValidCombinationInput getA_Accumdepreciation_A() {
		return A_Accumdepreciation_A;
	}

	/**
	 * Set Asset Acct.
	 *
	 * @param A_Asset_A Asset Acct
	 */
	public void setA_Asset_A(I_C_ValidCombinationInput A_Asset_A) {
		this.A_Asset_A = A_Asset_A;
		MAccount foreignEntity;
		if (A_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Acct(0);
		}
	}

	/**
	 * Get Asset Acct.
	 *
	 * @return Asset Acct
	 */
	public I_C_ValidCombinationInput getA_Asset_A() {
		return A_Asset_A;
	}

	/**
	 * Set Asset Addition.
	 *
	 * @param A_Asset_Addition Asset Addition
	 */
	public void setA_Asset_Addition(I_A_Asset_AdditionInput A_Asset_Addition) {
		this.A_Asset_Addition = A_Asset_Addition;
		MAssetAddition foreignEntity;
		if (get_ID() == 0 &&A_Asset_Addition != null &&
				(foreignEntity = new Query(getCtx(), MAssetAddition.Table_Name, MAssetAddition.COLUMNNAME_A_Asset_Addition_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Addition.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Addition_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset Addition.
	 *
	 * @return Asset Addition
	 */
	public I_A_Asset_AdditionInput getA_Asset_Addition() {
		return A_Asset_Addition;
	}
	/**
	 * Set Asset Addition.
	 *
	 * @param A_Asset_Addition_ID Asset Addition
	 */

	public void setA_Asset_Addition_ID(int A_Asset_Addition_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Addition_ID(A_Asset_Addition_ID);
		}
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
	public void setA_Asset(I_A_AssetInput A_Asset) {
		this.A_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 &&A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public I_A_AssetInput getA_Asset() {
		return A_Asset;
	}
	/**
	 * Set Asset.
	 *
	 * @param A_Asset_ID Asset used internally or by customers
	 */

	public void setA_Asset_ID(int A_Asset_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_ID(A_Asset_ID);
		}
	}

	/**
	 * Set Asset Retirement.
	 *
	 * @param A_Asset_Retirement Internally used asset is not longer used.
	 */
	public void setA_Asset_Retirement(I_A_Asset_RetirementInput A_Asset_Retirement) {
		this.A_Asset_Retirement = A_Asset_Retirement;
		X_A_Asset_Retirement foreignEntity;
		if (get_ID() == 0 &&A_Asset_Retirement != null &&
				(foreignEntity = new Query(getCtx(), X_A_Asset_Retirement.Table_Name, X_A_Asset_Retirement.COLUMNNAME_A_Asset_Retirement_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Retirement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Retirement_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset Retirement.
	 *
	 * @return Internally used asset is not longer used.
	 */
	public I_A_Asset_RetirementInput getA_Asset_Retirement() {
		return A_Asset_Retirement;
	}
	/**
	 * Set Asset Retirement.
	 *
	 * @param A_Asset_Retirement_ID Internally used asset is not longer used.
	 */

	public void setA_Asset_Retirement_ID(int A_Asset_Retirement_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Retirement_ID(A_Asset_Retirement_ID);
		}
	}

	/**
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	public void setA_Depreciation_A(I_C_ValidCombinationInput A_Depreciation_A) {
		this.A_Depreciation_A = A_Depreciation_A;
		MAccount foreignEntity;
		if (A_Depreciation_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Acct(0);
		}
	}

	/**
	 * Get Depreciation Account.
	 *
	 * @return Depreciation Account
	 */
	public I_C_ValidCombinationInput getA_Depreciation_A() {
		return A_Depreciation_A;
	}

	/**
	 * Set A_Depreciation_Manual_Period.
	 *
	 * @param A_Depreciation_Manual_Period_RL A_Depreciation_Manual_Period
	 */
	public void setA_Depreciation_Manual_Period_RL(I_AD_Ref_ListInput A_Depreciation_Manual_Period_RL) {
		this.A_Depreciation_Manual_Period_RL = A_Depreciation_Manual_Period_RL;
		MRefList foreignEntity;
		if (A_Depreciation_Manual_Period_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Manual_Period_RL.getID())
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
	public I_AD_Ref_ListInput getA_Depreciation_Manual_Period_RL() {
		return A_Depreciation_Manual_Period_RL;
	}

	/**
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header A_Depreciation_Table_Header_ID
	 */
	public void setA_Depreciation_Table_Header(I_A_Depreciation_Table_HeaderInput A_Depreciation_Table_Header) {
		this.A_Depreciation_Table_Header = A_Depreciation_Table_Header;
		X_A_Depreciation_Table_Header foreignEntity;
		if (A_Depreciation_Table_Header != null &&
				(foreignEntity = new Query(getCtx(), X_A_Depreciation_Table_Header.Table_Name, X_A_Depreciation_Table_Header.COLUMNNAME_A_Depreciation_Table_Header_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Table_Header.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Table_Header_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Table_Header_ID(0);
		}
	}

	/**
	 * Get A_Depreciation_Table_Header_ID.
	 *
	 * @return A_Depreciation_Table_Header_ID
	 */
	public I_A_Depreciation_Table_HeaderInput getA_Depreciation_Table_Header() {
		return A_Depreciation_Table_Header;
	}
	/**
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header_ID A_Depreciation_Table_Header_ID
	 */

	public void setA_Depreciation_Table_Header_ID(int A_Depreciation_Table_Header_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Table_Header_ID(A_Depreciation_Table_Header_ID);
		}
	}

	/**
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_A Disposal Loss Acct
	 */
	public void setA_Disposal_Loss_A(I_C_ValidCombinationInput A_Disposal_Loss_A) {
		this.A_Disposal_Loss_A = A_Disposal_Loss_A;
		MAccount foreignEntity;
		if (A_Disposal_Loss_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Loss_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Loss_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Disposal_Loss_Acct(0);
		}
	}

	/**
	 * Get Disposal Loss Acct.
	 *
	 * @return Disposal Loss Acct
	 */
	public I_C_ValidCombinationInput getA_Disposal_Loss_A() {
		return A_Disposal_Loss_A;
	}

	/**
	 * Set Disposal Revenue Acct.
	 *
	 * @param A_Disposal_Revenue_A Disposal Revenue Acct
	 */
	public void setA_Disposal_Revenue_A(I_C_ValidCombinationInput A_Disposal_Revenue_A) {
		this.A_Disposal_Revenue_A = A_Disposal_Revenue_A;
		MAccount foreignEntity;
		if (A_Disposal_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Revenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Revenue_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Disposal_Revenue_Acct(0);
		}
	}

	/**
	 * Get Disposal Revenue Acct.
	 *
	 * @return Disposal Revenue Acct
	 */
	public I_C_ValidCombinationInput getA_Disposal_Revenue_A() {
		return A_Disposal_Revenue_A;
	}

	/**
	 * Set Parent Asset.
	 *
	 * @param A_Parent_Asset Parent Asset
	 */
	public void setA_Parent_Asset(I_A_AssetInput A_Parent_Asset) {
		this.A_Parent_Asset = A_Parent_Asset;
		MAsset foreignEntity;
		if (A_Parent_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Parent_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Parent_Asset_ID(foreignEntity.get_ID());
		} else {
			this.setA_Parent_Asset_ID(0);
		}
	}

	/**
	 * Get Parent Asset.
	 *
	 * @return Parent Asset
	 */
	public I_A_AssetInput getA_Parent_Asset() {
		return A_Parent_Asset;
	}
	/**
	 * Set Parent Asset.
	 *
	 * @param A_Parent_Asset_ID Parent Asset
	 */

	public void setA_Parent_Asset_ID(int A_Parent_Asset_ID) {
		if (get_ID() == 0) {
			super.setA_Parent_Asset_ID(A_Parent_Asset_ID);
		}
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
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}
	/**
	 * Set User/Contact.
	 *
	 * @param AD_User_ID User within the system - Internal or Business Partner Contact
	 */

	public void setAD_User_ID(int AD_User_ID) {
		if (get_ID() == 0) {
			super.setAD_User_ID(AD_User_ID);
		}
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	public void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.C_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public I_C_BPartner_LocationInput getC_BPartner_Location() {
		return C_BPartner_Location;
	}
	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location_ID Identifies the (ship to) address for this Business Partner
	 */

	public void setC_BPartner_Location_ID(int C_BPartner_Location_ID) {
		if (get_ID() == 0) {
			super.setC_BPartner_Location_ID(C_BPartner_Location_ID);
		}
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	public void setC_Location(I_C_LocationInput C_Location) {
		this.C_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public I_C_LocationInput getC_Location() {
		return C_Location;
	}

	/**
	 * Set Combination.
	 *
	 * @param C_ValidCombination Valid Account Combination
	 */
	public void setC_ValidCombination(I_C_ValidCombinationInput C_ValidCombination) {
		this.C_ValidCombination = C_ValidCombination;
		MAccount foreignEntity;
		if (C_ValidCombination != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(C_ValidCombination.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ValidCombination_ID(foreignEntity.get_ID());
		} else {
			this.setC_ValidCombination_ID(0);
		}
	}

	/**
	 * Get Combination.
	 *
	 * @return Valid Account Combination
	 */
	public I_C_ValidCombinationInput getC_ValidCombination() {
		return C_ValidCombination;
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
	 * @param ChangeType_RL ChangeType
	 */
	public void setChangeType_RL(I_AD_Ref_ListInput ChangeType_RL) {
		this.ChangeType_RL = ChangeType_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&ChangeType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ChangeType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setChangeType(foreignEntity.getValue());
		}
	}

	/**
	 * Get ChangeType.
	 *
	 * @return ChangeType
	 */
	public I_AD_Ref_ListInput getChangeType_RL() {
		return ChangeType_RL;
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
