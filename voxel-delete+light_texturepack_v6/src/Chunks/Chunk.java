package Chunks;

import java.io.Serializable;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import Cube.Block;

public class Chunk implements Serializable {
	
	public List<Block> blocks;
	public Vector3f origin;
	
	public Chunk(List<Block> blocks, Vector3f origin) {
		
		this.blocks = blocks;
		this.origin = origin;
		
	}

}
