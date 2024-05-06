package org.bandahealth.idempiere.graphql.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;

import java.util.Collections;
import java.util.List;

public class GraphQLTestFactory implements IChuBoePopulateFactory {
	@Override
	public List<ChuBoePopulateFactoryVO> newChuBoePopulateInstance() {
		return Collections.singletonList(new BandaGraphQLDataPopulator());
	}
}
