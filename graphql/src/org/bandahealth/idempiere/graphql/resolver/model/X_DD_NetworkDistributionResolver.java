package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeNoticeDataLoader;
import org.compiere.model.MChangeNotice;
import org.dataloader.DataLoader;
import org.eevolution.model.X_DD_NetworkDistribution;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for DD_NetworkDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_DD_NetworkDistributionResolver extends POResolver<X_DD_NetworkDistribution> implements GraphQLResolver<X_DD_NetworkDistribution> {



	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	public CompletableFuture<MChangeNotice> M_ChangeNotice(X_DD_NetworkDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getM_ChangeNotice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MChangeNotice> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeNoticeDataLoader.DATALOADER_M_ChangeNotice_BY_ID);
		return dataLoader.load(entity.getM_ChangeNotice_ID());
	}

	public Boolean Processing(X_DD_NetworkDistribution entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
