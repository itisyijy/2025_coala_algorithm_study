import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int caseNum=Integer.parseInt(br.readLine());// case 개수
        

        for(int i=0; i<caseNum; i++){

            int printOrder=0; //몇번째로 출력됐는지 카운트 & case별 카운트 초기화

            String[] docInfo=br.readLine().split(" ");
            int docCount= Integer.parseInt(docInfo[0]); //문서 개수
            int targetIndex= Integer.parseInt(docInfo[1]); //우리가 찾을 문서의 위치

            Queue<int[]> queue= new LinkedList<>(); //중요도 queue

            String[] priorityInput=br.readLine().split(" ");
            for(int j = 0; j < docCount; j++){
                int priority = Integer.parseInt(priorityInput[j]);
                queue.offer(new int[]{j,priority});
                //큐에 (index,중요도) int리스트 넣음
            }
            
            while(true){
                int highestPriority=1;
                for(int[] doc : queue){//highestPriority 찾기
                    highestPriority = Math.max(highestPriority, doc[1]);
                }

                int[] currentDoc =queue.poll(); //맨앞 요소 삭제
                if(currentDoc[1]==highestPriority){//맨앞이 중요도가 제일 높을때
                    printOrder++;
                    if(currentDoc[0]==targetIndex) {//우리가 찾는 문서였을 때
                        System.out.println(printOrder);
                        break;
                    }
                }else queue.offer(currentDoc); //중요도가 제일 높지않을때 다시 뒤로

            }

        }

    }
}