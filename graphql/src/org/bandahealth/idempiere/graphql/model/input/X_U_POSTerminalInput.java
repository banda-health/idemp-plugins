package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCashBook;
import org.compiere.model.MOrg;
import org.compiere.model.MPOSTerminal;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_POSTerminalInput extends MPOSTerminal implements I_U_POSTerminalInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_CashBPartner;
	private ForeignEntityInput mC_CashBook;
	private ForeignEntityInput mC_TemplateBPartner;
	private ForeignEntityInput mCardTransferBankAccount;
	private ForeignEntityInput mCardTransferCashBook;
	private ForeignEntityInput mCard_BankAccount;
	private ForeignEntityInput mCashTransferBankAccount;
	private ForeignEntityInput mCashTransferCashBook;
	private ForeignEntityInput mCheckTransferBankAccount;
	private ForeignEntityInput mCheckTransferCashBook;
	private ForeignEntityInput mCheck_BankAccount;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mPO_PriceList;
	private ForeignEntityInput mSO_PriceList;
	private ForeignEntityInput mSalesRep;
	private I_AD_Ref_ListInput mCardTransferType;
	private I_AD_Ref_ListInput mCashBookTransferType;
	private I_AD_Ref_ListInput mCheckTransferType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The U_POSTerminal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_U_POSTerminalInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Cash Book.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public void setC_CashBookInput(ForeignEntityInput C_CashBook) {
		this.mC_CashBook = C_CashBook;
		if (C_CashBook != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashBook foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
							.setParameters(C_CashBook.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_CashBook_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashBook with UUID " + C_CashBook.getUUID());
			}
		} else {
			this.setC_CashBook_ID(0);
		}
	}

	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public ForeignEntityInput C_CashBook() {
		return mC_CashBook;
	}

	/**
	 * Set Cash BPartner.
	 *
	 * @param C_CashBPartner BPartner to be used for Cash transactions
	 */
	@JsonProperty("C_CashBPartner")
	public void setC_CashBPartnerInput(ForeignEntityInput C_CashBPartner) {
		this.mC_CashBPartner = C_CashBPartner;
		if (C_CashBPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_CashBPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_CashBPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_CashBPartner.getUUID());
			}
		} else {
			this.setC_CashBPartner_ID(0);
		}
	}

	/**
	 * Get Cash BPartner.
	 *
	 * @return BPartner to be used for Cash transactions
	 */
	@JsonProperty("C_CashBPartner")
	public ForeignEntityInput C_CashBPartner() {
		return mC_CashBPartner;
	}

	/**
	 * Set Template BPartner.
	 *
	 * @param C_TemplateBPartner BPartner that is to be used as template when new customers are created
	 */
	@JsonProperty("C_TemplateBPartner")
	public void setC_TemplateBPartnerInput(ForeignEntityInput C_TemplateBPartner) {
		this.mC_TemplateBPartner = C_TemplateBPartner;
		if (C_TemplateBPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_TemplateBPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_TemplateBPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_TemplateBPartner.getUUID());
			}
		} else {
			this.setC_TemplateBPartner_ID(0);
		}
	}

	/**
	 * Get Template BPartner.
	 *
	 * @return BPartner that is to be used as template when new customers are created
	 */
	@JsonProperty("C_TemplateBPartner")
	public ForeignEntityInput C_TemplateBPartner() {
		return mC_TemplateBPartner;
	}

	/**
	 * Set Card Bank Account.
	 *
	 * @param Card_BankAccount Bank Account on which card transactions will be processed
	 */
	@JsonProperty("Card_BankAccount")
	public void setCard_BankAccountInput(ForeignEntityInput Card_BankAccount) {
		this.mCard_BankAccount = Card_BankAccount;
		if (Card_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(Card_BankAccount.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCard_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + Card_BankAccount.getUUID());
			}
		} else {
			this.setCard_BankAccount_ID(0);
		}
	}

	/**
	 * Get Card Bank Account.
	 *
	 * @return Bank Account on which card transactions will be processed
	 */
	@JsonProperty("Card_BankAccount")
	public ForeignEntityInput Card_BankAccount() {
		return mCard_BankAccount;
	}

	/**
	 * Set Transfer Card trx to.
	 *
	 * @param CardTransferBankAccount Bank account on which to transfer Card transactions
	 */
	@JsonProperty("CardTransferBankAccount")
	public void setCardTransferBankAccountInput(ForeignEntityInput CardTransferBankAccount) {
		this.mCardTransferBankAccount = CardTransferBankAccount;
		if (CardTransferBankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(CardTransferBankAccount.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCardTransferBankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + CardTransferBankAccount.getUUID());
			}
		} else {
			this.setCardTransferBankAccount_ID(0);
		}
	}

	/**
	 * Get Transfer Card trx to.
	 *
	 * @return Bank account on which to transfer Card transactions
	 */
	@JsonProperty("CardTransferBankAccount")
	public ForeignEntityInput CardTransferBankAccount() {
		return mCardTransferBankAccount;
	}

	/**
	 * Set Transfer Card trx to.
	 *
	 * @param CardTransferCashBook Cash Book on which to transfer all Card transactions
	 */
	@JsonProperty("CardTransferCashBook")
	public void setCardTransferCashBookInput(ForeignEntityInput CardTransferCashBook) {
		this.mCardTransferCashBook = CardTransferCashBook;
		if (CardTransferCashBook != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashBook foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
							.setParameters(CardTransferCashBook.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCardTransferCashBook_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashBook with UUID " + CardTransferCashBook.getUUID());
			}
		} else {
			this.setCardTransferCashBook_ID(0);
		}
	}

	/**
	 * Get Transfer Card trx to.
	 *
	 * @return Cash Book on which to transfer all Card transactions
	 */
	@JsonProperty("CardTransferCashBook")
	public ForeignEntityInput CardTransferCashBook() {
		return mCardTransferCashBook;
	}

	/**
	 * Set Card Transfer Type.
	 *
	 * @param CardTransferType Card Transfer Type
	 */
	@JsonProperty("CardTransferType")
	public void setCardTransferTypeInput(I_AD_Ref_ListInput CardTransferType) {
		this.mCardTransferType = CardTransferType;
		if (CardTransferType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CardTransferType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCardTransferType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CardTransferType.getUUID());
			}
		} else {
			this.setCardTransferType(null);
		}
	}

	/**
	 * Get Card Transfer Type.
	 *
	 * @return Card Transfer Type
	 */
	@JsonProperty("CardTransferType")
	public I_AD_Ref_ListInput CardTransferType() {
		return mCardTransferType;
	}

	/**
	 * Set Cash Book Transfer Type.
	 *
	 * @param CashBookTransferType Where the money in the cash book should be transfered to. Either a Bank Account or another Cash Book
	 */
	@JsonProperty("CashBookTransferType")
	public void setCashBookTransferTypeInput(I_AD_Ref_ListInput CashBookTransferType) {
		this.mCashBookTransferType = CashBookTransferType;
		if (CashBookTransferType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CashBookTransferType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCashBookTransferType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CashBookTransferType.getUUID());
			}
		} else {
			this.setCashBookTransferType(null);
		}
	}

	/**
	 * Get Cash Book Transfer Type.
	 *
	 * @return Where the money in the cash book should be transfered to. Either a Bank Account or another Cash Book
	 */
	@JsonProperty("CashBookTransferType")
	public I_AD_Ref_ListInput CashBookTransferType() {
		return mCashBookTransferType;
	}

	/**
	 * Set Transfer Cash trx to.
	 *
	 * @param CashTransferBankAccount Bank Account on which to transfer all Cash transactions
	 */
	@JsonProperty("CashTransferBankAccount")
	public void setCashTransferBankAccountInput(ForeignEntityInput CashTransferBankAccount) {
		this.mCashTransferBankAccount = CashTransferBankAccount;
		if (CashTransferBankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(CashTransferBankAccount.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCashTransferBankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + CashTransferBankAccount.getUUID());
			}
		} else {
			this.setCashTransferBankAccount_ID(0);
		}
	}

	/**
	 * Get Transfer Cash trx to.
	 *
	 * @return Bank Account on which to transfer all Cash transactions
	 */
	@JsonProperty("CashTransferBankAccount")
	public ForeignEntityInput CashTransferBankAccount() {
		return mCashTransferBankAccount;
	}

	/**
	 * Set Transfer Cash trx to.
	 *
	 * @param CashTransferCashBook Cash Book on which to transfer all Cash transactions
	 */
	@JsonProperty("CashTransferCashBook")
	public void setCashTransferCashBookInput(ForeignEntityInput CashTransferCashBook) {
		this.mCashTransferCashBook = CashTransferCashBook;
		if (CashTransferCashBook != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashBook foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
							.setParameters(CashTransferCashBook.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCashTransferCashBook_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashBook with UUID " + CashTransferCashBook.getUUID());
			}
		} else {
			this.setCashTransferCashBook_ID(0);
		}
	}

	/**
	 * Get Transfer Cash trx to.
	 *
	 * @return Cash Book on which to transfer all Cash transactions
	 */
	@JsonProperty("CashTransferCashBook")
	public ForeignEntityInput CashTransferCashBook() {
		return mCashTransferCashBook;
	}

	/**
	 * Set Check Bank Account.
	 *
	 * @param Check_BankAccount Bank Account to be used for processing Check transactions
	 */
	@JsonProperty("Check_BankAccount")
	public void setCheck_BankAccountInput(ForeignEntityInput Check_BankAccount) {
		this.mCheck_BankAccount = Check_BankAccount;
		if (Check_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(Check_BankAccount.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCheck_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + Check_BankAccount.getUUID());
			}
		} else {
			this.setCheck_BankAccount_ID(0);
		}
	}

	/**
	 * Get Check Bank Account.
	 *
	 * @return Bank Account to be used for processing Check transactions
	 */
	@JsonProperty("Check_BankAccount")
	public ForeignEntityInput Check_BankAccount() {
		return mCheck_BankAccount;
	}

	/**
	 * Set Tranfer Check trx to.
	 *
	 * @param CheckTransferBankAccount Bank account on which to transfer Check transactions
	 */
	@JsonProperty("CheckTransferBankAccount")
	public void setCheckTransferBankAccountInput(ForeignEntityInput CheckTransferBankAccount) {
		this.mCheckTransferBankAccount = CheckTransferBankAccount;
		if (CheckTransferBankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(CheckTransferBankAccount.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCheckTransferBankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + CheckTransferBankAccount.getUUID());
			}
		} else {
			this.setCheckTransferBankAccount_ID(0);
		}
	}

	/**
	 * Get Tranfer Check trx to.
	 *
	 * @return Bank account on which to transfer Check transactions
	 */
	@JsonProperty("CheckTransferBankAccount")
	public ForeignEntityInput CheckTransferBankAccount() {
		return mCheckTransferBankAccount;
	}

	/**
	 * Set Transfer Check trx to.
	 *
	 * @param CheckTransferCashBook Cash Book on which to transfer all Check transactions
	 */
	@JsonProperty("CheckTransferCashBook")
	public void setCheckTransferCashBookInput(ForeignEntityInput CheckTransferCashBook) {
		this.mCheckTransferCashBook = CheckTransferCashBook;
		if (CheckTransferCashBook != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashBook foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
							.setParameters(CheckTransferCashBook.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCheckTransferCashBook_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashBook with UUID " + CheckTransferCashBook.getUUID());
			}
		} else {
			this.setCheckTransferCashBook_ID(0);
		}
	}

	/**
	 * Get Transfer Check trx to.
	 *
	 * @return Cash Book on which to transfer all Check transactions
	 */
	@JsonProperty("CheckTransferCashBook")
	public ForeignEntityInput CheckTransferCashBook() {
		return mCheckTransferCashBook;
	}

	/**
	 * Set Check Transfer Type.
	 *
	 * @param CheckTransferType Check Transfer Type
	 */
	@JsonProperty("CheckTransferType")
	public void setCheckTransferTypeInput(I_AD_Ref_ListInput CheckTransferType) {
		this.mCheckTransferType = CheckTransferType;
		if (CheckTransferType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CheckTransferType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCheckTransferType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CheckTransferType.getUUID());
			}
		} else {
			this.setCheckTransferType(null);
		}
	}

	/**
	 * Get Check Transfer Type.
	 *
	 * @return Check Transfer Type
	 */
	@JsonProperty("CheckTransferType")
	public I_AD_Ref_ListInput CheckTransferType() {
		return mCheckTransferType;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_Warehouse.getUUID());
			}
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}

	/**
	 * Set Purchase Pricelist.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	@JsonProperty("PO_PriceList")
	public void setPO_PriceListInput(ForeignEntityInput PO_PriceList) {
		this.mPO_PriceList = PO_PriceList;
		if (PO_PriceList != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(PO_PriceList.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPO_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UUID " + PO_PriceList.getUUID());
			}
		} else {
			this.setPO_PriceList_ID(0);
		}
	}

	/**
	 * Get Purchase Pricelist.
	 *
	 * @return Price List used by this Business Partner
	 */
	@JsonProperty("PO_PriceList")
	public ForeignEntityInput PO_PriceList() {
		return mPO_PriceList;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		if (SalesRep != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
		} else {
			this.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public ForeignEntityInput SalesRep() {
		return mSalesRep;
	}

	/**
	 * Set Sales Pricelist.
	 *
	 * @param SO_PriceList Sales Pricelist
	 */
	@JsonProperty("SO_PriceList")
	public void setSO_PriceListInput(ForeignEntityInput SO_PriceList) {
		this.mSO_PriceList = SO_PriceList;
		if (SO_PriceList != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(SO_PriceList.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSO_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UUID " + SO_PriceList.getUUID());
			}
		} else {
			this.setSO_PriceList_ID(0);
		}
	}

	/**
	 * Get Sales Pricelist.
	 *
	 * @return Sales Pricelist
	 */
	@JsonProperty("SO_PriceList")
	public ForeignEntityInput SO_PriceList() {
		return mSO_PriceList;
	}
	/**
	 * Set POS Terminal.
	 *
	 * @param U_POSTerminal_ID POS Terminal
	 */

	public void setU_POSTerminal_ID(int U_POSTerminal_ID) {
		if (get_ID() == 0) {
			super.setU_POSTerminal_ID(U_POSTerminal_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setU_POSTerminal_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getU_POSTerminal_UU();
	}
}
