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

import org.eclipse.wazaabi.engine.edp.DeclaratedAdapterFactory;
import org.eclipse.wazaabi.engine.edp.adapters.EventAdapter;
import org.eclipse.wazaabi.mm.edp.events.Event;

public interface EventAdapterFactory extends DeclaratedAdapterFactory {

	public EventAdapter createEventAdapter(Object callingContext, Event event);

}
