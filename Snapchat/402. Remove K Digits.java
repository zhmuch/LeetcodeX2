public class Solution {
    public String removeKdigits(String num, int k) {

        StringBuilder sb = new StringBuilder(num);

        //  mode1, delete as much '0' as possible
        int idx = 0, count = 0;
        while(count <= k && idx < sb.length()) {
            if (sb.charAt(idx) != '0') {
                idx++;
                count++;
            } else {
                k -= count;
                sb.delete(0, count);
                
                while(sb.length() > 0 && sb.charAt(0) == '0')
                    sb.deleteCharAt(0);
                
                idx = count = 0;
            }
        }

        if (sb.length() == 0)
            return "0";
        
        //  mode2, greedy
        for(int i = 0; i < k; i++) {
            int id = 0;
            
            while(id < sb.length() - 1 && sb.charAt(id) <= sb.charAt(id + 1))
                id++;
            
            sb.deleteCharAt(id);
        }
        
        if (sb.length() == 0)
            return "0";
            
        return sb.toString();
    }
}
