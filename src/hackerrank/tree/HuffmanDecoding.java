package hackerrank.tree;
import java.util.*;

abstract class NodeT implements Comparable<NodeT> {

    public  int frequency; // the frequency of this tree
    public  char data;
    public NodeT left, right;
    public NodeT(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(NodeT tree) {
        return frequency - tree.frequency;
    }

}

class HuffmanLeaf extends NodeT {

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }

}

class HuffmanNodeT extends NodeT {

    public HuffmanNodeT(NodeT l, NodeT r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*
	class NodeT
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  NodeT left, right;

*/

    void decode(String s, NodeT root) {
        NodeT temp = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0')temp = temp.left;
            else temp = temp.right;
            if(temp.left == null && temp.right == null){
                HuffmanLeaf leaf = (HuffmanLeaf) temp;
                System.out.print(leaf.data);
                temp = root;
            }
        }

    }


}


public class HuffmanDecoding {

    // input is an array of frequencies, indexed by character code

    public static NodeT buildTree(int[] charFreqs) {

        PriorityQueue<NodeT> trees = new PriorityQueue<NodeT>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            NodeT a = trees.poll();
            NodeT b = trees.poll();

            // put into new nodeT and re-insert into queue
            trees.offer(new HuffmanNodeT(a, b));
        }
        return trees.poll();
    }

    public static Map<Character,String> mapA=new HashMap<Character ,String>();

    public static void printCodes(NodeT tree, StringBuffer prefix) {
        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data,prefix.toString());

        } else if (tree instanceof HuffmanNodeT) {
            HuffmanNodeT nodeT = (HuffmanNodeT)tree;

            // traverse left
            prefix.append('0');
            printCodes(nodeT.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(nodeT.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String test= input.next();

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        NodeT tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for(int i = 0; i < test.length(); i++) {

            char c = test.charAt(i);
            s.append(mapA.get(c));

        }

        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s.toString(),tree);

    }
}
