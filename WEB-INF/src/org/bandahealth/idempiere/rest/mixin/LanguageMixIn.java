package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"locale", "dateFormat", "ad_PrintPaper"})
public abstract class LanguageMixIn implements POMixIn {
}
