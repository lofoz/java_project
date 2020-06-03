package Controls;

import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import Chunks.ChunkMesh;
import Cube.Block;
import Toolbox.Maths;
import User.User;

public abstract class DestroyBlock {
	static final int WORLD_SIZE = 32;

	public static int findBlock(Vector3f position, Vector3f currentRay, List<ChunkMesh> chunks, User user) {
		if (MouseControl.getMouseLClick() && Mouse.isGrabbed() && PlayState.isCreative()) {
			MouseControl.setMouseLClick(false);
			float x = position.x;
			float y = position.y;
			float z = position.z;
			for (int i = 1; i < 10; i++) {
				x += currentRay.x;
				y += currentRay.y;
				z += currentRay.z;

				for (int j = 0; j < chunks.size(); j++) {
					Vector3f origin = chunks.get(j).chunk.origin;
					if (x >= (float) origin.x && x < (float) (origin.x + WORLD_SIZE) && z >= (float) origin.z
							&& z < (float) (origin.z + WORLD_SIZE)) {
						for (int k = 0; k < chunks.get(j).chunk.blocks.size(); k++) {
//						System.out.println(chunks.size());
							if (
									x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
									x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
									y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
									y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
									z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
									z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
								)
							
							{
								System.out.print(chunks.get(j).chunk.blocks.get(k).x);
								System.out.print(" ");
								System.out.print(chunks.get(j).chunk.blocks.get(k).y);
								System.out.print(" ");
//								System.out.print(chunks.get(j).heights[chunks.get(j).chunk.blocks.get(k).x][chunks.get(j).chunk.blocks.get(k).z]+origin.y);
								System.out.print(" ");
								System.out.println(chunks.get(j).chunk.blocks.get(k).z);
								
								int index = FindtheRightBlock_Delete(x, y, z, currentRay, chunks, j, k, origin);
								//float h = chunks.get(j).chunk.blocks.get(k).y;
								//System.out.print(h);
								//chunks.get(j).heights[chunks.get(j).chunk.blocks.get(k).x][chunks.get(j).chunk.blocks.get(k).z].heights.remove(chunks.get(j).heights[chunks.get(j).chunk.blocks.get(k).x][chunks.get(j).chunk.blocks.get(k).z].heights.indexOf(h));
								chunks.get(j).chunk.blocks.remove(index);
								chunks.get(j).update(chunks.get(j).chunk);
								return j;
							}
						}
					}
//					for (int k = 0; k < chunks.get(j).chunk.blocks.size(); k++) {
////						System.out.println(chunks.size());
//						if (x == (int) (chunks.get(j).chunk.blocks.get(k).x + chunks.get(j).chunk.origin.x)
//								&& y == (int) (chunks.get(j).chunk.blocks.get(k).y + chunks.get(j).chunk.origin.y)
//								&& z == (int) (chunks.get(j).chunk.blocks.get(k).z + chunks.get(j).chunk.origin.z)) {
//							System.out.print(chunks.get(j).chunk.blocks.get(k).x);
//							System.out.print(" ");
//							System.out.print(chunks.get(j).chunk.blocks.get(k).y);
//							System.out.print(" ");
//							System.out.println(chunks.get(j).chunk.blocks.get(k).z);
//							chunks.get(j).chunk.blocks.remove(k);
//							chunks.get(j).update(chunks.get(j).chunk);
//							return j;
//						}
//					}
				}
			}
		}
		else if(MouseControl.getMouseRClick() && Mouse.isGrabbed() && PlayState.isCreative()) {
			MouseControl.setMouseRClick(false);
			float x = position.x;
			float y = position.y;
			float z = position.z;
			for (int i = 1; i < 10; i++) {
				x += currentRay.x;
				y += currentRay.y;
				z += currentRay.z;

				for (int j = 0; j < chunks.size(); j++) {
					Vector3f origin = chunks.get(j).chunk.origin;
					if (x >= (float) origin.x && x < (float) (origin.x + WORLD_SIZE) && z >= (float) origin.z
							&& z < (float) (origin.z + WORLD_SIZE)) {
						for (int k = 0; k < chunks.get(j).chunk.blocks.size(); k++) {
//						System.out.println(chunks.size());
							if (
									x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
									x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
									y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
									y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
									z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
									z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
								)
							
							{
								
								// print out picked cube
								System.out.println("start");
								System.out.print(chunks.get(j).chunk.blocks.get(k).x);
								System.out.print(" ");
								System.out.print(chunks.get(j).chunk.blocks.get(k).y);
								System.out.print(" ");
//								System.out.print(chunks.get(j).heights[chunks.get(j).chunk.blocks.get(k).x][chunks.get(j).chunk.blocks.get(k).z]+origin.y);
								System.out.print(" ");
								System.out.println(chunks.get(j).chunk.blocks.get(k).z);
								
								Vector3f answer = FindtheRightBlock(x, y, z, currentRay, chunks, j, k, origin);
								System.out.printf("answer: %f, %f, %f\n", answer.x, answer.y, answer.z);
								
								chunks.get(j).chunk.blocks.add(new Block((int)(answer.x), (int)(answer.y), (int)(answer.z), Block.TYPE.fromValue(user.chosenTextureID)));
								
								//float h = chunks.get(j).chunk.blocks.get(k).y;
								//System.out.print(h);
								//chunks.get(j).heights[chunks.get(j).chunk.blocks.get(k).x][chunks.get(j).chunk.blocks.get(k).z].heights.remove(chunks.get(j).heights[chunks.get(j).chunk.blocks.get(k).x][chunks.get(j).chunk.blocks.get(k).z].heights.indexOf(h));
								chunks.get(j).update(chunks.get(j).chunk);
								return j;
							}
						}
					}
				}
			}
		}
		return -1;
	}
	
