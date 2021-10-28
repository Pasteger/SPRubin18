package it.college;

//Поток для параллельного копирования файлов с использованием NIO

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class CopyStream extends Thread {

    private final String copiedFilePathString;
    private final String pastedFilePathString;

    CopyStream(String copiedFilePath, String pastedFilePath) {
        this.copiedFilePathString = copiedFilePath;
        this.pastedFilePathString = pastedFilePath;
    }

    @Override
    public void run() {
        Path copiedFilePath = Paths.get(URI.create(copiedFilePathString));
        Path pastedFilePath = Paths.get(URI.create(pastedFilePathString));
        try {
            Files.copy(copiedFilePath, pastedFilePath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
