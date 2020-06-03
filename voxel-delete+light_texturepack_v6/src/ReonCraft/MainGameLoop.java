package ReonCraft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import Chunks.Chunk;
import Chunks.ChunkMesh;
import Controls.DestroyBlock;
import Controls.MouseControl;
import Controls.SLBlocks;
import Cube.Block;
import Cube.BlockModel;
import Entities.Camera;
import Entities.Entity;
import Entities.Light;
import Guis.GuiTexture;
import Models.AtlasCubeModel;
import Models.CubeModel;
import Models.RawModel;
import Models.TexturedModel;
import RenderEngine.DisplayManager;
import RenderEngine.GuiRenderer;
import RenderEngine.Loader;
import RenderEngine.MasterRenderer;
import Shaders.StaticShader;
import Textures.ModelTexture;
import Toolbox.Maths;
import Toolbox.MousePicker;
import Toolbox.PerlinNoiseGenerator;
import User.User;

public class MainGameLoop {

	public static Loader loader1 = null;
	public static StaticShader shader1 = null;

	static List<ChunkMesh> chunks = Collections.synchronizedList(new ArrayList<ChunkMesh>());
	static Vector3f camPos = new Vector3f(0, 0, 0);
	static List<Vector3f> usedPos = new ArrayList<Vector3f>();

	static List<Entity> entities = new ArrayList<Entity>();

	static final int WORLD_SIZE = 3 * 32;

	static boolean closeDisplay = false;

