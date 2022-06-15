import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Board extends JFrame {
    private final JButton[][] squares = new JButton[Constant.BOARD_WIDTH][Constant.BOARD_HEIGHT];
    private int[] freePlaces;
    private int[] redOrYellow;
    private int playerCounter;
    private boolean isGameEnded;
    private final String nameRedOrYellow[] =new String[]{"YELLOW" , "RED"};

    public Board() {
        this.isGameEnded = false;
        this.playerCounter = 0;
        this.redOrYellow = new int[]{Constant.RED,Constant.YELLOW};

        this.freePlaces = new int[Constant.BOARD_WIDTH];
        for (int i = 0; i < this.freePlaces.length; i++) {
            this.freePlaces[i]=Constant.BOARD_HEIGHT-1;
        }

        for(int i = 0; i < Constant.BOARD_HEIGHT; ++i) {
            this.squares[i] = new JButton[Constant.BOARD_WIDTH];

            for(int j = 0; j < Constant.BOARD_WIDTH; ++j) {
                JButton square = new JButton();
                if (i == 0) {
                    square.setText(String.valueOf(j + 1));
                    square.setBackground(Color.WHITE);
                    square.setFont(new Font(Constant.FONT_NAME, 1, Constant.FONT_SIZE));
                    int colon = j;
                    square.addActionListener((e) -> {
                        if (!isGameEnded){
                            if (this.freePlaces[colon]>0){
                                placeSquare(colon+1,this.freePlaces[colon],this.redOrYellow[playerCounter%2]);
                                this.playerCounter ++;
                                this.freePlaces[colon]--;
                            }
                            if (winnerCheck()){
                                System.out.println("Game Over");
                                this.isGameEnded = true;
                            }
                        }
                    });
                } else {
                    square.setEnabled(false);
                }

                this.squares[i][j] = square;
                this.add(square);
            }
        }

        this.setLocationRelativeTo((Component)null);
        GridLayout gridLayout = new GridLayout(Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT);
        this.setLayout(gridLayout);
        this.setSize(Constant.BOARD_HEIGHT * Constant.SQUARE_SIZE, Constant.BOARD_HEIGHT * Constant.SQUARE_SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void placeSquare(int x, int y, int player) {
        this.squares[y][x - 1].setBackground(player == 1 ? Color.RED : Color.YELLOW);
    }

    public int getPlayerInSquare(int x, int y) {
        byte player = -1;

        try {
            Color backgroundColor = this.squares[ x][y ].getBackground();
            if (backgroundColor.equals(Color.RED)) {
                player = 0;
            } else if (backgroundColor.equals(Color.YELLOW)) {
                player = 1;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return player;
    }

    private boolean winnerCheck (){
        return (checkRows() || checkColons());
    }

    private boolean checkRows (){
        boolean isWin = false;
        for (int i = 1; i < Constant.BOARD_WIDTH && !isWin; i++) {
            int counter = 0;
            for (int j = 0; j < Constant.BOARD_HEIGHT && (counter<4); j++) {
                if (getPlayerInSquare(i,j ) == this.redOrYellow[(this.playerCounter )%2]){
                    counter ++;
                } else counter = 0;
            }
            isWin = (counter==4);
            if (isWin){
                System.out.println("Winner is -> " + this.nameRedOrYellow[(this.playerCounter)%2]);
            }
        }
        return isWin;
    }

    private boolean checkColons (){
        boolean isWin = false;
        for (int i = 0; i < Constant.BOARD_HEIGHT && !isWin; i++) {
            int counter = 0;
            for (int j = 1; j < Constant.BOARD_WIDTH && (counter<4); j++) {
                if (getPlayerInSquare(j,i ) == this.redOrYellow[(this.playerCounter)%2]){
                    counter ++;
                }else counter = 0;
            }
            isWin = (counter==4);
            if (isWin){
                System.out.println("Winner is -> " + this.nameRedOrYellow[(this.playerCounter)%2]);
            }
        }
        return isWin;
    }

//    private boolean slantCheck (){
//
//    }
}
