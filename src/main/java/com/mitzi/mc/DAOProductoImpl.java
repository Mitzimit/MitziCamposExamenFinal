/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mitzi.mc;


import com.mitzi.mc.DAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author Mitzimit
 */
public class DAOProductoImpl extends DAO{
    public void agregarProducto(Producto c) {
    begin();
 
    
    getSession().save(c);
    commit();
    close();
    
    }

      
    public ArrayList<Producto> buscarTodosProducto() {
        begin();
     
        Criteria c=getSession().createCriteria(Producto.class);
        ArrayList<Producto> producto = (ArrayList<Producto>)c.list();
        commit();
        close();
         
return producto; 
        
      
    }
    
 public void borrarProducto(Producto p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
       
  public Producto buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Producto where id = :id");
        q.setInteger("id",id);
        Producto p = (Producto)q.uniqueResult();
        commit();
        close();
return p;  
   
  }  
   public Producto buscarPorLogin(String nombre,String password){
      begin();
     Query q = getSession().createQuery("from Producto where usuario = :id");
        q.setString("nombre",nombre);
        Producto p = (Producto)q.uniqueResult();
        commit();
        close();
return p;  
   
  }  
}
