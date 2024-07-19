class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return func2(func1(x1, x2), func1(x3, x4));
    }
    
    public boolean func1(boolean x, boolean y) {
        if (!x && !y) return false;
        return true;
    }
    
    public boolean func2(boolean x, boolean y) {
        if (x && y) return true;
        return false;
    }
}