package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElement;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_ElementValue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_ElementValueInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Account Sign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public void setAccountSignInput(I_AD_Ref_ListInput AccountSign) {
		this.mAccountSign = AccountSign;
		if (AccountSign != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccountSign.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccountSign(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AccountSign.getUUID());
			}
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
		if (AccountType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccountType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccountType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AccountType.getUUID());
			}
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
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
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
		if (BPartnerType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BPartnerType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBPartnerType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BPartnerType.getUUID());
			}
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
		if (C_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BankAccount.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + C_BankAccount.getUUID());
			}
		} else {
			this.setC_BankAccount_ID(0);
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
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			this.setC_Currency_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_Element != null) {
			// Since an entity was passed, make sure it's in the DB
			MElement foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Element", "C_Element_UU=?", get_TrxName())
							.setParameters(C_Element.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Element_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Element with UUID " + C_Element.getUUID());
			}
		} else {
			this.setC_Element_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_ElementValue_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_ElementValue_UU();
	}
}
