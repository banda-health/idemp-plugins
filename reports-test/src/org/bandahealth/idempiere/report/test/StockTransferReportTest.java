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
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MMovementLine;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockTransferReportTest extends ChuBoePopulateFactoryVO {
	private static final String reportUU = "5a666f24-469a-43dc-865f-4053e0dd4fd6";

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
	public void movementDataAppearsOnTheReport() throws SQLException, IOException {
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
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Transfer inventory");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialMovement, null, false, false, false);
		var fromWarehouse = valueObject.getWarehouse();
		ChuBoeCreateEntity.changeWarehouse(valueObject);
		var toWarehouse = valueObject.getWarehouse();

		// create movement header
		MMovement_BH movement = new MMovement_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		movement.setAD_Org_ID(valueObject.getOrg().get_ID());
		movement.setDescription(valueObject.getStepMessageLong());
		movement.setC_DocType_ID(valueObject.getDocumentType().get_ID());
		movement.setMovementDate(valueObject.getDate());
		movement.setM_Warehouse_ID(fromWarehouse.get_ID());
		movement.setM_WarehouseTo_ID(toWarehouse.get_ID());
		movement.saveEx();

		// create movement line
		MMovementLine movementLine = new MMovementLine(valueObject.getContext(), 0, valueObject.getTransactionName());
		movementLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		movementLine.setDescription(valueObject.getStepMessageLong());
		movementLine.setM_Movement_ID(movement.get_ID());
		movementLine.setM_Product_ID(valueObject.getProduct().get_ID());
		movementLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		movementLine.setM_AttributeSetInstance_ID(
				valueObject.getAttributeSetInstance() == null ? 0 : valueObject.getAttributeSetInstance().get_ID());
		movementLine.setQtyEntered(Env.ONE);
		movementLine.setM_Locator_ID(fromWarehouse.getLocators(false)[0].get_ID());
		movementLine.setM_LocatorTo_ID(toWarehouse.getLocators(false)[0].get_ID());
		movementLine.saveEx();

		movement.setDocAction(valueObject.getDocumentAction());
		movement.processIt(valueObject.getDocumentAction());
		movement.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
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
			int productColumnIndex = TableUtils.getColumnIndex(headerRow, "Product");
			int movementQuantityWarehouseColumnIndex = TableUtils.getColumnIndex(headerRow, "Quantity");
			int sourceWarehouseColumnIndex = TableUtils.getColumnIndex(headerRow, "Source Store");
			int destinationWarehouseColumnIndex = TableUtils.getColumnIndex(headerRow, "Destination Store");

			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(productColumnIndex) != null && row.getCell(5).getCellType().equals(CellType.STRING) &&
									row.getCell(productColumnIndex).getStringCellValue().contains(valueObject.getProduct().getName()))
					.findFirst();
			assertTrue(productRow.isPresent(), "Product movement appears");
			assertEquals(fromWarehouse.getName(), productRow.get().getCell(sourceWarehouseColumnIndex).getStringCellValue(),
					"Source warehouse correct");
			assertEquals(toWarehouse.getName(),
					productRow.get().getCell(destinationWarehouseColumnIndex).getStringCellValue(),
					"Destination warehouse correct");
			assertEquals(1D, productRow.get().getCell(movementQuantityWarehouseColumnIndex).getNumericCellValue(),
					"Movement quantity is correct");
		}
	}
}
