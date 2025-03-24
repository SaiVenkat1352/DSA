class DisJoint
{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    DisJoint(int n)
    {
        for(int i=0;i<n;i++)
        {
            rank.add(0);
            parent.add(i);

        }
    }
    public int findParent(int a)
    {
        if(parent.get(a)==a)return a;
        int ans=findParent(parent.get(a));
        parent.set(a,ans);
        return parent.get(a);

    }
    public void findUnion(int u,int v,int ex[])
    {
        int upu=findParent(u);
        int upv=findParent(v);
        
        if(upu==upv)
        {
            ex[0]++;
            return;
            
        }
        if(rank.get(upu)<rank.get(upv))
        {
            parent.set(upu,upv);

        }
        else if(rank.get(upv)<rank.get(upu))
        {
            parent.set(upv,upu);
            

        }
        else
        {
            parent.set(upv,upu);
            int a=rank.get(upu);
            rank.set(upu,a+1);
        }
    }
}







class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisJoint ds=new DisJoint(n);
        int a[]=new int[1];
        for(int i=0;i<connections.length;i++)
        {
            ds.findUnion(connections[i][0],connections[i][1],a);

        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(ds.findParent(i)==i)
            {
                count++;


            }
        }
        if(a[0]>=count-1)return count-1;
        //if(a[0]==count-1 )return a[0];
        return -1;

















        
    }
}