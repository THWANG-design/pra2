import java.util.ArrayList;

class mergeSort {
    public int reversePairs(int[] nums) {

        int[] result = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<Integer>();
        mergeSort(nums, 0, nums.length -1, result, list);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i);
        }
        return count;
    }

    public void mergeSort(int[]arr, int start, int end, int[]result, ArrayList<Integer> list){
        if(start == end) return;
        int middle = (start + end) / 2;
        mergeSort(arr, start, middle, result, list);
        mergeSort(arr, middle + 1, end, result, list);
        list.add(merge(arr, start, end, result));


    }

    public int merge(int []arr , int start , int end, int[] result){
        int middle = (start + end) / 2;
        int count = 0;
        int end1 = middle;
        int index1 = start;
        int index2 = middle + 1;
        int resultindex = start;
        while(index1 <= middle && index2 <= end){
            if(arr[index1] <= arr[index2])
                result[resultindex++] = arr[index1++];
            else{
                result[resultindex++] = arr[index2++];
                if(index1 == middle)
                    count++;
                else
                    count+= (middle - index1 + 1);
            }
        }
        while(index1 <= middle){
            result[resultindex++] = arr[index1++];

        }
        while(index2 <= end){
            result[resultindex++] = arr[index2++];
        }

        while(start <= end)
            arr[start] = result[start++];
        return count;

    }
}