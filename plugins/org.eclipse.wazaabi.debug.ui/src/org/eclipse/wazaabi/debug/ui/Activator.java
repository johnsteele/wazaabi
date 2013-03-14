/*******************************************************************************
 * Copyright (c) 2013 Olivier Moises
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Olivier Moises- initial API and implementation
 *******************************************************************************/

package org.eclipse.wazaabi.debug.ui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

	private final static Logger logger = LoggerFactory
			.getLogger(Activator.class);

	static public final String DISPLAY_SERVICE = "displayService"; //$NON-NLS-1$

	private static BundleContext context;
	private HttpServiceTracker serviceTracker;

	static BundleContext getContext() {
		return context;
	}

	private static ModelDisplayService modelDisplay = null;

	public static ModelDisplayService getModelDisplay() {
		return modelDisplay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {

		if (bundleContext.getProperty(DISPLAY_SERVICE) != null) {

			serviceTracker = new HttpServiceTracker(bundleContext);
			serviceTracker.open();

			// logger.debug("Starting ModelDisplayService listening on port {}",
			// port);
			modelDisplay = new ModelDisplayService();
			modelDisplay.activate();
		}
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		if (modelDisplay != null) {
			logger.debug("ending ModelDisplayService");
			modelDisplay.deactivate();
			modelDisplay = null;
			serviceTracker.close();
			serviceTracker = null;
		}
		Activator.context = null;
	}

	public void processCommand(String command) {
	}

}
