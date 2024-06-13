package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MessageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MTable;
import org.compiere.model.MTableIndex;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_TableIndex - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TableIndexResolver extends POResolver<MTableIndex> implements GraphQLResolver<MTableIndex> {



	/**
	 * Get Message.
	 *
	 * @return System Message
	 */
	public CompletableFuture<MMessage_BH> AD_Message(MTableIndex entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Message_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MMessage_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_MessageDataLoader.DATALOADER_AD_Message_BY_ID);
		return dataLoader.load(entity.getAD_Message_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MTableIndex entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
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
	public CompletableFuture<MEntityType> AD_EntityType(MTableIndex entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public Boolean IsCreateConstraint(MTableIndex entity, DataFetchingEnvironment environment) {
		return entity.isCreateConstraint();
	}

	public Boolean IsKey(MTableIndex entity, DataFetchingEnvironment environment) {
		return entity.isKey();
	}

	public Boolean IsUnique(MTableIndex entity, DataFetchingEnvironment environment) {
		return entity.isUnique();
	}

	public Boolean Processing(MTableIndex entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
