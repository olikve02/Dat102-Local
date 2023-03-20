package Oblig1.kjedet;

public class LinearNode <T>{
    T element;
    public LinearNode<T> neste;

    LinearNode(){
        element = null;
        neste = null;
    }

    public LinearNode(T element){
        this.element = element;
        neste = null;
    }

    public LinearNode<T> getNeste(){
        return neste;
    }

    public void setNeste(LinearNode<T> neste){
        this.neste = neste;
    }

    public T getElement(){
        return element;
    }

    public void setElement(T element){
        this.element = element;
    }
}
