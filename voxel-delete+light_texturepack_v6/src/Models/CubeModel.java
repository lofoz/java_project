package Models;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class CubeModel {

	
// vertex order always like this:
//	left-top -> left-bottom -> right-top
// 	right-top -> left-bottom -> right->bottom
	
	
	public static Vector3f[] PX_POS = {
			
			new Vector3f(0.5f,0.5f,0.5f),
			new Vector3f(0.5f,-0.5f,0.5f),
			new Vector3f(0.5f,0.5f,-0.5f),
			new Vector3f(0.5f,0.5f,-0.5f),
			new Vector3f(0.5f,-0.5f,0.5f),
			new Vector3f(0.5f,-0.5f,-0.5f)
			
	};
	
	public static Vector3f[] NX_POS = {
			
			new Vector3f(-0.5f,0.5f,-0.5f),
			new Vector3f(-0.5f,-0.5f,-0.5f),
			new Vector3f(-0.5f,0.5f,0.5f),
			new Vector3f(-0.5f,0.5f,0.5f),
			new Vector3f(-0.5f,-0.5f,-0.5f),
			new Vector3f(-0.5f,-0.5f,0.5f)
			
	};
	
	public static Vector3f[] PY_POS = {
			
			new Vector3f(-0.5f,0.5f,-0.5f),
			new Vector3f(-0.5f,0.5f,0.5f),
			new Vector3f(0.5f,0.5f,-0.5f),
			new Vector3f(0.5f,0.5f,-0.5f),
			new Vector3f(-0.5f,0.5f,0.5f),
			new Vector3f(0.5f,0.5f,0.5f)
			
	};
	
	public static Vector3f[] NY_POS = {
			
			new Vector3f(-0.5f,-0.5f,-0.5f),
			new Vector3f(0.5f,-0.5f,-0.5f),
			new Vector3f(-0.5f,-0.5f,0.5f),
			new Vector3f(-0.5f,-0.5f,0.5f),
			new Vector3f(0.5f,-0.5f,-0.5f),
			new Vector3f(0.5f,-0.5f,0.5f)
			
	};
	
	public static Vector3f[] PZ_POS = {
			
			new Vector3f(-0.5f,0.5f,0.5f),
			new Vector3f(-0.5f,-0.5f,0.5f),
			new Vector3f(0.5f,0.5f,0.5f),
			new Vector3f(0.5f,0.5f,0.5f),
			new Vector3f(-0.5f,-0.5f,0.5f),
			new Vector3f(0.5f,-0.5f,0.5f)
			
	};
	
	public static Vector3f[] NZ_POS = {
			
			new Vector3f(0.5f,0.5f,-0.5f),
			new Vector3f(0.5f,-0.5f,-0.5f),
			new Vector3f(-0.5f,+0.5f,-0.5f),
			new Vector3f(-0.5f,+0.5f,-0.5f),
			new Vector3f(0.5f,-0.5f,-0.5f),
			new Vector3f(-0.5f,-0.5f,-0.5f)
			
	};
	
//	public static Vector3f[] PX_POS = {
//	
//	new Vector3f(1.f,1.f,1.f),
//	new Vector3f(1.f,0.f,1.f),
//	new Vector3f(1.f,1.f,0.f),
//	new Vector3f(1.f,1.f,0.f),
//	new Vector3f(1.f,0.f,1.f),
//	new Vector3f(1.f,0.f,0.f)
//	
//};
//
//public static Vector3f[] NX_POS = {
//	
//	new Vector3f(0.f,1.f,0.f),
//	new Vector3f(0.f,0.f,0.f),
//	new Vector3f(0.f,1.f,1.f),
//	new Vector3f(0.f,1.f,1.f),
//	new Vector3f(0.f,0.f,0.f),
//	new Vector3f(0.f,0.f,1.f)
//	
//};
//
//public static Vector3f[] PY_POS = {
//	
//	new Vector3f(0.f,1.f,0.f),
//	new Vector3f(0.f,1.f,1.f),
//	new Vector3f(1.f,1.f,0.f),
//	new Vector3f(1.f,1.f,0.f),
//	new Vector3f(0.f,1.f,1.f),
//	new Vector3f(1.f,1.f,1.f)
//	
//};
//
//public static Vector3f[] NY_POS = {
//	
//	new Vector3f(0.f,0.f,0.f),
//	new Vector3f(1.f,0.f,0.f),
//	new Vector3f(0.f,0.f,1.f),
//	new Vector3f(0.f,0.f,1.f),
//	new Vector3f(1.f,0.f,0.f),
//	new Vector3f(1.f,0.f,1.f)
//	
//};
//
//public static Vector3f[] PZ_POS = {
//	
//	new Vector3f(0.f,1.f,1.f),
//	new Vector3f(0.f,0.f,1.f),
//	new Vector3f(1.f,1.f,1.f),
//	new Vector3f(1.f,1.f,1.f),
//	new Vector3f(0.f,0.f,1.f),
//	new Vector3f(1.f,0.f,1.f)
//	
//};
//
//public static Vector3f[] NZ_POS = {
//	
//	new Vector3f(1.f,1.f,0.f),
//	new Vector3f(1.f,0.f,0.f),
//	new Vector3f(0.f,+1.f,0.f),
//	new Vector3f(0.f,+1.f,0.f),
//	new Vector3f(1.f,0.f,0.f),
//	new Vector3f(0.f,0.f,0.f)
//	
//};
	
	

	public static Vector2f[] UV_PX = {
			
			// Dirt
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			
			// DirtGrass
			new Vector2f(1.f/16.f, 0.f/16.f),
			new Vector2f(1.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(1.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			
			// Stone
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			
			// Log
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			
			// Leaves
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			
			// Sand
			new Vector2f(8.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			
			// PODZOL 
			new Vector2f(11.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			
			// WHITE_GLASS 
			new Vector2f(13.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			
			// BLACK_GLASS 
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 1.f/16.f),
			
			// TNT
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			new Vector2f(3.f/16.f, 2.f/16.f),
			
			// JUNGLE_PLANKS
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			
			// WHITE_CLAY
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			
			// BLACK_CLAY
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			
			// QUARTZ_PILLAR
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			
			// STONE_BRICK_CRACKED
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			
			// COBBLE_BRICK
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			
			// OAK_PLANK
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			
			// BETTER_STONE
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			
			// GRAY_CLAY
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 2.f/16.f),
			
	};
	
	public static Vector2f[] UV_NX = {
			
			// Dirt
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			
			// DirtGrass
			new Vector2f(1.f/16.f, 0.f/16.f),
			new Vector2f(1.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(1.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			
			// Stone
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			
			// Log
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			
			// Leaves
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			
			// Sand
			new Vector2f(8.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			
			// PODZOL 
			new Vector2f(11.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			
			// WHITE_GLASS 
			new Vector2f(13.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			
			// BLACK_GLASS 
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 1.f/16.f),
			
			// TNT
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			new Vector2f(3.f/16.f, 2.f/16.f),
			
			// JUNGLE_PLANKS
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			
			// WHITE_CLAY
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			
			// BLACK_CLAY
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			
			// QUARTZ_PILLAR
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			
			// STONE_BRICK_CRACKED
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			
			// COBBLE_BRICK
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			
			// OAK_PLANK
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			
			// BETTER_STONE
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			
			// GRAY_CLAY
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 2.f/16.f),
				
	};
	
	
	public static Vector2f[] UV_PY = {
			
			// Dirt
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			
			// DirtGrass
			new Vector2f(0.f/16.f, 0.f/16.f),
			new Vector2f(0.f/16.f, 1.f/16.f),
			new Vector2f(1.f/16.f, 0.f/16.f),
			new Vector2f(1.f/16.f, 0.f/16.f),
			new Vector2f(0.f/16.f, 1.f/16.f),
			new Vector2f(1.f/16.f, 1.f/16.f),
			
			// Stone
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			
			// Log
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			
			// Leaves
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			
			// Sand
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 0.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			
			// PODZOL 
			new Vector2f(10.f/16.f, 0.f/16.f),
			new Vector2f(10f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 0.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			
			// WHITE_GLASS 
			new Vector2f(13.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			
			// BLACK_GLASS 
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 1.f/16.f),
			
			// TNT
			new Vector2f(1.f/16.f, 1.f/16.f),
			new Vector2f(1.f/16.f, 2.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(1.f/16.f, 2.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			
			// JUNGLE_PLANKS
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			
			// WHITE_CLAY
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			
			// BLACK_CLAY
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			
			// QUARTZ_PILLAR
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			
			// STONE_BRICK_CRACKED
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			
			// COBBLE_BRICK
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			
			// OAK_PLANK
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			
			// BETTER_STONE
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			
			// GRAY_CLAY
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 2.f/16.f),
			
	};
	
	public static Vector2f[] UV_NY = {
			
			// Dirt
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			
			// DirtGrass
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),		
			
			// Stone
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			
			// Log
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			
			// Leaves
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			
			// Sand
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 0.f/16.f),
			new Vector2f(10.f/16.f, 0.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			
			// PODZOL 
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 0.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			
			// WHITE_GLASS 
			new Vector2f(13.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			
			// BLACK_GLASS 
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 1.f/16.f),
			
			// TNT
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 2.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 2.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			
			// JUNGLE_PLANKS
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			
			// WHITE_CLAY
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			
			// BLACK_CLAY
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			
			// QUARTZ_PILLAR
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			
			// STONE_BRICK_CRACKED
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			
			// COBBLE_BRICK
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			
			// OAK_PLANK
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			
			// BETTER_STONE
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			
			// GRAY_CLAY
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 2.f/16.f),
			
	};
	
	public static Vector2f[] UV_PZ = {
			
			// Dirt
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			
			// DirtGrass
			new Vector2f(1.f/16.f, 0.f/16.f),
			new Vector2f(1.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(1.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			
			// Stone
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			
			// Log
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			
			// Leaves
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			
			// Sand
			new Vector2f(8.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			
			// PODZOL 
			new Vector2f(11.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			
			// WHITE_GLASS 
			new Vector2f(13.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			
			// BLACK_GLASS 
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 1.f/16.f),			
			
			// TNT
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			new Vector2f(3.f/16.f, 2.f/16.f),
			
			// JUNGLE_PLANKS
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			
			// WHITE_CLAY
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			
			// BLACK_CLAY
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			
			// QUARTZ_PILLAR
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			
			// STONE_BRICK_CRACKED
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			
			// COBBLE_BRICK
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			
			// OAK_PLANK
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			
			// BETTER_STONE
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			
			// GRAY_CLAY
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 2.f/16.f),
			
	};
	
	public static Vector2f[] UV_NZ = {
			
			// Dirt
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			
			// DirtGrass
			new Vector2f(2.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			
			// Stone
			new Vector2f(3.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			
			// Log
			new Vector2f(4.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(5.f/16.f, 0.f/16.f),
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			
			// Leaves
			new Vector2f(6.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(7.f/16.f, 0.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			
			// Sand
			new Vector2f(8.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(9.f/16.f, 0.f/16.f),
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			
			// PODZOL 
			new Vector2f(11.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(12.f/16.f, 0.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			
			// WHITE_GLASS 
			new Vector2f(13.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			
			// BLACK_GLASS 
			new Vector2f(14.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(15.f/16.f, 0.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(15.f/16.f, 1.f/16.f),
			
			// TNT
			new Vector2f(2.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(3.f/16.f, 1.f/16.f),
			new Vector2f(2.f/16.f, 2.f/16.f),
			new Vector2f(3.f/16.f, 2.f/16.f),
			
			// JUNGLE_PLANKS
			new Vector2f(4.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(4.f/16.f, 2.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			
			// WHITE_CLAY
			new Vector2f(5.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(5.f/16.f, 2.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			
			// BLACK_CLAY
			new Vector2f(6.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(7.f/16.f, 1.f/16.f),
			new Vector2f(6.f/16.f, 2.f/16.f),
			new Vector2f(7.f/16.f, 2.f/16.f),
			
			// QUARTZ_PILLAR
			new Vector2f(8.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(8.f/16.f, 2.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			
			// STONE_BRICK_CRACKED
			new Vector2f(9.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(9.f/16.f, 2.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			
			// COBBLE_BRICK
			new Vector2f(10.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(10.f/16.f, 2.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			
			// OAK_PLANK
			new Vector2f(11.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(11.f/16.f, 2.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			
			// BETTER_STONE
			new Vector2f(12.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(12.f/16.f, 2.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			
			// GRAY_CLAY
			new Vector2f(13.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(14.f/16.f, 1.f/16.f),
			new Vector2f(13.f/16.f, 2.f/16.f),
			new Vector2f(14.f/16.f, 2.f/16.f),
			
	};
	
	public static Vector3f[] NORMALS_PX = {
			
			new Vector3f(1.f, 0.f, 0.f),
			new Vector3f(1.f, 0.f, 0.f),
			new Vector3f(1.f, 0.f, 0.f),
			new Vector3f(1.f, 0.f, 0.f),
			new Vector3f(1.f, 0.f, 0.f),
			new Vector3f(1.f, 0.f, 0.f)
			
	};
	
	public static Vector3f[] NORMALS_NX = {
			
			new Vector3f(-1.f, 0.f, 0.f),
			new Vector3f(-1.f, 0.f, 0.f),
			new Vector3f(-1.f, 0.f, 0.f),
			new Vector3f(-1.f, 0.f, 0.f),
			new Vector3f(-1.f, 0.f, 0.f),
			new Vector3f(-1.f, 0.f, 0.f)
			
	};
	
	public static Vector3f[] NORMALS_PY = {
			
			new Vector3f(0.f, 1.f, 0.f),
			new Vector3f(0.f, 1.f, 0.f),
			new Vector3f(0.f, 1.f, 0.f),
			new Vector3f(0.f, 1.f, 0.f),
			new Vector3f(0.f, 1.f, 0.f),
			new Vector3f(0.f, 1.f, 0.f)
			
	};
	
	public static Vector3f[] NORMALS_NY = {
			
			new Vector3f(0.f, -1.f, 0.f),
			new Vector3f(0.f, -1.f, 0.f),
			new Vector3f(0.f, -1.f, 0.f),
			new Vector3f(0.f, -1.f, 0.f),
			new Vector3f(0.f, -1.f, 0.f),
			new Vector3f(0.f, -1.f, 0.f)
			
	};
	
	public static Vector3f[] NORMALS_PZ = {
			
			new Vector3f(0.f, 0.f, 1.f),
			new Vector3f(0.f, 0.f, 1.f),
			new Vector3f(0.f, 0.f, 1.f),
			new Vector3f(0.f, 0.f, 1.f),
			new Vector3f(0.f, 0.f, 1.f),
			new Vector3f(0.f, 0.f, 1.f)
			
	};
	
	public static Vector3f[] NORMALS_NZ = {
			
			new Vector3f(0.f, 0.f, -1.f),
			new Vector3f(0.f, 0.f, -1.f),
			new Vector3f(0.f, 0.f, -1.f),
			new Vector3f(0.f, 0.f, -1.f),
			new Vector3f(0.f, 0.f, -1.f),
			new Vector3f(0.f, 0.f, -1.f)
			
	};
	
	
	
	// RESTORE FOR INDICES SYSTEM
//	public static float[] vertices = {			
//		-0.5f,0.5f,-0.5f,	// back
//		-0.5f,-0.5f,-0.5f,	
//		0.5f,-0.5f,-0.5f,	
//		0.5f,0.5f,-0.5f,		
//		
//		-0.5f,0.5f,0.5f,	// front
//		-0.5f,-0.5f,0.5f,	
//		0.5f,-0.5f,0.5f,	
//		0.5f,0.5f,0.5f,
//		
//		0.5f,0.5f,-0.5f,	// right
//		0.5f,-0.5f,-0.5f,	
//		0.5f,-0.5f,0.5f,	
//		0.5f,0.5f,0.5f,
//		
//		-0.5f,0.5f,-0.5f,	// left
//		-0.5f,-0.5f,-0.5f,	
//		-0.5f,-0.5f,0.5f,	
//		-0.5f,0.5f,0.5f,
//		
//		-0.5f,0.5f,0.5f,	// up
//		-0.5f,0.5f,-0.5f,
//		0.5f,0.5f,-0.5f,
//		0.5f,0.5f,0.5f,
//		
//		-0.5f,-0.5f,0.5f,	// down
//		-0.5f,-0.5f,-0.5f,
//		0.5f,-0.5f,-0.5f,
//		0.5f,-0.5f,0.5f
//			
//	};
	
	public static float[] vertices = {	
			
		-0.5f,0.5f,-0.5f,	// back
		0.5f,0.5f,-0.5f,	
		-0.5f,-0.5f,-0.5f,

		-0.5f,-0.5f,-0.5f,
		0.5f,0.5f,-0.5f,
		0.5f,-0.5f,-0.5f,

		-0.5f,0.5f,0.5f,	// front
		-0.5f,-0.5f,0.5f,	
		0.5f,0.5f,0.5f,

		0.5f,0.5f,0.5f,
		-0.5f,-0.5f,0.5f,
		0.5f,-0.5f,0.5f,

		0.5f,0.5f,-0.5f,	// right
		0.5f,0.5f,0.5f,
		0.5f,-0.5f,-0.5f,

		0.5f,-0.5f,-0.5f,	
		0.5f,0.5f,0.5f,
		0.5f,-0.5f,0.5f,	

		-0.5f,0.5f,-0.5f,	// left
		-0.5f,-0.5f,-0.5f,
		-0.5f,0.5f,0.5f,

		-0.5f,0.5f,0.5f,
		-0.5f,-0.5f,-0.5f,
		-0.5f,-0.5f,0.5f,

		-0.5f,0.5f,-0.5f,	// up
		-0.5f,0.5f,0.5f,
		0.5f,0.5f,-0.5f,

		0.5f,0.5f,-0.5f,
		-0.5f,0.5f,0.5f,
		0.5f,0.5f,0.5f,

		-0.5f,-0.5f,-0.5f,	// down
		0.5f,-0.5f,-0.5f,
		-0.5f,-0.5f,0.5f,

		-0.5f,-0.5f,0.5f,
		0.5f,-0.5f,-0.5f,
		0.5f,-0.5f,0.5f
			
	};
	
	// RESTORE FOR INDICES SYSTEM
//	public static float[] textureCoords = {
//		
//		0.25f,0,
//		0.25f,0.25f,
//		0.50f,0.25f,
//		0.50f,0,
//		
//		0.25f,0,
//		0.25f,0.25f,
//		0.50f,0.25f,
//		0.50f,0,
//		
//		0.25f,0,
//		0.25f,0.25f,
//		0.50f,0.25f,
//		0.50f,0,
//		
//		0.25f,0,
//		0.25f,0.25f,
//		0.50f,0.25f,
//		0.50f,0,
//		
//		0,0,
//		0,0.25f,
//		0.25f,0.25f,
//		0.25f,0,
//		
//		0.50f,0,
//		0.50f,0.25f,
//		0.75f,0.25f,
//		0.75f,0,
//			
//	};
	
	
	public static float[] textureCoords = {
			0.25f,0,
			0.25f,0.25f,
			0.50f,0,
			
			0.50f,0,
			0.25f,0.25f,
			0.50f,0.25f,
			
			0.25f,0,
			0.25f,0.25f,
			0.50f,0,
			
			0.50f,0,
			0.25f,0.25f,
			0.50f,0.25f,
			
			0.25f,0,
			0.25f,0.25f,
			0.50f,0,
			
			0.50f,0,
			0.25f,0.25f,
			0.50f,0.25f,
			
			0.25f,0,
			0.25f,0.25f,
			0.50f,0,
			
			0.50f,0,
			0.25f,0.25f,
			0.50f,0.25f,
			
			0.25f,0,
			0.25f,0.25f,
			0.50f,0,
			
			0.50f,0,
			0.25f,0.25f,
			0.50f,0.25f,
			
			0.25f,0,
			0.25f,0.25f,
			0.50f,0,
			
			0.50f,0,
			0.25f,0.25f,
			0.50f,0.25f,
			
			0.25f,0,
			0.25f,0.25f,
			0.50f,0,
			
			0.50f,0,
			0.25f,0.25f,
			0.50f,0.25f,
			
	};
	
	// RESTORE FOR INDICES SYSTEM
//	public static float[] normals = {
//		0, 0, -1f,
//		0, 0, -1f,	
//		0, 0, -1f,
//		0, 0, -1f,
//		
//		0, 0, 1f,
//		0, 0, 1f,
//		0, 0, 1f,
//		0, 0, 1f,
//		
//		1f, 0, 0,
//		1f, 0, 0,
//		1f, 0, 0,
//		1f, 0, 0,
//		
//		-1f, 0, 0,
//		-1f, 0, 0,
//		-1f, 0, 0,
//		-1f, 0, 0,
//		
//		0, 1f, 0,
//		0, 1f, 0,
//		0, 1f, 0,
//		0, 1f, 0,
//		
//		0, -1f, 0,
//		0, -1f, 0,
//		0, -1f, 0,
//		0, -1f, 0
//	};
	
	public static float[] normals = {
		0, 0, -1f,
		0, 0, -1f,	
		0, 0, -1f,
		0, 0, -1f,
		0, 0, -1f,
		0, 0, -1f,
		
		0, 0, 1f,
		0, 0, 1f,
		0, 0, 1f,
		0, 0, 1f,
		0, 0, 1f,
		0, 0, 1f,
		
		1f, 0, 0,
		1f, 0, 0,
		1f, 0, 0,
		1f, 0, 0,
		1f, 0, 0,
		1f, 0, 0,
			
		-1f, 0, 0,
		-1f, 0, 0,
		-1f, 0, 0,
		-1f, 0, 0,
		-1f, 0, 0,
		-1f, 0, 0,
		
		0, 1f, 0,
		0, 1f, 0,
		0, 1f, 0,
		0, 1f, 0,
		0, 1f, 0,
		0, 1f, 0,
		
		0, -1f, 0,
		0, -1f, 0,
		0, -1f, 0,
		0, -1f, 0,
		0, -1f, 0,
		0, -1f, 0
	};
	
	public static int[] indices = {
			
		0,3,1,	
		1,3,2,	
		
		4,5,7,
		7,5,6,
		
		8,11,9,
		9,11,10,
		
		12,13,15,
		15,13,14,	
		
		17,16,18,
		18,16,19,
		
		21,22,20,
		20,22,23

	};
}
