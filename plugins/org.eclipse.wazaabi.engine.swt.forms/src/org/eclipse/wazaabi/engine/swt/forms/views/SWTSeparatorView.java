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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

public class SWTSeparatorView extends
		org.eclipse.wazaabi.engine.swt.commons.views.SWTSeparatorView {

	private final SWTContainerView containingForm;

	public SWTSeparatorView(SWTContainerView containingForm) {
		this.containingForm = containingForm;
	}

	/**
	 * private for avoiding the use of this constructor
	 */
	@SuppressWarnings("unused")
	private SWTSeparatorView() {
		this.containingForm = null;
	}

	protected Widget createSWTWidget(Widget parent, int swtStyle, int index) {
		if (containingForm == null || containingForm.getFormToolkit() == null)
			return super.createSWTWidget(parent, swtStyle, index);
		Label label = containingForm.getFormToolkit().createSeparator(
				(org.eclipse.swt.widgets.Composite) parent,
				computeSWTCreationStyle(getHost()));
		if (SWTFormsUtils.isDirectChildOfForm(getHost()))
			return label;
		return wrapForSpecificParent((Composite) parent, label);
	}

}
