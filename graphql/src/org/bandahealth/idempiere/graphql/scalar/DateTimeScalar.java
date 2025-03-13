package org.bandahealth.idempiere.graphql.scalar;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.bandahealth.idempiere.graphql.utils.DateUtil;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * A custom scalar to allow passing of DateTime classes into the GraphQL API
 */
public class DateTimeScalar {
	public static final GraphQLScalarType DateTime = GraphQLScalarType.newScalar().name("DateTime")
			.coercing(new Coercing() {
				@Override
				public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
					if (dataFetcherResult == null) {
						return null;
					}
					if (dataFetcherResult instanceof Date) {
						return ((Date) dataFetcherResult).getTime();
					} else if (dataFetcherResult instanceof Timestamp) {
						return ((Timestamp) dataFetcherResult).getTime();
					}
					throw new CoercingSerializeException("Could not serialize to datetime: " + dataFetcherResult);
				}

				@Override
				public Object parseValue(Object input) throws CoercingParseValueException {
					return parseInput(input);
				}

				@Override
				public Object parseLiteral(Object input) throws CoercingParseLiteralException {
					return parseInput(input);
				}
			}).description("a scalar to hold a DateTime").build();

	/**
	 * Parse input received from the API caller
	 *
	 * @param input The input passed to the API
	 * @return A Timestamp or an error if the input is unable to be parsed
	 */
	private static Timestamp parseInput(Object input) {
		if (input == null) {
			return null;
		}
		Timestamp parsedTimestamp = DateUtil.getAPITimestamp(input, false);
		if (parsedTimestamp == null) {
			throw new CoercingSerializeException("Could not parse input to datetime: " + input);
		}
		return parsedTimestamp;
	}
}
