package ua.com.mdictionary.core.view.utils;

import java.io.File;
import java.io.FileFilter;

public class ImageFileFilter implements FileFilter {
    private final String[] okFileExtensions = new String[]{"jpg", "png", "gif", "jpeg", "ico", "tiff", "bmp"};
    private File file;

    public ImageFileFilter(File newFile) {
        this.file = newFile;
    }

    public boolean accept(File file) {
        for (String extension : okFileExtensions) {
            if (file.getName().toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}