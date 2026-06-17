package org.bandahealth.idempiere.base.utils;

import org.compiere.util.Env;
import org.compiere.util.Language;

import java.util.Properties;

/**
 * Helpers for running Jasper reports with a predictable language context.
 */
public final class ReportContextUtil {

	private ReportContextUtil() {
	}

	/**
	 * Run an action with the base (English) language in the context, restoring the original language afterward.
	 * Jasper reports are authored and maintained in the base language; missing {@code AD_Process_Trl} rows for
	 * login locales can otherwise produce blank printouts.
	 */
	public static void withBaseLanguage(Properties ctx, Runnable action) {
		String originalLanguage = Env.getAD_Language(ctx);
		Env.setContext(ctx, Env.LANGUAGE, Language.getBaseAD_Language());
		try {
			action.run();
		} finally {
			Env.setContext(ctx, Env.LANGUAGE, originalLanguage);
		}
	}
}
