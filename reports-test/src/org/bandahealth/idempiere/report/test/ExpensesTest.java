package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpensesTest extends ChuBoePopulateFactoryVO {
	private static final String patientTransactionReportUuid = "bbffd5e1-973a-4d17-9ddf-9ca78a4e140d";

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

		valueObject.setStepName("Create expense category");
		ChuBoeCreateEntity.createCharge(valueObject);
		MChargeType_BH expenseCategoryChargeType =
				new Query(valueObject.getContext(), MChargeType_BH.Table_Name, MChargeType_BH.COLUMNNAME_Name + "=?",
						valueObject.getTransactionName()).setParameters(MChargeType_BH.CHARGETYPENAME_DEFAULT_EXPENSE_CATEGORY)
						.setClient_ID().first();
		if (expenseCategoryChargeType == null) {
			expenseCategoryChargeType = new MChargeType_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			expenseCategoryChargeType.setDescription("For an expense category added by default");
			expenseCategoryChargeType.setName(MChargeType_BH.CHARGETYPENAME_DEFAULT_EXPENSE_CATEGORY);
			expenseCategoryChargeType.saveEx();
		}
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create expense");
		valueObject.setSalesPrice(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Date");
			int expenseCategoryColumnIndex = TableUtils.getColumnIndex(headerRow, "Expense Category");
			int supplierColumnIndex = TableUtils.getColumnIndex(headerRow, "Supplier");

			List<Row> expenseRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(expenseCategoryColumnIndex) != null &&
							row.getCell(5).getCellType().equals(CellType.STRING) &&
							row.getCell(expenseCategoryColumnIndex).getStringCellValue()
									.contains(valueObject.getCharge().getName().substring(0, 30))).collect(Collectors.toList());
			assertEquals(1, expenseRows.size(), "Expense category only appears once");
			assertTrue(expenseRows.get(0).getCell(supplierColumnIndex).getStringCellValue()
					.contains(valueObject.getBusinessPartner().getName().substring(0, 30)), "Supplier is correct");
		}
	}
}
