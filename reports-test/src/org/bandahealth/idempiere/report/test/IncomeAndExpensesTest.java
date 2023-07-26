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
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncomeAndExpensesTest extends ChuBoePopulateFactoryVO {
	private MProductCategory_BH getProductCategory(ChuBoePopulateVO valueObject, String productCategoryName)
			throws SQLException {
		MProductCategory_BH productCategory =
				new Query(valueObject.getContext(), MProductCategory_BH.Table_Name, MProductCategory_BH.COLUMNNAME_Name + "=?",
						valueObject.getTransactionName()).setParameters(productCategoryName).setClient_ID().first();
		if (productCategory == null) {
			productCategory = new MProductCategory_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			productCategory.setName(productCategoryName);
			productCategory.setBH_Product_Category_Type(MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Product);
			productCategory.saveEx();
		}
		commitEx();
		return productCategory;
	}

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

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.lastMonth(), null, null, null),
				new ProcessInfoParameter("End Date", new Timestamp(System.currentTimeMillis()), null, null, null)
		));
		ChuBoeCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Income section is on the report", reportContent, containsString("INCOME"));
		assertThat("Expenses section is on the report", reportContent, containsString("EXPENSES"));
	}

	@IPopulateAnnotation.CanRun
	public void productCategorySumsShowUpCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create Pharmacy product category");
		MProductCategory_BH pharmacyProductCategory = getProductCategory(valueObject, "Pharmacy");

		valueObject.setStepName("Create Other product category");
		MProductCategory_BH otherProductCategory = getProductCategory(valueObject, "Other");

		valueObject.setStepName("Create Laboratory product category");
		MProductCategory_BH laboratoryProductCategory = getProductCategory(valueObject, "Laboratory");

		valueObject.setStepName("Create Radiology product category");
		MProductCategory_BH radiologyProductCategory = getProductCategory(valueObject, "Radiology");

		valueObject.setStepName("Create Pharmacy product");
		valueObject.setSalesPrice(new BigDecimal(12));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(pharmacyProductCategory.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create Pharmacy purchase order");
		valueObject.setQuantity(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Pharmacy sales order");
		valueObject.setQuantity(new BigDecimal(30));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Other product");
		valueObject.setSalesPrice(new BigDecimal(13));
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(otherProductCategory.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create Other purchase order");
		valueObject.setQuantity(new BigDecimal(110));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Other sales order");
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Laboratory product");
		valueObject.setSalesPrice(new BigDecimal(14));
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(laboratoryProductCategory.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create Laboratory purchase order");
		valueObject.setQuantity(new BigDecimal(120));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Laboratory sales order");
		valueObject.setQuantity(new BigDecimal(70));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Radiology product");
		valueObject.setSalesPrice(new BigDecimal(15));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(radiologyProductCategory.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create Radiology purchase order");
		valueObject.setQuantity(new BigDecimal(130));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Radiology sales order");
		valueObject.setQuantity(new BigDecimal(90));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		Timestamp beginDate = TimestampUtils.lastMonth();
		Timestamp endDate = new Timestamp(System.currentTimeMillis());
		String chargeSql = "SELECT " +
				"     COALESCE(SUM(ol.linenetamt) FILTER ( WHERE pc.name = 'Pharmacy' ), 0)   AS pharmacysales, " +
				"      COALESCE(SUM(ol.linenetamt) FILTER ( WHERE pc.name = 'Services' ), 0)   AS servicessales, " +
				"      COALESCE(SUM(ol.linenetamt) FILTER ( WHERE pc.name = 'Laboratory' ), 0) AS labsales, " +
				"      COALESCE(SUM(ol.linenetamt) FILTER ( WHERE pc.name = 'Radiology' ), 0)  AS radiologysales, " +
				"      COALESCE(SUM(ol.linenetamt) FILTER ( WHERE pc.name = 'Other' ), 0)      AS othersales " +
				"    FROM " +
				"      bh_visit v " +
				"        JOIN c_order o " +
				"          ON v.bh_visit_id = o.bh_visit_id " +
				"        JOIN c_orderline ol " +
				"          ON o.c_order_id = ol.c_order_id " +
				"        JOIN m_product p " +
				"          ON ol.m_product_id = p.m_product_id " +
				"        RIGHT JOIN m_product_category pc " +
				"          ON p.m_product_category_id = pc.m_product_category_id " +
				"    WHERE " +
				"      o.docstatus = ? " +
				"      AND v.bh_visitdate BETWEEN ? AND ? " +
				"      AND v.ad_client_id = ?";
		List<Object> parameters = new ArrayList<>() {{
			add(MOrder_BH.DOCSTATUS_Completed);
			add(beginDate);
			add(endDate);
			add(valueObject.getClient().get_ID());
		}};
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BigDecimal pharmacyTotals = BigDecimal.ZERO;
		BigDecimal otherTotals = BigDecimal.ZERO;
		BigDecimal laboratoryTotals = BigDecimal.ZERO;
		BigDecimal radiologyTotals = BigDecimal.ZERO;
		try {
			preparedStatement = DB.prepareStatement(chargeSql, valueObject.getTransactionName());
			DB.setParameters(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				pharmacyTotals = resultSet.getBigDecimal(1);
				otherTotals = resultSet.getBigDecimal(2);
				laboratoryTotals = resultSet.getBigDecimal(3);
				radiologyTotals = resultSet.getBigDecimal(4);
			}
		} finally {
			DB.close(resultSet, preparedStatement);
		}

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
				new ProcessInfoParameter("End Date", endDate, null, null, null)
		));
		ChuBoeCreateEntity.runReport(valueObject);

		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Pharmacy charges are on the report", reportContent,
				containsString(decimalFormat.format(pharmacyTotals.intValue())));
		assertThat("Other charges are on the report", reportContent,
				containsString(decimalFormat.format(otherTotals.intValue())));
		assertThat("Laboratory charges are on the report", reportContent,
				containsString(decimalFormat.format(laboratoryTotals.intValue())));
		assertThat("Radiology charges are on the report", reportContent,
				containsString(decimalFormat.format(radiologyTotals.intValue())));
	}

	@IPopulateAnnotation.CanRun
	public void expensesShowUpForTheCorrectDatesAndNotWhenTheyWereUpdated() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		double initialTotalExpenses;
		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> expenseTotalsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell.getCellType().equals(CellType.STRING) && cell.getStringCellValue().equals("Total " +
											"expenses")))
					.findFirst();
			assertTrue(expenseTotalsRow.isPresent(), "Expense totals row exists");

			initialTotalExpenses = StreamSupport.stream(expenseTotalsRow.get().spliterator(), false)
					.filter(cell -> cell.getCellType().equals(CellType.NUMERIC)).findFirst().orElseThrow().getNumericCellValue();
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> expenseTotalsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell.getCellType().equals(CellType.STRING) && cell.getStringCellValue().equals("Total " +
											"expenses")))
					.findFirst();
			assertTrue(expenseTotalsRow.isPresent(), "Expense totals row exists");

			double newExpenseTotals = StreamSupport.stream(expenseTotalsRow.get().spliterator(), false)
					.filter(cell -> cell.getCellType().equals(CellType.NUMERIC)).findFirst().orElseThrow().getNumericCellValue();
			assertEquals(100d, newExpenseTotals - initialTotalExpenses, "PO was included in expenses");
		}

		valueObject.setStepName("Create an old PO");
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(100));
		valueObject.setDateOffset(-5);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> expenseTotalsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell.getCellType().equals(CellType.STRING) && cell.getStringCellValue().equals("Total " +
											"expenses")))
					.findFirst();
			assertTrue(expenseTotalsRow.isPresent(), "Expense totals row exists");

			double newExpenseTotals = StreamSupport.stream(expenseTotalsRow.get().spliterator(), false)
					.filter(cell -> cell.getCellType().equals(CellType.NUMERIC)).findFirst().orElseThrow().getNumericCellValue();
			assertEquals(100d, newExpenseTotals - initialTotalExpenses, "Old PO was not included in expenses");
		}
	}
}
