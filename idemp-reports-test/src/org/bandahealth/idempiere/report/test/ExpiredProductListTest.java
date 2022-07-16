package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExpiredProductListTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		BandaCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create attribute set to track expirations");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setIsGuaranteeDate(true);
		attributeSet.setIsGuaranteeDateMandatory(true);
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create expired attribute set instance");
		valueObject.setRandom();
		MAttributeSetInstance_BH expiredAttributeSetInstance = new MAttributeSetInstance_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		expiredAttributeSetInstance.setGuaranteeDate(TimestampUtils.yesterday());
		expiredAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		expiredAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		expiredAttributeSetInstance.setDescription(valueObject.getScenarioName());
		expiredAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create valid attribute set instance");
		valueObject.setRandom();
		MAttributeSetInstance_BH validAttributeSetInstance = new MAttributeSetInstance_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		validAttributeSetInstance.setGuaranteeDate(TimestampUtils.tomorrow());
		validAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		validAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		validAttributeSetInstance.setDescription(valueObject.getScenarioName());
		validAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create imperishable product");
		BandaCreateEntity.createProduct(valueObject);
		String imperishableProductName = String.valueOf(valueObject.getRandom());
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setRandom();
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQty(new BigDecimal(10));
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create perishable product that has expired");
		valueObject.setRandom();
		valueObject.setProduct(null);
		BandaCreateEntity.createProduct(valueObject);
		MProduct_BH expiredProduct = valueObject.getProductBH();
		String expiredProductNameSuffix = String.valueOf(valueObject.getRandom());
		expiredProduct.setM_AttributeSet_ID(attributeSet.get_ID());
		expiredProduct.saveEx();
		commitEx();

		valueObject.setStepName("Add expired product to purchase order");
		MOrderLine_BH line = new MOrderLine_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		line.setAD_Org_ID(valueObject.getOrg().get_ID());
		line.setDescription(valueObject.getStepMsgLong());
		line.setC_Order_ID(valueObject.getOrder().get_ID());
		line.setM_Product_ID(expiredProduct.get_ID());
		line.setC_UOM_ID(expiredProduct.getC_UOM_ID());
		line.setM_AttributeSetInstance_ID(expiredAttributeSetInstance.get_ID());
		line.setQty(new BigDecimal(10));
		line.setHeaderInfo(valueObject.getOrder());
		line.setPrice();
		line.saveEx();
		commitEx();

		valueObject.setStepName("Create perishable product that hasn't expired");
		valueObject.setRandom();
		valueObject.setProduct(null);
		BandaCreateEntity.createProduct(valueObject);
		MProduct_BH validProduct = valueObject.getProductBH();
		String validProductNameSuffix = String.valueOf(valueObject.getRandom());
		validProduct.setM_AttributeSet_ID(attributeSet.get_ID());
		validProduct.saveEx();
		commitEx();

		valueObject.setStepName("Add valid product to purchase order");
		line = new MOrderLine_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		line.setAD_Org_ID(valueObject.getOrg().get_ID());
		line.setDescription(valueObject.getStepMsgLong());
		line.setC_Order_ID(valueObject.getOrder().get_ID());
		line.setM_Product_ID(expiredProduct.get_ID());
		line.setC_UOM_ID(expiredProduct.getC_UOM_ID());
		line.setM_AttributeSetInstance_ID(validAttributeSetInstance.get_ID());
		line.setQty(new BigDecimal(10));
		line.setHeaderInfo(valueObject.getOrder());
		line.setPrice();
		line.saveEx();
		commitEx();

		valueObject.setStepName("Complete the purchase order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		BandaCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		BandaCreateEntity.runReport(valueObject);
		commitEx();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("The imperishable product isn't on the report", reportContent, not(containsString(imperishableProductName)));
		assertThat("The valid product isn't on the report", reportContent, not(containsString(validProductNameSuffix)));
		assertThat("The expired is on the report", reportContent, containsString(expiredProductNameSuffix));
	}
}
