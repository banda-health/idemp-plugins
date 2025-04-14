package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SequenceDataLoader;
import org.compiere.model.X_AD_Sequence_No;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Sequence_No - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Sequence_NoResolver extends POResolver<X_AD_Sequence_No> implements GraphQLResolver<X_AD_Sequence_No> {



	/**
	 * Get Sequence.
	 *
	 * @return Document Sequence
	 */
	public CompletableFuture<MSequence_BH> AD_Sequence(X_AD_Sequence_No entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Sequence_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MSequence_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SequenceDataLoader.DATALOADER_AD_Sequence_BY_ID);
		return dataLoader.load(entity.getAD_Sequence_ID());
	}

}
