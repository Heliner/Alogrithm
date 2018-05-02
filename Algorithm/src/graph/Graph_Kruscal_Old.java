package graph;

import java.io.BufferedInputStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.junit.Test;

/**
 * 最小生成树的Prim算法实现
 * 
 * @author hf
 *
 */

public class Graph_Kruscal_Old {
	public int MAXI = Integer.MAX_VALUE;
	PriorityQueue<Edgeset> priorityQueue;
	private static List<Edgeset> allSearched;
	int father[];
	Integer N_E;
	Integer N_V;

	public Graph_Kruscal_Old() {

	}

	class Edgeset {
		int fromvex;
		int endvex;
		int weight;

		public Edgeset(int formvex, int endvex, int weight) {
			this.fromvex = formvex;
			this.endvex = endvex;
			this.weight = weight;
		}
	}

	class ComparetorByNumber implements Comparator<Edgeset> {

		@Override
		public int compare(Edgeset a, Edgeset b) {
			if (a.weight == b.weight)
				return 0;
			else
				return a.weight > b.weight ? 1 : -1;
		}

	}

	public void initial() {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		System.out.println("Please input num of edges and vertexs like 1 2:");
		this.N_E = sc.nextInt();
		this.N_V = sc.nextInt();
		// for (int i = 1; i <= this.N_V; i++)
		// for (int j = 1; j <= this.N_V; j++) {
		//
		// }

		father = new int[this.N_V];
		for (int i = 0; i < father.length; i++) {
			father[i] = i;
			// 将其所属子集设为自身
		}

		System.out.println("Please input info of edges like from 1 to  2  weight  4:");
		priorityQueue = new PriorityQueue<Edgeset>(this.N_E, new ComparetorByNumber());
		for (int i = 1; i <= this.N_E; i++) {
			priorityQueue.add(new Edgeset(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		sc.close();

	}

	void Kruscal() {

		allSearched = new LinkedList<Edgeset>();
		while (!priorityQueue.isEmpty()) {
			// 排序算出最小的边
			Edgeset Edge = priorityQueue.poll();
			// 判断最小的边的两个顶点所属的集合是不是同一个集合
			int m, n;
			m = Edge.endvex;
			n = Edge.fromvex;
			if (father[m] == father[n]) {
				continue;
			}
			// 使一个树中的所有元素都有唯一的根节点
			int old_father_n = father[n];
			father[n] = father[m];
			// 更新n集合的所有父亲节点和n的父亲节点相同
			for (int i = 0; i < father.length; i++) {
				if (father[i] == old_father_n) {
					father[i] = father[n];
				}
			}

			allSearched.add(Edge);

		}
		for (int i = 0; i < allSearched.size(); i++) {
			Edgeset e = allSearched.get(i);
			System.out.println("From  " + e.fromvex + "  to  " + e.endvex + "  weigth " + e.weight);
		}
		// 是同一个集合就找下一个
		// 不是同一个集合就将两个改到一个集合中
		// 直到所有的元素都属于同一个集合

	}

	private int findRoot(int m) {
		if (m != father[m])
			return findRoot(father[m]);
		return m;

	}

	@Test
	public void TestGraph_Kruscal() {
		Graph_Kruscal_Old graph = new Graph_Kruscal_Old();
		graph.initial();
		graph.Kruscal();
	}
}
