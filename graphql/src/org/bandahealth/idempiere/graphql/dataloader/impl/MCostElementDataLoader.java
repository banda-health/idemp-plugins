package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.MCostElement;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MCostElementDataLoader extends X_M_CostElementDataLoader {
	public static String DATALOADER_M_CostElement_BY_CostingMethod = "DATALOADER_M_CostElement_BY_CostingMethod";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_CostElement_BY_CostingMethod,
				DataLoader.newMappedDataLoader(getByCostingMethodBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MCostElement>> getByCostingMethodBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			Repository.setCopyOfPropertiesForNestedThreadUsage(batchLoaderEnvironment.getContext());
			List<MCostElement> models =
					Repository.getQuery(batchLoaderEnvironment.getContext(), getTableName(), null, true, false,
							getTableName() + "." + MCostElement.COLUMNNAME_CostingMethod + " IN (" + whereCondition +
									")", parameters).list();
			return models.stream().collect(Collectors.groupingBy(MCostElement::getCostingMethod));
		});
	}
}
