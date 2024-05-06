package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostDetailDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MCostDetail;
import org.compiere.model.MCostElement;
import org.compiere.model.MCostType;
import org.compiere.model.X_M_CostHistory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostHistoryResolver extends POResolver<X_M_CostHistory> implements GraphQLResolver<X_M_CostHistory> {



	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(X_M_CostHistory entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Cost Detail.
	 *
	 * @return Cost Detail Information
	 */
	public CompletableFuture<MCostDetail> M_CostDetail(X_M_CostHistory entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostDetail_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostDetail> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostDetailDataLoader.DATALOADER_M_CostDetail_BY_ID);
		return dataLoader.load(entity.getM_CostDetail_ID());
	}


	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	public CompletableFuture<MCostElement> M_CostElement(X_M_CostHistory entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostElement_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostElement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostElementDataLoader.DATALOADER_M_CostElement_BY_ID);
		return dataLoader.load(entity.getM_CostElement_ID());
	}


	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	public CompletableFuture<MCostType> M_CostType(X_M_CostHistory entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostTypeDataLoader.DATALOADER_M_CostType_BY_ID);
		return dataLoader.load(entity.getM_CostType_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_M_CostHistory entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
