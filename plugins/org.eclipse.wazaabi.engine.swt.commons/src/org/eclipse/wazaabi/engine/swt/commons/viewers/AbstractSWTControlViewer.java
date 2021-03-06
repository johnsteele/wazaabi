package org.eclipse.wazaabi.engine.swt.commons.viewers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.widgets.Control;
import org.eclipse.wazaabi.engine.core.gef.EditPart;
import org.eclipse.wazaabi.engine.core.gef.RootEditPart;
import org.eclipse.wazaabi.engine.swt.commons.editparts.SWTRootEditPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author Olivier Moises
 * 
 */
public abstract class AbstractSWTControlViewer extends AbstractSWTViewer {

	final static Logger logger = LoggerFactory
			.getLogger(AbstractSWTControlViewer.class);

	// PROPOSAL : not sure to keep it
	protected static org.eclipse.wazaabi.mm.core.widgets.AbstractComponent getModelComponent(
			String uri) {
		Resource resource = new ResourceSetImpl().getResource(
				URI.createURI(uri), true);
		if (resource.getEObject("/") instanceof org.eclipse.wazaabi.mm.core.widgets.AbstractComponent)
			return (org.eclipse.wazaabi.mm.core.widgets.AbstractComponent) resource
					.getEObject("/");
		return null;
	}

	public AbstractSWTControlViewer(org.eclipse.swt.widgets.Composite parent,
			SWTRootEditPart rootEditPart) {
		super(parent);
		setRootEditPart(rootEditPart);
	}

	public AbstractSWTControlViewer(org.eclipse.swt.widgets.Composite parent) {
		this(parent, new SWTRootEditPart());
	}

	public Control getControl() {
		return (Control) getWidget();
	}

	public EditPart getContents() {
		if (getRootEditPart() == null)
			return null;
		return getRootEditPart().getContents();
	}

	public void setRootEditPart(RootEditPart editpart) {
		assert editpart == null || editpart instanceof SWTRootEditPart;
		super.setRootEditPart(editpart);
		if (!getRootEditPart().isActive())
			getRootEditPart().activate();
	}

}
