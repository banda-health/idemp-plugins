package org.bandahealth.idempiere.base;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;
import org.bandahealth.idempiere.base.modelevent.BusinessPartnerModelEventTest;
import org.bandahealth.idempiere.base.modelevent.OrderModelEventTest;
import org.bandahealth.idempiere.base.modelevent.PaymentModelEventTest;
import org.bandahealth.idempiere.base.modelevent.ProductModelEventTest;
import org.bandahealth.idempiere.base.modelevent.UserModelEventTest;

import java.util.ArrayList;
import java.util.List;

public class BandaHealthBaseTestFactory implements IChuBoePopulateFactory {
	@Override
	public List<ChuBoePopulateFactoryVO> newChuBoePopulateInstance() {
		List<ChuBoePopulateFactoryVO> tests = new ArrayList<>();

		tests.add(new BusinessPartnerModelEventTest());
		tests.add(new OrderModelEventTest());
		tests.add(new PaymentModelEventTest());
		tests.add(new ProductModelEventTest());
		tests.add(new UserModelEventTest());

		return tests;
	}
}
