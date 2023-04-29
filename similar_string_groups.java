class Solution {
    private int[] uf;
    private int[] rank;
    public int numSimilarGroups(String[] A) {
        uf = new int[A.length];
        rank = new int[A.length];
        for(int i = 0; i < A.length; i++){
            uf[i] = i;
        }
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                if(i == j) continue;
                else if(connected(A[i], A[j])){
                    union(i, j);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < A.length; i++){
            if(uf[i] == i) res++;
        }
        return res;
    }
    private int find(int a){
        if(a != uf[a]){
            uf[a] = find(uf[a]);
        }
        return uf[a];
    }
    private void union(int a, int b){
        int p = find(a);
        int q = find(b);
        if(q == p) return;
        if(rank[p] < rank[q]){
            uf[p] = q;
            rank[q] = Math.max(rank[q], rank[p] + 1);
        }else{
            uf[q] = p;
            rank[p] = Math.max(rank[p], rank[q] + 1);
        }
    }
    private boolean connected(String a, String b){
        if(a.equals(b)) return true;
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int diff = 0;
        for(int i = 0; i < arrA.length; i++){
            if(arrA[i] != arrB[i]) diff++;
            if(diff > 2) return false;
        }
        return diff == 0 || diff == 2;
    }
}