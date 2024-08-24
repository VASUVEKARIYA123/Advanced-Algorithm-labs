import java.util.*;

public class kmp1
{
    // using nested loop - outer for and inner while loop

    static int comparison_cnt = 0;
    
    public static int[] create_py_table(String pat){
        comparison_cnt=0;

        int m = pat.length();
        int[] py = new int[m];
        System.out.println("pat length : "+(m-1));

        py[1] = 0;
        int k = 0;
        
        for(int q = 2 ; q < m ; q++){
            boolean t = pat.charAt(k+1)==pat.charAt(q);
            comparison_cnt++;
            while(k>0 && !t){
                k = py[k];
                t = pat.charAt(k+1)==pat.charAt(q);
                comparison_cnt++;
            }

            if(t){
                k++;
            }
            py[q] = k;
        }
            
        //print py table
        System.out.println("comparison count in preprocessing : "+comparison_cnt);
        System.out.print("py table : ");
        for(int i = 1 ; i < m ; i++){
            System.out.print(py[i]+" ");
        }
        System.out.println("\n");

        return py;
    }
    
    public static void kmpalgo(String text, String pat){

        int n = text.length();
        pat = " "+ pat;
        int m = pat.length()-1;

        // pre-processing 
        int[] py = create_py_table(pat);

        comparison_cnt = 0;
        int q = 0;

        // matching 
        for(int i = 0 ; i < n ; i++){
            boolean t = pat.charAt(q+1)==text.charAt(i);
            comparison_cnt++;
            while(q>0 && !t){
                q = py[q];
                t = pat.charAt(q+1)==text.charAt(i);
                comparison_cnt++;
            }
            if(t){
                q++;
            }
            if(q == m){
                System.out.println("match "+(i-m+1));
                q = py[q];
            }
        }
        System.out.println("comparison count in matching : "+comparison_cnt);
    }
    
    public static void main(String[] args){

        // String text = "aaaaaaaa";
        // String pat = "aaaa";

        String text = "acacacacac";
        String pat = "acac";
        
        kmpalgo(text,pat);
    }
    
}