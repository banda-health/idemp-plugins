package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MUserRolesDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MUserRoles;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MUserResolver extends X_AD_UserResolver {
	public CompletableFuture<List<MUserRoles>> AD_User_Roles(MUser_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MUserRoles>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MUserRolesDataLoader.DATALOADER_AD_User_Roles_BY_AD_User_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_User_ID()));
	}
}
