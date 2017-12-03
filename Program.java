package pkg;
import java.io.File;
import java.io.FilenameFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class Program {

 public static void main(String[] args) throws IOException {
  //
  File fd = (args.length < 1) ?
   new File(".") : new File(args[0]);
  File[] files;
  FilenameFilter xmlExtFilter = new FilenameFilter() {
   public boolean accept(File dir, String name) {
    if (new File(dir + "/" + name).isFile() &&
     name.toLowerCase().endsWith(".xml"))
     return true;
    return false;
   }
  };
  files = fd.listFiles(xmlExtFilter);
  //
  if (files == null) {
   System.out.println(fd + "\n: такой директории не существует");
   System.exit(2);
  }
  for (File file: files)
   System.out.println(file);
  //
  String[] noteTagsEn = { "to", "from", "heading" };
  StringBuilder[] enTagVals = new StringBuilder[noteTagsEn.length];
  for (int i = 0; i < noteTagsEn.length; i++)
   enTagVals[i] = new StringBuilder();

  for (File file: files) {
   String outStr = null;
   try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();
    while (line != null) {
     sb.append(line);
     line = br.readLine();
    }
    outStr = sb.toString();
   } catch (IOException ioe) {
    System.out.println(file + "\n: ошибка доступа, файл не будет обработан");
    ioe.printStackTrace();
   }

   StringTokenizer st = new StringTokenizer(outStr, "<>");
   String v = readNextTagValue(st, "?xml version=\"1.0\"?");
   while (v != null) {
    v = readNextTagValue(st, "note");
    if (v != null)
     for (int i = 0; i < noteTagsEn.length; i++) {
      v = readNextTagValue(st, noteTagsEn[i]);
      if (v != null)
       enTagVals[i].append(v + "\r\n");
     }
   }
  }
  //
  try (PrintWriter out = new PrintWriter("out.txt")) {
   out.println("Список отправителей:");
   out.println(enTagVals[1]);
   out.println("Список получателей:");
   out.println(enTagVals[0]);
   out.println("Заголовки:");
   out.println(enTagVals[2]);
  } catch (IOException ioe) {
   System.out.println("файл ответа не может быть создан");
   ioe.printStackTrace();
  }
 }

 private static String readNextTagValue(StringTokenizer st, String tag) {
  try {
   while (true) {
    if (st.nextToken().contains(tag)) {
     String v = st.nextToken();
     //System.out.println("<" + tag + ">" + v + "<...");
     return v;
    }
   }
  } catch (Exception nsee) {
   nsee.printStackTrace();
  }
  return null;
 }
}