		static int FindtheRightBlock_Delete(float x, float y, float z, Vector3f currentRay, List<ChunkMesh> chunks,
			int j, int k,Vector3f origin) {
		System.out.printf("x:%f, y:%f, z:%f\n", x, y, z);
		System.out.printf("bx:%d, by:%d, bz:%d\n", chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z);
		System.out.println(k);
		int index = k;
		if (
				x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
				x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
				y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
				y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
				z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
				z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
			)
		
		{
			
			// print out picked cube
			System.out.println("In FindtheRightBlock IF");
			
			float x_back = x - currentRay.x;
			float y_back = y - currentRay.y;
			float z_back = z - currentRay.z;
			
			float px = (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f);
			float nx = (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f);
			float py = (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f);
			float ny = (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f);
			float pz = (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f);
			float nz = (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f);
			
			
//			x = ox + c1t
//			t = (x - ox) / c1
//			y = oy + c2t
//			z = oz + c3t
			
			// px
			float t = (px - x_back) / currentRay.x;
			float y_px = y_back + t * currentRay.y;
			float z_px = z_back + t * currentRay.z;
			
			if(y_px < py && y_px > ny && z_px < pz && z_px > nz && t >= 0 && t <= 1) {
				System.out.println("px");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x + 1, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 1.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					index = FindtheRightBlock_Delete(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					;
				}
			}
			
			// nx
			t = (nx - x_back) / currentRay.x;
			float y_nx = y_back + t * currentRay.y;
			float z_nx = z_back + t * currentRay.z;
			
			if(y_nx < py && y_nx > ny && z_nx < pz && z_nx > nz && t >= 0 && t <= 1) {
				System.out.println("nx");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x - 1, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 1.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					index = FindtheRightBlock_Delete(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					;
				}
			}

			// py
			t = (py - y_back) / currentRay.y;
			float x_py = x_back + t * currentRay.x;
			float z_py = z_back + t * currentRay.z;
			
			if(x_py < px && x_py > nx && z_py < pz && z_py > nz && t >= 0 && t <= 1) {
				System.out.println("py");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y + 1, chunks.get(j).chunk.blocks.get(k).z);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 1.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					index = FindtheRightBlock_Delete(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					;
				}
			}
			
			// ny
			t = (ny - y_back) / currentRay.y;
			float x_ny = x_back + t * currentRay.x;
			float z_ny = z_back + t * currentRay.z;
			
			if(x_ny < px && x_ny > nx && z_ny < pz && z_ny > nz && t >= 0 && t <= 1) {
				System.out.println("ny");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y - 1, chunks.get(j).chunk.blocks.get(k).z);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 1.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					index = FindtheRightBlock_Delete(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					;
				}
			}
			
