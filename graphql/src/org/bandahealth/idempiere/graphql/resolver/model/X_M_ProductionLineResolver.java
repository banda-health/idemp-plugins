package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionPlanDataLoader;
import org.compiere.model.MLocator;
import org.compiere.model.MProduction;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProductionPlan;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ProductionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionLineResolver extends POResolver<MProductionLine> implements GraphQLResolver<MProductionLine> {


	public Boolean IsEndProduct(MProductionLine entity, DataFetchingEnvironment environment) {
		return entity.isEndProduct();
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MProductionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MProductionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.M_Locator_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MProductionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Production.
	 *
	 * @return Plan for producing a product
	 */
	public CompletableFuture<MProduction> M_Production(MProductionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Production_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductionDataLoader.M_Production_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Production_ID());
	}


	/**
	 * Get Production Plan.
	 *
	 * @return Plan for how a product is produced
	 */
	public CompletableFuture<MProductionPlan> M_ProductionPlan(MProductionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductionPlan_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProductionPlan> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductionPlanDataLoader.M_ProductionPlan_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_ProductionPlan_ID());
	}

	public Boolean Processed(MProductionLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
