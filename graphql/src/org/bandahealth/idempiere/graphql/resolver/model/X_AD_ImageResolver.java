package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StorageProviderDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MImage;
import org.compiere.model.MStorageProvider;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Image - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ImageResolver extends POResolver<MImage> implements GraphQLResolver<MImage> {



	/**
	 * Get Storage Provider.
	 *
	 * @return Storage Provider
	 */
	public CompletableFuture<MStorageProvider> AD_StorageProvider(MImage entity, DataFetchingEnvironment environment) {
		if (entity.getAD_StorageProvider_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStorageProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StorageProviderDataLoader.DATALOADER_AD_StorageProvider_BY_ID);
		return dataLoader.load(entity.getAD_StorageProvider_ID());
	}

	static Map<String, Integer> ENTITYTYPE_IDS_BY_ENTITY_TYPE = new HashMap<>() {
		{
			put("D", 10);
			put("C", 20);
			put("U", 100);
			put("CUST", 110);
			put("A", 200);
			put("EXT", 210);
			put("XX", 220);
			put("EE01", 50000);
			put("EE04", 50001);
			put("EE05", 50003);
			put("EE02", 50005);
			put("WSTORE", 200015);
		}
	};

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MImage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

}
