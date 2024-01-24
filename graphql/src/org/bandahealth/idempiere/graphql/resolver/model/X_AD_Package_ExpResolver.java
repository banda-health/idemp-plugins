package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPackageExp;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Package_ExpResolver extends POResolver<MPackageExp> implements GraphQLResolver<MPackageExp> {


	static Map<String, String> AD_PACKAGE_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "4f949942-93a3-41ef-bb81-edcb086e8283");
			put("R", "0e2366f7-4d7f-4929-bb03-9cf62eb33593");
			put("X", "89094762-d594-4934-9173-50aecf4dfa5a");
		}
	};
	public CompletableFuture<MRefList_BH> AD_Package_Type(MPackageExp entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_Package_Type())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(AD_PACKAGE_TYPE_UUIDS_BY_VALUE.get(entity.getAD_Package_Type()));
	}

	public Boolean IsExportDictionaryEntity(MPackageExp entity, DataFetchingEnvironment environment) {
		return entity.isExportDictionaryEntity();
	}

	public Boolean Processed(MPackageExp entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MPackageExp entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> RELEASENO_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Release 2.5.2a", "d975e574-2e8e-47db-b541-cd9eb65056d9");
			put("Release 2.5.2b", "cd25b4fe-5dba-44b5-9a9d-39f36a898ac8");
			put("Release 2.5.2c", "78ee505b-f70a-49ad-8fc5-c9e8fe7cffd0");
			put("Release 2.5.2d", "e9ef48ac-4288-4016-bde2-6efbaa764ce5");
			put("Release 2.5.2e", "b6aeb737-b529-4365-a02d-e67588fb1abb");
			put("Release 2.5.3a", "592848cc-9c95-452a-a977-a4980f136740");
			put("Release 2.5.3b", "97d816d9-ecf7-4812-ab18-d14868a3af36");
			put("all", "b4557873-6a91-4219-b37c-295f62f1eb1e");
			put("Release 3.1.0", "02a67c21-a1ce-4943-a356-121fa3fd1c41");
			put("Release 3.2.0", "5046d1f5-6961-4c28-98ed-aebcde52f1a4");
			put("Release 3.3.0", "e2f98be7-ed36-4b40-b678-a957793ee8e4");
		}
	};
	public CompletableFuture<MRefList_BH> ReleaseNo(MPackageExp entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getReleaseNo())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(RELEASENO_UUIDS_BY_VALUE.get(entity.getReleaseNo()));
	}

}
