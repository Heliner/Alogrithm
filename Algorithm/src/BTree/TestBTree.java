package BTree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestBTree {
	@Test
	public void TestBTre(){
		List<Integer> list = new ArrayList<Integer>();
		//前置的用于充数的节点
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		BTree<Integer> btree = new BTree<Integer>();
		btree=btree.CreateTree(list, 1);
		System.out.println("traverse  by method of inorder");
		btree.inorder(btree);
		System.out.println("traverse  by method of preorder");
		btree.preorder(btree);
		btree.preorderByWhile(btree);
		System.out.println("traverse  by method of preorder");
		btree.preorder(btree);
		
	}
}
