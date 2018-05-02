package graph;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class De_Graph_Matrix {
	private final int MAX = 1000;
	ArrayList<Integer> elements;

	Integer N_E;
	Integer N_V;
	int[][] matrix;
	boolean[] visit; // visit or not

	public De_Graph_Matrix() {
	}

	public void initial() {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		System.out.println("Please input num of edges and vertexs like 1 2:");
		this.N_E = sc.nextInt();
		this.N_V = sc.nextInt();
		matrix = new int[this.N_V + 1][this.N_V + 1];
		visit = new boolean[this.N_V + 1];
		for (int i = 1; i <= this.N_V; i++)
			for (int j = 1; j <= this.N_V; j++) {
				visit[j] = false;
				if (i == j)
					matrix[i][j] = 0;
				else
					matrix[i][j] = 0;
			}
		
		System.out.println("Please input info of edges like 1 2 weight == 4:");
		int value,col,row;
		for (int i = 1; i <= this.N_E; i++) {
			col=sc.nextInt();
			row= sc.nextInt();
			value=sc.nextInt();
			matrix[col][row] = value;
			matrix[row][col] = value;
			
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

}
