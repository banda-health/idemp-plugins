package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpenBalanceReceiptTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		MPayment_BH payment = new MPayment_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		payment.setAD_Org_ID(valueObject.getOrg().get_ID());
		payment.setC_DocType_ID(valueObject.getDocumentType().get_ID());
		payment.setIsReceipt(valueObject.getDocumentType().isSOTrx());
		payment.setDateTrx(valueObject.getDate());
		payment.setC_BPartner_ID(valueObject.getBusinessPartner().get_ID());
		payment.setDescription(valueObject.getStepMessageLong());
		valueObject.setBankAccount(ChuBoeCreateEntity.getBankAccountOfOrganization(valueObject));
		payment.setC_BankAccount_ID(valueObject.getBankAccount().get_ID());
		payment.setPayAmt(new BigDecimal(20));
		payment.setBH_TenderAmount(new BigDecimal(20));
		payment.setTenderType(MPayment_BH.TENDERTYPE_Cash);

		MInvoice_BH invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		payment.setC_Currency_ID(valueObject.getInvoice().getC_Currency_ID());

		payment.saveEx();
		valueObject.setPayment(payment);
		payment.setDocAction(valueObject.getDocumentAction());
		payment.processIt(valueObject.getDocumentAction());
		payment.saveEx();
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("173a691b-ba89-4987-9216-9b3f0a60c864");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("debtPaymentID", new BigDecimal(valueObject.getPayment().get_ID()), null, null,
						null)));
		ChuBoeCreateEntity.runReport(valueObject);

		String receiptContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Patient's name is on the receipt", receiptContent,
				containsString(valueObject.getBusinessPartner().getName().substring(0, 12)));
		assertThat("Payment amount is on the receipt", receiptContent, containsString("Payment Amount Cash 20"));
	}
}
