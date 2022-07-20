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
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MInOutLine;
import org.compiere.model.X_M_AttributeSetExclude;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
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
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
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
		valueObject.setProcessUuid("630fc1ab-0b64-459b-b10f-68549d21f507");
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
}
