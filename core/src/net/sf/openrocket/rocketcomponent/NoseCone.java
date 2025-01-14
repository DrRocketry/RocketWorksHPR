package net.sf.openrocket.rocketcomponent;

import net.sf.openrocket.appearance.Appearance;
import net.sf.openrocket.appearance.Decal;
import net.sf.openrocket.l10n.Translator;
import net.sf.openrocket.preset.ComponentPreset;
import net.sf.openrocket.preset.ComponentPreset.Type;
import net.sf.openrocket.startup.Application;
import net.sf.openrocket.util.StateChangeListener;

import java.util.EventObject;

/**
 * Rocket nose cones of various types.  Implemented as a transition with the
 * fore radius == 0.
 *
 * @author Sampo Niskanen <sampo.niskanen@iki.fi>
 */

public class NoseCone extends Transition implements InsideColorComponent {
	private static final Translator trans = Application.getTranslator();

	private InsideColorComponentHandler insideColorComponentHandler = new InsideColorComponentHandler(this);
	
	/********* Constructors **********/
	public NoseCone() {
		this(Transition.Shape.OGIVE, 6 * DEFAULT_RADIUS, DEFAULT_RADIUS);
	}
	
	public NoseCone(Transition.Shape type, double length, double radius) {
		super();
		super.setType(type);
		super.setForeRadiusAutomatic(false);
		super.setForeRadius(0);
		super.setForeShoulderLength(0);
		super.setForeShoulderRadius(0.9 * radius);
		super.setForeShoulderThickness(0);
		super.setForeShoulderCapped(filled);
		super.setThickness(0.002);
		super.setLength(length);
		super.setClipped(false);
		
		super.setAftRadiusAutomatic(false);
		super.setAftRadius(radius);

		super.displayOrder_side = 1;		// Order for displaying the component in the 2D side view
		super.displayOrder_back = 0;		// Order for displaying the component in the 2D back view
	}
	
	
	/********** Get/set methods for component parameters **********/
	
	@Override
	public double getForeRadius() {
		return 0;
	}
	
	@Override
	public void setForeRadius(double r) {
		// No-op
	}
	
	@Override
	public boolean isForeRadiusAutomatic() {
		return false;
	}
	
	@Override
	public void setForeRadiusAutomatic(boolean b) {
		// No-op
	}

	@Override
	public boolean usesPreviousCompAutomatic() {
		return false;
	}

	@Override
	public double getForeShoulderLength() {
		return 0;
	}
	
	@Override
	public double getForeShoulderRadius() {
		return 0;
	}
	
	@Override
	public double getForeShoulderThickness() {
		return 0;
	}
	
	@Override
	public boolean isForeShoulderCapped() {
		return false;
	}
	
	@Override
	public void setForeShoulderCapped(boolean capped) {
		// No-op
	}
	
	@Override
	public void setForeShoulderLength(double foreShoulderLength) {
		// No-op
	}
	
	@Override
	public void setForeShoulderRadius(double foreShoulderRadius) {
		// No-op
	}
	
	@Override
	public void setForeShoulderThickness(double foreShoulderThickness) {
		// No-op
	}
	
	@Override
	public boolean isClipped() {
		return false;
	}
	
	@Override
	public void setClipped(boolean b) {
		// No-op
	}
	
	

	/********** RocketComponent methods **********/
	
	@Override
	public Type getPresetType() {
		return ComponentPreset.Type.NOSE_CONE;
	}

	@Override
	protected void loadFromPreset(ComponentPreset preset) {
		
		//Many parameters are handled by the super class Transition.loadFromPreset
		super.loadFromPreset(preset);
	}

	/**
	 * Return component name.
	 */
	@Override
	public String getComponentName() {
		//// Nose cone
		return trans.get("NoseCone.NoseCone");
	}


	@Override
	public InsideColorComponentHandler getInsideColorComponentHandler() {
		return this.insideColorComponentHandler;
	}

	@Override
	public void setInsideColorComponentHandler(InsideColorComponentHandler handler) {
		this.insideColorComponentHandler = handler;
	}
}
