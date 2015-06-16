/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.Game;

/**
 *
 * @author Alec
 */
public class Player_Info {
 
    // Data members
    private String username;
    private String password;
    private String email;
    private int rank;
    private int wins;
    private int losses;
    private int id;
    
    
    
     /**
     * 
     * @param id
     */
    public void set_id(int id){
        
        this.id = id;
        
    }
    
    /**
     * 
     * @return 
     */
    public int get_id(){
        
        return id;
        
    }
    
    
    /**
     * 
     * @param username 
     */
    public void set_username(String username){
        
        this.username = username;
        
    }
    
    /**
     * 
     * @return 
     */
    public String get_username(){
        
        return username;
        
    }
    
    /**
     * 
     * @param password 
     */
    public void set_password(String password){
        
        this.password = password;
        
    }
    
    /**
     * 
     * @return 
     */
    public String get_password(){
        
        return password;
        
    }
    
    /**
     * 
     * @param email 
     */
    public void set_email(String email){
        
        this.email = email;
        
    }
    
    /**
     * 
     * @return 
     */
    public String get_email(){
        
        return email;
        
    }
    
    /**
     * 
     * @param wins 
     */
    public void set_wins(int wins){
        
        this.wins = wins;
        
    }
    
    /**
     * 
     * @return 
     */
    public int get_wins(){
        
        return wins;
        
    }
    
    /**
     * 
     * @param losses 
     */
    public void set_losses(int losses){
        
        this.losses = losses;
        
    }
    
    /**
     * 
     * @return 
     */
    public int get_losses(){
        
        return losses;
    
    }
    
    /**
     * 
     * @param rank 
     */
    public void set_rank(int rank){
        
        this.rank = rank;
        
    }
    
    /**
     * 
     * @return 
     */
    public int get_rank(){
        
        return rank;
        
    }

}
