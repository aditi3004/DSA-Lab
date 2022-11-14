


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
		public void nonRecurInorder(root) {
			if(root==null) {
				System.out.println("empty root node");
			}
			
			Stack<node> s=new Stack<node>();
			node curr=root;
			//now we are traversing the tree, size function from stack package to check the stack is not empty
			 while (curr != null || s.size() > 0)
		        {
		  
		            //Reach the left most node of the curr node 
		            while (curr !=  null)
		            {
		                // place pointer to a tree node on the stack before traversing the node's left subtree 
		            	//because we store the current node into the stack and then move ahead
		                s.push(curr);
		                curr = curr.left;
		            }
		  
		            // Current must be NULL at this point 
		            curr = s.pop();
		  
		            System.out.print(curr.data + " ");
		  
		            //we have visited the node and its left subtree.  Now, it's right subtree's turn 
		            curr = curr.right;
		        }
			
	}
		
	//5.non recursive preorder traversal
		public void nonRecurPreorder() {
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
		
	//6.non recursive post order traversal
		public void nonRecurPostorder(root) {
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
			
			case 1: b.recurInorder(root);
					System.out.println();
					break;
			case 2: b.recurPreorder(root);
					System.out.println();
					break;
			case 3: b.recurPostorder(root);
					System.out.println();
					break;
			case 4: b.nonRecurInorder();
					System.out.println();
					break;
			case 5: b.nonRecurPreorder();
					System.out.println();
					break;
			case 6: b.nonRecurPostorder();
					System.out.println();
					break;
			}
			
			System.out.println("Do you want to continue ,1 to continue,0 to exit");
			no=s.nextInt();

		}while(no==1);
		
	}

}}
