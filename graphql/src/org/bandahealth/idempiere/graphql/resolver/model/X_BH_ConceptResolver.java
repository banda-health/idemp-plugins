package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for BH_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_ConceptResolver extends POResolver<MBHConcept> implements GraphQLResolver<MBHConcept> {


	public String bh_concept_class(MBHConcept entity, DataFetchingEnvironment environment) {
		return entity.getbh_concept_class();
	}

}
