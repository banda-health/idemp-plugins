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
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.process.ImportProductsProcess;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProductPrice;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsAndPricesTest extends ChuBoePopulateFactoryVO {
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

		valueObject.setStepName("Create attribute set to track expirations");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_AttributeSet_ID(attributeSet.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create valid attribute set instance");
		MAttributeSetInstance_BH
				validAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		validAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		validAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		validAttributeSetInstance.setDescription(valueObject.getScenarioName());
		validAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setAttributeSetInstance(validAttributeSetInstance);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().setPrice(new BigDecimal(20));
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.getOrder().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("3edf67b9-ee3d-4b73-a02e-deb1c1811db5");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(List.of(
				new ProcessInfoParameter("M_PriceList_UU", valueObject.getSalesPriceList().getM_PriceList_UU(), null, null,
						null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			int productNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int lastBuyingPriceColumnIndex = TableUtils.getColumnIndex(headerRow, "Last Buying Price");
			int sellingPriceColumnIndex = TableUtils.getColumnIndex(headerRow, "Selling Price");
			int totalQuantityColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Quantity");

			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(productNameColumnIndex) != null && row.getCell(productNameColumnIndex).getStringCellValue()
							.equalsIgnoreCase(valueObject.getProduct().getName())).findFirst();

			assertTrue(productRow.isPresent(), "Product row exists");
			assertThat("Last Buying Price is correct",
					productRow.get().getCell(lastBuyingPriceColumnIndex).getNumericCellValue(), is(20D));
			assertThat("Selling Price is correct", productRow.get().getCell(sellingPriceColumnIndex).getNumericCellValue(),
					is(50D));
			assertThat("Total price is correct", productRow.get().getCell(totalQuantityColumnIndex).getNumericCellValue(),
					is(1D));
		}
	}

	@IPopulateAnnotation.CanRun
	public void dataDisplayedCorrectly() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create attribute set to track expirations");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_AttributeSet_ID(attributeSet.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create valid attribute set instance");
		MAttributeSetInstance_BH
				validAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		validAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		validAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		validAttributeSetInstance.setDescription(valueObject.getScenarioName());
		validAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setAttributeSetInstance(validAttributeSetInstance);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("3edf67b9-ee3d-4b73-a02e-deb1c1811db5");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		// Get the number of products we should see on the report
		int productCount = new Query(valueObject.getContext(), MProduct_BH.Table_Name,
				MProduct_BH.COLUMNNAME_IsActive + "=? AND " + MProduct_BH.COLUMNNAME_ProductType + "=?",
				valueObject.getTransactionName()).setParameters("Y", "I").setClient_ID().count();

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			int reportProductCount = 0;
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			int headerRowIndex = TableUtils.getIndexOfRow(sheet, headerRow);
			int productNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				if (sheet.getRow(i).getCell(productNameColumnIndex).getCellType().equals(CellType.STRING) &&
						!sheet.getRow(i).getCell(productNameColumnIndex).getStringCellValue().isEmpty()) {
					reportProductCount++;
				}
			}
			assertEquals(productCount, reportProductCount, "All active products returned on the report");
		}
	}

	@IPopulateAnnotation.CanRun
	public void defaultPriceListIsUsedWhenNonePassedIn() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner 1");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create attribute set to track expirations");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create product 1");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_AttributeSet_ID(attributeSet.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Set default sales price");
		MPriceList defaultPriceList = new Query(valueObject.getContext(), MPriceList.Table_Name,
				MPriceList.COLUMNNAME_IsSOPriceList + "=? AND " + MPriceList.COLUMNNAME_IsDefault + "=?",
				valueObject.getTransactionName()).setParameters(true, true).first();
		MPriceListVersion salesPriceListVersion =
				new Query(valueObject.getContext(), MPriceListVersion.Table_Name, "M_PriceList_ID=?",
						valueObject.getTransactionName()).setClient_ID().setParameters(defaultPriceList.get_ID()).first();
		MProductPrice productSalesPrice = new MProductPrice(valueObject.getContext(), salesPriceListVersion.get_ID(),
				valueObject.getProduct().get_ID(), valueObject.getTransactionName());
		productSalesPrice.setPriceLimit(new BigDecimal(45));
		productSalesPrice.setPriceStd(new BigDecimal(45));
		productSalesPrice.setPriceList(new BigDecimal(45));
		productSalesPrice.saveEx();
		commitEx();

		valueObject.setStepName("Create valid attribute set instance 1");
		MAttributeSetInstance_BH
				validAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		validAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		validAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		validAttributeSetInstance.setDescription(valueObject.getScenarioName());
		validAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create order 1");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setAttributeSetInstance(validAttributeSetInstance);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("3edf67b9-ee3d-4b73-a02e-deb1c1811db5");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Row priceListRow = null;
			for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (StreamSupport.stream(row.spliterator(), false).anyMatch(
						cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
								cell.getStringCellValue().contains(defaultPriceList.getName()))) {
					priceListRow = row;
					break;
				}
			}

			assertNotNull(priceListRow, "Default price list is used");

			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			int productColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int sellingPriceColumnIndex = TableUtils.getColumnIndex(headerRow, "Selling Price");

			Optional<Row> product1Row = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(productColumnIndex) != null &&
									row.getCell(productColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(productColumnIndex).getStringCellValue().equals(valueObject.getProduct().getName()))
					.findFirst();
			assertTrue(product1Row.isPresent(), "First product appears on the report");
			assertEquals(45D, product1Row.get().getCell(sellingPriceColumnIndex).getNumericCellValue(),
					"Product shows the correct price");
		}
	}

	@IPopulateAnnotation.CanRun
	public void priceListIsUsedWhenOnePassedIn() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner 1");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create attribute set to track expirations");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create product 1");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_AttributeSet_ID(attributeSet.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Set default sales price");
		MPriceList defaultPriceList = new Query(valueObject.getContext(), MPriceList.Table_Name,
				MPriceList.COLUMNNAME_IsSOPriceList + "=? AND " + MPriceList.COLUMNNAME_IsDefault + "=?",
				valueObject.getTransactionName()).setParameters(true, true).first();
		MPriceListVersion salesPriceListVersion =
				new Query(valueObject.getContext(), MPriceListVersion.Table_Name, "M_PriceList_ID=?",
						valueObject.getTransactionName()).setClient_ID().setParameters(defaultPriceList.get_ID()).first();
		MProductPrice productSalesPrice = new MProductPrice(valueObject.getContext(), salesPriceListVersion.get_ID(),
				valueObject.getProduct().get_ID(), valueObject.getTransactionName());
		productSalesPrice.setPriceLimit(new BigDecimal(45));
		productSalesPrice.setPriceStd(new BigDecimal(45));
		productSalesPrice.setPriceList(new BigDecimal(45));
		productSalesPrice.saveEx();
		commitEx();

		valueObject.setStepName("Create valid attribute set instance 1");
		MAttributeSetInstance_BH
				validAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		validAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		validAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		validAttributeSetInstance.setDescription(valueObject.getScenarioName());
		validAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create order 1");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setAttributeSetInstance(validAttributeSetInstance);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("3edf67b9-ee3d-4b73-a02e-deb1c1811db5");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(List.of(
				new ProcessInfoParameter("M_PriceList_UU", valueObject.getSalesPriceList().getM_PriceList_UU(), null, null,
						null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Row priceListRow = null;
			for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (StreamSupport.stream(row.spliterator(), false).anyMatch(
						cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
								cell.getStringCellValue().contains(valueObject.getSalesPriceList().getName()))) {
					priceListRow = row;
					break;
				}
			}

			assertNotNull(priceListRow, "Non-default price list is used");

			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			int productColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int sellingPriceColumnIndex = TableUtils.getColumnIndex(headerRow, "Selling Price");

			Optional<Row> product1Row = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(productColumnIndex) != null &&
									row.getCell(productColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(productColumnIndex).getStringCellValue().equals(valueObject.getProduct().getName()))
					.findFirst();
			assertTrue(product1Row.isPresent(), "First product appears on the report");
			assertEquals(50D, product1Row.get().getCell(sellingPriceColumnIndex).getNumericCellValue(),
					"Product shows the correct price");
		}
	}
}
