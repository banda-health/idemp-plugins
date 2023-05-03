package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
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

public class StockToBeOrderedTest extends ChuBoePopulateFactoryVO {
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

		valueObject.setStepName("Create product 1");
		ChuBoeCreateEntity.createProduct(valueObject);
		MProduct_BH product1 = valueObject.getProduct();
		product1.setbh_reorder_level(10);
		product1.setbh_reorder_quantity(20);
		product1.saveEx();
		commitEx();

		valueObject.setStepName("Create a purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create product 2");
		valueObject.setProduct(null);
		valueObject.setRandom();
		ChuBoeCreateEntity.createProduct(valueObject);
		MProduct_BH product2 = valueObject.getProduct();
		product2.setbh_reorder_level(30);
		product2.setbh_reorder_quantity(40);
		product2.saveEx();
		commitEx();

		valueObject.setStepName("Add product 2 to purchase order");
		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(valueObject.getOrder().get_ID());
		orderLine.setM_Product_ID(product2.get_ID());
		orderLine.setC_UOM_ID(product2.getC_UOM_ID());
		orderLine.setM_AttributeSetInstance_ID(0);
		orderLine.setQty(new BigDecimal(100));
		orderLine.setHeaderInfo(valueObject.getOrder());
		orderLine.setPrice();
		orderLine.saveEx();
		commitEx();

		valueObject.getOrder().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setProduct(product1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(95));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add product 2 to sales order");
		orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(valueObject.getOrder().get_ID());
		orderLine.setM_Product_ID(product2.get_ID());
		orderLine.setC_UOM_ID(product2.getC_UOM_ID());
		orderLine.setM_AttributeSetInstance_ID(0);
		orderLine.setQty(new BigDecimal(60));
		orderLine.setHeaderInfo(valueObject.getOrder());
		orderLine.setPrice();
		orderLine.saveEx();
		commitEx();

		valueObject.getOrder().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("03ba009a-68bb-4b12-a5bc-e58a9bce1545");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Optional<Row> product1Row =
					StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().equalsIgnoreCase(product1.getName())).findFirst();
			Optional<Row> product2Row =
					StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().equalsIgnoreCase(product2.getName())).findFirst();

			assertTrue(product1Row.isPresent(), "Product 1 row exists");
			assertTrue(product2Row.isEmpty(), "Product 2 row is missing");
			assertThat("Existing quantity is correct", product1Row.get().getCell(1).getNumericCellValue(), is(5D));
			assertThat("Reorder level is correct", product1Row.get().getCell(2).getNumericCellValue(), is(10D));
			assertThat("Amount to order is correct", product1Row.get().getCell(3).getNumericCellValue(), is(20D));
		}
	}

	@IPopulateAnnotation.CanRun
	public void cleanedInventoryAppears() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product 1");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().setbh_reorder_level(10);
		valueObject.getProduct().setbh_reorder_quantity(20);
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create a purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Update storage on hand DB created date so it can be cleaned");
		DB.executeUpdate("UPDATE m_storageonhand SET created = created - '7 days'::interval WHERE m_product_id = " +
				valueObject.getProduct().get_ID(), valueObject.getTransactionName());

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Clean the inventory");
		valueObject.setProcessTableId(0);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessUuid("8e270648-1d54-46d9-9161-2d0300dd80ff");
		ChuBoeCreateEntity.runProcess(valueObject);

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("03ba009a-68bb-4b12-a5bc-e58a9bce1545");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(0) != null &&
									row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 20)))
					.findFirst();

			assertTrue(productRow.isPresent(), "Product row exists");
			assertThat("Existing quantity is correct", productRow.get().getCell(1).getNumericCellValue(), is(0D));
			assertThat("Reorder level is correct", productRow.get().getCell(2).getNumericCellValue(), is(10D));
			assertThat("Amount to order is correct", productRow.get().getCell(3).getNumericCellValue(), is(20D));
		}
	}

	@IPopulateAnnotation.CanRun
	public void productsDontAppearMultipleTimes() throws SQLException, IOException {
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
		attributeSet.setIsGuaranteeDate(true);
		attributeSet.setIsGuaranteeDateMandatory(true);
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create expired attribute set instance");
		valueObject.setRandom();
		MAttributeSetInstance_BH expiredAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		expiredAttributeSetInstance.setGuaranteeDate(TimestampUtils.yesterday());
		expiredAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		expiredAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		expiredAttributeSetInstance.setDescription(valueObject.getScenarioName());
		expiredAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create valid attribute set instance 1");
		valueObject.setRandom();
		MAttributeSetInstance_BH firstValidAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		firstValidAttributeSetInstance.setGuaranteeDate(TimestampUtils.tomorrow());
		firstValidAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		firstValidAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		firstValidAttributeSetInstance.setDescription(valueObject.getScenarioName());
		firstValidAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create valid attribute set instance 2");
		valueObject.setRandom();
		MAttributeSetInstance_BH secondValidAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		secondValidAttributeSetInstance.setGuaranteeDate(TimestampUtils.addToNow(Calendar.MONTH, 1));
		secondValidAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		secondValidAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		secondValidAttributeSetInstance.setDescription(valueObject.getScenarioName());
		secondValidAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(valueObject.getRandomNumber() + valueObject.getProduct().getName());
		valueObject.getProduct().setbh_reorder_level(10);
		valueObject.getProduct().setbh_reorder_quantity(20);
		valueObject.getProduct().setM_AttributeSet_ID(attributeSet.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create first purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(3));
		valueObject.setAttributeSetInstance(firstValidAttributeSetInstance);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(4));
		valueObject.setAttributeSetInstance(secondValidAttributeSetInstance);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create third purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(2));
		valueObject.setAttributeSetInstance(expiredAttributeSetInstance);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("03ba009a-68bb-4b12-a5bc-e58a9bce1545");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(0) != null &&
									row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 20)))
					.collect(Collectors.toList());

			assertEquals(1, productRows.size(), "Product only appears once");
			assertThat("Existing quantity is correct", productRows.get(0).getCell(1).getNumericCellValue(), is(7D));
		}
	}
}