	public static void main(String[] args) {

		DisplayManager.createDisplay();

		Loader loader = new Loader();
		loader1 = loader;
		StaticShader shader = new StaticShader();
		shader1 = shader;
		MasterRenderer renderer = new MasterRenderer();

		RawModel model = loader.loadToVAO(CubeModel.vertices, CubeModel.textureCoords, CubeModel.normals,
				CubeModel.indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("TexturePack_64x64"));
		TexturedModel texModel = new TexturedModel(model, texture);

		texture.setShineDamper(10.f);
		texture.setReflectivity(0.5f);

		Light light = new Light(new Vector3f(15, 100, 200), new Vector3f(1, 1, 1));
		Camera camera = new Camera(new Vector3f(30, 15, 30), 0, 0, 0);

		PerlinNoiseGenerator generator = new PerlinNoiseGenerator();

		MousePicker picker = new MousePicker(camera, renderer.getProjectionMatrix());

		new Thread(new Runnable() {
			public void run() {
				List<Block> blocksInit = null;
				while (!closeDisplay) {
					// save block
//					System.out.println(SLBlocks.save);
					if (SLBlocks.save.compareAndSet(true, false)) {
						for (int i = 0; i < chunks.size(); i++) {
							if (chunks.get(i).chunk.origin.x == 0.f && chunks.get(i).chunk.origin.y == 0.f
									&& chunks.get(i).chunk.origin.z == 0.f) {
								blocksInit = new ArrayList<Block>(chunks.get(i).chunk.blocks);
								SLBlocks.writeObjectToFile(blocksInit);
								break;
							}
						}
					}
					if (SLBlocks.load.compareAndSet(true, false)) {
						blocksInit = (List<Block>) SLBlocks.readObjectFromFile();
						Chunk chunk = new Chunk(blocksInit, new Vector3f(0 * 32, 0, 0 * 32));
						ChunkMesh mesh = new ChunkMesh(chunk);

						for (int i = 0; i < chunks.size(); i++) {
							if (chunks.get(i).chunk.origin.x == 0.f && chunks.get(i).chunk.origin.y == 0.f
									&& chunks.get(i).chunk.origin.z == 0.f) {
								chunks.remove(i);
							}
						}
						for (int i = 0; i < usedPos.size(); i++) {
							if (usedPos.get(i).x == 0.f && usedPos.get(i).y == 0.f && usedPos.get(i).z == 0.f) {
								usedPos.remove(i);
							}
						}
						for (int i = 0; i < entities.size(); i++) {
							if (entities.get(i).getPosition().x == 0.f && entities.get(i).getPosition().y == 0.f && entities.get(i).getPosition().z == 0.f) {
								entities.remove(i);
							}
						}
						chunks.add(mesh);
						usedPos.add(new Vector3f(0 * 32, 0 * 32, 0 * 32));
						SLBlocks.refresh.set(true);
						continue;
					}
					for (int x = (int) (camPos.x - WORLD_SIZE) / 32; x < (camPos.x + WORLD_SIZE) / 32; x++) {
						for (int z = (int) (camPos.z - WORLD_SIZE) / 32; z < (camPos.z + WORLD_SIZE) / 32; z++) {

							if (!usedPos.contains(new Vector3f(x * 32, 0 * 32, z * 32))) {

								List<Block> blocks = new ArrayList<Block>();

								// the (x =0, z = 0) chunk
								if (x == 0 && z == 0 && SLBlocks.load.compareAndSet(false, false)) {

//									// base
//									for (int i = 0; i < 32; i++) {
//										for (int j = 0; j < 32; j++) {
//											if(i == 1 || i == 30 || j == 1 || j == 30)
//												continue;
//											blocks.add(new Block(i, 0, j, Block.TYPE.DIRT_GRASS)); // the top of the terrain
//										}
//									}
//									for (int i = 1; i <= 30; i++) {
//										blocks.add(new Block(i, 0, 1, Block.TYPE.SAND));
//										blocks.add(new Block(i, 0, 30, Block.TYPE.SAND));
//										blocks.add(new Block(1, 0, i, Block.TYPE.SAND));
//										blocks.add(new Block(30, 0, i, Block.TYPE.SAND));
//									}
//									
//									// block building
//									for(int i = 0; i < BlockModel.Building2.length / 4; i++) {
//											blocks.add(new Block(BlockModel.Building2[i*4], BlockModel.Building2[i*4+1], BlockModel.Building2[i*4+2], Block.TYPE.fromValue(BlockModel.Building2[i*4+3])));
//									}

									//////////////////////////////////////////////////////////
									// base
									for (int i = 0; i < 32; i++) {
										for (int j = 0; j < 32; j++) {
											blocks.add(new Block(i, 0, j, Block.TYPE.BETTER_STONE));
										}
									}

									// block building
									for (int i = 0; i < BlockModel.Building.length / 4; i++) {
										for (int j = 1; j <= 10; j++)
											blocks.add(new Block(BlockModel.Building[i * 4], j,
													BlockModel.Building[i * 4 + 2], Block.TYPE.STONE_BRICK_CRACKED));
									}
									// top roof
									for (int i = 11; i <= 20; i++) {
										if (i == 15 || i == 16) {
											for (int j = 11; j <= 14; j++)
												blocks.add(new Block(i, 11, j, Block.TYPE.STONE_BRICK_CRACKED));
											for (int j = 17; j <= 20; j++)
												blocks.add(new Block(i, 11, j, Block.TYPE.QUARTZ_PILLAR));
										} else {
											for (int j = 11; j <= 20; j++) {
												blocks.add(new Block(i, 11, j, Block.TYPE.COBBLE_BRICK));
											}
										}
									}

									Chunk chunk = new Chunk(blocks, new Vector3f(x * 32, 0, z * 32));
									ChunkMesh mesh = new ChunkMesh(chunk);
//									System.out.print(chunks.size());
									chunks.add(mesh);
//									System.out.print(chunks.size());
									usedPos.add(new Vector3f(x * 32, 0 * 32, z * 32));

									continue;
								}

								if (x <= 1 && z <= 1) {

									// base
									for (int i = 0; i < 32; i++) {
										for (int j = 0; j < 32; j++) {
											blocks.add(new Block(i, 0, j, Block.TYPE.DIRT_GRASS)); // the top of the
																									// terrain
										}
									}

									Chunk chunk = new Chunk(blocks, new Vector3f(x * 32, 0, z * 32));
									ChunkMesh mesh = new ChunkMesh(chunk);

									chunks.add(mesh);
									usedPos.add(new Vector3f(x * 32, 0 * 32, z * 32));

									continue;
								}

								for (int i = 0; i < 32; i++) {
									for (int j = 0; j < 32; j++) {

										int max = 5;
										int min = 2;
										Random random = new Random();
										int Height = (int) generator.generateHeight(i + (x * 32), j + (z * 32));
										blocks.add(new Block(i, Height, j, Block.TYPE.DIRT_GRASS)); // the top of the
																									// terrain

										int t = 0;
										for (int h = 1; h <= random.nextInt((max - min) + 1) + min; h++) {
											int initHeight = Height - h;
											blocks.add(new Block(i, initHeight, j, Block.TYPE.DIRT_GRASS)); // texture
																											// beneath
											// the terrain
											if (initHeight > t && i == 0 && j == 0 && x == 0 && z == 0)
												t = initHeight;
										}
										if (x == 0 && z == 0 && i == 0 && j == 0) {
											System.out.println(t);
											camera.initHeight(t + 4);
										}
//										blocks.add(
//												new Block(i, (int) generator.generateHeight(i + (x * 32), j + (z * 32)),
//														j, Block.GRASS));

									}
								}

								for (int i = 0; i < BlockModel.Building.length / 4; i++) {
									blocks.add(new Block(BlockModel.Building[i * 4], BlockModel.Building[i * 4 + 1],
											BlockModel.Building[i * 4 + 2],
											Block.TYPE.fromValue(BlockModel.Building[i * 4 + 3])));
								}

								Chunk chunk = new Chunk(blocks, new Vector3f(x * 32, 0, z * 32));
								ChunkMesh mesh = new ChunkMesh(chunk);

								chunks.add(mesh);
								usedPos.add(new Vector3f(x * 32, 0 * 32, z * 32));
							}

						}
					}

				}

			}
		}).start();

		/*
		 * List<Block> blocks = new ArrayList<Block>();
		 * 
		 * for (int x = 0; x < 10; x++) { for (int y = 0; y < 10; y++) { for (int z = 0;
		 * z < 10; z++) {
		 * 
		 * blocks.add(new Block(x, y, z, Block.TYPE.DIRT));
		 * 
		 * } } }
		 * 
		 * Chunk chunk = new Chunk(blocks, new Vector3f(0, 0, 0)); ChunkMesh mesh = new
		 * ChunkMesh(chunk);
		 * 
		 * RawModel model123 = loader.loadToVAO(mesh.positions, mesh.uvs); TexturedModel
		 * texModel123 = new TexturedModel(model123, texture); Entity entity = new
		 * Entity(texModel123, new Vector3f(0, 0, 0), 0, 0, 0, 1);
		 */

		// GUI INIT
		List<GuiTexture> guis = new ArrayList<GuiTexture>();
		GuiTexture gui = new GuiTexture(loader.loadTexture("Cross"), new Vector2f(0.f, 0.f),
				new Vector2f(0.05f, 0.05f));
		guis.add(gui);
		User user = new User();
		GuiTexture tex = new GuiTexture(loader.loadTexture("texture/" + Integer.toString(user.chosenTextureID)),
				new Vector2f(-0.75f, -0.75f), new Vector2f(
						0.05f * ((float) DisplayManager.getHEIGHT() / (float) (DisplayManager.getWIDTH())), 0.05f));
		guis.add(tex);
		GuiRenderer guiRenderer = new GuiRenderer(loader);
		int chosenTextureChanged = user.chosenTextureID;
		// Main game loop

		int index = 0;
		while (!Display.isCloseRequested()) {
			camera.move(chunks);
			if (user.chosenTextureID != chosenTextureChanged) {
				guis.remove(1);
				tex = new GuiTexture(loader.loadTexture("texture/" + Integer.toString(user.chosenTextureID)),
						new Vector2f(-0.75f, -0.75f),
						new Vector2f(0.05f * ((float) DisplayManager.getHEIGHT() / (float) (DisplayManager.getWIDTH())),
								0.05f));
				guis.add(tex);
				chosenTextureChanged = user.chosenTextureID;
			}

			camera.mouseGrab(DisplayManager.getWIDTH(), DisplayManager.getHEIGHT());
			picker.update(camera);

			MouseControl.setMouseClick();
			int dindex = DestroyBlock.findBlock(camera.getPosition(), picker.getCurrentRay(), chunks, user);

			if (dindex >= 0) {
				RawModel model123 = loader.loadToVAO(chunks.get(dindex).positions, chunks.get(dindex).uvs,
						chunks.get(dindex).normals);
				TexturedModel texModel123 = new TexturedModel(model123, texture);
				Entity entity = new Entity(texModel123, chunks.get(dindex).chunk.origin, 0, 0, 0, 1);
				for (int i = 0; i < entities.size(); i++) {
					Vector3f origin = entities.get(i).getPosition();
					if (origin.x == chunks.get(dindex).chunk.origin.x && origin.y == chunks.get(dindex).chunk.origin.y
							&& origin.z == chunks.get(dindex).chunk.origin.z) {
						entities.remove(i);
						break;
					}
				}

				entities.add(entity);

				chunks.get(dindex).positions = null;
				chunks.get(dindex).uvs = null;
				chunks.get(dindex).normals = null;
			}
//			System.out.println(picker.getCurrentRay());

			camPos = camera.getPosition();

//			System.out.println(camPos);
			
			if(SLBlocks.refresh.compareAndSet(true, false)) {
				index--;
			}
			
			if (index < chunks.size()) {

				RawModel model123 = loader.loadToVAO(chunks.get(index).positions, chunks.get(index).uvs,
						chunks.get(index).normals);
				TexturedModel texModel123 = new TexturedModel(model123, texture);
				Entity entity = new Entity(texModel123, chunks.get(index).chunk.origin, 0, 0, 0, 1);
				entities.add(entity);

				chunks.get(index).positions = null;
				chunks.get(index).uvs = null;
				chunks.get(index).normals = null;

				index++;

			}

			for (int i = 0; i < entities.size(); i++) {
//				System.out.println(entities.size());
				Vector3f origin = entities.get(i).getPosition();

				int distX = (int) (camPos.x - origin.x);
				int distZ = (int) (camPos.z - origin.z);

				if (distX < 0) {
					distX = -distX;
				}
				if (distZ < 0) {
					distZ = -distZ;
				}

				if ((distX <= WORLD_SIZE) && (distZ <= WORLD_SIZE)) {

					renderer.processEntity(entities.get(i));

				}

			}

			// renderer.addEntity(entity);
			renderer.render(light, camera);
			guiRenderer.render(guis);
			DisplayManager.updateDisplay(camera, user);

		}
		guiRenderer.cleanUp();
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
