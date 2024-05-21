package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperCfgDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingProcessorDataLoader;
import org.compiere.model.MShipper;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.X_M_ShipperCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperResolver extends POResolver<MShipper> implements GraphQLResolver<MShipper> {



	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MShipper entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	public CompletableFuture<X_M_ShipperCfg> M_ShipperCfg(MShipper entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperCfg_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_M_ShipperCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperCfgDataLoader.DATALOADER_M_ShipperCfg_BY_ID);
		return dataLoader.load(entity.getM_ShipperCfg_ID());
	}


	/**
	 * Get Shipping Processor.
	 *
	 * @return Shipping Processor
	 */
	public CompletableFuture<MShippingProcessor> M_ShippingProcessor(MShipper entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShippingProcessor_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShippingProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShippingProcessorDataLoader.DATALOADER_M_ShippingProcessor_BY_ID);
		return dataLoader.load(entity.getM_ShippingProcessor_ID());
	}

}
