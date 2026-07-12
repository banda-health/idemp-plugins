package org.bandahealth.idempiere.graphql;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.graphql.model.AuthenticationCookie;
import org.bandahealth.idempiere.graphql.queue.QueueEventBroadcaster;
import org.bandahealth.idempiere.graphql.queue.QueueRoleMapping;
import org.bandahealth.idempiere.graphql.utils.AuthenticationUtil;
import org.compiere.model.MUser;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * SSE endpoint for real-time queue-arrival notifications. A connecting user is subscribed to the
 * channel(s) their role is allowed to see - the channel is always derived server-side from their
 * validated role, never taken from the client, since the event payload includes patient name.
 */
public class QueueEventsEndpoint extends HttpServlet {
	private final CLogger logger = CLogger.getCLogger(QueueEventsEndpoint.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServerContext.setCurrentInstance(new Properties());

		Cookie authenticationCookie = AuthenticationCookie.getAuthenticationCookie(request);
		if (authenticationCookie == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		Properties idempiereContext = new Properties();
		idempiereContext.putAll(ServerContext.getCurrentInstance());
		try {
			AuthenticationUtil.validate(authenticationCookie.getValue(), idempiereContext);
		} catch (Exception exception) {
			logger.warning("Rejected queue-events connection: " + exception.getMessage());
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		int AD_Role_ID = Env.getContextAsInt(idempiereContext, Env.AD_ROLE_ID);
		int AD_User_ID = Env.getContextAsInt(idempiereContext, Env.AD_USER_ID);
		if (AD_Role_ID <= 0 || AD_User_ID <= 0) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		String processStageValue = QueueRoleMapping.getProcessStageValueForRole(idempiereContext, AD_Role_ID, null);
		if (processStageValue == null) {
			// Not a single, unambiguous queue-visible role - nothing to subscribe to
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		String channel = processStageValue;
		if (QueueRoleMapping.CLINICIAN_PROCESS_STAGE_VALUE.equals(processStageValue) &&
				QueueRoleMapping.isClinicianSpecificRole(idempiereContext, AD_Role_ID, null)) {
			MUser currentUser = MUser.get(idempiereContext, AD_User_ID);
			channel = QueueEventBroadcaster.clinicianChannel(currentUser.getAD_User_UU());
		}

		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");

		AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(0);
		String subscribedChannel = channel;
		asyncContext.addListener(new AsyncListener() {
			@Override
			public void onComplete(AsyncEvent event) {
				QueueEventBroadcaster.getInstance().unsubscribe(subscribedChannel, asyncContext);
			}

			@Override
			public void onError(AsyncEvent event) {
				QueueEventBroadcaster.getInstance().unsubscribe(subscribedChannel, asyncContext);
			}

			@Override
			public void onTimeout(AsyncEvent event) {
				QueueEventBroadcaster.getInstance().unsubscribe(subscribedChannel, asyncContext);
			}

			@Override
			public void onStartAsync(AsyncEvent event) {
				// Intentionally left blank
			}
		});

		QueueEventBroadcaster.getInstance().subscribe(channel, asyncContext);
		response.getWriter().write(": connected\n\n");
		response.getWriter().flush();
	}
}
