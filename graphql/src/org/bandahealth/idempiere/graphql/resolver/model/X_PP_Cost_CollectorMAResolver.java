package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Cost_CollectorDataLoader;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Cost_Collector;
import org.eevolution.model.X_PP_Cost_CollectorMA;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_Cost_CollectorMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Cost_CollectorMAResolver extends POResolver<X_PP_Cost_CollectorMA> implements GraphQLResolver<X_PP_Cost_CollectorMA> {



	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(X_PP_Cost_CollectorMA entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	public CompletableFuture<X_PP_Cost_Collector> PP_Cost_Collector(X_PP_Cost_CollectorMA entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Cost_Collector_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Cost_Collector> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Cost_CollectorDataLoader.DATALOADER_PP_Cost_Collector_BY_ID);
		return dataLoader.load(entity.getPP_Cost_Collector_ID());
	}

}
