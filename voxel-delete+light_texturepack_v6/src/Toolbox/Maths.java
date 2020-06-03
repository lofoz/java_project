package Toolbox;

import java.util.Collections;
import java.util.List;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector2f;

import Entities.Camera;

public class Maths {

	public static Matrix4f createTransformationMatrix(Vector2f translation, Vector2f scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.scale(new Vector3f(scale.x, scale.y, 1f), matrix, matrix);
		return matrix;
	}
	
	public static Matrix4f transformationMatrix(Vector3f translation, float rotX, float rotY, float rotZ, float scale) {

		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();

		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotX), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotY), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotZ), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.scale(new Vector3f(scale, scale, scale), matrix, matrix);

		return matrix;

	}

	public static Matrix4f createViewMatrix(Camera camera) {

		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();

		Matrix4f.rotate((float) Math.toRadians(camera.getRotX()), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getRotY()), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getRotZ()), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.translate(new Vector3f(-camera.getPosition().x, -camera.getPosition().y, -camera.getPosition().z),
				matrix, matrix);

		return matrix;

	}

	public static float search(List<Float> heights, float value) {
		Collections.sort(heights);

		if (value < heights.get(0)) {
			return heights.get(0);
		}
		if (value > heights.get(heights.size() - 1)) {
			return heights.get(heights.size() - 1);
		}

		int lo = 0;
		int hi = heights.size() - 1;

		while (lo <= hi) {
			int mid = (hi + lo) / 2;

			if (value < heights.get(mid)) {
				hi = mid - 1;
			} else if (value > heights.get(mid)) {
				lo = mid + 1;
			} else {
				return heights.get(mid);
			}
		}
		// lo == hi + 1
		return (heights.get(lo) - value) < (value - heights.get(hi)) ? heights.get(lo) : heights.get(hi);
	}

}
