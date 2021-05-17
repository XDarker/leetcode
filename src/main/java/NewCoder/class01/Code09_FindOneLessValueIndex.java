package NewCoder.class01;

public class Code09_FindOneLessValueIndex {

    /**
     * 求一个数组里的局部最小值的索引
     * @param arr
     * @return
     */
    public static int getLessIndex(int[] arr) {
        //三种情况可以得出数组局部最小元素


        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }

        //1. 最左边：如果数组 arr[0] < arr[1]， 那么arr[0]是局部最小元素
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        //2. 最右边：如果数组 arr[arr.length - 1] < arr[arr.length - 2]， 那么arr[arr.length - 1]是局部最小元素
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        //3. arr[k-1] > arr[k] < arr[k+1]，采用二分法缩小搜索范围
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 4, 6, 7, 8};
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }

}

