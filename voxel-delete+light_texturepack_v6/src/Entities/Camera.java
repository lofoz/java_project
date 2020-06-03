package Entities;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import Chunks.ChunkMesh;
import Controls.PlayState;
import Toolbox.Maths;

public class Camera {
	static final int WORLD_SIZE = 32;
	static final float TIME_STEP = 1 / 55.f;
	static final float GRAVITY = 9.81f;
	float yVelocity;
	float xPosition;
	float yPosition;
	float zPosition;
	float pre_y;
	boolean jumping;
	boolean ground;
	boolean initHeight;

	Vector3f position;
	float rotX;
	float rotY;
	float rotZ;

	private static float speed = 0.3f;
	private static float turnSpeed = 0.1f;

	public static void setSpeed(float speed) {
		Camera.speed = speed;
	}

	public static void setTurnSpeed(float turnSpeed) {
		Camera.turnSpeed = turnSpeed;
	}

//	float moveAt = 0;

	public Camera(Vector3f position, float rotX, float rotY, float rotZ) {

		this.position = position;
		this.xPosition = position.x;
		this.yPosition = position.y;
		this.zPosition = position.z;
		this.pre_y = position.y;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.jumping = false;
		this.ground = true;
		this.initHeight = false;
	}

	public void initHeight(float height) {
		this.position.y = height;
		this.yPosition = height;
	}

	public void move(List<ChunkMesh> chunks) {
//		if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_D)) {
//			moveAt = -speed;
//		} else if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_A)) {
//			moveAt = speed;
//		} else {
//			moveAt = 0;
//		}

//		System.out.println(Mouse.getDY());
		if (rotX < 90.f && rotX > -90.f) {
			rotX += -Mouse.getDY() * turnSpeed;

//			System.out.println(rotX);

		} else if (rotX >= 90.f) {
			float rotdx = Mouse.getDY() * turnSpeed;
			if (rotdx > 0)
				rotX += -rotdx;
		} else if (rotX <= -90.f) {
			float rotdx = Mouse.getDY() * turnSpeed;
			if (rotdx < 0)
				rotX += -rotdx;
		}
		rotY += Mouse.getDX() * turnSpeed;

		float dx = (float) -(speed * Math.sin(Math.toRadians(rotY)));
		float dy = (float) (speed * Math.sin(Math.toRadians(rotX)));
		float dz = (float) (speed * Math.cos(Math.toRadians(rotY)));

		if (Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xPosition += (-dx + dz) * 0.5;
			zPosition -= (dx + dz) * 0.5;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xPosition -= (dx + dz) * 0.5;
			zPosition += (dx - dz) * 0.5;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xPosition += (dx + dz) * 0.5;
			zPosition += (-dx + dz) * 0.5;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xPosition += (dx - dz) * 0.5;
			zPosition += (dx + dz) * 0.5;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xPosition -= dz;
			zPosition += dx;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xPosition += dz;
			zPosition -= dx;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			xPosition -= dx;
			zPosition -= dz;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			xPosition += dx;
			zPosition += dz;
		}
		if (PlayState.isCreative()) {
			for (int i = 0; i < chunks.size(); i++) {
				Vector3f origin = chunks.get(i).chunk.origin;
				if (this.xPosition >= (int) origin.x && this.xPosition < (int) (origin.x + WORLD_SIZE)
						&& this.zPosition >= (int) origin.z && this.zPosition < (int) (origin.z + WORLD_SIZE)) {
					float xx = (this.xPosition > this.position.x) ? this.xPosition + 0.625f : this.xPosition + 0.375f;
					float zz = (this.zPosition > this.position.z) ? this.zPosition + 0.625f : this.zPosition + 0.375f;
//					xx = this.xPosition;
//					zz = this.zPosition;
//					System.out.print(xx);
//					System.out.print(" ");
//					System.out.print(origin.x);
//					System.out.print(" ");
//					System.out.print(zz);
//					System.out.print(" ");
//					System.out.print(origin.z);
//					System.out.println();
					int ix = (int) (xx - origin.x);
					int iz = (int) (zz - origin.z);
					ix = (ix > 31) ? 31 : (ix < 0) ? 0 : ix;
					iz = (iz > 31) ? 31 : (iz < 0) ? 0 : iz;
					List<Float> heights = chunks.get(i).heights[ix][iz].heights;
					this.yPosition = Maths.search(heights, this.pre_y) + 3;
//					System.out.print(yPosition);
//					for(float fff : heights) {
//						System.out.print(fff);
//						System.out.print(" ");
//						System.out.print(this.position.x);
//						System.out.print(" ");
//						System.out.print(this.position.z);
//						System.out.print(" ");
//						System.out.print(this.position.y);
//						System.out.print(" ");
//					}
//					System.out.println();
					if (this.position.y >= this.yPosition) {
						this.position.x = this.xPosition;
						this.position.z = this.zPosition;
						this.pre_y = this.yPosition;
						if (ground && !jumping) {
//							System.out.println("gggggg");
							if (!this.initHeight) {
								this.position.y = this.yPosition;
								this.initHeight = true;
							} else if(this.position.y == this.yPosition) {
								this.position.y = this.yPosition;
							} else if(this.position.y > this.yPosition) {
								this.pre_y = this.yPosition;
								this.jumping = true;
								this.ground = false;
							}
						}
					} else if (this.position.y < this.yPosition) {
//						System.out.print(xPosition);
//						System.out.print(" ");
//						System.out.print(zPosition);
//						System.out.print(" ");
						this.xPosition = this.position.x;
						this.zPosition = this.position.z;
//						System.out.print(xPosition);
//						System.out.print(" ");
//						System.out.print(zPosition);
//						System.out.println();

//						this.pre_y = (float)Math.ceil(this.position.y);
//						this.position.y = this.yPosition;
					}
//					System.out.println(this.position.y);
				}
			}
		}
//		System.out.print(position.y);
//		System.out.print(" ");
//		System.out.print(this.pre_y);
//		System.out.print(" ");
//		System.out.println(this.yPosition);
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && PlayState.isSpectator()) {
			position.y += dy;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && !jumping && ground && PlayState.isCreative()) {
			jumping = true;
			ground = false;
			yVelocity = 1;
		}
		if (jumping && position.y < pre_y + 1.25f && PlayState.isCreative()) {
			position.y += yVelocity * TIME_STEP;
//			System.out.println("xdxdxdxd");
			yVelocity += GRAVITY * TIME_STEP;
		} else if (jumping && position.y >= pre_y + 1.25f && PlayState.isCreative()) {
			yVelocity = -1;
			jumping = false;
		} else if (!jumping && !ground && position.y > pre_y && PlayState.isCreative()) {
			position.y += yVelocity * TIME_STEP;
//			System.out.println(position.y);
			yVelocity += (-GRAVITY) * TIME_STEP;
		} else if (!jumping && !ground && position.y <= pre_y && PlayState.isCreative()) {
			ground = true;
//			System.out.println("dsadsad");
			position.y = pre_y;
		}
		if (ground && PlayState.isCreative()) {
			yVelocity = 0;
		}

	}

	public void mouseGrab(int width, int height) {
		if (Mouse.isGrabbed()) {
			Mouse.setCursorPosition(width / 2, height / 2);
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getRotX() {
		return rotX;
	}

	public float getRotY() {
		return rotY;
	}

	public float getRotZ() {
		return rotZ;
	}

}
