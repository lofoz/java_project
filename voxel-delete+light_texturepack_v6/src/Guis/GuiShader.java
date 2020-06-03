package Guis;

import org.lwjgl.util.vector.Matrix4f;

import Shaders.ShaderProgram;

public class GuiShader extends ShaderProgram{
	
	private static final String VERTEX_FILE = "src/guis/guiVertexShader.txt";
	private static final String FRAGMENT_FILE = "src/guis/guiFragmentShader.txt";
	
	private int location_transformationMatrix;

	public GuiShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}
	
	public void loadTransformation(Matrix4f matrix){
		super.loadMatrix(location_transformationMatrix, matrix);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}

	@Override
	protected void getAllUniformLocation() {
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		
	}

	
	
	

}