package Cube;

import java.io.Serializable;

import Cube.Block.TYPE;

public class Block implements Serializable {
	
	public int x, y, z;
	
	public static enum TYPE {
		
		DIRT, DIRT_GRASS, STONE, LOG, LEAVES, SAND, PODZOL, WHITE_GLASS, BLACK_GLASS,
		TNT, JUNGLE_PLANK, WHITE_CLAY, BLACK_CLAY, QUARTZ_PILLAR, STONE_BRICK_CRACKED, COBBLE_BRICK, OAK_PLANK, BETTER_STONE, GRAY_CLAY;
		
		public static TYPE fromValue(int value) {
	        for (TYPE my: TYPE.values()) {
	            if (my.ordinal() == value) {
	                return my;
	            }
	        }
	 
	        return null;
	    }
		
	};
	
	public TYPE type;
	
	public Block(int x, int y, int z, TYPE type) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.type = type;
		
	}

}
