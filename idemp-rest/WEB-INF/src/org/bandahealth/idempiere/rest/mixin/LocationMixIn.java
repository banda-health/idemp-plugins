package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MLocation;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"country", "countryName", "region", "regionName", "addressLinesReverse",
		"cityRegionPostal", "mapsLocation", "errorMessage", "c_AddressValidation", "c_City", "c_Country", "c_Region"})
public abstract class LocationMixIn extends MLocation implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public LocationMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}
}
