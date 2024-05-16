import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //object creation for BST class
      BST o=new BST();
  
      o.insert(5);
      o.insert(6);
      o.insert(3);
      o.insert(2);
      o.insert(11);
      o.insert(20);
      o.insert(110);
      //Looping based search
     System.out.println(o.search(20));
  //recursion based search
     System.out.println(o.Search(o.Realroot,50));
  }
}
//structure of each node
class node{
  int data;
  node left,right;
  node(int key){
    data=key;
    left=right=null;
  }
}
//BINARY SEARCH TREE CLASS
class BST{
    //original Root declaration
    node Realroot;
    ////normal insert method to avoid unwanted error for backtrack
    void insert(int key){
        //calling recursive insert method and reassigning root again
        Realroot=insertRecursively(Realroot,key);
    }
    //recursive insert method 
    node insertRecursively(node dupRoot,int key){
    //condtion for creating new node 
        if(dupRoot==null){
           dupRoot= new node(key);
            return dupRoot;
        }
    //condition for right side insertion  
        if(key>dupRoot.data){
    //calling recursive insert but this time with dupRoot->right as dupRoot
            dupRoot.right=insertRecursively(dupRoot.right,key);
        }
         //condition for left side insertion  
       else if(key<dupRoot.data){
    //calling recursive insert but this time with dupRoot->left as dupRoot
            dupRoot.left=insertRecursively(dupRoot.left,key);
        }
    //return for original Root
        return dupRoot;
    }
//inOrder traversal
    void inOrder(node Root){
        if(Root!=null){
            //traversing till left end
            inOrder(Root.left);
            //printing data
            System.out.print(Root.data+" ");
            //traversing till right side end
            inOrder(Root.right);
        }
       
    }
//preOrder traversal
    void preOrder(node Root){
        if(Root!=null){
             //printing data
             System.out.print(Root.data+" ");
              //traversing till left end
            inOrder(Root.left);
              //traversing till right side end
            inOrder(Root.right);
        }
    }
    //postOrder traversal
    void postOrder(node Root){
        if(Root!=null){
             //traversing till left end
            inOrder(Root.left);
              //traversing till right side end
            inOrder(Root.right);
             //printing data
             System.out.print(Root.data+" ");
        }
    }
    boolean search(int target){
      //assigning temp with original Root Value
      node temp=Realroot;
      //condition for not finding any data
      if(temp==null) return false;
      else {
        //loopd to check all nodes till it reaches null
        while(temp!=null){
      //left search condition 
        if(temp.data>target)
          //moving temp to its left side
         temp=temp.left;
      //right search condition   
         else if(temp.data<target)
      //moving temp to its right side
         temp=temp.right;
        //Equal case
         else{
           return true;
         }
      }
    //if data not found it will return false
      return false;
      }
      
    }
    boolean Search(node temp,int target){
        //condition for not finding any data
      if(temp==null) return false;
       //left search condition 
      else if(target<temp.data)
        //moving temp to its left side
      return Search(temp.left,target);
        //right search condition   
      else if(target>temp.data)
         //moving temp to its right side
      return Search(temp.right,target);
        //Equal case
      else return true;
    }
}

