package com.mixer.trees.problems1;

import java.util.Scanner;

public class Trie {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            this.children = new Node[26];
            for(int i=0; i<26; i++) {
                this.children[i] = null;
            }
            this.eow = false;
        }
    }

    static Node root = new Node();

    private static void insertNode(String word) {
        Node currentNode = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(currentNode.children[idx] == null) {
                //create a new node
                currentNode.children[idx] = new Node();
            }

            //check for eow
            if(i == word.length()-1) {
                currentNode.children[idx].eow = true;
            }

            currentNode = currentNode.children[idx];

        }
    }

    private static boolean search(String word) {
        Node currentNode = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';

            if(currentNode.children[idx] == null) {
                return false;
            }

            if(i == word.length()-1 && !currentNode.children[idx].eow ) {
                return false;
            }

            currentNode = currentNode.children[idx];
        }

        return true;
    }


    private static boolean wordBreakSearch(String fullString) {
        if(fullString.length() == 0) {
            return true;
        }

        for(int i=1; i<=fullString.length(); i++) {
            String fp = fullString.substring(0,i);
            String sp = fullString.substring(i);
            if(search(fp) && wordBreakSearch(sp)) {
                return true;
            }
        }

        return false;
    }

    private static boolean startsWith(String prefix) {
        Node currentNode = root;
        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if(currentNode.children[idx] == null) {
                return false;
            }

            currentNode = currentNode.children[idx];

        }
        return false;
    }

    private static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }

    static String ans = "";
    private static void longestWordWithAllPrefixes(Node root, StringBuilder temp) {
        if(root == null)
            return;

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.children[i].eow) {
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWordWithAllPrefixes(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


/*         INSERT INTO TRIE

        System.out.println("Enter words to insert in trie : ");
        String[] wordsToInsert = sc.nextLine().split(",");
        for(String word : wordsToInsert) {
            insertNode(word.trim());
        }
*/



/*         SEARCH INTO TRIE

        System.out.println(search("word"));
        System.out.println(search("there"));
        System.out.println(search("thereee"));
        System.out.println(search("an"));
        System.out.println(search("and"));
*/
        //i,like,sung,sam,the,samsung



/*         WORD BREAK SEARCH INTO TRIE

        System.out.println("break1: " + wordBreakSearch("ilikesamsung"));
*/



/*         FIND UNIQUE SUBSTRING IN A STRING

        System.out.println("Enter string for counting unique substring. ");
        String str = sc.nextLine();

        //find all suffix
        for(int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            System.out.println(suffix);
            //insert suffix in trie
            insertNode(suffix);
        }

        System.out.println(countNodes(root) + " is the total count of unique substrings");

 */


/*      LONGEST WORD WITH ALL PREFIXES  */

        System.out.println("Enter words to insert in trie : ");
        String[] wordsToInsert = sc.nextLine().split(",");
        for(String word : wordsToInsert) {
            insertNode(word.trim());
        }

        longestWordWithAllPrefixes(root, new StringBuilder());

        System.out.println("Longest word with all prefixes: " + ans);

    }
}
