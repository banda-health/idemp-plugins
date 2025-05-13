package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_BankTransferResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBankTransfer;
import org.compiere.model.MConversionType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BankTransfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BankTransferInput extends MBankTransfer implements I_C_BankTransferInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mDocAction;
	private ForeignEntityInput mDocStatus;
	private ForeignEntityInput mFrom_C_BPartner;
	private ForeignEntityInput mFrom_C_BankAccount;
	private ForeignEntityInput mFrom_C_Charge;
	private ForeignEntityInput mFrom_C_Currency;
	private ForeignEntityInput mFrom_TenderType;
	private ForeignEntityInput mTo_C_BPartner;
	private ForeignEntityInput mTo_C_BankAccount;
	private ForeignEntityInput mTo_C_Charge;
	private ForeignEntityInput mTo_C_Currency;
	private ForeignEntityInput mTo_TenderType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_BankTransfer_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BankTransferInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
	 * Set Bank Transfer.
	 *
	 * @param C_BankTransfer_ID Bank Transfer
	 */
	@JsonProperty("C_BankTransfer_ID")
	public void setC_BankTransfer_IDFromJson(int C_BankTransfer_ID) {
		if (get_ID() == 0) {
			super.setC_BankTransfer_ID(C_BankTransfer_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_BankTransfer_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_BankTransfer_UU();
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		if (C_ConversionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MConversionType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UU " + C_ConversionType.getUU());
			}
		} else {
			this.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public ForeignEntityInput C_ConversionType() {
		return mC_ConversionType;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(ForeignEntityInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BankTransferResolver.DOCACTION_UUIDS_BY_VALUE.containsValue(DocAction.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocAction.getUU() +
						" is not in the list defined for the DocAction column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocAction.getUU());
			}
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public ForeignEntityInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(ForeignEntityInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BankTransferResolver.DOCSTATUS_UUIDS_BY_VALUE.containsValue(DocStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocStatus.getUU() +
						" is not in the list defined for the DocStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocStatus.getUU());
			}
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public ForeignEntityInput DocStatus() {
		return mDocStatus;
	}

	/**
	 * Set From Bank Account.
	 *
	 * @param From_C_BankAccount From Bank Account
	 */
	@JsonProperty("From_C_BankAccount")
	public void setFrom_C_BankAccountInput(ForeignEntityInput From_C_BankAccount) {
		this.mFrom_C_BankAccount = From_C_BankAccount;
		if (From_C_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(From_C_BankAccount.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setFrom_C_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UU " + From_C_BankAccount.getUU());
			}
		} else {
			this.setFrom_C_BankAccount_ID(0);
		}
	}

	/**
	 * Get From Bank Account.
	 *
	 * @return From Bank Account
	 */
	@JsonProperty("From_C_BankAccount")
	public ForeignEntityInput From_C_BankAccount() {
		return mFrom_C_BankAccount;
	}

	/**
	 * Set From Business Partner .
	 *
	 * @param From_C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("From_C_BPartner")
	public void setFrom_C_BPartnerInput(ForeignEntityInput From_C_BPartner) {
		this.mFrom_C_BPartner = From_C_BPartner;
		if (From_C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(From_C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setFrom_C_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + From_C_BPartner.getUU());
			}
		} else {
			this.setFrom_C_BPartner_ID(0);
		}
	}

	/**
	 * Get From Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("From_C_BPartner")
	public ForeignEntityInput From_C_BPartner() {
		return mFrom_C_BPartner;
	}

	/**
	 * Set From Charge.
	 *
	 * @param From_C_Charge From Charge
	 */
	@JsonProperty("From_C_Charge")
	public void setFrom_C_ChargeInput(ForeignEntityInput From_C_Charge) {
		this.mFrom_C_Charge = From_C_Charge;
		if (From_C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(From_C_Charge.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setFrom_C_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UU " + From_C_Charge.getUU());
			}
		} else {
			this.setFrom_C_Charge_ID(0);
		}
	}

	/**
	 * Get From Charge.
	 *
	 * @return From Charge
	 */
	@JsonProperty("From_C_Charge")
	public ForeignEntityInput From_C_Charge() {
		return mFrom_C_Charge;
	}

	/**
	 * Set From Bank Currency.
	 *
	 * @param From_C_Currency From Bank Currency
	 */
	@JsonProperty("From_C_Currency")
	public void setFrom_C_CurrencyInput(ForeignEntityInput From_C_Currency) {
		this.mFrom_C_Currency = From_C_Currency;
		if (From_C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(From_C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setFrom_C_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + From_C_Currency.getUU());
			}
		} else {
			this.setFrom_C_Currency_ID(0);
		}
	}

	/**
	 * Get From Bank Currency.
	 *
	 * @return From Bank Currency
	 */
	@JsonProperty("From_C_Currency")
	public ForeignEntityInput From_C_Currency() {
		return mFrom_C_Currency;
	}

	/**
	 * Set From Tender Type.
	 *
	 * @param From_TenderType From Tender Type
	 */
	@JsonProperty("From_TenderType")
	public void setFrom_TenderTypeInput(ForeignEntityInput From_TenderType) {
		this.mFrom_TenderType = From_TenderType;
		if (From_TenderType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BankTransferResolver.FROM_TENDERTYPE_UUIDS_BY_VALUE.containsValue(From_TenderType.getUU())) {
				throw new AdempiereException("The reference list UU of " + From_TenderType.getUU() +
						" is not in the list defined for the From_TenderType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(From_TenderType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFrom_TenderType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + From_TenderType.getUU());
			}
		} else {
			this.setFrom_TenderType(null);
		}
	}

	/**
	 * Get From Tender Type.
	 *
	 * @return From Tender Type
	 */
	@JsonProperty("From_TenderType")
	public ForeignEntityInput From_TenderType() {
		return mFrom_TenderType;
	}

	/**
	 * Set To Bank Account.
	 *
	 * @param To_C_BankAccount To Bank Account
	 */
	@JsonProperty("To_C_BankAccount")
	public void setTo_C_BankAccountInput(ForeignEntityInput To_C_BankAccount) {
		this.mTo_C_BankAccount = To_C_BankAccount;
		if (To_C_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(To_C_BankAccount.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setTo_C_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UU " + To_C_BankAccount.getUU());
			}
		} else {
			this.setTo_C_BankAccount_ID(0);
		}
	}

	/**
	 * Get To Bank Account.
	 *
	 * @return To Bank Account
	 */
	@JsonProperty("To_C_BankAccount")
	public ForeignEntityInput To_C_BankAccount() {
		return mTo_C_BankAccount;
	}

	/**
	 * Set To Business Partner .
	 *
	 * @param To_C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("To_C_BPartner")
	public void setTo_C_BPartnerInput(ForeignEntityInput To_C_BPartner) {
		this.mTo_C_BPartner = To_C_BPartner;
		if (To_C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(To_C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setTo_C_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + To_C_BPartner.getUU());
			}
		} else {
			this.setTo_C_BPartner_ID(0);
		}
	}

	/**
	 * Get To Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("To_C_BPartner")
	public ForeignEntityInput To_C_BPartner() {
		return mTo_C_BPartner;
	}

	/**
	 * Set To Charge.
	 *
	 * @param To_C_Charge To Charge
	 */
	@JsonProperty("To_C_Charge")
	public void setTo_C_ChargeInput(ForeignEntityInput To_C_Charge) {
		this.mTo_C_Charge = To_C_Charge;
		if (To_C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(To_C_Charge.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setTo_C_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UU " + To_C_Charge.getUU());
			}
		} else {
			this.setTo_C_Charge_ID(0);
		}
	}

	/**
	 * Get To Charge.
	 *
	 * @return To Charge
	 */
	@JsonProperty("To_C_Charge")
	public ForeignEntityInput To_C_Charge() {
		return mTo_C_Charge;
	}

	/**
	 * Set To Bank Currency.
	 *
	 * @param To_C_Currency To Bank Currency
	 */
	@JsonProperty("To_C_Currency")
	public void setTo_C_CurrencyInput(ForeignEntityInput To_C_Currency) {
		this.mTo_C_Currency = To_C_Currency;
		if (To_C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(To_C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setTo_C_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + To_C_Currency.getUU());
			}
		} else {
			this.setTo_C_Currency_ID(0);
		}
	}

	/**
	 * Get To Bank Currency.
	 *
	 * @return To Bank Currency
	 */
	@JsonProperty("To_C_Currency")
	public ForeignEntityInput To_C_Currency() {
		return mTo_C_Currency;
	}

	/**
	 * Set To Tender Type.
	 *
	 * @param To_TenderType To Tender Type
	 */
	@JsonProperty("To_TenderType")
	public void setTo_TenderTypeInput(ForeignEntityInput To_TenderType) {
		this.mTo_TenderType = To_TenderType;
		if (To_TenderType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BankTransferResolver.TO_TENDERTYPE_UUIDS_BY_VALUE.containsValue(To_TenderType.getUU())) {
				throw new AdempiereException("The reference list UU of " + To_TenderType.getUU() +
						" is not in the list defined for the To_TenderType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(To_TenderType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTo_TenderType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + To_TenderType.getUU());
			}
		} else {
			this.setTo_TenderType(null);
		}
	}

	/**
	 * Get To Tender Type.
	 *
	 * @return To Tender Type
	 */
	@JsonProperty("To_TenderType")
	public ForeignEntityInput To_TenderType() {
		return mTo_TenderType;
	}
}
