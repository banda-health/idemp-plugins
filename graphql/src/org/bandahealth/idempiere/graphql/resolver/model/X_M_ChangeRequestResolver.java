package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeNoticeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMDataLoader;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MChangeRequest;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOM;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ChangeRequestResolver extends POResolver<MChangeRequest> implements GraphQLResolver<MChangeRequest> {


	public Boolean IsApproved(MChangeRequest entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}


	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	public CompletableFuture<MChangeNotice> M_ChangeNotice(MChangeRequest entity, DataFetchingEnvironment environment) {
		if (entity.getM_ChangeNotice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChangeNotice> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeNoticeDataLoader.DATALOADER_M_ChangeNotice_BY_ID);
		return dataLoader.load(entity.getM_ChangeNotice_ID());
	}


	/**
	 * Get Fixed in.
	 *
	 * @return Fixed in Change Notice
	 */
	public CompletableFuture<MChangeNotice> M_FixChangeNotice(MChangeRequest entity, DataFetchingEnvironment environment) {
		if (entity.getM_FixChangeNotice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChangeNotice> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeNoticeDataLoader.DATALOADER_M_ChangeNotice_BY_ID);
		return dataLoader.load(entity.getM_FixChangeNotice_ID());
	}


	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	public CompletableFuture<MPPProductBOM> PP_Product_BOM(MChangeRequest entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Product_BOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPPProductBOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Product_BOMDataLoader.DATALOADER_PP_Product_BOM_BY_ID);
		return dataLoader.load(entity.getPP_Product_BOM_ID());
	}

	public Boolean Processed(MChangeRequest entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
