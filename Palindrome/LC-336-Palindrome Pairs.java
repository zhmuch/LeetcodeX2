
public class Solution {

    /**
     * Naive
     */
    public List<List<Integer>> palindromePairs(String[] words) {
      Map<String, Integer> index = new HashMap<>();
      Map<String, Integer> revIndex = new HashMap<>();
      String[] revWords = new String[words.length];
      for (int i = 0; i < words.length; ++i) {
          String s = words[i];
          String r = new StringBuilder(s).reverse().toString();
          index.put(s, i);
          revIndex.put(r, i);
          revWords[i] = r;
      }
      List<List<Integer>> result = new ArrayList<>();
      result.addAll(findPairs(words, revWords, revIndex, false));
      result.addAll(findPairs(revWords, words, index, true));
      return result;
  }

  private static List<List<Integer>> findPairs(String[] words, String[] revWords, Map<String, Integer> revIndex, boolean reverse) {
      List<List<Integer>> result = new ArrayList<>();
      for (int i = 0; i < words.length; ++i) {
          String s = words[i];
          for (int k = reverse ? 1 : 0; k <= s.length(); ++k) { // check suffixes, <= because we allow empty words
              Integer j = revIndex.get(s.substring(k));
              if (j != null && j != i) { // reversed suffix is present in the words list
                  String prefix = s.substring(0, k); // check whether the prefix is a palindrome
                  String revPrefix = revWords[i].substring(s.length() - k);
                  if (prefix.equals(revPrefix)) {
                      result.add(reverse ? Arrays.asList(i, j) : Arrays.asList(j, i));
                  }
              }
          }
      }
      return result;
  }
}
