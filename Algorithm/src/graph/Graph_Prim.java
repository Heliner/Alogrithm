package graph;

import org.junit.Test;

/**
 * 最小生成树的Prim算法实现
 * 
 * @author hf
 *
 */

public class Graph_Prim {
	public int MAXI = Integer.MAX_VALUE;
	De_Graph_Matrix graph = null;
	int access_vertexs[];
	int access_pass[];

	public Graph_Prim() {

		super();
		this.graph = new De_Graph_Matrix();
	}

	public void inital() {
		this.graph.initial();
		int max = this.graph.N_V;
		access_vertexs = new int[max + 1];
		access_pass = new int[max + 1];

	}

	void ShowAsPrim() {
		int max = this.graph.N_V;
		int lowcost[] = new int[max + 1];
		int closest[] = new int[max + 1];

		int i, j, k, min;
		for (i = 2; i <= max; i++) {
			lowcost[i] = this.graph.matrix[1][i];
			closest[i] = 1;
		}
		for (i = 2; i <= max; i++) {
			min = MAXI;
			k = 0;
			for (j = 2; j <= max; j++) {
				if ((lowcost[j] < min) && (lowcost[j] != 0)) {
					min = lowcost[j];
					k = j;
				}
			}
			System.out.printf("%d %5d\n", k, closest[k]);
			lowcost[k] = 0;
			closest[k] = 0;
			for (j = 2; j <= max; j++) {
				if ((this.graph.matrix[k][j] < lowcost[j]) && this.graph.matrix[k][j] != 0) {
					lowcost[j] = this.graph.matrix[k][j];
					closest[j] = k;
				}
			}
		}

		// 找到可达定点
		// 找到通向可达定点的路径长度
		// 直接找出最短的路径

		// 找出一个点 找到可以访问的点

		// 选出最小路径的点（这个点不能再已经访问的点数组中） 加入到已访问的点数组中

		// 将新选出的点中可到达的点加入到数组中

		// 记录未访问过的点 和 已访问过的点
		// 从两个中间找出最小的路劲
	}

	@Test
	public void TestGraph_Prim() {
		Graph_Prim graph = new Graph_Prim();
		graph.inital();
		graph.ShowAsPrim();
	}
}
