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

package org.eclipse.wazaabi.engine.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wazaabi.engine.swt.nonosgi.SWTHelper;
import org.eclipse.wazaabi.engine.swt.viewers.SWTControlViewer;
import org.eclipse.wazaabi.locationpaths.nonosgi.LocationPathsHelper;
import org.eclipse.wazaabi.locator.urn.java.nonosgi.URNJavaLocatorHelper;
import org.eclipse.wazaabi.mm.core.widgets.Container;
import org.eclipse.wazaabi.mm.core.widgets.CoreWidgetsFactory;
import org.eclipse.wazaabi.mm.core.widgets.Spinner;
import org.eclipse.wazaabi.mm.core.widgets.TextComponent;
import org.eclipse.wazaabi.mm.edp.events.EDPEventsFactory;
import org.eclipse.wazaabi.mm.edp.events.Event;
import org.eclipse.wazaabi.mm.edp.handlers.Binding;
import org.eclipse.wazaabi.mm.edp.handlers.Condition;
import org.eclipse.wazaabi.mm.edp.handlers.Converter;
import org.eclipse.wazaabi.mm.edp.handlers.EDPHandlersFactory;
import org.eclipse.wazaabi.mm.edp.handlers.StringParameter;
import org.eclipse.wazaabi.mm.edp.handlers.Validator;
import org.eclipse.wazaabi.mm.swt.styles.GridLayoutRule;
import org.eclipse.wazaabi.mm.swt.styles.SWTStylesFactory;

public class BindingTextComponentsWithException {

	public static void main(String[] args) {
		// create the shell
		Display display = new Display();
		Shell mainShell = new Shell(display, SWT.SHELL_TRIM);
		mainShell.setLayout(new FillLayout());
		mainShell.setSize(300, 300);

		// create the viewer
		SWTControlViewer viewer = new SWTControlViewer(mainShell);

		// init SWT Engine in standalone mode
		SWTHelper.init(viewer);

		// init the 'urn:java' resolver
		URNJavaLocatorHelper.init(viewer);
		LocationPathsHelper.init(viewer);


		
		Container container = CoreWidgetsFactory.eINSTANCE.createContainer();

		GridLayoutRule layoutRule = SWTStylesFactory.eINSTANCE
				.createGridLayoutRule();
		layoutRule.setPropertyName("layout");
		container.getStyleRules().add(layoutRule);
		
		
		// create a PushButton
		TextComponent pushButton = CoreWidgetsFactory.eINSTANCE.createTextComponent();
		pushButton.setText("Hello World"); //$NON-NLS-1$
		
		TextComponent textComponent = CoreWidgetsFactory.eINSTANCE.createTextComponent();
		

		Spinner spinner = CoreWidgetsFactory.eINSTANCE.createSpinner();
		
		TextComponent textComponent2 = CoreWidgetsFactory.eINSTANCE.createTextComponent();
		
		container.getChildren().add(pushButton);
		container.getChildren().add(textComponent);
		container.getChildren().add(spinner);
		container.getChildren().add(textComponent2);
		
		
		Binding eventHandler = EDPHandlersFactory.eINSTANCE.createBinding();
		
		StringParameter source = EDPHandlersFactory.eINSTANCE
				.createStringParameter();
		StringParameter target = EDPHandlersFactory.eINSTANCE
				.createStringParameter();
		source.setName("source");
		source.setValue("@text");
		target.setName("target");
		target.setValue("../TextComponent[1]/@text");
		eventHandler.getParameters().add(source);
		eventHandler.getParameters().add(target);
		

		Converter action = EDPHandlersFactory.eINSTANCE.createConverter();
		action.setUri("urn:java:org.eclipse.wazaabi.engine.swt.snippets.converters.VerySimpleConverter2");
		pushButton.getHandlers().add(eventHandler);		
		
		Validator preConversion = EDPHandlersFactory.eINSTANCE.createValidator();
		preConversion.setUri("urn:java:org.eclipse.wazaabi.engine.swt.snippets.validators.VerySimpleValidator");
		
		Validator postConversion = EDPHandlersFactory.eINSTANCE.createValidator();
		postConversion.setUri("urn:java:org.eclipse.wazaabi.engine.swt.snippets.validators.VerySimpleValidator2");
		
		Event event = EDPEventsFactory.eINSTANCE.createEvent();
		eventHandler.getEvents().add(event);
		eventHandler.getExecutables().add(preConversion);
		eventHandler.getExecutables().add(action);
		eventHandler.getExecutables().add(postConversion);
		event.setId("core:ui:focus:out");
		

		
		Condition condition = EDPHandlersFactory.eINSTANCE.createCondition();
		condition.setUri("urn:java:org.eclipse.wazaabi.engine.swt.snippets.conditions.BadCondition");
		eventHandler.getConditions().add(condition);
		
		
		Binding spinnerToText = EDPHandlersFactory.eINSTANCE.createBinding();
		StringParameter source2 = EDPHandlersFactory.eINSTANCE
				.createStringParameter();
		StringParameter target2 = EDPHandlersFactory.eINSTANCE
				.createStringParameter();
		source2.setName("source");
		source2.setValue("@value");
		target2.setName("target");
		target2.setValue("../TextComponent[2]/@text");
		spinnerToText.getParameters().add(source2);
		spinnerToText.getParameters().add(target2);
		
		Converter int2string = EDPHandlersFactory.eINSTANCE.createConverter();
		int2string.setUri("urn:java:org.eclipse.wazaabi.engine.swt.snippets.converters.Int2StringConverter");
		spinner.getHandlers().add(spinnerToText);
		Event event2 = EDPEventsFactory.eINSTANCE.createEvent();
		spinnerToText.getEvents().add(event2);
		spinnerToText.getExecutables().add(int2string);
		event2.setId("core:ui:focus:out");
		



		// inject the button into the viewer
		viewer.setContents(container);
//		condition.setUri(null);

		//action.setUri(null);
		
		mainShell.open();

		while (!mainShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
