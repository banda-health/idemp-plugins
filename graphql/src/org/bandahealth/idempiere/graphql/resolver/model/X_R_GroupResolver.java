package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeNoticeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMDataLoader;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MGroup;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOM;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_GroupResolver extends POResolver<MGroup> implements GraphQLResolver<MGroup> {



	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	public CompletableFuture<MChangeNotice> M_ChangeNotice(MGroup entity, DataFetchingEnvironment environment) {
		if (entity.getM_ChangeNotice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MChangeNotice> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeNoticeDataLoader.DATALOADER_M_ChangeNotice_BY_ID);
		return dataLoader.load(entity.getM_ChangeNotice_ID());
	}


	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	public CompletableFuture<MPPProductBOM> PP_Product_BOM(MGroup entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Product_BOM_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPPProductBOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Product_BOMDataLoader.DATALOADER_PP_Product_BOM_BY_ID);
		return dataLoader.load(entity.getPP_Product_BOM_ID());
	}

}
