package org.bandahealth.idempiere.graphql.instrumentation;

import graphql.ExecutionResult;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.SimpleInstrumentationContext;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.util.CLogger;

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
				String logMessage = StringUtil.stripNewLines(parameters.getQuery());
				if (!parameters.getVariables().isEmpty() && !parameters.getQuery().contains("AuthenticationInput")) {
					logMessage += ", variables: " + parameters.getVariables().entrySet().stream()
							.map((entry) -> entry.getKey() + ": " + entry.getValue().toString()).collect(Collectors.joining(", "));
				}
				logger.info(logMessage + ", execution time (ms): " + (System.currentTimeMillis() - startMillis));
			}
		};
	}
}
