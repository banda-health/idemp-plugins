package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StorageProviderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.compiere.model.MAttachment;
import org.compiere.model.MStorageProvider;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Attachment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AttachmentResolver extends POResolver<MAttachment> implements GraphQLResolver<MAttachment> {



	/**
	 * Get Storage Provider.
	 *
	 * @return Storage Provider
	 */
	public CompletableFuture<MStorageProvider> AD_StorageProvider(MAttachment entity, DataFetchingEnvironment environment) {
		if (entity.getAD_StorageProvider_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MStorageProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StorageProviderDataLoader.DATALOADER_AD_StorageProvider_BY_ID);
		return dataLoader.load(entity.getAD_StorageProvider_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MAttachment entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

}
