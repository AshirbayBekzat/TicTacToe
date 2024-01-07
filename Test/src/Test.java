import java.util.Scanner;

class Test{
    static Scanner sc = new Scanner(System.in);
    static final int MAP_SIZE = 3;
    static  final char EMPTY_FIELD = '*';
    static final char X_FIELD = 'X';
    static final char O_FIELD = 'O';
    static  char[][] map;

    public static void main(String[] args) {
        init();
        print();
        while (true){
            humanTurn();
            print();
            if(isWon(X_FIELD)){
                System.out.println("Человек выйграл");
                break;
            }
            if(isDraft()){
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            print();
            if(isWon(O_FIELD)){
                System.out.println("Робот выйграл");
                break;
            }
            if (isDraft()){
                System.out.println("Ничья");
                break;
            }
        }
    }
    public static boolean isWon(char playerField){
        if(map[0][0] == playerField && map[0][1] == playerField && map[0][2] == playerField) return true;
        if(map[1][0] == playerField && map[1][1] == playerField && map[1][2] == playerField) return true;
        if(map[2][0] == playerField && map[2][1] == playerField && map[2][2] == playerField) return true;

        if(map[0][0] == playerField && map[1][0] == playerField && map[2][0] == playerField) return true;
        if(map[0][1] == playerField && map[1][1] == playerField && map[2][1] == playerField) return true;
        if(map[0][2] == playerField && map[1][2] == playerField && map[2][2] == playerField) return true;

        if(map[0][0] == playerField && map[1][1] == playerField && map[2][2] == playerField) return true;
        if(map[0][2] == playerField && map[1][1] == playerField && map[2][0] == playerField) return true;

        return false;
    }
    public static boolean isDraft(){
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if(map[i][j] == EMPTY_FIELD){
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isValid(int x, int y){
        if(x<0 || y<0 || x>=MAP_SIZE || y>=MAP_SIZE){
            return false;
        }
        if(map[x][y] != EMPTY_FIELD){
            return false;
        }
        return true;
    }

    public static void aiTurn(){
        int x,y;
        do {
            System.out.println("Ход робота. ");
            x = (int)(Math.random() * MAP_SIZE);
            y = (int)(Math.random() * MAP_SIZE);
        }while (!isValid(x, y));
        map[x][y]=O_FIELD;
    }

    public static void humanTurn(){
        int x,y;
        do {
            System.out.print("Ход игрока. Введите кординаты X,Y: ");
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
        }while (!isValid(x, y));
        map[x][y]=X_FIELD;
    }

   public static void print(){
       for (int i = 0; i <= MAP_SIZE; i++) {
           System.out.print(i+" ");
       }
       System.out.println();
       for (int i = 0; i < MAP_SIZE; i++) {
           System.out.print((i+1)+" ");
           for (int j = 0; j < MAP_SIZE; j++) {
               System.out.print(map[i][j]+" ");
           }
           System.out.println();
       }
       System.out.println();
    }


   public static void init(){
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE ; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j]=EMPTY_FIELD;
            }
        }
    }
}