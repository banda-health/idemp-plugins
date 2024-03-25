package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBank;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccountInput extends MBankAccount_BH implements I_C_BankAccountInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Bank;
	private ForeignEntityInput mC_Currency;
	private I_AD_Ref_ListInput mBankAccountType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BankAccount_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BankAccountInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Bank Account Type.
	 *
	 * @param BankAccountType Bank Account Type
	 */
	@JsonProperty("BankAccountType")
	public void setBankAccountTypeInput(I_AD_Ref_ListInput BankAccountType) {
		this.mBankAccountType = BankAccountType;
		if (BankAccountType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BankAccountType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBankAccountType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BankAccountType.getUUID());
			}
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
		if (get_ID() != 0) {
			return;
		}
		if (C_Bank != null) {
			// Since an entity was passed, make sure it's in the DB
			MBank foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Bank", "C_Bank_UU=?", get_TrxName())
							.setParameters(C_Bank.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Bank_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Bank with UUID " + C_Bank.getUUID());
			}
		} else {
			this.setC_Bank_ID(0);
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
	 * Set Bank Account.
	 *
	 * @param C_BankAccount_ID Account at the Bank
	 */

	public void setC_BankAccount_ID(int C_BankAccount_ID) {
		if (get_ID() == 0) {
			super.setC_BankAccount_ID(C_BankAccount_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_BankAccount_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
}
