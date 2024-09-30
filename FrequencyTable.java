import java.util.Hashtable;
import java.util.Random;

/**
 * A FrequencyTable stores a set of characters each of which has
 * an associated integer frequency
 */
public class FrequencyTable {
  protected Hashtable<Character, Integer> hash;
  /** Construct an empty FrequencyTable */
  public FrequencyTable() {
    hash = new Hashtable<Character, Integer>();
  }

  /** add(char ch)
   * If ch is in the FrequencyTable, increment its associated frequency
   * Otherwise add ch to FrequencyTable with frequency 1
   * @param ch is the String to add to the FrequencyTable
   */
  public void add(char ch) {
    if(!hash.containsKey(ch)){
        hash.put(ch,1);
    }
    else{
      hash.put(ch, hash.get(ch) + 1);
    }  
  }

  /** Selects a character from this FrequencyTable with probabality equal to its relative frequency.
   * @return a character from the FrequencyTable
   */
  public char choose() {
    int sum = 0;
    for(Integer i : hash.values()){
      sum+= i;
    }
    Random r = new Random();
    int rando = r.nextInt(sum) + 1;
    int build = 0;
    char k = ' ';
    for(Character i : hash.keySet()){
      if(rando > build && rando <= build + hash.get(i)){
          k = i;
          break;
      }
      build += hash.get(i);
    }
    return k;
  }

  /** Produce a string representation of the FrequencyTable 
   * @return a String representing the FrequencyTable
   */
  public String toString() {
    String str = "";
    for(Character i : hash.keySet()){
      str += i + ": " + hash.get(i) +  "\n";
    }
    return str;
  }
  
  /**
   * Main Method
   * @param args
   */
  public static void main(String[] args) {
    FrequencyTable ft = new FrequencyTable();
    ft.add('a');
    ft.add('a');
    ft.add('a');
    ft.add('e');
    ft.add('e');
    System.out.println(ft.choose());
    System.out.println(ft.toString());
  }
}