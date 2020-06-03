package Controls;

import org.lwjgl.input.Mouse;

public abstract class MouseControl {
	private static boolean mouseRClick = false;
	private static boolean mouseLClick = false;

	public static boolean getMouseRClick() {
		return mouseRClick;
	}

	public static boolean getMouseLClick() {
		return mouseLClick;
	}

	public static void setMouseClick() {
		while (Mouse.next() && Mouse.isGrabbed() && PlayState.isCreative()) {
			if (Mouse.getEventButtonState()) {
				if (Mouse.isButtonDown(0)) {
					mouseLClick = true;
				} else {
					mouseLClick = false;
				}
				if (Mouse.isButtonDown(1)) {
					mouseRClick = true;
				} else {
					mouseRClick = false;
				}
			}
		}
	}

	public static void setMouseRClick(boolean mouseRClick) {
		MouseControl.mouseRClick = mouseRClick;
	}

	public static void setMouseLClick(boolean mouseLClick) {
		MouseControl.mouseLClick = mouseLClick;
	}

}
