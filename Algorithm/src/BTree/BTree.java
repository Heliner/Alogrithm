package BTree;

import java.util.List;

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
	
}
