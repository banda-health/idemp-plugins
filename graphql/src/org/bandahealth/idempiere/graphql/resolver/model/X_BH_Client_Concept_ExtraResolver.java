package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Concept_ExtraDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Client_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Client_Concept_ExtraResolver extends POResolver<MBHClientConceptExtra> implements GraphQLResolver<MBHClientConceptExtra> {



	/**
	 * Get Concept Extra.
	 *
	 * @return Concept Extra
	 */
	public CompletableFuture<MBHConceptExtra> BH_Concept_Extra(MBHClientConceptExtra entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_Extra_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHConceptExtra> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Concept_ExtraDataLoader.DATALOADER_BH_Concept_Extra_BY_ID);
		return dataLoader.load(entity.getBH_Concept_Extra_ID());
	}

}
