package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MLanguage;

public class Language {
	private String uuid;
	private boolean isBaseLanguage;
	private String printName;
	private boolean isSystemLanguage;
	private boolean isActive;
	private String languageISO;
	private String locale;

	public Language(MLanguage language) {
		uuid = language.getAD_Language_UU();
		isBaseLanguage = language.isBaseLanguage();
		printName = language.getPrintName();
		isSystemLanguage = language.isSystemLanguage();
		isActive = language.isActive();
		languageISO = language.getLanguageISO();
		locale = language.getAD_Language();
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean active) {
		isActive = active;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
