package RenderEngine;

import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

import Entities.Entity;
import Models.RawModel;
import Models.TexturedModel;
import Shaders.StaticShader;
import Textures.ModelTexture;
import Toolbox.Maths;

public class EntityRenderer {
	
	private StaticShader shader;
	
	public EntityRenderer(StaticShader shader, Matrix4f projectionMatrix) {
		this.shader = shader;
		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);
		shader.stop();
	}
	
	public void render(Map<TexturedModel, List<Entity>> entities) {
		for(TexturedModel model:entities.keySet()) {
			prepareTexturedModel(model);
			List<Entity> batch = entities.get(model);
			for(Entity entity:batch) {
				
				prepareInstance(entity);
				
				// draw with indices
				//GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
				
				//draw  without  indices
				GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getModel().getVertexCount());
				
			}
			unbindTexturedModel();
		}
	}
	
	private void prepareTexturedModel(TexturedModel model) {
		// binding model and enable vertices
		RawModel rawModel = model.getModel();
		GL30.glBindVertexArray(rawModel.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);	// normal for light
		// textured stuff
		ModelTexture texture = model.getTexture();
		shader.loadShineVariables(texture.getShineDamper(), texture.getReflectivity());
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getTextureID());
	}
	
	private void unbindTexturedModel() {
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);
		GL30.glBindVertexArray(0);
	}
	
	private void prepareInstance(Entity entity) {
		Matrix4f transformationMatrix = Maths.transformationMatrix(entity.getPosition(),
				entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
		shader.loadTransformationMatrix(transformationMatrix);
	}
	
	
	/*
	 * Renders a model to the screen.
	 * 
	 * Before we can render a VAO it needs to be made active, and we can do this
	 * by binding it. We also need to enable the relevant attributes of the VAO,
	 * which in this case is just attribute 0 where we stored the position data.
	 * 
	 * The VAO can then be rendered to the screen using glDrawArrays(). We tell
	 * it what type of shapes to render and the number of vertices that it needs
	 * to render.
	 * 
	 * After rendering we unbind the VAO and disable the attribute.
	 */
}