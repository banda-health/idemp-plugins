package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFeatureFlag;
import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AllClients_VDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AllUsers_VDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Feature_FlagDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_AllClients_V;
import org.compiere.model.X_AD_AllUsers_V;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Feature_Flag_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_Flag_RuleResolver extends POResolver<MBHFeatureFlagRule> implements GraphQLResolver<MBHFeatureFlagRule> {


	public static Map<String, String> BH_ENVIRONMENT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "80ee3010-2e49-4aa8-934e-2c5662b1b70d"); // Evaluation
			put("I", "d3239ec8-bbdc-42c3-997b-c3be8d89d914"); // Implementation
			put("P", "1b3201b9-d2a4-4101-a4a0-a53571550f32"); // Production
		}
	};
	public CompletableFuture<MRefList_BH> BH_Environment(MBHFeatureFlagRule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Environment())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_ENVIRONMENT_UUIDS_BY_VALUE.get(entity.getBH_Environment()));
	}


	/**
	 * Get Feature Flag.
	 *
	 * @return Feature Flag
	 */
	public CompletableFuture<MBHFeatureFlag> BH_Feature_Flag(MBHFeatureFlagRule entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Feature_Flag_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHFeatureFlag> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Feature_FlagDataLoader.DATALOADER_BH_Feature_Flag_BY_ID);
		return dataLoader.load(entity.getBH_Feature_Flag_ID());
	}

	public Boolean BH_IsEnabled(MBHFeatureFlagRule entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsEnabled();
	}


	/**
	 * Get Client.
	 *
	 * @return Client
	 */
	public CompletableFuture<X_AD_AllClients_V> BH_Rule_Client(MBHFeatureFlagRule entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Rule_Client_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_AllClients_V> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AllClients_VDataLoader.DATALOADER_AD_AllClients_V_BY_ID);
		return dataLoader.load(entity.getBH_Rule_Client_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Role
	 */
	public CompletableFuture<X_AD_Role> BH_Rule_Role(MBHFeatureFlagRule entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Rule_Role_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getBH_Rule_Role_ID());
	}


	/**
	 * Get User.
	 *
	 * @return User
	 */
	public CompletableFuture<X_AD_AllUsers_V> BH_Rule_User(MBHFeatureFlagRule entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Rule_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_AllUsers_V> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AllUsers_VDataLoader.DATALOADER_AD_AllUsers_V_BY_ID);
		return dataLoader.load(entity.getBH_Rule_User_ID());
	}

	public Boolean BH_SystemAdmin(MBHFeatureFlagRule entity, DataFetchingEnvironment environment) {
		return entity.isBH_SystemAdmin();
	}

}
