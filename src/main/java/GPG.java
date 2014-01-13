package se.soy.gpg;

import java.util.List;
import java.util.ArrayList;

public class GPG {
  // FIXME Remove when done
  static<T> void println(T arg) { System.out.println(arg); }

  public static void main(String[] args) {
    println("main");
    GPG.encrypt().armor().sign().recipient("0xrecipient").output();
    /*
    GPG.decrypt().armor().local-user("0xlocaluser").output("/tmp/a-file");
    GPG.sign().armor().();
    */
  }

  private List<String> command = new ArrayList<String>();
  private static GPG gpg = null;

  public void output() {
    println("Command: " + command);
    println("----------");
  }

  public static GPG encrypt() {
    gpg = (null == gpg) ? new GPG() : gpg;
    gpg.command.add("--encrypt");
    return gpg;
  }

  public static GPG sign() {
    gpg = (null == gpg) ? new GPG() : gpg;
    gpg.command.add("--sign");
    return gpg;
  }

  public GPG armor() {
    command.add("--armor");
    return this;
  }

  // TODO: Add recipients(List<String> recipients)
  public GPG recipient(String recipient) {
    command.add("--recipient " + recipient);
    return this;
  }
}
