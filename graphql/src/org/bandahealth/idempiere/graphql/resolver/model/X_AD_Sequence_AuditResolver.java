package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SequenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_Sequence_Audit;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Sequence_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Sequence_AuditResolver extends POResolver<X_AD_Sequence_Audit> implements GraphQLResolver<X_AD_Sequence_Audit> {



	/**
	 * Get Sequence.
	 *
	 * @return Document Sequence
	 */
	public CompletableFuture<MSequence_BH> AD_Sequence(X_AD_Sequence_Audit entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Sequence_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSequence_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SequenceDataLoader.DATALOADER_AD_Sequence_BY_ID);
		return dataLoader.load(entity.getAD_Sequence_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_Sequence_Audit entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

}
