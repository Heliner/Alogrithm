package graph;

public class Graph_Kruscal_Matrix {

	De_Graph_Matrix graph;
	int father[];

	public Graph_Kruscal_Matrix() {
		this.graph = new De_Graph_Matrix();
	}

	private void initial() {
		this.graph.initial();
		father = new int[this.graph.N_V];
		for (int i = 0; i < father.length; i++) {
			father[i] = i;
			// 将其所属子集设为自身
		}
	}

	private void Kruscal() {
		
//		 	排序算出最小的边
		//			判断最小的边的两个顶点所属的集合是不是同一个集合
//			是同一个集合就找下一个
//			不是同一个集合就将两个改到一个集合中
//			直到所有的元素都属于同一个集合
	}
}