			// pz
			t = (pz - z_back) / currentRay.z;
			float x_pz = x_back + t * currentRay.x;
			float y_pz = y_back + t * currentRay.y;
			
			if(x_pz < px && x_pz > nx && y_pz < py && y_pz > ny && t >= 0 && t <= 1) {
				System.out.println("pz");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z + 1);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 1.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					index = FindtheRightBlock_Delete(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					;
				}
			}

			// nz
			t = (nz - z_back) / currentRay.z;
			float x_nz = x_back + t * currentRay.x;
			float y_nz = y_back + t * currentRay.y;
			
			if(x_nz < px && x_nz > nx && y_nz < py && y_nz > ny && t >= 0 && t <= 1) {
				System.out.println("nz");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z - 1);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 1.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					index = FindtheRightBlock_Delete(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					;
				}
			}
		}
		return index;
	}
	
	static Vector3f FindtheRightBlock(float x, float y, float z, Vector3f currentRay, List<ChunkMesh> chunks,
			int j, int k,Vector3f origin) {
		System.out.printf("x:%f, y:%f, z:%f\n", x, y, z);
		System.out.printf("bx:%d, by:%d, bz:%d\n", chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z);
		System.out.println(k);
		Vector3f answer = new Vector3f(0, 0, 0);
		if (
				x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
				x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
				y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
				y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
				z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
				z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
			)
		
		{
			
			// print out picked cube
			System.out.println("In FindtheRightBlock IF");
			
			float x_back = x - currentRay.x;
			float y_back = y - currentRay.y;
			float z_back = z - currentRay.z;
			
			float px = (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f);
			float nx = (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f);
			float py = (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f);
			float ny = (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f);
			float pz = (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f);
			float nz = (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f);
			
			
//			x = ox + c1t
//			t = (x - ox) / c1
//			y = oy + c2t
//			z = oz + c3t
			
			// px
			float t = (px - x_back) / currentRay.x;
			float y_px = y_back + t * currentRay.y;
			float z_px = z_back + t * currentRay.z;
			
			if(y_px < py && y_px > ny && z_px < pz && z_px > nz && t >= 0 && t <= 1) {
				System.out.println("px");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x + 1, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 1.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					answer = FindtheRightBlock(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					answer.x = chunks.get(j).chunk.blocks.get(k).x + 1;
					answer.y = chunks.get(j).chunk.blocks.get(k).y;
					answer.z = chunks.get(j).chunk.blocks.get(k).z;
				}
			}
			
			// nx
			t = (nx - x_back) / currentRay.x;
			float y_nx = y_back + t * currentRay.y;
			float z_nx = z_back + t * currentRay.z;
			
			if(y_nx < py && y_nx > ny && z_nx < pz && z_nx > nz && t >= 0 && t <= 1) {
				System.out.println("nx");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x - 1, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 1.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					answer = FindtheRightBlock(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					answer.x = chunks.get(j).chunk.blocks.get(k).x - 1;
					answer.y = chunks.get(j).chunk.blocks.get(k).y;
					answer.z = chunks.get(j).chunk.blocks.get(k).z;
				}
			}

			// py
			t = (py - y_back) / currentRay.y;
			float x_py = x_back + t * currentRay.x;
			float z_py = z_back + t * currentRay.z;
			
			if(x_py < px && x_py > nx && z_py < pz && z_py > nz && t >= 0 && t <= 1) {
				System.out.println("py");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y + 1, chunks.get(j).chunk.blocks.get(k).z);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 1.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					answer = FindtheRightBlock(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					answer.x = chunks.get(j).chunk.blocks.get(k).x;
					answer.y = chunks.get(j).chunk.blocks.get(k).y + 1;
					answer.z = chunks.get(j).chunk.blocks.get(k).z;
				}
			}
			
			// ny
			t = (ny - y_back) / currentRay.y;
			float x_ny = x_back + t * currentRay.x;
			float z_ny = z_back + t * currentRay.z;
			
			if(x_ny < px && x_ny > nx && z_ny < pz && z_ny > nz && t >= 0 && t <= 1) {
				System.out.println("ny");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y - 1, chunks.get(j).chunk.blocks.get(k).z);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 1.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					answer = FindtheRightBlock(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					answer.x = chunks.get(j).chunk.blocks.get(k).x;
					answer.y = chunks.get(j).chunk.blocks.get(k).y - 1;
					answer.z = chunks.get(j).chunk.blocks.get(k).z;
				}
			}
			
			// pz
			t = (pz - z_back) / currentRay.z;
			float x_pz = x_back + t * currentRay.x;
			float y_pz = y_back + t * currentRay.y;
			
			if(x_pz < px && x_pz > nx && y_pz < py && y_pz > ny && t >= 0 && t <= 1) {
				System.out.println("pz");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z + 1);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 0.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z + 1.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					answer = FindtheRightBlock(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					answer.x = chunks.get(j).chunk.blocks.get(k).x;
					answer.y = chunks.get(j).chunk.blocks.get(k).y;
					answer.z = chunks.get(j).chunk.blocks.get(k).z + 1;
				}
			}

			// nz
			t = (nz - z_back) / currentRay.z;
			float x_nz = x_back + t * currentRay.x;
			float y_nz = y_back + t * currentRay.y;
			
			if(x_nz < px && x_nz > nx && y_nz < py && y_nz > ny && t >= 0 && t <= 1) {
				System.out.println("nz");
				int new_k = hasBlock(chunks, j, chunks.get(j).chunk.blocks.get(k).x, chunks.get(j).chunk.blocks.get(k).y, chunks.get(j).chunk.blocks.get(k).z - 1);
				if(new_k != -1) {
					boolean reach = false;
					float new_x = x;
					float new_y = y;
					float new_z = z;
					while(!reach) {
						new_x = (float)(new_x-currentRay.x*0.01);
						new_y = (float)(new_y-currentRay.y*0.01);
						new_z = (float)(new_z-currentRay.z*0.01);
						if (
								new_x > (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x - 0.5f) &&
								new_x < (float) (chunks.get(j).chunk.blocks.get(k).x + origin.x + 0.5f) &&
								new_y > (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y - 0.5f) &&
								new_y < (float) (chunks.get(j).chunk.blocks.get(k).y + origin.y + 0.5f) &&
								new_z > (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 1.5f) &&
								new_z < (float) (chunks.get(j).chunk.blocks.get(k).z + origin.z - 0.5f)
							) {
							reach = true;
						}
					}
					
					System.out.printf("K_old: %d, K_new: %d\n", k, new_k);
					answer = FindtheRightBlock(new_x, new_y, new_z, currentRay, chunks, j, new_k, origin);
				}
				else {
					answer.x = chunks.get(j).chunk.blocks.get(k).x;
					answer.y = chunks.get(j).chunk.blocks.get(k).y;
					answer.z = chunks.get(j).chunk.blocks.get(k).z - 1;
				}
			}
		}
		return new Vector3f(answer.x, answer.y, answer.z);
	}
	
	static int hasBlock(List<ChunkMesh> chunks, int j, float x, float y, float z) {
		
		for(int i = 0; i < chunks.get(j).chunk.blocks.size(); i++) {
			if(chunks.get(j).chunk.blocks.get(i).x == x &&
					chunks.get(j).chunk.blocks.get(i).y == y &&
					chunks.get(j).chunk.blocks.get(i).z == z)
			{
				System.out.printf("%f, %f, %f Found k:%d\n",x,y,z, i);
				return i;
			}
		}
		System.out.printf("%f, %f, %f NotFound\n",x,y,z);
		return -1;
		
	}
}
