package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_DefaultIncludedRoleResolver extends POResolver<MBHDefaultIncludedRole> implements GraphQLResolver<MBHDefaultIncludedRole> {


	static Map<String, String> DB_USERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "674c3217-bf02-4166-ac90-7e7228328da9");
			put("U", "1225f8a5-3f1a-4be3-9fbe-1b93a5467ce4");
			put("V", "da77ece5-1da7-4e12-a3b5-8ed40dc85617");
			put("B", "cce85e94-ae57-4956-aa68-e41ab1bab123");
			put("R", "132c218a-a6d8-4166-a8a1-36d934864ffd");
			put("I", "97001a3c-26e0-46b3-b0d7-b718f7c1a775");
			put("L", "bc7e156d-ddf2-4377-b915-d78b7222f942");
			put("X", "c3db36cc-c0a2-4314-9d22-8ded879870e2");
			put("C", "2a444310-ac8b-4e40-a0b9-fc6d1e66dc41");
			put("M", "09992ea0-fed9-4202-a0b9-a40754480a1f");
			put("T", "c12fae5c-0307-41ae-9555-8d283333a11d");
			put("D", "c2003ff1-682d-42a5-beda-d04fbf1a62a0");
			put("E", "34c6accb-c624-4936-95a6-3a2ef648e360");
			put("J", "2f53d003-2c9b-40c9-8bb2-bec3a7a32067");
		}
	};
	public CompletableFuture<MRefList_BH> DB_UserType(MBHDefaultIncludedRole entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDB_UserType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DB_USERTYPE_UUIDS_BY_VALUE.get(entity.getDB_UserType()));
	}


	/**
	 * Get Included Role.
	 *
	 * @return Included Role
	 */
	public CompletableFuture<X_AD_Role> Included_Role(MBHDefaultIncludedRole entity, DataFetchingEnvironment environment) {
		if (entity.getIncluded_Role_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getIncluded_Role_ID());
	}

}
