package org.bandahealth.idempiere.graphql.scalar;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;

/**
 * A custom scalar to allow passing of Date classes into the GraphQL API
 */
public class BinaryScalar {
	public static final GraphQLScalarType Binary = GraphQLScalarType.newScalar().name("Binary")
			.coercing(new Coercing() {
				@Override
				public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
					if (dataFetcherResult instanceof byte[]) {
						return Base64.getEncoder().encodeToString((byte[]) dataFetcherResult);
					}
					throw new CoercingSerializeException("Could not serialize to binary: " + dataFetcherResult);
				}

				@Override
				public Object parseValue(Object input) throws CoercingParseValueException {
					return parseInput(input);
				}

				@Override
				public Object parseLiteral(Object input) throws CoercingParseLiteralException {
					return parseInput(input);
				}
			}).description("a scalar to hold a byte array").build();

	/**
	 * Parse input received from the API caller
	 *
	 * @param input The input passed to the API
	 * @return A Timestamp or an error if the input is unable to be parsed
	 */
	private static byte[] parseInput(Object input) {
		if (input instanceof String) {
			return Base64.getDecoder().decode((String) input);
		}
		throw new CoercingSerializeException("Could not parse input to binary: " + input);
	}
}
