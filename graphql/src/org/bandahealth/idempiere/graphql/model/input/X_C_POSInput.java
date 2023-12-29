package org.bandahealth.idempiere.graphql.model.input;

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
import org.compiere.util.Env;

/**
 * Generated Model for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSInput extends MPOS implements I_C_POSInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_UserInput SalesRep;
	 private I_C_BPartnerInput C_BPartnerCashTrx;
	 private I_C_BankAccountInput C_BankAccount;
	 private I_C_CashBookInput C_CashBook;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_POSKeyLayoutInput C_POSKeyLayout;
	 private I_C_POSKeyLayoutInput OSK_KeyLayout;
	 private I_C_POSKeyLayoutInput OSNP_KeyLayout;
	 private I_M_PriceListInput M_PriceList;
	 private I_M_WarehouseInput M_Warehouse;

	/**
	 * Standard constructor
	 */
	public X_C_POSInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set Template B.Partner.
	 *
	 * @param C_BPartnerCashTrx Business Partner used for creating new Business Partners on the fly
	 */
	public void setC_BPartnerCashTrx(I_C_BPartnerInput C_BPartnerCashTrx) {
		this.C_BPartnerCashTrx = C_BPartnerCashTrx;
		MBPartner_BH foreignEntity;
		if (C_BPartnerCashTrx != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartnerCashTrx.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartnerCashTrx_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartnerCashTrx_ID(0);
		}
	}

	/**
	 * Get Template B.Partner.
	 *
	 * @return Business Partner used for creating new Business Partners on the fly
	 */
	public I_C_BPartnerInput getC_BPartnerCashTrx() {
		return C_BPartnerCashTrx;
	}

	/**
	 * Set Cash Book.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	public void setC_CashBook(I_C_CashBookInput C_CashBook) {
		this.C_CashBook = C_CashBook;
		MCashBook foreignEntity;
		if (C_CashBook != null &&
				(foreignEntity = new Query(getCtx(), MCashBook.Table_Name, MCashBook.COLUMNNAME_C_CashBook_UU + "=?", get_TrxName())
						.setParameters(C_CashBook.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_CashBook_ID(foreignEntity.get_ID());
		} else {
			this.setC_CashBook_ID(0);
		}
	}

	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	public I_C_CashBookInput getC_CashBook() {
		return C_CashBook;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	public void setC_DocType(I_C_DocTypeInput C_DocType) {
		this.C_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public I_C_DocTypeInput getC_DocType() {
		return C_DocType;
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
	public void setC_POSKeyLayout(I_C_POSKeyLayoutInput C_POSKeyLayout) {
		this.C_POSKeyLayout = C_POSKeyLayout;
		MPOSKeyLayout foreignEntity;
		if (C_POSKeyLayout != null &&
				(foreignEntity = new Query(getCtx(), MPOSKeyLayout.Table_Name, MPOSKeyLayout.COLUMNNAME_C_POSKeyLayout_UU + "=?", get_TrxName())
						.setParameters(C_POSKeyLayout.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_POSKeyLayout_ID(foreignEntity.get_ID());
		} else {
			this.setC_POSKeyLayout_ID(0);
		}
	}

	/**
	 * Get POS Key Layout.
	 *
	 * @return POS Function Key Layout
	 */
	public I_C_POSKeyLayoutInput getC_POSKeyLayout() {
		return C_POSKeyLayout;
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	public void setM_PriceList(I_M_PriceListInput M_PriceList) {
		this.M_PriceList = M_PriceList;
		MPriceList foreignEntity;
		if (M_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(M_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_PriceList_ID(foreignEntity.get_ID());
		} else {
			this.setM_PriceList_ID(0);
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public I_M_PriceListInput getM_PriceList() {
		return M_PriceList;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	public void setM_Warehouse(I_M_WarehouseInput M_Warehouse) {
		this.M_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public I_M_WarehouseInput getM_Warehouse() {
		return M_Warehouse;
	}

	/**
	 * Set On Screen Keyboard layout.
	 *
	 * @param OSK_KeyLayout The key layout to use for on screen keyboard for text fields.
	 */
	public void setOSK_KeyLayout(I_C_POSKeyLayoutInput OSK_KeyLayout) {
		this.OSK_KeyLayout = OSK_KeyLayout;
		MPOSKeyLayout foreignEntity;
		if (OSK_KeyLayout != null &&
				(foreignEntity = new Query(getCtx(), MPOSKeyLayout.Table_Name, MPOSKeyLayout.COLUMNNAME_C_POSKeyLayout_UU + "=?", get_TrxName())
						.setParameters(OSK_KeyLayout.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOSK_KeyLayout_ID(foreignEntity.get_ID());
		} else {
			this.setOSK_KeyLayout_ID(0);
		}
	}

	/**
	 * Get On Screen Keyboard layout.
	 *
	 * @return The key layout to use for on screen keyboard for text fields.
	 */
	public I_C_POSKeyLayoutInput getOSK_KeyLayout() {
		return OSK_KeyLayout;
	}

	/**
	 * Set On Screen Number Pad layout.
	 *
	 * @param OSNP_KeyLayout The key layout to use for on screen number pad for numeric fields.
	 */
	public void setOSNP_KeyLayout(I_C_POSKeyLayoutInput OSNP_KeyLayout) {
		this.OSNP_KeyLayout = OSNP_KeyLayout;
		MPOSKeyLayout foreignEntity;
		if (OSNP_KeyLayout != null &&
				(foreignEntity = new Query(getCtx(), MPOSKeyLayout.Table_Name, MPOSKeyLayout.COLUMNNAME_C_POSKeyLayout_UU + "=?", get_TrxName())
						.setParameters(OSNP_KeyLayout.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOSNP_KeyLayout_ID(foreignEntity.get_ID());
		} else {
			this.setOSNP_KeyLayout_ID(0);
		}
	}

	/**
	 * Get On Screen Number Pad layout.
	 *
	 * @return The key layout to use for on screen number pad for numeric fields.
	 */
	public I_C_POSKeyLayoutInput getOSNP_KeyLayout() {
		return OSNP_KeyLayout;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	public void setSalesRep(I_AD_UserInput SalesRep) {
		this.SalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			this.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public I_AD_UserInput getSalesRep() {
		return SalesRep;
	}
}
