/**
 * A Huffman Encoder interface
 * @author Jeremy Griffith
 */
public interface HuffmanList {
  
  public CharNode getHead();
  public void setHead(CharNode head);
  public int length();
  public boolean isEmpty();
  public boolean contains(char character);
  public void addToFront(char element);
  public void huffman_coder(String input_file, String output_file);
  
}