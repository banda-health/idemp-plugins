package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.report.test.utils.NumberUtils;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

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

		valueObject.setStepName("Create product 1");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(String.valueOf(valueObject.getRandomNumber()));
		String product1Name = valueObject.getProduct().getName();
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create product 2");
		valueObject.clearProduct();
		valueObject.setRandom();
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
		line.setM_AttributeSetInstance_ID(0);
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
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(endingProduct2Inventory);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, null, false, false, false);
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("58ae2bdf-0e80-46f2-860f-2ae070fc82d2");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		ChuBoeCreateEntity.runReport(valueObject);
		commitEx();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Product 2 is on the report", reportContent, containsString(product2Name));
		assertThat("Product 2 starting inventory count is on the report", reportContent,
				containsString(String.valueOf(startingProduct2Inventory.intValue())));
		assertThat("Product 2 ending inventory count is on the report", reportContent,
				containsString(String.valueOf(endingProduct2Inventory.intValue())));
		assertThat("Product 2 inventory change amount is on the report", reportContent,
				containsString(String.valueOf(endingProduct2Inventory.subtract(startingProduct2Inventory).intValue())));
		assertThat("Product 1 is not on the report", reportContent, not(containsString(product1Name)));
	}
}
