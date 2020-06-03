package Controls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MeshHeight implements Serializable {
	public List<Float> heights;

	public MeshHeight() {
		this.heights = new ArrayList<Float>();
		this.heights.add(-999.f);
	}
}
