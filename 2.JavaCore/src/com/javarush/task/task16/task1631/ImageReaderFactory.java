package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageTypes;

public class ImageReaderFactory {
    public static com.javarush.task.task16.task1631.common.ImageReader getImageReader(ImageTypes image) {
        try {
            switch (image) {
                case BMP:
                    return new com.javarush.task.task16.task1631.common.BmpReader();
                case JPG:
                    return new com.javarush.task.task16.task1631.common.JpgReader();
                case PNG:
                    return new com.javarush.task.task16.task1631.common.PngReader();
            }
        }
        catch(Exception e) {}

        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
