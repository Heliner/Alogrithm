package graph;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import queue.Queue;
import stack.Stack;

public class Graph_Matrix {
	private final int MAX = 1000;
	ArrayList<Integer> elements;

	Integer N_E;
	Integer N_V;
	int[][] matrix;
	boolean[] visit; // visit or not

	public Graph_Matrix() {

	}

	public void initial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input num of edges and vertexs like 1 2:");
		this.N_E = sc.nextInt();
		this.N_V = sc.nextInt();
		matrix = new int[this.N_V + 1][this.N_V + 1];
		visit = new boolean[this.N_V + 1];
		for (int i = 1; i <= this.N_V; i++)
			for (int j = 1; j <= this.N_V; j++) {
				visit[j] = false;
				if (i == j)
					matrix[i][j] = MAX;
				else
					matrix[i][j] = 0;
			}
		System.out.println("Please input info of edges like 1 2:");
		for (int i = 1; i <= this.N_E; i++) {
			matrix[sc.nextInt()][sc.nextInt()] = 1;
		}
		sc.close();
	}

	public void showAsMatrix() {
		for (int i = 1; i <= this.N_V; i++) {
			for (int j = 1; j <= this.N_V; j++)

				System.out.printf("\t\t%d", matrix[i][j]);
			System.out.println();
		}
	}

	/**
	 * Depth First Search By matrix
	 */
	public void DFS() {
		Integer cur_vertex = 0;

		Stack<Integer> stack = new Stack<Integer>();
		// 第二步 找到可到并且没有访问过的点压栈
		boolean flag = false;

		do {

			// 第一步 找到切入的节点
			if (stack.isEmpty() && cur_vertex == 0) {
				for (int i = 1; i <= this.N_V; i++) {
					for (int j = 1; j <= this.N_V; j++) {
						if (matrix[i][j] == 1) {
							cur_vertex = i;
							break;
						}
					}
					if (cur_vertex != 0)
						break;
				}
				if (cur_vertex == 0) {
					System.out.println("No vertex can be visited!!!");
					return;
				}

			}
			// 对这个点进行深度遍历
			do {
				flag = false;
				for (int j = 1; j <= this.N_V; j++) {
					if (matrix[cur_vertex][j] == 1 && visit[j] == false) {
						// 输出当前点并且设为已经访问过
						System.out.println("This way: form " + cur_vertex + " to " + j);
						visit[j] = true;
						cur_vertex = j;
						stack.push_back(cur_vertex);
						flag = true;
						break;
						// break the hool and restart the hool
					}
				}
			} while (flag == true);

			// 一条路的深度遍历完成所以一定无路可走
			cur_vertex = 0;
			if (!stack.isEmpty()) {
				cur_vertex = stack.pop_back();
			}

		} while (true);
		// 第三步 没有可访问的点就弹栈 否则就进行第二步
		// 如果栈为空、再次寻找接入点，有则进行第二步，否则退出函数

	}

	/**
	 * Breadth First Search By matrix
	 */
	public void BFS() {
		// 找到切入节点

		Integer cur_vertex = 0;
		Integer f_count_in = 0;

		Queue<Integer> queue = new Queue<Integer>();

		do {

			// -----如果为空就找出一行可以访问的元素
			if (queue.isEmpty()) {
				int flag = 0;
				
				for (int i = 1; i <= this.N_V; i++) {
					for (int j = 1; j <= this.N_V; j++) {
						if (matrix[i][j] == 1 && visit[j] == false) {
							queue.insert(j);
							visit[j] = true;
							f_count_in++;
							flag++;
						}
					}
					if (flag != 0)
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
				for (int j = 1; j <= this.N_V; j++)
					if (matrix[cur_vertex][j] == 1 && visit[j] == false) {
						queue.insert(j);
						visit[j] = true;
						temp_count++;
						// 插入队尾新元素的数目增加
					}
			} while (f_count_in > 0);
			f_count_in = temp_count;
		} while (true);
		// 输出当前节点并设置为已经访问
		// 没有可访问的节点就出队列-------添加队列如队列的元素的个数可用于出队列时使用
		// 如果栈为空，再次寻找接入点，否则退出函数

	}

	@Test
	public void TestGraph() {
		Graph_Matrix graph = new Graph_Matrix();
		graph.initial();
		graph.showAsMatrix();
		// graph.DPS();
		graph.BFS();
	}
}
