package org.bandahealth.idempiere.graphql.resolver.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.utils.FeatureFlagContext;
import org.bandahealth.idempiere.base.utils.FeatureFlagUtil;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class MBHFeatureFlagQuery extends X_BH_Feature_FlagQuery {

	public CompletableFuture<String> FeatureFlags(DataFetchingEnvironment environment) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Properties ctx = BandaGraphQLContext.getCtx(environment);
				FeatureFlagContext context = FeatureFlagUtil.fromContext(ctx);
				Map<String, Boolean> featureFlags = FeatureFlagUtil.evaluateAll(ctx, context, null);
				return new ObjectMapper().writeValueAsString(featureFlags);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		});
	}
}
