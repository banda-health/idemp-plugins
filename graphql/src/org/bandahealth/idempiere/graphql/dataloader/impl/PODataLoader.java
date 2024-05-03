package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.GraphQLEndpoint;
import org.bandahealth.idempiere.graphql.dataloader.DataLoaderRegisterer;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Properties;

/**
 * The base data loader that holds logic common to all data loaders.
 *
 * @param <T> The iDempiere entity this data loader loads data for
 */
public abstract class PODataLoader<T extends PO> implements DataLoaderRegisterer {
	protected final CLogger log;

	public PODataLoader() {
		Type genericSuperclass = getClass().getGenericSuperclass();
		Class<?> childClass;
		if (genericSuperclass instanceof ParameterizedType) {
			childClass = ((Class<?>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
		} else {
			childClass =
					((Class<?>) ((ParameterizedType) ((Class<?>) genericSuperclass).getGenericSuperclass()).getActualTypeArguments()[0]);
		}
		log = CLogger.getCLogger(childClass);
	}

	/**
	 * A method to return the data loader name of the ID batch loader (these names must be unique)
	 *
	 * @return The name to register the ID data loader under
	 */
	protected abstract String getByIdDataLoaderName();

	/**
	 * A method to return the data loader name of the UUID batch loader (these names must be unique)
	 *
	 * @return The name to register the UUID data loader under
	 */
	protected abstract String getByUuidDataLoaderName();

	/**
	 * A method to return the entity's table for default data loader registration
	 *
	 * @return The table name for the associated entity
	 */
	protected abstract String getTableName();

	/**
	 * The base method to register a data loader by iDempiere model ID and UUID.
	 *
	 * @param registry         The data loader registry for this GraphQL query
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 */
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		if (!StringUtil.isNullOrEmpty(getByIdDataLoaderName())) {
			registry.register(getByIdDataLoaderName(), DataLoader.newMappedDataLoader(getByIdBatchLoader(),
					getOptionsWithoutCache(idempiereContext)));
		}
		if (!StringUtil.isNullOrEmpty(getByUuidDataLoaderName())) {
			registry.register(getByUuidDataLoaderName(), DataLoader.newMappedDataLoader(getByUuidBatchLoader(),
					getOptionsWithoutCache(idempiereContext)));
		}
	}

	/**
	 * This gets options that provide the iDempiere context to the batch loaders, including a cache for the given entity
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @return A DataLoaderOptions containing a cache specific to the iDempiere entity T
	 */
	protected DataLoaderOptions getOptionsWithCache(Properties idempiereContext) {
		return getOptionsWithoutCache(idempiereContext).setCacheMap(GraphQLEndpoint.getCache(getTableName()));
	}

	/**
	 * This gets options that provide the iDempiere context to the batch loaders
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @return A DataLoaderOptions containing a cache specific to the iDempiere entity T
	 */
	protected DataLoaderOptions getOptionsWithoutCache(Properties idempiereContext) {
		return DataLoaderOptions.newOptions().setCachingEnabled(false)
				.setBatchLoaderContextProvider(() -> idempiereContext);
	}

	/**
	 * The method to return batched data by DB ID
	 *
	 * @return A batch loader for loading entities by their DB IDs
	 */
	protected MappedBatchLoaderWithContext<Integer, T> getByIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getByIdsCompletableFuture(batchLoaderEnvironment.getContext(),
				getTableName(), null, keys);
	}

	/**
	 * The method to return batched data by UUID
	 *
	 * @return A batch loader for loading entities by UUIDs
	 */
	protected MappedBatchLoaderWithContext<String, T> getByUuidBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getByUuidsCompletableFuture(batchLoaderEnvironment.getContext(),
				getTableName(), null, keys);
	}
}
