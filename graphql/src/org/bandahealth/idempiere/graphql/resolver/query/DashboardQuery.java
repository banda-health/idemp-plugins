package org.bandahealth.idempiere.graphql.resolver.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.compiere.model.MUser;

public class DashboardQuery implements GraphQLQueryResolver {
	public String DashboardData(String UU, String SqlQuery, DataFetchingEnvironment environment) {
		MUser currentUser;
		if ((currentUser = MUser_BH.get(BandaGraphQLContext.getCtx(environment))) == null ||
				!currentUser.isAdministrator()) {
			return null;
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(
					SqlUtil.executeDashboardQueryForClient(BandaGraphQLContext.getCtx(environment), SqlQuery, UU));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
