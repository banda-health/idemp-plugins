package org.bandahealth.idempiere.graphql.scalar;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * A custom scalar to allow passing of Date classes into the GraphQL API
 */
public class DateScalar {
	public static final GraphQLScalarType Date = GraphQLScalarType.newScalar().name("Date")
			.coercing(new Coercing() {
				@Override
				public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
					if (dataFetcherResult == null) {
						return null;
					}
					if (dataFetcherResult instanceof Date) {
						// Hopefully this never gets used because it'll lead to problems
						return new SimpleDateFormat("yyyy/MM/dd").format((Date) dataFetcherResult);
					} else if (dataFetcherResult instanceof Timestamp) {
						return new SimpleDateFormat("yyyy/MM/dd").format((Timestamp) dataFetcherResult);
					}
					throw new CoercingSerializeException("Could not serialize to date: " + dataFetcherResult);
				}

				@Override
				public Object parseValue(Object input) throws CoercingParseValueException {
					return parseInput(input);
				}

				@Override
				public Object parseLiteral(Object input) throws CoercingParseLiteralException {
					return parseInput(input);
				}
			}).description("a scalar to hold a Date").build();

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
		if (input instanceof Integer || input instanceof Long) {
			// Calculate the offset because the Timestamp is actually time-zoned and not UTC
			Instant instant = Instant.ofEpochMilli(Long.parseLong(input.toString()));
			ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
			return new Timestamp(Long.parseLong(input.toString()) - zonedDateTime.getOffset().getTotalSeconds() * 1000L);
		} else if (input instanceof String) {
			try {
				return new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(input.toString()).getTime());
			} catch (Exception ignored) {
			}
			try {
				return new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(input.toString()).getTime());
			} catch (Exception ignored) {
			}
			try {
				return new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(input.toString()).getTime());
			} catch (Exception ignored) {
			}
			try {
				return new Timestamp(new SimpleDateFormat("yyyy/MM/dd").parse(input.toString()).getTime());
			} catch (Exception ignored) {
			}
		}
		throw new CoercingSerializeException("Could not parse input to date: " + input);
	}
}
