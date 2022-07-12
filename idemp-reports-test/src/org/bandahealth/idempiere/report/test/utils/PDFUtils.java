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
		PDDocument doc = PDDocument.load(pdfFile);
		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		String content = pdfTextStripper.getText(doc);
		doc.close();
		return content;
	}
}
