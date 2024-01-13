package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRoleDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRole;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MUserResolver extends X_AD_UserResolver {
	public CompletableFuture<List<X_AD_Role>> AD_Roles(MUser_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<X_AD_Role>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MRoleDataLoader.DATALOADER_AD_Role_BY_AD_User_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_User_ID()));
	}
}
