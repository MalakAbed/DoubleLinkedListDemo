/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublelinkedlistdemo;

/**
 *
 * @author malakabed
 */
public class LinkedPositionalList <E> implements PositionalList<E>{
    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() throws IllegalArgumentException{
            if (next == null)
                throw new IllegalArgumentException("No element");
            return element;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setElement(E element){
            this.element = element;
        }
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
    }
    
    private Node<E> header;
    private Node<E> tailer;
    private int size = 0;
    public LinkedPositionalList(){
         header = new Node<>(null, null, null);
         tailer = new Node<>(null, header, null);
         header.setNext(tailer);      
    }
    private Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)) //validate that the casting operation(line 54) is a safe casting
            throw new IllegalArgumentException("invalid position");
        Node<E> node = (Node<E>) p; 
        if (node.getNext() == null)
            throw new IllegalArgumentException("position is no longer in the list");
        return node;
    }
    private Position<E> position(Node<E> node){
        if (node == header || node == tailer)
            return null;
        return node; // reference to node --> position
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public Position<E> first(){
        return position(header.getNext());
    }
    public Position<E> last(){
        return position(tailer.getPrev());
    }
    public Position<E> before(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return position(node.getPrev());
    }
    public Position<E> after(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return position(node.getNext());
    }
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ){
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }
    public Position<E> addFirst(E e){
        return addBetween(e, header, header.getNext());
    }
    public Position<E> addLast(E e){
        return addBetween(e, tailer.getPrev(), tailer);
    }
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }
    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
        
    }
}
