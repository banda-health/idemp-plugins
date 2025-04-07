package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MLocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMovementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MTransactionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.model.DashboardLabUsage;
import org.bandahealth.idempiere.graphql.model.DashboardProductUsage;
import org.bandahealth.idempiere.graphql.model.InventoryTransaction;
import org.compiere.model.MLocator;
import org.compiere.model.MTransaction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class DashboardProductUsageResolver implements GraphQLResolver<DashboardProductUsage> {

	public CompletableFuture<MProduct_BH> M_Product(DashboardProductUsage Entity, DataFetchingEnvironment environment) {
		if (Entity.getProductId() == null || Entity.getProductId() < 1) {
			return null;
		}
		final DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(Entity.getProductId());
	}
}
