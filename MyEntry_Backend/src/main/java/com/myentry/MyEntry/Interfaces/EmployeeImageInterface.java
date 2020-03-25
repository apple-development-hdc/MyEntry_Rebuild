package com.myentry.MyEntry.Interfaces;


import java.awt.*;
import java.awt.image.*;
import java.util.Vector;

public interface EmployeeImageInterface extends RenderedImage {

    @Override
    Vector<RenderedImage> getSources();

    @Override
    Object getProperty(String name);

    @Override
    String[] getPropertyNames();

    @Override
    ColorModel getColorModel();

    @Override
    SampleModel getSampleModel();

    @Override
    Raster getData();

    @Override
    Raster getData(Rectangle rect);

    @Override
    WritableRaster copyData(WritableRaster raster);
}
