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

package org.eclipse.wazaabi.engine.core.stylerules.factories;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.wazaabi.engine.core.editparts.AbstractComponentEditPart;
import org.eclipse.wazaabi.engine.core.stylerules.managers.BarLayoutStyleRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.BooleanStyleRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.ColorStyleRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.ExpandLayoutRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.ExpandRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.FontRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.HyperlinkRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.IntRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.MarkerManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.OrientationStyleRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.SashFormLayoutStyleRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.SashRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.ScrollbarRuleMananger;
import org.eclipse.wazaabi.engine.core.stylerules.managers.StringRuleManager;
import org.eclipse.wazaabi.engine.core.stylerules.managers.TabIndexRuleManager;
import org.eclipse.wazaabi.mm.core.styles.CoreStylesPackage;
import org.eclipse.wazaabi.mm.core.styles.StyleRule;

public class CoreStyleRuleManagerFactory implements StyleRuleManagerFactory {

	public static final String FACTORY_ID = CoreStyleRuleManagerFactory.class
			.getName();

	public void platformSpecificRefresh(Object context, StyleRule rule) {
		// nothing to do here since by definition, the core bundle is not
		// platform specific
	}

	public void platformSpecificUpdate(Object context, StyleRule rule) {
		// nothing to do here since by definition, the core bundle is not
		// platform specific
	}

	public Object convertIntoPlatformSpecificObject(Object context,
			StyleRule rule) {
		// nothing to do and return here since by definition, the core bundle is
		// not platform specific
		return null;
	}

	@Override
	public Object createComponent(Object callingContext, Object model,
			Object creationHint) {
		if (model instanceof StyleRule) {
			StyleRule rule = (StyleRule) model;
			if (rule != null
					&& CoreStylesPackage.eNS_URI.equals(rule.eClass()
							.getEPackage().getNsURI()))
				switch (rule.eClass().getClassifierID()) {
				case CoreStylesPackage.SCROLL_BAR_RULE:
					return new ScrollbarRuleMananger();
				case CoreStylesPackage.COLOR_RULE:
					return new ColorStyleRuleManager();
				case CoreStylesPackage.STRING_RULE:
					return new StringRuleManager();
				case CoreStylesPackage.BOOLEAN_RULE:
					return new BooleanStyleRuleManager();
				case CoreStylesPackage.ORIENTATION_RULE:
					return new OrientationStyleRuleManager();
				case CoreStylesPackage.INT_RULE:
					if (AbstractComponentEditPart.TAB_INDEX_PROPERTY_NAME
							.equals(rule.getPropertyName()))
						return new TabIndexRuleManager();
					return new IntRuleManager();
				case CoreStylesPackage.FONT_RULE:
					return new FontRuleManager();
				case CoreStylesPackage.MARKER:
					return new MarkerManager();
				case CoreStylesPackage.BAR_LAYOUT_RULE:
					return new BarLayoutStyleRuleManager();
				case CoreStylesPackage.EXPAND_LAYOUT_RULE:
					return new ExpandLayoutRuleManager();
				case CoreStylesPackage.EXPAND_RULE:
					return new ExpandRuleManager();
				case CoreStylesPackage.SASH_FORM_LAYOUT_RULE:
					return new SashFormLayoutStyleRuleManager();
				case CoreStylesPackage.HYPERLINK_RULE:
					return new HyperlinkRuleManager();
				case CoreStylesPackage.SASH_RULE:
					return new SashRuleManager();
				}
		}
		return null;

	}

	@Override
	public boolean isFactoryFor(Object callingContext, Object model,
			Object creationHint) {
		if (!(model instanceof EObject))
			return false;
		EObject rule = (EObject) model;
		if (!CoreStylesPackage.eNS_URI.equals(rule.eClass().getEPackage()
				.getNsURI()))
			return false;
		switch (rule.eClass().getClassifierID()) {
		case CoreStylesPackage.COLOR_RULE:
		case CoreStylesPackage.STRING_RULE:
		case CoreStylesPackage.BOOLEAN_RULE:
		case CoreStylesPackage.INT_RULE:
		case CoreStylesPackage.ORIENTATION_RULE:
		case CoreStylesPackage.FONT_RULE:
		case CoreStylesPackage.MARKER:
		case CoreStylesPackage.BAR_LAYOUT_RULE:
		case CoreStylesPackage.EXPAND_LAYOUT_RULE:
		case CoreStylesPackage.EXPAND_RULE:
		case CoreStylesPackage.SASH_FORM_LAYOUT_RULE:
		case CoreStylesPackage.HYPERLINK_RULE:
		case CoreStylesPackage.SASH_RULE:
			return true;
		}
		return false;
	}

	@Override
	public String getFactoryID() {
		return FACTORY_ID;
	}
}
