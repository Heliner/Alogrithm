package tree;

import java.util.HashSet;

/// <summary>
/// 平衡二叉树节点
/// </summary>
/// <typeparam name="K"></typeparam>
/// <typeparam name="V"></typeparam>
public class AVLNode<K, V> {
	/// <summary>
	/// 节点元素
	/// </summary>
	public K key;

	/// <summary>
	/// 增加一个高度信息
	/// </summary>
	public int height;

	/// <summary>
	/// 节点中的附加值
	/// </summary>
	public HashSet<V> attach = new HashSet<V>();

	/// <summary>
	/// 左节点
	/// </summary>
	public AVLNode<K, V> left;

	/// <summary>
	/// 右节点
	/// </summary>
	public AVLNode<K, V> right;

	public AVLNode() {
	}

	public AVLNode(K key, V value, AVLNode<K, V> left, AVLNode<K, V> right) {
		// KV键值对
		this.key = key;
		this.attach.add(value);

		this.left = left;
		this.right = right;
	}

	/// <summary>
	/// 第一种：左左旋转（单旋转）
	/// </summary>
	/// <param name="node"></param>
	/// <returns></returns>
	public AVLNode<K, V> RotateLL(AVLNode<K, V> node) {
		// top：需要作为顶级节点的元素
		AVLNode<K, V> top = node.left;

		// 先截断当前节点的左孩子
		node.left = top.right;

		// 将当前节点作为temp的右孩子
		top.right = node;

		// 计算当前两个节点的高度
		node.height = Math.max(Height(node.left), Height(node.right)) + 1;
		top.height = Math.max(Height(top.left), Height(top.right)) + 1;
		return top;
	}

	private int Height(AVLNode<K, V> node) {
		int m, n;
		if (node != null) {
			m = Height(node.left);
			n = Height(node.right);
			return (m > n ? m : n) + 1;
		}
		return 0;
	}
}
