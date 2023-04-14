package org.bandahealth.idempiere.rest.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;

import java.util.Collections;
import java.util.List;

public class RestTestFactory implements IChuBoePopulateFactory {
	@Override
	public List<ChuBoePopulateFactoryVO> newChuBoePopulateInstance() {
		return Collections.singletonList(new BandaRestDataPopulator());
	}
}
