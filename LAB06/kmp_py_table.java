import java.util.*;

public class kmp
{
    static int cnt = 0;


    public static int[] create_py_table(String p){
        cnt=0;
        //for one base indexing
        String pat = "#"+p;

        int m = pat.length();
        int[] py = new int[m];
        System.out.println("pat len : "+(m-1));

        py[1] = 0;
        int k = 0;

        //1). outer for loop and inner while loop
        for(int q = 2 ; q < m ; q++){
            boolean t = pat.charAt(k+1)==pat.charAt(q);
            cnt++;
            while(k>0 && !t){
                k = py[k];
                t = pat.charAt(k+1)==pat.charAt(q);
                cnt++;
            }

            if(t){
                k++;
            }
            py[q] = k;
        }

        // 2). using one loop only 
        // int q = 2;
        // while(q<m){
        //     boolean t = pat.charAt(k+1)==pat.charAt(q);
        //     cnt++;

        //     if(t){
        //         k++;
        //         py[q] = k;
        //         q++;
        //     }
        //     else{
        //         if(k>0){
        //             k = py[k];
        //         }
        //         else{
        //             k=0;
        //             q++;
        //         }
        //     }
        // }

        //print py table 
        System.out.println("comparison count : "+cnt);
        System.out.print("table : ");
        for(int i = 1 ; i < m ; i++){
            System.out.print(py[i]+" ");
        }
        System.out.println("\n");

        return py;
    }
    public static void main(String[] args){
        String[] s = new String[]{"aaaaa","abcdc","aaaab","ababa","abbab","babab","aaaba"};
        
        for(String temp : s){
            int[] py = create_py_table(temp);
        }
    }
    
}