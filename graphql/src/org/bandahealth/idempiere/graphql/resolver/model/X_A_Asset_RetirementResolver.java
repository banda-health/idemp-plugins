package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.compiere.model.MAsset;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.X_A_Asset_Retirement;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for A_Asset_Retirement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_RetirementResolver extends POResolver<X_A_Asset_Retirement> implements GraphQLResolver<X_A_Asset_Retirement> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_A_Asset_Retirement entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.A_Asset_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine> C_InvoiceLine(X_A_Asset_Retirement entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.C_InvoiceLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}

}
