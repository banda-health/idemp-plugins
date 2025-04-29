package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.assertion.ChuBoeAssert;
import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.compiere.model.MStorageOnHand;
import org.compiere.process.DocumentEngine;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResetStockProcessTest extends ChuBoePopulateFactoryVO {
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

		valueObject.setStepName("Create attribute set instance");
		valueObject.setRandom();
		valueObject.setDateOffset(1);
		MAttributeSetInstance_BH attributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		attributeSetInstance.setGuaranteeDate(valueObject.getDate());
		attributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		attributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSetInstance.setDescription(valueObject.getScenarioName());
		attributeSetInstance.saveEx();
		valueObject.setAttributeSetInstance(attributeSetInstance);
		commitEx();

		valueObject.setStepName("Create product 1");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName(String.valueOf(valueObject.getRandomNumber()));
		valueObject.getProduct().setM_AttributeSet_ID(attributeSet.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create product 2");
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Reset products");
		valueObject.setProcessUuid("25239635-591f-4940-bfb4-46533068af7d");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		ChuBoeCreateEntity.runProcess(valueObject);
		commitEx();

		addAssertionSQL("""
				SELECT
					'All products are reset' AS name,
					NOT EXISTS(
						SELECT *
						FROM
							(
								SELECT
								  m_product_id,
								  m_locator_id,
								  m_attributesetinstance_id,
								  SUM(qtyonhand) AS qtyonhand
								FROM
								  m_storageonhand
								WHERE
								  ad_client_id =""" + valueObject.getClient().get_ID() + """
								GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
					    ) t
					  WHERE
					    t.qtyonhand != 0
					)                        AS result;""");

		ChuBoeAssert.executeSQLAsserts(getAssertionSQL(), valueObject.getContext(), valueObject.getTransactionName());
	}
}
