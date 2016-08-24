import java.io.Console;
import java.io.PrintStream;

@SuppressWarnings("unused")
class Authenticator
{
  public static char[] key;

  public static void main(String[] paramArrayOfString)
  {
    key = new char[10];
    key[0] = 'H';
    key[1] = 'l';
    key[2] = 'r';
    key[3] = 'n';
    key[4] = 'o';
    key[5] = 'k';
    key[6] = 'R';
    key[7] = 'r';
    key[8] = 'h';
    key[9] = 'C';
    Console localConsole = System.console();
    String str = "";
    while (!str.equals("ThisIsth3mag1calString5502"))
      str = localConsole.readLine("Enter password:", new Object[0]);
    for (int i = 0; i < key.length; i++)
      System.out.print(key[i]);
    System.out.println("");
  }
}