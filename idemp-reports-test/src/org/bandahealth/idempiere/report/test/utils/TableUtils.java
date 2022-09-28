package org.bandahealth.idempiere.report.test.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableUtils {
	/**
	 * Get the header row of a table in a spreadsheet given the text that should be in the table's first cell (though
	 * not necessarily the first column of the spreadsheet)
	 *
	 * @param sheet                       The spreadsheet to search through
	 * @param headerRowStartingColumnText The text of the tables first cell
	 * @return The header row
	 */
	public static Row getHeaderRow(Sheet sheet, String headerRowStartingColumnText) {
		Optional<Row> headerRow = StreamSupport.stream(sheet.spliterator(), false).filter(
						row -> row.getCell(row.getFirstCellNum()) != null &&
								row.getCell(row.getFirstCellNum()).getCellType().equals(CellType.STRING) &&
								row.getCell(row.getFirstCellNum()).getStringCellValue().equalsIgnoreCase(headerRowStartingColumnText))
				.findFirst();
		assertTrue(headerRow.isPresent(), "Header row exists");
		return headerRow.get();
	}

	/**
	 * Provided the header row of a table, get the column index for the column with the specified header text
	 *
	 * @param headerRow        The header row of the table
	 * @param columnHeaderText The header text of the desired column
	 * @return The column index
	 */
	public static int getColumnIndex(Row headerRow, String columnHeaderText) {
		int columnIndex = -1;
		for (int i = headerRow.getFirstCellNum(); i < headerRow.getLastCellNum(); i++) {
			if (headerRow.getCell(i) != null && headerRow.getCell(i).getCellType().equals(CellType.STRING) &&
					headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(columnHeaderText)) {
				columnIndex = i;
				break;
			}
		}
		assertTrue(columnIndex > -1, columnHeaderText + " column exists");
		return columnIndex;
	}
}
