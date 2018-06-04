package graph;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph_Dijkstra {
	private final int MAX = Integer.MAX_VALUE;

	Integer N_E;
	Integer N_V;
	int[][] matrix;
	boolean[] visit; // visit or not

	public Graph_Dijkstra() {

	}

	public void initial() {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		System.out.println("Please input num of edges and vertexs like 1 2: weight : 4");
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
			matrix[sc.nextInt()][sc.nextInt()] = sc.nextInt();
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

	
	void Dijkstra() {
		int dist[] = new int[this.N_V];
		//从一个点开始查找与其位置相近的点
	}
}
