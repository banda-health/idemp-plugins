package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_PaymentRef_BankAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_PaymentRef_BankAcctInput extends MBHPaymentRefBankAccount implements I_BH_PaymentRef_BankAcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Ref_List;
	private ForeignEntityInput mBH_PaymentRef;
	private ForeignEntityInput mC_BankAccount;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_PaymentRef_BankAcct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_PaymentRef_BankAcctInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Reference List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List) {
		this.mAD_Ref_List = AD_Ref_List;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Ref_List != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Ref_List", "AD_Ref_List_UU=?", get_TrxName())
							.setParameters(AD_Ref_List.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Ref_List_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Ref_List with UUID " + AD_Ref_List.getUUID());
			}
		} else {
			this.setAD_Ref_List_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_PaymentRef_BankAcct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (BH_PaymentRef != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHPaymentRef foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_PaymentRef", "BH_PaymentRef_UU=?", get_TrxName())
							.setParameters(BH_PaymentRef.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_PaymentRef_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_PaymentRef with UUID " + BH_PaymentRef.getUUID());
			}
		} else {
			this.setBH_PaymentRef_ID(0);
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
}
