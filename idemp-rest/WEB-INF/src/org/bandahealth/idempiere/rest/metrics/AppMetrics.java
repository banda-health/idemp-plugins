package org.bandahealth.idempiere.rest.metrics;


import java.io.IOException;

import org.springframework.stereotype.Service;

import io.prometheus.client.exporter.HTTPServer;

@Service
public class AppMetrics {

public AppMetrics() throws IOException {
	HTTPServer server = new HTTPServer(9800);
}
}	