package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LanguageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PasswordRuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationStrategyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MPasswordRule;
import org.compiere.model.MRefList;
import org.compiere.model.MReplicationStrategy;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientResolver extends POResolver<MClient_BH> implements GraphQLResolver<MClient_BH> {



	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	public CompletableFuture<MLanguage> AD_Language_L(MClient_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Language() <= 0) {
			return null;
		}
		DataLoader<Integer, MLanguage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LanguageDataLoader.AD_Language_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Language());
	}


	/**
	 * Get Password Policies.
	 *
	 * @return Password Policies
	 */
	public CompletableFuture<MPasswordRule> AD_PasswordRule(MClient_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PasswordRule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPasswordRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PasswordRuleDataLoader.AD_PasswordRule_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PasswordRule_ID());
	}


	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	public CompletableFuture<MReplicationStrategy> AD_ReplicationStrategy(MClient_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReplicationStrategy_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReplicationStrategy> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReplicationStrategyDataLoader.AD_ReplicationStrategy_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_ReplicationStrategy_ID());
	}

	static Map<String, String> AUTOARCHIVE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MClient_BH.AUTOARCHIVE_None, "5be4ba0d-256b-48c6-bba5-e94d76c0b391");
			put(MClient_BH.AUTOARCHIVE_AllReportsDocuments, "001d29fb-a915-4660-ae36-406c9028610b");
			put(MClient_BH.AUTOARCHIVE_Documents, "17f95f60-8447-406e-89ce-becf0c7496a8");
			put(MClient_BH.AUTOARCHIVE_ExternalDocuments, "c647f6d8-6c62-4f1d-95b7-9512e4e0af07");
		}
	};
	public CompletableFuture<MRefList> AutoArchive_RL(MClient_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAutoArchive())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(AUTOARCHIVE_UUIDS_BY_VALUE.get(entity.getAutoArchive()));
	}

	static Map<String, String> MMPOLICY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MClient_BH.MMPOLICY_LiFo, "80bfacfa-9e34-4d5c-8388-5cb45e52447a");
			put(MClient_BH.MMPOLICY_FiFo, "b1ed1550-7c2f-402b-b47a-b700929da0f6");
		}
	};
	public CompletableFuture<MRefList> MMPolicy_RL(MClient_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMMPolicy())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(MMPOLICY_UUIDS_BY_VALUE.get(entity.getMMPolicy()));
	}

}
