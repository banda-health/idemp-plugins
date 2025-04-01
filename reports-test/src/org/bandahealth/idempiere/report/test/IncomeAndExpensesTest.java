package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.report.test.utils.EntityUtils;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.Query;
import org.compiere.model.X_M_Product;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;
import org.compiere.util.Env;
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
	private MProductCategory_BH getProductCategory(ChuBoePopulateVO valueObject, String productCategoryName,
			String productCategoryType)
			throws SQLException {
		MProductCategory_BH productCategory = new Query(valueObject.getContext(), MProductCategory_BH.Table_Name,
				MProductCategory_BH.COLUMNNAME_Name + "=? AND bh_product_category_type=?",
				valueObject.getTransactionName()).setParameters(productCategoryName, productCategoryType).setClient_ID()
				.first();
		if (productCategory == null) {
			productCategory = new MProductCategory_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			productCategory.setName(productCategoryName);
			productCategory.setBH_Product_Category_Type(productCategoryType);
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
				new ProcessInfoParameter("End Date", new Timestamp(System.currentTimeMillis()), null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Income section is on the report", reportContent, containsString("INCOME"));
		assertThat("Expenses section is on the report", reportContent, containsString("EXPENSES"));
	}

	@IPopulateAnnotation.CanRun
	public void serviceCategorySumsShowUpCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		Timestamp beginDate = TimestampUtils.lastMonth();
		Timestamp endDate = new Timestamp(System.currentTimeMillis());

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		//
		FileInputStream file = new FileInputStream(valueObject.getReport());
		double serviceTotals;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> servicesRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Services")))
					.findFirst();
			assertTrue(servicesRow.isPresent(), "Services Revenue row is present");
			Optional<Cell> serviceTotalCell = StreamSupport.stream(servicesRow.get().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)).findFirst();
			assertTrue(serviceTotalCell.isPresent(), "Services Revenue totals cell is present");
			serviceTotals = serviceTotalCell.get().getNumericCellValue();
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create Consultation service category");
		MProductCategory_BH consultationProductCategory =
				getProductCategory(valueObject, "Consultation", MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service);

		valueObject.setStepName("Create Other service category");
		MProductCategory_BH otherProductCategory =
				getProductCategory(valueObject, "Other", MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service);

		valueObject.setStepName("Create Laboratory product category");
		MProductCategory_BH laboratoryProductCategory =
				getProductCategory(valueObject, "Laboratory", MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service);

		valueObject.setStepName("Create Radiology product category");
		MProductCategory_BH radiologyProductCategory =
				getProductCategory(valueObject, "Radiology", MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service);

		valueObject.setStepName("Create Consultation service");
		valueObject.setSalesPrice(new BigDecimal(12));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(consultationProductCategory.get_ID());
		valueObject.getProduct().setProductType(X_M_Product.PRODUCTTYPE_Service);
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create Consultation sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Other service");
		valueObject.setSalesPrice(new BigDecimal(13));
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(otherProductCategory.get_ID());
		valueObject.getProduct().setProductType(X_M_Product.PRODUCTTYPE_Service);
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create Other sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Laboratory product");
		valueObject.setSalesPrice(new BigDecimal(14));
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(laboratoryProductCategory.get_ID());
		valueObject.getProduct().setProductType(X_M_Product.PRODUCTTYPE_Service);
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create Laboratory sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Radiology product");
		valueObject.setSalesPrice(new BigDecimal(15));
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(radiologyProductCategory.get_ID());
		valueObject.getProduct().setProductType(X_M_Product.PRODUCTTYPE_Service);
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create Radiology sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		//
		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> servicesRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Services")))
					.findFirst();
			assertTrue(servicesRow.isPresent(), "Services Revenue row is present");
			assertTrue(StreamSupport.stream(servicesRow.get().spliterator(), false)
					.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)
							&& cell.getNumericCellValue() == serviceTotals + 54), "Service Totals is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void productCategorySumsShowUpCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		Timestamp beginDate = TimestampUtils.lastMonth();
		Timestamp endDate = new Timestamp(System.currentTimeMillis());
		//
		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		//
		FileInputStream file = new FileInputStream(valueObject.getReport());
		double pharmacyTotals = 0;
		double otherTotals = 0;
		double laboratoryTotals = 0;
		double radiologyTotals = 0;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> pharmacyRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Pharmacy")))
					.findFirst();
			assertTrue(pharmacyRow.isPresent(), "Pharmacy income row is present");
			Optional<Cell> serviceTotalCell = StreamSupport.stream(pharmacyRow.get().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)).findFirst();
			assertTrue(serviceTotalCell.isPresent(), "Pharmacy income cell is present");
			pharmacyTotals = serviceTotalCell.get().getNumericCellValue();
			//
			Optional<Row> laboratoryRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Laboratory")))
					.findFirst();
			assertTrue(laboratoryRow.isPresent(), "Laboratory income row is present");
			Optional<Cell> laboratoryIncomeCell = StreamSupport.stream(laboratoryRow.get().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)).findFirst();
			assertTrue(laboratoryIncomeCell.isPresent(), "Laboratory income cell is present");
			laboratoryTotals = laboratoryIncomeCell.get().getNumericCellValue();
			//
			Optional<Row> radiologyRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Radiology")))
					.findFirst();
			assertTrue(radiologyRow.isPresent(), "Radiology income row is present");
			Optional<Cell> radiologyIncomeCell = StreamSupport.stream(radiologyRow.get().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)).findFirst();
			assertTrue(radiologyIncomeCell.isPresent(), "Radiology income cell is present");
			radiologyTotals = radiologyIncomeCell.get().getNumericCellValue();
			//
			Optional<Row> otherRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Other")))
					.findFirst();
			assertTrue(otherRow.isPresent(), "Other income row is present");
			Optional<Cell> otherIncomeCell = StreamSupport.stream(otherRow.get().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)).findFirst();
			assertTrue(otherIncomeCell.isPresent(), "Other income cell is present");
			otherTotals = otherIncomeCell.get().getNumericCellValue();
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create Pharmacy product category");
		MProductCategory_BH pharmacyProductCategory =
				getProductCategory(valueObject, "Pharmacy", MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Product);

		valueObject.setStepName("Create Other product category");
		MProductCategory_BH otherProductCategory =
				getProductCategory(valueObject, "Other", MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Product);

		valueObject.setStepName("Create Laboratory product category");
		MProductCategory_BH laboratoryProductCategory =
				getProductCategory(valueObject, "Laboratory", MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Product);

		valueObject.setStepName("Create Radiology product category");
		MProductCategory_BH radiologyProductCategory =
				getProductCategory(valueObject, "Radiology", MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Product);

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

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
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
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
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
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
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create Radiology product");
		valueObject.setSalesPrice(new BigDecimal(15));
		valueObject.clearProduct();
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
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		//
		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> pharmacyRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Pharmacy")))
					.findFirst();
			assertTrue(pharmacyRow.isPresent(), "Pharmacy income row is present");
			double finalPharmacyTotals = pharmacyTotals;
			assertTrue(StreamSupport.stream(pharmacyRow.get().spliterator(), false)
					.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)
							&& cell.getNumericCellValue() == finalPharmacyTotals + 30 * 12), "Pharmacy Totals is correct");
			//
			Optional<Row> laboratoryRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Laboratory")))
					.findFirst();
			assertTrue(laboratoryRow.isPresent(), "Laboratory income row is present");
			double finalLaboratoryTotals = laboratoryTotals;
			assertTrue(StreamSupport.stream(laboratoryRow.get().spliterator(), false)
					.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)
							&& cell.getNumericCellValue() == finalLaboratoryTotals + 70 * 14), "Laboratory Totals is correct");
			//
			Optional<Row> radiologyRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Radiology")))
					.findFirst();
			assertTrue(radiologyRow.isPresent(), "Radiology income row is present");
			double finalRadiologyTotals = radiologyTotals;
			assertTrue(StreamSupport.stream(radiologyRow.get().spliterator(), false)
					.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)
							&& cell.getNumericCellValue() == finalRadiologyTotals + 90 * 15), "Radiology Totals is correct");
			//
			Optional<Row> otherRow = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().contains("Other")))
					.findFirst();
			assertTrue(otherRow.isPresent(), "Other income row is present");
			double finalOtherTotals = otherTotals;
			assertTrue(StreamSupport.stream(otherRow.get().spliterator(), false)
					.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC)
							&& cell.getNumericCellValue() == finalOtherTotals + 50 * 13), "Other Totals is correct");
		}
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
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		double initialTotalExpenses;
		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> expenseTotalsRow = StreamSupport
					.stream(sheet.spliterator(),
							false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().equals("Total " + "expenses")))
					.findFirst();
			assertTrue(expenseTotalsRow.isPresent(), "Expense totals row exists");

			initialTotalExpenses = StreamSupport.stream(expenseTotalsRow.get().spliterator(), false)
					.filter(cell -> cell.getCellType().equals(CellType.NUMERIC)).findFirst().orElseThrow()
					.getNumericCellValue();
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
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> expenseTotalsRow = StreamSupport
					.stream(sheet.spliterator(),
							false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().equals("Total " + "expenses")))
					.findFirst();
			assertTrue(expenseTotalsRow.isPresent(), "Expense totals row exists");

			double newExpenseTotals = StreamSupport.stream(expenseTotalsRow.get().spliterator(), false)
					.filter(cell -> cell.getCellType().equals(CellType.NUMERIC)).findFirst().orElseThrow()
					.getNumericCellValue();
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
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> expenseTotalsRow = StreamSupport
					.stream(sheet.spliterator(),
							false)
					.filter(row -> StreamSupport.stream(row.spliterator(), false)
							.anyMatch(cell -> cell.getCellType().equals(CellType.STRING)
									&& cell.getStringCellValue().equals("Total " + "expenses")))
					.findFirst();
			assertTrue(expenseTotalsRow.isPresent(), "Expense totals row exists");

			double newExpenseTotals = StreamSupport.stream(expenseTotalsRow.get().spliterator(), false)
					.filter(cell -> cell.getCellType().equals(CellType.NUMERIC)).findFirst().orElseThrow()
					.getNumericCellValue();
			assertEquals(100d, newExpenseTotals - initialTotalExpenses, "Old PO was not included in expenses");
		}
	}

	@IPopulateAnnotation.CanRun
	public void insurancesShowUpOnTheReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

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

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_WarehouseOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create invoice");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		MInvoice_BH invoice = valueObject.getInvoice();
		commitEx();

		valueObject.setStepName("Create insurer");
		valueObject.stackAndClearBusinessPartner();
		EntityUtils.getBandaHealthFeeForServiceInsurerAndAssociatedCharge(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create insurer invoice line discount");
		MInvoiceLine invoiceLine = new MInvoiceLine(valueObject.getContext(), 0, valueObject.getTransactionName());
		invoiceLine.setC_Invoice_ID(invoice.get_ID());
		invoiceLine.setDescription(valueObject.getStepMessageLong());
		invoiceLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		invoiceLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		invoiceLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		invoiceLine.setQty(Env.ONE);
		invoiceLine.setPrice(new BigDecimal(-2));
		invoiceLine.saveEx();

		invoice.setDocAction(DocAction.ACTION_Complete);
		assertTrue(invoice.processIt(DocAction.ACTION_Complete), "Invoice completed");
		invoice.saveEx();
		commitEx();

		valueObject.setStepName("Create insurer invoice");
		valueObject.setOrder(null);
		valueObject.setOrderLine(null);
		valueObject.setSalesStandardPrice(invoiceLine.getPriceActual().negate());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)));
		valueObject.setReportType("pdf");
		ChuBoeCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertTrue(reportContent.contains(valueObject.getBusinessPartner().getName().substring(0, 10)),
				"Insurer shows up on the report");
	}
}
