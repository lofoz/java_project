package Toolbox;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import Entities.Camera;
import RenderEngine.DisplayManager;

public class MousePicker {
	private Vector3f currentRay;

	private Matrix4f projectionMatrix;
	private Matrix4f viewMatrix;
	private Camera camera;

	public MousePicker(Camera cam, Matrix4f projection) {
		this.camera = cam;
		this.projectionMatrix = projection;
		this.viewMatrix = Maths.createViewMatrix(camera);
	}

	public Vector3f getCurrentRay() {
		return currentRay;
	}

	public void update(Camera cam) {
		this.camera = cam;
		viewMatrix = Maths.createViewMatrix(cam);
		currentRay = calculateMouseRay();
	}

	private Vector3f calculateMouseRay() {
		// got the viewport space position
		float mouseX = DisplayManager.getWIDTH() / 2.f;
		float mouseY = DisplayManager.getHEIGHT() / 2.f;
//		System.out.print(mouseX);
//		System.out.print(" ");
//		System.out.println(mouseY);

		// convert from Viewport(screen) Space into openGL coordinates System
		Vector2f normalizedCoords = getNormalizedDeviceCoords(mouseX, mouseY);
		// convert from Normalized Device Space into Homogeneous Clip Space
		Vector4f clipCoords = new Vector4f(normalizedCoords.x, normalizedCoords.y, -1f, 1f);
		// covert from Clip Space into Eye Space
		Vector4f eyeCoords = toEyeCoords(clipCoords);
		// convert from Eye Space into World Space
		Vector3f worldRay = toWorldCoords(eyeCoords);

		return worldRay;
	}

	private Vector3f toWorldCoords(Vector4f eyeCoords) {
		Matrix4f invertedView = Matrix4f.invert(viewMatrix, null);
		Vector4f rayWorld = Matrix4f.transform(invertedView, eyeCoords, null);
		Vector3f mouseRay = new Vector3f(rayWorld.x, rayWorld.y, rayWorld.z);

		mouseRay.normalise();
		return mouseRay;
	}

	private Vector4f toEyeCoords(Vector4f clipCoords) {

		Matrix4f invertedProjection = Matrix4f.invert(projectionMatrix, null);
		Vector4f eyeCoords = Matrix4f.transform(invertedProjection, clipCoords, null);

		return new Vector4f(eyeCoords.x, eyeCoords.y, -1f, 0);

	}

	private Vector2f getNormalizedDeviceCoords(float mouseX, float mouseY) {

		// LWJGL screen system, origin is at bottom left corner instead of top left
		// corner
		float x = (2f * mouseX) / Display.getWidth() - 1f;
		float y = (2f * mouseY) / Display.getHeight() - 1f;

		return new Vector2f(x, y);
	}
}
