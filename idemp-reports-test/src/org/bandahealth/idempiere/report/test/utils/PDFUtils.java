package org.bandahealth.idempiere.report.test.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFUtils {
	/**
	 * Get the text displayed in a PDF file
	 *
	 * @param pdfFile The file to read the text from
	 * @return The text of the PDF file
	 * @throws IOException An error when reading the file
	 */
	public static String readPdfContent(File pdfFile) throws IOException {
		return readPdfContent(pdfFile, false);
	}

	/**
	 * Get the text displayed in a PDF file
	 *
	 * @param pdfFile         The file to read the text from
	 * @param replaceNewLines Whether new line characters should be replaced in the string (to make it easier for text
	 *                         matching)
	 * @return The text of the PDF file with/without newlines
	 * @throws IOException An error when reading the file
	 */
	public static String readPdfContent(File pdfFile, boolean replaceNewLines) throws IOException {
		PDDocument doc = PDDocument.load(pdfFile);
		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		String content = pdfTextStripper.getText(doc);
		doc.close();
		if (replaceNewLines) {
			return content.replace("\r\n", " ").replace("\n", " ");
		}
		return content;
	}
}
