import java.util.*;
class FriendNode{
    int friendId;
    FriendNode next;
    FriendNode(int friendId){
        this.friendId=friendId;
        this.next=null;
    }
}
class UserNode{
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;
    UserNode(int userId,String name,int age){
        this.userId=userId;
        this.name=name;
        this.age=age;
        this.friends=null;
        this.next=null;
    }
}
class SocialMediaList{
    UserNode head;
    void addUser(int userId,String name,int age){
        UserNode newUser=new UserNode(userId,name,age);
        newUser.next=head;
        head=newUser;
    }
    UserNode findUserById(int userId){
        UserNode temp=head;
        while(temp!=null){
            if(temp.userId==userId) return temp;
            temp=temp.next;
        }
        return null;
    }
    UserNode findUserByName(String name){
        UserNode temp=head;
        while(temp!=null){
            if(temp.name.equalsIgnoreCase(name)) return temp;
            temp=temp.next;
        }
        return null;
    }
    void addFriend(int userId,int friendId){
        UserNode user=findUserById(userId);
        UserNode friend=findUserById(friendId);
        if(user==null||friend==null){
            System.out.println("User not found");
            return;
        }
        user.friends=addFriendNode(user.friends,friendId);
        friend.friends=addFriendNode(friend.friends,userId);
        System.out.println("Friend connection added");
    }
    FriendNode addFriendNode(FriendNode head,int id){
        FriendNode newNode=new FriendNode(id);
        newNode.next=head;
        return newNode;
    }
    void removeFriend(int userId,int friendId){
        UserNode user=findUserById(userId);
        UserNode friend=findUserById(friendId);
        if(user==null||friend==null){
            System.out.println("User not found");
            return;
        }
        user.friends=removeFriendNode(user.friends,friendId);
        friend.friends=removeFriendNode(friend.friends,userId);
        System.out.println("Friend connection removed");
    }
    FriendNode removeFriendNode(FriendNode head,int id){
        if(head==null) return null;
        if(head.friendId==id) return head.next;
        FriendNode temp=head;
        while(temp.next!=null&&temp.next.friendId!=id){
            temp=temp.next;
        }
        if(temp.next!=null) temp.next=temp.next.next;
        return head;
    }
    void displayFriends(int userId){
        UserNode user=findUserById(userId);
        if(user==null){
            System.out.println("User not found");
            return;
        }
        System.out.println("Friends of "+user.name+":");
        FriendNode temp=user.friends;
        if(temp==null){
            System.out.println("No friends");
            return;
        }
        while(temp!=null){
            System.out.println("Friend ID:"+temp.friendId);
            temp=temp.next;
        }
    }
    void mutualFriends(int userId1,int userId2){
        UserNode u1=findUserById(userId1);
        UserNode u2=findUserById(userId2);
        if(u1==null||u2==null){
            System.out.println("User not found");
            return;
        }
        FriendNode f1=u1.friends;
        boolean found=false;
        System.out.println("Mutual Friends:");
        while(f1!=null){
            FriendNode f2=u2.friends;
            while(f2!=null){
                if(f1.friendId==f2.friendId){
                    System.out.println("Friend ID:"+f1.friendId);
                    found=true;
                }
                f2=f2.next;
            }
            f1=f1.next;
        }
        if(!found) System.out.println("No mutual friends");
    }
    void countFriends(){
        UserNode temp=head;
        while(temp!=null){
            int count=0;
            FriendNode f=temp.friends;
            while(f!=null){
                count++;
                f=f.next;
            }
            System.out.println(temp.name+" has "+count+" friends");
            temp=temp.next;
        }
    }
    void searchUser(){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Search by ID 2.Search by Name");
        int ch=sc.nextInt();
        sc.nextLine();
        UserNode user=null;
        if(ch==1){
            System.out.println("Enter ID");
            user=findUserById(sc.nextInt());
        }else{
            System.out.println("Enter Name");
            user=findUserByName(sc.nextLine());
        }
        if(user==null){
            System.out.println("User not found");
            return;
        }
        System.out.println("User ID:"+user.userId);
        System.out.println("Name:"+user.name);
        System.out.println("Age:"+user.age);
    }
}
public class SocialMedia{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        SocialMediaList list=new SocialMediaList();
        boolean loop=true;
        while(loop){
            System.out.println("1.Add User\n2.Add Friend\n3.Remove Friend\n4.Display Friends\n5.Mutual Friends\n6.Search User\n7.Count Friends\n0.Exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter user id");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name");
                    String name=sc.nextLine();
                    System.out.println("Enter age");
                    int age=sc.nextInt();
                    list.addUser(id,name,age);
                    break;
                case 2:
                    System.out.println("Enter user id");
                    int u1=sc.nextInt();
                    System.out.println("Enter friend id");
                    int u2=sc.nextInt();
                    list.addFriend(u1,u2);
                    break;
                case 3:
                    System.out.println("Enter user id");
                    int r1=sc.nextInt();
                    System.out.println("Enter friend id");
                    int r2=sc.nextInt();
                    list.removeFriend(r1,r2);
                    break;
                case 4:
                    System.out.println("Enter user id");
                    list.displayFriends(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Enter first user id");
                    int m1=sc.nextInt();
                    System.out.println("Enter second user id");
                    int m2=sc.nextInt();
                    list.mutualFriends(m1,m2);
                    break;
                case 6:
                    list.searchUser();
                    break;
                case 7:
                    list.countFriends();
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
