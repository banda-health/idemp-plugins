package org.bandahealth.idempiere.graphql.scalar;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * A custom scalar to allow passing of Date classes into the GraphQL API
 */
public class BigDecimalScalar {
	public static final GraphQLScalarType BigDecimal = GraphQLScalarType.newScalar().name("BigDecimal")
			.coercing(new Coercing() {
				@Override
				public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
					return dataFetcherResult;
				}

				@Override
				public Object parseValue(Object input) throws CoercingParseValueException {
					return parseInput(input);
				}

				@Override
				public Object parseLiteral(Object input) throws CoercingParseLiteralException {
					return parseInput(input);
				}
			}).description("a scalar to hold a BigDecimal").build();

	/**
	 * Parse input received from the API caller
	 *
	 * @param input The input passed to the API
	 * @return A BigDecimal or an error if the input is unable to be parsed
	 */
	private static BigDecimal parseInput(Object input) {
		if (input instanceof Integer || input instanceof Long || input instanceof Float || input instanceof Double || input instanceof BigDecimal) {
			return new BigDecimal(input.toString());
		}
		throw new CoercingSerializeException("Could not parse input to BigDecimal: " + input);
	}
}
