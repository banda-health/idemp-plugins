package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MLanguage;

public class Language extends BaseMetadata {
	private boolean isBaseLanguage;
	private String printName;
	private boolean isSystemLanguage;
	private String languageISO;
	private String locale;

	public Language(MLanguage language) {
		super(language);
		isBaseLanguage = language.isBaseLanguage();
		printName = language.getPrintName();
		isSystemLanguage = language.isSystemLanguage();
		languageISO = language.getLanguageISO();
		locale = language.getAD_Language();
	}

	public boolean getIsBaseLanguage() {
		return isBaseLanguage;
	}

	public void setIsBaseLanguage(boolean baseLanguage) {
		isBaseLanguage = baseLanguage;
	}

	public boolean getIsSystemLanguage() {
		return isSystemLanguage;
	}

	public void setIsSystemLanguage(boolean systemLanguage) {
		isSystemLanguage = systemLanguage;
	}

	public String getLanguageISO() {
		return languageISO;
	}

	public void setLanguageISO(String languageISO) {
		this.languageISO = languageISO;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getPrintName() {
		return printName;
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}
}
