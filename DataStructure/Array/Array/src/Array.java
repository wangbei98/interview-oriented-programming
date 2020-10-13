public class Array<E> {
    private E[]data;
    private int size;

    /**
     *
     * @param capacity
     */
    public Array(int capacity) {
        data =(E[]) new Object[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void addLast(E e){
//        if(size==data.length){
//            // 满了
//            throw new IllegalArgumentException("AddLast failed.Array is full!");
//        }
//        data[size]=e;
//        size++;
        add(size,e);
    }
    public void addFirst(E e){
        add(0,e);
    }
    public void add(int index,E e){
        if(index < 0 || index > size){
            // index 非法
            throw new IllegalArgumentException("AddLast failed. Required size >= 0 and <= size!");
        }
        if(size == data.length){
            // 满了
//            throw new IllegalArgumentException("AddLast failed.Array is full!");
            resize(2*data.length);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append("[");
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
    E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get Failed , index illegal");
        }
        return data[index];
    }
    void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get Failed , index illegal");
        }
        data[index] = e;
    }
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if (data[i].equals(e))
                return true;
        }
        return false;
    }
    public int find(E e){
        for(int i=0;i<size;i++){
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get Failed , index illegal");
        }
        E ret = data[index];
        for (int i=index;i<size-1;i++){
            data[i] = data[i+1];
        }
        size--;
        data[size]=null;// loitering objects
        if (size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }
    public boolean removeElement(E e){
        int index = find(e);
        if (index != 1){
            remove(index);
            return true;
        }else{
            return  false;
        }
    }
    private void resize(int newCapacity){
        E[] newData =(E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
