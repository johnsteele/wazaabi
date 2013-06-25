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

package org.eclipse.wazaabi.engine.swt.forms.views;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wazaabi.engine.core.editparts.ContainerEditPart;
import org.eclipse.wazaabi.engine.core.editparts.WidgetEditPart;
import org.eclipse.wazaabi.engine.core.gef.EditPart;

public class SWTFormsUtils {

	/**
	 * Looks up into containment hierarchy and returns the {@link FormToolkit}
	 * of the container which owns a {@link Form} widget if exists. Returns null
	 * otherwise.
	 * 
	 * @param host
	 *            A non null <code>EditPart</code>
	 * @return A {@link FormToolkit} if this host is a descendant of an EditPart
	 *         which owns a {@link Form}, null otherwise
	 */
	public static FormToolkit getFormToolkit(WidgetEditPart host) {
		EditPart parent = host;
		while ((parent = parent.getParent()) != null) {
			if (parent instanceof ContainerEditPart
					&& ((ContainerEditPart) parent).getWidgetView() instanceof SWTContainerView)
				return ((SWTContainerView) ((ContainerEditPart) parent)
						.getWidgetView()).getFormToolkit();
		}
		return null;
	}

}
