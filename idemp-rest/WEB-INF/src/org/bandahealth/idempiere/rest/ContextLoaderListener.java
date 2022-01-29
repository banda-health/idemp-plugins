/**
 * 
 */
package org.bandahealth.idempiere.rest;

import java.io.IOException;

import javax.servlet.ServletContextEvent;

import io.prometheus.client.exporter.HTTPServer;

/**
 * @author hengsin
 *
 */
public class ContextLoaderListener extends
		org.springframework.web.context.ContextLoaderListener {

	/**
	 * 
	 */
	public ContextLoaderListener() {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
			HTTPServer server = new HTTPServer(9200);
			System.out.println("Started Prometheus server!");
			super.contextInitialized(event);
		} catch (IOException e) {
			System.out.println("Failed to start prometheus server");
			e.printStackTrace();
		} finally {
			Thread.currentThread().setContextClassLoader(cl);
		}
	}

}
