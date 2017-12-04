package pkg;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Program {

 static byte deep;

 public static void main(String[] args) throws IOException {
  //
  File fd = (args.length < 1) ?
   new File(".") : new File(args[0]);
  File[] files;
  files = fd.listFiles();
  //
  if (files == null) {
   System.out.println(fd + "\n: такой директории не существует");
   System.exit(2);
  }
  //
  StringBuilder outStr = new StringBuilder("");
  outStr.append("<?xml version=\"1.0\"?>\r\n");
  deep = 1;
  rScan(fd, outStr);
  //
  System.out.println(outStr);
  try (PrintWriter out = new PrintWriter("dir.xml")) {
   out.println(outStr);
  } catch (IOException ioe) {
   System.out.println("файл ответа не может быть создан");
   ioe.printStackTrace();
  }
 }

 private static void rScan(File fd, StringBuilder sb) {
  //static byte deep = 0;
  sb.append(String.format("%" + deep + "s<catalogname=\"%s\">\r\n", "", fd.getName()));
  deep++;
  File[] files;
  files = fd.listFiles();
  if (files != null)
   for (File file: files)
    if (file.isDirectory())
     rScan(file, sb);
    else
     sb.append(String.format("%" + deep + "s<file name=\"%s\">\r\n", "", file.getName()));
  deep--;
  sb.append(String.format("%" + deep + "s</catalog>\r\n", ""));
 }
}