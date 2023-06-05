package org.bandahealth.idempiere.report.test.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
		return getHeaderRow(sheet, headerRowStartingColumnText, sheet.getFirstRowNum());
	}

	/**
	 * Get the header row of a table in a spreadsheet given the text that should be in the table's first cell (though
	 * not necessarily the first column of the spreadsheet) from a given starting row index (in case a sheet has multiple
	 * tables in it)
	 *
	 * @param sheet                       The spreadsheet to search through
	 * @param headerRowStartingColumnText The text of the tables first cell
	 * @param startingRowIndex            The row from which to start searching
	 * @return The header row
	 */
	public static Row getHeaderRow(Sheet sheet, String headerRowStartingColumnText, int startingRowIndex) {
		for (int i = startingRowIndex; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (StreamSupport.stream(row.spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().equalsIgnoreCase(headerRowStartingColumnText))) {
				return row;
			}
		}
		fail("Header row exists");
		return null;
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

	/**
	 * Provided the header row of a table, get the column index for the column containing the specified header text
	 *
	 * @param headerRow        The header row of the table
	 * @param columnHeaderText The header text of the desired column
	 * @return The column index
	 */
	public static int getColumnIndexContaining(Row headerRow, String columnHeaderText) {
		int columnIndex = -1;
		for (int i = headerRow.getFirstCellNum(); i < headerRow.getLastCellNum(); i++) {
			if (headerRow.getCell(i) != null && headerRow.getCell(i).getCellType().equals(CellType.STRING) &&
					headerRow.getCell(i).getStringCellValue().toLowerCase().contains(columnHeaderText.toLowerCase())) {
				columnIndex = i;
				break;
			}
		}
		assertTrue(columnIndex > -1, "Column with text " + columnHeaderText + " exists");
		return columnIndex;
	}

	/**
	 * Get the index of the provided row in the sheet
	 *
	 * @param sheet The spreadsheet to search through
	 * @param row   The row in the sheet to get the index of
	 * @return The row index
	 */
	public static int getIndexOfRow(Sheet sheet, Row row) {
		int rowIndex = -1;
		for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
			if (sheet.getRow(i) == row) {
				rowIndex = i;
				break;
			}
		}
		return rowIndex;
	}
}
