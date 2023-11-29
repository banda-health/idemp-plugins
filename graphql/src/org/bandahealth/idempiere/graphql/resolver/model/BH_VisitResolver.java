package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.AttributeSetDataLoader;
import org.compiere.model.MAttributeSet;
import org.compiere.model.MAttributeSetInstance;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class BH_VisitResolver implements GraphQLResolver<MBHVisit> {

	public CompletableFuture<MOrder_BH> C_Order(MBHVisit entity,
			DataFetchingEnvironment environment) {
		final DataLoader<Integer, MOrder_BH> orderDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(C_OrderDataLoader.C_ORDER_BY_BH_VISIT_ID_DATA_LOADER);
		return orderDataLoader.load(entity.get_ID());
	}
}
