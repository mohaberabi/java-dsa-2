package SegmentTree;

import java.util.Stack;

public class SegmentTreeBalancedBrackets {
    static class Pair {


        int open;
        int closed;


        public Pair() {

        }
    }

    String expression;


    int[] segmentTree;
    int n;


    int getLongestParanthasis(int qs, int qe) {
        return getLongestParanthesis(qs, qe, 0, n - 1, 0);
    }

    int getLongestParanthesis(int qStart, int qEnd, int start, int end, int index) {


        if (qStart > end || qEnd < start) {

            return 0;
        }
        if (qStart >= start && qEnd <= end) {
            return segmentTree[index];
        }
        int mid = (start + end) / 2;
        int left = getLongestParanthesis(qStart, qEnd, start, mid, 2 * index + 1);
        int right = getLongestParanthesis(qStart, qEnd, mid + 1, end, 2 * index + 2);

        return left + right;

    }

    public SegmentTreeBalancedBrackets(String ex) {
        n = ex.length();
        int size = n * 4;
        expression = ex;
        segmentTree = new int[size];
        buildSegmentTree(0, n - 1, 0);
    }


    void printTree() {
        for (int x : segmentTree) {
            System.out.print(x + " ");
        }
    }

    int buildSegmentTree(int start, int end, int index) {

        if (start == end) {
            segmentTree[index] += isOpen(expression.charAt(start)) ? 1 : 0;
            return segmentTree[index];
        }


        int mid = (start + end) / 2;

        int left = buildSegmentTree(start, mid, 2 * index + 1);
        int right = buildSegmentTree(mid + 1, end, 2 * index + 2);


        segmentTree[index] = left + right;
        return segmentTree[index];
    }

    boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }


    public static void main(String[] args) {
        String ex = "())(())(())(";
        SegmentTreeBalancedBrackets tree = new SegmentTreeBalancedBrackets(ex);
//        tree.printTree();
        int longest = tree.getLongestParanthasis(0, 11);
        System.out.println(longest);
    }

    //{ Driver Code Starts
//Initial Template for Java

    /*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
    class GFG {
        public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
            long t=sc.nextInt();
            while(t-->0)
            {
                sc.nextLine();
                int query;

                String line[]=sc.nextLine().split(" ");

                String str=line[0];
                query=Integer.parseInt(line[1]);
                int n=str.length();
                Node st[]=constructST(str, n);

                int startIndex,endIndex;
                while(query-->0)
                {
                    startIndex=sc.nextInt();
                    endIndex=sc.nextInt();
                    System.out.println(new Solution().getLongestSequence(st, str, startIndex, endIndex, n));
                }


            }
        }

        public static int getMid(int s,int e)
        {
            return s + (e - s) / 2;
        }

        public static Node merge(Node leftChild, Node rightChild) {
            Node parentNode=new Node();
            int minMatched = Math.min(leftChild.open, rightChild.closed);
            parentNode.pairs = leftChild.pairs + rightChild.pairs + minMatched;
            parentNode.open = leftChild.open + rightChild.open - minMatched;
            parentNode.closed = leftChild.closed + rightChild.closed - minMatched;
            return parentNode;
        }


        public static void constructSTUtil(String str, int ss, int se, Node[]st, int si)
        {
            st[si]=new Node();
            if (ss == se) {
                st[si].pairs = 0;
                if (str.charAt(ss) == '(')
                    st[si].open = 1;
                else
                    st[si].closed = 1;

                return;
            }

            int mid = getMid(ss, se);
            constructSTUtil(str, ss, mid, st, si * 2 + 1);
            constructSTUtil(str, mid + 1, se, st, si * 2 + 2);

            st[si] = merge(st[si * 2 + 1], st[si * 2 + 2]);

        }

        public static Node [] constructST(String str, int n)
        {
            int x=(int) Math.ceil(Math.log(n)/Math.log(2));
            int max_size = 2 * (int)Math.pow(2, x) - 1;
            Node st[]=new Node[max_size];
            constructSTUtil(str, 0, n - 1, st, 0);

            return st;
        }
    }
    class Node {
        public int pairs;
        public int open;   // unused
        public int closed; // unused

        public Node() { pairs = open = closed = 0; }
    };

// } Driver Code Ends


//User function Template for Java



// str : given string
// n : length of the string
// qs and qe are L and R respectively
// st : segment tree of the given string of Node type
// return the maximum length of correct bracket subsequence of the sequence.

    class Solution
    {
        //Function to returns the maximum length of correct bracket subsequence
        //between starting and ending indexes.
        public static Node merge(Node leftChild, Node rightChild)
        {
            Node parentNode=new Node();
            int minMatched = Math.min(leftChild.open, rightChild.closed);
            parentNode.pairs = leftChild.pairs + rightChild.pairs + minMatched;
            parentNode.open = leftChild.open + rightChild.open - minMatched;
            parentNode.closed = leftChild.closed + rightChild.closed - minMatched;
            return parentNode;
        }
        public static int getMid(int s,int e)
        {
            return s + (e - s) / 2;
        }

        //recursive function to get the desired Longest Sequence.
        public static Node getLongestSequenceUtil(Node[] st, int ss, int se, int qs, int qe, int si)
        {
            //if segment of this node is outside given range, we return null node.
            if (ss > qe || se < qs) {
                return new Node();
            }

            //if segment of this node is part of given range then we return st[si].
            if (ss >= qs && se <= qe) {
                return st[si];
            }

            //if a part of this segment overlaps with the given range, we call
            //the function recursively for the children nodes.
            int mid = getMid(ss, se);
            Node left = getLongestSequenceUtil(st, ss, mid, qs, qe, si * 2 + 1);
            Node right=getLongestSequenceUtil(st, mid + 1, se, qs, qe, si * 2 + 2);

            //merging left and right subtree query results.
            Node res = merge(left, right);
            return res;
        }

        //Function to returns the maximum length of correct bracket subsequence
        //between starting and ending indexes.
        public static int getLongestSequence(Node[] st, String str, int qs, int qe, int n)
        {
            Node res = getLongestSequenceUtil(st, 0, n - 1, qs, qe, 0);

            //since we are storing numbers pairs and have to return maximum
            //length hence we multiply no of pairs with 2.
            return 2 * res.pairs;
        }
    }

}
