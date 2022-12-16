import java.util.*;

class Book{
	int id=0;
	String bookname=" ";
	String authorname=" ";
	
	public Book() {
		
	}
	
	public Book(int id,String authname,String bookname) {
		this.authorname=authname;
		this.bookname=bookname;
		this.id=id;
	}
}

class library{
	Scanner sc=new Scanner(System.in);
	int n;//no of books to be stored
	Book list[]=new Book[n];
	int m;
	Book list1[]=new Book[m+n];
	//Book list2[]=new Book[n+m];
	
	public void create() {
		System.out.println("how many books do u want to store: ");
		n=sc.nextInt();
		list=new Book[n];
		for(int i=0;i<n;i++) {
			System.out.println("enter the auth name: ");
			String name1=sc.next();
			System.out.println("enter the name of the book: ");
			String name2=sc.next();
			System.out.println("enter the id: ");
			int id1=sc.nextInt();
			list[i]=new Book(id1,name1,name2);
		}
	}
	
	
	
	public void add() {
		System.out.println("how many books do u want to add: ");
		m=sc.nextInt();
		list1=new Book[m+n];
		for(int i=0;i<m;i++) {
			System.out.println("enter the auth name: ");
			String name1=sc.next();
			System.out.println("enter the name of the book: ");
			String name2=sc.next();
			System.out.println("enter the id: ");
			int id1=sc.nextInt();
			list1[i]=new Book(id1,name1,name2);
		}
		for(int i=m;i<m+n;i++) {
			list1[i]=new Book(list[i-m].id,list[i-m].authorname,list[i-m].bookname);
		}
		
		
	}
	
	public void display() {
		int n=list.length;
		for(int i=0;i<n;i++) {
			System.out.println("Book No: "+(i+1));
			System.out.println("author name: "+list[i].authorname);
			System.out.println("book name: "+list[i].bookname);
			System.out.println("book id: "+list[i].id);
			System.out.println();
			}
	}
	
	
	
	public void displayAdded() {
		int n=list1.length;
		for(int i=0;i<n;i++) {
			System.out.println("New Book No: "+(i+1));
			System.out.println("author name: "+list1[i].authorname);
			System.out.println("book name: "+list1[i].bookname);
			System.out.println("book id: "+list1[i].id);
			System.out.println();
			}
	}
	
	public void search() {
		int flag=0;
		System.out.println("enter the id to seacrh for the book: ");
		int tempId=sc.nextInt();
		for(int i=0;i<list1.length;i++) {
			if(list1[i].id==tempId) {
				System.out.println("book found in the new added book list!!");
				System.out.println("author name: "+list1[i].authorname);
				System.out.println("book name: "+list1[i].bookname);
				System.out.println("book id: "+list1[i].id);
				System.out.println();
			}
		}
	}
	
	
	public void sort() {
		int n=list1.length;
		for(int i=1;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				if(list1[j].id>list1[j+1].id) {
					int temp=list1[j].id;
					list1[j].id=list1[j+1].id;
					list1[j+1].id=temp;
				}
			}
		}
		
	}
	
}

public class LibManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		library l=new library();
		int ch;
		int ch1=0;
		do {
			System.out.println("1.create");
			System.out.println("2.add");
			System.out.println("3.search");
			System.out.println("4.sort");
			System.out.println("enter your choice: ");
			ch=sc.nextInt();
			switch(ch) {
			case 1: l.create();
					l.display();
					break;
			case 2: l.add();
					l.displayAdded();
					break;
			case 3: l.search();
					break;
			case 4: l.sort();
					System.out.println("Sorted book list: ");
					System.out.println();
					l.displayAdded();
					break;
					
			}
			
			System.out.println("to continue press 1,");
			ch1=sc.nextInt();
		}while(ch1==1);
		
		
		
	}

}
