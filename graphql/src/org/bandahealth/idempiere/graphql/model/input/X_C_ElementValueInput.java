package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MElement;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_ElementValue;
import org.compiere.util.Env;

/**
 * Generated Model for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ElementValueInput extends X_C_ElementValue implements I_C_ElementValueInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput AccountSign_RL;
	 private I_AD_Ref_ListInput AccountType_RL;
	 private I_AD_Ref_ListInput BPartnerType_RL;
	 private I_C_BankAccountInput C_BankAccount;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_ElementInput C_Element;

	/**
	 * Standard constructor
	 */
	public X_C_ElementValueInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Account Sign.
	 *
	 * @param AccountSign_RL Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	public void setAccountSign_RL(I_AD_Ref_ListInput AccountSign_RL) {
		this.AccountSign_RL = AccountSign_RL;
		MRefList foreignEntity;
		if (AccountSign_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccountSign_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccountSign(foreignEntity.getValue());
		} else {
			this.setAccountSign(null);
		}
	}

	/**
	 * Get Account Sign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	public I_AD_Ref_ListInput getAccountSign_RL() {
		return AccountSign_RL;
	}

	/**
	 * Set Account Type.
	 *
	 * @param AccountType_RL Indicates the type of account
	 */
	public void setAccountType_RL(I_AD_Ref_ListInput AccountType_RL) {
		this.AccountType_RL = AccountType_RL;
		MRefList foreignEntity;
		if (AccountType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccountType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccountType(foreignEntity.getValue());
		} else {
			this.setAccountType(null);
		}
	}

	/**
	 * Get Account Type.
	 *
	 * @return Indicates the type of account
	 */
	public I_AD_Ref_ListInput getAccountType_RL() {
		return AccountType_RL;
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
	 * Set Business Partner Type.
	 *
	 * @param BPartnerType_RL Business Partner Type
	 */
	public void setBPartnerType_RL(I_AD_Ref_ListInput BPartnerType_RL) {
		this.BPartnerType_RL = BPartnerType_RL;
		MRefList foreignEntity;
		if (BPartnerType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BPartnerType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBPartnerType(foreignEntity.getValue());
		} else {
			this.setBPartnerType(null);
		}
	}

	/**
	 * Get Business Partner Type.
	 *
	 * @return Business Partner Type
	 */
	public I_AD_Ref_ListInput getBPartnerType_RL() {
		return BPartnerType_RL;
	}

	/**
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	public void setC_BankAccount(I_C_BankAccountInput C_BankAccount) {
		this.C_BankAccount = C_BankAccount;
		MBankAccount_BH foreignEntity;
		if (C_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), MBankAccount_BH.Table_Name, MBankAccount_BH.COLUMNNAME_C_BankAccount_UU + "=?", get_TrxName())
						.setParameters(C_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BankAccount_ID(foreignEntity.get_ID());
		} else {
			this.setC_BankAccount_ID(0);
		}
	}

	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public I_C_BankAccountInput getC_BankAccount() {
		return C_BankAccount;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}

	/**
	 * Set Element.
	 *
	 * @param C_Element Accounting Element
	 */
	public void setC_Element(I_C_ElementInput C_Element) {
		this.C_Element = C_Element;
		MElement foreignEntity;
		if (get_ID() == 0 &&C_Element != null &&
				(foreignEntity = new Query(getCtx(), MElement.Table_Name, MElement.COLUMNNAME_C_Element_UU + "=?", get_TrxName())
						.setParameters(C_Element.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Element_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Element.
	 *
	 * @return Accounting Element
	 */
	public I_C_ElementInput getC_Element() {
		return C_Element;
	}
	/**
	 * Set Element.
	 *
	 * @param C_Element_ID Accounting Element
	 */

	public void setC_Element_ID(int C_Element_ID) {
		if (get_ID() == 0) {
			super.setC_Element_ID(C_Element_ID);
		}
	}
	/**
	 * Set Account Element.
	 *
	 * @param C_ElementValue_ID Account Element
	 */

	public void setC_ElementValue_ID(int C_ElementValue_ID) {
		if (get_ID() == 0) {
			super.setC_ElementValue_ID(C_ElementValue_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ElementValue_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ElementValue_UU();
	}
}
