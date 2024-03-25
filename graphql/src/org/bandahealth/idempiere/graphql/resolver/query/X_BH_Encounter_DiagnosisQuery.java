package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Encounter_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Encounter_DiagnosisQuery extends POQuery<MBHEncounterDiagnosis> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHEncounterDiagnosis.Table_Name;
	}

	public Connection<MBHEncounterDiagnosis> BH_Encounter_DiagnosisGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
