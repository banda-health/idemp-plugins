package org.bandahealth.idempiere.graphql.generator.util;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface ConsumerWithThrows<T> {
	void accept(T t) throws SQLException, FileNotFoundException;
}
