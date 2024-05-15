package org.bandahealth.idempiere.graphql.scalar;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * A custom scalar to allow passing of Date classes into the GraphQL API
 */
public class FileScaler {
	public static final GraphQLScalarType File = GraphQLScalarType.newScalar().name("File")
			.coercing(new Coercing() {
				@Override
				public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
					if (dataFetcherResult == null) {
						return null;
					}
					if (dataFetcherResult instanceof File) {
						File file = (File) dataFetcherResult;
						String contentType;
						byte[] data;
						try {
							contentType = Files.probeContentType(file.toPath());
							data = Files.readAllBytes(file.toPath());
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
						String base64str = Base64.getEncoder().encodeToString(data);
						return "data:" + contentType + ";base64," + base64str;
					}
					throw new CoercingSerializeException("Could not serialize to data URL: " + dataFetcherResult);
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
			int dataStartIndex = ((String) input).indexOf(",") + 1;
			if (dataStartIndex != 0) {
				return Base64.getDecoder().decode(((String) input).substring(dataStartIndex));
			}
		}
		throw new CoercingSerializeException("Could not parse input to binary: " + input);
	}
}
