package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBank;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccountInput extends MBankAccount_BH implements I_C_BankAccountInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mC_Bank;
	 private ForeignEntityInput mC_Currency;
	 private I_AD_Ref_ListInput mBankAccountType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BankAccountInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	 * Set Bank Account Type.
	 *
	 * @param BankAccountType Bank Account Type
	 */
	@JsonProperty("BankAccountType")
	public void setBankAccountTypeInput(I_AD_Ref_ListInput BankAccountType) {
		this.mBankAccountType = BankAccountType;
		MRefList_BH foreignEntity;
		if (BankAccountType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BankAccountType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBankAccountType(foreignEntity.getValue());
		} else {
			this.setBankAccountType(null);
		}
	}

	/**
	 * Get Bank Account Type.
	 *
	 * @return Bank Account Type
	 */
	@JsonProperty("BankAccountType")
	public I_AD_Ref_ListInput BankAccountType() {
		return mBankAccountType;
	}

	/**
	 * Set Bank.
	 *
	 * @param C_Bank Bank
	 */
	@JsonProperty("C_Bank")
	public void setC_BankInput(ForeignEntityInput C_Bank) {
		this.mC_Bank = C_Bank;
		MBank foreignEntity;
		if (get_ID() == 0 &&C_Bank != null &&
				(foreignEntity = new Query(getCtx(), MBank.Table_Name, MBank.COLUMNNAME_C_Bank_UU + "=?", get_TrxName())
						.setParameters(C_Bank.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Bank_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Bank.
	 *
	 * @return Bank
	 */
	@JsonProperty("C_Bank")
	public ForeignEntityInput C_Bank() {
		return mC_Bank;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BankAccount_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BankAccount_UU();
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
				(foreignEntity = new Query(getCtx(), MCurrency_BH.Table_Name, MCurrency_BH.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
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
}
