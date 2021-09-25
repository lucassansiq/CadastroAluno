/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Lucas
 */
public interface Persistencia<T> {
    
    public int create (T obj);
    public T findByCodigo(int id);
    public void delete(int id);
    public void update(T obj);
}
