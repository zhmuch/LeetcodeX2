public class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length < 1)
            return false;
        
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            int tmp = countHead(data[i]);
            switch (tmp) {
                case -1: 
                    return false;
                case 4:  
                    count--;
                    if (count < 0)
                        return false;
                    break;
                default:
                    if (count != 0)
                        return false;
                    count = tmp;
            }
        }
        
        return count == 0;
    }
    
    /**
     * 0, 1, 2, 3 means number of following characters;
     * 4 means followee;
     * -1 means not valid;
     */
    private int countHead(int a) {
        int count = 0, offset = 7;
        
        while ((a & (1 << offset)) >>> offset == 1) {
            if (count > 4)
                return -1;
            count++;
            offset--;
        }
        
        if (count == 1)
            return 4;
        else if (count == 0)
            return count;
        else
            return count - 1;
    }
}
