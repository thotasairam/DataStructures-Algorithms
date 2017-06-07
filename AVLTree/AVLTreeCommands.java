/**
 * Sai Ram Thota
 * CWID 11573236
 * Data Structures Project
 *
 */
import java.io.*;
import java.util.*;

public class AVLTreeCommands {


    private static final String EXIT = "exit";
    private static final String HEIGHT = "height";
    private static final String FIND = "find";
    private static final String OCCURS = "occurs";
    private static final String COUNT = "count";
    private static final String REPLACE = "replace";


    private static AVLTreeMapping<String, AVLTreeNodeData <String>> tempTree;


    private static PrintWriter print = null;

    public static void main(String[] args) {

        if (args.length < 2) {
            exit("Usage: java AVLTreeCommands <input.txt> <results.txt>");
        }

        String inFile = args[0];
        String outFile = args[1];

        String fTxt = readFile(inFile);
        if (fTxt == null) {
            exit("Error: Could not find file input file with name: " + inFile);
        } else {

            System.out.println("Input file: " + inFile + " and Output file: " + outFile);
            System.out.println("Commands: find, occurs, count, replace");
            System.out.println("Usage: <command> <words> (for \"replace\" command : replace <word> <replacing word>)");
            System.out.println();

            print = openOutputStream(outFile);

            fTxt = fTxt.replaceAll("_", " ").toLowerCase();

            String[] words = fTxt.split("\\W+");

            tempTree = new AVLTreeMapping<>();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                tempTree.insert(word, new AVLTreeNodeData<>(word), i);
            }

            int uniqueCount = getUniqueWordsCount(words);
            System.out.println("It working! The given input file, "+ inFile +", has " + uniqueCount + " words.");
            System.out.println("AVLTree's height is " + tempTree.getHeight() + ".");
            System.out.println("Please enter instrucstion below as shown in the \"Usage:\" content above. ");
            System.out.println();



            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                String n = scanner.nextLine();
                executeCommand(n);
            }
        }
    }


    public static PrintWriter openOutputStream(String fileName) {
        try {
            File f = new File(fileName);
            PrintWriter writer = new PrintWriter(f);


            if (!f.exists()) {
                f.createNewFile();
            }
            return writer;

        } catch (IOException ex) {
            return null;
        }
    }


    public static String readFile(String filename) {
        try {
            InputStream t1 = new FileInputStream(new File(filename));
            BufferedReader t2 = new BufferedReader(new InputStreamReader(t1));
            StringBuilder print = new StringBuilder();
            String t3;
            while ((t3 = t2.readLine()) != null) {
                print.append(t3).append("\n");
            }
            t2.close();

            return print.toString();
        } catch (IOException ex) {
            return null;
        }
    }


    public static int getUniqueWordsCount(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        Collections.addAll(uniqueWords, words);
        return uniqueWords.size();
    }
    
    public static void exit(String message) {
        System.out.println(message);
        System.exit(0);
    }
    
    public static void executeCommand(String n) {

        StringBuilder output = new StringBuilder();
        String[] data = n.toLowerCase().split(" ");

        output.append(new Date()).append(" ~ ");

        if (data.length < 2) {
            if (data.length == 1) {
                if (data[0].equals(EXIT)) {
                    print.write("\n");
                    print.flush();
                    print.close();
                    System.out.println("Thank you! Hope to see you again. :D :)");
                    System.exit(0);
                } else if(data[0].equals(HEIGHT)) {
                    output.append("The AVLTree's height is ").append(tempTree.getHeight());
                } else {
                    output.append("Error: wrong usage of command. Use only 'find', 'occurs', 'count', 'replace' or 'height' for commands");
                }
            } else {
                output.append("Usage: <command> <words>");
            }
        } else {
            String command = data[0];
            String word = data[1];
            switch (command) {
                case FIND:
                    AVLTreeNodeComparison<String, AVLTreeNodeData<String>> nodeWrapper = tempTree.find(word);
                    if (nodeWrapper.getNode() == null) {
                        output.append("Sorry! Couldn't find the word '").append(word).append("'");
                    } else {
                        output.append("Found '").append(word).append("' with ").append(nodeWrapper.getComparison()).append(" searches.");
                    }
                    break;
                case OCCURS:
                    List<Integer> occurrences = tempTree.occurs(word);
                    if (occurrences == null) {
                        output.append("Sorry! There are no 'occur'rences for ").append(word);
                    } else {
                        output.append("Occur command has found your words occurences, which is ").append(word).append(": ").append(occurrences);
                    }
                    break;
                case COUNT:
                    int count = tempTree.count(word);
                    if (count == -1) {
                        output.append("Sorry! Couldn't find the 'count' of the word ").append(word);
                    } else {
                        output.append("The given word, '").append(word).append("', has count of ").append(count).append(".");
                    }

                    break;
                case REPLACE:
                    String word2 = data.length > 2 ? data[2] : null;
                    AVLTreeNode<String, AVLTreeNodeData<String>> node = tempTree.replace(word, word2);

                    if (node == null) {
                        output.append("Sorry! Couldn't 'find' or 'replace' the given word: '").append(word).append("'");
                    } else if (node.getKey() == null) {
                        output.append("Found the word: '").append(word).append("' and deleted it.");
                    } else {
                        output.append("Replaced the word, '").append(word).append("', with '").append(word2).append("'");
                    }

                    break;
                default:
                    output.append("Error: wrong usage of command. Use only 'find', 'occurs', 'count', 'replace' or 'height' for commands");
                    break;
            }
        }

        output.append("\n");
        System.out.println(output.toString());
        print.write(output.toString());
        print.flush();
    }
}
