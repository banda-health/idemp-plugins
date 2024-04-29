package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_Sequence - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SequenceResolver extends POResolver<MSequence_BH> implements GraphQLResolver<MSequence_BH> {


	public Boolean IsAudited(MSequence_BH entity, DataFetchingEnvironment environment) {
		return entity.isAudited();
	}

	public Boolean IsAutoSequence(MSequence_BH entity, DataFetchingEnvironment environment) {
		return entity.isAutoSequence();
	}

	public Boolean IsOrgLevelSequence(MSequence_BH entity, DataFetchingEnvironment environment) {
		return entity.isOrgLevelSequence();
	}

	public Boolean IsTableID(MSequence_BH entity, DataFetchingEnvironment environment) {
		return entity.isTableID();
	}

	public Boolean StartNewMonth(MSequence_BH entity, DataFetchingEnvironment environment) {
		return entity.isStartNewMonth();
	}

	public Boolean StartNewYear(MSequence_BH entity, DataFetchingEnvironment environment) {
		return entity.isStartNewYear();
	}

}
