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
import org.bandahealth.idempiere.base.model.MBHBPartnerTags;
import org.bandahealth.idempiere.base.model.MBHTag;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicesChargedReportTest extends ChuBoePopulateFactoryVO {
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
	public void canRunReport() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Service Name");
			int serviceColumnIndex = TableUtils.getColumnIndex(headerRow, "Service Name");
			int quantityChargedColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Quantity");
			int chargePriceColumnIndex = TableUtils.getColumnIndex(headerRow, "Unit Charge Price");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(serviceColumnIndex) != null &&
							row.getCell(serviceColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(serviceColumnIndex).getStringCellValue()
									.contains(valueObject.getProduct().getName().substring(0, 30))).findFirst();

			assertTrue(productRow.isPresent(), "Service row exists");
			assertThat("Times charged is correct",
					productRow.get().getCell(quantityChargedColumnIndex).getNumericCellValue(),
					is(1D));
			assertThat("Selling price is correct", productRow.get().getCell(chargePriceColumnIndex).getNumericCellValue(),
					is(50D));
			assertThat("Income is correct", productRow.get().getCell(amountColumnIndex).getNumericCellValue(), is(50D));
		}
	}

	@IPopulateAnnotation.CanRun
	public void serviceShowsUpEvenIfExpenseColumnNull() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(0) != null && row.getCell(0).getCellType().equals(CellType.STRING) &&
									row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 30)))
					.findFirst();

			assertTrue(productRow.isPresent(), "Service row exists");
		}
	}

	@IPopulateAnnotation.CanRun
	public void dateTimeFiltersWork() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		Timestamp earlyDate = TimestampUtils.startOfYesterday();
		Timestamp beginDate = TimestampUtils.add(earlyDate, Calendar.HOUR, 2);
		Timestamp endDate = TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, 2);
		Timestamp lateDate = TimestampUtils.add(endDate, Calendar.DAY_OF_YEAR, 2);

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create first visit");
		valueObject.setDate(earlyDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second visit");
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create third visit");
		valueObject.setDate(lateDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create third sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
				new ProcessInfoParameter("End Date", endDate, null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Service Name");
			int serviceColumnIndex = TableUtils.getColumnIndex(headerRow, "Service Name");
			int quantityChargedColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Quantity");
			int chargePriceColumnIndex = TableUtils.getColumnIndex(headerRow, "Unit Charge Price");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(serviceColumnIndex) != null &&
							row.getCell(serviceColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(serviceColumnIndex).getStringCellValue()
									.contains(valueObject.getProduct().getName().substring(0, 30))).findFirst();

			assertTrue(productRow.isPresent(), "Service row exists");
			assertThat("Times charged is correct",
					productRow.get().getCell(quantityChargedColumnIndex).getNumericCellValue(), is(1D));
			assertThat("Selling price is correct", productRow.get().getCell(chargePriceColumnIndex).getNumericCellValue(),
					is(50D));
			assertThat("Income is correct", productRow.get().getCell(amountColumnIndex).getNumericCellValue(), is(50D));
		}
	}

	@IPopulateAnnotation.CanRun
	public void totalsAreCorrectInCategoryTablesAndTotal() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		Timestamp earlyDate = TimestampUtils.startOfYesterday();
		Timestamp beginDate = TimestampUtils.add(earlyDate, Calendar.HOUR, 2);
		Timestamp endDate = TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, 2);
		Timestamp lateDate = TimestampUtils.add(endDate, Calendar.DAY_OF_YEAR, 2);

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		valueObject.setDate(earlyDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
				new ProcessInfoParameter("End Date", endDate, null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			double totalServicesCharged = 0;
			double currentServiceCharged = 0;

			Row headerRow = TableUtils.getHeaderRow(sheet, "Service Name");
			int categoryColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Category");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			String currentCategory = null;
			for (Row row : sheet) {
				// If this is the header row, be done
				if (StreamSupport.stream(row.spliterator(), false).anyMatch(
						cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
								cell.getStringCellValue().equals("Service Name"))) {
					currentServiceCharged = 0;
					continue;
				}
				// If this is a table row
				if (row.getCell(categoryColumnIndex) != null &&
						row.getCell(categoryColumnIndex).getCellType().equals(CellType.STRING) &&
						!StringUtil.isNullOrEmpty(row.getCell(categoryColumnIndex).getStringCellValue())) {
					currentCategory = row.getCell(categoryColumnIndex).getStringCellValue();
					currentServiceCharged += row.getCell(amountColumnIndex).getNumericCellValue();
					totalServicesCharged += row.getCell(amountColumnIndex).getNumericCellValue();
					continue;
				}
				String finalCurrentCategory = currentCategory;
				if (!StringUtil.isNullOrEmpty(currentCategory) && StreamSupport.stream(row.spliterator(), false).anyMatch(
						cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
								cell.getStringCellValue().equals(finalCurrentCategory + " Total"))) {
					assertEquals(row.getCell(amountColumnIndex).getNumericCellValue(), currentServiceCharged,
							finalCurrentCategory + " total is correct");
				}
			}

			Optional<Row> totalsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Services Total:"))).findFirst();
			assertTrue(totalsRow.isPresent(), "Service row exists");
			assertEquals(totalServicesCharged, totalsRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					"Services total is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void canFilterByPatientTag() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner 1");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product first product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create first visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("create second business partner");
		valueObject.clearBusinessPartner();
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create business partner tag");
		MBHTag tag = new MBHTag(valueObject.getContext(), 0, valueObject.getTransactionName());
		tag.setName(String.valueOf(valueObject.getRandomNumber()));
		tag.saveEx();
		MBHBPartnerTags businessPartnerTag =
				new MBHBPartnerTags(valueObject.getContext(), 0, valueObject.getTransactionName());
		businessPartnerTag.setC_BPartner_ID(valueObject.getBusinessPartner().get_ID());
		businessPartnerTag.setBH_Tag_ID(tag.get_ID());
		businessPartnerTag.saveEx();
		commitEx();

		valueObject.setStepName("Create second product");
		valueObject.clearProduct();
		valueObject.setSalesStandardPrice(new BigDecimal(150));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create second visit");
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null),
						new ProcessInfoParameter("Patient Tags", Collections.singletonList(tag.getBH_Tag_UU()), null, null,
								null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Service Name");
			int serviceColumnIndex = TableUtils.getColumnIndex(headerRow, "Service Name");
			int chargePriceColumnIndex = TableUtils.getColumnIndex(headerRow, "Unit Charge Price");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(serviceColumnIndex) != null &&
							row.getCell(serviceColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(serviceColumnIndex).getStringCellValue()
									.contains(valueObject.getProduct().getName().substring(0, 30))).findFirst();

			assertTrue(productRow.isPresent(), "Service row exists");
			assertThat("Selling price is correct", productRow.get().getCell(chargePriceColumnIndex).getNumericCellValue(),
					is(150D));
			assertThat("Income is correct", productRow.get().getCell(amountColumnIndex).getNumericCellValue(), is(150D));
		}
	}
}
