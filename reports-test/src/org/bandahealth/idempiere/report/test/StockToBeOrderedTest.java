package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.process.DocumentEngine;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
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
}
