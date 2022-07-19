package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MRefList;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VoidedTransactionsListTest extends ChuBoePopulateFactoryVO {
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
	public void canRunReport() throws SQLException, IOException, ParseException {
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
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BandaCreateEntity.createOrder(valueObject);
		valueObject.getOrderBH().saveEx();
		commitEx();

		valueObject.setStepName("Complete the order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
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

//		PO.setCrossTenantSafe();
		MBHVoidedReason voidedReason = new Query(valueObject.getCtx(), MBHVoidedReason.Table_Name, null,
				valueObject.get_trxName()).setOnlyActiveRecords(true).first();
//		PO.clearCrossTenantSafe();

		valueObject.setStepName("Void order");
		valueObject.refresh();
		valueObject.getOrderBH().setBH_VoidedReasonID(voidedReason.get_ID());
		valueObject.getOrderBH().setDocAction(MOrder_BH.DOCACTION_Void);
		valueObject.getOrderBH().processIt(MOrder_BH.DOCACTION_Void);
		valueObject.getOrderBH().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("20a623fb-e127-4c26-98d5-3604a6d100b2");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		BandaCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Optional<Row> patientRow =
					StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(1) != null &&
							row.getCell(1).getStringCellValue().equalsIgnoreCase(valueObject.getBP().getName())).findFirst();

			NumberFormat numberFormat = NumberFormat.getInstance();

			assertTrue(patientRow.isPresent(), "Voided record exists");
			assertThat("Voided reason is present", patientRow.get().getCell(4).getStringCellValue(),
					containsStringIgnoringCase(voidedReason.getName()));
		}
	}
}
