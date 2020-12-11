package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"info", "language", "locale", "acctSchema", "requestUser", "requestUserPW",
		"smtpport", "smtphost", "ad_PasswordRule", "ad_ReplicationStrategy"})
public abstract class ClientMixIn extends POMixIn {
}
