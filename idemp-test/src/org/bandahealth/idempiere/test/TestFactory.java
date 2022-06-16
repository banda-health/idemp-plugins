package org.bandahealth.idempiere.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;

import java.util.ArrayList;
import java.util.List;

public class TestFactory implements IChuBoePopulateFactory {
	@Override
	public List<ChuBoePopulateFactoryVO> newChuBoePopulateInstance() {
		List<ChuBoePopulateFactoryVO> tests = new ArrayList<>();

		tests.add(new CreateClientTest());

		return tests;
	}
}
