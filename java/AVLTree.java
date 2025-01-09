import java.util.Scanner;

class Node{
    int data;
    int h;
    Node leftChild;
    Node rightChild;
    public Node(){
        data=0;
        h=0;
        leftChild=null;
        rightChild=null;
    }
    public Node(int value){
        this.data=value;
        h=0;
        leftChild=null;
        rightChild=null;
    }
} 
class ConstructAVLTree{
    private Node root;
    public ConstructAVLTree(){
        root=null;
    }
    public void insert(int value){
        root=insert(root,value);
    }
    private int getHeight(Node node){
        return node==null?-1:node.h;
    }
    private  int max(int l,int r){
        return l>r?l:r;
    }
    private Node insert(Node node,int value){
        if(node==null){
            node=new Node(value);
        }
        else if(value<node.data){
            node.leftChild=insert(node.leftChild,value);
            if(getHeight(node.leftChild)-getHeight(node.rightChild)==2){
                if(value<node.rightChild.data){
                    node=rotateWithLeftChild(node);
                }
                else{
                    node=doubleWithLeftChild(node);
                }
            }
        }
        else if(value>node.data){
            node.rightChild=insert(node.rightChild,value);
            if(getHeight(node.rightChild)-getHeight(node.leftChild)==2){
                if(value<node.rightChild.data){
                    node=rotateWithRightChild(node);
                }
                else{
                    node=doubleWithRightChild(node);
                }
            }
        }
        else{}
        node.h=max(getHeight(node.leftChild),getHeight(node.rightChild))+1;
        return node;
    }
    private Node rotateWithLeftChild(Node node2){
        Node node1=node2.leftChild;
        node2.leftChild=node1.rightChild;
        node1.rightChild=node2;
        node2.h=max(getHeight(node2.leftChild),getHeight(node2.rightChild))+1;
        node1.h=max(getHeight(node1.leftChild),node2.h)+1;
        return node1;
    }
    private Node rotateWithRightChild(Node node1){
        Node node2=node1.rightChild;
        node1.rightChild=node2.leftChild;
        node2.leftChild=node1;
        node1.h=max(getHeight(node1.leftChild),getHeight(node1.rightChild))+1;
        node2.h=max(getHeight(node2.leftChild),node1.h)+1;
        return node2;
    }
    private Node doubleWithLeftChild(Node node3){
        node3.leftChild=rotateWithRightChild(node3.leftChild);
        return rotateWithLeftChild(node3);
    }
    private Node doubleWithRightChild(Node node1){
        node1.rightChild=rotateWithLeftChild(node1.rightChild);
        return rotateWithRightChild(node1);
    }
    public void inorderTraversal(){
        inorderTraversal(root);
    }
    private void inorderTraversal(Node node){
        if(node!=null){
            inorderTraversal(node.leftChild);
            System.out.print(node.data+" ");
            inorderTraversal(node.rightChild);
        }
    }
    public void preorderTraversal(){
        preorderTraversal(root);
    }
    private void preorderTraversal(Node node){
        if(node!=null){
            System.out.print(node.data+" ");
            inorderTraversal(node.leftChild);
            inorderTraversal(node.rightChild);
        }
    }
    public void postorderTraversal(){
        postorderTraversal(root);
    }
    private void postorderTraversal(Node node){
        if(node!=null){
            inorderTraversal(node.leftChild);
            inorderTraversal(node.rightChild);
            System.out.print(node.data+" ");
        }
    }
    public void search(int key){
        Node n=search(root,key);
        if(n==null) System.out.println("Key is not found in the Tree");
        else System.out.println("Key not found");
    }
    private Node search(Node node,int key){
        if(node==null || node.data==key)
            return node;
        else if(key<node.data)
            return search(node.leftChild,key);
        else 
            return search(node.rightChild,key);
    }
}
public class AVLTree{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ConstructAVLTree avl = new ConstructAVLTree();
            while(true){
                System.out.println("1. Insert: ");
                System.out.println("2. Search:");
                System.out.println("3. Inorder:\n4. Preorder:\n5. Postorder:");
                System.out.println("6. Exit");
                System.out.println("Enter choice: ");
                int ch = sc.nextInt();
                switch(ch){
                    case 1:
                        System.out.println("Enter element:");
                        int item = sc.nextInt();
                        avl.insert(item);
                        break;
                    
                    case 2:
                        System.out.println("Enter search");
                        int key = sc.nextInt();
                        avl.search(key);
                        break;
                    
                    case 3:
                        System.out.println("Inorder Traversal:");
                        avl.inorderTraversal();
                        System.out.println();
                        break;
                    
                    case 4:
                        System.out.println("Preorder Traversal:");
                        avl.preorderTraversal();
                        System.out.println();
                        break;
                    
                    case 5:
                        System.out.println("Postorder Traversal:");
                        avl.postorderTraversal();
                        System.out.println();
                        
                    
                    case 6:break;
                }
            }
        } 
    }
}