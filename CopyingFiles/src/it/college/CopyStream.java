package it.college;

//Поток для параллельного копирования файлов

import java.io.*;

public class CopyStream extends Thread {

    private final File copiedFile;
    private final File pastePath;

    CopyStream(File copiedFile, File pastePath) {
        this.copiedFile = copiedFile;
        this.pastePath = pastePath;
    }

    @Override
    public void run() {
        try {
            copyFileUsingStream(copiedFile, pastePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Этот метод скопирован с, приложенного к заданию, источника информации
    protected static void copyFileUsingStream(File source, File destination) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(source);
                OutputStream outputStream = new FileOutputStream(destination)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
    }
}
