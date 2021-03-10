public class MinProd {

    static int minproduct(int[] a, int[] b, int n, int k) {
        int diff = 0, res = 0, temp = 0;
        for(int i = 0; i < n; i++) {
            int prod = a[i] * b[i];
            res += prod;

            if(prod < 0 && b[i] < 0) {
                temp = (a[i] + 2*k) * b[i];
            } else if(prod < 0 && a[i] < 0) {
                temp = (a[i] - 2*k) * b[i];
            } else if(prod > 0 && a[i] > 0) {
                temp = (a[i] - 2*k) * b[i];
            } else if(prod > 0 && a[i] < 0) {
                temp = (a[i] + 2*k) * b[i];
            }

            int d = Math.abs(prod - temp);
            if(d > diff)
                diff = d;
        }
        return res - diff;
    }

    public static void main(String[] args) {
        int a[] = { 2, 3, 4, 5, 4 };
        int b[] = { 3, 4, 2, 3, 2 };
        int n = 5, k = 3;
        System.out.println(minproduct(a, b, n, k));
    }
}
