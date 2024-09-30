import java.util.Hashtable;
/**
* A Table holds a collection of strings, each of which has an
* associated FrequencyTable
*/
public class Table {
  protected Hashtable<String,FrequencyTable> hash;
  /** Construct an empty table */
  public Table() {
    hash = new Hashtable<String, FrequencyTable>();
  }

  /**
  * Updates the table as follows
  * If key already exists in the table, update its FrequencyTable
  * by adding value to it
  * Otherwise, create a FrequencyTable for key and add value to it
  * @param key is the desired k-letter sequence
  * @param value is the character to add to the FrequencyTable of key
  */
  public void add(String key, char value) {
    if(!hash.containsKey(key)){
      hash.put(key, new FrequencyTable());
    }
    hash.get(key).add(value);
  }

  /**
  * If key is in the table, return one of the characters from
  * its FrequencyTable with probability equal to its relative frequency
  * Otherwise, determine a reasonable value to return
  * @param key is the k-letter sequence whose frequencies we want to use
  * @return a character selected from the corresponding FrequencyTable
  */
  public char choose(String key) {
    if(hash.containsKey(key)){
      return hash.get(key).choose();
    }
    return ' ';
  }

  /** Produce a string representation of the Table 
  * @return a String representing this Table
  */
  public String toString() {
    String str = "";
    for(String i : hash.keySet()){
      str += i + " hastable:" + hash.get(i).toString();
    }
    return str;
  }

  /**
   * Main method
   * @param args
   */
  public static void main(String[] args) {
    Table table = new Table();
    table.add("a", 'h');
    System.out.println(table.toString());
  }

}
