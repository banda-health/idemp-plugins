package org.bandahealth.idempiere.graphql.instrumentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionResult;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.SimpleInstrumentationContext;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.util.Properties;
import java.util.stream.Collectors;

/**
 * This is a custom logging implementation that captures pertinent information about a GraphQL query and can log it
 * or do whatever else is needed. To see a bigger example, look here:
 * https://www.graphql-java.com/documentation/v15/instrumentation/
 */
public class LoggingInstrumentation extends SimpleInstrumentation {
	private final CLogger logger = CLogger.getCLogger(LoggingInstrumentation.class);

	@Override
	public InstrumentationContext<ExecutionResult> beginExecution(InstrumentationExecutionParameters parameters) {
		long startMillis = System.currentTimeMillis();
		return new SimpleInstrumentationContext<>() {
			@Override
			public void onCompleted(ExecutionResult result, Throwable t) {
				// We'll handle this endpoint in the LoggingMutation itself
				if (parameters.getQuery().contains(" Log(")) {
					return;
				}
				String logMessage = StringUtil.stripNewLines(parameters.getQuery());
				// Skip logging information for sign-ins
				if (!parameters.getVariables().isEmpty() && !parameters.getQuery().contains("AuthenticationInput")) {
					String variablesString;
					try {
						ObjectMapper mapper = new ObjectMapper();
						variablesString = mapper.writeValueAsString(parameters.getVariables());
					} catch (JsonProcessingException e) {
						variablesString = parameters.getVariables().entrySet().stream()
								.map((entry) -> entry.getKey() + ": " + entry.getValue().toString()).collect(Collectors.joining(", "));
					}
					logMessage += ", variables: " + variablesString;
				}
				// Add the user context for debugging & tracking purposes
				try {
					Properties idempiereContext = ((BandaGraphQLContext) parameters.getContext()).getIdempiereContext();
					logMessage += ", userId: " + Env.getAD_User_ID(idempiereContext) + ", clientId: " +
							Env.getAD_Client_ID(idempiereContext) + ", organizationId: " + Env.getAD_Org_ID(idempiereContext) +
							", roleId: " + Env.getAD_Role_ID(idempiereContext) + ", warehouseId: " +
							Env.getContextAsInt(idempiereContext, Env.M_WAREHOUSE_ID) + ", sessionId: " +
							Env.getContextAsInt(idempiereContext, Env.AD_SESSION_ID);
				} catch (Exception e) {
					logger.warning(e.getMessage());
				}
				logger.info(logMessage + ", execution time (ms): " + (System.currentTimeMillis() - startMillis));
			}
		};
	}
}
