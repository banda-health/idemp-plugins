package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DemandLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ForecastLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RequisitionLineDataLoader;
import org.compiere.model.MForecastLine;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.X_M_DemandDetail;
import org.compiere.model.X_M_DemandLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DemandDetailResolver extends POResolver<X_M_DemandDetail> implements GraphQLResolver<X_M_DemandDetail> {



	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	public CompletableFuture<MOrderLine_BH> C_OrderLine(X_M_DemandDetail entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.DATALOADER_C_OrderLine_BY_ID);
		return dataLoader.load(entity.getC_OrderLine_ID());
	}


	/**
	 * Get Demand Line.
	 *
	 * @return Material Demand Line
	 */
	public CompletableFuture<X_M_DemandLine> M_DemandLine(X_M_DemandDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_DemandLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_M_DemandLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DemandLineDataLoader.DATALOADER_M_DemandLine_BY_ID);
		return dataLoader.load(entity.getM_DemandLine_ID());
	}


	/**
	 * Get Forecast Line.
	 *
	 * @return Forecast Line
	 */
	public CompletableFuture<MForecastLine> M_ForecastLine(X_M_DemandDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_ForecastLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MForecastLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ForecastLineDataLoader.DATALOADER_M_ForecastLine_BY_ID);
		return dataLoader.load(entity.getM_ForecastLine_ID());
	}


	/**
	 * Get Requisition Line.
	 *
	 * @return Material Requisition Line
	 */
	public CompletableFuture<MRequisitionLine> M_RequisitionLine(X_M_DemandDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_RequisitionLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRequisitionLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RequisitionLineDataLoader.DATALOADER_M_RequisitionLine_BY_ID);
		return dataLoader.load(entity.getM_RequisitionLine_ID());
	}

}
