package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.compiere.process.DocumentEngine;

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

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException, ParseException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		BandaCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product 1");
		BandaCreateEntity.createProduct(valueObject);
		MProduct_BH product1 = valueObject.getProductBH();
		product1.setbh_reorder_level(10);
		product1.setbh_reorder_quantity(20);
		product1.saveEx();
		commitEx();

		valueObject.setStepName("Create a purchase order");
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQty(new BigDecimal(100));
		BandaCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Create product 2");
		valueObject.setProduct(null);
		valueObject.setRandom();
		BandaCreateEntity.createProduct(valueObject);
		MProduct_BH product2 = valueObject.getProductBH();
		product2.setbh_reorder_level(30);
		product2.setbh_reorder_quantity(40);
		product2.saveEx();
		commitEx();

		valueObject.setStepName("Add product 2 to purchase order");
		MOrderLine_BH line = new MOrderLine_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		line.setAD_Org_ID(valueObject.getOrg().get_ID());
		line.setDescription(valueObject.getStepMsgLong());
		line.setC_Order_ID(valueObject.getOrder().get_ID());
		line.setM_Product_ID(product2.get_ID());
		line.setC_UOM_ID(product2.getC_UOM_ID());
		line.setM_AttributeSetInstance_ID(0);
		line.setQty(new BigDecimal(100));
		line.setHeaderInfo(valueObject.getOrder());
		line.setPrice();
		line.saveEx();
		commitEx();

		valueObject.getOrder().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		BandaCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setProduct(product1);
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQty(new BigDecimal(95));
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add product 2 to sales order");
		line = new MOrderLine_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		line.setAD_Org_ID(valueObject.getOrg().get_ID());
		line.setDescription(valueObject.getStepMsgLong());
		line.setC_Order_ID(valueObject.getOrder().get_ID());
		line.setM_Product_ID(product2.get_ID());
		line.setC_UOM_ID(product2.getC_UOM_ID());
		line.setM_AttributeSetInstance_ID(0);
		line.setQty(new BigDecimal(60));
		line.setHeaderInfo(valueObject.getOrder());
		line.setPrice();
		line.saveEx();
		commitEx();

		valueObject.getOrder().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("03ba009a-68bb-4b12-a5bc-e58a9bce1545");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setReportType("xlsx");
		BandaCreateEntity.runReport(valueObject);

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
