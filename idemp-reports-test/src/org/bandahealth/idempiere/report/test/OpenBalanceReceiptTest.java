package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.compiere.model.MPayment;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpenBalanceReceiptTest extends ChuBoePopulateFactoryVO {
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
		valueObject.setQty(new BigDecimal(50));
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		MRefList tenderTypeToUse = tenderTypes.stream()
				.filter(referenceList -> referenceList.getValue().equalsIgnoreCase(MPayment_BH.TENDERTYPE_Cash)).findFirst()
				.orElse(new MRefList(valueObject.getCtx(), 0, valueObject.get_trxName()));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		MPayment payment = new MPayment(valueObject.getCtx(), 0, valueObject.get_trxName());
		payment.setAD_Org_ID(valueObject.getOrg().get_ID());
		payment.setC_DocType_ID(valueObject.getDocType().get_ID());
		payment.setIsReceipt(valueObject.getDocType().isSOTrx());
		payment.setDateTrx(valueObject.getDate());
		payment.setC_BPartner_ID(valueObject.getBP().get_ID());
		payment.setDescription(valueObject.getStepMsgLong());
		valueObject.setBankAcct(BandaCreateEntity.getBankAccountOfOrg(valueObject));
		payment.setC_BankAccount_ID(valueObject.getBankAcct().get_ID());
		payment.setPayAmt(new BigDecimal(20));
		payment.setTenderType(tenderTypeToUse.getValue());

		MInvoice_BH invoice =
				new Query(valueObject.getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.get_trxName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		payment.setC_Currency_ID(valueObject.getInvoice().getC_Currency_ID());

		payment.saveEx();
		valueObject.setPayment(payment);
		payment.setDocAction(valueObject.getDocAction());
		payment.processIt(valueObject.getDocAction());
		payment.saveEx();
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcess_UU("173a691b-ba89-4987-9216-9b3f0a60c864");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Collections.singletonList(
				new ProcessInfoParameter("debtPaymentID", new BigDecimal(valueObject.getPayment().get_ID()), null, null, null)));
		BandaCreateEntity.runReport(valueObject);

		String receiptContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Patient's name is on the receipt", receiptContent,
				containsString(valueObject.getBP().getName().substring(0, 12)));
	}
}
