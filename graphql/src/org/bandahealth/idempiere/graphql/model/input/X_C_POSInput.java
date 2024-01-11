package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCashBook;
import org.compiere.model.MOrg;
import org.compiere.model.MPOS;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSInput extends MPOS implements I_C_POSInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartnerCashTrx;
	private ForeignEntityInput mC_BankAccount;
	private ForeignEntityInput mC_CashBook;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mC_POSKeyLayout;
	private ForeignEntityInput mM_PriceList;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mOSK_KeyLayout;
	private ForeignEntityInput mOSNP_KeyLayout;
	private ForeignEntityInput mSalesRep;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_POSInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPOS(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Template B.Partner.
	 *
	 * @param C_BPartnerCashTrx Business Partner used for creating new Business Partners on the fly
	 */
	@JsonProperty("C_BPartnerCashTrx")
	public void setC_BPartnerCashTrxInput(ForeignEntityInput C_BPartnerCashTrx) {
		this.mC_BPartnerCashTrx = C_BPartnerCashTrx;
		MBPartner_BH foreignEntity;
		if (C_BPartnerCashTrx != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartnerCashTrx.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartnerCashTrx_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartnerCashTrx_ID(0);
		}
	}

	/**
	 * Get Template B.Partner.
	 *
	 * @return Business Partner used for creating new Business Partners on the fly
	 */
	@JsonProperty("C_BPartnerCashTrx")
	public ForeignEntityInput C_BPartnerCashTrx() {
		return mC_BPartnerCashTrx;
	}

	/**
	 * Set Cash Book.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public void setC_CashBookInput(ForeignEntityInput C_CashBook) {
		this.mC_CashBook = C_CashBook;
		MCashBook foreignEntity;
		if (C_CashBook != null &&
				(foreignEntity = new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
						.setParameters(C_CashBook.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CashBook_ID(foreignEntity.get_ID());
		} else {
			super.setC_CashBook_ID(0);
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
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}
	/**
	 * Set POS Terminal.
	 *
	 * @param C_POS_ID Point of Sales Terminal
	 */

	public void setC_POS_ID(int C_POS_ID) {
		if (get_ID() == 0) {
			super.setC_POS_ID(C_POS_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_POS_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_POS_UU();
	}

	/**
	 * Set POS Key Layout.
	 *
	 * @param C_POSKeyLayout POS Function Key Layout
	 */
	@JsonProperty("C_POSKeyLayout")
	public void setC_POSKeyLayoutInput(ForeignEntityInput C_POSKeyLayout) {
		this.mC_POSKeyLayout = C_POSKeyLayout;
		MPOSKeyLayout foreignEntity;
		if (C_POSKeyLayout != null &&
				(foreignEntity = new Query(getCtx(), "C_POSKeyLayout", "C_POSKeyLayout_UU=?", get_TrxName())
						.setParameters(C_POSKeyLayout.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_POSKeyLayout_ID(foreignEntity.get_ID());
		} else {
			super.setC_POSKeyLayout_ID(0);
		}
	}

	/**
	 * Get POS Key Layout.
	 *
	 * @return POS Function Key Layout
	 */
	@JsonProperty("C_POSKeyLayout")
	public ForeignEntityInput C_POSKeyLayout() {
		return mC_POSKeyLayout;
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public void setM_PriceListInput(ForeignEntityInput M_PriceList) {
		this.mM_PriceList = M_PriceList;
		MPriceList foreignEntity;
		if (M_PriceList != null &&
				(foreignEntity = new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
						.setParameters(M_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PriceList_ID(foreignEntity.get_ID());
		} else {
			super.setM_PriceList_ID(0);
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public ForeignEntityInput M_PriceList() {
		return mM_PriceList;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			super.setM_Warehouse_ID(0);
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
	 * Set On Screen Keyboard layout.
	 *
	 * @param OSK_KeyLayout The key layout to use for on screen keyboard for text fields.
	 */
	@JsonProperty("OSK_KeyLayout")
	public void setOSK_KeyLayoutInput(ForeignEntityInput OSK_KeyLayout) {
		this.mOSK_KeyLayout = OSK_KeyLayout;
		MPOSKeyLayout foreignEntity;
		if (OSK_KeyLayout != null &&
				(foreignEntity = new Query(getCtx(), "C_POSKeyLayout", "C_POSKeyLayout_UU=?", get_TrxName())
						.setParameters(OSK_KeyLayout.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOSK_KeyLayout_ID(foreignEntity.get_ID());
		} else {
			super.setOSK_KeyLayout_ID(0);
		}
	}

	/**
	 * Get On Screen Keyboard layout.
	 *
	 * @return The key layout to use for on screen keyboard for text fields.
	 */
	@JsonProperty("OSK_KeyLayout")
	public ForeignEntityInput OSK_KeyLayout() {
		return mOSK_KeyLayout;
	}

	/**
	 * Set On Screen Number Pad layout.
	 *
	 * @param OSNP_KeyLayout The key layout to use for on screen number pad for numeric fields.
	 */
	@JsonProperty("OSNP_KeyLayout")
	public void setOSNP_KeyLayoutInput(ForeignEntityInput OSNP_KeyLayout) {
		this.mOSNP_KeyLayout = OSNP_KeyLayout;
		MPOSKeyLayout foreignEntity;
		if (OSNP_KeyLayout != null &&
				(foreignEntity = new Query(getCtx(), "C_POSKeyLayout", "C_POSKeyLayout_UU=?", get_TrxName())
						.setParameters(OSNP_KeyLayout.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOSNP_KeyLayout_ID(foreignEntity.get_ID());
		} else {
			super.setOSNP_KeyLayout_ID(0);
		}
	}

	/**
	 * Get On Screen Number Pad layout.
	 *
	 * @return The key layout to use for on screen number pad for numeric fields.
	 */
	@JsonProperty("OSNP_KeyLayout")
	public ForeignEntityInput OSNP_KeyLayout() {
		return mOSNP_KeyLayout;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			super.setSalesRep_ID(0);
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
}
