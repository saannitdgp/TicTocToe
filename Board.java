package tictactoe;

// 3 for user X
// 5 for computer O
// 2 for empty

public class Board {
    int[][] B;

    public void intiBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) B[i][j] = 2;
        }
    }

    public Board() {
        B = new int[3][3];
        intiBoard();
    }

    public int getValue(int i, int j) {
        return B[i][j];
    }

    public void setValue(int i, int j, int x) {
        B[i][j] = x;
    }

    public int possibleWin(int player) {
        if (player == 1) {
            for (int i = 0; i < 3; i++) {
                if (B[i][0] * B[i][1] * B[i][2] == 18) {
                    if (B[i][0] == 2) return 3 * i + 1;
                    if (B[i][1] == 2) return 3 * i + 2;
                    else return 3 * i + 3;

                }
            }
            for (int i = 0; i < 3; i++) {
                if (B[0][i] * B[1][i] * B[2][i] == 18) {
                    if (B[0][i] == 2) return  (i+1);
                    else if (B[1][i] == 2) return 4 + i;
                    else return 7 + i;
                }
            }
            if (B[0][0] * B[1][1] * B[2][2] == 18) {
                if (B[0][0] == 2) return 1;
                else if (B[1][1] == 2) return 5;
                else return 9;
            }
            if (B[0][2] * B[1][1] * B[2][0] == 18) {
                if (B[0][2] == 2) return 3;
                else if (B[1][1] == 2) return 5;
                else return 7;
            }
        }
        else {
            for (int i = 0; i < 3; i++) {
                if (B[i][0] * B[i][1] * B[i][2] == 50) {
                    if (B[i][0] == 2) return 3 * i + 1;
                    if (B[i][1] == 2) return 3 * i + 2;
                    else return 3 * i + 3;

                }
            }
            for (int i = 0; i < 3; i++) {
                if (B[0][i] * B[1][i] * B[2][i] == 50) {
                    if (B[0][i] == 2) return (i+1);
                    else if (B[1][i] == 2) return (4+i);
                    else return 7+ i;
                }
            }
            if (B[0][0] * B[1][1] * B[2][2] == 50) {
                if (B[0][0] == 2) return 1;
                else if (B[1][1] == 2) return 5;
                else return 9;
            }
            if (B[0][2] * B[1][1] * B[2][0] == 50) {
                if (B[0][2] == 2) return 3;
                else if (B[1][1] == 2) return 5;
                else return 7;
            }
        }
        return (0);
    }

    public boolean checkWin(int player) {
        if (player == 1) {
            for (int i = 0; i < 3; i++) {
                if (B[i][0] * B[i][1] * B[i][2] == 27) return true;
            }
            for (int i = 0; i < 3; i++) {
                if (B[0][i] * B[1][i] * B[2][i] == 27) return true;
            }
            if (B[0][0] * B[1][1] * B[2][2] == 27) return true;
            if (B[2][0] * B[1][1] * B[0][2] == 27) return true;
        } else {
            for (int i = 0; i < 3; i++) {
                if (B[i][0] * B[i][1] * B[i][2] == 125) return true;
            }
            for (int i = 0; i < 3; i++) {
                if (B[0][i] * B[1][i] * B[2][i] == 125) return true;
            }
            if (B[0][0] * B[1][1] * B[2][2] == 125) return true;
            if (B[2][0] * B[1][1] * B[0][2] == 125) return true;
        }
        return (false);

    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) if (B[i][j] == 2) return (false);
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) System.out.print(B[i][j]);
            System.out.println("");
        }
    }

    public int randomBlankButton() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (B[i][j] == 2) count++;
            }
        }
        int r = 1 + (int) (Math.random() * count);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (B[i][j] == 2) {
                    r--;
                    if (r == 0) return (3 * i + j+1);
                }
            }
        }
        return 0;

    }

}
