package org.bandahealth.idempiere.base.factory;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroup;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.compiere.model.PO;
import org.compiere.util.Env;

public class BHModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return MBPartner_BH.class;
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return MOrder_BH.class;
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
		}

		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return new MBPartner_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return new MOrder_BH(Env.getCtx(), Record_ID, trxName);
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
		}

		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return new MBPartner_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return new MOrder_BH(Env.getCtx(), rs, trxName);
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
		}

		return null;
	}
}
