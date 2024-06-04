package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MCountry;
import org.compiere.model.MRegion;

public class MLocationInput extends X_C_LocationInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Location_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MLocationInput(@JsonProperty("UU") String UUID, @JsonProperty("C_Country") ForeignEntityInput C_CountryInput,
			@JsonProperty("C_Region") ForeignEntityInput C_RegionInput) {
		super(UUID);
		setC_CountryInput(C_CountryInput);
		setCountry(getC_Country_ID() > 0 ? MCountry.get(getC_Country_ID()) : null);
		setC_RegionInput(C_RegionInput);
		setRegion(getC_Region_ID() > 0 ? MRegion.get(getC_Region_ID()) : null);
	}
}
