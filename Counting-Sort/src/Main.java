import java.util.Arrays;

class Main {
    public static void main(String[] args) {
//        int[] A = new int[]{6, 0, 2, 0, 1, 3, 4, 6, 3, 2};
        int[] A = new int[]{356, 198, 327, 226, 516};
        int[] B = new int[A.length];
        int k = Arrays.stream(A).max().getAsInt();
        countingSort(A, B, k);
        System.out.println(Arrays.toString(B));
    }

    public static void countingSort(int[] A, int[] B, int k){
        int maxNumberFiguresAmount = (int) Math.log10(k) + 1;
        int[] D = new int[A.length];
        int[] C = new int[k + 1];
        for (int i = 1; i <= maxNumberFiguresAmount; i++) {
            for (int j = 0; j < A.length; j++) {
                D[j] = (int) (A[j] % Math.pow(10, i) / Math.pow(10, i - 1));
            }
            for (int j = 0; j <= k; j++) {
                C[j] = 0;
            }
            for (int j = 0; j < D.length; j++) {
                C[D[j]]++;
            }
            for (int j = 1; j <= k; j++) {
                C[j] = C[j] + C[j - 1];
            }
            for (int j = D.length - 1; j >= 0; j--) {
                B[C[D[j]] - 1] = A[j];
                C[D[j]]--;
            }
            for (int j = 0; j < B.length; j++) {
                A[j] = B[j];
            }

        }
//        int[] C = new int[k + 1];
//        for (int i = 0; i <= k; i++) {
//            C[i] = 0;
//        }
//        for (int i = 0; i < A.length; i++) {
//            C[A[i]]++;
//        }
//        for (int i = 1; i <= k; i++) {
//            C[i] = C[i] + C[i - 1];
//        }
//        for (int i = A.length - 1; i >= 0; i--) {
//            B[C[A[i]] - 1] = A[i];
//            C[A[i]]--;
//        }
    }
}