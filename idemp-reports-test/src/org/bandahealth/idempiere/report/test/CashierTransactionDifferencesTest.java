package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CashierTransactionDifferencesTest extends ChuBoePopulateFactoryVO {
	private List<MRefList> tenderTypes = new ArrayList<>();

	@IPopulateAnnotation.CanRunBeforeClass
	public void populateTenderTypes() {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		tenderTypes = new Query(valueObject.getCtx(), MRefList.Table_Name,
				MReference_BH.Table_Name + "." + MReference_BH.COLUMNNAME_AD_Reference_UU + "=?",
				valueObject.get_trxName()).setParameters(MReference_BH.TENDER_TYPE_AD_REFERENCE_UU).addJoinClause(
				"JOIN " + MReference_BH.Table_Name + " ON " + MReference_BH.Table_Name + "." +
						MReference_BH.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "." +
						MRefList.COLUMNNAME_AD_Reference_ID).list();
	}

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		BandaCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		BandaCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		MRefList tenderTypeToUse = tenderTypes.stream()
				.filter(referenceList -> referenceList.getValue().equalsIgnoreCase(MPayment_BH.TENDERTYPE_Cash)).findFirst()
				.orElse(new MRefList(valueObject.getCtx(), 0, valueObject.get_trxName()));
		MInvoice_BH invoice =
				new Query(valueObject.getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.get_trxName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		BandaCreateEntity.createPayment(valueObject);
		valueObject.getPaymentBH().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPaymentBH().setTenderType(tenderTypeToUse.getValue());
		valueObject.getPaymentBH().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("226cdf47-9cde-43e8-b7ef-87b28d7ef2e2");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		BandaCreateEntity.runReport(valueObject);

		MUser_BH currentUser = new Query(valueObject.getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_ID + "=?",
				valueObject.get_trxName()).setParameters(Env.getAD_User_ID(valueObject.getCtx())).first();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("The cashier's name is on the report", reportContent, containsString(currentUser.getName()));
	}
}
