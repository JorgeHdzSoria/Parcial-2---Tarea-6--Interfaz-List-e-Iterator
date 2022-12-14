package uaslp.objetos.list.arraylist;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class Arraylist implements List {
    private String[] data;
    private int size;

    public Arraylist(){
        data = new  String[2];

    }

    public void addAtTail(String data){
        if(size == this.data.length){
            increaseArraySize();
        }

        this.data[size] = data;
        size++;
    }

    private void increaseArraySize(){
        String []newArray = new String[this.data.length * 2];

        System.arraycopy(data, 0, newArray, 0, data.length);

        data = newArray;
    }

    public void addAtFront(String data){
        if(size == this.data.length){
            increaseArraySize();
        }

        for(int i = size; i > 0; i--){
            this.data[i] = this.data[i -1];
        }
        this.data[0] = data;
        size++;
    }

    public boolean remove(int indexToRemove){
        if (indexToRemove < 0 || indexToRemove >= size){
            return false;
        }

        for(int i=indexToRemove; i < size-1; i++){
            this.data[i] = this.data[i+1];
        }
        size--;
        this.data[size] = null;

        return true;
    }

    public void removeAll(){
        for (int i = 0; i < size;i++){
            this.data[i] = null;
        }

        size = 0;
    }

    public boolean setAt(int index,String data){
        if (index < 0 || index >= size){
            return false;
        }

        this.data[index] = data;

        return true;
    }

    public String getAt(int index){
        if (index < 0 || index >= size){
            return null;
        }

        return this.data[index];
    }

    public void removeAllWithValue(String value){
        String []newArray = new String[data.length];
        int count =0;

        for(int i=0; i< size; i++){
            if( !data[i].equals(value)){
                newArray[count++]=data[i];
            }
        }
        data = newArray;
        size =count;
    }

    public int getSize(){
        return size;
    }


    public Iterator getIterator(){
        class ArrayListIterator implements Iterator {
            private final Arraylist arraylist;
            private int currentIndex = 0;

            public ArrayListIterator(Arraylist arraylist){
                this.arraylist = arraylist;
            }

            public boolean hasNext(){
                return currentIndex < arraylist.getSize();
            }

            public String next(){
                return arraylist.getAt(currentIndex++);
            }
        }
        return new ArrayListIterator(this);
    }

}
