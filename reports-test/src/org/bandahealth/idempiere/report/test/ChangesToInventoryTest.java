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
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangesToInventoryTest extends ChuBoePopulateFactoryVO {
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

		valueObject.setStepName("Create attribute set");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create product 1");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(String.valueOf(valueObject.getRandomNumber()));
		String product1Name = valueObject.getProduct().getName();
		valueObject.getProduct().saveEx();
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

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create product 2");
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(String.valueOf(valueObject.getRandomNumber()));
		String product2Name = valueObject.getProduct().getName();
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Add another product to purchase order");
		MOrderLine_BH line = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		BigDecimal startingProduct2Inventory = NumberUtils.randomBigDecimal(1, 250);
		line.setAD_Org_ID(valueObject.getOrg().get_ID());
		line.setDescription(valueObject.getStepMessageLong());
		line.setC_Order_ID(valueObject.getOrder().get_ID());
		line.setM_Product_ID(valueObject.getProduct().get_ID());
		line.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		line.setM_AttributeSetInstance_ID(attributeSetInstance.get_ID());
		line.setQty(startingProduct2Inventory);
		line.setHeaderInfo(valueObject.getOrder());
		line.setPrice();
		line.saveEx();
		commitEx();

		valueObject.setStepName("Complete the purchase order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Adjust inventory for product 2");
		BigDecimal endingProduct2Inventory = NumberUtils.randomBigDecimal(1, 250);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setQuantity(endingProduct2Inventory);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		ChuBoeCreateEntity.createInventory(valueObject);
		valueObject.getInventory().setbh_update_reason(MInventory_BH.BH_UPDATE_REASON_DamagedProducts);
		valueObject.getInventory().saveEx();
		Timestamp inventoryAdjustmentTime = valueObject.getInventory().getUpdated();
		commitEx();

		valueObject.setStepName("Complete the inventory adjustment");
		valueObject.getInventory().setDocAction(MInventory_BH.DOCACTION_Complete);
		assertTrue(valueObject.getInventory().processIt(MInventory_BH.DOCACTION_Complete), "Inventory was completed");
		valueObject.getInventory().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("58ae2bdf-0e80-46f2-860f-2ae070fc82d2");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Product");
			int productColumnIndex = TableUtils.getColumnIndex(headerRow, "Product");
			int quantityChangedColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Quantity");
			int stockLevelAtTimeOfReportColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Stock Level at");
			int changeFromColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Change From");
			int changeToColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Change To");
			int dateAndTimeChangedColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Date and Time");
			TableUtils.getColumnIndex(headerRow, "Changed By");
			TableUtils.getColumnIndex(headerRow, "Reason for Change");

			List<Row> product1Rows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(productColumnIndex) != null &&
							row.getCell(productColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(productColumnIndex).getStringCellValue().contains(product1Name)).collect(Collectors.toList());
			assertEquals(0, product1Rows.size(), "Product 1 is not on the report");

			List<Row> product2Rows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(productColumnIndex) != null &&
							row.getCell(productColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(productColumnIndex).getStringCellValue().contains(product2Name)).collect(Collectors.toList());
			assertEquals(1, product2Rows.size(), "Product 2 is not on the report");

			Row product2Row = product2Rows.get(0);
			assertEquals(endingProduct2Inventory.subtract(startingProduct2Inventory).intValue(),
					product2Row.getCell(quantityChangedColumnIndex).getNumericCellValue(),
					"Product 2 inventory change amount is correct");
			assertEquals(endingProduct2Inventory.intValue(),
					product2Row.getCell(stockLevelAtTimeOfReportColumnIndex).getNumericCellValue(),
					"Product 2 current stock level is correct");
			assertEquals(startingProduct2Inventory.intValue(),
					product2Row.getCell(changeFromColumnIndex).getNumericCellValue(),
					"Product 2 starting inventory count is correct");
			assertEquals(endingProduct2Inventory.intValue(), product2Row.getCell(changeToColumnIndex).getNumericCellValue(),
					"Product 2 ending inventory count is on the report");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			assertEquals(dateFormat.format(inventoryAdjustmentTime),
					dateFormat.format(product2Row.getCell(dateAndTimeChangedColumnIndex).getDateCellValue()),
					"Adjustment time is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void inventoryChangesRespectDateTimeFilters() throws SQLException, IOException {
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

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		valueObject.setDateOffset(-1);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		Timestamp earlyDate = TimestampUtils.startOfYesterday();
		Timestamp beginDate = TimestampUtils.add(earlyDate, Calendar.HOUR, 2);
		Timestamp endDate = TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, 2);
		Timestamp lateDate = TimestampUtils.add(endDate, Calendar.DAY_OF_YEAR, 2);

		valueObject.setStepName("Adjust inventory for product");
		BigDecimal firstEndingInventory = NumberUtils.randomBigDecimal(1, 250);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(firstEndingInventory);
		valueObject.setDateOffset(1);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		valueObject.setProduct(product);
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of that last inventory adjustment");
		SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DB.executeUpdate("UPDATE m_inventory SET created = '" + dbDateFormat.format(earlyDate) + "', updated = '" +
						dbDateFormat.format(earlyDate) + "' WHERE m_inventory_id = " + valueObject.getInventory().get_ID(),
				valueObject.getTransactionName());
		DB.executeUpdate("UPDATE m_transaction SET created = '" + dbDateFormat.format(earlyDate) + "', updated = '" +
				dbDateFormat.format(earlyDate) +
				"' WHERE m_inventoryline_id IN (SELECT m_inventoryline_id FROM m_inventoryline WHERE m_inventory_id = " +
				valueObject.getInventory().get_ID() + ")", valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Adjust inventory for product again");
		BigDecimal secondEndingInventory = NumberUtils.randomBigDecimal(20, 250);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(secondEndingInventory);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setbh_primaryuncodeddiagnosis("pain");
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(15));
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

		valueObject.setStepName("Adjust inventory for product for the last time");
		BigDecimal currentInventory = NumberUtils.randomBigDecimal(1, 250);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(currentInventory);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of that last inventory adjustment");
		DB.executeUpdate("UPDATE m_inventory SET created = '" + dbDateFormat.format(lateDate) + "', updated = '" +
						dbDateFormat.format(lateDate) + "' WHERE m_inventory_id = " + valueObject.getInventory().get_ID(),
				valueObject.getTransactionName());
		DB.executeUpdate("UPDATE m_transaction SET created = '" + dbDateFormat.format(lateDate) + "', updated = '" +
				dbDateFormat.format(lateDate) +
				"' WHERE m_inventoryline_id IN (SELECT m_inventoryline_id FROM m_inventoryline WHERE m_inventory_id = " +
				valueObject.getInventory().get_ID() + ")", valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("58ae2bdf-0e80-46f2-860f-2ae070fc82d2");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		int secondChange = secondEndingInventory.intValue() - firstEndingInventory.intValue();
		int thirdChange = thirdEndingInventory.intValue() - secondEndingInventory.intValue() + 15;

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Product");
			int productColumnIndex = TableUtils.getColumnIndex(headerRow, "Product");
			int quantityChangedColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Quantity");
			int stockLevelAtTimeOfReportColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Stock Level at");
			int changeFromColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Change From");
			int changeToColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Change To");

			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(productColumnIndex) != null &&
									row.getCell(productColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(productColumnIndex).getStringCellValue().contains(product.getName()))
					.collect(Collectors.toList());
			assertEquals(2, productRows.size(), "Only 2 adjustments are on the report");

			Row productRow = productRows.get(0);
			assertEquals(secondChange, productRow.getCell(quantityChangedColumnIndex).getNumericCellValue(),
					"First inventory change amount is correct");
			assertEquals(currentInventory.intValue(),
					productRow.getCell(stockLevelAtTimeOfReportColumnIndex).getNumericCellValue(),
					"Product current stock level is correct on the first row");
			assertEquals(firstEndingInventory.intValue(), productRow.getCell(changeFromColumnIndex).getNumericCellValue(),
					"First starting inventory count is correct");
			assertEquals(secondEndingInventory.intValue(), productRow.getCell(changeToColumnIndex).getNumericCellValue(),
					"First ending inventory count is on the report");

			productRow = productRows.get(1);
			assertEquals(thirdChange, productRow.getCell(quantityChangedColumnIndex).getNumericCellValue(),
					"Second inventory change amount is correct");
			assertEquals(currentInventory.intValue(),
					productRow.getCell(stockLevelAtTimeOfReportColumnIndex).getNumericCellValue(),
					"Product current stock level is correct on the second row");
			assertEquals(secondEndingInventory.intValue() - 15,
					productRow.getCell(changeFromColumnIndex).getNumericCellValue(), "First starting inventory count is " +
							"correct");
			assertEquals(thirdEndingInventory.intValue(), productRow.getCell(changeToColumnIndex).getNumericCellValue(),
					"Second ending inventory count is on the report");
		}
	}
}
