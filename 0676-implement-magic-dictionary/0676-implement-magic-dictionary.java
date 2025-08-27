class MagicDictionary {

    public TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();  
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode node = root; // reset for each word
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }
    }
    
    public boolean search(String searchWord) {
        return searchword(root, searchWord, 0, 0);
    }

    private boolean searchword(TrieNode root, String searchWord, int count, int index) {
        if (count > 1) {
            return false;
        }

        if (index == searchWord.length()) {
            return count == 1 && root.isEnd();
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (root.links[ch - 'a'] != null) {
                if (searchWord.charAt(index) == ch) {
                    if (searchword(root.links[ch - 'a'], searchWord, count, index + 1)) {
                        return true;
                    }
                } else {
                    if (searchword(root.links[ch - 'a'], searchWord, count + 1, index + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}