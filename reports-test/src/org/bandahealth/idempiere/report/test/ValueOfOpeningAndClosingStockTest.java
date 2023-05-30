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
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.report.test.utils.NumberUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MInOutLine;
import org.compiere.model.X_M_AttributeSetExclude;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueOfOpeningAndClosingStockTest extends ChuBoePopulateFactoryVO {
	private final String reportUuid = "630fc1ab-0b64-459b-b10f-68549d21f507";

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

		BigDecimal productExpirationDate1PurchasePrice = new BigDecimal(12);
		BigDecimal productExpirationDate2PurchasePrice = new BigDecimal(13);
		BigDecimal productExpirationDate3PurchasePrice = new BigDecimal(14);
		BigDecimal productExpirationDate1QuantityReceived = new BigDecimal(15);
		BigDecimal productExpirationDate2QuantityReceived = new BigDecimal(20);
		BigDecimal productExpirationDate3QuantityReceived = new BigDecimal(25);
		BigDecimal productExpirationDate2QuantityAfterAdjustment = new BigDecimal(30);
		BigDecimal productSellingQuantity = new BigDecimal(60);

		valueObject.setStepName("Create business partner");
		valueObject.setPurchaseStandardPrice(productExpirationDate1PurchasePrice);
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

		valueObject.setStepName("Add exclusions for the attribute set");
		X_M_AttributeSetExclude attributeSetExclusion =
				new X_M_AttributeSetExclude(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetExclusion.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetExclusion.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetExclusion.setIsSOTrx(true);
		attributeSetExclusion.setAD_Table_ID(MOrderLine_BH.Table_ID);
		attributeSetExclusion.saveEx();

		attributeSetExclusion = new X_M_AttributeSetExclude(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetExclusion.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetExclusion.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetExclusion.setIsSOTrx(true);
		attributeSetExclusion.setAD_Table_ID(MInOutLine.Table_ID);
		attributeSetExclusion.saveEx();

		attributeSetExclusion = new X_M_AttributeSetExclude(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetExclusion.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetExclusion.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetExclusion.setIsSOTrx(true);
		attributeSetExclusion.setAD_Table_ID(MInventoryLine_BH.Table_ID);
		attributeSetExclusion.saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_AttributeSet_ID(attributeSet.get_ID());
		valueObject.getProduct().setName(String.valueOf(valueObject.getRandomNumber()));
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create attribute set instance with same guarantee date 1");
		valueObject.setRandom();
		MAttributeSetInstance_BH attributeSetInstanceTomorrow1 =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetInstanceTomorrow1.setGuaranteeDate(TimestampUtils.tomorrow());
		attributeSetInstanceTomorrow1.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetInstanceTomorrow1.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetInstanceTomorrow1.setDescription(valueObject.getScenarioName());
		attributeSetInstanceTomorrow1.saveEx();
		commitEx();

		valueObject.setStepName("Create attribute set instance with same guarantee date 2");
		valueObject.setRandom();
		MAttributeSetInstance_BH attributeSetInstanceTomorrow2 =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetInstanceTomorrow2.setGuaranteeDate(TimestampUtils.tomorrow());
		attributeSetInstanceTomorrow2.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetInstanceTomorrow2.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetInstanceTomorrow2.setDescription(valueObject.getScenarioName());
		attributeSetInstanceTomorrow2.saveEx();
		commitEx();

		valueObject.setStepName("Create attribute set instance with different guarantee date");
		valueObject.setRandom();
		MAttributeSetInstance_BH attributeSetInstanceFuture =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetInstanceFuture.setGuaranteeDate(ChuBoeCreateEntity.getDateOffset(TimestampUtils.tomorrow(), 2));
		attributeSetInstanceFuture.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetInstanceFuture.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetInstanceFuture.setDescription(valueObject.getScenarioName());
		attributeSetInstanceFuture.saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(productExpirationDate1QuantityReceived);
		valueObject.setPurchaseStandardPrice(productExpirationDate1PurchasePrice);
		valueObject.setAttributeSetInstance(attributeSetInstanceTomorrow1);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add same product with different expiration date to purchase order");
//		valueObject.getPriceListPO()
		MOrderLine_BH line = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		line.setAD_Org_ID(valueObject.getOrg().get_ID());
		line.setDescription(valueObject.getStepMessageLong());
		line.setC_Order_ID(valueObject.getOrder().get_ID());
		line.setM_Product_ID(valueObject.getProduct().get_ID());
		line.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		line.setM_AttributeSetInstance_ID(attributeSetInstanceTomorrow2.get_ID());
		line.setQty(productExpirationDate2QuantityReceived);
		line.setHeaderInfo(valueObject.getOrder());
		line.setPriceEntered(productExpirationDate2PurchasePrice);
		line.setPriceActual(productExpirationDate2PurchasePrice);
		line.setPriceList(productExpirationDate2PurchasePrice);
		line.setPriceLimit(productExpirationDate2PurchasePrice);
		line.saveEx();
		commitEx();

		valueObject.setStepName("Add same product with future expiration date to purchase order");
		line = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		line.setAD_Org_ID(valueObject.getOrg().get_ID());
		line.setDescription(valueObject.getStepMessageLong());
		line.setC_Order_ID(valueObject.getOrder().get_ID());
		line.setM_Product_ID(valueObject.getProduct().get_ID());
		line.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		line.setM_AttributeSetInstance_ID(attributeSetInstanceFuture.get_ID());
		line.setQty(productExpirationDate3QuantityReceived);
		line.setHeaderInfo(valueObject.getOrder());
		line.setPriceEntered(productExpirationDate3PurchasePrice);
		line.setPriceActual(productExpirationDate3PurchasePrice);
		line.setPriceList(productExpirationDate3PurchasePrice);
		line.setPriceLimit(productExpirationDate3PurchasePrice);
		line.saveEx();
		commitEx();

		valueObject.setStepName("Complete the purchase order");
		valueObject.getOrder().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Adjust inventory for product with second expiration date");
		valueObject.setQuantity(productExpirationDate2QuantityAfterAdjustment);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		valueObject.setAttributeSetInstance(attributeSetInstanceTomorrow2);
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(productSellingQuantity);
		valueObject.setAttributeSetInstance(null);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Run the storage clean-up process");
		valueObject.setProcessUuid("8e270648-1d54-46d9-9161-2d0300dd80ff");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialMovement, null, false, false, false);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("C_DocType_ID", valueObject.getDocumentType().get_ID(), null, null, null)));
		ChuBoeCreateEntity.runProcess(valueObject);

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
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
			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().equalsIgnoreCase(valueObject.getProduct().getName()))
					.sorted(Comparator.comparingDouble(row -> row.getCell(2).getNumericCellValue())).collect(Collectors.toList());

			assertEquals(3, productRows.size(), "Product rows exist");

			// Check the first row
			Row productRow = productRows.get(0);
			assertThat("Product expiration 1 opening value is correct", productRow.getCell(1).getNumericCellValue(),
					is(0D));
			assertThat("Product expiration 1 received value is correct", productRow.getCell(2).getNumericCellValue(),
					is(productExpirationDate1QuantityReceived.doubleValue()));
			assertThat("Product expiration 1 sold value is correct", productRow.getCell(3).getNumericCellValue(),
					is(productExpirationDate1QuantityReceived.doubleValue()));
			assertThat("Product expiration 1 balanced value is correct", productRow.getCell(4).getNumericCellValue(),
					is(0D));
			assertThat("Product expiration 1 closing value is correct", productRow.getCell(5).getNumericCellValue(),
					is(0D));
			assertThat("Product expiration 1 purchase price value is correct",
					productRow.getCell(6).getNumericCellValue(), is(productExpirationDate1PurchasePrice.doubleValue()));
			assertThat("Product expiration 1 closing stock value is correct",
					productRow.getCell(7).getNumericCellValue(), is(0D));

			// Check the second row
			productRow = productRows.get(1);
			assertThat("Product expiration 2 opening value is correct", productRow.getCell(1).getNumericCellValue(),
					is(0D));
			assertThat("Product expiration 2 received value is correct", productRow.getCell(2).getNumericCellValue(),
					is(productExpirationDate2QuantityReceived.doubleValue()));
			assertThat("Product expiration 2 sold value is correct", productRow.getCell(3).getNumericCellValue(),
					is(productExpirationDate2QuantityAfterAdjustment.doubleValue()));
			assertThat("Product expiration 2 balanced value is correct", productRow.getCell(4).getNumericCellValue(),
					is(productExpirationDate2QuantityAfterAdjustment.subtract(productExpirationDate2QuantityReceived)
							.doubleValue()));
			assertThat("Product expiration 2 closing value is correct", productRow.getCell(5).getNumericCellValue(),
					is(0D));
			assertThat("Product expiration 2 purchase price value is correct",
					productRow.getCell(6).getNumericCellValue(), is(productExpirationDate2PurchasePrice.doubleValue()));
			assertThat("Product expiration 2 closing stock value is correct",
					productRow.getCell(7).getNumericCellValue(), is(0D));

			// Check the third row
			productRow = productRows.get(2);
			BigDecimal product3SoldAmount = productSellingQuantity.subtract(productExpirationDate1QuantityReceived)
					.subtract(productExpirationDate2QuantityAfterAdjustment);
			BigDecimal product3RemainingAmount = productExpirationDate3QuantityReceived.subtract(product3SoldAmount);
			assertThat("Product expiration 3 opening value is correct", productRow.getCell(1).getNumericCellValue(),
					is(0D));
			assertThat("Product expiration 3 received value is correct", productRow.getCell(2).getNumericCellValue(),
					is(productExpirationDate3QuantityReceived.doubleValue()));
			assertThat("Product expiration 3 sold value is correct", productRow.getCell(3).getNumericCellValue(),
					is(product3SoldAmount.doubleValue()));
			assertThat("Product expiration 3 balanced value is correct", productRow.getCell(4).getNumericCellValue(),
					is(0D));
			assertThat("Product expiration 3 closing value is correct", productRow.getCell(5).getNumericCellValue(),
					is(product3RemainingAmount.doubleValue()));
			assertThat("Product expiration 3 purchase price value is correct",
					productRow.getCell(6).getNumericCellValue(), is(productExpirationDate3PurchasePrice.doubleValue()));
			assertThat("Product expiration 3 closing stock value is correct", productRow.getCell(7).getNumericCellValue(),
					is(product3RemainingAmount.doubleValue() * productExpirationDate3PurchasePrice.doubleValue()));
		}
	}

	@IPopulateAnnotation.CanRun
	public void duplicateProductQuantityDoesntAppearWhenSellingOnDifferentDays() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		BigDecimal productPurchasePrice = new BigDecimal(14);
		BigDecimal productQuantityReceived = new BigDecimal(25);
		BigDecimal productSellingQuantity = new BigDecimal(5);

		valueObject.setStepName("Create business partner");
		valueObject.setPurchaseStandardPrice(productPurchasePrice);
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
		valueObject.setQuantity(productQuantityReceived);
		valueObject.setPurchaseStandardPrice(productPurchasePrice);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(productSellingQuantity);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDateOffset(1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(productSellingQuantity);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
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
			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 30)))
					.sorted(Comparator.comparingDouble(row -> row.getCell(2).getNumericCellValue())).collect(Collectors.toList());

			assertEquals(1, productRows.size(), "Only one product row appears");
			Row productRow = productRows.get(0);
			assertThat("Product opening value is correct", productRow.getCell(1).getNumericCellValue(), is(0D));
			assertThat("Product received value is correct", productRow.getCell(2).getNumericCellValue(),
					is(productQuantityReceived.doubleValue()));
			assertThat("Product sold value is correct", productRow.getCell(3).getNumericCellValue(),
					is(productSellingQuantity.doubleValue() * 2));
			assertThat("Product balanced value is correct", productRow.getCell(4).getNumericCellValue(), is(0D));
			assertThat("Product closing value is correct", productRow.getCell(5).getNumericCellValue(), is(15D));
			assertThat("Product purchase price value is correct", productRow.getCell(6).getNumericCellValue(),
					is(productPurchasePrice.doubleValue()));
			assertThat("Product closing stock value is correct", productRow.getCell(7).getNumericCellValue(),
					is(15D * productPurchasePrice.doubleValue()));
		}
	}

	@IPopulateAnnotation.CanRun
	public void startingQuantityCorrectWhenRunOnOldPeriod() throws SQLException, IOException {
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
		valueObject.setDateOffset(-10);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(20));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of the shipment from the last purchase order");
		SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DB.executeUpdate(
				"UPDATE m_transaction SET created = '" + dbDateFormat.format(valueObject.getDate()) + "', updated = '" +
						dbDateFormat.format(valueObject.getDate()) +
						"' WHERE m_inoutline_id IN (SELECT m_inoutline_id FROM m_inoutline WHERE c_orderline_id IN (SELECT " +
						"c_orderline_id FROM c_orderline WHERE c_order_id = " + valueObject.getOrder().get_ID() + "))",
				valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDateOffset(5);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Update the updated & created dates of the shipment from the last sales order");
		DB.executeUpdate(
				"UPDATE m_transaction SET created = '" + dbDateFormat.format(valueObject.getDate()) + "', updated = '" +
						dbDateFormat.format(valueObject.getDate()) +
						"' WHERE m_inoutline_id IN (SELECT m_inoutline_id FROM m_inoutline WHERE c_orderline_id IN (SELECT " +
						"c_orderline_id FROM c_orderline WHERE c_order_id = " + valueObject.getOrder().get_ID() + "))",
				valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date",
						ChuBoeCreateEntity.getDateOffset(new Timestamp(System.currentTimeMillis()), -11), null, null, null),
				new ProcessInfoParameter("End Date",
						ChuBoeCreateEntity.getDateOffset(new Timestamp(System.currentTimeMillis()), -8), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().contains(valueObject.getProduct().getName().substring(0, 30)))
					.sorted(Comparator.comparingDouble(row -> row.getCell(2).getNumericCellValue())).collect(Collectors.toList());

			assertEquals(1, productRows.size(), "Only one product row appears");
			Row productRow = productRows.get(0);
			assertThat("Product opening value is correct", productRow.getCell(1).getNumericCellValue(), is(0D));
			assertThat("Product received value is correct", productRow.getCell(2).getNumericCellValue(), is(20D));
			assertThat("Product sold value is correct", productRow.getCell(3).getNumericCellValue(), is(0D));
			assertThat("Product balanced value is correct", productRow.getCell(4).getNumericCellValue(), is(0D));
			assertThat("Product closing value is correct", productRow.getCell(5).getNumericCellValue(), is(20D));
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
