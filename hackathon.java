import java.util.*;
class Hack3{
    static int board[][];
    static int curri=-1;
    static int currj=-1;
    static int score=0;
    /**
     * @param args
     */
    public static void main(String args[]){
        Scanner pk=new Scanner(System.in);
        // System.out.println("Enter the board of 4*4");
        while(true){
        board=new int[4][4];
        score=0;
        boolean []pres=new boolean[18];
        Arrays.fill(pres,false);
        Random r=new Random();
        int arr[]=new int[16];
        int a=0;
        int c=0;
        boolean again=false;
        while(c<15){
             a=r.nextInt(1,16);
            if(pres[a]==true){
                continue;
            }
            else{
                pres[a]=true;
                arr[c++]=a;
            }
        }
        // System.out.println(Arrays.toString(arr));
        c=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                 board[i][j]=arr[c++];
            }
        }
        board[3][3]=-1;
        curri=3;
        currj=3;
        // System.out.println("priting board");
        print();
        boolean intrest=true;
        while(!check()){
            // System.out.println("Choose one option:\n\t\t1)UP\n\t\t2)DOWN\n\t\t3)LEFT\n\t\t4)RIGHT\n\t\t5)EXIT THE GAME\\t6)NEW GAME");
            int move=pk.nextInt();
            // System.out.println("your move is"+move);
            if(move==8){
                move=1;
            }
            else if(move==4){
                move=3;
            }
            else if(move==6){
                move=4;
            }
            score++;
            switch(move){
                case 1:moveup();
                break;
                case 2:movedown();
                break;
                case 3:moveleft();
                break;
                case 4:moveright();
                break;
                case 5:intrest=false;
                break;
                case 6:again=true;
                break;
            }
            if(intrest==false){
                break;
            }
            if(again==true){
                break;
            }
            print();
        }
        System.out.println();
        System.out.println();
        if(intrest==false){

        }
        else{
          System.out.println("\t\t\tCONGRATULATIONS!!,Your score is "+score);
        }
        System.out.println("Do you want to play again:y/n");
        char nex=pk.next().charAt(0);
        if(nex=='y'){
            again=true;
        }
        else{
            again=false;
        }
        if(again==false){
            break;
        }
     }
     pk.close();
    }

    public static void print(){
         for(int i=0;i<4;i++){
            System.out.println("---------------------------------");
             for(int j=0;j<4;j++){
                  if(j==3){
                    if(board[i][j]<=9&&board[i][j]!=-1){
                        System.out.print("| "+board[i][j]+"     |");
                    }
                    else{
                     System.out.print("| "+board[i][j]+"    |");
                    }
                  }
                  else{
                    if(board[i][j]<=9 &&board[i][j]!=-1){
                        System.out.print("| "+board[i][j]+"     ");
                    }
                    else{
                     System.out.print("| "+board[i][j]+"    ");
                    }
                  }
             }
              System.out.println();
            }
            System.out.println("---------------------------------");
    }
    public static void moveup(){
        if(curri==3){
            System.out.println("INVALID MOVE CHOOSE OTHER OPTION");
            return;
        }
        int temp=board[curri+1][currj];
        board[curri+1][currj]=-1;
        board[curri][currj]=temp;
        curri=curri+1;
        return;
    }
    public static void movedown(){
        if(curri==0){
            System.out.println("INVALID MOVE CHOOSE OTHER OPTION");
            return;
        }
        int temp=board[curri-1][currj];
        board[curri][currj]=temp;
        board[curri-1][currj]=-1;
        curri=curri-1;
        return;
    }
    public static void moveright(){
        if(currj==0){
            System.out.println("INVALID MOVE CHOOSE OTHER OPTION");
            return;
        }
        int temp=board[curri][currj-1];
        board[curri][currj]=temp;
        board[curri][currj-1]=-1;
        currj=currj-1;
        return;
    }
    public static void moveleft(){
        if(currj==3){
            System.out.println("INVALID MOVE CHOOSE OTHER OPTION");
            return;
        }
        int temp=board[curri][currj+1];
        board[curri][currj]=temp;
        board[curri][currj+1]=-1;
        currj=currj+1;
        return;
    }
    public static boolean check(){
        int currnum=1;
         for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i==3&&j==3){
                    return true;
                }
                   if(board[i][j]==currnum){
                        currnum++;
                   }
                   else{
                    return false;
                   }
            }
         }
         return true;
    }
}