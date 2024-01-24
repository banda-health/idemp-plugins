package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_PaymentRef_BankAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_PaymentRef_BankAcctInput extends MBHPaymentRefBankAccount implements I_BH_PaymentRef_BankAcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Ref_List;
	private ForeignEntityInput mBH_PaymentRef;
	private ForeignEntityInput mC_BankAccount;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_PaymentRef_BankAcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHPaymentRefBankAccount(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Reference List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List) {
		this.mAD_Ref_List = AD_Ref_List;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 && AD_Ref_List != null &&
				(foreignEntity = new Query(getCtx(), "AD_Ref_List", "AD_Ref_List_UU=?", get_TrxName())
						.setParameters(AD_Ref_List.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Ref_List_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Reference List.
	 *
	 * @return Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public ForeignEntityInput AD_Ref_List() {
		return mAD_Ref_List;
	}
	/**
	 * Set BH_PaymentRef_BankAcct.
	 *
	 * @param BH_PaymentRef_BankAcct_ID BH_PaymentRef_BankAcct
	 */

	public void setBH_PaymentRef_BankAcct_ID(int BH_PaymentRef_BankAcct_ID) {
		if (get_ID() == 0) {
			super.setBH_PaymentRef_BankAcct_ID(BH_PaymentRef_BankAcct_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_PaymentRef_BankAcct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_PaymentRef_BankAcct_UU();
	}

	/**
	 * Set BH_PaymentRef.
	 *
	 * @param BH_PaymentRef BH_PaymentRef
	 */
	@JsonProperty("BH_PaymentRef")
	public void setBH_PaymentRefInput(ForeignEntityInput BH_PaymentRef) {
		this.mBH_PaymentRef = BH_PaymentRef;
		MBHPaymentRef foreignEntity;
		if (get_ID() == 0 && BH_PaymentRef != null &&
				(foreignEntity = new Query(getCtx(), "BH_PaymentRef", "BH_PaymentRef_UU=?", get_TrxName())
						.setParameters(BH_PaymentRef.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_PaymentRef_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get BH_PaymentRef.
	 *
	 * @return BH_PaymentRef
	 */
	@JsonProperty("BH_PaymentRef")
	public ForeignEntityInput BH_PaymentRef() {
		return mBH_PaymentRef;
	}
	/**
	 * Set BH_ReferenceList_IsActive.
	 *
	 * @param BH_ReferenceList_IsActive BH_ReferenceList_IsActive
	 */

	public void setBH_ReferenceList_IsActive(boolean BH_ReferenceList_IsActive) {
		if (get_ID() == 0) {
			super.setBH_ReferenceList_IsActive(BH_ReferenceList_IsActive);
		}
	}

	/**
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	@JsonProperty("C_BankAccount")
	public void setC_BankAccountInput(ForeignEntityInput C_BankAccount) {
		this.mC_BankAccount = C_BankAccount;
		MBankAccount_BH foreignEntity;
		if (C_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
						.setParameters(C_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BankAccount_ID(foreignEntity.get_ID());
		} else {
			super.setC_BankAccount_ID(0);
		}
	}

	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	@JsonProperty("C_BankAccount")
	public ForeignEntityInput C_BankAccount() {
		return mC_BankAccount;
	}
}
