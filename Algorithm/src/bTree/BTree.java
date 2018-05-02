package bTree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import stack.Stack;

/**
 * Binary Tree
 * 
 * @author hf
 *
 * @param <Item>
 */

public class BTree<Item> {
	public BTree<Item> lchild;
	public BTree<Item> rchild;
	public Item data;

	@SuppressWarnings("unused")
	private BTree(BTree<Item> lchild, BTree<Item> rchild, Item data) {
		this.lchild = lchild;
		this.rchild = rchild;
		this.data = data;
	}

	private BTree(Item data) {
		this.data = data;
	}

	public BTree(){
		
	}
	
	/**
	 * Use the method of recursion to create A tree
	 * 
	 * @param list
	 * @param n
	 * @return
	 */
	public  BTree<Item> CreateTree(List<Item> list, int n) {
		BTree<Item> btree = null;
		if (n < list.size()) {
			btree = new BTree<Item>(list.get(n));
			btree.lchild = CreateTree(list, 2 * (n));
			btree.rchild = CreateTree(list, 2 * (n) + 1);
		}
		return btree;
	}

	/**
	 * empty a BTree
	 * 
	 * @param btree
	 */
	public void clearTree(BTree<Item> btree) {
		btree.lchild = null;
		btree.rchild = null;
	}

	/**
	 * 
	 * @param btree
	 */
	public void preorder(BTree<Item> btree) {
		if (btree != null) {
			System.out.println("element:" + btree.data);
			preorder(btree.lchild);
			preorder(btree.rchild);
		}
	}

	/**
	 * 
	 * @param btree
	 */
	public void inorder(BTree<Item> btree) {
		if (btree != null) {
			inorder(btree.lchild);
			System.out.println("element:" + btree.data);
			inorder(btree.rchild);
		}
	}

	/**
	 * 
	 * @param btree
	 */
	public void postorder(BTree<Item> btree) {
		if (btree != null) {
			postorder(btree.lchild);
			postorder(btree.rchild);
			System.out.println("element:" + btree.data);
		}
	}
	
	
	public void preorderByWhile(BTree<Item> btree){
		Stack<BTree<Item>> stack = new Stack<BTree<Item>>();
		do{
			while(btree!=null){
				System.out.println("element->data:"+btree.data);
				stack.push_back(btree);
				btree = btree.lchild;
			}
			if(!stack.isEmpty()){
				btree = stack.pop_back();
				btree = btree.rchild;
			}
		}while(!stack.isEmpty()||btree!=null);
	}

	/**
	 * return the level of item by preorder
	 * @param btree
	 * @param item The item which is searched
	 * @return	level
	 */
	public int level(BTree<Item> btree,Item item){
		int m,n,level;
		if(btree==null)
			level=0;
		else if(btree.data == item){
			level=1;
		}else{
			m = level(btree.lchild,item);
			n = level(btree.rchild,item);
			if(m==0&&n==0)level=0;
			else level=(m>n?m:n)+1;
		}
		return level;
	}

	/**
	 * return subtree's depth
	 * @param btree
	 * @return	subtree's depth
	 */
	int get_Depth(BTree<Item> btree){
		int m,n;
		if(btree!=null){
			m=get_Depth(btree.lchild);
			n = get_Depth(btree.rchild);
			return (m>n?m:n)+1;
		}
		return 0;
	}
	
	
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
		System.out.println("The depth of element '4'");
		System.out.println(""+btree.level(btree, 4));
		System.out.println("The tree's depth");
		System.out.println(""+btree.get_Depth(btree));
	}
}
