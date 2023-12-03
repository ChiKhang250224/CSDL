package Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public BNode<E> getRoot() {
		return root;
	}

	public void setRoot(BNode<E> root) {
		this.root = root;
	}

	// Add element e into BST
	public void add(E e) {
		root = addRecursive(root, e);
	}

	private BNode<E> addRecursive(BNode<E> current, E e) {
		if (current == null) {
			return new BNode<>(e);
		}

		int result = e.compareTo(current.getData());

		if (result < 0) {
			current.setLeft(addRecursive(current.getLeft(), e));
		} else if (result > 0) {
			current.setRight(addRecursive(current.getRight(), e));
		}
		return current;
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// Find the minimum element in BST
	public E findMin() {
		BNode<E> current = root;

		if (current == null) {
			return null;
		}

		while (current.getLeft() != null) {
			current = current.getLeft();
		}

		return current.getData();
	}

	// Find the maximum element in BST
	public E findMax() {
		BNode<E> current = root;

		if (current == null) {
			return null;
		}

		while (current.getRight() != null) {
			current = current.getRight();
		}

		return current.getData();
	}

	// compute the height of BST
	public int height() {
		return tinhHeight(root);
	}

	private int tinhHeight(BNode<E> node) {
		if (node == null) {
			return -1;
		}
		int max = 1;
		int leftHeight = tinhHeight(node.getLeft());
		int rightHeight = tinhHeight(node.getRight());
		if (leftHeight > rightHeight) {
			max = leftHeight;
		} else {
			max = rightHeight;
		}

		return max;
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		return containsElement(root, e);
	}

	private boolean containsElement(BNode<E> node, E e) {
		if (node == null) {
			return false;

		}
		int result = e.compareTo(node.getData());
		if (result == 0) {
			return true;
		} else if (result < 0) {
			return containsElement(node.getLeft(), e);
		} else {
			return containsElement(node.getRight(), e);
		}
	}

	public int size() {
		return tinhSize(root);
	}

	private int tinhSize(BNode<E> node) {
		if (node == null) {
			return 0;
		}
		int leftSize = tinhSize(node.getLeft());
		int rightSize = tinhSize(node.getRight());

		return leftSize + rightSize + 1;
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (node == null) {
			return -1;
		}
		int depth = 0;
		BNode<E> current = root;
		while (current != null) {
			if (node.compareTo(current.getData()) == 0) {
				return depth;
			} else if (node.compareTo(current.getData()) < 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
			depth++;
		}
		return -1;
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		}
		BNode<E> parent = null;
		BNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.getData()) == 0) {
				break;
			} else if (e.compareTo(current.getData()) < 0) {
				parent = current;
				current = current.getLeft();
			} else {
				parent = current;
				current = current.getRight();
			}
		}
		if (current == null) {
			return false;
		}
		if (current.getLeft() == null) {
			if (parent == null) {
				root = current.getRight();
			} else {
				if (e.compareTo(parent.getData()) < 0) {
					parent.setLeft(current.getRight());
				} else {
					parent.setRight(current.getRight());
				}
			}
		} else {
			BNode<E> parentOfRightMost = current;
			BNode<E> rightMost = current.getLeft();
			while (rightMost.getRight() != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.getRight();
			}
			current.setData(rightMost.getData());
			if (parentOfRightMost.getRight() == rightMost) {
				parentOfRightMost.setRight(rightMost.getLeft());
			} else {
				parentOfRightMost.setLeft(rightMost.getLeft());
			}
		}
		return true;
	}

	public List<E> descendants(E data) {
		List<E> descendantsList = new ArrayList<>();
		BNode<E> node = findNode(root, data);

		if (node != null) {
			getDescendants(node, descendantsList);
		}

		return descendantsList;
	}

	private void getDescendants(BNode<E> node, List<E> descendantsList) {
		if (node != null) {
			descendantsList.add(node.getData());
			getDescendants(node.getLeft(), descendantsList);
			getDescendants(node.getRight(), descendantsList);
		}
	}

	private BNode<E> findNode(BNode<E> node, E data) {
		if (node == null) {
			return null;
		}

		int compareResult = data.compareTo(node.getData());

		if (compareResult == 0) {
			return node; // Node found
		} else if (compareResult < 0) {
			return findNode(node.getLeft(), data); // Search in the left subtree
		} else {
			return findNode(node.getRight(), data); // Search in the right subtree
		}
	}

	public List<E> ancestors(E data) {
		List<E> ancestorsList = new ArrayList<>();
		findAncestors(root, data, ancestorsList);
		return ancestorsList;
	}

	private boolean findAncestors(BNode<E> node, E data, List<E> ancestorsList) {
		if (node == null) {
			return false;
		}

		if (node.getData().equals(data)) {
			return true;
		}

		if (findAncestors(node.getLeft(), data, ancestorsList) || findAncestors(node.getRight(), data, ancestorsList)) {
			ancestorsList.add(node.getData());
			return true;
		}

		return false;
	}

//TASK 2

	// display BST using inorder approach

	public void inorder(BNode<E> node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + " ");
			inorder(node.getRight());
		}

	}

	// display BST using preorder approach

	public void preorder(BNode<E> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}

	}

	// display BST using postorder approach
	public void postorder(BNode<E> node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(7);
		bst.add(12);
		bst.add(18);

		System.out.println("Inorder:");
		bst.inorder(bst.getRoot());
		System.out.println();

		System.out.println("Preorder:");
		bst.preorder(bst.getRoot());
		System.out.println();

		System.out.println("Postorder: ");
		bst.postorder(bst.getRoot());
		System.out.println();

		System.out.println(bst.findMin());
		System.out.println(bst.findMax());
		System.out.println(bst.height());

		int elementToSearch = 7;
		System.out.println(bst.contains(elementToSearch));

		int elementToRemove = 5;
		System.out.println(bst.remove(elementToRemove));

		System.out.println("Inorder sau khi xoa");
		bst.inorder(bst.getRoot());
	}

}
