import java.util.*;

public class kargers_algo {

    static int create_edge_matrix(int[][] G, ArrayList<ArrayList<Integer>> edge_matrix) {
        int n = G.length;
        int edge_count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (G[i][j] == 1) {
                    ArrayList<Integer> nlist = new ArrayList<>();
                    nlist.add(i);
                    nlist.add(j);
                    edge_matrix.add(nlist);
                    edge_count++;
                }
            }
        }
        return edge_count;
    }

    static int findPar(int par[], int node) {
        if (par[node] == node)
            return node;
        return par[node] = findPar(par, par[node]);
    }

    static void unionBySize(int[] size, int[] par, int u, int v) {
        int pu = findPar(par, u);
        int pv = findPar(par, v);
        if (pu == pv)
            return;
        if (size[pu] < size[pv]) {
            par[pu] = pv;
            size[v] += size[u];
        } else {
            par[pv] = pu;
            size[u] += size[v];
        }
    }

    static int karger_algo(int[][] G) {
        int num_vertex = G.length;

        // for disjoint set
        int[] size = new int[num_vertex];
        int[] par = new int[num_vertex];
        for (int i = 0; i < num_vertex; i++) {
            par[i] = i;
            size[i] = 1;
        }

        // create edge-matrix
        ArrayList<ArrayList<Integer>> edge_matrix = new ArrayList<>();
        int edge_count = create_edge_matrix(G, edge_matrix);

        // vetrex contarction
        int num = num_vertex;
        while (num > 2) {
            Random r = new Random();
            int temp = (r.nextInt());
            temp = temp < 0 ? temp * -1 : temp;
            int rand = (temp % edge_count);

            int u = edge_matrix.get(rand).get(0);
            int v = edge_matrix.get(rand).get(1);

            if (findPar(par, u) != findPar(par, v)) {
                unionBySize(size, par, u, v);
                num--;
            }
        }

        // count cross edges
        int num_cross_edge = 0;
        for (int i = 0; i < edge_count; i++) {
            int u = edge_matrix.get(i).get(0);
            int v = edge_matrix.get(i).get(1);
            if (findPar(par, u) != findPar(par, v)) {
                num_cross_edge++;
                // System.out.println(u+" <-----> "+v);
            }
        }

        // System.out.println("min cut : " + num_cross_edge);
        return num_cross_edge;
    }

    public static void main(String[] args) {
        // int[][] G = new int[][]{{0,1,1,1},{1,0,1,0},{1,1,0,1},{1,0,1,0}};
        int[][] G = new int[][] { { 0, 1, 0, 0, 1, 1 }, { 1, 0, 1, 1, 0, 0 }, { 0, 1, 0, 1, 0, 0 },
                { 0, 1, 1, 0, 1, 0 }, { 1, 0, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1, 0 } };
        int n = G.length;
        // karger_algo(G);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= 100 * n * n; i++) {
            min = Math.min(min, karger_algo(G));
        }
        System.out.println("min cut : " + min);
    }
}