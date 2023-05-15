package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;
import org.bandahealth.idempiere.base.test.modelevent.BusinessPartnerModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.InOutModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.InvoiceModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.OrderModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.ProductModelEventTest;
import org.bandahealth.idempiere.base.test.modelevent.UserModelEventTest;
import org.bandahealth.idempiere.base.test.process.CleanExpiredStockProcessTest;
import org.bandahealth.idempiere.base.test.process.InitialBandaClientSetupTest;

import java.util.ArrayList;
import java.util.List;

public class BandaBaseTestFactory implements IChuBoePopulateFactory {
	@Override
	public List<ChuBoePopulateFactoryVO> newChuBoePopulateInstance() {
		List<ChuBoePopulateFactoryVO> tests = new ArrayList<>();

		// Model Events
		tests.add(new BusinessPartnerModelEventTest());
		tests.add(new InOutModelEventTest());
		tests.add(new InvoiceModelEventTest());
		tests.add(new OrderModelEventTest());
		tests.add(new ProductModelEventTest());
		tests.add(new UserModelEventTest());

		// Processes
		tests.add(new InitialBandaClientSetupTest());
		tests.add(new CleanExpiredStockProcessTest());

		// Generic
		tests.add(new OrderTest());
		tests.add(new PaymentTest());

		return tests;
	}
}
