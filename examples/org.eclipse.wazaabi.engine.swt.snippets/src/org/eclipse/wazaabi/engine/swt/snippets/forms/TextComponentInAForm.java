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

package org.eclipse.wazaabi.engine.swt.snippets.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wazaabi.engine.swt.forms.nonosgi.SWTFormsHelper;
import org.eclipse.wazaabi.engine.swt.nonosgi.SWTHelper;
import org.eclipse.wazaabi.engine.swt.viewers.SWTControlViewer;
import org.eclipse.wazaabi.mm.core.styles.BooleanRule;
import org.eclipse.wazaabi.mm.core.styles.CoreStylesFactory;
import org.eclipse.wazaabi.mm.core.styles.StringRule;
import org.eclipse.wazaabi.mm.core.widgets.Container;
import org.eclipse.wazaabi.mm.core.widgets.CoreWidgetsFactory;
import org.eclipse.wazaabi.mm.core.widgets.TextComponent;
import org.eclipse.wazaabi.mm.edp.events.EDPEventsFactory;
import org.eclipse.wazaabi.mm.edp.events.Event;
import org.eclipse.wazaabi.mm.edp.handlers.EDPHandlersFactory;
import org.eclipse.wazaabi.mm.edp.handlers.EventHandler;
import org.eclipse.wazaabi.mm.edp.handlers.Validator;
import org.eclipse.wazaabi.mm.swt.styles.RowLayoutRule;
import org.eclipse.wazaabi.mm.swt.styles.SWTStylesFactory;

public class TextComponentInAForm {

	public static void main(String[] args) {

		// create the shell
		Display display = new Display();
		Shell mainShell = new Shell(display, SWT.SHELL_TRIM);
		mainShell.setLayout(new FillLayout());
		mainShell.setSize(300, 300);

		// create the viewer
		SWTControlViewer viewer = new SWTControlViewer(mainShell);

		// init SWT Engine in standalone mode
		SWTFormsHelper.init(viewer);
		SWTHelper.init(viewer);

		// create a container and set its layout
		Container container = CoreWidgetsFactory.eINSTANCE.createContainer();
		StringRule laf = CoreStylesFactory.eINSTANCE.createStringRule();
		laf.setPropertyName("look-and-feel");
		laf.setValue("form");
		container.getStyleRules().add(laf);

		// inject the container into the viewer
		viewer.setContents(container);

		RowLayoutRule layoutRule = SWTStylesFactory.eINSTANCE
				.createRowLayoutRule();
		layoutRule.setPropertyName("layout");
		container.getStyleRules().add(layoutRule);

		TextComponent text = CoreWidgetsFactory.eINSTANCE.createTextComponent();

		// We add a default error text for being sure that the validation text
		// will override it
		text.setErrorText("default error text");

		EventHandler handler = EDPHandlersFactory.eINSTANCE
				.createEventHandler();
		Validator validator = EDPHandlersFactory.eINSTANCE.createValidator();
		validator
				.setUri("platform:/plugin/test.handlers/test.handlers.Less5CharsValidator");
		handler.getExecutables().add(validator);
		Event event = EDPEventsFactory.eINSTANCE.createEvent();
		event.setId("core:ui:text:modify");
		handler.getEvents().add(event);

		text.getHandlers().add(handler);

		// append the button to the container's children list.
		container.getChildren().add(text);

		// We add a boolean rule then we are sure that he swt widget has been
		// recreated. We want to know if the swt listeners have well be
		// reassigned

		BooleanRule b = CoreStylesFactory.eINSTANCE.createBooleanRule();
		text.getStyleRules().add(b);
		b.setPropertyName("border");
		b.setValue(true);

		StringRule r = CoreStylesFactory.eINSTANCE.createStringRule();
		r.setPropertyName("title");
		container.getStyleRules().add(r);
		r.setValue("Hello World");

		// for testing dynamic support of removal addition of StyleRule
		container.getStyleRules().remove(r);
		container.getStyleRules().add(r);

		mainShell.open();

		while (!mainShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
