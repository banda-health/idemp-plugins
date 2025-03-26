package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Allergy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_AllergyResolver extends POResolver<MBHAllergy> implements GraphQLResolver<MBHAllergy> {



	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	public CompletableFuture<MBHConcept> BH_Concept(MBHAllergy entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getBH_Concept_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MBHAllergy entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Severity Concept ID.
	 *
	 * @return Severity Concept ID
	 */
	public CompletableFuture<MBHConcept> Severity_Concept(MBHAllergy entity, DataFetchingEnvironment environment) {
		if (entity.getSeverity_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getSeverity_Concept_ID());
	}

}
