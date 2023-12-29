package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MRefList;
import org.compiere.model.MTree;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RoleResolver extends POResolver<X_AD_Role> implements GraphQLResolver<X_AD_Role> {



	/**
	 * Get Menu Tree.
	 *
	 * @return Tree of the menu
	 */
	public CompletableFuture<MTree> AD_Tree_Menu(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Menu_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.AD_Tree_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Tree_Menu_ID());
	}


	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	public CompletableFuture<MTree> AD_Tree_Org(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Org_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.AD_Tree_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Tree_Org_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}

	static Map<String, String> PREFERENCETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "83843d71-2a13-4c6f-912f-dd92b1faeaa5");
			put("O", "925937f5-882b-459e-a044-6156cd642415");
			put("U", "1e3cec47-4ddd-4543-b9de-0b52125f464b");
			put("N", "7b6855b5-554c-4350-a4c1-605523bc56e1");
		}
	};
	public CompletableFuture<MRefList> PreferenceType_RL(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPreferenceType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PREFERENCETYPE_UUIDS_BY_VALUE.get(entity.getPreferenceType()));
	}

	static Map<String, String> ROLETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ZK", "af5be523-6318-4b6c-bc8b-f51ecd0de2d0");
			put("WS", "ff7ae569-ea86-4c21-9aff-6a9073f4b677");
			put("SS", "3b6ad66c-e962-46a5-a3ec-b8787ee4c754");
			put("MO", "78962d5b-b6bb-4798-8f9d-fd36381b58ed");
			put("SW", "b6d02ebf-6845-47d9-b91e-b956084333e8");
			put("E1", "d6bc8c6d-d5bf-458c-81f7-4d3f11303d6d");
			put("E2", "79a2e44a-dfd6-4114-b835-5392c4736eb9");
			put("E3", "f158da0d-6ad6-4f2e-aa65-099417d6217b");
			put("E4", "d136b0f9-658a-4e79-b22f-3cf995da34ff");
			put("E5", "b06729fb-ce8e-4bff-b6da-0f38bdefa55e");
		}
	};
	public CompletableFuture<MRefList> RoleType_RL(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRoleType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ROLETYPE_UUIDS_BY_VALUE.get(entity.getRoleType()));
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSupervisor_ID());
	}

	static Map<String, String> USERLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S  ", "e8d54adf-89fa-43f6-90aa-32f3d57c1bfc");
			put(" C ", "1c9b74bd-a284-4c2b-9ad1-826e53c01bae");
			put("  O", "23b5d43e-7691-4a8f-b9ee-969cca173609");
			put(" CO", "ac273750-1ebd-4bf1-9637-b693fa7a5794");
		}
	};
	public CompletableFuture<MRefList> UserLevel_RL(X_AD_Role entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getUserLevel())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(USERLEVEL_UUIDS_BY_VALUE.get(entity.getUserLevel()));
	}

}
