package dao;

public class SelectionSortStrategy implements ISortStrategy {
    @Override
    public void sort(Comparable[] data, int count) {
        for (int i = 0;i < count ;i++){
            int smallIndex = getSmallNumberIndex(data,i,count);
            Comparable temp = data[i];
            data[i] = data[smallIndex];
            data[smallIndex] = temp;
        }
    }
    public int getSmallNumberIndex(Comparable[] data, int index,int count){
        Comparable min = data[index];
        int minIndex = index;
        for(int i = index +1;i < count;i++){
            if(min.compareTo(data[i]) >0){
                min = data[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
}
