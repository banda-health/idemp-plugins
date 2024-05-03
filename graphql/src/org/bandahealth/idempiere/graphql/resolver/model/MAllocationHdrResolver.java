package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAllocationLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MAllocationLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MAllocationHdrResolver extends X_C_AllocationHdrResolver {

	public CompletableFuture<List<MAllocationLine>> C_AllocationLines(MAllocationHdr entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAllocationLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAllocationLineDataLoader.DATALOADER_C_AllocationLine_BY_C_AllocationHdr_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_AllocationHdr_ID()));
	}
}
