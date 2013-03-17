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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wazaabi.engine.swt.viewers.SWTControlViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelDisplayService {

	private final static Logger logger = LoggerFactory
			.getLogger(ModelDisplayService.class);

	private boolean isActive = false;


	public void activate() {
		if (isActive)
			return;
		openViewer();
		isActive = true;
		logger.debug("Service Activated");
	}

	public void deactivate() {
		if (!isActive)
			return;
		isActive = false;
		logger.debug("Service deactivated");
	}

	protected boolean isActive() {
		return isActive;
	}

	public void processCommand(String command) {
		if (isActive()) {
			if ("open\r\n".equals(command))
				openViewer();
			else if ("close\r\n".equals(command))
				closeViewer();
			else if (command != null && !command.isEmpty()) {
				XMIResource res = new XMIResourceImpl();
				ByteArrayInputStream bin;
				try {
					bin = new ByteArrayInputStream(command.getBytes("UTF-8"));
					res.load(bin, null);
					if (!res.getContents().isEmpty())
						// System.out.println(res.getContents().get(0));
						setContents(res.getContents().get(0));
				} catch (UnsupportedEncodingException e) {
					logger.error("{}\n{}",
							new Object[] { e.getMessage(), e.getCause() });
				} catch (IOException e) {
					logger.error("Unable to convert strean into AbstractComponent");
				}
			}
		}
	}

	private static class ViewerThread extends Thread {

		private Display display = null;
		private SWTControlViewer viewer = null;

		@Override
		public void interrupt() {
			super.interrupt();
			if (display != null && !display.isDisposed()) {
				display.syncExec(new Runnable() {

					public void run() {
						display.dispose();
						display = null;
						viewer = null;
					}
				});
			}
			logger.debug("end of ViewerThread interrupt method");
		}

		@Override
		public void run() {
			display = new Display();
			Shell mainShell = new Shell(display, SWT.SHELL_TRIM);
			mainShell.setLayout(new FillLayout());
			mainShell.setSize(300, 300);

			viewer = new SWTControlViewer(mainShell);
			mainShell.open();

			while (!mainShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			if (display != null && !display.isDisposed()) {
				display.dispose();
				display = null;
				viewer = null;
			}
			logger.debug("End of ViewerThread run method");
		}

		public void setContents(final Object contents) {
			if (viewer != null && display != null && !display.isDisposed())
				display.asyncExec(new Runnable() {

					public void run() {
						logger.debug("setContents {}", contents);
						viewer.setContents(contents);
						if (viewer.getControl() != null
								&& !viewer.getControl().isDisposed()
								&& viewer.getControl().getParent() instanceof Composite)
							((Composite) viewer.getControl().getParent())
									.layout(true, true);
					}
				});
		}
	};

	private ViewerThread viewerThread = null;

	protected void openViewer() {
		if (viewerThread != null && viewerThread.isAlive())
			viewerThread.interrupt();
		viewerThread = new ViewerThread();
		viewerThread.start();
	}

	protected void closeViewer() {
		if (viewerThread != null && viewerThread.isAlive())
			viewerThread.interrupt();
		viewerThread = null;
	}

	protected void setContents(Object contents) {
		if (!viewerThread.isInterrupted())
			viewerThread.setContents(contents);
	}
}