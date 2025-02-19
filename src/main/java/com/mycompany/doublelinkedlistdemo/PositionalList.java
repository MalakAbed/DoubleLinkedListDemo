/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.doublelinkedlistdemo;

/**
 *
 * @author malakabed
 */
public interface PositionalList <E> {
    public int size();
    public boolean isEmpty();
    
    public Position<E> first();
    public Position<E> last();
    public Position<E> before(Position<E> p) throws IllegalArgumentException;
    public Position<E> after(Position<E> p) throws IllegalArgumentException;
    public Position<E> addFirst(E e);
    public Position<E> addLast(E e);
    public Position<E> addBefore(Position<E> p ,E e);
    public Position<E> addAfter(Position<E> p ,E e);
    E set(Position<E> p, E e) throws IllegalArgumentException;
    E remove(Position<E> p) throws IllegalArgumentException;
    
    
}
