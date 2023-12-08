package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.input.M_BH_VisitInput;

public class M_BH_VisitMutation extends X_BH_VisitMutation {
	public MBHVisit BH_VisitSaveAndProcess(M_BH_VisitInput visitInput, DataFetchingEnvironment environment) {
//		var savedVisit = super.BH_VisitSave(visitInput);
//		visitInput.getC_Orders().forEach(order -> {
//			order.setBH_Visit_ID(visitInput.get_ID());
//			order.saveEx();
//		});
		return visitInput;
	}

	public MBHVisit BH_VisitProcess(String uuid, DataFetchingEnvironment environment) {
		// Update the cache if anything there
		return new MBHVisit(BandaGraphQLContext.getCtx(environment), 0, null);
	}
}
