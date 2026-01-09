import java.util.*;
class ItemNode{
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;
    ItemNode(int itemId,String itemName,int quantity,double price){
        this.itemId=itemId;
        this.itemName=itemName;
        this.quantity=quantity;
        this.price=price;
        this.next=null;
    }
}
class InventoryLinkedList{
    ItemNode head;
    void addBeginning(int itemId,String itemName,int quantity,double price){
        ItemNode newNode=new ItemNode(itemId,itemName,quantity,price);
        newNode.next=head;
        head=newNode;
    }
    void addEnd(int itemId,String itemName,int quantity,double price){
        ItemNode newNode=new ItemNode(itemId,itemName,quantity,price);
        if(head==null){
            head=newNode;
            return;
        }
        ItemNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void addAtPosition(int pos,int itemId,String itemName,int quantity,double price){
        if(pos==1){
            addBeginning(itemId,itemName,quantity,price);
            return;
        }
        ItemNode temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Invalid position");
            return;
        }
        ItemNode newNode=new ItemNode(itemId,itemName,quantity,price);
        newNode.next=temp.next;
        temp.next=newNode;
    }
    void removeById(int itemId){
        if(head==null){
            System.out.println("Inventory is empty");
            return;
        }
        if(head.itemId==itemId){
            head=head.next;
            System.out.println("Item removed");
            return;
        }
        ItemNode temp=head;
        while(temp.next!=null&&temp.next.itemId!=itemId){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Item not found");
        }else{
            temp.next=temp.next.next;
            System.out.println("Item removed");
        }
    }
    void updateQuantity(int itemId,int newQuantity){
        ItemNode temp=head;
        while(temp!=null){
            if(temp.itemId==itemId){
                temp.quantity=newQuantity;
                System.out.println("Quantity updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Item not found");
    }
    void searchById(int itemId){
        ItemNode temp=head;
        while(temp!=null){
            if(temp.itemId==itemId){
                displayItem(temp);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Item not found");
    }
    void searchByName(String name){
        ItemNode temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.itemName.equalsIgnoreCase(name)){
                displayItem(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("Item not found");
    }
    void totalInventoryValue(){
        double total=0;
        ItemNode temp=head;
        while(temp!=null){
            total+=temp.price*temp.quantity;
            temp=temp.next;
        }
        System.out.println("Total Inventory Value:"+total);
    }
    void sortByName(boolean ascending){
        head=mergeSortByName(head,ascending);
        System.out.println("Inventory sorted by name");
    }
    void sortByPrice(boolean ascending){
        head=mergeSortByPrice(head,ascending);
        System.out.println("Inventory sorted by price");
    }
    ItemNode mergeSortByName(ItemNode node,boolean asc){
        if(node==null||node.next==null) return node;
        ItemNode mid=getMiddle(node);
        ItemNode nextMid=mid.next;
        mid.next=null;
        ItemNode left=mergeSortByName(node,asc);
        ItemNode right=mergeSortByName(nextMid,asc);
        return mergeByName(left,right,asc);
    }
    ItemNode mergeByName(ItemNode a,ItemNode b,boolean asc){
        if(a==null) return b;
        if(b==null) return a;
        int cmp=a.itemName.compareToIgnoreCase(b.itemName);
        if((asc&&cmp<=0)||(!asc&&cmp>0)){
            a.next=mergeByName(a.next,b,asc);
            return a;
        }else{
            b.next=mergeByName(a,b.next,asc);
            return b;
        }
    }
    ItemNode mergeSortByPrice(ItemNode node,boolean asc){
        if(node==null||node.next==null) return node;
        ItemNode mid=getMiddle(node);
        ItemNode nextMid=mid.next;
        mid.next=null;
        ItemNode left=mergeSortByPrice(node,asc);
        ItemNode right=mergeSortByPrice(nextMid,asc);
        return mergeByPrice(left,right,asc);
    }
    ItemNode mergeByPrice(ItemNode a,ItemNode b,boolean asc){
        if(a==null) return b;
        if(b==null) return a;
        if((asc&&a.price<=b.price)||(!asc&&a.price>b.price)){
            a.next=mergeByPrice(a.next,b,asc);
            return a;
        }else{
            b.next=mergeByPrice(a,b.next,asc);
            return b;
        }
    }
    ItemNode getMiddle(ItemNode node){
        if(node==null) return node;
        ItemNode slow=node;
        ItemNode fast=node.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    void displayAll(){
        if(head==null){
            System.out.println("No items available");
            return;
        }
        ItemNode temp=head;
        while(temp!=null){
            displayItem(temp);
            temp=temp.next;
        }
    }
    void displayItem(ItemNode i){
        System.out.println("Item ID:"+i.itemId);
        System.out.println("Item Name:"+i.itemName);
        System.out.println("Quantity:"+i.quantity);
        System.out.println("Price:"+i.price);
        System.out.println("-----------------");
    }
}
public class InventorySystem{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        InventoryLinkedList list=new InventoryLinkedList();
        boolean loop=true;
        while(loop){
            System.out.println("1.Add Item\n2.Remove Item\n3.Update Quantity\n4.Search by ID\n5.Search by Name\n6.Total Value\n7.Sort\n8.Display\n0.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter item id");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter item name");
                    String name=sc.nextLine();
                    System.out.println("Enter quantity");
                    int qty=sc.nextInt();
                    System.out.println("Enter price");
                    double price=sc.nextDouble();
                    System.out.println("1.Beginning 2.End 3.Position");
                    int posChoice=sc.nextInt();
                    if(posChoice==1) list.addBeginning(id,name,qty,price);
                    else if(posChoice==2) list.addEnd(id,name,qty,price);
                    else if(posChoice==3){
                        System.out.println("Enter position");
                        int pos=sc.nextInt();
                        list.addAtPosition(pos,id,name,qty,price);
                    }
                    break;
                case 2:
                    System.out.println("Enter item id");
                    list.removeById(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter item id");
                    int uid=sc.nextInt();
                    System.out.println("Enter new quantity");
                    int nq=sc.nextInt();
                    list.updateQuantity(uid,nq);
                    break;
                case 4:
                    System.out.println("Enter item id");
                    list.searchById(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Enter item name");
                    sc.nextLine();
                    list.searchByName(sc.nextLine());
                    break;
                case 6:
                    list.totalInventoryValue();
                    break;
                case 7:
                    System.out.println("1.Name 2.Price");
                    int s=sc.nextInt();
                    System.out.println("1.Ascending 2.Descending");
                    int o=sc.nextInt();
                    if(s==1) list.sortByName(o==1);
                    else if(s==2) list.sortByPrice(o==1);
                    break;
                case 8:
                    list.displayAll();
                    break;
                case 0:
                    loop=false;
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
