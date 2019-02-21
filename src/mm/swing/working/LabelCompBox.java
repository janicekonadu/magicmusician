package mm.swing.working;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class LabelCompBox extends Box {
	private static final long serialVersionUID = 1L;
	private JComponent component;

	public LabelCompBox(String label, JComponent component) {
		super(BoxLayout.X_AXIS);
		this.component = component;
		this.add(new JLabel(label + ": "));
		this.add(Box.createHorizontalGlue());
		this.add(component);
	}
	
	public JComponent getComponent() {
		return this.component;
	}
}
