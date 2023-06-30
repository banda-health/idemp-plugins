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
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventorySoldReportTest extends ChuBoePopulateFactoryVO {
	private final String reportUuid = "1211e173-6f12-4e2f-bfcc-d43d48af51c3";

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

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(30));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BigDecimal quantitySold = new BigDecimal(20);
		valueObject.setQuantity(quantitySold);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.lastMonth(), null, null, null),
				new ProcessInfoParameter("End Date", new Timestamp(System.currentTimeMillis()), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Optional<Row> productRow =
					StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().equalsIgnoreCase(valueObject.getProduct().getName())).findFirst();
			assertTrue(productRow.isPresent(), "Report contains product");
			assertThat("Quantity sold for this product is correct", productRow.get().getCell(1).getNumericCellValue(),
					is(quantitySold.doubleValue()));
			assertThat("Selling price for this product is correct", productRow.get().getCell(2).getNumericCellValue(),
					is(valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("Income for this product is correct", productRow.get().getCell(3).getNumericCellValue(),
					is(quantitySold.doubleValue() * valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("Purchase price for this product is correct", productRow.get().getCell(4).getNumericCellValue(),
					is(valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("COGS for this product is correct", productRow.get().getCell(5).getNumericCellValue(),
					is(valueObject.getPurchaseStandardPrice().doubleValue() * quantitySold.doubleValue()));
			assertThat("Gross profit for this product is correct", productRow.get().getCell(6).getNumericCellValue(),
					is((valueObject.getSalesStandardPrice().doubleValue() -
							valueObject.getPurchaseStandardPrice().doubleValue()) *
							quantitySold.doubleValue()));
		}
	}

	@IPopulateAnnotation.CanRun
	public void duplicateProductQuantityDoesntAppearWhenSellingOnDifferentDays() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDateOffset(-1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(30));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BigDecimal quantitySold = new BigDecimal(5);
		valueObject.setQuantity(quantitySold);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDateOffset(1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(quantitySold);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.lastMonth(), null, null, null),
				new ProcessInfoParameter("End Date", new Timestamp(System.currentTimeMillis()), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 30)))
					.collect(Collectors.toList());
			double totalQuantitySold = quantitySold.doubleValue() * 2;
			assertEquals(1, productRows.size(), "Only one row is returned");
			assertThat("Quantity sold for this product is correct", productRows.get(0).getCell(1).getNumericCellValue(),
					is(totalQuantitySold));
			assertThat("Selling price for this product is correct", productRows.get(0).getCell(2).getNumericCellValue(),
					is(valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("Income for this product is correct", productRows.get(0).getCell(3).getNumericCellValue(),
					is(totalQuantitySold * valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("Purchase price for this product is correct", productRows.get(0).getCell(4).getNumericCellValue(),
					is(valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("COGS for this product is correct", productRows.get(0).getCell(5).getNumericCellValue(),
					is(valueObject.getPurchaseStandardPrice().doubleValue() * totalQuantitySold));
			assertThat("Gross profit for this product is correct", productRows.get(0).getCell(6).getNumericCellValue(),
					is((valueObject.getSalesStandardPrice().doubleValue() -
							valueObject.getPurchaseStandardPrice().doubleValue()) * totalQuantitySold));
		}
	}

	@IPopulateAnnotation.CanRun
	public void matchingProductInformationRowsAreNotMerged() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setPurchasePrice(new BigDecimal(75));
		valueObject.setSalesPrice(new BigDecimal(100));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().setBH_BuyPrice(valueObject.getPurchaseStandardPrice());
		valueObject.getProduct().setBH_SellPrice(valueObject.getSalesStandardPrice());
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create attribute set to track expirations");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setIsGuaranteeDate(true);
		attributeSet.setIsGuaranteeDateMandatory(true);
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create first attribute set instance");
		valueObject.setRandom();
		MAttributeSetInstance_BH firstAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		firstAttributeSetInstance.setGuaranteeDate(TimestampUtils.tomorrow());
		firstAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		firstAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		firstAttributeSetInstance.setDescription(valueObject.getScenarioName());
		firstAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create inventory");
		valueObject.setAttributeSetInstance(firstAttributeSetInstance);
		valueObject.setDateOffset(-5);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(5));
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setAttributeSetInstance(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BigDecimal quantitySold = new BigDecimal(5);
		valueObject.setQuantity(quantitySold);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second attribute set instance");
		valueObject.setRandom();
		MAttributeSetInstance_BH secondAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		secondAttributeSetInstance.setGuaranteeDate(TimestampUtils.tomorrow());
		secondAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		secondAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		secondAttributeSetInstance.setDescription(valueObject.getScenarioName());
		secondAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setAttributeSetInstance(secondAttributeSetInstance);
		valueObject.setDateOffset(4);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setAttributeSetInstance(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(quantitySold);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.lastMonth(), null, null, null),
				new ProcessInfoParameter("End Date", new Timestamp(System.currentTimeMillis()), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 30)))
					.collect(Collectors.toList());
			double totalQuantitySold = quantitySold.doubleValue() * 2;
			assertEquals(1, productRows.size(), "Only one row is returned");
			assertThat("Quantity sold for this product is correct", productRows.get(0).getCell(1).getNumericCellValue(),
					is(totalQuantitySold));
			assertThat("Selling price for this product is correct", productRows.get(0).getCell(2).getNumericCellValue(),
					is(valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("Income for this product is correct", productRows.get(0).getCell(3).getNumericCellValue(),
					is(totalQuantitySold * valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("Purchase price for this product is correct", productRows.get(0).getCell(4).getNumericCellValue(),
					is(valueObject.getPurchaseStandardPrice().doubleValue()));
			assertThat("COGS for this product is correct", productRows.get(0).getCell(5).getNumericCellValue(),
					is(valueObject.getPurchaseStandardPrice().doubleValue() * totalQuantitySold));
			assertThat("Gross profit for this product is correct", productRows.get(0).getCell(6).getNumericCellValue(),
					is((valueObject.getSalesStandardPrice().doubleValue() -
							valueObject.getPurchaseStandardPrice().doubleValue()) * totalQuantitySold));
		}
	}

	@IPopulateAnnotation.CanRun
	public void matchingProductInformationRowsAreNotMergedWithSpecifiedAttributeSetInstances()
			throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setPurchasePrice(new BigDecimal(75));
		valueObject.setSalesPrice(new BigDecimal(100));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().setBH_BuyPrice(valueObject.getPurchaseStandardPrice());
		valueObject.getProduct().setBH_SellPrice(valueObject.getSalesStandardPrice());
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create attribute set to track expirations");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setIsGuaranteeDate(true);
		attributeSet.setIsGuaranteeDateMandatory(true);
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create first attribute set instance");
		valueObject.setRandom();
		MAttributeSetInstance_BH firstAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		firstAttributeSetInstance.setGuaranteeDate(TimestampUtils.tomorrow());
		firstAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		firstAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		firstAttributeSetInstance.setDescription(valueObject.getScenarioName());
		firstAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create inventory");
		valueObject.setAttributeSetInstance(firstAttributeSetInstance);
		valueObject.setDateOffset(-5);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(5));
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BigDecimal quantitySold = new BigDecimal(5);
		valueObject.setQuantity(quantitySold);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second attribute set instance");
		valueObject.setRandom();
		MAttributeSetInstance_BH secondAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		secondAttributeSetInstance.setGuaranteeDate(TimestampUtils.tomorrow());
		secondAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		secondAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		secondAttributeSetInstance.setDescription(valueObject.getScenarioName());
		secondAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setAttributeSetInstance(secondAttributeSetInstance);
		valueObject.setDateOffset(4);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(quantitySold);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.lastMonth(), null, null, null),
				new ProcessInfoParameter("End Date", new Timestamp(System.currentTimeMillis()), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 30)))
					.collect(Collectors.toList());
			double totalQuantitySold = quantitySold.doubleValue() * 2;
			assertEquals(1, productRows.size(), "Only one row is returned");
			assertThat("Quantity sold for this product is correct", productRows.get(0).getCell(1).getNumericCellValue(),
					is(totalQuantitySold));
			assertThat("Selling price for this product is correct", productRows.get(0).getCell(2).getNumericCellValue(),
					is(valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("Income for this product is correct", productRows.get(0).getCell(3).getNumericCellValue(),
					is(totalQuantitySold * valueObject.getSalesStandardPrice().doubleValue()));
			assertThat("Purchase price for this product is correct", productRows.get(0).getCell(4).getNumericCellValue(),
					is(valueObject.getPurchaseStandardPrice().doubleValue()));
			assertThat("COGS for this product is correct", productRows.get(0).getCell(5).getNumericCellValue(),
					is(valueObject.getPurchaseStandardPrice().doubleValue() * totalQuantitySold));
			assertThat("Gross profit for this product is correct", productRows.get(0).getCell(6).getNumericCellValue(),
					is((valueObject.getSalesStandardPrice().doubleValue() -
							valueObject.getPurchaseStandardPrice().doubleValue()) * totalQuantitySold));
		}
	}

	@IPopulateAnnotation.CanRun
	public void dateTimeFiltersWork() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create attribute set");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		MProduct_BH product = valueObject.getProduct();
		product.setName(String.valueOf(valueObject.getRandomNumber()));
		product.saveEx();
		commitEx();

		valueObject.setStepName("Create attribute set instance");
		MAttributeSetInstance_BH attributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetInstance.setDescription(valueObject.getScenarioName());
		attributeSetInstance.saveEx();
		valueObject.setAttributeSetInstance(attributeSetInstance);
		commitEx();

		Timestamp earlyDate = TimestampUtils.startOfYesterday();
		Timestamp beginDate = TimestampUtils.add(earlyDate, Calendar.HOUR, 2);
		Timestamp endDate = TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, 2);
		Timestamp lateDate = TimestampUtils.add(endDate, Calendar.DAY_OF_YEAR, 2);

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		valueObject.setDate(earlyDate);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		valueObject.setStepName("Create visit");
		valueObject.setDate(earlyDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(15));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of the transaction from the last sales order");
		DB.executeUpdate("UPDATE m_transaction SET created = '" + dbDateFormat.format(earlyDate) + "', updated = '" +
				dbDateFormat.format(earlyDate) +
				"' WHERE m_inoutline_id IN (SELECT m_inoutline_id FROM m_inoutline WHERE c_orderline_id IN (SELECT " +
				"c_orderline_id FROM c_orderline WHERE c_order_id = " +
				valueObject.getOrder().get_ID() + "))", valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Create second visit");
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(16));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create third visit");
		valueObject.setDate(lateDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDate(lateDate);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(17));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of the inventory from the last sales order");
		DB.executeUpdate("UPDATE m_transaction SET created = '" + dbDateFormat.format(lateDate) + "', updated = '" +
				dbDateFormat.format(lateDate) +
				"' WHERE m_inoutline_id IN (SELECT m_inoutline_id FROM m_inoutline WHERE c_orderline_id IN (SELECT " +
				"c_orderline_id FROM c_orderline WHERE c_order_id = " +
				valueObject.getOrder().get_ID() + "))", valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Product Name");
			int productColumnIndex = TableUtils.getColumnIndex(headerRow, "Product Name");
			int quantitySoldColumnIndex = TableUtils.getColumnIndex(headerRow, "Quantity Sold");

			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(productColumnIndex) != null &&
									row.getCell(productColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(productColumnIndex).getStringCellValue().contains(product.getName()))
					.collect(Collectors.toList());
			assertEquals(1, productRows.size(), "The product is on the report");

			Row productRow = productRows.get(0);
			assertEquals(16, productRow.getCell(quantitySoldColumnIndex).getNumericCellValue(),
					"Opening inventory amount is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void reportDoesNotIncludeServices() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(30));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BigDecimal quantitySold = new BigDecimal(20);
		valueObject.setQuantity(quantitySold);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create service");
		valueObject.clearProduct();
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Add second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(15));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
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
			Row headerRow = TableUtils.getHeaderRow(sheet, "Product Name");
			int productColumnIndex = TableUtils.getColumnIndex(headerRow, "Product Name");

			Optional<Row> serviceRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(productColumnIndex) != null && row.getCell(productColumnIndex).getStringCellValue()
							.contains(valueObject.getProduct().getName().substring(0, 20))).findFirst();
			assertTrue(serviceRow.isEmpty(), "Report does not contain service");
		}
	}
}
