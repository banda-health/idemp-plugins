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
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.report.test.utils.NumberUtils;
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

public class InventoryQuantityReportTest extends ChuBoePopulateFactoryVO {
	private final String reportUuid = "93d7c1bc-2885-43f4-985f-90f57a414e5f";

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
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Adjust inventory");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(20));
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
			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(0) != null &&
									row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 30)))
					.findFirst();
			assertTrue(productRow.isPresent(), "Report contains product");
			assertThat("Opening stock for this product is correct", productRow.get().getCell(1).getNumericCellValue(),
					is(0.0D));
			assertThat("Received stock for this product is correct", productRow.get().getCell(2).getNumericCellValue(),
					is(10.0D));
			assertThat("Sold stock for this product is correct", productRow.get().getCell(3).getNumericCellValue(),
					is(20.0D));
			assertThat("Balanced stock for this product is correct", productRow.get().getCell(4).getNumericCellValue(),
					is(40.0D));
			assertThat("Balanced stock for this product is correct", productRow.get().getCell(5).getNumericCellValue(),
					is(30.0D));
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
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Adjust inventory");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDateOffset(1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(10));
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
			assertEquals(1, productRows.size(), "Only one row is returned");
			Row productRow = productRows.get(0);
			assertThat("Opening stock for this product is correct", productRow.getCell(1).getNumericCellValue(), is(0.0D));
			assertThat("Received stock for this product is correct", productRow.getCell(2).getNumericCellValue(), is(10.0D));
			assertThat("Sold stock for this product is correct", productRow.getCell(3).getNumericCellValue(), is(20.0D));
			assertThat("Balanced stock for this product is correct", productRow.getCell(4).getNumericCellValue(), is(40.0D));
			assertThat("Balanced stock for this product is correct", productRow.getCell(5).getNumericCellValue(), is(30.0D));
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
		valueObject.setQuantity(new BigDecimal(10)); // + 10
		valueObject.setDate(earlyDate);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of the shipment from the last purchase order");
		SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DB.executeUpdate("UPDATE m_transaction SET created = '" + dbDateFormat.format(earlyDate) + "', updated = '" +
				dbDateFormat.format(earlyDate) +
				"' WHERE m_inoutline_id IN (SELECT m_inoutline_id FROM m_inoutline WHERE c_orderline_id IN (SELECT " +
				"c_orderline_id FROM c_orderline WHERE c_order_id = " +
				valueObject.getOrder().get_ID() + "))", valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Adjust inventory for product");
		BigDecimal firstEndingInventory = NumberUtils.randomBigDecimal(1, 250);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(firstEndingInventory);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		valueObject.setProduct(product);
		valueObject.setDateOffset(1);
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of that last inventory adjustment");
		DB.executeUpdate("UPDATE m_transaction SET created = '" + dbDateFormat.format(earlyDate) + "', updated = '" +
				dbDateFormat.format(earlyDate) +
				"' WHERE m_inventoryline_id IN (SELECT m_inventoryline_id FROM m_inventoryline WHERE m_inventory_id = " +
				valueObject.getInventory().get_ID() + ")", valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Adjust inventory for product again");
		BigDecimal secondEndingInventory = NumberUtils.randomBigDecimal(20, 250); // Give us at least 20
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(secondEndingInventory);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(15)); // - 15
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Adjust inventory for product once more");
		BigDecimal thirdEndingInventory = NumberUtils.randomBigDecimal(1, 250);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(thirdEndingInventory);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Create another purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10)); // + 10
		valueObject.setDate(lateDate);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of the inventory from the last purchase order");
		DB.executeUpdate("UPDATE m_transaction SET created = '" + dbDateFormat.format(lateDate) + "', updated = '" +
				dbDateFormat.format(lateDate) +
				"' WHERE m_inoutline_id IN (SELECT m_inoutline_id FROM m_inoutline WHERE c_orderline_id IN (SELECT " +
				"c_orderline_id FROM c_orderline WHERE c_order_id = " +
				valueObject.getOrder().get_ID() + "))", valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Adjust inventory for product for the last time");
		BigDecimal currentInventory = NumberUtils.randomBigDecimal(20, 250); // Get us back to no less than 20
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(currentInventory);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of that last inventory adjustment");
		DB.executeUpdate("UPDATE m_transaction SET created = '" + dbDateFormat.format(lateDate) + "', updated = '" +
				dbDateFormat.format(lateDate) +
				"' WHERE m_inventoryline_id IN (SELECT m_inventoryline_id FROM m_inventoryline WHERE m_inventory_id = " +
				valueObject.getInventory().get_ID() + ")", valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Create another visit");
		valueObject.setDate(lateDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDate(lateDate);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(16));
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

		int startingInventory = firstEndingInventory.intValue();
		int inventoryDistributed = 15;
		int inventoryReceived = 0;
		int endingInventory = thirdEndingInventory.intValue();
		int changedInventory = endingInventory - (startingInventory + inventoryReceived - inventoryDistributed);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			int productColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int openingColumnIndex = TableUtils.getColumnIndex(headerRow, "Opening");
			int receivedColumnIndex = TableUtils.getColumnIndex(headerRow, "Received");
			int soldColumnIndex = TableUtils.getColumnIndex(headerRow, "Sold");
			int balancedColumnIndex = TableUtils.getColumnIndex(headerRow, "Balanced");
			int closingColumnIndex = TableUtils.getColumnIndex(headerRow, "Closing");

			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(productColumnIndex) != null &&
									row.getCell(productColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(productColumnIndex).getStringCellValue().contains(product.getName()))
					.collect(Collectors.toList());
			assertEquals(1, productRows.size(), "The product is on the report");

			Row productRow = productRows.get(0);
			assertEquals(startingInventory, productRow.getCell(openingColumnIndex).getNumericCellValue(),
					"Opening inventory amount is correct");
			assertEquals(inventoryReceived, productRow.getCell(receivedColumnIndex).getNumericCellValue(),
					"Received inventory amount is correct");
			assertEquals(inventoryDistributed, productRow.getCell(soldColumnIndex).getNumericCellValue(),
					"Sold inventory amount is correct");
			assertEquals(changedInventory, productRow.getCell(balancedColumnIndex).getNumericCellValue(),
					"Balanced inventory amount is correct");
			assertEquals(endingInventory, productRow.getCell(closingColumnIndex).getNumericCellValue(),
					"Closing inventory amount is correct");
		}
	}
}
