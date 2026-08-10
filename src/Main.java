//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Buggy binary search implementation
    public static int binarySearch(int[] arr, int b) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int a = i + (j - i) / 2;
            if (arr[a] == b) {
                return a;
            } else if (arr[a] < b) {
                i = a + 1;
            } else {
                j = a - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hi");
        if (args.length < 2) {
            System.out.println("Usage: java Main <array elements> <target value>");
            System.out.println("Example: java Main 1 2 3 4 5 5");
            return;
        }
        int[] arr = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        int target = Integer.parseInt(args[args.length - 1]);
        int result = binarySearch(arr, target);
        System.out.println("Result index: " + result); // Should print the correct index or -1 if not found
    }
}