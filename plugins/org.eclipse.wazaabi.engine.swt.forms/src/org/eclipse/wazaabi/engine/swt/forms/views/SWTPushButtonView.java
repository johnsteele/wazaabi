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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class SWTPushButtonView extends
		org.eclipse.wazaabi.engine.swt.commons.views.SWTPushButtonView {

	private final FormToolkit formToolkit;

	public SWTPushButtonView(FormToolkit formToolkit) {
		this.formToolkit = formToolkit;
	}

	/**
	 * private for avoiding the use of this constructor
	 */
	@SuppressWarnings("unused")
	private SWTPushButtonView() {
		this.formToolkit = null;
	}

	@Override
	protected Widget createSWTWidget(Widget parent, int swtStyle, int index) {
		return formToolkit.createButton((Composite) parent, null,
				computeSWTCreationStyle(getHost()));
	}
}