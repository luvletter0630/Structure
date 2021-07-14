package Liwj.study.Leecode.Trie;

/**
 * Created by Administrator on 2021/5/16.
 */
public class Trie {
    /**
     * Initialize your data structure here.
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));

    }

    private Trie[] Child;
    private boolean isend;

    public Trie() {
        Child = new Trie[26];
        isend = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            if (trie.Child[word.charAt(i) - 'a'] == null) {
                trie.Child[word.charAt(i) - 'a'] = new Trie();
            }
            trie = trie.Child[word.charAt(i) - 'a'];
        }
        trie.isend = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            if (trie.Child[word.charAt(i) - 'a'] != null) {
                trie = trie.Child[word.charAt(i) - 'a'];
            } else {
                trie = null;
                break;
            }
        }

        return trie != null && trie.isend == true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (trie.Child[prefix.charAt(i) - 'a'] != null) {
                trie = trie.Child[prefix.charAt(i) - 'a'];
                if (trie == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
