/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author hquiroga
 */
public class DAO {
    //Simula la base de datos
    private ArrayList<Integer> db;

    public DAO() {
        this.db = new ArrayList<>();
    }
    
    public ArrayList<Integer> getDb() {
        return db;
    }

    public void setDb(ArrayList<Integer> db) {
        this.db = db;
    }
    
    public void addDb(Integer data) {
        this.db.add(data);
    }
    
    public boolean modificar(int value, int pos){
      this.db.set(pos, value);
      return true;
    }
}
