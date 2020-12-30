package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"country", "countryName", "region", "regionName", "addressLinesReverse",
		"cityRegionPostal", "mapsLocation", "errorMessage", "c_AddressValidation", "c_City", "c_Country", "c_Region"})
public abstract class LocationMixIn extends POMixIn {
}
