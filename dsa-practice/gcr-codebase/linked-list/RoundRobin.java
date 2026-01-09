import java.util.*;
class ProcessNode{
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;
    ProcessNode(int pid,int burstTime,int priority){
        this.pid=pid;
        this.burstTime=burstTime;
        this.remainingTime=burstTime;
        this.priority=priority;
        this.waitingTime=0;
        this.turnaroundTime=0;
        this.next=null;
    }
}
class RoundRobinScheduler{
    ProcessNode head;
    ProcessNode tail;
    int timeQuantum;
    int currentTime=0;
    RoundRobinScheduler(int timeQuantum){
        this.timeQuantum=timeQuantum;
    }
    void addProcess(int pid,int burstTime,int priority){
        ProcessNode newNode=new ProcessNode(pid,burstTime,priority);
        if(head==null){
            head=tail=newNode;
            newNode.next=head;
            return;
        }
        tail.next=newNode;
        newNode.next=head;
        tail=newNode;
    }
    void removeProcess(ProcessNode prev,ProcessNode curr){
        if(curr==head&&curr==tail){
            head=null;
            tail=null;
            return;
        }
        if(curr==head){
            head=head.next;
            tail.next=head;
        }else if(curr==tail){
            tail=prev;
            tail.next=head;
        }else{
            prev.next=curr.next;
        }
    }
    void simulate(){
        if(head==null){
            System.out.println("No processes to schedule");
            return;
        }
        ProcessNode curr=head;
        ProcessNode prev=tail;
        while(head!=null){
            displayQueue();
            if(curr.remainingTime>timeQuantum){
                curr.remainingTime-=timeQuantum;
                currentTime+=timeQuantum;
            }else{
                currentTime+=curr.remainingTime;
                curr.remainingTime=0;
                curr.turnaroundTime=currentTime;
                curr.waitingTime=curr.turnaroundTime-curr.burstTime;
                removeProcess(prev,curr);
                curr=prev.next;
                continue;
            }
            prev=curr;
            curr=curr.next;
        }
        displayAverages();
    }
    void displayQueue(){
        if(head==null){
            System.out.println("Queue empty");
            return;
        }
        ProcessNode temp=head;
        System.out.print("Queue: ");
        do{
            System.out.print("P"+temp.pid+"("+temp.remainingTime+") ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }
    void displayAverages(){
        ProcessNode temp=head;
        int totalWT=0;
        int totalTAT=0;
        int count=0;
        temp=tail;
        do{
            totalWT+=temp.waitingTime;
            totalTAT+=temp.turnaroundTime;
            count++;
            temp=temp.next;
        }while(temp!=tail);
        System.out.println("Average Waiting Time:"+(double)totalWT/count);
        System.out.println("Average Turnaround Time:"+(double)totalTAT/count);
    }
}
public class RoundRobin{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter time quantum");
        int tq=sc.nextInt();
        RoundRobinScheduler scheduler=new RoundRobinScheduler(tq);
        System.out.println("Enter number of processes");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.println("Enter PID");
            int pid=sc.nextInt();
            System.out.println("Enter Burst Time");
            int bt=sc.nextInt();
            System.out.println("Enter Priority");
            int pr=sc.nextInt();
            scheduler.addProcess(pid,bt,pr);
        }
        scheduler.simulate();
    }
}
