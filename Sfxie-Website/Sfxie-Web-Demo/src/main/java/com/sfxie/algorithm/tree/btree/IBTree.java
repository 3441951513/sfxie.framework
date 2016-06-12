package com.sfxie.algorithm.tree.btree;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Interface for a b tree
 * 
 * @author 
 * @version .
 */
@SuppressWarnings("rawtypes")
public interface IBTree extends Serializable
{
    /**
     * Method that will add an node into the b tree
     * 
     * @param o node to add
     */
    public void add(Comparable o);
    
    /**
     * Method that will remove an node from the b tree
     * 
     * @param o node to remove
     * @return object
     */
    public Object remove(Comparable o);
    
    /**
     * Method that will find the element belongs to the specified node
     * 
     * @param o node to find
     * @return object
     */
    public Object find(Comparable o);
    
    /**
     * Method that will return an iterator of the b tree
     * 
     * @return the iterator of the b tree
     */
    public Iterator iterator();
    
    /**
     * Method that will clear the b tree
     */
    public void clear();
    
    /**
     * Method that will check to see if the b tree is null
     * 
     * @return true if the b tree is null, false if it is not
     */
    public boolean isEmpty();
}

