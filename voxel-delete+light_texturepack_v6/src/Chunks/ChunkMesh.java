package Chunks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import Controls.MeshHeight;
import Cube.Block;
import Cube.Vertex;
import Models.CubeModel;

public class ChunkMesh implements Serializable {

	private List<Vertex> vertices;

	private List<Float> positionsList;
	private List<Float> uvsList;
	private List<Float> normalsList;

	public float[] positions, uvs, normals;

	public MeshHeight[][] heights;

	public Chunk chunk;

	public ChunkMesh(Chunk chunk) {
		heights = new MeshHeight[32][32];

		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 32; j++) {
				heights[i][j] = new MeshHeight();
			}
		}

		this.chunk = chunk;

		vertices = new ArrayList<Vertex>();
		positionsList = new ArrayList<Float>();
		uvsList = new ArrayList<Float>();
		normalsList = new ArrayList<Float>();

		buildMesh();
		populateLists();

	}

	public void update(Chunk chunk) {

		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 32; j++) {
				heights[i][j].heights.clear();
				heights[i][j].heights.add(-999.f);
			}
		}

		this.chunk = chunk;

//		vertices.clear();
		buildMesh();
		populateLists();

	}

	private void buildMesh() {

		// Loop through block in chunk and determine which faces are visible

		for (int i = 0; i < chunk.blocks.size(); i++) {

			Block blockI = chunk.blocks.get(i);

			boolean px = false, nx = false, py = false, ny = false, pz = false, nz = false;

			for (int j = 0; j < chunk.blocks.size(); j++) {

				Block blockJ = chunk.blocks.get(j);

				// PX
				if (((blockI.x + 1) == (blockJ.x)) && ((blockI.y) == (blockJ.y)) && ((blockI.z) == (blockJ.z))) {
					px = true;
				}

				// NX
				if (((blockI.x - 1) == (blockJ.x)) && ((blockI.y) == (blockJ.y)) && ((blockI.z) == (blockJ.z))) {
					nx = true;
				}

				// PY
				if (((blockI.x) == (blockJ.x)) && ((blockI.y + 1) == (blockJ.y)) && ((blockI.z) == (blockJ.z))) {
					py = true;
				}

				// NY
				if (((blockI.x) == (blockJ.x)) && ((blockI.y - 1) == (blockJ.y)) && ((blockI.z) == (blockJ.z))) {
					ny = true;
				}

				// PZ
				if (((blockI.x) == (blockJ.x)) && ((blockI.y) == (blockJ.y)) && ((blockI.z + 1) == (blockJ.z))) {
					pz = true;
				}

				// NZ
				if (((blockI.x) == (blockJ.x)) && ((blockI.y) == (blockJ.y)) && ((blockI.z - 1) == (blockJ.z))) {
					nz = true;
				}

			}

			// Add visible face to the chunk mesh

			if (!px) {
				for (int k = 0; k < 6; k++) {
					vertices.add(new Vertex(
							new Vector3f(CubeModel.PX_POS[k].x + blockI.x, CubeModel.PX_POS[k].y + blockI.y,
									CubeModel.PX_POS[k].z + blockI.z),
							CubeModel.UV_PX[blockI.type.ordinal() * 6 + k], CubeModel.NORMALS_PX[k]));
				}
			}

			if (!nx) {
				for (int k = 0; k < 6; k++) {
					vertices.add(new Vertex(
							new Vector3f(CubeModel.NX_POS[k].x + blockI.x, CubeModel.NX_POS[k].y + blockI.y,
									CubeModel.NX_POS[k].z + blockI.z),
							CubeModel.UV_NX[blockI.type.ordinal() * 6 + k], CubeModel.NORMALS_NX[k]));
				}
			}

			if (!py) {
				for (int k = 0; k < 6; k++) {
					vertices.add(new Vertex(
							new Vector3f(CubeModel.PY_POS[k].x + blockI.x, CubeModel.PY_POS[k].y + blockI.y,
									CubeModel.PY_POS[k].z + blockI.z),
							CubeModel.UV_PY[blockI.type.ordinal() * 6 + k], CubeModel.NORMALS_PY[k]));
				}
				heights[blockI.x][blockI.z].heights.add((float) blockI.y);
			}

			if (!ny) {
				for (int k = 0; k < 6; k++) {
					vertices.add(new Vertex(
							new Vector3f(CubeModel.NY_POS[k].x + blockI.x, CubeModel.NY_POS[k].y + blockI.y,
									CubeModel.NY_POS[k].z + blockI.z),
							CubeModel.UV_NY[blockI.type.ordinal() * 6 + k], CubeModel.NORMALS_NY[k]));
				}
			}

			if (!pz) {
				for (int k = 0; k < 6; k++) {
					vertices.add(new Vertex(
							new Vector3f(CubeModel.PZ_POS[k].x + blockI.x, CubeModel.PZ_POS[k].y + blockI.y,
									CubeModel.PZ_POS[k].z + blockI.z),
							CubeModel.UV_PZ[blockI.type.ordinal() * 6 + k], CubeModel.NORMALS_PZ[k]));
				}
			}

			if (!nz) {
				for (int k = 0; k < 6; k++) {
					vertices.add(new Vertex(
							new Vector3f(CubeModel.NZ_POS[k].x + blockI.x, CubeModel.NZ_POS[k].y + blockI.y,
									CubeModel.NZ_POS[k].z + blockI.z),
							CubeModel.UV_NZ[blockI.type.ordinal() * 6 + k], CubeModel.NORMALS_NZ[k]));
				}
			}
//			Collections.sort(heights[blockI.x][blockI.z].heights);
		}
	}

	private void populateLists() {

		for (int i = 0; i < vertices.size(); i++) {

			positionsList.add(vertices.get(i).positions.x);
			positionsList.add(vertices.get(i).positions.y);
			positionsList.add(vertices.get(i).positions.z);
			uvsList.add(vertices.get(i).uvs.x);
			uvsList.add(vertices.get(i).uvs.y);
			normalsList.add(vertices.get(i).normals.x);
			normalsList.add(vertices.get(i).normals.y);
			normalsList.add(vertices.get(i).normals.z);

		}

		positions = new float[positionsList.size()];
		uvs = new float[uvsList.size()];
		normals = new float[normalsList.size()];

		for (int i = 0; i < positionsList.size(); i++) {
			positions[i] = positionsList.get(i);
		}

		for (int i = 0; i < uvsList.size(); i++) {
			uvs[i] = uvsList.get(i);
		}

		for (int i = 0; i < normalsList.size(); i++) {
			normals[i] = normalsList.get(i);
		}

		cleanup();

	}

	public void cleanup() {
		normalsList.clear();
		uvsList.clear();
		positionsList.clear();
		vertices.clear();
	}

}
