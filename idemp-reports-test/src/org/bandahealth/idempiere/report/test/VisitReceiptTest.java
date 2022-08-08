package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
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

public class VisitReceiptTest extends ChuBoePopulateFactoryVO {
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
	public void canGenerateReceipt() throws SQLException, IOException {
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
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
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
		payment.setBH_C_Order_ID(valueObject.getOrder().get_ID());
		payment.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		payment.setC_Currency_ID(valueObject.getOrder().getC_Currency_ID());
		payment.saveEx();
		valueObject.setPayment(payment);
		commitEx();

		valueObject.setStepName("Complete the order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getOrder().get_ID()), null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);

		String receiptContent = PDFUtils.readPdfContent(valueObject.getReport());
		assertThat("Patient's name is on the receipt", receiptContent,
				containsString(valueObject.getBusinessPartner().getName().substring(0, 12)));
		assertThat("Products are included", receiptContent,
				containsString(valueObject.getOrderLine().getName().substring(0, 18)));
		assertThat("Products prices are included", receiptContent,
				containsString(String.valueOf(valueObject.getOrderLine().getLineNetAmt().intValue())));
		assertThat("Payments are included", receiptContent.toLowerCase(), containsString("Cash".toLowerCase()));
		assertThat("Products prices are included", receiptContent,
				containsString(String.valueOf(valueObject.getPayment().getPayAmt().intValue())));
	}
}
