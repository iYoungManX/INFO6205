public class BinarySearch {

    // Method to count occurrences in a sorted array with duplicates
    public static int countOccurrences(int[] arr, int target) {
        // Find the first occurrence of target
        int first = binarySearchLeft(arr, target);
        if (first == -1) {
            return 0;
        }
        // Find the last occurrence of target
        int last = binarySearchRight(arr, target);
        return last - first + 1;
    }

    private static int binarySearchLeft(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int binarySearchRight(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Method to find the target in a rotated sorted array
    public static int findRotated(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15};
        System.out.println("Target 4 = " + countOccurrences(arr1, 4) + " Occurrences");
        System.out.println("Target 2 = " + countOccurrences(arr1, 2) + " Occurrences");
        System.out.println("Target 5 = " + countOccurrences(arr1, 5) + " Occurrences");

        int[] arr2 = {6, 7, 8, 2, 3, 4, 5};
        System.out.println("Target 8 = " + findRotated(arr2, 8));
        System.out.println("Target 9 = " + findRotated(arr2, 9));
    }
}
