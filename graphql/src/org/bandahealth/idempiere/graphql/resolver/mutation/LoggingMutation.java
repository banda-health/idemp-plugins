package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.util.Properties;

public class LoggingMutation implements GraphQLMutationResolver {
	private static final CLogger log = CLogger.getCLogger(LoggingMutation.class);

	public boolean Log(String LogObject, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		log.info(LogObject + ", AD_Client_ID: " + Env.getAD_Client_ID(idempiereContext) + ", AD_Org_ID: " +
				Env.getAD_Org_ID(idempiereContext) + ", AD_User_ID: " + Env.getAD_User_ID(idempiereContext));
		return true;
	}
}
