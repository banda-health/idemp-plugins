package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MWarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MOrgResolver extends X_AD_OrgResolver {

	public CompletableFuture<List<X_AD_Role>> AD_Roles(MOrg entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<X_AD_Role>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MRoleDataLoader.AD_Role_BY_ORGANIZATION_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Org_ID()));
	}

	public CompletableFuture<List<MWarehouse_BH>> M_Warehouses(MOrg entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MWarehouse_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MWarehouseDataLoader.M_Warehouse_BY_ORGANIZATION_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Org_ID()));
	}
}
