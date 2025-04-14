package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FieldDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_EncounterDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Observation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_ObservationResolver extends POResolver<MBHObservation> implements GraphQLResolver<MBHObservation> {



	/**
	 * Get Field.
	 *
	 * @return Field on a database table
	 */
	public CompletableFuture<MField_BH> AD_Field(MBHObservation entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Field_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MField_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FieldDataLoader.DATALOADER_AD_Field_BY_ID);
		return dataLoader.load(entity.getAD_Field_ID());
	}


	/**
	 * Get Encounter.
	 *
	 * @return Encounter
	 */
	public CompletableFuture<MBHEncounter> BH_Encounter(MBHObservation entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Encounter_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHEncounter> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_EncounterDataLoader.DATALOADER_BH_Encounter_BY_ID);
		return dataLoader.load(entity.getBH_Encounter_ID());
	}

}
