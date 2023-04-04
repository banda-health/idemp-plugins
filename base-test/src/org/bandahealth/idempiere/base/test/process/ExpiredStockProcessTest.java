package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoeCreateEntity;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MStorageOnHand;
import org.compiere.process.DocumentEngine;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExpiredStockProcessTest extends ChuBoePopulateFactoryVO {
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
	public void canRunProcess() throws SQLException, IOException {
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
		valueObject.setDateOffset(-1);
		MAttributeSetInstance_BH expiredAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		expiredAttributeSetInstance.setGuaranteeDate(valueObject.getDate());
		expiredAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		expiredAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		expiredAttributeSetInstance.setDescription(valueObject.getScenarioName());
		expiredAttributeSetInstance.saveEx();
		valueObject.setAttributeSetInstance(expiredAttributeSetInstance);
		commitEx();

		valueObject.setStepName("Create product that has expired");
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		MProduct_BH expiredProduct = valueObject.getProduct();
		expiredProduct.setName(String.valueOf(valueObject.getRandomNumber()));
		expiredProduct.setM_AttributeSet_ID(attributeSet.get_ID());
		expiredProduct.saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Clean Expired Products");
		valueObject.setProcessUuid("e79541fb-9b70-4a10-bfef-7401401b8c56");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		ChuBoeCreateEntity.runProcess(valueObject);
		commitEx();

		MStorageOnHand productStorage = MStorageOnHand.get(valueObject.getContext(), valueObject.getProduct().get_ID(),
				valueObject.getWarehouse().getDefaultLocator().get_ID(), valueObject.getAttributeSetInstance().get_ID(), null,
				valueObject.getTransactionName());

		assertThat("The expired stock is zero", productStorage.getQtyOnHand().doubleValue(), is(0d));
	}
}
