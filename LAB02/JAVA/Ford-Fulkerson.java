import java.util.*;

// 1). find the Max flow from the given flow network using Ford-Fulkerson algorithm.

class HelloWorld {
    static boolean bfs(int s,int t,int[][] G,int[] par){
        int n = G.length;
        int vis[] = new int[n];
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        
        while(!que.isEmpty()){
            int u = que.remove();
            
            for(int v = 1 ; v < n ; v++){
                if(G[u][v]>0 && vis[v]==0){
                    if(v==t){
                        vis[v] = 1;
                        par[v] = u;
                        return true;
                    }
                    vis[v] = 1;
                    par[v] = u;
                    que.add(v);
                }
            }
        }
        return false;
    }
    
    static int findBottleNeck(int s,int t,int[][] G,int[] par){
        int min = Integer.MAX_VALUE;
        for(int v = t ; v!=s ; v = par[v]){
            int u = par[v];
            min = Math.min(min,G[u][v]);
        }
        return min;
    }
    
    static void creatResidualGraph(int s,int t,int[][] G,int[] par,int flow){
        Stack<Integer> st = new Stack<>();
        for(int v = t ; v!=s ; v = par[v]){
            st.push(v);
            int u = par[v];
            G[u][v] -= flow;
            G[v][u] += flow;
        }
        System.out.print(0);
        while(!st.isEmpty()){
            System.out.print(" -> "+st.pop());
        }
        System.out.println(" = " + flow);
    }
    public static void main(String[] args) {
        int n = 6;
        int maxflow = 0;
        int[][] G = new int[][]{{0,16,13,0,0,0},
                           {0,0,10,12,0,0},
                           {0,4,0,0,14,0},
                           {0,0,9,0,0,20},
                           {0,0,0,7,0,4},
                           {0,0,0,0,0,0}};
        while(true){
            int[] par = new int[n];
            if(bfs(0,n-1,G,par)==true){
                int flow = findBottleNeck(0,n-1,G,par);
                maxflow += flow;
                creatResidualGraph(0,n-1,G,par,flow);
            }
            else{
                break;
            }
        }
        System.out.println("MAX FLOW : "+maxflow);
        
    }
    
    
}