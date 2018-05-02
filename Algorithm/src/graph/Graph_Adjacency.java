package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import queue.Queue;

public class Graph_Adjacency {

	// 领接表
	static List<vex_node> vexs = new ArrayList<vex_node>();
	int N_E;
	int N_V;
	boolean visit[];

	// 头结点
	class vex_node {
		char vexdata;
		edge_node firstarc;

		public vex_node(char vexdata) {
			this.vexdata = vexdata;
		}
	}

	// edge_node
	class edge_node {
		int adjvex;
		edge_node nextarc;
		float info;

		public edge_node(edge_node node, int adjvex) {
			this.nextarc = node;
			this.adjvex = adjvex;
		}

		public edge_node(int adjvex) {
			this.adjvex = adjvex;
			this.nextarc = null;
		}
	}

	void create_graph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input num info of edges and vertexs");
		this.N_E = sc.nextInt();
		this.N_V = sc.nextInt();
		System.out.println("Please input the data of vertexs likes abcd");

		// 多余的节点 使节点从1开始
		vexs.add(new vex_node('f'));

		this.visit = new boolean[this.N_V + 1];

		sc.nextLine();
		String s = sc.nextLine();
		s.trim();
		for (int i = 0; i < this.N_V; i++) {
			vexs.add(new vex_node(s.charAt(i)));
		}

		System.out.println("Please input info of edges：1 2");

		for (int i = 1; i <= this.N_V; i++) {
			int c1 = sc.nextInt();

			vex_node node = vexs.get(c1);
			int c = sc.nextInt();
			if (node.firstarc == null) {
				node.firstarc = new edge_node(c);
				vexs.set(c1, node);
			} else {
				edge_node new_p = new edge_node(c);
				edge_node f_p = node.firstarc;
				new_p.nextarc = f_p.nextarc;
				f_p.nextarc = new_p;
				vexs.set(c1, node);
			}
		}

		sc.close();
	}

	void display() {
		// 先去找到头
		for (int i = 1; i <= this.N_V; i++) {
			vex_node node = vexs.get(i);
			System.out.print(node.vexdata + ":  ");
			// 将领接表中的元素遍历出来
			edge_node p = node.firstarc;
			while (p != null) {
				System.out.print(vexs.get(p.adjvex).vexdata + "  ");
				p = p.nextarc;
			}
			System.out.println();
		}
	}

	/**
	 * Depth First Search By
	 */
	void DPS() {
		for (int i = 1; i <= this.N_V; i++) {
			if (this.visit[i] == false) {

				explore_dfs(i);
			}
		}
	}

	/**
	 * First Search By While
	 * 
	 * @param temp_cout
	 * 
	 */
	void BPS_W() {
		// 找到切入节点

		Integer cur_vertex = 0;
		Integer f_count_in = 0;

		Queue<Integer> queue = new Queue<Integer>();

		do {

			// -----如果为空就找出一行可以访问的元素

			if (queue.isEmpty()) {
				int flag = 0;
				for (int i = 1; i <= this.N_V; i++) {
					// 一旦查到有元素后只能查该行元素
					if (visit[i] == false) {
						queue.insert(i);
						visit[i] = true;
						edge_node p = vexs.get(i).firstarc;
						while (p != null) {
							if (visit[p.adjvex] == false) {
								queue.insert(p.adjvex);
								this.visit[p.adjvex] = true;

								flag = 1;
							}
							p = p.nextarc;
						}
					}
					if (flag == 1)
						break;
				}
				if (flag == 0) {
					System.out.println("No vertex can be visited By BPS!!!");
					return;
				}
			}

			// 开始对队列元素输出并设置为已访问 并进行二次查找
			int temp_count = 0;
			do {
				cur_vertex = queue.deQueue();
				f_count_in--;
				System.out.println("Node->>>>" + cur_vertex);
				// 查找这一行中可以访问的元素
				edge_node p = vexs.get(cur_vertex).firstarc;
				while (p != null) {

					if (visit[p.adjvex] == false) {
						queue.insert(p.adjvex);
						this.visit[p.adjvex] = true;
						temp_count++;
					}
					p = p.nextarc;
				}

			} while (f_count_in > 0);
			f_count_in = temp_count;
		} while (true);
	}

	void explore_dfs(int i) {
		if (i <= this.N_V && this.visit[i] == false) {
			System.out.println(vexs.get(i).vexdata + "  ");
			this.visit[i] = true;
			edge_node node = vexs.get(i).firstarc;
			while (node != null) {
				explore_dfs(node.adjvex);
				node = node.nextarc;

			}
		}

	}

	@Test
	public void TestGraph() {
		Graph_Adjacency graph_a = new Graph_Adjacency();
		graph_a.create_graph();
		graph_a.display();
		// graph_a.DPS();
		graph_a.BPS_W();
	}

}
