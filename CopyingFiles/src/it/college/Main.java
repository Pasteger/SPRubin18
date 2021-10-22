package it.college;

/*
Добиваясь параллельности и точности подсчёта времени выполнения, я, кажется, немного извратил код.
Время выполнения последовательным копированием, в среднем, 7 миллисекунд, параллельным - 3 миллисекунды.
*/

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //Замеривание времени последовательного копирования
        long start = System.currentTimeMillis();
        sequentialCopying(); //Метод последовательного копирования
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Файлы успешно скопированы!\nЗатрачено времени: " + elapsed + " миллисекунд");

        //Замеривание времени параллельного копирования
        long start_ = System.currentTimeMillis();
        parallelCopying(); //параллельное копирование
        long finish_ = System.currentTimeMillis();
        long elapsed_ = finish_ - start_;
        System.out.println("Файлы успешно скопированы!\nЗатрачено времени: " + elapsed_ + " миллисекунд");
    }


    //Метод последовательного копирования
    private static void sequentialCopying() throws IOException {
        copyFileUsingStream(
                new File("D:\\Programs\\JavaProject\\CopyingFiles\\copied_files\\copied_file0.txt"),
                new File("D:\\Programs\\JavaProject\\CopyingFiles\\pasted_files\\pasted_file0.txt")
        );
        copyFileUsingStream(
                new File("D:\\Programs\\JavaProject\\CopyingFiles\\copied_files\\copied_file1.txt"),
                new File("D:\\Programs\\JavaProject\\CopyingFiles\\pasted_files\\pasted_file1.txt")
        );
    }
    //Этот метод скопирован с, приложенного к заданию, источника информации
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }


    //метод параллельного копирования
    private static void parallelCopying(){
        File copiedFile0 = new File("D:\\Programs\\JavaProject\\CopyingFiles\\copied_files\\copied_file0.txt");
        File pastePath0 = new File("D:\\Programs\\JavaProject\\CopyingFiles\\pasted_files\\pasted_file0.txt");
        File copiedFile1 = new File("D:\\Programs\\JavaProject\\CopyingFiles\\copied_files\\copied_file1.txt");
        File pastePath1 = new File("D:\\Programs\\JavaProject\\CopyingFiles\\pasted_files\\pasted_file1.txt");

        CopyStream copyStream0 = new CopyStream(copiedFile0, pastePath0);
        CopyStream copyStream1 = new CopyStream(copiedFile1, pastePath1);
        //параллельность осуществляется при помощи потоков
        copyStream0.start();
        copyStream1.start();
    }
}
