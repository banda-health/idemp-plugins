package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventorySoldReportTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		BandaCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		BandaCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQty(new BigDecimal(30));
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		BandaCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BigDecimal quantitySold = new BigDecimal(20);
		valueObject.setQty(quantitySold);
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("1211e173-6f12-4e2f-bfcc-d43d48af51c3");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.lastMonth(), null, null, null),
				new ProcessInfoParameter("End Date", new Timestamp(System.currentTimeMillis()), null, null, null)
		));
		valueObject.setReportType("xlsx");
		BandaCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Optional<Row> productRow =
					StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(0) != null &&
							row.getCell(0).getStringCellValue().equalsIgnoreCase(valueObject.getProduct().getName())).findFirst();
			assertTrue(productRow.isPresent(), "Report contains product");
			assertThat("Quantity sold for this product is correct", productRow.get().getCell(1).getNumericCellValue(),
					is(quantitySold.doubleValue()));
			assertThat("Selling price for this product is correct", productRow.get().getCell(2).getNumericCellValue(),
					is(valueObject.getStdPriceSO().doubleValue()));
			assertThat("Income for this product is correct", productRow.get().getCell(3).getNumericCellValue(),
					is(quantitySold.doubleValue() * valueObject.getStdPriceSO().doubleValue()));
			assertThat("Purchase price for this product is correct", productRow.get().getCell(4).getNumericCellValue(),
					is(valueObject.getStdPriceSO().doubleValue()));
			assertThat("COGS for this product is correct", productRow.get().getCell(5).getNumericCellValue(),
					is(valueObject.getStdPricePO().doubleValue() * quantitySold.doubleValue()));
			assertThat("Gross profit for this product is correct", productRow.get().getCell(6).getNumericCellValue(),
					is((valueObject.getStdPriceSO().doubleValue() - valueObject.getStdPricePO().doubleValue()) *
							quantitySold.doubleValue()));
		}
	}
}
