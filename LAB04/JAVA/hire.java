import java.util.*;

public class hire {
    public static void main(String[] args) {
        ArrayList<Integer> employee = new ArrayList<>();

        for(int i = 0 ; i < 100 ; i++ ){
            employee.add(i);
        }

        Collections.shuffle(employee);

        int max = 0;
        int count = 0;

        for(int per : employee){
            if(per > max){
                max = per;
                count++;
            }
        }

        System.out.println(max + " " + count);
    }
}
