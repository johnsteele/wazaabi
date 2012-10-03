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

package org.eclipse.wazaabi.engine.edp.events;

import org.eclipse.wazaabi.engine.edp.DeclaratedFactory;
import org.eclipse.wazaabi.engine.edp.adapters.EventHandlerAdapter;
import org.eclipse.wazaabi.mm.edp.handlers.EventHandler;

public interface EventHandlerAdapterFactory extends DeclaratedFactory {

	public EventHandlerAdapter createEventHandlerAdapter(Object context,
			EventHandler eventHandler);

}
