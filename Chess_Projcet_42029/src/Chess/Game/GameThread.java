/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.Game;

/**
 *
 * @author rcc
 */
public class GameThread extends Thread {
     private PlayInterface game;
     private int winner = -1;
     
     GameThread(PlayInterface game) {
         this.game = game;
     }
     
    @Override
    public void run() {
        super.run();
        while(!this.isInterrupted()) {
            try {
                changeText();
                if(winner == 1 || winner == 2){
                    Thread.sleep(2000);
                    System.exit(0);
                }
            } catch(Exception e) {
                //System.out.println(e.getStackTrace());
            }
        }
    }
    
    public void changeText() {
         if(winner == 1) {
            game.setLabelText("Player 1 Wins");
        } else if (winner == 2) {
            game.setLabelText("Player 2 Wins");
        } 
    }
    public void setWinner(int i) {
        winner = i;
    }
}