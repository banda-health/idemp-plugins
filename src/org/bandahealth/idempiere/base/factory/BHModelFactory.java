package org.bandahealth.idempiere.base.factory;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.bandahealth.idempiere.base.model.MBHChargeDefault;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroup;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.bandahealth.idempiere.base.model.MUIButton;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.PO;
import org.compiere.util.Env;

public class BHModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return MBPartner_BH.class;
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return MOrder_BH.class;
		} else if (tableName.equalsIgnoreCase(MInvoice_BH.Table_Name)) {
			return MInvoice_BH.class;
		} else if (tableName.equalsIgnoreCase(MPayment_BH.Table_Name)) {
			return MPayment_BH.class;
		} else if (tableName.equalsIgnoreCase(MDashboardButtonGroupButton.Table_Name)) {
			return MDashboardButtonGroupButton.class;
		} else if (tableName.equalsIgnoreCase(MOrderLine_BH.Table_Name)) {
			return MOrderLine_BH.class;
		} else if (tableName.equalsIgnoreCase(MDashboardButtonGroup.Table_Name)) {
			return MDashboardButtonGroup.class;
		} else if (tableName.equalsIgnoreCase(MInventoryLine_BH.Table_Name)) {
			return MInventoryLine_BH.class;
		} else if (tableName.equalsIgnoreCase(MProduct_BH.Table_Name)) {
			return MProduct_BH.class;
		} else if (tableName.equalsIgnoreCase(MTabNavBtn.Table_Name)) {
			return MTabNavBtn.class;
		} else if (tableName.equalsIgnoreCase(MTabNavBtnTab.Table_Name)) {
			return MTabNavBtnTab.class;
		} else if (tableName.equalsIgnoreCase(MUIButton.Table_Name)) {
			return MUIButton.class;
		} else if (tableName.equalsIgnoreCase(MCharge_BH.Table_Name)) {
			return MCharge_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHPaymentRef.Table_Name)) {
			return MBHPaymentRef.class;
		} else if (tableName.equalsIgnoreCase(MBHPaymentRefBankAccount.Table_Name)) {
			return MBHPaymentRefBankAccount.class;
		} else if (tableName.equalsIgnoreCase(MBHChargeDefault.Table_Name)) {
			return MBHChargeDefault.class;
		} else if (tableName.equalsIgnoreCase(MChargeType_BH.Table_Name)) {
			return MChargeType_BH.class;
		} else if (tableName.equalsIgnoreCase(MProductCategory_BH.Table_Name)) {
			return MProductCategory_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHProductCategoryDefault.Table_Name)) {
			return MBHProductCategoryDefault.class;
		} else if (tableName.equalsIgnoreCase(MBHDefaultIncludedRole.Table_Name)) {
			return MBHDefaultIncludedRole.class;
		} else if (tableName.equalsIgnoreCase(MUser_BH.Table_Name)) {
			return MUser_BH.class;
		}

		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return new MBPartner_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return new MOrder_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MInvoice_BH.Table_Name)) {
			return new MInvoice_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MPayment_BH.Table_Name)) {
			return new MPayment_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MDashboardButtonGroupButton.Table_Name)) {
			return new MDashboardButtonGroupButton(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MOrderLine_BH.Table_Name)) {
			return new MOrderLine_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MDashboardButtonGroup.Table_Name)) {
			return new MDashboardButtonGroup(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MInventoryLine_BH.Table_Name)) {
			return new MInventoryLine_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MProduct_BH.Table_Name)) {
			return new MProduct_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MTabNavBtn.Table_Name)) {
			return new MTabNavBtn(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MTabNavBtnTab.Table_Name)) {
			return new MTabNavBtnTab(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MUIButton.Table_Name)) {
			return new MUIButton(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MCharge_BH.Table_Name)) {
			return new MCharge_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPaymentRef.Table_Name)) {
			return new MBHPaymentRef(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPaymentRefBankAccount.Table_Name)) {
			return new MBHPaymentRefBankAccount(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHChargeDefault.Table_Name)) {
			return new MBHChargeDefault(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MChargeType_BH.Table_Name)) {
			return new MChargeType_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MProductCategory_BH.Table_Name)) {
			return new MProductCategory_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHProductCategoryDefault.Table_Name)) {
			return new MBHProductCategoryDefault(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHDefaultIncludedRole.Table_Name)) {
			return new MBHDefaultIncludedRole(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MUser_BH.Table_Name)) {
			return new MUser_BH(Env.getCtx(), Record_ID, trxName);
		}

		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return new MBPartner_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return new MOrder_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MInvoice_BH.Table_Name)) {
			return new MInvoice_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MPayment_BH.Table_Name)) {
			return new MPayment_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MDashboardButtonGroupButton.Table_Name)) {
			return new MDashboardButtonGroupButton(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MOrderLine_BH.Table_Name)) {
			return new MOrderLine_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MDashboardButtonGroup.Table_Name)) {
			return new MDashboardButtonGroup(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MInventoryLine_BH.Table_Name)) {
			return new MInventoryLine_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MProduct_BH.Table_Name)) {
			return new MProduct_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MTabNavBtn.Table_Name)) {
			return new MTabNavBtn(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MTabNavBtnTab.Table_Name)) {
			return new MTabNavBtnTab(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MUIButton.Table_Name)) {
			return new MUIButton(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MCharge_BH.Table_Name)) {
			return new MCharge_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPaymentRef.Table_Name)) {
			return new MBHPaymentRef(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPaymentRefBankAccount.Table_Name)) {
			return new MBHPaymentRefBankAccount(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHChargeDefault.Table_Name)) {
			return new MBHChargeDefault(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MChargeType_BH.Table_Name)) {
			return new MChargeType_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MProductCategory_BH.Table_Name)) {
			return new MProductCategory_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHProductCategoryDefault.Table_Name)) {
			return new MBHProductCategoryDefault(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHDefaultIncludedRole.Table_Name)) {
			return new MBHDefaultIncludedRole(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MUser_BH.Table_Name)) {
			return new MUser_BH(Env.getCtx(), rs, trxName);
		}

		return null;
	}
}
