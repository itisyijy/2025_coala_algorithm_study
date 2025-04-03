import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException { //readLine() 때문에 추가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력되는 정수 개수
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //정수 개수
        PriorityQueue<Integer> AbsMinHeap = new PriorityQueue<>(
            Comparator.<Integer>comparingInt(x -> Math.abs(x)).thenComparingInt(x -> x));
        //comparingInt(x -> 기준), 절댓값 기준 정렬
        //thenComparingInt(x -> x), 절댓값이 같으면 원래 숫자 기준 정렬
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());//입력받은 정수
            if (x!=0){
                AbsMinHeap.add(x);
            } else{ //x==0
                Integer minAbs=AbsMinHeap.poll();//루트(최소값)제거하면서 반환
                /*참조형 Integer를 사용한 이유는 heap이 비어있을 때 null을 return하는데
                기본형 int는 null->컴파일 에러라서*/
                if (minAbs==null){//heap empty
                    sb.append("0\n");
                } else{
                    sb.append(minAbs).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}