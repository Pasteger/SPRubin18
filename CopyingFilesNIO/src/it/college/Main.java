package it.college;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        //Замеривание времени последовательного копирования
        long start = System.currentTimeMillis();
        sequentialCopying(); //Метод последовательного копирования
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Метод завершил работу!\nЗатрачено времени: " + elapsed + " миллисекунд");

        //Замеривание времени параллельного копирования
        long start_ = System.currentTimeMillis();
        parallelCopying(); //параллельное копирование
        long finish_ = System.currentTimeMillis();
        long elapsed_ = finish_ - start_;
        System.out.println("Метод завершил работу!\nЗатрачено времени: " + elapsed_ + " миллисекунд");
    }

    //Метод последовательного копирования файлов
    private static void sequentialCopying() throws IOException {
        Path copiedFilePath = Paths.get(URI.create("file:///D:/Programs/JavaProject/CopyingFilesNIO/copied_files/copied_file0.txt"));
        Path pastedFilePath = Paths.get(URI.create("file:///D:/Programs/JavaProject/CopyingFilesNIO/pasted_files/pasted_file0.txt"));
        Files.copy(copiedFilePath, pastedFilePath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);

        copiedFilePath = Paths.get(URI.create("file:///D:/Programs/JavaProject/CopyingFilesNIO/copied_files/copied_file1.txt"));
        pastedFilePath = Paths.get(URI.create("file:///D:/Programs/JavaProject/CopyingFilesNIO/pasted_files/pasted_file1.txt"));
        Files.copy(copiedFilePath, pastedFilePath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
    }

    //метод параллельного копирования файлов
    private static void parallelCopying() throws InterruptedException {
        String copiedFile0 = "file:///D:/Programs/JavaProject/CopyingFilesNIO/copied_files/copied_file0.txt";
        String pastePath0 = "file:///D:/Programs/JavaProject/CopyingFilesNIO/pasted_files/pasted_file0.txt";

        String copiedFile1 = "file:///D:/Programs/JavaProject/CopyingFilesNIO/copied_files/copied_file1.txt";
        String pastePath1 = "file:///D:/Programs/JavaProject/CopyingFilesNIO/pasted_files/pasted_file1.txt";

        CopyStream copyStream0 = new CopyStream(copiedFile0, pastePath0);
        CopyStream copyStream1 = new CopyStream(copiedFile1, pastePath1);

        //параллельность осуществляется при помощи потоков
        copyStream0.start();
        copyStream1.start();

        Thread.sleep(1);
    }
}
