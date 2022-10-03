class Solution {
    // 유클리드 호제법
    public int solution(int[] arr) {
        int ans = arr[0];
        for(int i=1; i<arr.length; i++) {
            int gcd = gcd(ans, arr[i]); // 최대공약수
            ans = ans * arr[i] / gcd; // 최대공배수
        }
        
        return ans;
    }
    
    static int gcd(int n1, int n2) {
        int b = n1<n2 ? n2:n1;
        int s = n1<n2 ? n1:n2;
        
        while(b%s != 0) {
            int r = b%s;
            b = s;
            s = r;
        }
        
        return s;
    }
}