package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;
import org.eevolution.model.MDDOrderLine;

import java.util.List;
import java.util.Properties;

public class MDDOrderLineDataLoader extends X_DD_OrderLineDataLoader {
	public static String DATALOADER_DD_OrderLine_BY_DD_Order_ID = "DATALOADER_DD_OrderLine_BY_DD_Order_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_DD_OrderLine_BY_DD_Order_ID,
				DataLoader.newMappedDataLoader(getByDDOrderIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MDDOrderLine>> getByDDOrderIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MDDOrderLine::getDD_Order_ID,
				MDDOrderLine.COLUMNNAME_DD_Order_ID, keys);
	}
}
