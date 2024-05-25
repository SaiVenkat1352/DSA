class BrowserHistory {
    
    Node temp;
    
    public BrowserHistory(String homepage) {
        temp=new Node(homepage);
        
    }
    public void visit(String url) {
        Node newUrl=new Node(url);
        temp.next=newUrl;
        newUrl.prev=temp;
        temp=temp.next;
        
    }
    
    public String back(int steps) {
        while(steps>0)
        {
            if(temp.prev!=null)temp=temp.prev;
            else break;
            steps--;
        }
        return temp.data;
    }
    
    public String forward(int steps) {
        while(steps>0)
        {
            if(temp.next!=null)temp=temp.next;
            else break;
            steps--;
        }
        return temp.data;
    }
}
class Node{
    String data;
    Node next;
    Node prev;
    
    Node(String data)
    {
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

 