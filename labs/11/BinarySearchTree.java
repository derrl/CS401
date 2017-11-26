import java.util.*;

public class BinarySearchTree<E>  {

   private int index;       
   private TreeNode<E> root;
   protected Comparator<E> comp;

   public BinarySearchTree()  {
      index = 0;
      root = null;
	  comp = new Comparator<E>(){
			public int compare(E element1, E element2){
				return ((Comparable)element1).compareTo(element2);
			}
	  };
   }

   public BinarySearchTree(Comparator<E> comp){
		root = null;
		this.comp = comp;
   }

   public int size() { return size_p(root); }

	
   private int size_p(TreeNode<E> t)  {
	  if (t == null)
			return 0;
	  else return(1 + size_p(t.get_left()) + size_p(t.get_right()));
   }

   public void inorder() { inorder_p(root); }

   private void inorder_p(TreeNode<E> t)  {
	  if (t != null){
		inorder_p(t.get_left());
		System.out.print(t.info + " ");
		inorder_p(t.get_right());
	  }
      return;
   }

   public void preorder() { preorder_p(root); }

   private void preorder_p(TreeNode<E> t)  {
      if (t != null){
		System.out.print(t.info + " ");
		preorder_p(t.get_left());
		preorder_p(t.get_right());
	  }  
      return;
   }

   public void postorder() { postorder_p(root); }

   private void postorder_p(TreeNode<E> t)  {
      if (t != null){
		postorder_p(t.get_left());
		postorder_p(t.get_right());
		System.out.print(t.info + " ");
	  } 
	  return;
   }

	protected int maxDepth(TreeNode<E> node){
		if(node == null)
			return 0;
		else{
			int lDepth = maxDepth(node.get_left());
			int rDepth = maxDepth(node.get_right());

			if(lDepth > rDepth)
				return(lDepth+1);
			else return(rDepth+1);
		}
	}

	public boolean add (E element){
		root = recAdd(element, root);
		return true;
	}

	public TreeNode<E> recAdd(E info, TreeNode<E> node){
		if(node == null)
			node = new TreeNode<E>(info);
		else if (comp.compare(info, node.getInfo())<=0)
			node.setLeft(recAdd(info, node.get_left()));
		else
			node.setRight(recAdd(info, node.get_right()));
		return node;
	}

   public static void main(String[] args)  {
      BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();

      bt.add(25);  
      bt.add(15);  
      bt.add(50);  
      bt.add(10);   
      bt.add(22);   
      bt.add(35); 
      bt.add(70); 
      bt.add(4); 
      bt.add(12); 
      bt.add(18); 
      bt.add(24); 
      bt.add(31); 
      bt.add(44); 
      bt.add(66); 
      bt.add(90); 

	  System.out.println("The maximum depth is " + bt.maxDepth(bt.root)+".");
      System.out.println("The tree has " + bt.size() + " nodes.");
		System.out.print("Inorder:\t");
      bt.inorder();
		System.out.println();
		System.out.print("Preorder:\t");
      bt.preorder();
		System.out.println();
		System.out.print("Postorder:\t");
      bt.postorder();
		System.out.println();

      return;
   }

   public class TreeNode<E>  {
      private TreeNode<E> left,right;
      private E info;

      public TreeNode(E info) { left = right = null; this.info = info; }
      public void setInfo(E info){this.info = info;}
      public E getInfo() {return info;}
      public void setLeft(TreeNode<E> link) {left = link;}
      public void setRight(TreeNode<E> link) {right = link;}
      public TreeNode<E> get_left()  { return left; }
      public TreeNode<E> get_right() { return right;}
   }
}
