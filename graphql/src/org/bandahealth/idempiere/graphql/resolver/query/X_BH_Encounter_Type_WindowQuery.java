package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Encounter_Type_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Encounter_Type_WindowQuery extends POQuery<MBHEncounterTypeWindow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHEncounterTypeWindow.Table_Name;
	}

	public Connection<MBHEncounterTypeWindow> BH_Encounter_Type_WindowGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
