package org.bandahealth.idempiere.rest.provider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

/**
 * For some reason iDempiere 11 doesn't like the default JacksonJsonProvider, so force it to
 */
@Provider
@Produces("application/json")
@Consumes("application/json")
public class BandaJsonProvider extends JacksonJsonProvider {
}
