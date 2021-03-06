/*******************************************************************************
 * Copyright (c) 2008 Olivier Moises
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Olivier Moises- initial API and implementation
 *******************************************************************************/

package org.eclipse.wazaabi.engine.core.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.wazaabi.engine.core.views.ScaleView;
import org.eclipse.wazaabi.engine.edp.CompareUtils;
import org.eclipse.wazaabi.mm.core.widgets.CoreWidgetsPackage;
import org.eclipse.wazaabi.mm.core.widgets.Scale;

public class ScaleEditPart extends AbstractComponentEditPart {
	public static final String MAXIMUM_PROPERTY_NAME = "maximum"; //$NON-NLS-1$
	public static final String MINIMUM_PROPERTY_NAME = "minimum"; //$NON-NLS-1$
	public static final String ORIENTATION_PROPERTY_NAME = "orientation"; //$NON-NLS-1$
	public static final String INCREMENT_PROPERTY_NAME = "increment"; //$NON-NLS-1$
	public static final String PAGEINCREMENT_PROPERTY_NAME = "pageIncrement"; //$NON-NLS-1$

	public EClass getModelEClass() {
		return CoreWidgetsPackage.Literals.SCALE;
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (getWidgetView() instanceof ScaleView) {
			switch (notification.getFeatureID(Scale.class)) {
			case CoreWidgetsPackage.SCALE__VALUE:
				if (!CompareUtils.areEquals(
						((ScaleView) getWidgetView()).getValue(),
						notification.getNewIntValue())) {
					((ScaleView) getWidgetView()).setValue(notification
							.getNewIntValue());
					getWidgetView().fireWidgetViewRepainted();
				}
				break;
			default:
				super.notifyChanged(notification);
			}
		}
	}

	public void refreshFeaturesAndStyles() {
		super.refreshFeaturesAndStyles();
		ScaleView view = ((ScaleView) getWidgetView());

		refreshUniqueStyleRule(ORIENTATION_PROPERTY_NAME);
		refreshUniqueStyleRule(MAXIMUM_PROPERTY_NAME);
		refreshUniqueStyleRule(MINIMUM_PROPERTY_NAME);
		refreshUniqueStyleRule(INCREMENT_PROPERTY_NAME);
		refreshUniqueStyleRule(PAGEINCREMENT_PROPERTY_NAME);

		view.setValue(((Scale) getModel()).getValue());

		// view.updatePlatformSpecificStyleProperties(((StyledElement)
		// getModel())
		// .getStyleRules());
	}

}
