package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.compiere.model.MOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertTrue;

public class OrderModelEventTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void orderIsCreatedCorrectlyWithModelEvents() throws Exception {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBP(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, null, true, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		MOrder order = valueObject.getOrder();

		assertTrue("Should have Sales Rep", order.getSalesRep_ID() > 0);
		assertTrue("Should have DocType", order.getDocTypeID() > 0);
		assertTrue("Should have DocTypeTarget", order.getC_DocTypeTarget_ID() > 0);
		assertTrue("Should have similar DocType and DocTypeTarget", order.getDocTypeID() == order.getC_DocTypeTarget_ID());
	}
}