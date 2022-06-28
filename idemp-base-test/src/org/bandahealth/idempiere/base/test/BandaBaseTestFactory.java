package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;
import org.bandahealth.idempiere.base.test.modelevent.BusinessPartnerModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.OrderLineModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.OrderModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.PaymentModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.ProductModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.UserModelEventTest;
import org.bandahealth.idempiere.base.test.process.SalesProcessTest;

import java.util.ArrayList;
import java.util.List;

public class BandaBaseTestFactory implements IChuBoePopulateFactory {
	@Override
	public List<ChuBoePopulateFactoryVO> newChuBoePopulateInstance() {
		List<ChuBoePopulateFactoryVO> tests = new ArrayList<>();

		// Model Events
		tests.add(new BusinessPartnerModelEventTest());
		tests.add(new OrderLineModelEventTest());
		tests.add(new OrderModelEventTest());
		tests.add(new PaymentModelEventTest());
		tests.add(new ProductModelEventTest());
		tests.add(new UserModelEventTest());

		// Processes
		tests.add(new SalesProcessTest());

		return tests;
	}
}
