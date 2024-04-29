package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.MPriceListVersion;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MPriceListVersionDataLoader extends X_M_PriceList_VersionDataLoader {
	public static String DATALOADER_M_PriceList_Version_BY_M_PriceList_AND_Today_ID =
			"DATALOADER_M_PriceList_Version_BY_M_PriceList_AND_Today_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_PriceList_Version_BY_M_PriceList_AND_Today_ID,
				DataLoader.newMappedDataLoader(getByPriceListIdForTodayBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	/**
	 * Do what {@link org.compiere.model.MPriceList#getPriceListVersion(Timestamp) does}
	 *
	 * @return The most-recent, valid price list version for the price lists
	 */
	private MappedBatchLoaderWithContext<String, MPriceListVersion> getByPriceListIdForTodayBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			String modelName = ModelUtil.getModelFromKey(keys.iterator().next());
			Set<Integer> ids = keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet());
			//
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(ids, parameters);
			String columnToSearch = getTableName() + "." + MPriceListVersion.COLUMNNAME_M_PriceList_ID;
			Repository.setCopyOfPropertiesForNestedThreadUsage(batchLoaderEnvironment.getContext());
			parameters.add(new Timestamp(System.currentTimeMillis()));
			//
			List<MPriceListVersion> models =
					Repository.getQuery(batchLoaderEnvironment.getContext(), getTableName(), null, true, false,
									columnToSearch + " IN (" + whereCondition + ") AND TRUNC(ValidFrom)<=?", parameters)
							.setOrderBy("ValidFrom DESC").list();
			return models.stream().collect(Collectors.groupingBy(MPriceListVersion::getM_PriceList_ID)).entrySet().stream()
					.collect(Collectors.toMap(entrySet -> ModelUtil.getModelKey(modelName, entrySet.getKey()),
							entry -> entry.getValue().get(0)));
		});
	}
}
