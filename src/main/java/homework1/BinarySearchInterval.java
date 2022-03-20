package homework1;

public class BinarySearchInterval {
    private static void search(int[] arr, int val) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == val) {
                System.out.println(mid);
                return;
            }
            if (val > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (mid == 0 && val < arr[mid]) {
            System.out.println(-1 + " and " + 0);
        } else if (mid == n - 1 && val > arr[mid]) {
            System.out.println(n - 1 + " and " + n);
        } else if (val > arr[mid]) {
            System.out.println(mid + " and " + (mid + 1));
        } else {
            System.out.println(mid - 1 + " and " + mid);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-5, -2, 19, 30, 70};
        search(arr, 50);
    }
}
