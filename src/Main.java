import java.util.InputMismatchException;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        int[] IDs = new int[10];
        int[] scores = new int[10];

        Scanner scanner = new Scanner(System.in);
        System.out.println("10명 학생의 학번과 점수를 입력하세요.");

        for(int i = 0; i<10; i++){
            System.out.print((i + 1) + " : ");
            IDs[i] = scanner.nextInt();
            scores[i] = scanner.nextInt();
        }

        while(true){ // 1 2 3 중 입력받기
            System.out.print("학번으로 검색은 1, 점수로 검색은 2, 끝내려면 3을 입력하세요. : ");
            int num = scanner.nextInt();

            if(num == 1){
                int inputID;
                while(true){
                    try{
                        System.out.print("학번 : ");
                        inputID = scanner.nextInt();
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("경고! 정수를 입력하세요.");
                        scanner.nextLine();
                    }
                }
                boolean search = false;

                for(int i = 0; i < 10; i++){
                    if(IDs[i] == inputID){
                        System.out.println(scores[i] + " 점 ");
                        search = true;
                        break;
                    }
                }
                if(!search){
                    System.out.println("학번 " + inputID + " 의 학생은 없습니다.");
                }
            }

            else if(num == 2){
                int inputScore;
                while(true){
                    try{
                        System.out.print("점수: ");
                        inputScore = scanner.nextInt();
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("경고! 정수를 입력하세요.");
                        scanner.nextLine();
                    }
                }
                boolean search = false;

                for(int i = 0; i < 10; i++){ // 점수가 10인 학생은 1 2 3 식이 아니라 문장 n개가 출력됨
                    if(scores[i] == inputScore){
                        System.out.println("점수가 " + inputScore + "인 학생은 "+
                                IDs[i] + " 입니다.");
                        search = true;
                    }
                }
                if(!search){
                    System.out.println("점수가 " + inputScore + "인 학생은 없습니다.");
                }
            }
            else if(num == 3){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else{
                System.out.println("1 2 3 중에 입력하세요.");
            }
        }
        scanner.close();
    }
}