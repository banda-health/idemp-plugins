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
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostOfGoodsSoldTest extends ChuBoePopulateFactoryVO {
	private final String inventorySoldReportUuid = "1211e173-6f12-4e2f-bfcc-d43d48af51c3";
	private final String incomeStatementReportUuid = "8ea6c947-4450-48dd-8bd0-76b0f307dcb0";

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
	public void dataTheSameOnInventorySoldAndIncomeStatement() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createPatient(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
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

		valueObject.setStepName("Create attribute set instance");
		valueObject.setRandom();
		MAttributeSetInstance_BH attributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetInstance.setGuaranteeDate(TimestampUtils.tomorrow());
		attributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetInstance.setDescription(valueObject.getScenarioName());
		attributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setAttributeSetInstance(attributeSetInstance);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(50000));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setAttributeSetInstance(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(900));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the inventory sold report");
		valueObject.setProcessUuid(inventorySoldReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		double costOfGoodsSold;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Product Name");
			int costOfGoodsSoldColumnIndex = TableUtils.getColumnIndex(headerRow, "Cost of Goods Sold");

			costOfGoodsSold = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().equals("Total")))
					.findFirst().map(row -> row.getCell(costOfGoodsSoldColumnIndex).getNumericCellValue()).orElse(0.0);
		}

		valueObject.setStepName("Generate the income statement report");
		valueObject.setProcessUuid(incomeStatementReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Item");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			Optional<Row> productPurchasesRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Product Purchases")))
					.findFirst();
			assertEquals(costOfGoodsSold * -1,
					productPurchasesRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0),
					"Cost of goods sold amount is correct");
		}
	}
}
