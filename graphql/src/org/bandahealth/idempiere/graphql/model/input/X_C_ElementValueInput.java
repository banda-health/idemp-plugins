package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElement;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ElementValueInput extends MElementValue implements I_C_ElementValueInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BankAccount;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Element;
	private I_AD_Ref_ListInput mAccountSign;
	private I_AD_Ref_ListInput mAccountType;
	private I_AD_Ref_ListInput mBPartnerType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ElementValueInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MElementValue(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Account Sign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public void setAccountSignInput(I_AD_Ref_ListInput AccountSign) {
		this.mAccountSign = AccountSign;
		MRefList_BH foreignEntity;
		if (AccountSign != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccountSign.getID())
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
	@JsonProperty("AccountSign")
	public I_AD_Ref_ListInput AccountSign() {
		return mAccountSign;
	}

	/**
	 * Set Account Type.
	 *
	 * @param AccountType Indicates the type of account
	 */
	@JsonProperty("AccountType")
	public void setAccountTypeInput(I_AD_Ref_ListInput AccountType) {
		this.mAccountType = AccountType;
		MRefList_BH foreignEntity;
		if (AccountType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccountType.getID())
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
	@JsonProperty("AccountType")
	public I_AD_Ref_ListInput AccountType() {
		return mAccountType;
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
	 * Set Business Partner Type.
	 *
	 * @param BPartnerType Business Partner Type
	 */
	@JsonProperty("BPartnerType")
	public void setBPartnerTypeInput(I_AD_Ref_ListInput BPartnerType) {
		this.mBPartnerType = BPartnerType;
		MRefList_BH foreignEntity;
		if (BPartnerType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BPartnerType.getID())
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
	@JsonProperty("BPartnerType")
	public I_AD_Ref_ListInput BPartnerType() {
		return mBPartnerType;
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

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
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
	 * Set Element.
	 *
	 * @param C_Element Accounting Element
	 */
	@JsonProperty("C_Element")
	public void setC_ElementInput(ForeignEntityInput C_Element) {
		this.mC_Element = C_Element;
		MElement foreignEntity;
		if (get_ID() == 0 && C_Element != null &&
				(foreignEntity = new Query(getCtx(), "C_Element", "C_Element_UU=?", get_TrxName())
						.setParameters(C_Element.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Element_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Element.
	 *
	 * @return Accounting Element
	 */
	@JsonProperty("C_Element")
	public ForeignEntityInput C_Element() {
		return mC_Element;
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
