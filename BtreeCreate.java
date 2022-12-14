package dsl6;

import java.util.*;

class node{
	int data;
	node left;
	node right;
	
	public node(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

 class BinaryTree{
	public node create() {
		Scanner s=new Scanner(System.in);
		node root = null;
		System.out.println("Enter data: ");
		int data = s.nextInt();
		
		if(data == -1) return null;
		
		root = new node(data);
		
		System.out.println("Enter left for " + data);
		root.left = create();
		
		System.out.println("Enter right for "+ data);
		root.right = create();
		
		return root;
		}
	
	//1.recursive inorder traversal
	public void recurInorder(node root) {
		if(root == null) return;
		
		recurInorder(root.left);
		System.out.print(root.data+" ");
		recurInorder(root.right);
	}
	
	//2.recursive preorder traversal
		public void recurPreorder(node root) {
			if(root==null) {
				//System.out.println("null node");
				return;
			}
			
			System.out.print(root.data+" ");
			recurPreorder(root.left);
			recurPreorder(root.right);
		}
		
	//3.recursive post order traversal
		public void recurPostorder(node root) {
			if(root==null) {
				//System.out.println("null node");
				return;
			}
			
			recurPostorder(root.left);
			recurPostorder(root.right);
			System.out.print(root.data+" ");
		}
		
	//4.NonRecursive inorder traversal
		
		//root2 store the root value since create function returns the actual root of the created binary tree
		public void nonRecurInorder(node root) {
			if (root == null)
           			 return;
  
			Stack<node> s = new Stack<node>();
			node curr = root;
			// traverse the tree
			while (curr != null || s.size() > 0)
			{
			    while (curr !=  null)
			    {
				s.push(curr);
				curr = curr.left;
			    }

			    curr = s.pop();
			    System.out.print(curr.data + " ");
			    curr = curr.right;
			 }
			
	}
		
	//5.non recursive preorder traversal
		public void nonRecurPreorder(node root) {
			/*if(root==null) {
				System.out.println("null node");
				return;
			}*/
			
			if(root==null) {
			System.out.println("null node");
			return;
		}
		
		Stack <node> st= new Stack<node>();
		st.push(root);
		while(st.empty()==false) {
			node curr=st.peek();
			System.out.println(curr.data);
			st.pop();
			if(curr.right!=null) {
				st.push(curr.right);
			}
			if(curr.left!=null) {
				st.push(curr.left);
			}
		}
	}
		
	//6.non recursive post order traversal
		public void nonRecurPostorder(node root) {
			Stack<node> st = new Stack<node>();
			boolean check = true;
			while(true){
			    while(root != null && check){
				st.push(root);
				root = root.left;
			  }
			    if(st.empty()) break;

			    if(root != st.peek().right){
				root = st.peek().right;
				check = true;
				continue;
			  }

			    root = st.pop();
			    System.out.print(root.data + " ");
			    check = false;
            
        }
		
	}
	
 }
public class BtreeCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		BinaryTree b=new BinaryTree();
		node root=b.create();
		int no;
		do {
			System.out.println("Enter the choice for traversal: ");
			System.out.println("1: RECURSIVE INORDER");
			System.out.println("2: RECURSIVE PREORDER");
			System.out.println("3: RECURSIVE POSTORDER");
			System.out.println("4: NonRECURSIVE INORDER");
			System.out.println("5: NonRECURSIVE PREORDER");
			System.out.println("6: NonRECURSUVE POSTORDER");
			int ch=s.nextInt();
			switch(ch) {
			
			case 1: System.out.println("inorder: ");
					b.recurInorder(root);
					System.out.println();
					break;
			case 2: System.out.println("preorder: ");
					b.recurPreorder(root);
					System.out.println();
					break;
			case 3: System.out.println("postorder: ");
					b.recurPostorder(root);
					System.out.println();
					break;
			case 4: System.out.println("NON Recurive inorder: ");
					b.nonRecurInorder(root);
					System.out.println();
					break;
			case 5: System.out.println("NON Recursive preorder: ");
					b.nonRecurPreorder(root);
					System.out.println();
					break;
			case 6: System.out.println("NON Recursive postorder: ");
					b.nonRecurPostorder(root);
					System.out.println();
					break;
			}
			
			System.out.println("Do you want to continue ,1 to continue,0 to exit");
			no=s.nextInt();

		}while(no==1);
		
	}
 }


