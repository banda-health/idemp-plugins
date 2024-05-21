package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineConfirmDataLoader;
import org.compiere.model.MInOutLineConfirm;
import org.compiere.model.X_I_InOutLineConfirm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_InOutLineConfirmResolver extends POResolver<X_I_InOutLineConfirm> implements GraphQLResolver<X_I_InOutLineConfirm> {


	public Boolean I_IsImported(X_I_InOutLineConfirm entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}


	/**
	 * Get Ship/Receipt Confirmation Line.
	 *
	 * @return Material Shipment or Receipt Confirmation Line
	 */
	public CompletableFuture<MInOutLineConfirm> M_InOutLineConfirm(X_I_InOutLineConfirm entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLineConfirm_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInOutLineConfirm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineConfirmDataLoader.DATALOADER_M_InOutLineConfirm_BY_ID);
		return dataLoader.load(entity.getM_InOutLineConfirm_ID());
	}

	public Boolean Processed(X_I_InOutLineConfirm entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_InOutLineConfirm entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
