package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDDOrderLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;
import org.eevolution.model.MDDOrder;
import org.eevolution.model.MDDOrderLine;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MDDOrderResolver extends X_DD_OrderResolver {

	public CompletableFuture<List<MDDOrderLine>> DD_OrderLines(MDDOrder entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDDOrderLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDDOrderLineDataLoader.DATALOADER_DD_OrderLine_BY_DD_Order_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getDD_Order_ID()));
	}
}
