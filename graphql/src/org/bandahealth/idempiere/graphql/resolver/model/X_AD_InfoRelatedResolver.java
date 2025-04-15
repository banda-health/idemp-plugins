package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MInfoWindow;
import org.compiere.model.X_AD_InfoRelated;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_InfoRelated - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_InfoRelatedResolver extends POResolver<X_AD_InfoRelated> implements GraphQLResolver<X_AD_InfoRelated> {



	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	public CompletableFuture<MInfoWindow> AD_InfoWindow(X_AD_InfoRelated entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoWindow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInfoWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_ID);
		return dataLoader.load(entity.getAD_InfoWindow_ID());
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
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_InfoRelated entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}


	/**
	 * Get Parent Related Column.
	 *
	 * @return column in parent info window, link with column in this relate info
	 */
	public CompletableFuture<MInfoColumn> ParentRelatedColumn(X_AD_InfoRelated entity, DataFetchingEnvironment environment) {
		if (entity.getParentRelatedColumn_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInfoColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoColumnDataLoader.DATALOADER_AD_InfoColumn_BY_ID);
		return dataLoader.load(entity.getParentRelatedColumn_ID());
	}


	/**
	 * Get Related Info Column.
	 *
	 * @return Related Info Column
	 */
	public CompletableFuture<MInfoColumn> RelatedColumn(X_AD_InfoRelated entity, DataFetchingEnvironment environment) {
		if (entity.getRelatedColumn_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInfoColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoColumnDataLoader.DATALOADER_AD_InfoColumn_BY_ID);
		return dataLoader.load(entity.getRelatedColumn_ID());
	}


	/**
	 * Get Related Info Window.
	 *
	 * @return Related Info Window
	 */
	public CompletableFuture<MInfoWindow> RelatedInfo(X_AD_InfoRelated entity, DataFetchingEnvironment environment) {
		if (entity.getRelatedInfo_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInfoWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_ID);
		return dataLoader.load(entity.getRelatedInfo_ID());
	}

}
