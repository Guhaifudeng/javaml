package net.sf.javaml.test;
import java.io.File;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.DatasetLoader;

/*
 * TestDatasetLoader.java 
 * -----------------------
 * Copyright (C) 2005-2006  Thomas Abeel
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 * Author: Thomas Abeel
 * Created on: 17-jan-2007 - 11:39:12
 */

public class TestDatasetLoader {

    public static void main(String[]args)throws Exception{
        Dataset data=DatasetLoader.loadDataset(new File("iris.data"),4);
        System.out.println(data);
    }
}
